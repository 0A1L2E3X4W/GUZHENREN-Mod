package com.alex.guzhenren.utils.enums;

public enum ModPath {

    HEAVEN("guzhenren.path.heaven", "heaven"),
    SPACE("guzhenren.path.space", "space"),
    TIME("guzhenren.path.time", "time"),

    HUMAN("guzhenren.path.human", "human"),
    RULE("guzhenren.path.rule", "rule"),

    QI("guzhenren.path.qi", "qi"),
    FIRE("guzhenren.path.fire", "fire"),
    WATER("guzhenren.path.water", "water"),
    ICE_SNOW("guzhenren.path.ice_snow", "ice_snow"),
    WOOD("guzhenren.path.wood", "wood"),
    EARTH("guzhenren.path.earth", "earth"),
    METAL("guzhenren.path.metal", "metal"),
    LIGHT("guzhenren.path.light", "light"),
    DARK("guzhenren.path.dark", "dark"),
    CLOUD("guzhenren.path.cloud", "cloud"),
    WIND("guzhenren.path.wind","wind"),
    SOUND("guzhenren.path.sound", "sound"),
    MOON("guzhenren.path.moon", "moon"),

    POWER("guzhenren.path.power", "power"),
    WISDOM("guzhenren.path.wisdom", "wisdom"),
    ENSLAVEMENT("guzhenren.path.enslavement", "enslavement"),
    FORMATION("guzhenren.path.formation", "formation"),
    INFORMATION("guzhenren.path.information", "information"),
    REFINEMENT("guzhenren.path.refinement", "refinement"),
    TRANSFORMATION("guzhenren.path.transformation", "transformation"),
    BLADE("guzhenren.path.blade", "blade"),
    LUCK("guzhenren.path.luck", "luck"),
    THEFT("guzhenren.path.theft", "theft"),
    DREAM("guzhenren.path.dream", "dream"),

    BLOOD("guzhenren.path.blood", "blood"),
    POISON("guzhenren.path.poison", "poison"),
    SOUL("guzhenren.path.soul", "soul"),
    KILLING("guzhenren.path.killing", "killing");

    private final String nameKey;
    private final String name;
    ModPath(String key, String name) { this.nameKey = key; this.name = name; }
    public String getNameKey() { return nameKey; }
    public String getName() { return this.name; }
}
