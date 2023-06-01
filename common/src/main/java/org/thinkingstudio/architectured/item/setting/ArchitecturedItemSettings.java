package org.thinkingstudio.architectured.item.setting;

import org.jetbrains.annotations.Contract;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;
import org.thinkingstudio.architectured.impl.item.CustomItemSettingImpl;

public class ArchitecturedItemSettings extends Item.Settings {

    public ArchitecturedItemSettings equipmentSlot(EquipmentSlotProvider equipmentSlotProvider) {
        return this.customSetting(ArchitecturedCustomItemSettings.EQUIPMENT_SLOT_PROVIDER, equipmentSlotProvider);
    }
    
    public ArchitecturedItemSettings equipmentSlot(EquipmentSlot equipmentSlot) {
        return this.customSetting(ArchitecturedCustomItemSettings.EQUIPMENT_SLOT_PROVIDER, itemStack -> equipmentSlot);
    }
    
    public ArchitecturedItemSettings customDamage(CustomDamageHandler handler) {
        return this.customSetting(ArchitecturedCustomItemSettings.CUSTOM_DAMAGE_HANDLER, handler);
    }
    
    public ArchitecturedItemSettings recipeRemainder(RecipeRemainderProvider provider) {
        return this.customSetting(ArchitecturedCustomItemSettings.RECIPE_REMAINDER_PROVIDER, provider);
    }
    
    public ArchitecturedItemSettings recipeDamageRemainder() {
        return this.recipeDamageRemainder(1);
    }
    
    public ArchitecturedItemSettings recipeSelfRemainder() {
        return this.recipeDamageRemainder(0);
    }

    /**
     * Sets the stack-aware recipe remainder to damage the item by a certain amount every time it is used in crafting.
     *
     * @param by the amount
     */
    public ArchitecturedItemSettings recipeDamageRemainder(int by) {
        if (by == 0) {
            return this.recipeRemainder((original, recipe) -> original.copy());
        }

        return this.recipeRemainder((original, recipe) -> {
            if (!original.isDamageable()) {
                return original.copy();
            }

            ItemStack copy = original.copy();

            copy.setDamage(copy.getDamage() + by);

            if (copy.getDamage() >= copy.getMaxDamage()) {
                copy.setCount(0);
                return ItemStack.EMPTY;
            }

            return copy;
        });
    }

    /**
     * Sets a custom setting of the item.
     *
     * @param setting the unique type for this setting
     * @param value   the object containing the setting itself
     * @return this builder
     */
    public <T> ArchitecturedItemSettings customSetting(CustomItemSetting<T> setting, T value) {
        if (!(setting instanceof CustomItemSettingImpl<T>)) {
            throw new UnsupportedOperationException("CustomItemSetting should not be custom class " + setting.getClass().getSimpleName());
        }

        ((CustomItemSettingImpl<T>) setting).set(this, value);
        return this;
    }

    // Overrides of vanilla methods

    @Override
    @Contract("_->this")
    public ArchitecturedItemSettings food(FoodComponent foodComponent) {
        super.food(foodComponent);
        return this;
    }

    @Override
    public ArchitecturedItemSettings maxCount(int maxCount) {
        super.maxCount(maxCount);
        return this;
    }

    @Override
    public ArchitecturedItemSettings maxDamageIfAbsent(int maxDamage) {
        super.maxDamageIfAbsent(maxDamage);
        return this;
    }

    @Override
    @Contract("_->this")
    public ArchitecturedItemSettings maxDamage(int maxDamage) {
        super.maxDamage(maxDamage);
        return this;
    }

    @Override
    @Contract("_->this")
    public ArchitecturedItemSettings recipeRemainder(Item recipeRemainder) {
        super.recipeRemainder(recipeRemainder);
        return this;
    }

    @Override
    @Contract("_->this")
    public ArchitecturedItemSettings group(ItemGroup group) {
        super.group(group);
        return this;
    }

    @Override
    @Contract("_->this")
    public ArchitecturedItemSettings rarity(Rarity rarity) {
        super.rarity(rarity);
        return this;
    }

    @Override
    @Contract("->this")
    public ArchitecturedItemSettings fireproof() {
        super.fireproof();
        return this;
    }
}
