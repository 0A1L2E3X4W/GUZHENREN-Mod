package com.alex.guzhenren.block;

import com.alex.guzhenren.Guzhenren;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    /*DEFINE MOD BLOCKS*/
    public static final Block PRIMEVAL_STONE_BLOCK =
            register("primeval_stone_block", new Block(AbstractBlock.Settings.copy(Blocks.COAL_BLOCK)));
    public static final Block PRIMEVAL_STONE_ORE =
            register("primeval_stone_ore", new ExperienceDroppingBlock(
                    AbstractBlock.Settings.create().requiresTool().strength(3.0F, 3.0F),
                    UniformIntProvider.create(0, 2)));

    /*Minecraft Methods*/
    public static Block register(String id, Block block) {
        registerBlockItems(id, block);
        return Registry.register(Registries.BLOCK, new Identifier(Guzhenren.MOD_ID, id), block);
    }

    /*MOD METHODS*/
    public static void registerBlockItems(String id, Block block) {
        Registry.register(Registries.ITEM, new Identifier(Guzhenren.MOD_ID, id),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {

    }
}
