package net.bean.balefulherbs;

import com.mojang.logging.LogUtils;
import net.bean.balefulherbs.block.ModBlocks;
import net.bean.balefulherbs.block.entity.ModBlockEntities;
import net.bean.balefulherbs.item.ModCreativeModTabs;
import net.bean.balefulherbs.item.ModItems;
import net.bean.balefulherbs.loot.ModLootModifiers;
import net.bean.balefulherbs.recipe.ModRecipes;
import net.bean.balefulherbs.screen.HerbPulveriserScreen;
import net.bean.balefulherbs.screen.HerbShaperScreen;
import net.bean.balefulherbs.screen.ModMenuTypes;
import net.bean.balefulherbs.villager.ModVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BalefulHerbs.MOD_ID)
public class BalefulHerbs
{
    public static final String MOD_ID = "balefulherbs";
    public static final Logger LOGGER = LogUtils.getLogger();

    public BalefulHerbs()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModLootModifiers.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.IDONITE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(ModMenuTypes.HERB_PULVERISING_MENU.get(), HerbPulveriserScreen::new);
            MenuScreens.register(ModMenuTypes.HERB_SHAPING_MENU.get(), HerbShaperScreen::new);
        }
    }
}
