package net.dispider.dispidermod.item.custom;

import net.dispider.dispidermod.effect.ModEffects;
import net.dispider.dispidermod.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties Spanakoruzo = new FoodProperties.Builder().nutrition(2).saturationModifier(0.25f).
            effect(new MobEffectInstance(MobEffects.HUNGER,25),0.50f).build();

    public static final FoodProperties Tomato = new FoodProperties.Builder().nutrition(2).saturationModifier(0.25f).build();

    public static final FoodProperties VAPE = new FoodProperties.Builder().nutrition(0).saturationModifier(0.2f).effect(new MobEffectInstance(
            ModEffects.CANCER_EFFECT.getHolder().get(),4000),0.20f).effect(new MobEffectInstance(MobEffects.LEVITATION,300),0.40f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,300),0.40f)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,300),0.40f).build();

    public static final FoodProperties SOUL = new FoodProperties.Builder().nutrition(0).saturationModifier(1f).effect(
            new MobEffectInstance(ModEffects.SOUL_EFFECT.getHolder().get(),10000),1f).build();

    public static final FoodProperties SOUL2 = new FoodProperties.Builder().nutrition(0).saturationModifier(1f).effect(
            new MobEffectInstance(ModEffects.SOUL_EFFECT2.getHolder().get(),10000),1f).build();
    public static final FoodProperties SOUL3 = new FoodProperties.Builder().nutrition(0).saturationModifier(1f).effect(
            new MobEffectInstance(ModEffects.SOUL_EFFECT3.getHolder().get(),10000),1f).build();
    public static final FoodProperties SOUL4 = new FoodProperties.Builder().nutrition(0).saturationModifier(1f).effect(
            new MobEffectInstance(ModEffects.SOUL_EFFECT4.getHolder().get(),10000),1f).build();
    public static final FoodProperties SOUL5 = new FoodProperties.Builder().nutrition(0).saturationModifier(1f).effect(
            new MobEffectInstance(ModEffects.SOUL_EFFECT5.getHolder().get(),10000),1f).build();
}
