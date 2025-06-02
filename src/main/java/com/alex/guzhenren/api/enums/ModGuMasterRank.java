package com.alex.guzhenren.api.enums;

public enum ModGuMasterRank {

    MORTAL("guzhenren.rank.mortal",0, "guzhenren.color.none", 0),

    RANK_ONE_INIT("guzhenren.rank.one_init", 1, "guzhenren.color.jade_green", 1),
    RANK_ONE_MID("guzhenren.rank.one_mid", 1, "guzhenren.color.pale_green", 2),
    RANK_ONE_UPPER("guzhenren.rank.one_upper", 1, "guzhenren.color.dark_green", 4),
    RANK_ONE_PEAK("guzhenren.rank.one_peak", 1, "guzhenren.color.black_green", 8);

    private final String nameKey;
    private final int rank;
    private final String essenceColor;
    private final int essenceModifier;

    ModGuMasterRank(String key, int v, String colorKey, int modifier) {
        this.nameKey = key;
        this.rank = v;
        this.essenceColor = colorKey;
        this.essenceModifier = modifier;
    }

    public String getNameKey() { return nameKey; }
    public String getEssenceColor() { return essenceColor; }
    public int getEssenceModifier() { return essenceModifier; }
    public int getRank() { return rank; }

    public static ModGuMasterRank fromNameKey(String key) {
        for (ModGuMasterRank rank : values()) {
            if (rank.nameKey.equals(key)) {
                return rank;
            }
        }
        return MORTAL;
    }
}
