package net.dispider.dispidermod.item;

import net.dispider.dispidermod.DiSpiderMod;
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


   public static void register(IEventBus eventbus){
      ITEMS.register(eventbus);
   }

}
