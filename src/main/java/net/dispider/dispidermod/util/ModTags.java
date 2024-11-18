package net.dispider.dispidermod.util;

import net.dispider.dispidermod.DiSpiderMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {


    public static class Blocks{
        private static TagKey<Block> createTag(String name){

            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(DiSpiderMod.EXAMPLEMOD,name));
        }
    }

    public static class Items{
        public static TagKey<Item> COOL_ITEMS = createTag("cool_items");

        private static TagKey<Item>  createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(DiSpiderMod.EXAMPLEMOD,name));
        }

        /*
        public boolean isValidItem(ItemStack item){
        return item.is(ModTags.Items.COOL_ITEMS);
            }
         */


    }


}
