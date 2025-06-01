package com.alex.guzhenren.datagen;

import com.alex.guzhenren.block.ModBlocks;
import com.alex.guzhenren.item.ModItemGroups;
import com.alex.guzhenren.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModLangEnUsProvider extends FabricLanguageProvider {

    public ModLangEnUsProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.PRIMEVAL_STONE, "Primeval Stone");
        translationBuilder.add(ModItems.LIQUOR, "Liquor");
        translationBuilder.add(ModItems.HUASHI_GU_1, "Hua Zhi Gu - Rank 1");
        translationBuilder.add(ModItems.YUANLAO_GU_1, "Yuan Lao Gu - Rank 1");

        translationBuilder.add(ModBlocks.PRIMEVAL_STONE_BLOCK, "Primeval Stone Block");
        translationBuilder.add(ModBlocks.PRIMEVAL_STONE_ORE, "Primeval Stone Ore");

        translationBuilder.add(ModItemGroups.GU_MATERIAL_GROUP, "Gu Material");
        translationBuilder.add(ModItemGroups.GU_FOOD_GROUP, "Mod Food");
        translationBuilder.add(ModItemGroups.GU_GROUP, "Mortal Gu");

        generateRankTranslations(translationBuilder);
        generateRealmsTranslations(translationBuilder);
        generatePathNameTranslations(translationBuilder);

        generateScreenTextTranslation(translationBuilder);
    }

    private static void generateScreenTextTranslation(TranslationBuilder translationBuilder) {
        translationBuilder.add("guzhenren.screen.title", "GUI");
        translationBuilder.add("guzhenren.screen.moral", "Moral");
        translationBuilder.add("guzhenren.screen.talent", "Talent");
//        translationBuilder.add("guzhenren.screen.extreme_physique", "Extreme Physique");
    }

    private static void generateRankTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("guzhenren.rank.mortal", "Mortal");
        translationBuilder.add("guzhenren.rank.one", "Rank One");
        translationBuilder.add("guzhenren.rank.two", "Rank Two");
        translationBuilder.add("guzhenren.rank.three", "Rank Three");
        translationBuilder.add("guzhenren.rank.four", "Rank Four");
        translationBuilder.add("guzhenren.rank.five", "Rank Five");
        translationBuilder.add("guzhenren.rank.six", "Rank Six");
        translationBuilder.add("guzhenren.rank.seven", "Rank Seven");
        translationBuilder.add("guzhenren.rank.eight", "Rank Right");
        translationBuilder.add("guzhenren.rank.nine", "Rank Nine");
    }

    private static void generateRealmsTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("guzhenren.title.ordinary", "Ordinary");
        translationBuilder.add("guzhenren.title.quasi_master", "Quasi-Master");
        translationBuilder.add("guzhenren.title.master", "Master");
        translationBuilder.add("guzhenren.title.quasi_grandmaster", "Quasi-GrandMaster");
        translationBuilder.add("guzhenren.title.grandmaster", "GrandMaster");
        translationBuilder.add("guzhenren.title.quasi_supreme_grandmaster", "Quasi-Supreme-GrandMaster");
        translationBuilder.add("guzhenren.title.supreme_grandmaster", "Supreme-GrandMaster");
    }

    private static void generatePathNameTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("guzhenren.path.heaven", "Heaven Path");
        translationBuilder.add("guzhenren.path.earth", "Earth Path");
        translationBuilder.add("guzhenren.path.power", "Power Path");
        translationBuilder.add("guzhenren.path.killing", "Killing Path");
    }
}
