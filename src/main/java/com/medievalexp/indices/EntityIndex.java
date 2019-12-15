package com.medievalexp.indices;

import com.medievalexp.MedievalExpansion;
import com.medievalexp.entities.EntityGoat;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;

public class EntityIndex {
    public static EntityType<?> GOAT_ENTITY = EntityType.Builder.create(EntityGoat::new, EntityClassification.CREATURE)
            .build(MedievalExpansion.modid + ":goat_entity").setRegistryName(MedievalExpansion.RegistryEvents.location("goat_entity"));

    public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                ItemIndex.goat_entity_egg = registerEntitySpawnEgg(GOAT_ENTITY, 0x664c2b, 0x282219, "goat_entity_egg")
        );
    }

    public static void registerEntityWorldSpawns() {
        registerEntityWorldSpawn(GOAT_ENTITY, Biomes.MOUNTAINS, Biomes.GIANT_SPRUCE_TAIGA, Biomes.SNOWY_TAIGA);
    }

    private static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name) {
        SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(MedievalExpansion.general));
        item.setRegistryName(MedievalExpansion.RegistryEvents.location(name));
        return item;
    }

    private static void registerEntityWorldSpawn(EntityType<?> type, Biome... biomes) {
        for(Biome biome:biomes) {
            if(biome != null) {
                biome.getSpawns(type.getClassification()).add(new Biome.SpawnListEntry(type, 10, 1, 10));
            }
        }
    }
}
