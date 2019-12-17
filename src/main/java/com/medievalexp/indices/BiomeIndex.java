package com.medievalexp.indices;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public class BiomeIndex {
    public static Biome magical_forest_biome;

    public static void registerBiomes() {
        registerBiome(magical_forest_biome, Type.FOREST, Type.MAGICAL);
    }

    private static void registerBiome(Biome biome, Type... types) {
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }
}
