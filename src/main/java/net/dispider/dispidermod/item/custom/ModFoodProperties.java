package net.dispider.dispidermod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties Spanakoruzo = new FoodProperties.Builder().nutrition(2).saturationModifier(0.25f).
            effect(new MobEffectInstance(MobEffects.HUNGER,25),0.50f).build();
}
