package net.dispider.dispidermod.worldgen;

import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {


    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_RAINBOW_ORE_KEY = registerKey("rainbow_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> NETHER_RAINBOW_ORE_KEY = registerKey("nether_rainbow_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> END_RAINBOW_ORE_KEY = registerKey("end_rainbow_ore");


    // CF - > PF - > BM
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldRainbowOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.RAINBOW_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.RAINBOW_DEEPSLATE_ORE.get().defaultBlockState()));


        register(context,OVERWORLD_RAINBOW_ORE_KEY,Feature.ORE,new OreConfiguration(overworldRainbowOres,4));
        register(context,NETHER_RAINBOW_ORE_KEY,Feature.ORE,new OreConfiguration(netherrackReplaceables,ModBlocks.NETHER_RAINBOW_ORE.get().defaultBlockState(),2));
        register(context,END_RAINBOW_ORE_KEY,Feature.ORE,new OreConfiguration(endReplaceables,ModBlocks.END_RAINBOW_ORE.get().defaultBlockState(),4));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(DiSpiderMod.EXAMPLEMOD, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
