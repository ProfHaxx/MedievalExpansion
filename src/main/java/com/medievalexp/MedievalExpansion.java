package com.medievalexp;

import com.medievalexp.client.renders.RenderRegistry;
import com.medievalexp.config.Config;
import com.medievalexp.groups.MedievalExpansionGeneralGroup;
import com.medievalexp.indices.*;
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
                    ItemIndex.steel_ingot = new Item(new Item.Properties().group(general)).setRegistryName(location("steel_ingot")),

                    ItemIndex.steel_axe = new AxeItem(ToolMaterialIndex.STEEL, 6.0f, -3.0f, new Item.Properties().group(general)).setRegistryName("steel_axe"),
                    ItemIndex.steel_pickaxe = new PickaxeItem(ToolMaterialIndex.STEEL, 1, -2.8f, new Item.Properties().group(general)).setRegistryName("steel_pickaxe"),
                    ItemIndex.steel_sword = new SwordItem(ToolMaterialIndex.STEEL, 3, -2.4f, new Item.Properties().group(general)).setRegistryName("steel_sword"),
                    ItemIndex.steel_hoe = new HoeItem(ToolMaterialIndex.STEEL, -3.0f, new Item.Properties().group(general)).setRegistryName("steel_hoe"),
                    ItemIndex.steel_shovel = new ShovelItem(ToolMaterialIndex.STEEL, 1.5f, -3.0f, new Item.Properties().group(general)).setRegistryName("steel_shovel"),

                    ItemIndex.steel_helmet = new ArmorItem(ArmorMaterialIndex.STEEL, EquipmentSlotType.HEAD, new Item.Properties().group(general)).setRegistryName("steel_helmet"),
                    ItemIndex.steel_chestplate = new ArmorItem(ArmorMaterialIndex.STEEL, EquipmentSlotType.CHEST, new Item.Properties().group(general)).setRegistryName("steel_chestplate"),
                    ItemIndex.steel_leggings = new ArmorItem(ArmorMaterialIndex.STEEL, EquipmentSlotType.LEGS, new Item.Properties().group(general)).setRegistryName("steel_leggings"),
                    ItemIndex.steel_boots = new ArmorItem(ArmorMaterialIndex.STEEL, EquipmentSlotType.FEET, new Item.Properties().group(general)).setRegistryName("steel_boots"),

                    ItemIndex.steel_block = new BlockItem(BlockIndex.steel_block, new Item.Properties().group(general)).setRegistryName(Objects.requireNonNull(BlockIndex.steel_block.getRegistryName())),


                    ItemIndex.copper_ingot = new Item(new Item.Properties().group(general)).setRegistryName(location("copper_ingot")),

                    ItemIndex.copper_axe = new AxeItem(ToolMaterialIndex.COPPER, 6.0f, -3.0f, new Item.Properties().group(general)).setRegistryName("copper_axe"),
                    ItemIndex.copper_pickaxe = new PickaxeItem(ToolMaterialIndex.COPPER, 1, -2.8f, new Item.Properties().group(general)).setRegistryName("copper_pickaxe"),
                    ItemIndex.copper_sword = new SwordItem(ToolMaterialIndex.COPPER, 3, -2.4f, new Item.Properties().group(general)).setRegistryName("copper_sword"),
                    ItemIndex.copper_hoe = new HoeItem(ToolMaterialIndex.COPPER, -3.0f, new Item.Properties().group(general)).setRegistryName("copper_hoe"),
                    ItemIndex.copper_shovel = new ShovelItem(ToolMaterialIndex.COPPER, 1.5f, -3.0f, new Item.Properties().group(general)).setRegistryName("copper_shovel"),

                    ItemIndex.copper_helmet = new ArmorItem(ArmorMaterialIndex.COPPER, EquipmentSlotType.HEAD, new Item.Properties().group(general)).setRegistryName("copper_helmet"),
                    ItemIndex.copper_chestplate = new ArmorItem(ArmorMaterialIndex.COPPER, EquipmentSlotType.CHEST, new Item.Properties().group(general)).setRegistryName("copper_chestplate"),
                    ItemIndex.copper_leggings = new ArmorItem(ArmorMaterialIndex.COPPER, EquipmentSlotType.LEGS, new Item.Properties().group(general)).setRegistryName("copper_leggings"),
                    ItemIndex.copper_boots = new ArmorItem(ArmorMaterialIndex.COPPER, EquipmentSlotType.FEET, new Item.Properties().group(general)).setRegistryName("copper_boots"),

                    ItemIndex.copper_block = new BlockItem(BlockIndex.copper_block, new Item.Properties().group(general)).setRegistryName(Objects.requireNonNull(BlockIndex.copper_block.getRegistryName())),
                    ItemIndex.copper_ore = new BlockItem(BlockIndex.copper_ore, new Item.Properties().group(general)).setRegistryName(Objects.requireNonNull(BlockIndex.copper_ore.getRegistryName())),

                    ItemIndex.tin_ingot = new Item(new Item.Properties().group(general)).setRegistryName(location("tin_ingot")),

                    ItemIndex.tin_axe = new AxeItem(ToolMaterialIndex.TIN, 6.0f, -3.0f, new Item.Properties().group(general)).setRegistryName("tin_axe"),
                    ItemIndex.tin_pickaxe = new PickaxeItem(ToolMaterialIndex.TIN, 1, -2.8f, new Item.Properties().group(general)).setRegistryName("tin_pickaxe"),
                    ItemIndex.tin_sword = new SwordItem(ToolMaterialIndex.TIN, 3, -2.4f, new Item.Properties().group(general)).setRegistryName("tin_sword"),
                    ItemIndex.tin_hoe = new HoeItem(ToolMaterialIndex.TIN, -3.0f, new Item.Properties().group(general)).setRegistryName("tin_hoe"),
                    ItemIndex.tin_shovel = new ShovelItem(ToolMaterialIndex.TIN, 1.5f, -3.0f, new Item.Properties().group(general)).setRegistryName("tin_shovel"),

                    ItemIndex.tin_helmet = new ArmorItem(ArmorMaterialIndex.TIN, EquipmentSlotType.HEAD, new Item.Properties().group(general)).setRegistryName("tin_helmet"),
                    ItemIndex.tin_chestplate = new ArmorItem(ArmorMaterialIndex.TIN, EquipmentSlotType.CHEST, new Item.Properties().group(general)).setRegistryName("tin_chestplate"),
                    ItemIndex.tin_leggings = new ArmorItem(ArmorMaterialIndex.TIN, EquipmentSlotType.LEGS, new Item.Properties().group(general)).setRegistryName("tin_leggings"),
                    ItemIndex.tin_boots = new ArmorItem(ArmorMaterialIndex.TIN, EquipmentSlotType.FEET, new Item.Properties().group(general)).setRegistryName("tin_boots"),

                    ItemIndex.tin_block = new BlockItem(BlockIndex.tin_block, new Item.Properties().group(general)).setRegistryName(Objects.requireNonNull(BlockIndex.tin_block.getRegistryName())),
                    ItemIndex.tin_ore = new BlockItem(BlockIndex.tin_ore, new Item.Properties().group(general)).setRegistryName(Objects.requireNonNull(BlockIndex.tin_ore.getRegistryName()))
            );

            EntityIndex.registerEntitySpawnEggs(event);

            logger.info("Items registered!");
        }

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            logger.info("Block Registry initialized.");
            event.getRegistry().registerAll(
                    BlockIndex.steel_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("steel_block")),
                    BlockIndex.copper_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("copper_block")),
                    BlockIndex.copper_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("copper_ore")),
                    BlockIndex.tin_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("tin_block")),
                    BlockIndex.tin_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("tin_ore"))
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
