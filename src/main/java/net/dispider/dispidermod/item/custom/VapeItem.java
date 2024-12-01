package net.dispider.dispidermod.item.custom;

import net.dispider.dispidermod.sound.ModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;

public class VapeItem extends Item {
    public VapeItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public SoundEvent getEatingSound() {
        return ModSounds.useVape.get();
    }
}
