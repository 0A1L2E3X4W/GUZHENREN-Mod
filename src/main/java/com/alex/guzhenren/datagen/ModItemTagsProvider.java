package com.alex.guzhenren.datagen;

import com.alex.guzhenren.item.ModItemTags;
import com.alex.guzhenren.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagsProvider(FabricDataOutput output,
                               CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModItemTags.SUGAR_INGREDIENTS)
                .add(Items.BEETROOT);

        getOrCreateTagBuilder(ModItemTags.GU_MATERIALS)
                .add(ModItems.PRIMEVAL_STONE)
                .add(ModItems.LIQUOR);
    }
}
