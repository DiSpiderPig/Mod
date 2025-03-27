package net.dispider.dispidermod.block.entity;

import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.block.ModBlocks;
import net.dispider.dispidermod.block.entity.custom.GoldSmelterBlockEntity;
import net.dispider.dispidermod.block.entity.custom.PrinterBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DiSpiderMod.MODID);

    public static final RegistryObject<BlockEntityType<PrinterBlockEntity>> PRINTER_BE = BLOCK_ENTITIES.register("printer_be",()-> BlockEntityType.Builder.of(
            PrinterBlockEntity::new, ModBlocks.Printer.get()
    ).build(null));

    public static final RegistryObject<BlockEntityType<GoldSmelterBlockEntity>> GOLD_SMELTER_BE = BLOCK_ENTITIES.register("gold_smelter_be",
            ()-> BlockEntityType.Builder.of(GoldSmelterBlockEntity::new, ModBlocks.GOLD_SMELTER.get()
    ).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}

