package net.bean.balefulherbs.datagen;

import net.bean.balefulherbs.BalefulHerbs;
import net.bean.balefulherbs.item.ModItems;
import net.bean.balefulherbs.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider
{
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, BalefulHerbs.MOD_ID);
    }

    @Override
    protected void start()
    {
        add("kemp_seeds_from_grass", new AddItemModifier(new LootItemCondition[]
                {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.08f).build()
                }, ModItems.KEMP_SEEDS.get()));
        /*
        add("item_from_creeper", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/creeper")).build(),
        }, ModItems.itemname.get()));

         */

        //Resource locations can be found in External Libraries/net.minecraft:client:extra:1.20.1/client-extra.jar/data/minecraft/loot_tables


    }
}