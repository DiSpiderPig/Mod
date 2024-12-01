package net.dispider.dispidermod.item.custom;

import net.dispider.dispidermod.block.ModBlocks;
import net.dispider.dispidermod.effect.ModEffects;
import net.dispider.dispidermod.item.ModItems;
import net.dispider.dispidermod.item.RugaUsed;
import net.dispider.dispidermod.item.custom.BlackKatanaUse.*;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.entity.projectile.windcharge.AbstractWindCharge;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.SimpleExplosionDamageCalculator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;


public class BlackKatanaItem extends SwordItem {

    public static int i = 0;
    public static int k = 1;// Amplifier
    public static final int COOLDOWN = 20;




    public BlackKatanaItem(Tier pTier, Properties pProperties) {
        super(pTier, pProperties);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return true;
    }


    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();
        if(clickedBlock.equals(Blocks.CREEPER_HEAD)){
            level.setBlockAndUpdate(pContext.getClickedPos(),Blocks.AIR.defaultBlockState());
            pContext.getPlayer().addItem(new ItemStack(ModItems.Soul.get()));
        }
        if(clickedBlock.equals(Blocks.ZOMBIE_HEAD)){
            level.setBlockAndUpdate(pContext.getClickedPos(),Blocks.AIR.defaultBlockState());
            pContext.getPlayer().addItem(new ItemStack(ModItems.Soul.get()));
        }
        if(clickedBlock.equals(Blocks.END_PORTAL)){
            level.setBlockAndUpdate(pContext.getClickedPos(),Blocks.AIR.defaultBlockState());
            pContext.getPlayer().addItem(new ItemStack(ModItems.Soul.get()));
        }
        if(clickedBlock.equals(Blocks.SKELETON_SKULL)){
            level.setBlockAndUpdate(pContext.getClickedPos(),Blocks.AIR.defaultBlockState());
            pContext.getPlayer().addItem(new ItemStack(ModItems.Soul.get()));
        }
        if(clickedBlock.equals(Blocks.WITHER_SKELETON_SKULL)){
            level.setBlockAndUpdate(pContext.getClickedPos(),Blocks.AIR.defaultBlockState());
            pContext.getPlayer().addItem(new ItemStack(ModItems.Soul.get()));
        }
        if(clickedBlock.equals(Blocks.SLIME_BLOCK)){
     level.setBlockAndUpdate(pContext.getClickedPos(),Blocks.AIR.defaultBlockState());
            pContext.getPlayer().addItem(new ItemStack(ModItems.Soul.get()));
        }
        if(clickedBlock.equals(Blocks.CAULDRON)){
            level.setBlockAndUpdate(pContext.getClickedPos(),Blocks.AIR.defaultBlockState());
            pContext.getPlayer().addItem(new ItemStack(ModItems.Soul.get()));
        }
        return super.useOn(pContext);

    }

    @Override
    public void postHurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {

        Level level = pAttacker.level();

        BlockPos blockpos = new BlockPos(pTarget.getBlockX(),pTarget.getBlockY(),pTarget.getBlockZ()+1);

        if(!pTarget.isAlive()){
            if(pTarget instanceof Mob){
                Random rand = new Random();
                int rand1= rand.nextInt(4);
                switch (rand1){
                    case 1:
                        level.setBlockAndUpdate(blockpos,Blocks.ZOMBIE_HEAD.defaultBlockState());
                        break;
                    case 2:
                        level.setBlockAndUpdate(blockpos,Blocks.CREEPER_HEAD.defaultBlockState());
                        break;
                    case 3:
                        level.setBlockAndUpdate(blockpos,Blocks.SKELETON_SKULL.defaultBlockState());
                        break;
                    case 4:
                        level.setBlockAndUpdate(blockpos,Blocks.WITHER_SKELETON_SKULL.defaultBlockState());
                        break;
                }
            }


            if(pAttacker.hasEffect(MobEffects.DARKNESS) || (i ==0)){

                if(i < 5){
                    i++;
                }

            }
            else{
                i = 0;
            }
            pAttacker.hurt(pAttacker.damageSources().magic(),2f);
            pAttacker.addEffect(new MobEffectInstance(MobEffects.DARKNESS,1250),pAttacker);
        }

        super.postHurtEnemy(pStack, pTarget, pAttacker);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {



        if (!pLevel.isClientSide() && pPlayer.hasEffect(ModEffects.SOUL_EFFECT5.getHolder().get())) {
            BlackKatanaUse5 windcharge = new BlackKatanaUse5(
                    pPlayer, pLevel, pPlayer.position().x(), pPlayer.getEyePosition().y(), pPlayer.position().z()

            );
            pPlayer.heal(50f);
            pPlayer.removeEffect(MobEffects.DARKNESS);;
            windcharge.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(windcharge);pPlayer.removeAllEffects();
        }
        else if (!pLevel.isClientSide() && pPlayer.hasEffect(ModEffects.SOUL_EFFECT4.getHolder().get())) {
            BlackKatanaUse4 windcharge = new BlackKatanaUse4(
                    pPlayer, pLevel, pPlayer.position().x(), pPlayer.getEyePosition().y(), pPlayer.position().z()
            );pPlayer.heal(50f);
            pPlayer.removeEffect(MobEffects.DARKNESS);;
            windcharge.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(windcharge);pPlayer.removeAllEffects();
        }


            else if (!pLevel.isClientSide() && pPlayer.hasEffect(ModEffects.SOUL_EFFECT3.getHolder().get())) {
                BlackKatanaUse3 windcharge = new BlackKatanaUse3(
                        pPlayer, pLevel, pPlayer.position().x(), pPlayer.getEyePosition().y(), pPlayer.position().z()
                );pPlayer.heal(50f);
            pPlayer.removeEffect(MobEffects.DARKNESS);;
                windcharge.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
                pLevel.addFreshEntity(windcharge);pPlayer.removeAllEffects();
            }
        else if (!pLevel.isClientSide() && pPlayer.hasEffect(ModEffects.SOUL_EFFECT2.getHolder().get())) {
            pPlayer.addEffect(new MobEffectInstance(MobEffects.POISON,250),pPlayer);
            BlackKatanaUse2 windcharge = new BlackKatanaUse2(
                    pPlayer, pLevel, pPlayer.position().x(), pPlayer.getEyePosition().y(), pPlayer.position().z()
            );pPlayer.heal(50f);
            pPlayer.removeEffect(MobEffects.DARKNESS);;
            windcharge.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(windcharge);pPlayer.removeAllEffects();
        }

        else if (!pLevel.isClientSide() && pPlayer.hasEffect(ModEffects.SOUL_EFFECT.getHolder().get())) {
            BlackKatanaUse windcharge = new BlackKatanaUse(
                    pPlayer, pLevel, pPlayer.position().x(), pPlayer.getEyePosition().y(), pPlayer.position().z()
            );pPlayer.heal(50f);
            pPlayer.removeEffect(MobEffects.DARKNESS);;
            windcharge.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(windcharge);
            pPlayer.removeAllEffects();
        }


            pLevel.playSound(
                    null,
                    pPlayer.getX(),
                    pPlayer.getY(),
                    pPlayer.getZ(),
                    SoundEvents.END_PORTAL_SPAWN,
                    SoundSource.NEUTRAL,
                    0.5F,
                    0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F)
            );
           ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
            pPlayer.getCooldowns().addCooldown(this, COOLDOWN);

            pPlayer.awardStat(Stats.ITEM_USED.get(this));
            itemstack.hurtAndBreak(1, pPlayer, LivingEntity.getSlotForHand(pUsedHand));






        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }





    public static int getI(){
        return i;
    }


    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()){
            pTooltipComponents.add(Component.translatable("Kill to charge up your Special Power"));
        }
        else{
            pTooltipComponents.add(Component.translatable("You have "+getI()+" Kills"));
        }
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
