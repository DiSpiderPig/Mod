package net.dispider.dispidermod.block;

import net.dispider.dispidermod.block.custom.*;
import net.dispider.dispidermod.item.ModItems;
import net.dispider.dispidermod.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.dispider.dispidermod.DiSpiderMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DiSpiderMod.EXAMPLEMOD);

    public static final RegistryObject<Block> RAINBOW_BLOCK = registerBlock("rainbow_block",()->new Block(BlockBehaviour.Properties.of
            ().strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> BLUE_PLANK = registerBlock("blue_plank",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> WHITE_PLANK = registerBlock("white_plank",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> BLUE_LEAVES = registerBlock("blue_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> WHITE_LEAVES = registerBlock("white_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });
    public static final RegistryObject<Block> BLUE_SAPLING = registerBlock("blue_sapling",
            () -> new SaplingBlock(ModTreeGrowers.BLUE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> WHITE_SAPLING= registerBlock("white_sapling",
            () -> new SaplingBlock(ModTreeGrowers.WHITE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));


    public static final RegistryObject<Block> RAINBOW_ORE = registerBlock("rainbow_ore",()->new DropExperienceBlock(UniformInt.of(2,4),BlockBehaviour.Properties.of()
            .strength(3f).sound(SoundType.NETHER_GOLD_ORE).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> NETHER_RAINBOW_ORE = registerBlock("nether_rainbow_ore",()->new DropExperienceBlock(UniformInt.of(3,6),BlockBehaviour.Properties.of()
            .strength(3f).sound(SoundType.NETHER_GOLD_ORE).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> END_RAINBOW_ORE = registerBlock("end_rainbow_ore",()->new DropExperienceBlock(UniformInt.of(2,4),BlockBehaviour.Properties.of()
            .strength(2f).sound(SoundType.NETHER_GOLD_ORE).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RAINBOW_DEEPSLATE_ORE = registerBlock("deepslate_rainbow_ore",()->new DropExperienceBlock(UniformInt.of(3,6),BlockBehaviour.Properties.of()
            .strength(4f).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MOKIP = registerBlock("mokip",()->new Mokip(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.AZALEA_LEAVES)));

    public static final RegistryObject<StairBlock> BlUE_STAIRS = registerBlock("blue_stairs",()->new StairBlock(ModBlocks.BLUE_PLANK.get().defaultBlockState(),
            BlockBehaviour.Properties.of().strength(1f)));
    public static final RegistryObject<SlabBlock> BlUE_SLAB = registerBlock("blue_slab",()->new SlabBlock(
            BlockBehaviour.Properties.of().strength(1f)));

     public static final RegistryObject<Block> MONEY_PRINTER = registerBlock("money_printer",()-> new MoneyPrinterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK).noOcclusion()));



    public static final RegistryObject<PressurePlateBlock> BlUE_PRESSURE_PLATE = registerBlock("blue_pressure_plate",()->new PressurePlateBlock(BlockSetType.IRON,
            BlockBehaviour.Properties.of().strength(1f)));
    public static final RegistryObject<ButtonBlock> BlUE_BUTTON = registerBlock("blue_button",()->new ButtonBlock(BlockSetType.IRON,3,
            BlockBehaviour.Properties.of().strength(1f).noCollission()));



    public static final RegistryObject<FenceBlock> BlUE_FENCE = registerBlock("blue_fence",()->new FenceBlock(
            BlockBehaviour.Properties.of().strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceGateBlock> BlUE_FENCE_GATE = registerBlock("blue_fence_gate",()->new FenceGateBlock(WoodType.ACACIA,
            BlockBehaviour.Properties.of().strength(1f)));
    public static final RegistryObject<WallBlock> BlUE_WALL = registerBlock("blue_wall",()->new WallBlock(
            BlockBehaviour.Properties.of().strength(1f)));

    public static final RegistryObject<GrassBlock> WHITE_GRASS = registerBlock(
            "white_grass",()->new GrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));




    public static final RegistryObject<DoorBlock> BlUE_DOOR = registerBlock("blue_door",()->new DoorBlock(BlockSetType.IRON,
            BlockBehaviour.Properties.of().strength(1f).noOcclusion()));
    public static final RegistryObject<TrapDoorBlock> BlUE_TRAP_DOOR = registerBlock("blue_trap_door",()->new TrapDoorBlock(BlockSetType.IRON,
            BlockBehaviour.Properties.of().strength(1f).noOcclusion()));

    public static final RegistryObject<Block> SMILEY_FACE_LAMP = registerBlock("smiley_face_lamp",()->new Smiley_Face_Lamp(BlockBehaviour.Properties.of().strength(1f)
            .lightLevel(state ->state.getValue(Smiley_Face_Lamp.CLICKED)? 15:0)));
    public static final RegistryObject<Block> TOMATO_CROP = BLOCKS.register("tomato_crop",()-> new TomatoCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));

    public static final RegistryObject<RotatedPillarBlock> BLUE_LOG = registerBlock("blue_log",()-> new ModFlammableRotatedPillarBlock(BlockBehaviour
            .Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final RegistryObject<RotatedPillarBlock>  BLUE_WOOD = registerBlock("blue_wood",()-> new ModFlammableRotatedPillarBlock(BlockBehaviour
            .Properties.ofFullCopy(Blocks.OAK_WOOD)));

    public static final RegistryObject<RotatedPillarBlock> STRIPPED_BLUE_LOG = registerBlock("stripped_blue_log",()-> new ModFlammableRotatedPillarBlock(BlockBehaviour
            .Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<RotatedPillarBlock> STRIPPED_BLUE_WOOD = registerBlock("stripped_blue_wood",()-> new ModFlammableRotatedPillarBlock(BlockBehaviour
            .Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<RotatedPillarBlock> WHITE_LOG = registerBlock("white_log",()-> new ModFlammableRotatedPillarBlock(BlockBehaviour
            .Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final RegistryObject<RotatedPillarBlock>  WHITE_WOOD = registerBlock("white_wood",()-> new ModFlammableRotatedPillarBlock(BlockBehaviour
            .Properties.ofFullCopy(Blocks.OAK_WOOD)));

    public static final RegistryObject<RotatedPillarBlock> STRIPPED_WHITE_LOG = registerBlock("stripped_white_log",()-> new ModFlammableRotatedPillarBlock(BlockBehaviour
            .Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<RotatedPillarBlock> STRIPPED_WHITE_WOOD = registerBlock("stripped_white_wood",()-> new ModFlammableRotatedPillarBlock(BlockBehaviour
            .Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> POKEBLOCK = registerBlock("pokeblock",()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
    public static final RegistryObject<Block> MOD_PORTAL= registerBlock("mod_portal",()->new ModPortalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE
    ).noCollission().noLootTable().noOcclusion()));
    public static final RegistryObject<RotatedPillarBlock> RED_LOG = registerBlock("red_log",()-> new ModFlammableRotatedPillarBlock(BlockBehaviour
            .Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final RegistryObject<RotatedPillarBlock>  RED_WOOD = registerBlock("red_wood",()-> new ModFlammableRotatedPillarBlock(BlockBehaviour
            .Properties.ofFullCopy(Blocks.OAK_WOOD)));

    public static final RegistryObject<RotatedPillarBlock> STRIPPED_RED_LOG = registerBlock("stripped_red_log",()-> new ModFlammableRotatedPillarBlock(BlockBehaviour
            .Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<RotatedPillarBlock> STRIPPED_RED_WOOD = registerBlock("stripped_red_wood",()-> new ModFlammableRotatedPillarBlock(BlockBehaviour
            .Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<GrassBlock> RED_GRASS = registerBlock(
            "red_grass",()->new GrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));
    public static final RegistryObject<Block> RED_SAPLING= registerBlock("red_sapling",
            () -> new SaplingBlock(ModTreeGrowers.RED, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> RED_LEAVES = registerBlock("red_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });
    public static final RegistryObject<Block> RED_PLANK = registerBlock("red_plank",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;


                }
            });


    public static final RegistryObject<PressurePlateBlock> WHITE_PRESSURE_PLATE = registerBlock("white_pressure_plate",()->new PressurePlateBlock(BlockSetType.IRON,
            BlockBehaviour.Properties.of().strength(1f)));
    public static final RegistryObject<ButtonBlock> WHITE_BUTTON = registerBlock("white_button",()->new ButtonBlock(BlockSetType.IRON,3,
            BlockBehaviour.Properties.of().strength(1f).noCollission()));
    public static final RegistryObject<FenceBlock> WHITE_FENCE = registerBlock("white_fence",()->new FenceBlock(
            BlockBehaviour.Properties.of().strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceGateBlock> WHITE_FENCE_GATE = registerBlock("white_fence_gate",()->new FenceGateBlock(WoodType.ACACIA,
            BlockBehaviour.Properties.of().strength(1f)));
    public static final RegistryObject<WallBlock> WHITE_WALL = registerBlock("white_wall",()->new WallBlock(
            BlockBehaviour.Properties.of().strength(1f)));
    public static final RegistryObject<DoorBlock> WHITE_DOOR = registerBlock("white_door",()->new DoorBlock(BlockSetType.IRON,
            BlockBehaviour.Properties.of().strength(1f).noOcclusion()));
    public static final RegistryObject<TrapDoorBlock> WHITE_TRAP_DOOR = registerBlock("white_trap_door",()->new TrapDoorBlock(BlockSetType.IRON,
            BlockBehaviour.Properties.of().strength(1f).noOcclusion()));
    public static final RegistryObject<StairBlock> WHITE_STAIRS = registerBlock("white_stairs",()->new StairBlock(ModBlocks.BLUE_PLANK.get().defaultBlockState(),
            BlockBehaviour.Properties.of().strength(1f)));
    public static final RegistryObject<SlabBlock> WHITE_SLAB = registerBlock("white_slab",()->new SlabBlock(
            BlockBehaviour.Properties.of().strength(1f)));

    public static final RegistryObject<PressurePlateBlock> RED_PRESSURE_PLATE = registerBlock("red_pressure_plate",()->new PressurePlateBlock(BlockSetType.IRON,
            BlockBehaviour.Properties.of().strength(1f)));
    public static final RegistryObject<ButtonBlock> RED_BUTTON = registerBlock("red_button",()->new ButtonBlock(BlockSetType.IRON,3,
            BlockBehaviour.Properties.of().strength(1f).noCollission()));
    public static final RegistryObject<FenceBlock> RED_FENCE = registerBlock("red_fence",()->new FenceBlock(
            BlockBehaviour.Properties.of().strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceGateBlock> RED_FENCE_GATE = registerBlock("red_fence_gate",()->new FenceGateBlock(WoodType.ACACIA,
            BlockBehaviour.Properties.of().strength(1f)));
    public static final RegistryObject<WallBlock> RED_WALL = registerBlock("red_wall",()->new WallBlock(
            BlockBehaviour.Properties.of().strength(1f)));
    public static final RegistryObject<DoorBlock> RED_DOOR = registerBlock("red_door",()->new DoorBlock(BlockSetType.IRON,
            BlockBehaviour.Properties.of().strength(1f).noOcclusion()));
    public static final RegistryObject<TrapDoorBlock> RED_TRAP_DOOR = registerBlock("red_trap_door",()->new TrapDoorBlock(BlockSetType.IRON,
            BlockBehaviour.Properties.of().strength(1f).noOcclusion()));
    public static final RegistryObject<StairBlock> RED_STAIRS = registerBlock("red_stairs",()->new StairBlock(ModBlocks.RED_PLANK.get().defaultBlockState(),
            BlockBehaviour.Properties.of().strength(1f)));
    public static final RegistryObject<SlabBlock> RED_SLAB = registerBlock("red_slab",()->new SlabBlock(
            BlockBehaviour.Properties.of().strength(1f)));










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
