package com.alex.guzhenren.datagen;

import com.alex.guzhenren.block.ModBlocks;
import com.alex.guzhenren.item.ModItemGroups;
import com.alex.guzhenren.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModLangZhCnProvider extends FabricLanguageProvider {

    public ModLangZhCnProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "zh_cn");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.PRIMEVAL_STONE, "原石");
        translationBuilder.add(ModItems.LIQUOR, "酒");
        translationBuilder.add(ModItems.HUASHI_GU_1, "一转花豕蛊");
        translationBuilder.add(ModItems.YUANLAO_GU_1, "一转元老蛊");

        translationBuilder.add(ModBlocks.PRIMEVAL_STONE_BLOCK, "原石块");
        translationBuilder.add(ModBlocks.PRIMEVAL_STONE_ORE, "原石矿");

        translationBuilder.add(ModItemGroups.GU_MATERIAL_GROUP, "蛊材");
        translationBuilder.add(ModItemGroups.GU_FOOD_GROUP, "食物类");
        translationBuilder.add(ModItemGroups.GU_GROUP, "凡蛊");

        generateRankTranslations(translationBuilder);
        generatePathNameTranslations(translationBuilder);
        generateRealmsTranslations(translationBuilder);

        generateScreenTextTranslation(translationBuilder);
    }

    private static void generateScreenTextTranslation(TranslationBuilder translationBuilder) {
        translationBuilder.add("guzhenren.screen.title", "GUI");
        translationBuilder.add("guzhenren.screen.moral", "道德");
        translationBuilder.add("guzhenren.screen.talent", "资质");
//        translationBuilder.add("guzhenren.screen.extreme_physique", "天资");
    }

    private static void generateRealmsTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("guzhenren.title.ordinary", "凡阶");
        translationBuilder.add("guzhenren.title.quasi_master", "准大师");
        translationBuilder.add("guzhenren.title.master", "大师");
        translationBuilder.add("guzhenren.title.quasi_grandmaster", "准宗师");
        translationBuilder.add("guzhenren.title.grandmaster", "宗师");
        translationBuilder.add("guzhenren.title.quasi_supreme_grandmaster", "准大宗师");
        translationBuilder.add("guzhenren.title.supreme_grandmaster", "大宗师");
    }

    private static void generateRankTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("guzhenren.rank.mortal", "凡人");
        translationBuilder.add("guzhenren.rank.one", "一转");
        translationBuilder.add("guzhenren.rank.two", "二转");
        translationBuilder.add("guzhenren.rank.three", "三转");
        translationBuilder.add("guzhenren.rank.four", "四转");
        translationBuilder.add("guzhenren.rank.five", "五转");
        translationBuilder.add("guzhenren.rank.six", "六转");
        translationBuilder.add("guzhenren.rank.seven", "七转");
        translationBuilder.add("guzhenren.rank.eight", "八转");
        translationBuilder.add("guzhenren.rank.nine", "九转");
    }

    private static void generatePathNameTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("guzhenren.path.heaven", "天道");
        translationBuilder.add("guzhenren.path.earth", "土道");
        translationBuilder.add("guzhenren.path.power", "力道");
        translationBuilder.add("guzhenren.path.killing", "杀道");
    }
}
