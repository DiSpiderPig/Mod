package net.dispider.dispidermod.datagen;

import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.block.ModBlocks;
import net.dispider.dispidermod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.item.crafting.BlastingRecipe;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,ModItems.EMERALD_AXE.get())
                        .pattern("AA")
                                .pattern("XA")
                                        .pattern(" X")
                                                .define('A',Items.EMERALD.asItem())
                                                        .define('X',Items.STICK.asItem())
                                                                .unlockedBy(getHasName(Items.EMERALD.asItem()),has(Items.EMERALD.asItem())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,ModItems.EMERALD_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("X")
                .define('A',Items.EMERALD.asItem())
                .define('X',Items.STICK.asItem())
                .unlockedBy(getHasName(Items.EMERALD.asItem()),has(Items.EMERALD.asItem())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,ModItems.EMERALD_PICKAXE.get())
                .pattern("AAA")
                .pattern(" X ")
                .pattern(" X ")
                .define('A',Items.EMERALD.asItem())
                .define('X',Items.STICK.asItem())
                .unlockedBy(getHasName(Items.EMERALD.asItem()),has(Items.EMERALD.asItem())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,ModItems.EMERALD_SHOVEL.get())
                .pattern("A")
                .pattern("X")
                .pattern("X")
                .define('A',Items.EMERALD.asItem())
                .define('X',Items.STICK.asItem())
                .unlockedBy(getHasName(Items.EMERALD.asItem()),has(Items.EMERALD.asItem())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,ModItems.EMERALD_HOE.get())
                .pattern("AA")
                .pattern(" X")
                .pattern(" X")
                .define('A',Items.EMERALD.asItem())
                .define('X',Items.STICK.asItem())
                .unlockedBy(getHasName(Items.EMERALD.asItem()),has(Items.EMERALD.asItem())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,ModItems.RAINBOW_HAMMER.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern(" X ")
                .define('A',Items.DIAMOND_PICKAXE)
                .define('X',Items.STICK.asItem())
                .unlockedBy(getHasName(Items.DIAMOND_PICKAXE.asItem()),has(Items.DIAMOND_PICKAXE.asItem())).save(pRecipeOutput);




        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.Ruga.get())
                .pattern("A")
                .pattern("B")
                .define('A', ModItems.Rainbow.get())
                .define('B',Items.STICK.asItem())
                .unlockedBy(getHasName(ModItems.Rainbow.get()), has(ModItems.Rainbow.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Money.get(),64)
                .requires(ModItems.Bitcoin.get())
                .unlockedBy(getHasName(ModItems.Bitcoin.get()),has(ModItems.Bitcoin.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,ModBlocks.WHITE_PLANK.get(),4)
                        .requires(ModBlocks.WHITE_LOG.get())
                                .unlockedBy(getHasName(ModBlocks.WHITE_LOG.get()),has(ModBlocks.WHITE_LOG.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,ModBlocks.RED_PLANK.get(),4)
                .requires(ModBlocks.RED_LOG.get())
                .unlockedBy(getHasName(ModBlocks.RED_LOG.get()),has(ModBlocks.RED_LOG.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,ModBlocks.BLUE_PLANK.get(),4)
                .requires(ModBlocks.BLUE_LOG.get())
                .unlockedBy(getHasName(ModBlocks.BLUE_LOG.get()),has(ModBlocks.BLUE_LOG.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Spanakoruzi.get(),1)
                .requires(Items.ROTTEN_FLESH.asItem())
                .requires(Items.BOWL.asItem())
                .unlockedBy(getHasName(Items.BOWL.asItem()),has(Items.ROTTEN_FLESH.asItem())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Money.get(),16)
                .requires(ModBlocks.RAINBOW_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAINBOW_BLOCK.get()),
                        has(ModBlocks.RAINBOW_BLOCK.get())).save(pRecipeOutput, DiSpiderMod.MODID +":money_from_rainbow_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.Soul2.get(),1)
                .requires(ModItems.Soul.get(),2)
                .unlockedBy(getHasName(ModItems.Soul.get()),has(ModItems.Soul.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.Soul3.get(),1)
                .requires(ModItems.Soul2.get())
                .requires(ModItems.Soul.get())
                .unlockedBy(getHasName(ModItems.Soul2.get()),has(ModItems.Soul2.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.Soul4.get(),1)
                .requires(ModItems.Soul3.get())
                .requires(ModItems.Soul.get())
                .unlockedBy(getHasName(ModItems.Soul.get()),has(ModItems.Soul3.get())).save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.Soul5.get(),1)
                .requires(ModItems.Soul4.get())
                .requires(ModItems.Soul.get())
                .unlockedBy(getHasName(ModItems.Soul.get()),has(ModItems.Soul3.get())).save(pRecipeOutput);


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




        stairBuilder(ModBlocks.WHITE_STAIRS.get(),Ingredient.of(ModBlocks.WHITE_PLANK.get())).group("white")
                .unlockedBy(getHasName(ModBlocks.WHITE_PLANK.get()),has(ModBlocks.WHITE_PLANK.get())).save(pRecipeOutput);
        slab(pRecipeOutput,RecipeCategory.BUILDING_BLOCKS,ModBlocks.WHITE_SLAB.get(),ModBlocks.WHITE_PLANK.get());

        buttonBuilder(ModBlocks.WHITE_BUTTON.get(), Ingredient.of(ModBlocks.WHITE_BUTTON.get())).group("white")
                .unlockedBy(getHasName(ModBlocks.WHITE_PLANK.get()), has(ModBlocks.WHITE_PLANK.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.WHITE_PRESSURE_PLATE.get(), ModBlocks.WHITE_PLANK.get());

        fenceBuilder(ModBlocks.WHITE_FENCE.get(), Ingredient.of(ModBlocks.WHITE_PLANK.get())).group("white")
                .unlockedBy(getHasName(ModBlocks.WHITE_PLANK.get()), has(ModBlocks.WHITE_PLANK.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.WHITE_FENCE_GATE.get(), Ingredient.of(ModBlocks.WHITE_PLANK.get())).group("white")
                .unlockedBy(getHasName(ModBlocks.WHITE_PLANK.get()), has(ModBlocks.WHITE_PLANK.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_WALL.get(), ModBlocks.WHITE_PLANK.get());

        doorBuilder(ModBlocks.WHITE_DOOR.get(), Ingredient.of(ModBlocks.WHITE_PLANK.get())).group("white")
                .unlockedBy(getHasName(ModBlocks.WHITE_PLANK.get()), has(ModBlocks.WHITE_PLANK.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.WHITE_TRAP_DOOR.get(), Ingredient.of(ModBlocks.WHITE_TRAP_DOOR.get())).group("white")
                .unlockedBy(getHasName(ModBlocks.WHITE_PLANK.get()), has(ModBlocks.WHITE_PLANK.get())).save(pRecipeOutput);





        stairBuilder(ModBlocks.RED_STAIRS.get(),Ingredient.of(ModBlocks.RED_PLANK.get())).group("red")
                .unlockedBy(getHasName(ModBlocks.RED_PLANK.get()),has(ModBlocks.RED_PLANK.get())).save(pRecipeOutput);
        slab(pRecipeOutput,RecipeCategory.BUILDING_BLOCKS,ModBlocks.RED_SLAB.get(),ModBlocks.RED_PLANK.get());

        buttonBuilder(ModBlocks.RED_BUTTON.get(), Ingredient.of(ModBlocks.RED_BUTTON.get())).group("red")
                .unlockedBy(getHasName(ModBlocks.RED_PLANK.get()), has(ModBlocks.RED_PLANK.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.RED_PRESSURE_PLATE.get(), ModBlocks.RED_PLANK.get());

        fenceBuilder(ModBlocks.RED_FENCE.get(), Ingredient.of(ModBlocks.RED_PLANK.get())).group("red")
                .unlockedBy(getHasName(ModBlocks.RED_PLANK.get()), has(ModBlocks.RED_PLANK.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.RED_FENCE_GATE.get(), Ingredient.of(ModBlocks.RED_PLANK.get())).group("red")
                .unlockedBy(getHasName(ModBlocks.BLUE_PLANK.get()), has(ModBlocks.RED_PLANK.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_WALL.get(), ModBlocks.RED_PLANK.get());

        doorBuilder(ModBlocks.RED_DOOR.get(), Ingredient.of(ModBlocks.RED_PLANK.get())).group("red")
                .unlockedBy(getHasName(ModBlocks.RED_PLANK.get()), has(ModBlocks.BLUE_PLANK.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.RED_TRAP_DOOR.get(), Ingredient.of(ModBlocks.RED_TRAP_DOOR.get())).group("red")
                .unlockedBy(getHasName(ModBlocks.RED_PLANK.get()), has(ModBlocks.RED_PLANK.get())).save(pRecipeOutput);

        trimSmithing(pRecipeOutput,ModItems.PEACE_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(DiSpiderMod.MODID
        ,"peace"));






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
                    .save(recipeOutput, DiSpiderMod.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
}}
