package net.dispider.dispidermod.entity.custom.projectile;

import net.dispider.dispidermod.entity.ModEntities;
import net.dispider.dispidermod.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class PokeballProjectileEntity extends ThrowableItemProjectile {
    public PokeballProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

public PokeballProjectileEntity(Level pLevel) {
        super(ModEntities.POKEBALL_PROJECTILE.get(),pLevel);
    }
public PokeballProjectileEntity(LivingEntity livingEntity, Level pLevel) {
        super(ModEntities.POKEBALL_PROJECTILE.get(),livingEntity,pLevel);
    }



    @Override
    protected Item getDefaultItem() {
        return ModItems.Pokeball.get();
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if(!this.level().isClientSide()){

            if(!this.level().isClientSide()){
                pResult.getEntity().hurt(pResult.getEntity().damageSources().magic(),4f);
                if(pResult.getEntity() instanceof Skeleton skeleton){
                    level().getNearestPlayer(pResult.getEntity(),5000).addItem(new ItemStack (ModItems.SkeletonPokeball.get()));
                    this.discard();
                    pResult.getEntity().kill();
                }
                if(pResult.getEntity() instanceof Slime skeleton){
                    level().getNearestPlayer(pResult.getEntity(),5000).addItem(new ItemStack (ModItems.SlimePokeball.get()));
                    this.discard();
                    pResult.getEntity().kill();
                }
                if(pResult.getEntity() instanceof Zombie skeleton){
                    level().getNearestPlayer(pResult.getEntity(),5000).addItem(new ItemStack (ModItems.ZombiePokeball.get()));
                    this.discard();
                    pResult.getEntity().kill();
                }
                if(pResult.getEntity() instanceof Spider skeleton){
                    level().getNearestPlayer(pResult.getEntity(),5000).addItem(new ItemStack (ModItems.SpiderPokeball.get()));
                    this.discard();
                    pResult.getEntity().kill();
                }
                if(pResult.getEntity() instanceof Creeper skeleton){
                    level().getNearestPlayer(pResult.getEntity(),5000).addItem(new ItemStack (ModItems.CreeperPokeball.get()));
                    this.discard();
                    pResult.getEntity().kill();
                }

            }

        }
        super.onHitEntity(pResult);
    }
    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }
}
