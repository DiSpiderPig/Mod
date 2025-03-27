package net.dispider.dispidermod.screen;

import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.screen.custom.GoldSmelterMenu;
import net.dispider.dispidermod.screen.custom.PrinterMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, DiSpiderMod.MODID);

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, MenuType.MenuSupplier<T> supplier) {
        return MENUS.register(name, () -> new MenuType(supplier, FeatureFlags.DEFAULT_FLAGS));
    }

    public static final  RegistryObject<MenuType<GoldSmelterMenu>> GOLD_SMELTER_MENU = MENUS.register("gold_smelter_name",()-> IForgeMenuType
            .create(GoldSmelterMenu::new));

     public static final RegistryObject<MenuType<GuideMenu>> GUIDE_MENU = registerMenuType("guide_menu",GuideMenu::new);


    public static final  RegistryObject<MenuType<PrinterMenu>> PRINTER_MENU = MENUS.register("printer_name",()-> IForgeMenuType.create(PrinterMenu::new));

    public static void register(IEventBus eventBus){
        MENUS.register(eventBus);
    }
}
