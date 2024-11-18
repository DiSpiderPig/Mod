package net.dispider.dispidermod.datagen;

import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DiSpiderMod.EXAMPLEMOD, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RAINBOW_BLOCK.get())
                .add(ModBlocks.RAINBOW_ORE.get())
                .add(ModBlocks.MOKIP.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RAINBOW_BLOCK.get())
                .add(ModBlocks.RAINBOW_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MOKIP.get());

        tag(BlockTags.FENCES).add(ModBlocks.BlUE_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.BlUE_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.BlUE_WALL.get());


    }
}
