package net.dispider.dispidermod.worldgen;

import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> RAINBOW_ORE_PLACED_KEY = registerKey("rainbow_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_RAINBOW_ORE_PLACED_KEY = registerKey("nether_rainbow_ore_placed");
    public static final ResourceKey<PlacedFeature> END_RAINBOW_ORE_PLACED_KEY = registerKey("end_rainbow_ore_placed");

    public static final ResourceKey<PlacedFeature> BLUE_PLACED_KEY = registerKey("blue_placed");
    public static final ResourceKey<PlacedFeature> WHITE_PLACED_KEY = registerKey("white_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context,RAINBOW_ORE_PLACED_KEY,configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_RAINBOW_ORE_KEY
        ), ModOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(80))));
        register(context,NETHER_RAINBOW_ORE_PLACED_KEY,configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_RAINBOW_ORE_KEY
        ), ModOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(80))));
        register(context,END_RAINBOW_ORE_PLACED_KEY,configuredFeatures.getOrThrow(ModConfiguredFeatures.END_RAINBOW_ORE_KEY
        ), ModOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(80))));

       register(context,BLUE_PLACED_KEY,configuredFeatures.getOrThrow(ModConfiguredFeatures.BLUE_KEY), VegetationPlacements.treePlacement(PlacementUtils.countExtra(
               3,0.1f,2), ModBlocks.BLUE_SAPLING.get()));

        register(context,WHITE_PLACED_KEY,configuredFeatures.getOrThrow(ModConfiguredFeatures.WHITE_KEY), VegetationPlacements.treePlacement(PlacementUtils.countExtra(
                1,0.01f,1), ModBlocks.WHITE_SAPLING.get()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(DiSpiderMod.EXAMPLEMOD, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
