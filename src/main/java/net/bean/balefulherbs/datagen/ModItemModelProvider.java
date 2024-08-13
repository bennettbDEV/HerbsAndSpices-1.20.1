package net.bean.balefulherbs.datagen;

import net.bean.balefulherbs.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider
{
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, net.bean.balefulherbs.BalefulHerbs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        simpleItem(ModItems.MAOSTONE);
        simpleItem(ModItems.MEWSTONE);

        simpleItem(ModItems.IDONITE);
        simpleItem(ModItems.IDONITE_POWDER);
        simpleItem(ModItems.REFINED_IDONITE);

        simpleItem(ModItems.SILVER_SPEEDBERRY_SEEDS);
        simpleItem(ModItems.SILVER_SPEEDBERRY);
        simpleItem(ModItems.SILVER_SPEEDBERRY_POWDER);
        simpleItem(ModItems.REFINED_SILVER_SPEEDBERRY);

        simpleItem(ModItems.KEMP_SEEDS);
        simpleItem(ModItems.KEMP);
        simpleItem(ModItems.KEMP_POWDER);
        simpleItem(ModItems.REFINED_KEMP);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(net.bean.balefulherbs.BalefulHerbs.MOD_ID,"item/" + item.getId().getPath()));
    }
}
