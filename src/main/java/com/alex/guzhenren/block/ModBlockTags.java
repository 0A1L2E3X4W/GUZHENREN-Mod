package com.alex.guzhenren.block;

import com.alex.guzhenren.Guzhenren;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {

    public static final TagKey<Block> GUZHENREN_ORE = of("guzhenren_ore");
    public static final TagKey<Block> GUZHENREN_BUILDING_BLOCK = of("guzhenren_building_block");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(Guzhenren.MOD_ID, id));
    }
}
