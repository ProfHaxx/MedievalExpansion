package com.medievalexp.indices;

import com.medievalexp.MedievalExpansion;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

//Armor Materials: net.minecraft.item.ArmorMaterial;
//Sound Events: net.minecraft.util.SoundEvents;
public enum ArmorMaterialIndex implements IArmorMaterial {
    STEEL("steel", 400, new int[]{3, 5, 7, 3}, 16, ItemIndex.steel_ingot, "item.armor.equip_chain", 0.0f),
    COPPER("copper", 200, new int[]{2, 5, 5, 2}, 13, ItemIndex.copper_ingot, "item.armor.equip_chain", 0.0f);

    private static final int[] max_damage_array = new int[]{13, 15, 16, 11};

    private String name, equipSound;
    private int durability, enchantability;
    private int[] damageReductionAmount;
    private Item repairItem;
    private float toughness;

    ArmorMaterialIndex(String name, int durability, int[] damageReductionAmount, int enchantability, Item repairItem, String equipSound, float toughness) {
        this.name = name;
        this.durability = durability;
        this.damageReductionAmount = damageReductionAmount;
        this.enchantability = enchantability;
        this.repairItem = repairItem;
        this.equipSound = equipSound;
        this.toughness = toughness;
    }

    @Override
    public int getDurability(EquipmentSlotType equipmentSlotType) {
        return max_damage_array[equipmentSlotType.getIndex()] * this.durability;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType equipmentSlotType) {
        return this.damageReductionAmount[equipmentSlotType.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return new SoundEvent(new ResourceLocation(equipSound));
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(repairItem);
    }

    @Override
    public String getName() {
        return MedievalExpansion.modid + ":" + name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }
}
