package net.dispider.dispidermod.entity.custom;

import net.dispider.dispidermod.entity.ModEntities;
import net.dispider.dispidermod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class SlimeProjectileEntity extends ThrowableItemProjectile {
    public SlimeProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public SlimeProjectileEntity(Level pLevel) {
        super(ModEntities.POKEBALL_PROJECTILE.get(),pLevel);
    }
    public SlimeProjectileEntity(LivingEntity livingEntity, Level pLevel) {
        super(ModEntities.POKEBALL_PROJECTILE.get(),livingEntity,pLevel);
    }



    @Override
    protected Item getDefaultItem() {
        return ModItems.SlimePokeball.get();
    }



    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            BlockPos blockPos = BlockPos.containing(pResult.getLocation());
            Slime skeleton= new Slime(EntityType.SLIME,level());
            skeleton.setPos(pResult.getLocation());



            level().addFreshEntity(skeleton);


            this.discard();
        }
    }
}
