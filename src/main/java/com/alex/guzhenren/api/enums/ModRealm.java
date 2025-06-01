package com.alex.guzhenren.api.enums;

public enum ModRealm {

    ORDINARY("guzhenren.title.ordinary"),
    QUASI_MASTER("guzhenren.title.master"),
    MASTER("guzhenren.title.quasi_master"),
    QUASI_GRANDMASTER("guzhenren.title.quasi_grandmaster"),
    GRANDMASTER("guzhenren.title.grandmaster"),
    QUASI_SUPREME_GRANDMASTER("guzhenren.title.quadi_supreme_grandmaster"),
    SUPREME_GRANDMASTER("guzhenren.title.supreme_grandmaster");

    private final String nameKey;
    ModRealm(String key) { this.nameKey = key; }
    public String getNameKey() { return nameKey; }
}
