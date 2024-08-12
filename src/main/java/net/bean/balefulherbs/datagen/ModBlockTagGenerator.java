package net.bean.balefulherbs.datagen;

import net.bean.balefulherbs.block.ModBlocks;
import net.bean.balefulherbs.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider
{
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, net.bean.balefulherbs.BalefulHerbs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider)
    {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ModBlocks.IDONITE_ORE.get(),
                        ModBlocks.DEEPSLATE_IDONITE_ORE.get(),

                        ModBlocks.IDONITE_BLOCK.get()
                );


        //Mining tool related
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(
                        ModBlocks.IDONITE_ORE.get(),
                        ModBlocks.IDONITE_BLOCK.get()
                );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(
                        ModBlocks.DEEPSLATE_IDONITE_ORE.get()
                );

        /*
        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add();

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add();

         */


    }
}
