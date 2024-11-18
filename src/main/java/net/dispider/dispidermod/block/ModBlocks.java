package net.dispider.dispidermod.block;

import net.dispider.dispidermod.block.custom.Mokip;
import net.dispider.dispidermod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.dispider.dispidermod.DiSpiderMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
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

    public static final RegistryObject<Block> RAINBOW_ORE = registerBlock("rainbow_ore",()->new DropExperienceBlock(UniformInt.of(2,4),BlockBehaviour.Properties.of()
            .strength(4f).sound(SoundType.NETHER_GOLD_ORE).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MOKIP = registerBlock("mokip",()->new Mokip(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.AZALEA_LEAVES)));

    public static final RegistryObject<StairBlock> BlUE_STAIRS = registerBlock("blue_stairs",()->new StairBlock(ModBlocks.BLUE_PLANK.get().defaultBlockState(),
            BlockBehaviour.Properties.of().strength(1f)));
    public static final RegistryObject<SlabBlock> BlUE_SLAB = registerBlock("blue_slab",()->new SlabBlock(
            BlockBehaviour.Properties.of().strength(1f)));



    public static final RegistryObject<PressurePlateBlock> BlUE_PRESSURE_PLATE = registerBlock("blue_pressure_plate",()->new PressurePlateBlock(BlockSetType.IRON,
            BlockBehaviour.Properties.of().strength(1f)));
    public static final RegistryObject<ButtonBlock> BlUE_BUTTON = registerBlock("blue_button",()->new ButtonBlock(BlockSetType.IRON,1,
            BlockBehaviour.Properties.of().strength(1f).noCollission()));



    public static final RegistryObject<FenceBlock> BlUE_FENCE = registerBlock("blue_fence",()->new FenceBlock(
            BlockBehaviour.Properties.of().strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceGateBlock> BlUE_FENCE_GATE = registerBlock("blue_fence_gate",()->new FenceGateBlock(WoodType.ACACIA,
            BlockBehaviour.Properties.of().strength(1f)));
    public static final RegistryObject<WallBlock> BlUE_WALL = registerBlock("blue_wall",()->new WallBlock(
            BlockBehaviour.Properties.of().strength(1f)));




    public static final RegistryObject<DoorBlock> BlUE_DOOR = registerBlock("blue_door",()->new DoorBlock(BlockSetType.IRON,
            BlockBehaviour.Properties.of().strength(1f).noOcclusion()));
    public static final RegistryObject<TrapDoorBlock> BlUE_TRAP_DOOR = registerBlock("blue_trap_door",()->new TrapDoorBlock(BlockSetType.IRON,
            BlockBehaviour.Properties.of().strength(1f).noOcclusion()));










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
