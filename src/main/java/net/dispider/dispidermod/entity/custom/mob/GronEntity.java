package net.dispider.dispidermod.entity.custom.mob;

import net.dispider.dispidermod.entity.ModEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class GronEntity extends Animal {
    public GronEntity(EntityType<?> pEntityType, Level pLevel) {
        super((EntityType<? extends GronEntity>) pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0,new FloatGoal(this));

        this.goalSelector.addGoal(1,new BreedGoal(this,1.15D));
        this.goalSelector.addGoal(2,new TemptGoal(this,1.20D, Ingredient.of(Items.APPLE),false));
        this.goalSelector.addGoal(3,new FollowParentGoal(this,1.10D));
        this.goalSelector.addGoal(4,new WaterAvoidingRandomStrollGoal(this,1.10D));
        this.goalSelector.addGoal(5,new LookAtPlayerGoal(this, Player.class,5f));
        this.goalSelector.addGoal(6,new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(7, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(8, new OpenDoorGoal(this,true));
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Animal.createLivingAttributes().add(Attributes.MAX_HEALTH,(150D)).add(Attributes.MOVEMENT_SPEED,0.4f)
                .add(Attributes.ARMOR_TOUGHNESS,0.01f)
                .add(Attributes.FOLLOW_RANGE,240)
                .add(Attributes.ATTACK_KNOCKBACK,1f)
                .add(Attributes.ATTACK_DAMAGE,1f);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntities.GRON.get().create(pLevel);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(Items.APPLE);
    }
}
