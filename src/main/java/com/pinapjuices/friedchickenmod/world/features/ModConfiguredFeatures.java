package com.pinapjuices.friedchickenmod.world.features;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import com.pinapjuices.friedchickenmod.block.ModBlocks;

public class ModConfiguredFeatures {


    public static final ConfiguredFeature<?, ?> CHICKEN_FLOWER_CONFIG = FeatureUtils.register("chicken_flower",
            Feature.FLOWER.configured(new RandomPatchConfiguration(32, 6, 2,
                    () -> Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CHICKEN_FLOWER.get())))
                            .onlyWhenEmpty())));

    private static <FC extends FeatureConfiguration>ConfiguredFeature<FC, ?> register(String name,
                                                                                      ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, name, configuredFeature);
    }
}