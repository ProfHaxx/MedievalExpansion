package com.medievalexp.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OreGenConfig {
    public static ForgeConfigSpec.IntValue copper_chance, tin_chance;
    public static ForgeConfigSpec.BooleanValue copper_overworld, tin_overworld;

    static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {
        server.comment("OreGen Config");
        copper_chance = server.comment("Maximum number of ore veins of the copper ore that can spawn in one chunk")
                .defineInRange("oregen.copper_chance", 20, 10, 40);
        copper_overworld = server.comment("Decide if you want to spawn copper ore in the overworld")
                .define("oregen.generate_overworld", true);
        tin_chance = server.comment("Maximum number of ore veins of the tin ore that can spawn in one chunk")
                .defineInRange("oregen.copper_chance", 20, 10, 40);
        tin_overworld = server.comment("Decide if you want to spawn tin ore in the overworld")
                .define("oregen.generate_overworld", true);
    }
}
