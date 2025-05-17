package com.alex.guzhenren.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {

    public static final FoodComponent LIQUOR = new FoodComponent.Builder().hunger(1).saturationModifier(0.7F)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200), 0.6F)
            .build();
}
