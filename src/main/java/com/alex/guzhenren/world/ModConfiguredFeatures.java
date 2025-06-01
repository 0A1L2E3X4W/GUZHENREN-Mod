package com.alex.guzhenren.world;

import com.alex.guzhenren.Guzhenren;
import com.alex.guzhenren.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> PRIMEVAL_STONE_ORE = registryKey("primeval_stone_stone");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        RuleTest stonePlace = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslatePlace = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overWorld =
                List.of(OreFeatureConfig.createTarget(stonePlace, ModBlocks.PRIMEVAL_STONE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslatePlace, ModBlocks.PRIMEVAL_STONE_ORE.getDefaultState()));

        register(context, PRIMEVAL_STONE_ORE, Feature.ORE, new OreFeatureConfig(overWorld, 20));
    };

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Guzhenren.MOD_ID, name));
    }

    private static <FC extends FeatureConfig,
            F extends Feature<FC>> void register(
                    Registerable<ConfiguredFeature<?, ?>> context,
                    RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
