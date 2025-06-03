package com.alex.guzhenren.item;

import com.alex.guzhenren.Guzhenren;
import com.alex.guzhenren.item.custom.PrimevalStone;
import com.alex.guzhenren.item.custom.gu.Gu_BlackBoar_1;
import com.alex.guzhenren.item.custom.gu.Gu_Hope;
import com.alex.guzhenren.item.custom.gu.Gu_FlowerBoar_1;
import com.alex.guzhenren.item.custom.gu.Gu_WhiteBoar_1;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {

    // ITEMS
    public static final Item PRIMEVAL_STONE = registerItem("primeval_stone",
            new PrimevalStone(new Item.Settings().maxCount(64)));

    // FOOD
    public static final Item LIQUOR = registerItem("liquor", new Item(new Item.Settings().food(ModFoodComponents.LIQUOR)));

    // GU
    public static final Item HOPE_GU = registerItem("hope_gu", new Gu_Hope(new Item.Settings()
            .maxCount(64)));
    public static final Item FLOWER_BOAR_GU_1 = registerItem("flower_boar_gu1", new Gu_FlowerBoar_1(new Item.Settings()
            .maxCount(1).maxDamage(32)));
    public static final Item WHITE_BOAR_GU_1 = registerItem("white_boar_gu1", new Gu_WhiteBoar_1(new Item.Settings()
            .maxCount(1).maxDamage(32)));
    public static final Item BLACK_BOAR_GU_1 = registerItem("black_boar_gu1", new Gu_BlackBoar_1(new Item.Settings()
            .maxCount(1).maxDamage(32)));

    /*MOD METHODS*/
    public static Item registerItem(String id, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Guzhenren.MOD_ID, id), item);
    }

    public static Item registerItems(String id, Item item) {
        return Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(),
                new Identifier(Guzhenren.MOD_ID)), item);
    }

    public static void registerItems() {

    }
}
