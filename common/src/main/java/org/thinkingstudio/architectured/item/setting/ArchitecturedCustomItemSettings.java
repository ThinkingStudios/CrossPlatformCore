package org.thinkingstudio.architectured.item.setting;

import org.thinkingstudio.architectured.impl.item.CustomItemSettingImpl;

/**
 * A list of the {@link CustomItemSetting}s that are provided by Quilt.
 */
public final class ArchitecturedCustomItemSettings {
    private ArchitecturedCustomItemSettings() {}

    /**
     * The {@link CustomItemSetting} in charge of handing {@link EquipmentSlotProvider}s.
     */
    public static final CustomItemSetting<EquipmentSlotProvider> EQUIPMENT_SLOT_PROVIDER = CustomItemSettingImpl.EQUIPMENT_SLOT_PROVIDER;

    /**
     * The {@link CustomItemSetting} in charge of handing {@link CustomDamageHandler}s.
     */
    public static final CustomItemSetting<CustomDamageHandler> CUSTOM_DAMAGE_HANDLER = CustomItemSettingImpl.CUSTOM_DAMAGE_HANDLER;

    /**
     * The {@link CustomItemSetting} in charge of handing {@link RecipeRemainderProvider}s. This setting should be used when implementing custom crafting systems to properly handle remainders.
     * <p>
     * The setting is currently used in the following places:
     * <ul>
     *     <li>Crafting Table</li>
     *     <li>Furnace Fuel</li>
     *     <li>Furnace Ingredient</li>
     *     <li>Loom Dye Input</li>
     *     <li>Brewing Stand Ingredient</li>
     *     <li>Smithing Table Addition</li>
     *     <li>Stone Cutter Ingredient</li>
     * </ul>
     */
    public static final CustomItemSetting<RecipeRemainderProvider> RECIPE_REMAINDER_PROVIDER = CustomItemSettingImpl.RECIPE_REMAINDER_PROVIDER;
}
