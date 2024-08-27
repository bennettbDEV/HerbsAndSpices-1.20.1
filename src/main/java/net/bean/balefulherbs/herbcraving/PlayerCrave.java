package net.bean.balefulherbs.herbcraving;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import java.util.HashMap;

public class PlayerCrave
{
    public static final int BAD_KEMP_EFFECT_DUR = 300;
    public static final int BAD_KEMP_POWDER_EFFECT_DUR = 500;
    public static final int BAD_REFINED_KEMP_EFFECT_DUR = 1200;

    public static final int BAD_SILVER_SPEEDBERRY_EFFECT_DUR = 300;
    public static final int BAD_SILVER_SPEEDBERRY_POWDER_EFFECT_DUR = 550;
    public static final int BAD_REFINED_SILVER_SPEEDBERRY_EFFECT_DUR = 1200;

    public static final int BAD_IDONITE_EFFECT_DUR = 450;
    public static final int BAD_IDONITE_POWDER_EFFECT_DUR = 600;
    public static final int BAD_REFINED_IDONITE_EFFECT_DUR = 1200;

    public static final MobEffectInstance badKempEffect = new MobEffectInstance(MobEffects.HUNGER, BAD_KEMP_EFFECT_DUR);
    public static final MobEffectInstance badKempPowderEffect = new MobEffectInstance(MobEffects.HUNGER, BAD_KEMP_POWDER_EFFECT_DUR, 1);
    public static final MobEffectInstance badRefinedKempEffect = new MobEffectInstance(MobEffects.HUNGER, BAD_REFINED_KEMP_EFFECT_DUR, 2);

    public static final MobEffectInstance badSilverSpeedberryEffect = new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, BAD_SILVER_SPEEDBERRY_EFFECT_DUR);
    public static final MobEffectInstance badSilverSpeedberryPowderEffect = new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, BAD_SILVER_SPEEDBERRY_POWDER_EFFECT_DUR, 1);
    public static final MobEffectInstance badRefinedSilverSpeedberryEffect = new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, BAD_REFINED_SILVER_SPEEDBERRY_EFFECT_DUR, 2);

    public static final MobEffectInstance badIdoniteEffect = new MobEffectInstance(MobEffects.WEAKNESS, BAD_IDONITE_EFFECT_DUR);
    public static final MobEffectInstance badIdonitePowderEffect = new MobEffectInstance(MobEffects.WEAKNESS, BAD_IDONITE_POWDER_EFFECT_DUR, 1);
    public static final MobEffectInstance badRefinedIdoniteEffect = new MobEffectInstance(MobEffects.WEAKNESS, BAD_REFINED_IDONITE_EFFECT_DUR, 2);

    HashMap<String, Long> hashMap = new HashMap<>();
    {
        hashMap.put("kemp", 0L);
        /*
        hashMap.put("kemp_powder", 0L);
        hashMap.put("refined_kemp", 0L);

        hashMap.put("silver_speedberry", 0L);
        hashMap.put("silver_speedberry_powder", 0L);
        hashMap.put("refined_silver_speedberry", 0L);

        hashMap.put("idonite", 0L);
        hashMap.put("idonite_powder", 0L);
        hashMap.put("refined_idonite", 0L);

         */
    }

    public void setConsumedTime(String key, long time) {
        this.hashMap.put(key, time);
    }

    public long getConsumedTime(String key) {
        return this.hashMap.get(key);
    }


}
