package net.dispider.dispidermod.datagen;


import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.block.ModBlocks;
import net.dispider.dispidermod.block.custom.Smiley_Face_Lamp;
import net.dispider.dispidermod.block.custom.TomatoCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DiSpiderMod.EXAMPLEMOD, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockwithItem(ModBlocks.RAINBOW_BLOCK);
        blockwithItem(ModBlocks.BLUE_PLANK);
        blockwithItem(ModBlocks.MOKIP);
        blockwithItem(ModBlocks.RAINBOW_ORE);
        blockwithItem(ModBlocks.END_RAINBOW_ORE);
        blockwithItem(ModBlocks.NETHER_RAINBOW_ORE);
        blockwithItem(ModBlocks.RAINBOW_DEEPSLATE_ORE);


        stairsBlock(ModBlocks.BlUE_STAIRS.get(),blockTexture(ModBlocks.BLUE_PLANK.get()));
        slabBlock(ModBlocks.BlUE_SLAB.get(),blockTexture(ModBlocks.BLUE_PLANK.get()),blockTexture(ModBlocks.BLUE_PLANK.get()));

        buttonBlock(ModBlocks.BlUE_BUTTON.get(),blockTexture(ModBlocks.BLUE_PLANK.get()));
        pressurePlateBlock(ModBlocks.BlUE_PRESSURE_PLATE.get(),blockTexture(ModBlocks.BLUE_PLANK.get()));


        fenceBlock(ModBlocks.BlUE_FENCE.get(),blockTexture(ModBlocks.BLUE_PLANK.get()));
        fenceGateBlock(ModBlocks.BlUE_FENCE_GATE.get(),blockTexture(ModBlocks.BLUE_PLANK.get()));
        wallBlock(ModBlocks.BlUE_WALL.get(),blockTexture(ModBlocks.BLUE_PLANK.get()));


        doorBlockWithRenderType(ModBlocks.BlUE_DOOR.get(),modLoc("block/blue_door_bottom"),modLoc("block/blue_door_top"),"cutout");
        trapdoorBlockWithRenderType(ModBlocks.BlUE_TRAP_DOOR.get(),modLoc("block/blue_trap_door"),true,"cutout");

         simpleBlock(ModBlocks.MONEY_PRINTER.get(), new ModelFile.UncheckedModelFile(modLoc("block/money_printer")) {
         });

        blockItem(ModBlocks.BlUE_PRESSURE_PLATE);
        blockItem(ModBlocks.BlUE_SLAB);
        blockItem(ModBlocks.BlUE_STAIRS);
        blockItem(ModBlocks.BlUE_FENCE_GATE);
        blockItem(ModBlocks.BlUE_TRAP_DOOR,"_bottom");


        logBlock(ModBlocks.BLUE_LOG.get());
        axisBlock(ModBlocks.BLUE_WOOD.get(),blockTexture(ModBlocks.BLUE_LOG.get()),blockTexture(ModBlocks.BLUE_LOG.get())) ;
        logBlock(ModBlocks.STRIPPED_BLUE_LOG.get());
        axisBlock(ModBlocks.STRIPPED_BLUE_WOOD.get(),blockTexture(ModBlocks.STRIPPED_BLUE_LOG.get()),blockTexture(ModBlocks.BLUE_LOG.get())) ;



        blockItem(ModBlocks.BLUE_LOG);
        blockItem(ModBlocks.BLUE_WOOD);
        blockItem(ModBlocks.STRIPPED_BLUE_LOG);
        blockItem(ModBlocks.STRIPPED_BLUE_WOOD);



        saplingBlock(ModBlocks.BLUE_SAPLING);
        leavesBlock(ModBlocks.BLUE_LEAVES);

        customLamp();
        makeCrop((CropBlock) ModBlocks.TOMATO_CROP.get(),"tomato_crop_stage","tomato_crop_stage");
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.SMILEY_FACE_LAMP.get()).forAllStates(state -> {
            if(state.getValue(Smiley_Face_Lamp.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("smiley_face_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(DiSpiderMod.EXAMPLEMOD, "block/" + "smiley_face_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("smiley_face_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(DiSpiderMod.EXAMPLEMOD, "block/" + "smiley_face_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.SMILEY_FACE_LAMP.get(), models().cubeAll("smiley_face_lamp_on",
                ResourceLocation.fromNamespaceAndPath(DiSpiderMod.EXAMPLEMOD, "block/" + "smiley_face_lamp_on")));
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((TomatoCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(DiSpiderMod.EXAMPLEMOD, "block/" + textureName + state.getValue(((TomatoCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockwithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }


    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("dispider_mod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("dispider_mod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

}
