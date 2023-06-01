package org.thinkingstudio.architectured.impl.item;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.function.Supplier;

import org.jetbrains.annotations.ApiStatus;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.thinkingstudio.architectured.item.setting.CustomDamageHandler;
import org.thinkingstudio.architectured.item.setting.CustomItemSetting;
import org.thinkingstudio.architectured.item.setting.EquipmentSlotProvider;
import org.thinkingstudio.architectured.item.setting.RecipeRemainderProvider;

@ApiStatus.Internal
public class CustomItemSettingImpl<T> implements CustomItemSetting<T> {
    public static final CustomItemSetting<EquipmentSlotProvider> EQUIPMENT_SLOT_PROVIDER = CustomItemSetting.create(() -> null);
    public static final CustomItemSetting<CustomDamageHandler> CUSTOM_DAMAGE_HANDLER = CustomItemSetting.create(() -> null);

    @SuppressWarnings("ConstantConditions")
    public static final CustomItemSetting<RecipeRemainderProvider> RECIPE_REMAINDER_PROVIDER = new CustomItemSettingImpl<>(() -> (original, recipe) -> original.getItem().hasRecipeRemainder() ? original.getItem().getRecipeRemainder().getDefaultStack() : ItemStack.EMPTY) {
        @Override
        public void apply(Item.Settings settings, Item item) {
            if (item.hasRecipeRemainder()) {
                throw new IllegalArgumentException("Item cannot have a standard recipe remainder and a custom recipe remainder");
            }

            super.apply(settings, item);
        }
    };

    private static final Map<Item.Settings, Collection<CustomItemSettingImpl<?>>> CUSTOM_SETTINGS = new WeakHashMap<>();

    private final Map<Item.Settings, T> customSettings = new WeakHashMap<>();
    private final Map<Item, T> customItemSettings = new HashMap<>();
    private final Supplier<T> defaultValue;

    public CustomItemSettingImpl(Supplier<T> defaultValue) {
        Objects.requireNonNull(defaultValue);

        this.defaultValue = defaultValue;
    }

    @Override
    public T get(Item item) {
        Objects.requireNonNull(item);

        return this.customItemSettings.computeIfAbsent(item, i -> this.defaultValue.get());
    }

    public void set(Item.Settings settings, T value) {
        Objects.requireNonNull(settings);

        this.customSettings.put(settings, value);
        CUSTOM_SETTINGS.computeIfAbsent(settings, s -> new HashSet<>()).add(this);
    }

    public void apply(Item.Settings settings, Item item) {
        Objects.requireNonNull(settings);

        this.customItemSettings.put(item, this.customSettings.getOrDefault(settings, this.defaultValue.get()));
    }

    // Because item settings are reusable, it is possible that the same item settings object will be applied
    // to multiple items.
    public static void onBuild(Item.Settings settings, Item item) {
        for (CustomItemSettingImpl<?> setting : CUSTOM_SETTINGS.getOrDefault(settings, Collections.emptyList())) {
            setting.apply(settings, item);
        }
    }
}
