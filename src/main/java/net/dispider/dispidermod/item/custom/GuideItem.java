package net.dispider.dispidermod.item.custom;

import net.dispider.dispidermod.item.ModItems;
import net.dispider.dispidermod.screen.GuideMenu;
import net.dispider.dispidermod.screen.ModMenuTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuConstructor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GuideItem extends Item {


    public GuideItem(Properties pProperties) {
        super(pProperties);
    }




    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack item = pPlayer.getItemInHand(pUsedHand);
//        player.openMenu(new CustomMenuProvider());
        if (!pLevel.isClientSide && pPlayer instanceof ServerPlayer serverPlayer) {



            // Open the GUI
            pPlayer.openMenu(new SimpleMenuProvider( (containerId, playerInventory, playerEntity) -> new GuideMenu(containerId, playerInventory),
                    Component.translatable(" ")
            ));
        }

        return InteractionResultHolder.success(item);
    }




}
