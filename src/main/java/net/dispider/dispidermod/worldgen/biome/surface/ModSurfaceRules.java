package net.dispider.dispidermod.worldgen.biome.surface;


import net.dispider.dispidermod.block.ModBlocks;
import net.dispider.dispidermod.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource SAPPHIRE = makeStateRule(ModBlocks.WHITE_PLANK.get());
    private static final SurfaceRules.RuleSource RAW_SAPPHIRE = makeStateRule(ModBlocks.WHITE_GRASS.get());

    private static final SurfaceRules.RuleSource RED_PLANK = makeStateRule(ModBlocks.RED_PLANK.get());
    private static final SurfaceRules.RuleSource RED_GRASS = makeStateRule(ModBlocks.RED_GRASS.get());


    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return SurfaceRules.sequence(
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.WHITE_BIOME),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, RAW_SAPPHIRE)),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SAPPHIRE)),


                // Default to a grass and dirt surface
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
        );
    }
    public static SurfaceRules.RuleSource makeRulesRed() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return SurfaceRules.sequence(
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.RED_BIOME),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, GRASS_BLOCK)),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, GRASS_BLOCK)),


                // Default to a grass and dirt surface
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}