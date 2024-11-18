package net.dispider.dispidermod.datagen;


import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
        blockwithItem(ModBlocks.BLUE_LOG);

        stairsBlock(ModBlocks.BlUE_STAIRS.get(),blockTexture(ModBlocks.BLUE_PLANK.get()));
        slabBlock(ModBlocks.BlUE_SLAB.get(),blockTexture(ModBlocks.BLUE_PLANK.get()),blockTexture(ModBlocks.BLUE_PLANK.get()));

        buttonBlock(ModBlocks.BlUE_BUTTON.get(),blockTexture(ModBlocks.BLUE_PLANK.get()));
        pressurePlateBlock(ModBlocks.BlUE_PRESSURE_PLATE.get(),blockTexture(ModBlocks.BLUE_PLANK.get()));


        fenceBlock(ModBlocks.BlUE_FENCE.get(),blockTexture(ModBlocks.BLUE_PLANK.get()));
        fenceGateBlock(ModBlocks.BlUE_FENCE_GATE.get(),blockTexture(ModBlocks.BLUE_PLANK.get()));
        wallBlock(ModBlocks.BlUE_WALL.get(),blockTexture(ModBlocks.BLUE_PLANK.get()));


        doorBlockWithRenderType(ModBlocks.BlUE_DOOR.get(),modLoc("block/blue_door_bottom"),modLoc("block/blue_door_top"),"cutout");
        trapdoorBlockWithRenderType(ModBlocks.BlUE_TRAP_DOOR.get(),modLoc("block/blue_trap_door"),true,"cutout");

        
        blockItem(ModBlocks.BlUE_PRESSURE_PLATE);
        blockItem(ModBlocks.BlUE_SLAB);
        blockItem(ModBlocks.BlUE_STAIRS);
        blockItem(ModBlocks.BlUE_FENCE_GATE);
        blockItem(ModBlocks.BlUE_TRAP_DOOR,"_bottom");
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
