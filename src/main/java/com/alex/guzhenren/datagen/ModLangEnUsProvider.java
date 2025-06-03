package com.alex.guzhenren.datagen;

import com.alex.guzhenren.block.ModBlocks;
import com.alex.guzhenren.effect.ModEffects;
import com.alex.guzhenren.item.ModItemGroups;
import com.alex.guzhenren.item.ModItems;
import com.alex.guzhenren.utils.enums.*;
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
        translationBuilder.add(ModItems.FLOWER_BOAR_GU_1, "Flower Boar Gu - Rank 1");
        translationBuilder.add(ModItems.WHITE_BOAR_GU_1, "White Boar Gu - Rank 1");
        translationBuilder.add(ModItems.BLACK_BOAR_GU_1, "Black Boar Gu - Rank 1");
        translationBuilder.add(ModItems.HOPE_GU, "Hope Gu");

        translationBuilder.add(ModBlocks.PRIMEVAL_STONE_BLOCK, "Primeval Stone Block");
        translationBuilder.add(ModBlocks.PRIMEVAL_STONE_ORE, "Primeval Stone Ore");

        translationBuilder.add(ModItemGroups.GU_MATERIAL_GROUP, "Gu Material");
        translationBuilder.add(ModItemGroups.GU_FOOD_GROUP, "Mod Food");
        translationBuilder.add(ModItemGroups.GU_GROUP, "Mortal Gu");

        translationBuilder.add(ModEffects.WHITE_BOAR_POWER, "White Boar Strength");
        translationBuilder.add(ModEffects.BLACK_BOAR_POWER, "Black Boar Strength");

        generateRankTranslations(translationBuilder);
        generateRealmsTranslations(translationBuilder);
        generatePathNameTranslations(translationBuilder);
        generateTalentTranslations(translationBuilder);
        generatedTenExtremePhysiqueTranslations(translationBuilder);
        generateScreenTextTranslation(translationBuilder);
    }

    private static void generateTalentTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModGuMasterTalent.A.getNameKey(), "A");
        translationBuilder.add(ModGuMasterTalent.B.getNameKey(), "B");
        translationBuilder.add(ModGuMasterTalent.C.getNameKey(), "C");
        translationBuilder.add(ModGuMasterTalent.D.getNameKey(), "D");
        translationBuilder.add(ModGuMasterTalent.TEN_EXTREME.getNameKey(), "Ten Extreme Physique");
        translationBuilder.add(ModGuMasterTalent.NULL.getNameKey(), "Ordinary");
    }

    private static void generateRankTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModGuMasterRank.MORTAL.getNameKey(), "Mortal");

        translationBuilder.add(ModGuMasterRank.RANK_ONE_INIT.getNameKey(), "Rank One Init");
        translationBuilder.add(ModGuMasterRank.RANK_ONE_MID.getNameKey(), "Rank One Middle");
        translationBuilder.add(ModGuMasterRank.RANK_ONE_UPPER.getNameKey(), "Rank One Upper");
        translationBuilder.add(ModGuMasterRank.RANK_ONE_PEAK.getNameKey(), "Rank One Peak");
    }

    private static void generatePathNameTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModPath.HEAVEN.getNameKey(), "Heaven Path");
        translationBuilder.add(ModPath.TIME.getNameKey(), "Time Path");
        translationBuilder.add(ModPath.SPACE.getNameKey(), "Space Path");
        translationBuilder.add(ModPath.HUMAN.getNameKey(), "Human Path");
        translationBuilder.add(ModPath.RULE.getNameKey(), "Rule Path");

        translationBuilder.add(ModPath.EARTH.getNameKey(), "Earth Path");
        translationBuilder.add(ModPath.WATER.getNameKey(), "Water Path");
        translationBuilder.add(ModPath.METAL.getNameKey(), "Metal Path");
        translationBuilder.add(ModPath.WOOD.getNameKey(), "Wood Path");
        translationBuilder.add(ModPath.ICE_SNOW.getNameKey(), "Ice&Snow Path");
        translationBuilder.add(ModPath.FIRE.getNameKey(), "Fire Path");
        translationBuilder.add(ModPath.DARK.getNameKey(), "Dark Path");
        translationBuilder.add(ModPath.LIGHT.getNameKey(), "Light Path");
        translationBuilder.add(ModPath.CLOUD.getNameKey(), "Cloud Path");
        translationBuilder.add(ModPath.MOON.getNameKey(), "Moon Path");
        translationBuilder.add(ModPath.WIND.getNameKey(), "Wind Path");
        translationBuilder.add(ModPath.QI.getNameKey(), "QI Path");

        translationBuilder.add(ModPath.POWER.getNameKey(), "Power Path");
        translationBuilder.add(ModPath.DREAM.getNameKey(), "Dream Path");
        translationBuilder.add(ModPath.ENSLAVEMENT.getNameKey(), "Enslavement Path");
        translationBuilder.add(ModPath.FORMATION.getNameKey(), "Formation Path");
        translationBuilder.add(ModPath.TRANSFORMATION.getNameKey(), "Transformation Path");
        translationBuilder.add(ModPath.INFORMATION.getNameKey(), "Information Path");
        translationBuilder.add(ModPath.LUCK.getNameKey(), "Luck Path");
        translationBuilder.add(ModPath.REFINEMENT.getNameKey(), "Refinement Path");
        translationBuilder.add(ModPath.SOUND.getNameKey(), "Sound Path");
        translationBuilder.add(ModPath.THEFT.getNameKey(), "Theft Path");
        translationBuilder.add(ModPath.BLADE.getNameKey(), "Blade Path");
        translationBuilder.add(ModPath.WISDOM.getNameKey(), "Wisdom Path");

        translationBuilder.add(ModPath.KILLING.getNameKey(), "Killing Path");
        translationBuilder.add(ModPath.BLOOD.getNameKey(), "Blood Path");
        translationBuilder.add(ModPath.POISON.getNameKey(), "Poison Path");
        translationBuilder.add(ModPath.SOUL.getNameKey(), "Soul Path");
    }

    private static void generateRealmsTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModPathRealm.ORDINARY.getNameKey(), "Ordinary");
        translationBuilder.add(ModPathRealm.QUASI_MASTER.getNameKey(), "Quasi-Master");
        translationBuilder.add(ModPathRealm.MASTER.getNameKey(), "Master");
        translationBuilder.add(ModPathRealm.QUASI_GRANDMASTER.getNameKey(), "Quasi-GrandMaster");
        translationBuilder.add(ModPathRealm.GRANDMASTER.getNameKey(), "GrandMaster");
        translationBuilder.add(ModPathRealm.QUASI_SUPREME_GRANDMASTER.getNameKey(), "Quasi-Supreme-GrandMaster");
        translationBuilder.add(ModPathRealm.SUPREME_GRANDMASTER.getNameKey(), "Supreme-GrandMaster");
    }

    private static void generatedTenExtremePhysiqueTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModTenExtremePhysique.VERDANT_GREAT_SUN.getNameKey(), "Verdant Great Sun");
        translationBuilder.add(ModTenExtremePhysique.DESOLATE_ANCIENT_MOON.getNameKey(), "Desolate Ancient Moon");
        translationBuilder.add(ModTenExtremePhysique.NORTHERN_DARK_ICE_SOUL.getNameKey(), "Northern Dark Ice Soul");
        translationBuilder.add(ModTenExtremePhysique.BOUNDLESS_FOREST_SAMSARA.getNameKey(), "Boundless Forest Samsara");
        translationBuilder.add(ModTenExtremePhysique.BLAZING_GLORY_LIGHTNING_BRILLIANCE.getNameKey(), "Blazing Glory Lightning Brilliance");
        translationBuilder.add(ModTenExtremePhysique.MYRIAD_GOLD_WONDROUS_ESSENCE.getNameKey(), "Myriad Gold Wondrous Essence");
        translationBuilder.add(ModTenExtremePhysique.GREAT_STRENGTH_TRUE_MARTIAL.getNameKey(), "Great Strength True Martial");
        translationBuilder.add(ModTenExtremePhysique.CAREFREE_WISDOM_HEART.getNameKey(), "Carefree Wisdom Heart");
        translationBuilder.add(ModTenExtremePhysique.CENTRAL_EARTH_ESSENCE.getNameKey(), "Central Earth Essence");
        translationBuilder.add(ModTenExtremePhysique.UNIVERSE_GREAT_DERIVATION.getNameKey(), "Universe Great Derivation");
        translationBuilder.add(ModTenExtremePhysique.PURE_DREAM_REALITY_SEEKER.getNameKey(), "Pure Dream Reality Seeker");
        translationBuilder.add(ModTenExtremePhysique.NULL.getNameKey(), "None");
    }

    private static void generateScreenTextTranslation(TranslationBuilder translationBuilder) {
        translationBuilder.add("guzhenren.screen.title", "GUI");
        translationBuilder.add("guzhenren.screen.rank", "Rank");
        translationBuilder.add("guzhenren.screen.moral", "Moral");
        translationBuilder.add("guzhenren.screen.soul", "Soul");
        translationBuilder.add("guzhenren.screen.talent", "Talent");
        translationBuilder.add("guzhenren.screen.extreme_physique", "Extreme Physique");
        translationBuilder.add("guzhenren.screen.essence", "Primeval Essence");
        translationBuilder.add("guzhenren.screen.main_page_btn", "Main Page");
        translationBuilder.add("guzhenren.screen.path_page_btn", "Path Attainment");
        translationBuilder.add("guzhenren.screen.realm_page_btn", "Path Realms");
    }
}
