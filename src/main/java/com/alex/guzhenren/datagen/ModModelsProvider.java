package com.alex.guzhenren.datagen;

import com.alex.guzhenren.block.ModBlocks;
import com.alex.guzhenren.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelsProvider extends FabricModelProvider {

    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PRIMEVAL_STONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LIQUOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.HUASHI_GU_1, Models.GENERATED);
        itemModelGenerator.register(ModItems.YUANLAO_GU_1, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOPE_GU, Models.GENERATED);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRIMEVAL_STONE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRIMEVAL_STONE_ORE);
    }
}
