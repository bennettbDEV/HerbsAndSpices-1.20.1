package net.bean.balefulherbs.recipe;

import net.bean.balefulherbs.BalefulHerbs;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes
{
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, BalefulHerbs.MOD_ID);

    public static final RegistryObject<RecipeSerializer<HerbPulverisingRecipe>> HERB_PULVERISING_SERIALIZER =
            SERIALIZERS.register("herb_pulverising", () -> HerbPulverisingRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<HerbShapingRecipe>> HERB_SHAPING_SERIALIZER =
            SERIALIZERS.register("herb_shaping", () -> HerbShapingRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
