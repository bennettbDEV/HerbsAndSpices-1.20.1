package net.bean.balefulherbs.screen;

import net.bean.balefulherbs.BalefulHerbs;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes
{
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, BalefulHerbs.MOD_ID);

    public static final RegistryObject<MenuType<HerbPulveriserMenu>> HERB_PULVERISING_MENU =
            registerMenuType("herb_pulverising_menu", HerbPulveriserMenu::new);
    public static final RegistryObject<MenuType<HerbShaperMenu>> HERB_SHAPING_MENU =
            registerMenuType("herb_shaping_menu", HerbShaperMenu::new);


    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }

}