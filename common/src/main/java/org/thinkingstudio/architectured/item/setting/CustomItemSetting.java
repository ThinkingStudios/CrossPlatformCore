package org.thinkingstudio.architectured.item.setting;

import net.minecraft.item.Item;
import org.jetbrains.annotations.ApiStatus;
import org.thinkingstudio.architectured.impl.item.CustomItemSettingImpl;

import java.util.function.Supplier;

@ApiStatus.NonExtendable
public interface CustomItemSetting<T> {
    /**
     * Returns the current value of this setting for the given {@link Item}.
     *
     * @param item the item
     * @return the current setting if present, the default setting if not
     */
    T get(Item item);

    /**
     * Creates a new CustomItemSetting with the given default value.
     *
     * @param defaultValue the value all items that do not explicitly set this setting will have.
     * @return a new CustomItemSetting
     */
    static <T> CustomItemSetting<T> create(Supplier<T> defaultValue) {
        return new CustomItemSettingImpl<>(defaultValue);
    }

    /**
     * Creates a new CustomItemSetting with the given default value.
     *
     * @param defaultValue the value all items that do not explicitly set this setting will have.
     * @return a new CustomItemSetting
     */
    static <T> CustomItemSetting<T> create(T defaultValue) {
        return create(() -> defaultValue);
    }
}