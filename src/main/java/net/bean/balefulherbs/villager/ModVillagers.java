package net.bean.balefulherbs.villager;

import com.google.common.collect.ImmutableSet;
import net.bean.balefulherbs.BalefulHerbs;
import net.bean.balefulherbs.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, BalefulHerbs.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, BalefulHerbs.MOD_ID);

    public static final RegistryObject<PoiType> OUTCAST_POI = POI_TYPES.register("outcast_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.HERB_PULVERISER.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> OUTCAST =
            VILLAGER_PROFESSIONS.register("outcast", () -> new VillagerProfession("outcast",
                    holder -> holder.get() == OUTCAST_POI.get(), holder -> holder.get() == OUTCAST_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_FARMER));


    public static void register(IEventBus eventBus)
    {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}