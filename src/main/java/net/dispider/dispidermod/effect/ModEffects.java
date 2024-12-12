package net.dispider.dispidermod.effect;

import net.dispider.dispidermod.DiSpiderMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS,
            DiSpiderMod.MODID);

    public static final RegistryObject<MobEffect> CANCER_EFFECT = MOB_EFFECTS.register("cancer",()->new CancerEffect(
            MobEffectCategory.HARMFUL,
            000000).addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(
                    DiSpiderMod.MODID,"cancer"),-0.25f, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
            ));

    public static final RegistryObject<MobEffect> SOUL_EFFECT = MOB_EFFECTS.register("soul",()-> new SoulEffect(MobEffectCategory.HARMFUL,81437));
    public static final RegistryObject<MobEffect> SOUL_EFFECT2 = MOB_EFFECTS.register("soul2",()-> new SoulEffect2(MobEffectCategory.HARMFUL,81437));
    public static final RegistryObject<MobEffect> SOUL_EFFECT3 = MOB_EFFECTS.register("soul3",()-> new SoulEffect3(MobEffectCategory.HARMFUL,81437));
    public static final RegistryObject<MobEffect> SOUL_EFFECT4 = MOB_EFFECTS.register("soul4",()-> new SoulEffect4(MobEffectCategory.HARMFUL,81437));
    public static final RegistryObject<MobEffect> SOUL_EFFECT5 = MOB_EFFECTS.register("soul5",()-> new SuperSoulEffect(MobEffectCategory.HARMFUL,81437));

    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }

}
