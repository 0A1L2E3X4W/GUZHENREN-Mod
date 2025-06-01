package com.alex.guzhenren.api.enums;

public enum ModRank {

    MORTAL("guzhenren.rank.mortal"),
    RANK_ONE("guzhenren.rank.one"),
    RANK_TWO("guzhenren.rank.two"),
    RANK_THREE("guzhenren.rank.three"),
    RANK_FOUR("guzhenren.rank.four"),
    RANK_FIVE("guzhenren.rank.five"),
    RANK_SIX("guzhenren.rank.six"),
    RANK_SEVEN("guzhenren.rank.seven"),
    RANK_EIGHT("guzhenren.rank.eight"),
    RANK_NINE("guzhenren.rank.nine");

    private final String nameKey;
    ModRank(String key) { this.nameKey = key; }
    public String getNameKey() { return nameKey; }
}
