package net.dispider.dispidermod.entity.custom;

import net.dispider.dispidermod.entity.ModEntities;
import net.dispider.dispidermod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class DealerEntity extends Animal {
    public DealerEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public final AnimationState idleAnimation = new AnimationState();
    public int idleAnimationTimeout = 0;

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(ModItems.Money.get());
    }

    @Override
    public InteractionResult interactAt(Player pPlayer, Vec3 pVec, InteractionHand pHand) {

        if(pHand.equals(InteractionHand.MAIN_HAND) && level().isClientSide){
            pPlayer.displayClientMessage(Component.literal(("Whachu want?")),false);
            if(pPlayer.getItemInHand(pHand).is(Items.IRON_INGOT.asItem())){
                pPlayer.getItemInHand(pHand).shrink(1);
                pPlayer.drop(ModItems.VAPE.get().getDefaultInstance(),false);
            } else if(pPlayer.getItemInHand(pHand).is(Items.GOLD_INGOT.asItem())){
                pPlayer.getItemInHand(pHand).shrink(1);
                pPlayer.drop(ModItems.CRACK_COCAINE.get().getDefaultInstance(),false);
            }
            else{
                pPlayer.displayClientMessage(Component.literal("Its ehm, 1 iron for the vape and 1 gold for coke"),false);

            } return InteractionResult.SUCCESS;
        }
        else{
            return InteractionResult.SUCCESS;
        }

    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0,new FloatGoal(this));

        this.goalSelector.addGoal(1,new PanicGoal(this,1));

        this.goalSelector.addGoal(2,new WaterAvoidingRandomStrollGoal(this,1.0));
        this.goalSelector.addGoal(3,new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Animal.createLivingAttributes().add(Attributes.MAX_HEALTH,5D).add(Attributes.MOVEMENT_SPEED,0.25D).add(Attributes.FOLLOW_RANGE,240D);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntities.Dealer.get().create(pLevel);
    }
    private void setupAnimationStates(){
        if(this.idleAnimationTimeout<=0){
            this.idleAnimationTimeout = 360;
            this.idleAnimation.start(this.tickCount);
        }else{
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()){
            this.setupAnimationStates();
        }
    }
}
