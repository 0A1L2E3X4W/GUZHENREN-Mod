package com.alex.guzhenren.datagen;

import com.alex.guzhenren.block.ModBlocks;
import com.alex.guzhenren.effect.ModEffects;
import com.alex.guzhenren.item.ModItemGroups;
import com.alex.guzhenren.item.ModItems;
import com.alex.guzhenren.utils.enums.ModPath;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModLangZhCnProvider extends FabricLanguageProvider {

    public ModLangZhCnProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "zh_cn");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.PRIMEVAL_STONE, "元石");
        translationBuilder.add(ModItems.LIQUOR, "酒");
        translationBuilder.add(ModItems.FLOWER_BOAR_GU_1, "一转花豕蛊");
        translationBuilder.add(ModItems.WHITE_BOAR_GU_1, "一转白豕蛊");
        translationBuilder.add(ModItems.BLACK_BOAR_GU_1, "一转黑豕蛊");
        translationBuilder.add(ModItems.HOPE_GU, "希望蛊");

        translationBuilder.add(ModBlocks.PRIMEVAL_STONE_BLOCK, "原石块");
        translationBuilder.add(ModBlocks.PRIMEVAL_STONE_ORE, "原石矿");

        translationBuilder.add(ModItemGroups.GU_MATERIAL_GROUP, "蛊材");
        translationBuilder.add(ModItemGroups.GU_FOOD_GROUP, "食物类");
        translationBuilder.add(ModItemGroups.GU_GROUP, "凡蛊");

        translationBuilder.add(ModEffects.WHITE_BOAR_POWER, "白豕之力");
        translationBuilder.add(ModEffects.BLACK_BOAR_POWER, "黑豕之力");

        generateRankTranslations(translationBuilder);
        generatePathNameTranslations(translationBuilder);
        generateRealmsTranslations(translationBuilder);
        generateTalentTranslations(translationBuilder);
        generatedTenExtremePhysiqueTranslations(translationBuilder);

        generateScreenTextTranslation(translationBuilder);
    }

    private static void generateTalentTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("guzhenren.talent.a", "甲");
        translationBuilder.add("guzhenren.talent.b", "乙");
        translationBuilder.add("guzhenren.talent.c", "丙");
        translationBuilder.add("guzhenren.talent.d", "丁");
        translationBuilder.add("guzhenren.talent.ten_extreme", "十绝体");
        translationBuilder.add("guzhenren.talent.null", "凡人");
    }

    private static void generateRankTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("guzhenren.rank.mortal", "凡人");
        translationBuilder.add("guzhenren.rank.one_init", "一转初阶");
        translationBuilder.add("guzhenren.rank.one_mid", "一转中阶");
        translationBuilder.add("guzhenren.rank.one_upper", "一转高阶");
        translationBuilder.add("guzhenren.rank.one_peak", "一转巅峰");
    }

    private static void generatePathNameTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModPath.HEAVEN.getNameKey(), "天道");
        translationBuilder.add(ModPath.TIME.getNameKey(), "宙道");
        translationBuilder.add(ModPath.SPACE.getNameKey(), "宇道");
        translationBuilder.add(ModPath.HUMAN.getNameKey(), "人道");
        translationBuilder.add(ModPath.RULE.getNameKey(), "律道");

        translationBuilder.add(ModPath.EARTH.getNameKey(), "土道");
        translationBuilder.add(ModPath.WATER.getNameKey(), "水道");
        translationBuilder.add(ModPath.METAL.getNameKey(), "金道");
        translationBuilder.add(ModPath.WOOD.getNameKey(), "木道");
        translationBuilder.add(ModPath.ICE_SNOW.getNameKey(), "冰雪道");
        translationBuilder.add(ModPath.FIRE.getNameKey(), "炎道");
        translationBuilder.add(ModPath.DARK.getNameKey(), "暗道");
        translationBuilder.add(ModPath.LIGHT.getNameKey(), "光道");
        translationBuilder.add(ModPath.CLOUD.getNameKey(), "云道");
        translationBuilder.add(ModPath.MOON.getNameKey(), "月道");
        translationBuilder.add(ModPath.WIND.getNameKey(), "风道");
        translationBuilder.add(ModPath.QI.getNameKey(), "气道");

        translationBuilder.add(ModPath.POWER.getNameKey(), "力道");
        translationBuilder.add(ModPath.DREAM.getNameKey(), "梦道");
        translationBuilder.add(ModPath.ENSLAVEMENT.getNameKey(), "奴道");
        translationBuilder.add(ModPath.FORMATION.getNameKey(), "阵道");
        translationBuilder.add(ModPath.TRANSFORMATION.getNameKey(), "变化道");
        translationBuilder.add(ModPath.INFORMATION.getNameKey(), "信道");
        translationBuilder.add(ModPath.LUCK.getNameKey(), "运道");
        translationBuilder.add(ModPath.REFINEMENT.getNameKey(), "炼道");
        translationBuilder.add(ModPath.SOUND.getNameKey(), "音道");
        translationBuilder.add(ModPath.THEFT.getNameKey(), "偷道");
        translationBuilder.add(ModPath.BLADE.getNameKey(), "刃道");
        translationBuilder.add(ModPath.WISDOM.getNameKey(), "智道");

        translationBuilder.add(ModPath.KILLING.getNameKey(), "杀道");
        translationBuilder.add(ModPath.BLOOD.getNameKey(), "血道");
        translationBuilder.add(ModPath.POISON.getNameKey(), "毒道");
        translationBuilder.add(ModPath.SOUL.getNameKey(), "魂道");
    }

    private static void generateRealmsTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("guzhenren.title.ordinary", "无");
        translationBuilder.add("guzhenren.title.quasi_master", "准大师");
        translationBuilder.add("guzhenren.title.master", "大师");
        translationBuilder.add("guzhenren.title.quasi_grandmaster", "准宗师");
        translationBuilder.add("guzhenren.title.grandmaster", "宗师");
        translationBuilder.add("guzhenren.title.quasi_supreme_grandmaster", "准大宗师");
        translationBuilder.add("guzhenren.title.supreme_grandmaster", "无上大宗师");
    }

    private static void generatedTenExtremePhysiqueTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("guzhenren.extreme_physique.verdant_great_sun", "太日阳莽体");
        translationBuilder.add("guzhenren.extreme_physique.desolate_ancient_moon", "古月阴荒体");
        translationBuilder.add("guzhenren.extreme_physique.northern_dark_ice_soul", "北冥冰魄体");
        translationBuilder.add("guzhenren.extreme_physique.boundless_forest_samsara", "森海轮回体");
        translationBuilder.add("guzhenren.extreme_physique.blazing_glory_lightning_brilliance", "炎煌雷泽体");
        translationBuilder.add("guzhenren.extreme_physique.myriad_gold_wondrous_essence", "万金妙华体");
        translationBuilder.add("guzhenren.extreme_physique.great_strength_true_martial", "大力真武体");
        translationBuilder.add("guzhenren.extreme_physique.carefree_wisdom_heart", "逍遥智心体");
        translationBuilder.add("guzhenren.extreme_physique.central_earth_essence", "厚土元央体");
        translationBuilder.add("guzhenren.extreme_physique.universe_great_derivation", "宇宙大衍体");
        translationBuilder.add("guzhenren.extreme_physique.pure_dream_reality_seeker", "纯梦求真体");
        translationBuilder.add("guzhenren.extreme_physique.null", "无");
    }

    private static void generateScreenTextTranslation(TranslationBuilder translationBuilder) {
        translationBuilder.add("guzhenren.screen.title", "GUI");
        translationBuilder.add("guzhenren.screen.rank", "转数");
        translationBuilder.add("guzhenren.screen.moral", "道德");
        translationBuilder.add("guzhenren.screen.soul", "灵魂");
        translationBuilder.add("guzhenren.screen.talent", "资质");
        translationBuilder.add("guzhenren.screen.extreme_physique", "天资");
        translationBuilder.add("guzhenren.screen.essence", "真元");
        translationBuilder.add("guzhenren.screen.main_page_btn", "主页");
        translationBuilder.add("guzhenren.screen.path_page_btn", "道痕");
        translationBuilder.add("guzhenren.screen.realm_page_btn", "称号");
    }
}
