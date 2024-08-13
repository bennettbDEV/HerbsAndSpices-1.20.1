package net.bean.balefulherbs.datagen;

import net.bean.balefulherbs.block.ModBlocks;
import net.bean.balefulherbs.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{

    private static final List<ItemLike> IDONITE_SMELTABLES = List.of(
            ModBlocks.IDONITE_ORE.get(),ModBlocks.DEEPSLATE_IDONITE_ORE.get());
    private static final List<ItemLike> MEWSTONE_SMELTABLE = List.of(
            ModItems.MEWSTONE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter)
    {
        oreSmelting(pWriter, IDONITE_SMELTABLES, RecipeCategory.MISC, ModItems.IDONITE.get(), 0.25f, 200, "idonite");
        oreBlasting(pWriter, IDONITE_SMELTABLES, RecipeCategory.MISC, ModItems.IDONITE.get(), 0.25f, 100, "idonite");

        oreSmelting(pWriter, MEWSTONE_SMELTABLE, RecipeCategory.MISC, ModItems.MAOSTONE.get(), 0.25f, 200, "maostone");
        oreBlasting(pWriter, MEWSTONE_SMELTABLE, RecipeCategory.MISC, ModItems.MAOSTONE.get(), 0.25f, 100, "maostone");

        //Shaped crafting for Idonite Block from idonite
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.IDONITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.IDONITE.get())
                .unlockedBy(getHasName(ModItems.IDONITE.get()), has(ModItems.IDONITE.get())) //Unlocks recipe in crafting book
                .save(pWriter);

        //Shaped crafting for Herb pulveriser
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.HERB_PULVERISER.get())
                .pattern("IKI")
                .pattern("CPC")
                .pattern("CCC")
                .define('I', Items.IRON_INGOT)
                .define('K', ModItems.KEMP.get())
                .define('C', Blocks.COBBLESTONE)
                .define('P', Items.IRON_PICKAXE)
                .unlockedBy(getHasName(ModItems.KEMP.get()), has(ModItems.KEMP.get()))
                .save(pWriter);

        //Shaped crafting for Herb shaper
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.HERB_SHAPER.get())
                .pattern("IDI")
                .pattern("CHC")
                .pattern("CCC")
                .define('I', Items.IRON_INGOT)
                .define('D', Items.DIAMOND)
                .define('C', Blocks.COBBLESTONE)
                .define('H', Items.IRON_HOE)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(pWriter);

        //Shapeless Crafting for Idonite from Idonite Block
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.IDONITE.get(), 9)
                .requires(ModBlocks.IDONITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.IDONITE_BLOCK.get()), has(ModBlocks.IDONITE_BLOCK.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName)
    {
        for(ItemLike itemlike : pIngredients)
        {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  net.bean.balefulherbs.BalefulHerbs.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
