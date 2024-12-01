package net.dispider.mixin;

import com.mojang.authlib.GameProfile;
import net.dispider.dispidermod.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.List;

@Mixin(Player.class)

public abstract class Mixing extends LivingEntity {


    protected Mixing(EntityType<? extends LivingEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    private final Abilities abilities = new Abilities();
    protected FoodData foodData = new FoodData();

    public Player self(){
        return (Player) (Object) this;
    }

    @Overwrite
    public void attack(Entity pTarget) {
        if (!net.minecraftforge.common.ForgeHooks.onPlayerAttackTarget(self(), pTarget)) return;
        if (pTarget.isAttackable()) {
            if (!pTarget.skipAttackInteraction(this)) {
                float f = this.isAutoSpinAttack() ? this.autoSpinAttackDmg : (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
                ItemStack itemstack = this.getWeaponItem();
                DamageSource damagesource = this.damageSources().playerAttack(self());
                float f1 = this.getEnchantedDamage(pTarget, f, damagesource) - f;
                float f2 = this.getAttackStrengthScale(0.5F);
                f *= 0.2F + f2 * f2 * 0.8F;
                f1 *= f2;
                this.attackStrengthTicker = 0;
                if (pTarget.getType().is(EntityTypeTags.REDIRECTABLE_PROJECTILE)
                        && pTarget instanceof Projectile projectile
                        && projectile.deflect(ProjectileDeflection.AIM_DEFLECT, this, this, true)) {
                    this.level().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.KatanaSlash.get(), this.getSoundSource());
                    return;
                }

                if (f > 0.0F || f1 > 0.0F) {
                    boolean flag4 = f2 > 0.9F;
                    boolean flag;
                    if (this.isSprinting() && flag4) {
                        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_KNOCKBACK, this.getSoundSource(), 1.0F, 1.0F);
                        flag = true;
                    } else {
                        flag = false;
                    }

                    f += itemstack.getItem().getAttackDamageBonus(pTarget, f, damagesource);
                    boolean flag1 = flag4
                            && this.fallDistance > 0.0F
                            && !this.onGround()
                            && !this.onClimbable()
                            && !this.isInWater()
                            && !this.hasEffect(MobEffects.BLINDNESS)
                            && !this.isPassenger()
                            && pTarget instanceof LivingEntity
                            && !this.isSprinting();
                    var hitResult = net.minecraftforge.common.ForgeHooks.getCriticalHit(self(), pTarget, flag1, flag1 ? 1.5F : 1.0F);
                    flag1 = hitResult != null;
                    if (flag1) {
                        f *= hitResult.getDamageModifier();
                    }

                    float f3 = f + f1;
                    boolean flag2 = false;
                    double d0 = (double)(this.walkDist - this.walkDistO);
                    if (flag4 && !flag1 && !flag && this.onGround() && d0 < (double)this.getSpeed()) {
                        ItemStack itemstack1 = this.getItemInHand(InteractionHand.MAIN_HAND);
                        if (itemstack.canPerformAction(net.minecraftforge.common.ToolActions.SWORD_SWEEP)) {
                            flag2 = true;
                        }
                    }

                    float f6 = 0.0F;
                    if (pTarget instanceof LivingEntity livingentity) {
                        f6 = livingentity.getHealth();
                    }

                    Vec3 vec3 = pTarget.getDeltaMovement();
                    boolean flag3 = pTarget.hurt(damagesource, f3);
                    if (flag3) {
                        float f4 = this.getKnockback(pTarget, damagesource) + (flag ? 1.0F : 0.0F);
                        if (f4 > 0.0F) {
                            if (pTarget instanceof LivingEntity livingentity1) {
                                livingentity1.knockback(
                                        (double)(f4 * 0.5F),
                                        (double) Mth.sin(this.getYRot() * (float) (Math.PI / 180.0)),
                                        (double)(-Mth.cos(this.getYRot() * (float) (Math.PI / 180.0)))
                                );
                            } else {
                                pTarget.push(
                                        (double)(-Mth.sin(this.getYRot() * (float) (Math.PI / 180.0)) * f4 * 0.5F),
                                        0.1,
                                        (double)(Mth.cos(this.getYRot() * (float) (Math.PI / 180.0)) * f4 * 0.5F)
                                );
                            }

                            this.setDeltaMovement(this.getDeltaMovement().multiply(0.6, 1.0, 0.6));
                            this.setSprinting(false);
                        }

                        if (flag2) {
                            float f7 = 1.0F + (float)this.getAttributeValue(Attributes.SWEEPING_DAMAGE_RATIO) * f;

                            for (LivingEntity livingentity2 : this.level().getEntitiesOfClass(LivingEntity.class, this.getItemInHand(InteractionHand.MAIN_HAND).getSweepHitBox(self(), pTarget))) {
                                if (livingentity2 != this
                                        && livingentity2 != pTarget
                                        && !this.isAlliedTo(livingentity2)
                                        && (!(livingentity2 instanceof ArmorStand) || !((ArmorStand)livingentity2).isMarker())
                                        && this.distanceToSqr(livingentity2) < 9.0) {
                                    float f5 = this.getEnchantedDamage(livingentity2, f7, damagesource) * f2;
                                    livingentity2.knockback(
                                            0.4F,
                                            (double)Mth.sin(this.getYRot() * (float) (Math.PI / 180.0)),
                                            (double)(-Mth.cos(this.getYRot() * (float) (Math.PI / 180.0)))
                                    );
                                    livingentity2.hurt(damagesource, f5);
                                    if (this.level() instanceof ServerLevel serverlevel) {
                                        EnchantmentHelper.doPostAttackEffects(serverlevel, livingentity2, damagesource);
                                    }
                                }
                            }

                            this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_SWEEP, this.getSoundSource(), 1.0F, 1.0F);
                            this.sweepAttack();
                        }

                        if (pTarget instanceof ServerPlayer && pTarget.hurtMarked) {
                            ((ServerPlayer)pTarget).connection.send(new ClientboundSetEntityMotionPacket(pTarget));
                            pTarget.hurtMarked = false;
                            pTarget.setDeltaMovement(vec3);
                        }

                        if (flag1) {
                            this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_CRIT, this.getSoundSource(), 1.0F, 1.0F);
                            this.crit(pTarget);
                        }

                        if (!flag1 && !flag2) {
                            if (flag4) {
                                this.level()
                                        .playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_STRONG, this.getSoundSource(), 1.0F, 1.0F);
                            } else {
                                this.level()
                                        .playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_WEAK, this.getSoundSource(), 1.0F, 1.0F);
                            }
                        }

                        if (f1 > 0.0F) {
                            this.magicCrit(pTarget);
                        }

                        this.setLastHurtMob(pTarget);
                        Entity entity = pTarget;
                        if (pTarget instanceof net.minecraftforge.entity.PartEntity<?> pe) {
                            entity = pe.getParent();
                        }

                        boolean flag5 = false;
                        if (this.level() instanceof ServerLevel serverlevel1) {
                            if (entity instanceof LivingEntity livingentity3) {
                                flag5 = itemstack.hurtEnemy(livingentity3, self());
                            }

                            EnchantmentHelper.doPostAttackEffects(serverlevel1, pTarget, damagesource);
                        }

                        if (!this.level().isClientSide && !itemstack.isEmpty() && entity instanceof LivingEntity) {
                            if (flag5) {
                                itemstack.postHurtEnemy((LivingEntity)entity, self());
                            }

                            if (itemstack.isEmpty()) {
                                if (itemstack == this.getMainHandItem()) {
                                    this.setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);
                                } else {
                                    this.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);
                                }
                            }
                        }

                        if (pTarget instanceof LivingEntity) {
                            float f8 = f6 - ((LivingEntity)pTarget).getHealth();
                            this.awardStat(Stats.DAMAGE_DEALT, Math.round(f8 * 10.0F));
                            if (this.level() instanceof ServerLevel && f8 > 2.0F) {
                                int i = (int)((double)f8 * 0.5);
                                ((ServerLevel)this.level())
                                        .sendParticles(ParticleTypes.DAMAGE_INDICATOR, pTarget.getX(), pTarget.getY(0.5), pTarget.getZ(), i, 0.1, 0.0, 0.1, 0.2);
                            }
                        }

                        this.causeFoodExhaustion(0.1F);
                    } else {
                        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_NODAMAGE, this.getSoundSource(), 1.0F, 1.0F);
                    }
                }
                this.attackStrengthTicker = 0; // FORGE: Moved from beginning of attack() so that getAttackStrengthScale() returns an accurate value during all attack events
            }
        }
    }

    public void awardStat(ResourceLocation pStat, int pIncrement) {
        this.awardStat(Stats.CUSTOM.get(pStat).getValue(), pIncrement);
    }
    protected float getEnchantedDamage(Entity pEntity, float pDamage, DamageSource pDamageSource) {
        return pDamage;
    }
    public void causeFoodExhaustion(float pExhaustion) {
        if (!this.abilities.invulnerable) {
            if (!this.level().isClientSide) {
                this.foodData.addExhaustion(pExhaustion);
            }
        }
    }
    public void magicCrit(Entity pEntityHit) {
    }
    @Override
    public boolean isSpectator() {
        return false;
    }
    public float getAttackStrengthScale(float pAdjustTicks) {
        return Mth.clamp(((float)this.attackStrengthTicker + pAdjustTicks) / this.getCurrentItemAttackStrengthDelay(), 0.0F, 1.0F);
    }
    public float getCurrentItemAttackStrengthDelay() {
        return (float)(1.0 / this.getAttributeValue(Attributes.ATTACK_SPEED) * 20.0);
    }
    public void crit(Entity pEntityHit) {
    }

    public void sweepAttack() {
        double d0 = (double)(-Mth.sin(this.getYRot() * (float) (Math.PI / 180.0)));
        double d1 = (double)Mth.cos(this.getYRot() * (float) (Math.PI / 180.0));
        if (this.level() instanceof ServerLevel) {
            ((ServerLevel)this.level()).sendParticles(ParticleTypes.SWEEP_ATTACK, this.getX() + d0, this.getY(0.5), this.getZ() + d1, 0, d0, 0.0, d1, 0.0);
        }
    }



}
