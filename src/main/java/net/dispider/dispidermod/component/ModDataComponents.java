package net.dispider.dispidermod.component;

import com.mojang.serialization.Codec;
import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.item.ModItems;
import net.minecraft.client.renderer.entity.layers.PlayerItemInHandLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.UnaryOperator;

import static net.dispider.dispidermod.item.ModItems.Ruga;

public class ModDataComponents {
    static Player player;
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister.create(
            Registries.DATA_COMPONENT_TYPE, DiSpiderMod.EXAMPLEMOD);

    public static final RegistryObject<DataComponentType<BlockPos>> COORDINATES = register("coordinates",builder->builder.persistent(
            BlockPos.CODEC));

   


    private static <T> RegistryObject<DataComponentType<T>> register(String name, UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return DATA_COMPONENT_TYPES.register(name, () -> builderOperator.apply(DataComponentType.builder()).build()); }

    public static void register(IEventBus eventBus){
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}
