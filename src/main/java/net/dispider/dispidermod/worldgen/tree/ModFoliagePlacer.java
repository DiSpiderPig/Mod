package net.dispider.dispidermod.worldgen.tree;

import com.mojang.serialization.MapCodec;
import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.worldgen.tree.custom.WhiteFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacer {

        public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, DiSpiderMod.MODID);

        public static final RegistryObject<FoliagePlacerType<WhiteFoliagePlacer>> WHITE_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("white_foliage_placer",()->
                new FoliagePlacerType<>(MapCodec.assumeMapUnsafe(WhiteFoliagePlacer.CODEC)));

        public static void register(IEventBus eventBus){
            FOLIAGE_PLACERS.register(eventBus);
        }
}
