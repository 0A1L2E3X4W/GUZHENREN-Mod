package com.alex.guzhenren.datagen;

import com.alex.guzhenren.block.ModBlockTags;
import com.alex.guzhenren.block.ModBlocks;
import com.alex.guzhenren.item.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagsProvider(FabricDataOutput output,
                                CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        // Mineable
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.PRIMEVAL_STONE_BLOCK)
                .add(ModBlocks.PRIMEVAL_STONE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.PRIMEVAL_STONE_BLOCK)
                .add(ModBlocks.PRIMEVAL_STONE_ORE);

        // Tags
        getOrCreateTagBuilder(ModBlockTags.GUZHENREN_ORE)
                .add(ModBlocks.PRIMEVAL_STONE_ORE);

        getOrCreateTagBuilder(ModBlockTags.GUZHENREN_BUILDING_BLOCK)
                .add(ModBlocks.PRIMEVAL_STONE_BLOCK);
    }
}
