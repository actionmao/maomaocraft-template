package com.actionmao.maomaocraft.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    //猫薄荷饼干的食物属性
    //nutrition -> 4点
    //饱食度 -> 4 * 0.8 * 2 = 6.4
    public static final FoodComponent CATNIP_COOKIE_FOOD = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.8f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 600), 0.5F)
            .build();
}
