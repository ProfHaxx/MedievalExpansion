package com.medievalexp.world;

import com.medievalexp.indices.BiomeIndex;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.SingleBiomeProvider;
import net.minecraft.world.biome.provider.SingleBiomeProviderSettings;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.OverworldChunkGenerator;
import net.minecraft.world.gen.OverworldGenSettings;

public class MedievalWorldType extends WorldType {
    public MedievalWorldType() {
        super("medieval_type");
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator(World world) {
        OverworldGenSettings settings = new OverworldGenSettings();
        SingleBiomeProviderSettings single = new SingleBiomeProviderSettings();
        single.setBiome(BiomeIndex.magical_forest_biome);
        return new OverworldChunkGenerator(world, new SingleBiomeProvider(single), settings);
    }
}
