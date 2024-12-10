package net.dispider.dispidermod.entity.custom.projectile;

import net.dispider.dispidermod.entity.ModEntities;
import net.dispider.dispidermod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class SkeletonPokeballProjectileEntity extends ThrowableItemProjectile {
    public SkeletonPokeballProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public SkeletonPokeballProjectileEntity(Level pLevel) {
        super(ModEntities.POKEBALL_PROJECTILE.get(),pLevel);
    }
    public SkeletonPokeballProjectileEntity(LivingEntity livingEntity, Level pLevel) {
        super(ModEntities.POKEBALL_PROJECTILE.get(),livingEntity,pLevel);
    }



    @Override
    protected Item getDefaultItem() {
        return ModItems.SkeletonPokeball.get();
    }



    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            BlockPos blockPos = BlockPos.containing(pResult.getLocation());
            Skeleton skeleton = new Skeleton(EntityType.SKELETON,level());
            skeleton.setItemInHand(InteractionHand.MAIN_HAND,new ItemStack(Items.BOW));
            skeleton.setPos(pResult.getLocation());



            level().addFreshEntity(skeleton);


            this.discard();
        }
    }
}
