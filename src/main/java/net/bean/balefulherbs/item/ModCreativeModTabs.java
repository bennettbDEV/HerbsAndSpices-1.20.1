package net.bean.balefulherbs.item;

import net.bean.balefulherbs.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, net.bean.balefulherbs.BalefulHerbs.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register("balefulherbs_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MEWSTONE.get()))
                    .title(Component.translatable("creativetab.balefulherbs_tab"))
                    .displayItems((pParameters, pOutput) ->
                    {

                        pOutput.accept(ModItems.MEWSTONE.get());
                        pOutput.accept(ModItems.MAOSTONE.get());
                        pOutput.accept(ModItems.IDONITE.get());

                        pOutput.accept(ModBlocks.IDONITE_BLOCK.get());
                        pOutput.accept(ModBlocks.IDONITE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_IDONITE_ORE.get());

                        pOutput.accept(ModItems.SILVER_SPEEDBERRY.get());
                        pOutput.accept(ModItems.SILVER_SPEEDBERRY_POWDER.get());
                        pOutput.accept(ModItems.SILVER_SPEEDBERRY_SEEDS.get());
                        pOutput.accept(ModItems.KEMP.get());
                        pOutput.accept(ModItems.KEMP_POWDER.get());
                        pOutput.accept(ModItems.KEMP_SEEDS.get());

                        pOutput.accept(ModBlocks.HERB_PULVERISER.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
