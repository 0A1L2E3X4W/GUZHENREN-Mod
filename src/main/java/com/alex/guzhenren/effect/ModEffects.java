package com.alex.guzhenren.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final StatusEffect WHITE_BOAR_POWER = new WhiteBoarPowerEffect();
    public static final StatusEffect BLACK_BOAR_POWER = new BlackBoarPowerEffect();

    public static void registerEffects() {
        Registry.register(Registries.STATUS_EFFECT, new Identifier("guzhenren", "white_boar_power"), WHITE_BOAR_POWER);
        Registry.register(Registries.STATUS_EFFECT, new Identifier("guzhenren", "black_boar_power"), BLACK_BOAR_POWER);
    }
}
