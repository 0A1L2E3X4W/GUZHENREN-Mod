package com.alex.guzhenren.datagen;

import com.alex.guzhenren.block.ModBlocks;
import com.alex.guzhenren.item.ModItemGroups;
import com.alex.guzhenren.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModZhCnLangProvider extends FabricLanguageProvider {

    public ModZhCnLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "zh_cn");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.PRIMEVAL_STONE, "原石");
        translationBuilder.add(ModItems.LIQUOR, "酒");

        translationBuilder.add(ModBlocks.PRIMEVAL_STONE_BLOCK, "原石块");
        translationBuilder.add(ModBlocks.PRIMEVAL_STONE_ORE, "原石矿");

        translationBuilder.add(ModItemGroups.GU_MATERIAL_GROUP, "蛊材");
        translationBuilder.add(ModItemGroups.GU_FOOD_GROUP, "食物类");
    }
}
