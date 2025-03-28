package net.dispider.dispidermod.datagen;

import net.dispider.dispidermod.block.ModBlocks;
import net.dispider.dispidermod.block.custom.TomatoCropBlock;
import net.dispider.dispidermod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(    HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
       dropSelf(ModBlocks.RAINBOW_BLOCK.get());
       dropSelf(ModBlocks.END_RAINBOW_ORE.get());
       dropSelf(ModBlocks.NETHER_RAINBOW_ORE.get());
       dropSelf(ModBlocks.RAINBOW_DEEPSLATE_ORE.get());
            dropSelf(ModBlocks.MOKIP.get());



       dropSelf(ModBlocks.BlUE_STAIRS.get());
       this.add(ModBlocks.BlUE_SLAB.get(),block -> createSlabItemTable(ModBlocks.BlUE_SLAB.get()));
       this.add(ModBlocks.BlUE_DOOR.get(),block -> createDoorTable(ModBlocks.BlUE_DOOR.get()));
       dropSelf(ModBlocks.BlUE_TRAP_DOOR.get());
       dropSelf(ModBlocks.BlUE_FENCE.get());
       dropSelf(ModBlocks.BlUE_FENCE_GATE.get());
       dropSelf(ModBlocks.BlUE_PRESSURE_PLATE.get());
       dropSelf(ModBlocks.BlUE_BUTTON.get());
       dropSelf(ModBlocks.BlUE_WALL.get());
       dropSelf(ModBlocks.BLUE_PLANK.get());
      this.add(ModBlocks.BLUE_LEAVES.get(),block -> createLeavesDrops(block,ModBlocks.BLUE_SAPLING.get(),NORMAL_LEAVES_SAPLING_CHANCES));
       dropSelf(ModBlocks.BLUE_LOG.get());
       dropSelf(ModBlocks.BLUE_SAPLING.get());
       dropSelf(ModBlocks.BLUE_WOOD.get());
       dropSelf(ModBlocks.STRIPPED_BLUE_WOOD.get());
       dropSelf(ModBlocks.STRIPPED_BLUE_LOG.get());

        dropSelf(ModBlocks.WHITE_STAIRS.get());
        this.add(ModBlocks.WHITE_SLAB.get(),block -> createSlabItemTable(ModBlocks.WHITE_SLAB.get()));
        this.add(ModBlocks.WHITE_DOOR.get(),block -> createDoorTable(ModBlocks.WHITE_DOOR.get()));
        dropSelf(ModBlocks.WHITE_TRAP_DOOR.get());
        dropSelf(ModBlocks.WHITE_FENCE.get());
        dropSelf(ModBlocks.WHITE_FENCE_GATE.get());
        dropSelf(ModBlocks.WHITE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.WHITE_BUTTON.get());
        dropSelf(ModBlocks.WHITE_WALL.get());


        dropSelf(ModBlocks.RED_STAIRS.get());
        this.add(ModBlocks.RED_SLAB.get(),block -> createSlabItemTable(ModBlocks.RED_SLAB.get()));
        this.add(ModBlocks.RED_DOOR.get(),block -> createDoorTable(ModBlocks.RED_DOOR.get()));
        dropSelf(ModBlocks.RED_TRAP_DOOR.get());
        dropSelf(ModBlocks.RED_FENCE.get());
        dropSelf(ModBlocks.RED_FENCE_GATE.get());
        dropSelf(ModBlocks.RED_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.RED_BUTTON.get());
        dropSelf(ModBlocks.RED_WALL.get());
        dropSelf(ModBlocks.RED_PLANK.get());
        this.add(ModBlocks.RED_LEAVES.get(),block -> createLeavesDrops(block,ModBlocks.RED_SAPLING.get(),NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(ModBlocks.RED_LOG.get());
        dropSelf(ModBlocks.RED_SAPLING.get());
        dropSelf(ModBlocks.RED_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_RED_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_RED_LOG.get());



        this.add(ModBlocks.WHITE_LEAVES.get(),block -> createLeavesDrops(block,ModBlocks.WHITE_SAPLING.get(),NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(ModBlocks.WHITE_LOG.get());
        dropSelf(ModBlocks.WHITE_SAPLING.get());
        dropSelf(ModBlocks.WHITE_WOOD.get());
        dropSelf(ModBlocks.WHITE_PLANK.get());
        dropSelf(ModBlocks.STRIPPED_WHITE_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_WHITE_LOG.get());
       dropSelf(ModBlocks.SMILEY_FACE_LAMP.get());

        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.TOMATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, TomatoCropBlock.MAX_AGE));

        this.add(ModBlocks.TOMATO_CROP.get(), this.createCropDrops(ModBlocks.TOMATO_CROP.get(),
                ModItems.TOMATO.get(), ModItems.TOMATO_SEEDS.get(), lootItemConditionBuilder));
        this.add(ModBlocks.WHITE_GRASS.get(),block ->createMultipleDrops(ModBlocks.WHITE_GRASS.get(), Blocks.DIRT.asItem(),1f,1f));
        this.add(ModBlocks.RED_GRASS.get(),block ->createMultipleDrops(ModBlocks.RED_GRASS.get(), Blocks.DIRT.asItem(),1f,1f));

        this.add(ModBlocks.POKEBLOCK.get(),
                block -> createMultipleDrops(ModBlocks.RAINBOW_ORE.get(), ModItems.Pokeball.get(),1f,1f));

       this.add(ModBlocks.RAINBOW_ORE.get(),
               block -> createMultipleDrops(ModBlocks.RAINBOW_ORE.get(), ModItems.Rainbow.get(),2f,4f));
       this.add(ModBlocks.RAINBOW_DEEPSLATE_ORE.get(),block ->createMultipleDrops(ModBlocks.RAINBOW_DEEPSLATE_ORE.get(),ModItems.Rainbow.get(),1f,3f));
       this.add(ModBlocks.END_RAINBOW_ORE.get(),block ->createMultipleDrops(ModBlocks.END_RAINBOW_ORE.get(),ModItems.Rainbow.get(),2f,4f));
       this.add(ModBlocks.NETHER_RAINBOW_ORE.get(),block ->createMultipleDrops(ModBlocks.NETHER_RAINBOW_ORE.get(),ModItems.Rainbow.get(),1f,3f));
    }

    protected LootTable.Builder createMultipleDrops(Block pBlock,Item item,float minDrops,float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock,
                (LootPoolEntryContainer.Builder<?>)this.applyExplosionDecay(
                        pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
