package net.dispider.dispidermod.worldgen.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.dispider.dispidermod.block.ModBlocks;
import net.dispider.dispidermod.worldgen.tree.ModTrunkPlacerTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class WhiteTrunkPlacer extends TrunkPlacer {
    public static final Codec<WhiteTrunkPlacer> CODEC = RecordCodecBuilder.create(whiteTrunkPlacerInstance ->
            trunkPlacerParts(whiteTrunkPlacerInstance).apply(whiteTrunkPlacerInstance,WhiteTrunkPlacer::new));

    public WhiteTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.WHITE_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {


  setDirtAt(pLevel,pBlockSetter,pRandom,pPos.below(),pConfig);
  int height = pFreeTreeHeight + pRandom.nextInt(heightRandA,heightRandA+3)+pRandom.nextInt(heightRandB-1,heightRandB+1);


        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                for (int k = 0; k < height; k++) {
                    placeLog(pLevel,pBlockSetter,pRandom,pPos.above(k).east(j).north(i),pConfig);

                    }
                }
            }


        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pPos.above(height),0,true));
    }
}
