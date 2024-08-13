package net.bean.balefulherbs.datagen.loot;

import net.bean.balefulherbs.block.ModBlocks;
import net.bean.balefulherbs.block.custom.KempCropBlock;
import net.bean.balefulherbs.block.custom.SilverSpeedBerryCropBlock;
import net.bean.balefulherbs.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        //Normal blocks
        this.dropSelf(ModBlocks.IDONITE_BLOCK.get());
        this.dropSelf(ModBlocks.HERB_PULVERISER.get());
        this.dropSelf(ModBlocks.HERB_SHAPER.get());

        //Ores
        this.add(ModBlocks.IDONITE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.IDONITE_ORE.get(), ModItems.IDONITE.get()));
        this.add(ModBlocks.DEEPSLATE_IDONITE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_IDONITE_ORE.get(), ModItems.IDONITE.get()));

        //Crops
        //Remember to look at VanillaBlockLoot class to see how its done in vanilla
        // .gradle\caches\forge_gradle\minecraft_user_repo\net\minecraftforge\forge\1.20.1-47.3.5_mapped_parchment_2023.06.26-1.20.1\forge-1.20.1-47.3.5_mapped_parchment_2023.06.26-1.20.1-recomp.jar!\net\minecraft\data\loot\packs\VanillaBlockLoot.class
        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.SILVER_SPEEDBERRY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SilverSpeedBerryCropBlock.AGE, 4));

        this.add(ModBlocks.SILVER_SPEEDBERRY_CROP.get(), createCropDrops(ModBlocks.SILVER_SPEEDBERRY_CROP.get(), ModItems.SILVER_SPEEDBERRY.get(),
                ModItems.SILVER_SPEEDBERRY_SEEDS.get(), lootitemcondition$builder));

        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.KEMP_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(KempCropBlock.AGE, 6))
                .or(LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(ModBlocks.KEMP_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(KempCropBlock.AGE, 5)));

        this.add(ModBlocks.KEMP_CROP.get(), createCropDrops(ModBlocks.KEMP_CROP.get(), ModItems.KEMP.get(),
                ModItems.KEMP_SEEDS.get(), lootitemcondition$builder2));

    }



    //Private method to get loot table for ore like copper
    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
