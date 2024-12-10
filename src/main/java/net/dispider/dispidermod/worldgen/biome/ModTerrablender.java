package net.dispider.dispidermod.worldgen.biome;

import net.dispider.dispidermod.DiSpiderMod;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes(){
        Regions.register(new ModOverworldRegion(ResourceLocation.fromNamespaceAndPath(DiSpiderMod.EXAMPLEMOD,"overworld"),2));
    }
}
