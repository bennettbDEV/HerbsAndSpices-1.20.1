package net.bean.balefulherbs.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags
{
    public static class Blocks
    {
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(net.bean.balefulherbs.BalefulHerbs.MOD_ID, name));
        }
    }

    public static class Items
    {
        public static final TagKey<Item> KEMP_ITEMS = tag("kemp_items");
        public static final TagKey<Item> SILVER_SPEEDBERRY_ITEMS = tag("silver_speedberry_items");
        public static final TagKey<Item> IDONITE_ITEMS = tag("idonite_items");


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(net.bean.balefulherbs.BalefulHerbs.MOD_ID, name));
        }
    }
}
