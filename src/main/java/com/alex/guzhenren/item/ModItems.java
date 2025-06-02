package com.alex.guzhenren.item;

import com.alex.guzhenren.Guzhenren;
import com.alex.guzhenren.item.custom.PrimevalStone;
import com.alex.guzhenren.item.custom.gu.Hope_Gu;
import com.alex.guzhenren.item.custom.gu.HuaShi_Gu_1;
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
    public static final Item HOPE_GU = registerItem("hope_gu", new Hope_Gu(new Item.Settings()
            .maxCount(64)));
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

    public static void registerItems() {

    }
}
