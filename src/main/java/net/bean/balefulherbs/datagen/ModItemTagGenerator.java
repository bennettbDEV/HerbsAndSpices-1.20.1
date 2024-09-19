package net.bean.balefulherbs.datagen;

import net.bean.balefulherbs.item.ModItems;
import net.bean.balefulherbs.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider
{
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, net.bean.balefulherbs.BalefulHerbs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider)
    {
        this.tag(ModTags.Items.KEMP_ITEMS)
                .add(ModItems.KEMP.get(),
                        ModItems.KEMP_POWDER.get(),
                        ModItems.REFINED_KEMP.get()
                );
        this.tag(ModTags.Items.SILVER_SPEEDBERRY_ITEMS)
                .add(ModItems.SILVER_SPEEDBERRY.get(),
                        ModItems.SILVER_SPEEDBERRY_POWDER.get(),
                        ModItems.REFINED_SILVER_SPEEDBERRY.get()
                );
        this.tag(ModTags.Items.IDONITE_ITEMS)
                .add(ModItems.IDONITE.get(),
                        ModItems.IDONITE_POWDER.get(),
                        ModItems.REFINED_IDONITE.get()
                );
    }
}
