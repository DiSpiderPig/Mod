package net.dispider.dispidermod.blocks;

import net.dispider.dispidermod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.dispider.dispidermod.DiSpiderMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DiSpiderMod.EXAMPLEMOD);

    public static final RegistryObject<Block> RAINBOW_BLOCK = registerBlock("rainbow_block",()->new Block(BlockBehaviour.Properties.of
            ().strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> BLUE_LOG = registerBlock("blue_log",()->new Block(BlockBehaviour.Properties.of()
            .strength(2f).sound(SoundType.CHERRY_WOOD)));
    public static final RegistryObject<Block> BLUE_PLANK = registerBlock("blue_plank",()->new Block(BlockBehaviour.Properties.of()
            .strength(2f).sound(SoundType.CHERRY_WOOD)));


    private static<T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    } private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name,()->new BlockItem(block.get(),new Item.Properties()));
    } public static void register(IEventBus eventbus){
        BLOCKS.register(eventbus);
    }


}
