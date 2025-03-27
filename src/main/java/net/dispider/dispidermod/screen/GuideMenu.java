package net.dispider.dispidermod.screen;

import net.dispider.dispidermod.block.ModBlocks;
import net.dispider.dispidermod.item.ModItems;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class GuideMenu extends AbstractContainerMenu {
    public static final ItemStackHandler inventory = new ItemStackHandler(5){
        @Override
        protected int getStackLimit(int slot, @NotNull ItemStack stack) {
            return 1;
        }

        @Override
        protected void onContentsChanged(int slot) {


            super.onContentsChanged(slot);
        }
    };

    public GuideMenu(int pContainerId, Inventory inv) {
       super(ModMenuTypes.GUIDE_MENU.get(),pContainerId);


        addSlot(new SlotItemHandler(inventory,0,40,35));
        addSlot(new SlotItemHandler(inventory,1,60,35));
       addSlot(new SlotItemHandler(inventory,2,80,35));
        addSlot(new SlotItemHandler(inventory,3,100,35));
        addSlot(new SlotItemHandler(inventory,4,120,35));

    }
    
    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
       return null;}
                          

    @Override
    public boolean stillValid(Player pPlayer) {
        return true;
    }
}



