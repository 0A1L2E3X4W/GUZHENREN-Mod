package com.alex.guzhenren.item;

import com.alex.guzhenren.Guzhenren;
import com.alex.guzhenren.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    /*DEFINE MOD ITEMS GROUP*/
    public static final RegistryKey<ItemGroup> GU_MATERIAL_GROUP = register("gu_material_group");
    public static final RegistryKey<ItemGroup> GU_FOOD_GROUP = register("gu_food_group");
    public static final RegistryKey<ItemGroup> GU_GROUP = register("gu_group");

    /*Minecraft Methods*/
    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(Guzhenren.MOD_ID, id));
    }

    /*MOD METHODS*/
    public static void registerGroups() {
        Registry.register(
                Registries.ITEM_GROUP, GU_MATERIAL_GROUP,
                ItemGroup.create(ItemGroup.Row.TOP, 7)
                        .displayName(Text.translatable("itemGroup.gu_material_group"))
                        .icon(() -> new ItemStack(ModItems.PRIMEVAL_STONE))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.PRIMEVAL_STONE);
                            entries.add(ModBlocks.PRIMEVAL_STONE_ORE);
                            entries.add(ModBlocks.PRIMEVAL_STONE_BLOCK);
                        }).build());

        Registry.register(
                Registries.ITEM_GROUP, GU_FOOD_GROUP,
                ItemGroup.create(ItemGroup.Row.TOP, 8)
                        .displayName(Text.translatable("itemGroup.gu_food_group"))
                        .icon(() -> new ItemStack(ModItems.LIQUOR))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.LIQUOR);
                        }).build());

        Registry.register(
                Registries.ITEM_GROUP, GU_GROUP,
                ItemGroup.create(ItemGroup.Row.TOP, 9)
                        .displayName(Text.translatable("itemGroup.gu_group"))
                        .icon(() -> new ItemStack(ModItems.HUASHI_GU_1))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.HUASHI_GU_1);
                            entries.add(ModItems.YUANLAO_GU_1);
                        }).build());
    }
}
