package com.medievalexp.groups;

import com.medievalexp.indices.ItemIndex;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MedievalExpansionGeneralGroup extends ItemGroup {

    public MedievalExpansionGeneralGroup() {
        super("mexgeneral");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemIndex.steel_ingot);
    }
}
