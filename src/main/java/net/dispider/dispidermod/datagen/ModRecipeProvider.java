package net.dispider.dispidermod.datagen;

import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.block.ModBlocks;
import net.dispider.dispidermod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.models.model.TextureMapping.pattern;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> BITCOIN = List.of(ModItems.Bitcoin.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MOKIP.get())
                .pattern("AA")
                .pattern("AA")
                .define('A', Items.ROTTEN_FLESH.asItem())
                .unlockedBy(getHasName(Items.ROTTEN_FLESH.asItem()), has(Items.ROTTEN_FLESH.asItem())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.Ruga.get())
                .pattern("A")
                .pattern("B")
                .define('A', ModItems.Rainbow.get())
                .define('B',Items.STICK.asItem())
                .unlockedBy(getHasName(ModItems.Rainbow.get()), has(ModItems.Rainbow.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Money.get(),64)
                .requires(ModItems.Bitcoin.get())
                .unlockedBy(getHasName(ModItems.Bitcoin.get()),has(ModItems.Bitcoin.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Spanakoruzi.get(),1)
                .requires(ModItems.Bitcoin.get())
                .requires(Items.BOWL.asItem())
                .unlockedBy(getHasName(Items.BOWL.asItem()),has(Items.ROTTEN_FLESH.asItem())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Money.get(),16)
                .requires(ModBlocks.RAINBOW_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAINBOW_BLOCK.get()),
                        has(ModBlocks.RAINBOW_BLOCK.get())).save(pRecipeOutput, DiSpiderMod.EXAMPLEMOD+":money_from_rainbow_block");

        oreSmelting(pRecipeOutput, BITCOIN,RecipeCategory.MISC,Items.COAL,20f,200,"coal");
        oreBlasting(pRecipeOutput, BITCOIN,RecipeCategory.MISC,Items.COAL,20f,100,"coal");


        stairBuilder(ModBlocks.BlUE_STAIRS.get(),Ingredient.of(ModBlocks.BLUE_PLANK.get())).group("blue")
                .unlockedBy(getHasName(ModBlocks.BLUE_PLANK.get()),has(ModBlocks.BLUE_PLANK.get())).save(pRecipeOutput);
        slab(pRecipeOutput,RecipeCategory.BUILDING_BLOCKS,ModBlocks.BlUE_SLAB.get(),ModBlocks.BLUE_PLANK.get());

        buttonBuilder(ModBlocks.BlUE_BUTTON.get(), Ingredient.of(ModBlocks.BlUE_BUTTON.get())).group("blue")
                .unlockedBy(getHasName(ModBlocks.BLUE_PLANK.get()), has(ModBlocks.BLUE_PLANK.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.BlUE_PRESSURE_PLATE.get(), ModBlocks.BLUE_PLANK.get());

        fenceBuilder(ModBlocks.BlUE_FENCE.get(), Ingredient.of(ModBlocks.BLUE_PLANK.get())).group("blue")
                .unlockedBy(getHasName(ModBlocks.BLUE_PLANK.get()), has(ModBlocks.BLUE_PLANK.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.BlUE_FENCE_GATE.get(), Ingredient.of(ModBlocks.BLUE_PLANK.get())).group("blue")
                .unlockedBy(getHasName(ModBlocks.BLUE_PLANK.get()), has(ModBlocks.BLUE_PLANK.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BlUE_WALL.get(), ModBlocks.BLUE_PLANK.get());

        doorBuilder(ModBlocks.BlUE_DOOR.get(), Ingredient.of(ModBlocks.BLUE_PLANK.get())).group("blue")
                .unlockedBy(getHasName(ModBlocks.BLUE_PLANK.get()), has(ModBlocks.BLUE_PLANK.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.BlUE_TRAP_DOOR.get(), Ingredient.of(ModBlocks.BlUE_TRAP_DOOR.get())).group("blue")
                .unlockedBy(getHasName(ModBlocks.BLUE_PLANK.get()), has(ModBlocks.BLUE_PLANK.get())).save(pRecipeOutput);




    }
    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, DiSpiderMod.EXAMPLEMOD + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
}}
