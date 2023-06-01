package org.thinkingstudio.architectured.item.setting;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

@FunctionalInterface
public interface EquipmentSlotProvider {
    EquipmentSlot getPreferredEquipmentSlot(ItemStack stack);
}