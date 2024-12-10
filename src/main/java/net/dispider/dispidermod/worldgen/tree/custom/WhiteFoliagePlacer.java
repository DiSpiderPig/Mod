package net.dispider.dispidermod.worldgen.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.dispider.dispidermod.worldgen.tree.ModFoliagePlacer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class WhiteFoliagePlacer extends FoliagePlacer {
    public static final Codec<WhiteFoliagePlacer> CODEC = RecordCodecBuilder.create(whiteFoliagePlacerInstance -> foliagePlacerParts(
            whiteFoliagePlacerInstance).and(Codec.intRange(0,16).fieldOf("height").forGetter(fp -> fp.height)).apply(whiteFoliagePlacerInstance, WhiteFoliagePlacer::new));


    private final int height;



    public WhiteFoliagePlacer(IntProvider pRadius, IntProvider pOffset,int height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacer.WHITE_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig, int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {

        BlockPos blockpos = pAttachment.pos();
        blockpos.north(3).east(3);        // -3 z      // +3 x
        int i = 0;

        for (int j = blockpos.getY() - pFoliageHeight + pOffset; j <= blockpos.getY() + pOffset; j++) {
            int k = blockpos.getY() - j;
            int l = pFoliageRadius + pAttachment.radiusOffset() + Mth.floor((float)k / (float)pFoliageHeight * 3.5F);
            int i1;
            if (k > 0 && l == i && (j & 1) == 0) {
                i1 = l + 1;
            } else {
                i1 = l;
            }

            this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, new BlockPos(blockpos.getX()+3, j, blockpos.getZ()-3), i1, 0, pAttachment.doubleTrunk());
            i = l;
        }
    }

    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        return false;
    }
}
