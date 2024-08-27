package net.bean.balefulherbs.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods
{
    //Dur of 20 is about a second
    public static final int KEMP_EFFECT_DUR = 300;
    public static final int KEMP_POWDER_EFFECT_DUR = 500;
    public static final int REFINED_KEMP_EFFECT_DUR = 1200;

    public static final int SILVER_SPEEDBERRY_EFFECT_DUR = 300;
    public static final int SILVER_SPEEDBERRY_POWDER_EFFECT_DUR = 550;
    public static final int REFINED_SILVER_SPEEDBERRY_EFFECT_DUR = 1200;

    public static final int IDONITE_EFFECT_DUR = 450;
    public static final int IDONITE_POWDER_EFFECT_DUR = 600;
    public static final int REFINED_IDONITE_EFFECT_DUR = 1200;


    public static final FoodProperties SILVER_SPEEDBERRY = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, SILVER_SPEEDBERRY_EFFECT_DUR), 1.0f).alwaysEat().build();
    public static final FoodProperties SILVER_SPEEDBERRY_POWDER = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, SILVER_SPEEDBERRY_POWDER_EFFECT_DUR,1), 1.0f).alwaysEat().build();
    public static final FoodProperties REFINED_SILVER_SPEEDBERRY = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, REFINED_SILVER_SPEEDBERRY_EFFECT_DUR,3), 1.0f).alwaysEat().build();

    public static final FoodProperties KEMP = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, KEMP_EFFECT_DUR), 1.0f).alwaysEat().build();
    public static final FoodProperties KEMP_POWDER = new FoodProperties.Builder().nutrition(4).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, KEMP_POWDER_EFFECT_DUR,1), 1.0f).alwaysEat().build();
    public static final FoodProperties REFINED_KEMP = new FoodProperties.Builder().nutrition(3).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, REFINED_KEMP_EFFECT_DUR,4), 1.0f).alwaysEat().build();

    public static final FoodProperties IDONITE = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, IDONITE_EFFECT_DUR), 1.0f).alwaysEat().build();
    public static final FoodProperties IDONITE_POWDER = new FoodProperties.Builder().nutrition(4).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, IDONITE_POWDER_EFFECT_DUR,1), 1.0f).alwaysEat().build();
    public static final FoodProperties REFINED_IDONITE = new FoodProperties.Builder().nutrition(3).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, REFINED_IDONITE_EFFECT_DUR,4), 1.0f).alwaysEat().build();
}
