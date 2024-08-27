package net.bean.balefulherbs.event;


import net.bean.balefulherbs.BalefulHerbs;
import net.bean.balefulherbs.herbcraving.ModCapabilities;
import net.bean.balefulherbs.herbcraving.PlayerCrave;
import net.bean.balefulherbs.herbcraving.PlayerCraveProvider;
import net.bean.balefulherbs.item.ModFoods;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

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
        if (event.phase == TickEvent.Phase.END && !event.player.level().isClientSide())
        {
            event.player.getCapability(ModCapabilities.PLAYER_CRAVE_CAPABILITY).ifPresent(data ->
            {
                long currentTime = event.player.level().getGameTime();

                //Kemp
                long kempConsumedTime = data.getConsumedTime("kemp");
                if (kempConsumedTime > 0 && currentTime - kempConsumedTime >= ModFoods.KEMP_EFFECT_DUR) {
                    event.player.addEffect(new MobEffectInstance(PlayerCrave.badKempEffect));
                    data.setConsumedTime("kemp",0);
                }
                /*
                long kempPowderConsumedTime = data.getConsumedTime("kemp_powder");
                if (kempPowderConsumedTime > 0 && currentTime - kempPowderConsumedTime >= ModFoods.KEMP_POWDER_EFFECT_DUR) {
                    event.player.addEffect(new MobEffectInstance(PlayerCrave.badKempPowderEffect));
                    data.setConsumedTime("kemp_powder",0);
                }
                long refinedKempConsumedTime = data.getConsumedTime("refined_kemp");
                if (refinedKempConsumedTime > 0 && currentTime - refinedKempConsumedTime >= ModFoods.REFINED_KEMP_EFFECT_DUR) {
                    event.player.addEffect(new MobEffectInstance(PlayerCrave.badRefinedKempEffect));
                    data.setConsumedTime("refined_kemp",0);
                }

                //Speedberry
                long speedberryConsumedTime = data.getConsumedTime("silver_speedberry");
                if (speedberryConsumedTime > 0 && currentTime - speedberryConsumedTime >= ModFoods.SILVER_SPEEDBERRY_EFFECT_DUR) {
                    event.player.addEffect(new MobEffectInstance(PlayerCrave.badSilverSpeedberryEffect));
                    data.setConsumedTime("silver_speedberry",0);
                }
                long speedberryPowderConsumedTime = data.getConsumedTime("silver_speedberry_powder");
                if (speedberryPowderConsumedTime > 0 && currentTime - speedberryPowderConsumedTime >= ModFoods.SILVER_SPEEDBERRY_POWDER_EFFECT_DUR) {
                    event.player.addEffect(new MobEffectInstance(PlayerCrave.badSilverSpeedberryPowderEffect));
                    data.setConsumedTime("silver_speedberry_powder",0);
                }
                long refinedSpeedberryConsumedTime = data.getConsumedTime("silver_speedberry");
                if (refinedSpeedberryConsumedTime > 0 && currentTime - refinedSpeedberryConsumedTime >= ModFoods.REFINED_SILVER_SPEEDBERRY_EFFECT_DUR) {
                    event.player.addEffect(new MobEffectInstance(PlayerCrave.badRefinedSilverSpeedberryEffect));
                    data.setConsumedTime("refined_silver_speedberry",0);
                }

                 */
            });
        }
    }


}
