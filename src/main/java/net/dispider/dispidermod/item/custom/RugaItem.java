package net.dispider.dispidermod.item.custom;

import net.dispider.dispidermod.Ruga;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.LongJumpToRandomPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.windcharge.WindCharge;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import static net.minecraft.world.entity.player.Player.*;

public class RugaItem extends Item implements ProjectileItem {
    private static final int COOLDOWN = 10;

    public RugaItem(Item.Properties p_333764_) {
        super(p_333764_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level p_333953_, Player p_328676_, InteractionHand p_332155_) {
        if (!p_333953_.isClientSide()) {
            Ruga windcharge = new Ruga(
                    p_328676_, p_333953_, p_328676_.position().x(), p_328676_.getEyePosition().y(), p_328676_.position().z()
            );
            windcharge.shootFromRotation(p_328676_, p_328676_.getXRot(), p_328676_.getYRot(), 0.0F, 1.5F, 1.0F);
            p_333953_.addFreshEntity(windcharge);
        }

        p_333953_.playSound(
                null,
                p_328676_.getX(),
                p_328676_.getY(),
                p_328676_.getZ(),
                SoundEvents.WITCH_DEATH,
                SoundSource.NEUTRAL,
                0.5F,
                0.4F / (p_333953_.getRandom().nextFloat() * 0.4F + 0.8F)
        );
        ItemStack itemstack = p_328676_.getItemInHand(p_332155_);
        p_328676_.getCooldowns().addCooldown(this, 10);
        p_328676_.awardStat(Stats.ITEM_USED.get(this));
        itemstack.hurtAndBreak(1,p_328676_,LivingEntity.getSlotForHand(p_332155_));
        return InteractionResultHolder.sidedSuccess(itemstack, p_333953_.isClientSide());
    }

    @Override
    public Projectile asProjectile(Level p_335187_, Position p_334268_, ItemStack p_330980_, Direction p_331337_) {
        RandomSource randomsource = p_335187_.getRandom();
        double d0 = randomsource.triangle((double)p_331337_.getStepX(), 0.11485000000000001);
        double d1 = randomsource.triangle((double)p_331337_.getStepY(), 0.11485000000000001);
        double d2 = randomsource.triangle((double)p_331337_.getStepZ(), 0.11485000000000001);
        Vec3 vec3 = new Vec3(d0, d1, d2);
        WindCharge ruga = new WindCharge(p_335187_, p_334268_.x(), p_334268_.y(), p_334268_.z(), vec3);
        ruga.setDeltaMovement(vec3);
        return ruga;
    }



    @Override
    public void shoot(Projectile p_331638_, double p_331384_, double p_329200_, double p_331035_, float p_335278_, float p_332729_) {
    }


}