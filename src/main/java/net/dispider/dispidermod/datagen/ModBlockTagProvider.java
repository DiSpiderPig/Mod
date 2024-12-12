package net.dispider.dispidermod.datagen;

import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.block.ModBlocks;
import net.dispider.dispidermod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DiSpiderMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RAINBOW_BLOCK.get())
                .add(ModBlocks.RAINBOW_ORE.get())
                .add(ModBlocks.END_RAINBOW_ORE.get())
                .add(ModBlocks.NETHER_RAINBOW_ORE.get())
                .add(ModBlocks.RAINBOW_DEEPSLATE_ORE.get())
                .add(ModBlocks.MOKIP.get())
                        .add(ModBlocks.POKEBLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RAINBOW_BLOCK.get())
                .add(ModBlocks.RAINBOW_ORE.get())
                        .add(ModBlocks.RAINBOW_DEEPSLATE_ORE.get())
                                .add(ModBlocks.END_RAINBOW_ORE.get())
                                        .add(ModBlocks.NETHER_RAINBOW_ORE.get());
        tag(BlockTags.DIRT).add(ModBlocks.WHITE_GRASS.get()).add(ModBlocks.RED_GRASS.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MOKIP.get());

        tag(BlockTags.FENCES).add(ModBlocks.BlUE_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.BlUE_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.BlUE_WALL.get());
        this.tag(BlockTags.LOGS_THAT_BURN)
                        .add(ModBlocks.BLUE_LOG.get())
                        .add(ModBlocks.STRIPPED_BLUE_WOOD.get())
                        .add(ModBlocks.BLUE_WOOD.get())
                        .add(ModBlocks.STRIPPED_BLUE_LOG.get())
                .add(ModBlocks.RED_LOG.get())
                .add(ModBlocks.STRIPPED_RED_WOOD.get())
                .add(ModBlocks.RED_WOOD.get())
                .add(ModBlocks.STRIPPED_RED_LOG.get())
                .add(ModBlocks.WHITE_WOOD.get())
                .add(ModBlocks.STRIPPED_WHITE_WOOD.get())
                .add(ModBlocks.WHITE_LOG.get())
                .add(ModBlocks.STRIPPED_WHITE_LOG.get());
        tag(BlockTags.PLANKS).add(ModBlocks.BLUE_PLANK.get()).add(ModBlocks.WHITE_PLANK.get()).add(ModBlocks.WHITE_PLANK.get());
        tag(ModTags.Blocks.NEEDS_EMERALD_TOOL)
                .add(ModBlocks.RAINBOW_ORE.get())
                .add(ModBlocks.END_RAINBOW_ORE.get())
                .add(ModBlocks.NETHER_RAINBOW_ORE.get())
                .add(ModBlocks.RAINBOW_DEEPSLATE_ORE.get())
                .add(Blocks.OBSIDIAN)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_EMERALD_TOOL)
                .addTags(BlockTags.INCORRECT_FOR_IRON_TOOL)
        .remove(ModTags.Blocks.NEEDS_EMERALD_TOOL);
        }


    }

