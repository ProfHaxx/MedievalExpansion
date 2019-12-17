package com.medievalexp.world;

import com.medievalexp.config.OreGenConfig;
import com.medievalexp.indices.BlockIndex;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration {
    public static void setupOreGeneration() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            //Copper Ore
            if(OreGenConfig.copper_overworld.get()) {
                biome.addFeature(
                    Decoration.UNDERGROUND_ORES,
                    Biome.createDecoratedFeature(
                        Feature.ORE,
                            new OreFeatureConfig(
                                OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                BlockIndex.copper_ore.getDefaultState(),
                                OreGenConfig.copper_chance.get()),
                            Placement.COUNT_RANGE,
                            new CountRangeConfig(10, 20, 0, 80)));
            }

            //Tin Ore
            if(OreGenConfig.tin_overworld.get()) {
                biome.addFeature(
                        Decoration.UNDERGROUND_ORES,
                        Biome.createDecoratedFeature(
                                Feature.ORE,
                                new OreFeatureConfig(
                                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                        BlockIndex.tin_ore.getDefaultState(),
                                        OreGenConfig.tin_chance.get()),
                                Placement.COUNT_RANGE,
                                new CountRangeConfig(10, 20, 0, 80)));
            }

            //Silver Ore
            if(OreGenConfig.silver_overworld.get()) {
                biome.addFeature(
                        Decoration.UNDERGROUND_ORES,
                        Biome.createDecoratedFeature(
                                Feature.ORE,
                                new OreFeatureConfig(
                                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                        BlockIndex.silver_ore.getDefaultState(),
                                        OreGenConfig.silver_chance.get()),
                                Placement.COUNT_RANGE,
                                new CountRangeConfig(10, 20, 0, 40)));
            }

            //Magical Ore (Just spawns in Magical Forest Biome)

        }
    }
}
