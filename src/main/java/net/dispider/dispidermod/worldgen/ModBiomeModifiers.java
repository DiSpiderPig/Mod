package net.dispider.dispidermod.worldgen;

import net.dispider.dispidermod.DiSpiderMod;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_RAINBOW_ORE = registerKey("add_rainbow_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_RAINBOW_ORE = registerKey("add_nether_rainbow_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_RAINBOW_ORE = registerKey("add_end_rainbow_ore");

    public static final ResourceKey<BiomeModifier> ADD_TREE_BLUE = registerKey("add_tree_blue");
    public static final ResourceKey<BiomeModifier> ADD_TREE_WHITE = registerKey("add_tree_white");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeature = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

context.register(ADD_RAINBOW_ORE,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeature
        .getOrThrow(ModPlacedFeatures.RAINBOW_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_NETHER_RAINBOW_ORE,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_NETHER), HolderSet.direct(placedFeature
                .getOrThrow(ModPlacedFeatures.NETHER_RAINBOW_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_END_RAINBOW_ORE,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_END), HolderSet.direct(placedFeature
                .getOrThrow(ModPlacedFeatures.END_RAINBOW_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_TREE_BLUE,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_SNOWY),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.BLUE_PLACED_KEY)),GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_WHITE,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_MOUNTAIN),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.WHITE_PLACED_KEY)),GenerationStep.Decoration.VEGETAL_DECORATION));



    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(DiSpiderMod.EXAMPLEMOD, name));
    }

}
