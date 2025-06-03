package com.alex.guzhenren.utils.enums;

public enum ModGuMasterTalent {

    A("guzhenren.talent.a"),
    B("guzhenren.talent.b"),
    C("guzhenren.talent.c"),
    D("guzhenren.talent.d"),
    TEN_EXTREME("guzhenren.talent.ten_extreme"),
    NULL("guzhenren.talent.null");

    private final String nameKey;
    ModGuMasterTalent(String key) { this.nameKey = key; }
    public String getNameKey() { return nameKey; }

    public static ModGuMasterTalent fromNameKey(String key) {
        for (ModGuMasterTalent talent : values()) {
            if (talent.nameKey.equals(key)) {
                return talent;
            }
        }
        return NULL;
    }
}
