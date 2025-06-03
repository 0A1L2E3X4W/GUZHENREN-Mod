package com.alex.guzhenren.utils.enums;

public enum ModGuMasterTitle {
    LONE_CULTIVATOR("guzhenren.title.lone_cultivator"),
    RIGHTEOUS_PATH("guzhenren.title.righteous_path"),
    DEMONIC_PATH("guzhenren.title.demonic_path");

    private final String nameKey;
    ModGuMasterTitle(String key) { this.nameKey = key; };
    public String getNameKey() { return nameKey; }
}
