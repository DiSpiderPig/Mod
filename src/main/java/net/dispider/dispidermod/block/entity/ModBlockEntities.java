package net.dispider.dispidermod.block.entity;

import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DiSpiderMod.MODID);


    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}

