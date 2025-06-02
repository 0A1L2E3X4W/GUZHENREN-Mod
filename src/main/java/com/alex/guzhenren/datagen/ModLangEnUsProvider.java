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
        translationBuilder.add(ModItems.HOPE_GU, "Hope Gu");

        translationBuilder.add(ModBlocks.PRIMEVAL_STONE_BLOCK, "Primeval Stone Block");
        translationBuilder.add(ModBlocks.PRIMEVAL_STONE_ORE, "Primeval Stone Ore");

        translationBuilder.add(ModItemGroups.GU_MATERIAL_GROUP, "Gu Material");
        translationBuilder.add(ModItemGroups.GU_FOOD_GROUP, "Mod Food");
        translationBuilder.add(ModItemGroups.GU_GROUP, "Mortal Gu");

        generateRankTranslations(translationBuilder);
        generateRealmsTranslations(translationBuilder);
        generatePathNameTranslations(translationBuilder);
        generateTalentTranslations(translationBuilder);
        generatedTenExtremePhysiqueTranslations(translationBuilder);

        generateScreenTextTranslation(translationBuilder);
    }

    private static void generateTalentTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("guzhenren.talent.a", "A");
        translationBuilder.add("guzhenren.talent.b", "B");
        translationBuilder.add("guzhenren.talent.c", "C");
        translationBuilder.add("guzhenren.talent.d", "D");
        translationBuilder.add("guzhenren.talent.ten_extreme", "Ten Extreme Physique");
        translationBuilder.add("guzhenren.talent.null", "Ordinary");
    }

    private static void generateScreenTextTranslation(TranslationBuilder translationBuilder) {
        translationBuilder.add("guzhenren.screen.title", "GUI");
        translationBuilder.add("guzhenren.screen.rank", "Rank");
        translationBuilder.add("guzhenren.screen.moral", "Moral");
        translationBuilder.add("guzhenren.screen.talent", "Talent");
        translationBuilder.add("guzhenren.screen.extreme_physique", "Extreme Physique");
    }

    private static void generateRankTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("guzhenren.rank.mortal", "Mortal");

        translationBuilder.add("guzhenren.rank.one_init", "Rank One Init");
        translationBuilder.add("guzhenren.rank.one_mid", "Rank One Middle");
        translationBuilder.add("guzhenren.rank.one_upper", "Rank One Upper");
        translationBuilder.add("guzhenren.rank.one_peak", "Rank One Peak");
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

    private static void generatedTenExtremePhysiqueTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("guzhenren.extreme_physique.verdant_great_sun", "Verdant Great Sun");
        translationBuilder.add("guzhenren.extreme_physique.desolate_ancient_moon", "Desolate Ancient Moon");
        translationBuilder.add("guzhenren.extreme_physique.northern_dark_ice_soul", "Northern Dark Ice Soul");
        translationBuilder.add("guzhenren.extreme_physique.boundless_forest_samsara", "Boundless Forest Samsara");
        translationBuilder.add("guzhenren.extreme_physique.blazing_glory_lightning_brilliance", "Blazing Glory Lightning Brilliance");
        translationBuilder.add("guzhenren.extreme_physique.myriad_gold_wondrous_essence", "Myriad Gold Wondrous Essence");
        translationBuilder.add("guzhenren.extreme_physique.great_strength_true_martial", "Great Strength True Martial");
        translationBuilder.add("guzhenren.extreme_physique.carefree_wisdom_heart", "Carefree Wisdom Heart");
        translationBuilder.add("guzhenren.extreme_physique.central_earth_essence", "Central Earth Essence");
        translationBuilder.add("guzhenren.extreme_physique.universe_great_derivation", "Universe Great Derivation");
        translationBuilder.add("guzhenren.extreme_physique.pure_dream_reality_seeker", "Pure Dream Reality Seeker");
        translationBuilder.add("guzhenren.extreme_physique.null", "None");
    }
}
