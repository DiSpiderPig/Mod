package net.dispider.dispidermod.item.custom;

import net.dispider.dispidermod.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class CrackCocaineItem extends Item {
    public CrackCocaineItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public SoundEvent getEatingSound() {
        return ModSounds.Sniffing.get();
    }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 32;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {

        pTooltipComponents.add(Component.translatable("0 Calories"));

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }

}
