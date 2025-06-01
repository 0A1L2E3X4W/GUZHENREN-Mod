package com.alex.guzhenren.item;

import com.alex.guzhenren.Guzhenren;
import com.alex.guzhenren.item.custom.HuaShi_Gu_1;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item PRIMEVAL_STONE = registerItem("primeval_stone",
            new Item(new Item.Settings().maxCount(64)));

    public static final Item LIQUOR = registerItem("liquor", new Item(new Item.Settings().food(ModFoodComponents.LIQUOR)));

    public static final Item YUANLAO_GU_1 = registerItem("yuanlao_gu1", new Item(new Item.Settings()
            .maxCount(1)));
    public static final Item HUASHI_GU_1 = registerItem("huashi_gu1", new HuaShi_Gu_1(new Item.Settings()
            .maxCount(1).maxDamage(32)));

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
