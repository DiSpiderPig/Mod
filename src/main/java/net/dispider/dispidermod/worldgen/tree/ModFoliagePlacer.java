package net.dispider.dispidermod.worldgen.tree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.worldgen.tree.custom.WhiteFoliagePlacer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacer {

        public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, DiSpiderMod.EXAMPLEMOD);

        public static final RegistryObject<FoliagePlacerType<WhiteFoliagePlacer>> WHITE_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("white_foliage_placer",()->
                new FoliagePlacerType<>(MapCodec.assumeMapUnsafe(WhiteFoliagePlacer.CODEC)));

        public static void register(IEventBus eventBus){
            FOLIAGE_PLACERS.register(eventBus);
        }
}
