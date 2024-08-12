package net.bean.balefulherbs.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods
{
    public static final FoodProperties SILVER_SPEEDBERRY = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300), 1.0f).alwaysEat().build();
    public static final FoodProperties SILVER_SPEEDBERRY_POWDER = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300,1), 1.0f).alwaysEat().build();

    public static final FoodProperties KEMP = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300), 1.0f).alwaysEat().build();
    public static final FoodProperties KEMP_POWDER = new FoodProperties.Builder().nutrition(4).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300,1), 1.0f).alwaysEat().build();
}
