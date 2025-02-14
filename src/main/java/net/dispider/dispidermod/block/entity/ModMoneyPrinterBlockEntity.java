

package net.dispider.dispidermod.block.entity;

import net.dispider.dispidermod.item.ModItems;
import net.dispider.dispidermod.screen.MoneyPrinterMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ModMoneyPrinterBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(2);
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;


    public ModMoneyPrinterBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.MONEY_PRINTER_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex){
                    case 0 -> ModMoneyPrinterBlockEntity.this.progress;
                    case 1 -> ModMoneyPrinterBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
              switch(pIndex){
                  case 0 -> ModMoneyPrinterBlockEntity.this.progress = pValue;
                  case 1 -> ModMoneyPrinterBlockEntity.this.maxProgress = pValue;
              }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }


    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {

        if(cap== ForgeCapabilities.ITEM_HANDLER){
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(()-> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }
    public void drops(){
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i,itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level,this.worldPosition,inventory);
    }

    @Override
    public Component getDisplayName() {

        return Component.translatable("block.dispider_mod.money_printer");
    }



    @Override
    public void saveAdditional(CompoundTag nbt, HolderLookup.Provider lookup) {
        nbt.put("inventory", itemHandler.serializeNBT(lookup));
        nbt.putInt("breeder.progress", this.progress);
        super.saveAdditional(nbt, lookup);
    }

    @Override
    public void loadAdditional(CompoundTag nbt, HolderLookup.Provider lookup) {
        super.loadAdditional(nbt, lookup);
        itemHandler.deserializeNBT(lookup,nbt.getCompound("inventory"));
        progress = nbt.getInt("breeder.progress");


    }
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {




        if(hasRecipe()){
            increaseCraftingProgress();
            setChanged(pLevel,pPos,pState);


            if(hasProgressFinished()){
                craftItem();
                resetProgress();
            }
            else{
                resetProgress();
            }
        }

    }

    private void resetProgress() {
        progress =0;
    }

    private void craftItem() {
        ItemStack result = new ItemStack(ModItems.Money.get(),64);
        this.itemHandler.extractItem(INPUT_SLOT,1,false);

        this.itemHandler.setStackInSlot(OUTPUT_SLOT,new ItemStack(result.getItem(),this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));

    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        boolean hasCraftingItem = this.itemHandler.getStackInSlot(INPUT_SLOT).getItem() == ModItems.Bitcoin.get();
        ItemStack result = new ItemStack(ModItems.Money.get());
        return hasCraftingItem && canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
       return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new MoneyPrinterMenu(pContainerId,pPlayerInventory,new SimpleContainer(2),this.data);
    }
}
