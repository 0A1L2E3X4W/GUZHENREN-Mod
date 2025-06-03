package com.alex.guzhenren.api.enums;

public enum ModPath {

    HEAVEN("guzhenren.path.heaven"),
    HUMAN("guzhenren.path.human"),
    RULE("guzhenren.path.rule"),

    FIRE("guzhenren.path.fire"),
    WATER("guzhenren.path.water"),
    ICE_SNOW("guzhenren.path.ice_snow"),
    WOOD("guzhenren.path.wood"),
    EARTH("guzhenren.path.earth"),
    METAL("guzhenren.path.metal"),
    DARK("guzhenren.path.dark"),
    LIGHT("guzhenren.path.light"),
    CLOUD("guzhenren.path.cloud"),
    MOON("guzhenren.path.moon"),
    SPACE("guzhenren.path.space"),
    TIME("guzhenren.path.time"),
    WIND("guzhenren.path.wind"),

    POWER("guzhenren.path.power"),
    QI("guzhenren.path.qi"),
    DREAM("guzhenren.path.dream"),
    ENSLAVEMENT("guzhenren.path.enslavement"),
    FORMATION("guzhenren.path.formation"),
    ILLUSION("guzhenren.path.illusion"),
    INFORMATION("guzhenren.path.information"),
    LUCK("guzhenren.path.luck"),
    PAINTING("guzhenren.path.painting"),
    REFINEMENT("guzhenren.path.refinement"),
    SOUND("guzhenren.path.sound"),
    THEFT("guzhenren.path.theft"),
    TRANSFORMATION("guzhenren.path.transformation"),
    BLADE("guzhenren.path.blade"),
    WISDOM("guzhenren.path.wisdom"),

    BLOOD("guzhenren.path.blood"),
    BONE("guzhenren.path.bone"),
    POISON("guzhenren.path.poison"),
    SOUL("guzhenren.path.soul"),
    KILLING("guzhenren.path.killing");

    private final String nameKey;
    ModPath(String key) { this.nameKey = key; }
    public String getNameKey() { return nameKey; }
}
