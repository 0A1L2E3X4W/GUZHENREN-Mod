package com.alex.guzhenren.item;

import com.alex.guzhenren.Guzhenren;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {

    /*DEFINE MOD ITEMS*/
    public static final Item PRIMEVAL_STONE = registerItem("primeval_stone", new Item(new Item.Settings()));

    public static final Item LIQUOR = registerItem("liquor", new Item(new Item.Settings().food(ModFoodComponents.LIQUOR)));

    /*MOD METHODS*/
    public static Item registerItem(String id, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Guzhenren.MOD_ID, id), item);
    }

    public static Item registerItems(String id, Item item) {
        return Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(),
                new Identifier(Guzhenren.MOD_ID)), item);
    }

    /*Minecraft Methods*/
    public static Item register(String id, Item item) {
        return register(new Identifier(id), item);
    }

    public static Item register(Identifier id, Item item) {
        return register(RegistryKey.of(Registries.ITEM.getKey(), id), item);
    }

    public static Item register(RegistryKey<Item> key, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, key, item);
    }

    public static void registerItems() {

    }
}
