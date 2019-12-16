package com.medievalexp;

import com.medievalexp.client.renders.RenderRegistry;
import com.medievalexp.config.Config;
import com.medievalexp.groups.MedievalExpansionGeneralGroup;
import com.medievalexp.indices.*;
import com.medievalexp.item.BattleAxeItem;
import com.medievalexp.item.DaggerItem;
import com.medievalexp.item.WarHammerItem;
import com.medievalexp.world.OreGeneration;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@Mod("medexp")
public class MedievalExpansion {
    private static MedievalExpansion instance;
    public static final String modid = "medexp";
    public static final Logger logger = LogManager.getLogger(modid);

    public static final ItemGroup general = new MedievalExpansionGeneralGroup();

    public MedievalExpansion() {
        instance = this;

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER, "tutorialmod-server.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT, "tutorialmod-client.toml");

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

        Config.loadConfig(Config.CLIENT, FMLPaths.CONFIGDIR.get().resolve("tutorialmod-client.toml").toString());
        Config.loadConfig(Config.SERVER, FMLPaths.CONFIGDIR.get().resolve("tutorialmod-server.toml").toString());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        OreGeneration.setupOreGeneration();
        logger.info("Setup initialized.");
    }

    private void clientRegistries(final FMLClientSetupEvent event) {
        RenderRegistry.registryEntityRenders();
        logger.info("Client Registries initialized.");
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            logger.info("Item Registry initialized.");
            event.getRegistry().registerAll(
                    //Steel Set
                    ItemIndex.steel_ingot = new Item(new Item.Properties().group(general)).setRegistryName(location("steel_ingot")),

                    ItemIndex.steel_axe = new AxeItem(ToolMaterialIndex.STEEL, 6.0f, -3.0f, new Item.Properties().group(general)).setRegistryName("steel_axe"),
                    ItemIndex.steel_pickaxe = new PickaxeItem(ToolMaterialIndex.STEEL, 1, -2f, new Item.Properties().group(general)).setRegistryName("steel_pickaxe"),
                    ItemIndex.steel_sword = new SwordItem(ToolMaterialIndex.STEEL, 3, -2.4f, new Item.Properties().group(general)).setRegistryName("steel_sword"),
                    ItemIndex.steel_hoe = new HoeItem(ToolMaterialIndex.STEEL, -2f, new Item.Properties().group(general)).setRegistryName("steel_hoe"),
                    ItemIndex.steel_shovel = new ShovelItem(ToolMaterialIndex.STEEL, 1.5f, -2f, new Item.Properties().group(general)).setRegistryName("steel_shovel"),
                    ItemIndex.steel_battle_axe = new BattleAxeItem(ToolMaterialIndex.STEEL, 8.0f, -3.0f, new Item.Properties().group(general)).setRegistryName("steel_battle_axe"),
                    ItemIndex.steel_war_hammer = new WarHammerItem(ToolMaterialIndex.STEEL, 8, -3.0f, new Item.Properties().group(general)).setRegistryName("steel_war_hammer"),
                    ItemIndex.steel_dagger = new DaggerItem(ToolMaterialIndex.STEEL, 3, -2.4f, new Item.Properties().group(general)).setRegistryName("steel_dagger"),

                    ItemIndex.steel_helmet = new ArmorItem(ArmorMaterialIndex.STEEL, EquipmentSlotType.HEAD, new Item.Properties().group(general)).setRegistryName("steel_helmet"),
                    ItemIndex.steel_chestplate = new ArmorItem(ArmorMaterialIndex.STEEL, EquipmentSlotType.CHEST, new Item.Properties().group(general)).setRegistryName("steel_chestplate"),
                    ItemIndex.steel_leggings = new ArmorItem(ArmorMaterialIndex.STEEL, EquipmentSlotType.LEGS, new Item.Properties().group(general)).setRegistryName("steel_leggings"),
                    ItemIndex.steel_boots = new ArmorItem(ArmorMaterialIndex.STEEL, EquipmentSlotType.FEET, new Item.Properties().group(general)).setRegistryName("steel_boots"),

                    ItemIndex.steel_block = new BlockItem(BlockIndex.steel_block, new Item.Properties().group(general)).setRegistryName(Objects.requireNonNull(BlockIndex.steel_block.getRegistryName())),

                    //Copper Set
                    ItemIndex.copper_ingot = new Item(new Item.Properties().group(general)).setRegistryName(location("copper_ingot")),

                    ItemIndex.copper_axe = new AxeItem(ToolMaterialIndex.COPPER, 6.0f, -3.0f, new Item.Properties().group(general)).setRegistryName("copper_axe"),
                    ItemIndex.copper_pickaxe = new PickaxeItem(ToolMaterialIndex.COPPER, 1, -2f, new Item.Properties().group(general)).setRegistryName("copper_pickaxe"),
                    ItemIndex.copper_sword = new SwordItem(ToolMaterialIndex.COPPER, 3, -2.4f, new Item.Properties().group(general)).setRegistryName("copper_sword"),
                    ItemIndex.copper_hoe = new HoeItem(ToolMaterialIndex.COPPER, -2f, new Item.Properties().group(general)).setRegistryName("copper_hoe"),
                    ItemIndex.copper_shovel = new ShovelItem(ToolMaterialIndex.COPPER, 1.5f, -2f, new Item.Properties().group(general)).setRegistryName("copper_shovel"),
                    ItemIndex.copper_battle_axe = new BattleAxeItem(ToolMaterialIndex.COPPER, 8.0f, -3.0f, new Item.Properties().group(general)).setRegistryName("copper_battle_axe"),
                    ItemIndex.copper_war_hammer = new WarHammerItem(ToolMaterialIndex.COPPER, 8, -3.0f, new Item.Properties().group(general)).setRegistryName("copper_war_hammer"),
                    ItemIndex.copper_dagger = new DaggerItem(ToolMaterialIndex.COPPER, 3, -2.4f, new Item.Properties().group(general)).setRegistryName("copper_dagger"),

                    ItemIndex.copper_helmet = new ArmorItem(ArmorMaterialIndex.COPPER, EquipmentSlotType.HEAD, new Item.Properties().group(general)).setRegistryName("copper_helmet"),
                    ItemIndex.copper_chestplate = new ArmorItem(ArmorMaterialIndex.COPPER, EquipmentSlotType.CHEST, new Item.Properties().group(general)).setRegistryName("copper_chestplate"),
                    ItemIndex.copper_leggings = new ArmorItem(ArmorMaterialIndex.COPPER, EquipmentSlotType.LEGS, new Item.Properties().group(general)).setRegistryName("copper_leggings"),
                    ItemIndex.copper_boots = new ArmorItem(ArmorMaterialIndex.COPPER, EquipmentSlotType.FEET, new Item.Properties().group(general)).setRegistryName("copper_boots"),

                    ItemIndex.copper_block = new BlockItem(BlockIndex.copper_block, new Item.Properties().group(general)).setRegistryName(Objects.requireNonNull(BlockIndex.copper_block.getRegistryName())),
                    ItemIndex.copper_ore = new BlockItem(BlockIndex.copper_ore, new Item.Properties().group(general)).setRegistryName(Objects.requireNonNull(BlockIndex.copper_ore.getRegistryName())),

                    //Tin Set
                    ItemIndex.tin_ingot = new Item(new Item.Properties().group(general)).setRegistryName(location("tin_ingot")),

                    ItemIndex.tin_axe = new AxeItem(ToolMaterialIndex.TIN, 6.0f, -3.0f, new Item.Properties().group(general)).setRegistryName("tin_axe"),
                    ItemIndex.tin_pickaxe = new PickaxeItem(ToolMaterialIndex.TIN, 1, -2f, new Item.Properties().group(general)).setRegistryName("tin_pickaxe"),
                    ItemIndex.tin_sword = new SwordItem(ToolMaterialIndex.TIN, 3, -2.4f, new Item.Properties().group(general)).setRegistryName("tin_sword"),
                    ItemIndex.tin_hoe = new HoeItem(ToolMaterialIndex.TIN, -2f, new Item.Properties().group(general)).setRegistryName("tin_hoe"),
                    ItemIndex.tin_shovel = new ShovelItem(ToolMaterialIndex.TIN, 1.5f, -2f, new Item.Properties().group(general)).setRegistryName("tin_shovel"),
                    ItemIndex.tin_battle_axe = new BattleAxeItem(ToolMaterialIndex.TIN, 8.0f, -3.0f, new Item.Properties().group(general)).setRegistryName("tin_battle_axe"),
                    ItemIndex.tin_war_hammer = new WarHammerItem(ToolMaterialIndex.TIN, 8, -3.0f, new Item.Properties().group(general)).setRegistryName("tin_war_hammer"),
                    ItemIndex.tin_dagger = new DaggerItem(ToolMaterialIndex.TIN, 3, -2.4f, new Item.Properties().group(general)).setRegistryName("tin_dagger"),

                    ItemIndex.tin_helmet = new ArmorItem(ArmorMaterialIndex.TIN, EquipmentSlotType.HEAD, new Item.Properties().group(general)).setRegistryName("tin_helmet"),
                    ItemIndex.tin_chestplate = new ArmorItem(ArmorMaterialIndex.TIN, EquipmentSlotType.CHEST, new Item.Properties().group(general)).setRegistryName("tin_chestplate"),
                    ItemIndex.tin_leggings = new ArmorItem(ArmorMaterialIndex.TIN, EquipmentSlotType.LEGS, new Item.Properties().group(general)).setRegistryName("tin_leggings"),
                    ItemIndex.tin_boots = new ArmorItem(ArmorMaterialIndex.TIN, EquipmentSlotType.FEET, new Item.Properties().group(general)).setRegistryName("tin_boots"),

                    ItemIndex.tin_block = new BlockItem(BlockIndex.tin_block, new Item.Properties().group(general)).setRegistryName(Objects.requireNonNull(BlockIndex.tin_block.getRegistryName())),
                    ItemIndex.tin_ore = new BlockItem(BlockIndex.tin_ore, new Item.Properties().group(general)).setRegistryName(Objects.requireNonNull(BlockIndex.tin_ore.getRegistryName())),

                    //Silver Set
                    ItemIndex.silver_ingot = new Item(new Item.Properties().group(general)).setRegistryName(location("silver_ingot")),

                    ItemIndex.silver_axe = new AxeItem(ToolMaterialIndex.SILVER, 6.0f, -3.0f, new Item.Properties().group(general)).setRegistryName("silver_axe"),
                    ItemIndex.silver_pickaxe = new PickaxeItem(ToolMaterialIndex.SILVER, 1, -2f, new Item.Properties().group(general)).setRegistryName("silver_pickaxe"),
                    ItemIndex.silver_sword = new SwordItem(ToolMaterialIndex.SILVER, 3, -2.4f, new Item.Properties().group(general)).setRegistryName("silver_sword"),
                    ItemIndex.silver_hoe = new HoeItem(ToolMaterialIndex.SILVER, -2f, new Item.Properties().group(general)).setRegistryName("silver_hoe"),
                    ItemIndex.silver_shovel = new ShovelItem(ToolMaterialIndex.SILVER, 1.5f, -2f, new Item.Properties().group(general)).setRegistryName("silver_shovel"),
                    ItemIndex.silver_battle_axe = new BattleAxeItem(ToolMaterialIndex.SILVER, 8.0f, -3.0f, new Item.Properties().group(general)).setRegistryName("silver_battle_axe"),
                    ItemIndex.silver_war_hammer = new WarHammerItem(ToolMaterialIndex.SILVER, 8, -3.0f, new Item.Properties().group(general)).setRegistryName("silver_war_hammer"),
                    ItemIndex.silver_dagger = new DaggerItem(ToolMaterialIndex.SILVER, 3, -2.4f, new Item.Properties().group(general)).setRegistryName("silver_dagger"),

                    ItemIndex.silver_helmet = new ArmorItem(ArmorMaterialIndex.SILVER, EquipmentSlotType.HEAD, new Item.Properties().group(general)).setRegistryName("silver_helmet"),
                    ItemIndex.silver_chestplate = new ArmorItem(ArmorMaterialIndex.SILVER, EquipmentSlotType.CHEST, new Item.Properties().group(general)).setRegistryName("silver_chestplate"),
                    ItemIndex.silver_leggings = new ArmorItem(ArmorMaterialIndex.SILVER, EquipmentSlotType.LEGS, new Item.Properties().group(general)).setRegistryName("silver_leggings"),
                    ItemIndex.silver_boots = new ArmorItem(ArmorMaterialIndex.SILVER, EquipmentSlotType.FEET, new Item.Properties().group(general)).setRegistryName("silver_boots"),

                    ItemIndex.silver_block = new BlockItem(BlockIndex.silver_block, new Item.Properties().group(general)).setRegistryName(Objects.requireNonNull(BlockIndex.silver_block.getRegistryName())),
                    ItemIndex.silver_ore = new BlockItem(BlockIndex.silver_ore, new Item.Properties().group(general)).setRegistryName(Objects.requireNonNull(BlockIndex.silver_ore.getRegistryName())),

                    //Bronze Set
                    ItemIndex.bronze_ingot = new Item(new Item.Properties().group(general)).setRegistryName(location("bronze_ingot")),

                    ItemIndex.bronze_axe = new AxeItem(ToolMaterialIndex.BRONZE, 6.0f, -3.0f, new Item.Properties().group(general)).setRegistryName("bronze_axe"),
                    ItemIndex.bronze_pickaxe = new PickaxeItem(ToolMaterialIndex.BRONZE, 1, -2f, new Item.Properties().group(general)).setRegistryName("bronze_pickaxe"),
                    ItemIndex.bronze_sword = new SwordItem(ToolMaterialIndex.BRONZE, 3, -2.4f, new Item.Properties().group(general)).setRegistryName("bronze_sword"),
                    ItemIndex.bronze_hoe = new HoeItem(ToolMaterialIndex.BRONZE, -2f, new Item.Properties().group(general)).setRegistryName("bronze_hoe"),
                    ItemIndex.bronze_shovel = new ShovelItem(ToolMaterialIndex.BRONZE, 1.5f, -2f, new Item.Properties().group(general)).setRegistryName("bronze_shovel"),
                    ItemIndex.bronze_battle_axe = new BattleAxeItem(ToolMaterialIndex.BRONZE, 8.0f, -3.0f, new Item.Properties().group(general)).setRegistryName("bronze_battle_axe"),
                    ItemIndex.bronze_war_hammer = new WarHammerItem(ToolMaterialIndex.BRONZE, 8, -3.0f, new Item.Properties().group(general)).setRegistryName("bronze_war_hammer"),
                    ItemIndex.bronze_dagger = new DaggerItem(ToolMaterialIndex.BRONZE, 3, -2.4f, new Item.Properties().group(general)).setRegistryName("bronze_dagger"),

                    ItemIndex.bronze_helmet = new ArmorItem(ArmorMaterialIndex.BRONZE, EquipmentSlotType.HEAD, new Item.Properties().group(general)).setRegistryName("bronze_helmet"),
                    ItemIndex.bronze_chestplate = new ArmorItem(ArmorMaterialIndex.BRONZE, EquipmentSlotType.CHEST, new Item.Properties().group(general)).setRegistryName("bronze_chestplate"),
                    ItemIndex.bronze_leggings = new ArmorItem(ArmorMaterialIndex.BRONZE, EquipmentSlotType.LEGS, new Item.Properties().group(general)).setRegistryName("bronze_leggings"),
                    ItemIndex.bronze_boots = new ArmorItem(ArmorMaterialIndex.BRONZE, EquipmentSlotType.FEET, new Item.Properties().group(general)).setRegistryName("bronze_boots"),

                    ItemIndex.bronze_block = new BlockItem(BlockIndex.bronze_block, new Item.Properties().group(general)).setRegistryName(Objects.requireNonNull(BlockIndex.bronze_block.getRegistryName())),

                    //Wooden Set
                    ItemIndex.wooden_battle_axe = new BattleAxeItem(ItemTier.WOOD, 8.0f, -3.0f, new Item.Properties().group(general)).setRegistryName("wooden_battle_axe"),
                    ItemIndex.wooden_war_hammer = new WarHammerItem(ItemTier.WOOD, 8, -3.0f, new Item.Properties().group(general)).setRegistryName("wooden_war_hammer"),
                    ItemIndex.wooden_dagger = new DaggerItem(ItemTier.WOOD, 3, -2.4f, new Item.Properties().group(general)).setRegistryName("wooden_dagger"),

                    //Stone Set
                    ItemIndex.stone_battle_axe = new BattleAxeItem(ItemTier.STONE, 8.0f, -3.0f, new Item.Properties().group(general)).setRegistryName("stone_battle_axe"),
                    ItemIndex.stone_war_hammer = new WarHammerItem(ItemTier.STONE, 8, -3.0f, new Item.Properties().group(general)).setRegistryName("stone_war_hammer"),
                    ItemIndex.stone_dagger = new DaggerItem(ItemTier.STONE, 3, -2.4f, new Item.Properties().group(general)).setRegistryName("stone_dagger"),


                    //Gold Set
                    ItemIndex.gold_battle_axe = new BattleAxeItem(ItemTier.GOLD, 8.0f, -3.0f, new Item.Properties().group(general)).setRegistryName("gold_battle_axe"),
                    ItemIndex.gold_war_hammer = new WarHammerItem(ItemTier.GOLD, 8, -3.0f, new Item.Properties().group(general)).setRegistryName("gold_war_hammer"),
                    ItemIndex.gold_dagger = new DaggerItem(ItemTier.GOLD, 3, -2.4f, new Item.Properties().group(general)).setRegistryName("gold_dagger"),


                    //Iron Set
                    ItemIndex.iron_battle_axe = new BattleAxeItem(ItemTier.IRON, 8.0f, -3.0f, new Item.Properties().group(general)).setRegistryName("iron_battle_axe"),
                    ItemIndex.iron_war_hammer = new WarHammerItem(ItemTier.IRON, 8, -3.0f, new Item.Properties().group(general)).setRegistryName("iron_war_hammer"),
                    ItemIndex.iron_dagger = new DaggerItem(ItemTier.IRON, 3, -2.4f, new Item.Properties().group(general)).setRegistryName("iron_dagger"),


                    //Diamond Set
                    ItemIndex.diamond_battle_axe = new BattleAxeItem(ItemTier.DIAMOND, 8.0f, -3.0f, new Item.Properties().group(general)).setRegistryName("diamond_battle_axe"),
                    ItemIndex.diamond_war_hammer = new WarHammerItem(ItemTier.DIAMOND, 8, -3.0f, new Item.Properties().group(general)).setRegistryName("diamond_war_hammer"),
                    ItemIndex.diamond_dagger = new DaggerItem(ItemTier.DIAMOND, 3, -2.4f, new Item.Properties().group(general)).setRegistryName("diamond_dagger")
            );

            EntityIndex.registerEntitySpawnEggs(event);

            logger.info("Items registered!");
        }

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            logger.info("Block Registry initialized.");
            event.getRegistry().registerAll(
                    BlockIndex.steel_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("steel_block")),
                    BlockIndex.bronze_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("bronze_block")),
                    BlockIndex.copper_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("copper_block")),
                    BlockIndex.copper_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("copper_ore")),
                    BlockIndex.tin_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("tin_block")),
                    BlockIndex.tin_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("tin_ore")),
                    BlockIndex.silver_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("silver_block")),
                    BlockIndex.silver_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("silver_ore"))
            );
            logger.info("Blocks registered!");
        }

        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
            logger.info("Entity Registry initialized.");
            event.getRegistry().registerAll(
                    EntityIndex.GOAT_ENTITY
            );
            EntityIndex.registerEntityWorldSpawns();
            logger.info("Entities registered!");
        }

        public static ResourceLocation location(String name) {
            return new ResourceLocation(modid, name);
        }
    }
}
