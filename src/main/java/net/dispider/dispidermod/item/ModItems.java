package net.dispider.dispidermod.item;

import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.block.ModBlocks;
import net.dispider.dispidermod.item.custom.*;
import net.dispider.dispidermod.item.custom.pokeball.*;
import net.dispider.dispidermod.sound.ModSounds;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
   public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DiSpiderMod.MODID);

   public static final RegistryObject<Item> Money = ITEMS.register("money",()->new Item((new Item.Properties())));

   public static final RegistryObject<Item> Bitcoin = ITEMS.register("bitcoin",()->new Item((new Item.Properties())));
   public static final RegistryObject<Item> Rainbow = ITEMS.register("rainbow",()->new Item((new Item.Properties())));

   public static final RegistryObject<Item> Ruga = ITEMS.register("ruga",()->new RugaItem(new Item.Properties().durability(8)));

   public static final RegistryObject<Item> RugaUsed = ITEMS.register("ruga_used",()->new RugaUsedItem(new Item.Properties().durability(3)));

   public static final RegistryObject<Item> Spanakoruzi = ITEMS.register("spanakoruzi",()-> new Item(new Item.Properties().food(ModFoodProperties.Spanakoruzo)));

   public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",()->new Item(new Item.Properties().food(ModFoodProperties.Tomato)));

   public static final RegistryObject<Item> Petrol = ITEMS.register("petrol",()->new FuelItem(new Item.Properties(),1600));

   public static final RegistryObject<Item> Soul = ITEMS.register("soul",()-> new Item(new Item.Properties().food(ModFoodProperties.SOUL)));
   public static final RegistryObject<Item> Soul2 = ITEMS.register("soul2",()-> new Item(new Item.Properties().food(ModFoodProperties.SOUL2)));
   public static final RegistryObject<Item> Soul3 = ITEMS.register("soul3",()-> new Item(new Item.Properties().food(ModFoodProperties.SOUL3)));
   public static final RegistryObject<Item> Soul4 = ITEMS.register("soul4",()-> new Item(new Item.Properties().food(ModFoodProperties.SOUL4)));
   public static final RegistryObject<Item> Soul5 = ITEMS.register("soul5",()-> new Item(new Item.Properties().food(ModFoodProperties.SOUL5)));

   public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword",()->new SwordItem(ModToolTiers.EMERALD,new Item.Properties()
           .attributes(SwordItem.createAttributes(ModToolTiers.EMERALD,3,-2.4f))));

   public static final RegistryObject<Item> Katana = ITEMS.register("katana",()->new KatanaItem(ModToolTiers.EMERALD,new Item.Properties().attributes(
           (KatanaItem.createAttributes(ModToolTiers.EMERALD,2,-1.2f)))));

   public static final RegistryObject<Item> GreenKatana = ITEMS.register("green_katana",()->new GreenKatanaItem(ModToolTiers.EMERALD,new Item.Properties().attributes(
           (GreenKatanaItem.createAttributes(ModToolTiers.EMERALD,3,-2.2f)))));

   public static final RegistryObject<Item> BlackKatana = ITEMS.register("black_katana",()->new BlackKatanaItem(ModToolTiers.EMERALD,new Item.Properties().attributes(
           (BlackKatanaItem.createAttributes(ModToolTiers.EMERALD,2,-2.8f)))));


   public static final RegistryObject<Item> RedKatana = ITEMS.register("red_katana",()->new RedKatanaItem(ModToolTiers.EMERALD,new Item.Properties().attributes(
           (RedKatanaItem.createAttributes(ModToolTiers.EMERALD,-2,-3.2f)))));

   public static final RegistryObject<Item> PinkKatana = ITEMS.register("pink_katana",()->new PinkKatanaItem(ModToolTiers.EMERALD,new Item.Properties().attributes(
           (PinkKatanaItem.createAttributes(ModToolTiers.EMERALD,-3,-0.7f)))));

   public static final RegistryObject<Item> OrangeKatana = ITEMS.register("orange_katana",()->new OrangeKatanaItem(ModToolTiers.EMERALD,new Item.Properties().attributes(
           (OrangeKatanaItem.createAttributes(ModToolTiers.EMERALD,0,-0.7f)))));

   public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe",()->new PickaxeItem(ModToolTiers.EMERALD,new Item.Properties()
           .attributes(PickaxeItem.createAttributes(ModToolTiers.EMERALD,1,-2.8f))));

   public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel",()->new ShovelItem(ModToolTiers.EMERALD,new Item.Properties()
           .attributes(ShovelItem.createAttributes(ModToolTiers.EMERALD,1.5f,-3.0f))));

   public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe",()->new AxeItem(ModToolTiers.EMERALD,new Item.Properties()
           .attributes(AxeItem.createAttributes(ModToolTiers.EMERALD,5,-3.2f))));

   public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe",()->new HoeItem(ModToolTiers.EMERALD,new Item.Properties()
           .attributes(HoeItem.createAttributes(ModToolTiers.EMERALD,0,-3f))));

   public static final RegistryObject<Item> RAINBOW_HAMMER = ITEMS.register("rainbow_hammer",()->new HammerItem(ModToolTiers.EMERALD,new Item.Properties().attributes(
           PickaxeItem.createAttributes(ModToolTiers.EMERALD,7,-3.4f) )));

   public static final RegistryObject<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet",()-> new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL
           , ArmorItem.Type.HELMET,new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(18))));

   public static final RegistryObject<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate",()-> new ModArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL
           , ArmorItem.Type.CHESTPLATE,new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(18))));

   public static final RegistryObject<Item> EMERALD_LEGGINS = ITEMS.register("emerald_leggins",()-> new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL
           , ArmorItem.Type.LEGGINGS,new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(18))));

   public static final RegistryObject<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots",()-> new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL
           , ArmorItem.Type.BOOTS,new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(18))));

   public static final RegistryObject<Item> EMERALD_HORSE_ARMOR = ITEMS.register("emerald_horse_armor",()->new AnimalArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL
   , AnimalArmorItem.BodyType.EQUESTRIAN,false,new Item.Properties().stacksTo(1)));

   public static final RegistryObject<Item> VAPE = ITEMS.register("vape",()-> new VapeItem(new Item.Properties()
           .food(ModFoodProperties.VAPE)));

   public static final RegistryObject<Item> PEACE_SMITHING_TEMPLATE = ITEMS.register("peace_armor_trim_smithing_template",()-> SmithingTemplateItem.
           createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(DiSpiderMod.MODID,"peace")));


   public static final RegistryObject<Item> EPIC_BOW = ITEMS.register("epic_bow",()->new ModBow(new Item.Properties().durability(500)));


   public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds",()-> new ItemNameBlockItem(ModBlocks.TOMATO_CROP.get(),new Item.Properties()));


   public static final RegistryObject<Item> MOONTALE_MUSIC_DISC = ITEMS.register("moontale_music_disc",()->new Item(new Item.Properties().jukeboxPlayable(ModSounds.Moontale_Key).stacksTo(1)));

   public static final RegistryObject<Item> Pokeball = ITEMS.register("pokeball",()-> new PokeballItem(new Item.Properties()));
   public static final RegistryObject<Item> SkeletonPokeball = ITEMS.register("skeleton_pokeball",()-> new SkeletonPokeballItem(new Item.Properties()));
   public static final RegistryObject<Item> ZombiePokeball = ITEMS.register("zombie_pokeball",()-> new ZombiePokeballItem(new Item.Properties()));
   public static final RegistryObject<Item> CreeperPokeball = ITEMS.register("creeper_pokeball",()-> new CreeperPokeballItem(new Item.Properties()));
   public static final RegistryObject<Item> SpiderPokeball = ITEMS.register("spider_pokeball",()-> new SpiderPokeballItem(new Item.Properties()));
   public static final RegistryObject<Item> SlimePokeball = ITEMS.register("slime_pokeball",()-> new SlimePokeballItem(new Item.Properties()));
   public static final RegistryObject<Item> Masterball = ITEMS.register("masterball",()-> new MasterBallItem(new Item.Properties()));
   public static final RegistryObject<Item> EnderDragonMasterball = ITEMS.register("ender_dragon_masterball",()-> new EnderDragonMasterBallItem(new Item.Properties()));
   public static final RegistryObject<Item> WitherMasterball = ITEMS.register("wither_masterball",()-> new WitherMasterBallItem(new Item.Properties()));




   public static void register(IEventBus eventbus){
      ITEMS.register(eventbus);
   }

}
