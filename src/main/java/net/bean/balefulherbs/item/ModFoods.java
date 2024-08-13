package net.bean.balefulherbs.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods
{
    public static final FoodProperties SILVER_SPEEDBERRY = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300), 1.0f).alwaysEat().build();
    public static final FoodProperties SILVER_SPEEDBERRY_POWDER = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 450,1), 1.0f).alwaysEat().build();
    public static final FoodProperties REFINED_SILVER_SPEEDBERRY = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600,3), 1.0f).alwaysEat().build();

    public static final FoodProperties KEMP = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300), 1.0f).alwaysEat().build();
    public static final FoodProperties KEMP_POWDER = new FoodProperties.Builder().nutrition(4).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 450,1), 1.0f).alwaysEat().build();
    public static final FoodProperties REFINED_KEMP = new FoodProperties.Builder().nutrition(3).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600,4), 1.0f).alwaysEat().build();

    public static final FoodProperties IDONITE = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 450), 1.0f).alwaysEat().build();
    public static final FoodProperties IDONITE_POWDER = new FoodProperties.Builder().nutrition(4).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600,1), 1.0f).alwaysEat().build();
    public static final FoodProperties REFINED_IDONITE = new FoodProperties.Builder().nutrition(3).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1000,4), 1.0f).alwaysEat().build();
}
