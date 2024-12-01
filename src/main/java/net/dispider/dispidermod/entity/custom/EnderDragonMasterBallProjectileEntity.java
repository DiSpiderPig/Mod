package net.dispider.dispidermod.entity.custom;

import net.dispider.dispidermod.entity.ModEntities;
import net.dispider.dispidermod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class EnderDragonMasterBallProjectileEntity extends ThrowableItemProjectile {
    public EnderDragonMasterBallProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public EnderDragonMasterBallProjectileEntity(Level pLevel) {
        super(ModEntities.POKEBALL_PROJECTILE.get(),pLevel);
    }
    public EnderDragonMasterBallProjectileEntity(LivingEntity livingEntity, Level pLevel) {
        super(ModEntities.POKEBALL_PROJECTILE.get(),livingEntity,pLevel);
    }



    @Override
    protected Item getDefaultItem() {
        return ModItems.EnderDragonMasterball.get();
    }



    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            BlockPos blockPos = BlockPos.containing(pResult.getLocation());
            EnderDragon skeleton= new EnderDragon(EntityType.ENDER_DRAGON,level());
            skeleton.setPos(pResult.getLocation());



            level().addFreshEntity(skeleton);


            this.discard();
        }
    }
}
