package net.dispider.dispidermod.datagen;

import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.block.ModBlocks;
import net.dispider.dispidermod.item.ModItems;
import net.dispider.dispidermod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, DiSpiderMod.EXAMPLEMOD, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        tag(ModTags.Items.COOL_ITEMS)
                .add(ModItems.Ruga.get())
                .add(ModItems.Ruga.get());
        tag(ItemTags.PLANKS).add(Item.byBlock(ModBlocks.BLUE_PLANK.get()));
        tag(ItemTags.TRIMMABLE_ARMOR).add(ModItems.EMERALD_BOOTS.get())
                .add(ModItems.EMERALD_LEGGINS.get())
                .add(ModItems.EMERALD_CHESTPLATE.get())
                .add(ModItems.EMERALD_HELMET.get());
        tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.Rainbow.get());
        tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.PEACE_SMITHING_TEMPLATE.get());
        tag(ItemTags.WEAPON_ENCHANTABLE).add(ModItems.Ruga.get());
        tag(ItemTags.WEAPON_ENCHANTABLE).add(ModItems.RugaUsed.get());
        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.BLUE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_BLUE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_BLUE_LOG.get().asItem())
                .add(ModBlocks.BLUE_WOOD.get().asItem());
        tag(ItemTags.PLANKS)
                .add(ModBlocks.BLUE_PLANK.get().asItem());

    }
}
