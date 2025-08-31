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

    //羽毛味猫薄荷饼干
    public static final FoodComponent CATNIP_COOKIE_FOOD_WITH_FEATHER = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.8f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 600,2), 1.0F)
            .build();

    //木镐味猫薄荷饼干
    public static final FoodComponent CATNIP_COOKIE_FOOD_WITH_WOODEN_PICKAXE = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.8f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 600,9), 1.0F)
            .build();

    //木剑味猫薄荷饼干
    public static final FoodComponent CATNIP_COOKIE_FOOD_WITH_WOODEN_SWORD = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.8f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 600,9), 1.0F)
            .build();

    //木锹味猫薄荷饼干
    public static final FoodComponent CATNIP_COOKIE_FOOD_WITH_WOODEN_SHOVEL = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.8f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 600), 1.0F)
            .build();

    //风弹味猫薄荷饼干
    public static final FoodComponent CATNIP_COOKIE_FOOD_WITH_WIND_CHARGE = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.8f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 600,9), 1.0F)
            .build();

    //岩浆桶味猫薄荷饼干
    public static final FoodComponent CATNIP_COOKIE_FOOD_WITH_LAVA_BUCKET = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.8f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600), 1.0F)
            .build();

    //TNT味猫薄荷饼干
    //wind_charged->蓄风 --- 死亡后风爆
    public static final FoodComponent CATNIP_COOKIE_FOOD_WITH_TNT = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.8f)
            .alwaysEdible()
            .build();

}
