package com.alex.guzhenren.api.enums;

public enum ModPathRealm {

    ORDINARY("guzhenren.title.ordinary"),
    QUASI_MASTER("guzhenren.title.master"),
    MASTER("guzhenren.title.quasi_master"),
    QUASI_GRANDMASTER("guzhenren.title.quasi_grandmaster"),
    GRANDMASTER("guzhenren.title.grandmaster"),
    QUASI_SUPREME_GRANDMASTER("guzhenren.title.quadi_supreme_grandmaster"),
    SUPREME_GRANDMASTER("guzhenren.title.supreme_grandmaster");

    private final String nameKey;
    ModPathRealm(String key) { this.nameKey = key; }
    public String getNameKey() { return nameKey; }

    public static ModPathRealm fromNameKey(String key) {
        for (ModPathRealm realm : values()) {
            if (realm.nameKey.equals(key)) {
                return realm;
            }
        }
        return ORDINARY;
    }
}
