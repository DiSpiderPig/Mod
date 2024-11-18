package net.dispider.dispidermod.item;

import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.item.custom.FuelItem;
import net.dispider.dispidermod.item.custom.ModFoodProperties;
import net.dispider.dispidermod.item.custom.RugaItem;
import net.minecraft.world.item.DiscFragmentItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
   public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DiSpiderMod.EXAMPLEMOD);

   public static final RegistryObject<Item> Money = ITEMS.register("money",()->new Item((new Item.Properties())));

   public static final RegistryObject<Item> Bitcoin = ITEMS.register("bitcoin",()->new Item((new Item.Properties())));
   public static final RegistryObject<Item> Rainbow = ITEMS.register("rainbow",()->new Item((new Item.Properties())));

   public static final RegistryObject<Item> Ruga = ITEMS.register("ruga",()->new RugaItem(new Item.Properties().durability(8)));

   public static final RegistryObject<Item> Spanakoruzi = ITEMS.register("spanakoruzi",()-> new Item(new Item.Properties().food(ModFoodProperties.Spanakoruzo)));

   public static final RegistryObject<Item> Petrol = ITEMS.register("petrol",()->new FuelItem(new Item.Properties(),1600));


   public static void register(IEventBus eventbus){
      ITEMS.register(eventbus);
   }

}
