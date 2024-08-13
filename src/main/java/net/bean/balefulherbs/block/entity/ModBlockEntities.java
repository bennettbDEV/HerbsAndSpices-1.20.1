package net.bean.balefulherbs.block.entity;

import net.bean.balefulherbs.BalefulHerbs;
import net.bean.balefulherbs.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities
{
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BalefulHerbs.MOD_ID);

    public static final RegistryObject<BlockEntityType<HerbPulveriserBlockEntity>> HERB_PULVERISER_BE =
            BLOCK_ENTITIES.register("herb_pulveriser_be", () ->
                    BlockEntityType.Builder.of(HerbPulveriserBlockEntity::new,
                            ModBlocks.HERB_PULVERISER.get()).build(null));
    public static final RegistryObject<BlockEntityType<HerbShaperBlockEntity>> HERB_SHAPER_BE =
            BLOCK_ENTITIES.register("herb_shaper_be", () ->
                    BlockEntityType.Builder.of(HerbShaperBlockEntity::new,
                            ModBlocks.HERB_SHAPER.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}