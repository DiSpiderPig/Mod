package net.dispider.dispidermod.worldgen.tree;

import com.mojang.serialization.MapCodec;
import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.worldgen.tree.custom.WhiteTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, DiSpiderMod.MODID);

    public static final RegistryObject<TrunkPlacerType<WhiteTrunkPlacer>> WHITE_TRUNK_PLACER = TRUNK_PLACER.register("white_trunk_placer",()->new TrunkPlacerType<>(
            MapCodec.assumeMapUnsafe(WhiteTrunkPlacer.CODEC)));
    public static void register(IEventBus eventBus){
        TRUNK_PLACER.register(eventBus);
    }
}
