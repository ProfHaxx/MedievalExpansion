package com.medievalexp.world.biomes;

import com.medievalexp.MedievalExpansion;
import com.medievalexp.indices.BlockIndex;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class MagicalForestBiome extends Biome {
    public MagicalForestBiome() {
        super(new Biome.Builder()
            .surfaceBuilder(
                    new ConfiguredSurfaceBuilder<>(
                            SurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    BlockIndex.magical_grass.getDefaultState(),
                                    Blocks.DIRT.getDefaultState(),
                                    Blocks.SAND.getDefaultState())))
            .precipitation(RainType.RAIN)
            .category(Category.FOREST)
            .downfall(0.3f)
            .depth(0.05f)
            .temperature(0.7f)
            .waterColor(0x1bb1cf)
            .waterFogColor(0x1bb1cf)
            .scale(0.5f)
        );

        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addMonsterRooms(this);
        DefaultBiomeFeatures.addFossils(this);
        DefaultBiomeFeatures.addGrass(this);

        this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.WOLF, 5, 4, 4));

        this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));

        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 30, 1, 1));

        this.setRegistryName(MedievalExpansion.RegistryEvents.location("magical_forest_biome"));
    }
}
