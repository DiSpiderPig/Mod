package net.dispider.dispidermod.worldgen;

import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.block.ModBlocks;
import net.dispider.dispidermod.worldgen.tree.custom.WhiteFoliagePlacer;
import net.dispider.dispidermod.worldgen.tree.custom.WhiteTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {


    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_RAINBOW_ORE_KEY = registerKey("rainbow_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> NETHER_RAINBOW_ORE_KEY = registerKey("nether_rainbow_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> END_RAINBOW_ORE_KEY = registerKey("end_rainbow_ore");

    public static  final  ResourceKey<ConfiguredFeature<?,?>> BLUE_KEY = registerKey("blue");
    public static final ResourceKey<ConfiguredFeature<?,?>> WHITE_KEY = registerKey("white");
    public static final ResourceKey<ConfiguredFeature<?,?>> RED_KEY = registerKey("red");

    // CF - > PF - > BM
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        register(context, BLUE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.BLUE_LOG.get()),
                new ForkingTrunkPlacer(4, 4, 3),

                BlockStateProvider.simple(ModBlocks.BLUE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(3), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

         register(context, WHITE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.WHITE_LOG.get()),
                new WhiteTrunkPlacer(12, 12, 10),

                BlockStateProvider.simple(ModBlocks.WHITE_LEAVES.get()),
                new WhiteFoliagePlacer(ConstantInt.of(7), ConstantInt.of(2),8),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, RED_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.RED_LOG.get()),
                new BendingTrunkPlacer(4, 4, 3,4,ConstantInt.of(4)),

                BlockStateProvider.simple(ModBlocks.RED_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(3), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());



        List<OreConfiguration.TargetBlockState> overworldRainbowOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.RAINBOW_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.RAINBOW_DEEPSLATE_ORE.get().defaultBlockState()));


        register(context,OVERWORLD_RAINBOW_ORE_KEY,Feature.ORE,new OreConfiguration(overworldRainbowOres,9));
        register(context,NETHER_RAINBOW_ORE_KEY,Feature.ORE,new OreConfiguration(netherrackReplaceables,ModBlocks.NETHER_RAINBOW_ORE.get().defaultBlockState(),2));
        register(context,END_RAINBOW_ORE_KEY,Feature.ORE,new OreConfiguration(endReplaceables,ModBlocks.END_RAINBOW_ORE.get().defaultBlockState(),4));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(DiSpiderMod.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
