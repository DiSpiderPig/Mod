package net.dispider.dispidermod.datagen;

import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.enchantment.ModEnchantments;
import net.dispider.dispidermod.trim.ModTrimMaterials;
import net.dispider.dispidermod.trim.ModTrimPatterns;
import net.dispider.dispidermod.worldgen.ModBiomeModifiers;
import net.dispider.dispidermod.worldgen.ModConfiguredFeatures;
import net.dispider.dispidermod.worldgen.ModPlacedFeatures;
import net.dispider.dispidermod.worldgen.biome.ModBiomes;
import net.dispider.dispidermod.worldgen.dimension.ModDimensions;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDataPackEntries extends DatapackBuiltinEntriesProvider {
   public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.TRIM_MATERIAL, ModTrimMaterials::bootstrap)
           .add(Registries.DIMENSION_TYPE, ModDimensions::bootstrapType)
           .add(Registries.TRIM_PATTERN, ModTrimPatterns::bootstrap)
           .add(Registries.ENCHANTMENT, ModEnchantments::boostrap)
           .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
           .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
           .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
           .add(Registries.BIOME, ModBiomes::bootstrap)
           .add(Registries.LEVEL_STEM,ModDimensions::bootstrapStem);



    public ModDataPackEntries(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries,BUILDER, Set.of(DiSpiderMod.MODID));
    }
}
