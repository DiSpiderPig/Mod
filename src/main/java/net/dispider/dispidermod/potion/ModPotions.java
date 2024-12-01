package net.dispider.dispidermod.potion;

import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.effect.ModEffects;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, DiSpiderMod.EXAMPLEMOD);

    public static final RegistryObject<Potion> CANCER_POTION = POTIONS.register("cancer_potion",()->new Potion(new MobEffectInstance(ModEffects.CANCER_EFFECT.getHolder().get(),1500,0)));


    public static void register(IEventBus eventBus){
        POTIONS.register(eventBus);
    }
}
