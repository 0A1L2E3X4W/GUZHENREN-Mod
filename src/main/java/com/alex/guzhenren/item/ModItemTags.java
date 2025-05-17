package com.alex.guzhenren.item;

import com.alex.guzhenren.Guzhenren;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {

    public static final TagKey<Item> SUGAR_INGREDIENTS = of("sugar_ingredients");
    public static final TagKey<Item> GU_MATERIALS = of("gu_materials");

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(Guzhenren.MOD_ID, id));
    }
}
