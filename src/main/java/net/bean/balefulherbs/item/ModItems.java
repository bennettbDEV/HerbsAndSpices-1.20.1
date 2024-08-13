package net.bean.balefulherbs.item;

import net.bean.balefulherbs.block.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, net.bean.balefulherbs.BalefulHerbs.MOD_ID);


    //New items
    public static final RegistryObject<Item> MEWSTONE = ITEMS.register("mewstone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAOSTONE = ITEMS.register("maostone",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> IDONITE = ITEMS.register("idonite",
            () -> new Item(new Item.Properties().food(ModFoods.IDONITE)));
    public static final RegistryObject<Item> IDONITE_POWDER = ITEMS.register("idonite_powder",
            () -> new Item(new Item.Properties().food(ModFoods.IDONITE_POWDER)));
    public static final RegistryObject<Item> REFINED_IDONITE = ITEMS.register("refined_idonite",
            () -> new Item(new Item.Properties().food(ModFoods.REFINED_IDONITE)));

    public static final RegistryObject<Item> SILVER_SPEEDBERRY = ITEMS.register("silver_speedberry",
            () -> new Item(new Item.Properties().food(ModFoods.SILVER_SPEEDBERRY)));
    public static final RegistryObject<Item> SILVER_SPEEDBERRY_POWDER = ITEMS.register("silver_speedberry_powder",
            () -> new Item(new Item.Properties().food(ModFoods.SILVER_SPEEDBERRY_POWDER)));
    public static final RegistryObject<Item> REFINED_SILVER_SPEEDBERRY = ITEMS.register("refined_silver_speedberry",
            () -> new Item(new Item.Properties().food(ModFoods.REFINED_SILVER_SPEEDBERRY)));

    public static final RegistryObject<Item> KEMP = ITEMS.register("kemp",
            () -> new Item(new Item.Properties().food(ModFoods.KEMP)));
    public static final RegistryObject<Item> KEMP_POWDER = ITEMS.register("kemp_powder",
            () -> new Item(new Item.Properties().food(ModFoods.KEMP_POWDER)));
    public static final RegistryObject<Item> REFINED_KEMP = ITEMS.register("refined_kemp",
            () -> new Item(new Item.Properties().food(ModFoods.REFINED_KEMP)));

    public static final RegistryObject<Item> SILVER_SPEEDBERRY_SEEDS = ITEMS.register("silver_speedberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SILVER_SPEEDBERRY_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> KEMP_SEEDS = ITEMS.register("kemp_seeds",
            () -> new ItemNameBlockItem(ModBlocks.KEMP_CROP.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
