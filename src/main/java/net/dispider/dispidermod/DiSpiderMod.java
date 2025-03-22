package net.dispider.dispidermod;

import com.mojang.logging.LogUtils;
import net.dispider.dispidermod.block.ModBlocks;
import net.dispider.dispidermod.block.entity.ModBlockEntities;
import net.dispider.dispidermod.component.ModDataComponents;
import net.dispider.dispidermod.effect.ModEffects;
import net.dispider.dispidermod.enchantment.ModEnchantmentEffects;
import net.dispider.dispidermod.entity.ModEntities;
import net.dispider.dispidermod.entity.client.ManRenderer;
import net.dispider.dispidermod.item.ModItems;
import net.dispider.dispidermod.potion.ModPotions;
import net.dispider.dispidermod.screen.ModMenuTypes;
import net.dispider.dispidermod.sound.ModSounds;
import net.dispider.dispidermod.util.ModItemProperties;
import net.dispider.dispidermod.worldgen.biome.ModTerrablender;
import net.dispider.dispidermod.worldgen.biome.surface.ModSurfaceRules;
import net.dispider.dispidermod.worldgen.tree.ModFoliagePlacer;
import net.dispider.dispidermod.worldgen.tree.ModTrunkPlacerTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DiSpiderMod.MODID)

public class DiSpiderMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "dispider_mod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();




    public DiSpiderMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModTerrablender.registerBiomes();
        ModDataComponents.register(modEventBus);


        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        ModSounds.register(modEventBus);
        ModEffects.register(modEventBus);
        ModEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModTrunkPlacerTypes.register(modEventBus);
        ModFoliagePlacer.register(modEventBus);
        ModPotions.register(modEventBus);
        ModEnchantmentEffects.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID,ModSurfaceRules.makeRules());
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, ModSurfaceRules.makeRulesRed());

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.Money);
            event.accept(ModItems.Bitcoin);
            event.accept(ModItems.Rainbow);
            event.accept(ModItems.Spanakoruzi);
            event.accept(ModItems.TOMATO_SEEDS);
            event.accept(ModItems.Petrol);
            event.accept(ModItems.VAPE);
            event.accept(ModItems.MOONTALE_MUSIC_DISC);
        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.BLUE_LOG);
            event.accept(ModBlocks.BLUE_PLANK);
            event.accept(ModBlocks.RAINBOW_BLOCK);
            event.accept(ModBlocks.END_RAINBOW_ORE);
            event.accept(ModBlocks.RAINBOW_DEEPSLATE_ORE);
            event.accept(ModBlocks.NETHER_RAINBOW_ORE);
            event.accept(ModBlocks.RAINBOW_ORE);
            event.accept(ModBlocks.MOKIP);
            event.accept(ModBlocks.BlUE_PRESSURE_PLATE);
            event.accept(ModBlocks.BlUE_SLAB);
            event.accept(ModBlocks.BlUE_STAIRS);
            event.accept(ModBlocks.BlUE_BUTTON);
            event.accept(ModBlocks.BlUE_TRAP_DOOR);
            event.accept(ModBlocks.BlUE_DOOR);
            event.accept(ModBlocks.BlUE_WALL);
            event.accept(ModBlocks.BlUE_FENCE);
            event.accept(ModBlocks.BlUE_FENCE_GATE);
            event.accept(ModBlocks.SMILEY_FACE_LAMP);
        }

        if(event.getTabKey() == CreativeModeTabs.COMBAT){
            event.accept(ModItems.Ruga);
            event.accept(ModItems.EMERALD_SWORD);
            event.accept(ModItems.Katana);
            event.accept(ModItems.RedKatana);
            event.accept(ModItems.PinkKatana);
            event.accept(ModItems.GreenKatana);
            event.accept(ModItems.BlackKatana);
            event.accept(ModItems.OrangeKatana);
            event.accept(ModItems.RAINBOW_HAMMER);
            event.accept(ModItems.EMERALD_HELMET);
            event.accept(ModItems.EMERALD_CHESTPLATE);
            event.accept(ModItems.EMERALD_LEGGINS);
            event.accept(ModItems.EMERALD_BOOTS);
            event.accept(ModItems.EMERALD_HORSE_ARMOR);
            event.accept(ModItems.EPIC_BOW);
            event.accept(ModItems.Pokeball);
            event.accept(ModItems.SkeletonPokeball);
        }
        if(event.getTabKey()==CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.accept(ModItems.EMERALD_AXE);
            event.accept(ModItems.EMERALD_HOE);
            event.accept(ModItems.EMERALD_PICKAXE);
            event.accept(ModItems.EMERALD_SHOVEL);
        }
    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ModItemProperties.addCustomProperties();
            EntityRenderers.register(ModEntities.POKEBALL_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.creeperPOKEBALL_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.zombiePOKEBALL_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.SlimePOKEBALL_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.spidercreeperPOKEBALL_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.SkeletonPOKEBALL_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.Masterball_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.EnderDragonPROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.WitherPROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.MAN.get(), ManRenderer::new);


        }
    }

}