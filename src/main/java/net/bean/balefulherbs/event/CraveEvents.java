package net.bean.balefulherbs.event;

import net.bean.balefulherbs.BalefulHerbs;
import net.bean.balefulherbs.herbcraving.ModCapabilities;
import net.bean.balefulherbs.herbcraving.PlayerCrave;
import net.bean.balefulherbs.herbcraving.PlayerCraveProvider;
import net.bean.balefulherbs.item.ModFoods;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

@Mod.EventBusSubscriber(modid = BalefulHerbs.MOD_ID)
public class CraveEvents
{
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        ModCapabilities.registerCapabilities(event);
    }

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event)
    {
        if (event.getObject() instanceof Player) {
            event.addCapability(new ResourceLocation(BalefulHerbs.MOD_ID, "player_data"), new PlayerCraveProvider());
        }
    }


    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event)
    {
        HashMap<String, Integer> herbEffectDurHashMap = getHerbEffectDurHashMap();
        HashMap<String, MobEffectInstance> herbBadEffectHashMap = getHerbBadEffectHashMap();

        if (event.phase == TickEvent.Phase.END && !event.player.level().isClientSide())
        {
            event.player.getCapability(ModCapabilities.PLAYER_CRAVE_CAPABILITY).ifPresent(data ->
            {
                long currentTime = event.player.level().getGameTime();


                //Code for bad effects after good herb effect finishes
                String[] herbList = {"kemp","kemp_powder","refined_kemp","silver_speedberry","silver_speedberry_powder","refined_silver_speedberry",
                        "idonite","idonite_powder","refined_idonite"};
                for(String herbName: herbList)
                {
                    long herbConsumedTime = data.getConsumedTime(herbName);
                    if (herbConsumedTime > 0 && currentTime - herbConsumedTime >= herbEffectDurHashMap.get(herbName))
                    {
                        event.player.addEffect(new MobEffectInstance(herbBadEffectHashMap.get(herbName)));
                        data.setConsumedTime(herbName, 0);
                    }
                }

                //Crave levels
                

            });
        }
    }



    @NotNull
    private static HashMap<String, Integer> getHerbEffectDurHashMap() {
        HashMap<String, Integer> herbEffectDurHashMap = new HashMap<>();
        {
            herbEffectDurHashMap.put("kemp", ModFoods.KEMP_EFFECT_DUR);
            herbEffectDurHashMap.put("kemp_powder", ModFoods.KEMP_POWDER_EFFECT_DUR);
            herbEffectDurHashMap.put("refined_kemp", ModFoods.REFINED_KEMP_EFFECT_DUR);

            herbEffectDurHashMap.put("silver_speedberry", ModFoods.SILVER_SPEEDBERRY_EFFECT_DUR);
            herbEffectDurHashMap.put("silver_speedberry_powder", ModFoods.SILVER_SPEEDBERRY_POWDER_EFFECT_DUR);
            herbEffectDurHashMap.put("refined_silver_speedberry", ModFoods.REFINED_SILVER_SPEEDBERRY_EFFECT_DUR);

            herbEffectDurHashMap.put("idonite", ModFoods.IDONITE_EFFECT_DUR);
            herbEffectDurHashMap.put("idonite_powder", ModFoods.IDONITE_POWDER_EFFECT_DUR);
            herbEffectDurHashMap.put("refined_idonite", ModFoods.REFINED_IDONITE_EFFECT_DUR);
        }
        return herbEffectDurHashMap;
    }
    @NotNull
    private static HashMap<String, MobEffectInstance> getHerbBadEffectHashMap() {
        HashMap<String, MobEffectInstance> herbBadEffectHashMap = new HashMap<>();
        {
            herbBadEffectHashMap.put("kemp", PlayerCrave.badKempEffect);
            herbBadEffectHashMap.put("kemp_powder", PlayerCrave.badKempPowderEffect);
            herbBadEffectHashMap.put("refined_kemp", PlayerCrave.badRefinedKempEffect);

            herbBadEffectHashMap.put("silver_speedberry", PlayerCrave.badSilverSpeedberryEffect);
            herbBadEffectHashMap.put("silver_speedberry_powder", PlayerCrave.badSilverSpeedberryPowderEffect);
            herbBadEffectHashMap.put("refined_silver_speedberry", PlayerCrave.badRefinedSilverSpeedberryEffect);

            herbBadEffectHashMap.put("idonite", PlayerCrave.badIdoniteEffect);
            herbBadEffectHashMap.put("idonite_powder", PlayerCrave.badIdonitePowderEffect);
            herbBadEffectHashMap.put("refined_idonite", PlayerCrave.badRefinedIdoniteEffect);
        }
        return herbBadEffectHashMap;
    }

}
