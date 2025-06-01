package com.alex.guzhenren.api.enums;

public enum ModPlayerTalent {

    A("guzhenren.talent.a"),
    B("guzhenren.talent.b"),
    C("guzhenren.talent.c"),
    D("guzhenren.talent.d"),
    TEN_EXTREME("guzhenren.talent.ten_extreme"),
    NULL("guzhenren.talent.null");

    private final String nameKey;
    ModPlayerTalent(String key) { this.nameKey = key; }
    public String getNameKey() { return nameKey; }
}
