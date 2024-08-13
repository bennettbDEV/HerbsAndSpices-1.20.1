package net.bean.balefulherbs.datagen;

import net.bean.balefulherbs.BalefulHerbs;
import net.bean.balefulherbs.block.ModBlocks;
import net.bean.balefulherbs.block.custom.KempCropBlock;
import net.bean.balefulherbs.block.custom.SilverSpeedBerryCropBlock;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, net.bean.balefulherbs.BalefulHerbs.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        blockWithItem(ModBlocks.IDONITE_BLOCK);
        blockWithItem(ModBlocks.DEEPSLATE_IDONITE_ORE);
        blockWithItem(ModBlocks.IDONITE_ORE);

        simpleBlockWithItem(ModBlocks.HERB_PULVERISER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/herb_pulveriser")));
        simpleBlockWithItem(ModBlocks.HERB_SHAPER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/herb_shaper")));

        makeSilver_SpeedBerryCrop((CropBlock) ModBlocks.SILVER_SPEEDBERRY_CROP.get(), "silver_speedberry_stage", "silver_speedberry_stage");
        makeKempCrop((CropBlock) ModBlocks.KEMP_CROP.get(), "kemp_stage", "kemp_stage");

    }

    public void makeSilver_SpeedBerryCrop(CropBlock block, String modelName, String textureName)
    {
        Function<BlockState, ConfiguredModel[]> function = state -> silver_speedberryStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] silver_speedberryStates(BlockState state, CropBlock block, String modelName, String textureName)
    {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((SilverSpeedBerryCropBlock) block).getAgeProperty()),
                new ResourceLocation(BalefulHerbs.MOD_ID, "block/" + textureName + state.getValue(((SilverSpeedBerryCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }


    public void makeKempCrop(CropBlock block, String modelName, String textureName)
    {
        Function<BlockState, ConfiguredModel[]> function = state -> kempStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] kempStates(BlockState state, CropBlock block, String modelName, String textureName)
    {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(((KempCropBlock) block).getAgeProperty()),
                new ResourceLocation(BalefulHerbs.MOD_ID, "block/" + textureName + state.getValue(((KempCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
