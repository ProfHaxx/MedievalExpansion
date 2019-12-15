package com.medievalexp.indices;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

//Item Tiers: net.minecraft.item.ItemTier;

public enum ToolMaterialIndex implements IItemTier {
    STEEL(3.0f, 8.0f, 512, 2, 16, ItemIndex.steel_ingot),
    COPPER(2.0f, 6.0f, 168, 2, 13, ItemIndex.copper_ingot),
    TIN(2.0f, 6.0f, 168, 2, 13, ItemIndex.tin_ingot),
    SILVER(2.5f, 7.0f, 386, 2, 18, ItemIndex.silver_ingot),
    BRONZE(2.5f, 386, 2, 13, 15, ItemIndex.bronze_ingot);
    private float attackDamage, efficiency;
    private int durability, harvestLevel, enchantability;
    private Item repairMaterial;

    ToolMaterialIndex(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial) {
        this.attackDamage = attackDamage;
        this.efficiency = efficiency;
        this.durability = durability;
        this.harvestLevel = harvestLevel;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return durability;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(this.repairMaterial);
    }
}
