package net.dispider.dispidermod.util;

import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.component.ModDataComponents;
import net.dispider.dispidermod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItemProperties {

    public static void addCustomProperties(){
        ItemProperties.register(ModItems.Ruga.get(), ResourceLocation.fromNamespaceAndPath(DiSpiderMod.MODID,"used"),
                (itemStack,clientLevel,livingEntity,i) -> itemStack.get(ModDataComponents.COORDINATES.get())!=
                null ? 1:0f);
        CustomBow(ModItems.EPIC_BOW.get());

    }
    private static void CustomBow(Item item){
        ItemProperties.register(item, ResourceLocation.withDefaultNamespace("pull"), (p_340951_, p_340952_, p_340953_, p_340954_) -> {
            if (p_340953_ == null) {
                return 0.0F;
            } else {
                return p_340953_.getUseItem() != p_340951_ ? 0.0F : (float)(p_340951_.getUseDuration(p_340953_) - p_340953_.getUseItemRemainingTicks()) / 20.0F;
            }
        });

        ItemProperties.register(
                item,
                ResourceLocation.withDefaultNamespace("pulling"),
                (p_174630_, p_174631_, p_174632_, p_174633_) -> p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F
        );
    }

}
