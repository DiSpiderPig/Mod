package net.dispider.dispidermod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class FuelItem extends Item {

    private int burnTIme = 0;


    public FuelItem(Properties pProperties, int burnTime) {
        super(pProperties);
        this.burnTIme = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burnTIme;
    }
}
