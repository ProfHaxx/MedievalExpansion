package com.medievalexp;

import com.medievalexp.groups.MedievalExpansionGeneralGroup;
import com.medievalexp.indices.ArmorMaterialIndex;
import com.medievalexp.indices.BlockIndex;
import com.medievalexp.indices.ItemIndex;
import com.medievalexp.indices.ToolMaterialIndex;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@Mod("medexp")
public class MedievalExpansion {
    private static MedievalExpansion instance;
    public static final String modid = "medexp";
    private static final Logger logger = LogManager.getLogger(modid);

    private static final ItemGroup general = new MedievalExpansionGeneralGroup();

    public MedievalExpansion() {
        instance = this;

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        logger.info("Setup initialized.");
    }

    private void clientRegistries(final FMLClientSetupEvent event) {
        logger.info("Client Registries initialized.");
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            logger.info("Item Registry initialized.");
            event.getRegistry().registerAll(
                    ItemIndex.steel_ingot = new Item(new Item.Properties().group(general)).setRegistryName(location("steel_ingot")),

                    ItemIndex.steel_axe = new AxeItem(ToolMaterialIndex.STEEL, 2.0f, 0.6f, new Item.Properties().group(general)).setRegistryName("steel_axe"),
                    ItemIndex.steel_pickaxe = new PickaxeItem(ToolMaterialIndex.STEEL, -3, 1.8f, new Item.Properties().group(general)).setRegistryName("steel_pickaxe"),
                    ItemIndex.steel_sword = new SwordItem(ToolMaterialIndex.STEEL, 0, 1.9f, new Item.Properties().group(general)).setRegistryName("steel_sword"),
                    ItemIndex.steel_hoe = new HoeItem(ToolMaterialIndex.STEEL, 1.0f, new Item.Properties().group(general)).setRegistryName("steel_hoe"),
                    ItemIndex.steel_shovel = new ShovelItem(ToolMaterialIndex.STEEL, -3.0f, 6.0f, new Item.Properties().group(general)).setRegistryName("steel_shovel"),

                    ItemIndex.steel_helmet = new ArmorItem(ArmorMaterialIndex.STEEL, EquipmentSlotType.HEAD, new Item.Properties().group(general)).setRegistryName("steel_helmet"),
                    ItemIndex.steel_chestplate = new ArmorItem(ArmorMaterialIndex.STEEL, EquipmentSlotType.CHEST, new Item.Properties().group(general)).setRegistryName("steel_chestplate"),
                    ItemIndex.steel_leggings = new ArmorItem(ArmorMaterialIndex.STEEL, EquipmentSlotType.LEGS, new Item.Properties().group(general)).setRegistryName("steel_leggings"),
                    ItemIndex.steel_boots = new ArmorItem(ArmorMaterialIndex.STEEL, EquipmentSlotType.FEET, new Item.Properties().group(general)).setRegistryName("steel_boots"),

                    ItemIndex.steel_block = new BlockItem(BlockIndex.steel_block, new Item.Properties().group(general)).setRegistryName(Objects.requireNonNull(BlockIndex.steel_block.getRegistryName()))
            );
            logger.info("Items registered!");
        }

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            logger.info("Item Registry initialized.");
            event.getRegistry().registerAll(
                    BlockIndex.steel_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("steel_block"))
            );
            logger.info("Items registered!");
        }

        private static ResourceLocation location(String name) {
            return new ResourceLocation(modid, name);
        }
    }
}
