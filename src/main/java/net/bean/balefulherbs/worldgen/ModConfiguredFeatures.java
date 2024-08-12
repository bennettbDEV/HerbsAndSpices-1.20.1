package net.bean.balefulherbs.worldgen;

import net.bean.balefulherbs.BalefulHerbs;
import net.bean.balefulherbs.block.ModBlocks;
import net.bean.balefulherbs.block.custom.SilverSpeedBerryCropBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.InclusiveRange;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.DualNoiseProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

public class ModConfiguredFeatures
{
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_IDONITE_ORE_KEY = registerKey("idonite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_SPEEDBERRY_KEY = registerKey("silver_speedberry");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context)
    {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldIdoniteOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.IDONITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_IDONITE_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_IDONITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldIdoniteOres, 6));

        register(context, SILVER_SPEEDBERRY_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(50, 6, 2,
                        PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SILVER_SPEEDBERRY_CROP.get().defaultBlockState().setValue(SilverSpeedBerryCropBlock.AGE,4))))));

    }


    //Helper methods
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name)
    {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(BalefulHerbs.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration)
    {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }



}
