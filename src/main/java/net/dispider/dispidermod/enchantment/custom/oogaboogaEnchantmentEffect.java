package net.dispider.dispidermod.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.dispider.dispidermod.sound.ModSounds;
import net.minecraft.client.resources.sounds.AmbientSoundHandler;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.sound.SoundEvent;

public record oogaboogaEnchantmentEffect() implements EnchantmentEntityEffect {
    @Override
    public void apply(ServerLevel pLevel, int pEnchantmentLevel, EnchantedItemInUse pItem, Entity pEntity, Vec3 pOrigin) {

    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return null;
    }
}
