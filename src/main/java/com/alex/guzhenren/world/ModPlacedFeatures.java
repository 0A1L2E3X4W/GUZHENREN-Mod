package com.alex.guzhenren.world;

import com.alex.guzhenren.Guzhenren;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> PRIMEVAL_STONE_ORE = registryKey("primeval_stone_ore");

    public static void bootstrap(Registerable<PlacedFeature> context){
        var configuredFutureRegistryEntryLookUp = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(context, PRIMEVAL_STONE_ORE,
                configuredFutureRegistryEntryLookUp.getOrThrow(ModConfiguredFeatures.PRIMEVAL_STONE_ORE),
                ModOrePlacements.modifiersWithCount(10,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-50), YOffset.fixed(80))));

    };

    public static RegistryKey<PlacedFeature> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Guzhenren.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context,
                                 RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers){
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
