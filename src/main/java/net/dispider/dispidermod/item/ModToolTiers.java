package net.dispider.dispidermod.item;

import net.dispider.dispidermod.util.ModTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {

    public static final Tier EMERALD = new ForgeTier(1400,7f,5f,7, ModTags.Blocks.NEEDS_EMERALD_TOOL,
            ()-> Ingredient.of(Items.EMERALD.asItem()),ModTags.Blocks.INCORRECT_FOR_EMERALD_TOOL);

}
