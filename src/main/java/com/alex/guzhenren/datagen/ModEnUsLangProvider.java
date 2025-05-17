package com.alex.guzhenren.datagen;

import com.alex.guzhenren.block.ModBlocks;
import com.alex.guzhenren.item.ModItemGroups;
import com.alex.guzhenren.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModEnUsLangProvider extends FabricLanguageProvider {

    public ModEnUsLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.PRIMEVAL_STONE, "Primeval Stone");
        translationBuilder.add(ModItems.LIQUOR, "Liquor");

        translationBuilder.add(ModItems.HUASHI_GU_1, "Hua Zhi Gu");
        translationBuilder.add(ModItems.YUANLAO_GU_1, "Yuan Lao Gu");

        translationBuilder.add(ModBlocks.PRIMEVAL_STONE_BLOCK, "Primeval Stone Block");
        translationBuilder.add(ModBlocks.PRIMEVAL_STONE_ORE, "Primeval Stone Ore");

        translationBuilder.add(ModItemGroups.GU_MATERIAL_GROUP, "Gu Material");
        translationBuilder.add(ModItemGroups.GU_FOOD_GROUP, "Mod Food");
        translationBuilder.add(ModItemGroups.GU_GROUP, "Gu");
    }
}
