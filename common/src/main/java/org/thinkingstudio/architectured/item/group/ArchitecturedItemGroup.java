package org.thinkingstudio.architectured.item.group;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.thinkingstudio.architectured.impl.item.ItemGroupExtensions;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public final class ArchitecturedItemGroup extends ItemGroup {
    private final Supplier<ItemStack> iconSupplier;
    private @Nullable ItemStack icon;
    private final @Nullable Consumer<List<ItemStack>> stacksForDisplay;
    private final @Nullable Text displayText;

    public ArchitecturedItemGroup(int index, String id, Supplier<ItemStack> iconSupplier, @Nullable Consumer<List<ItemStack>> stacksForDisplay, @Nullable Text displayText) {
        super(index, id);

        this.iconSupplier = iconSupplier;
        this.stacksForDisplay = stacksForDisplay;
        this.displayText = displayText;
    }

    public void setIcon(ItemConvertible icon) {
        this.icon = icon.asItem().getDefaultStack();
    }

    public void setIcon(ItemStack icon) {
        this.icon = icon;
    }

    @Override
    public ItemStack createIcon() {
        ItemStack supplierIcon = this.iconSupplier.get();
        if (!supplierIcon.isEmpty()) {
            return supplierIcon;
        } else if (icon == null) {
            return ItemStack.EMPTY;
        }

        return icon;
    }

    @Override
    public void appendStacks(DefaultedList<ItemStack> stacks) {
        super.appendStacks(stacks);

        if (this.stacksForDisplay != null) {
            this.stacksForDisplay.accept(stacks);
        }
    }

    @Override
    public Text getDisplayName() {
        return this.displayText == null ? super.getDisplayName() : this.displayText;
    }

    public static Builder builder(Identifier identifier) {
        return new Builder(identifier);
    }

    public static ArchitecturedItemGroup create(Identifier identifier) {
        return new Builder(identifier).build();
    }

    public static ArchitecturedItemGroup createWithIcon(Identifier identifier, @NotNull Supplier<ItemStack> iconSupplier) {
        return new Builder(identifier).icon(iconSupplier).build();
    }

    public static <T extends ItemGroup> T register(Function<Integer, T> itemGroupFactory) {
        ((ItemGroupExtensions) GROUPS[0]).architectured$expandArray();
        return itemGroupFactory.apply(GROUPS.length - 1);
    }

    public static final class Builder {
        private final Identifier identifier;
        private Supplier<ItemStack> iconSupplier = () -> ItemStack.EMPTY;
        private Consumer<List<ItemStack>> stacksForDisplay;
        private Text text;

        private Builder(Identifier identifier) {
            this.identifier = identifier;
        }

        /**
         * This is used to add an icon to the {@link ItemGroup}.
         *
         * @param iconSupplier the supplier should return the {@link ItemStack} that you wish to show on the tab
         * @return {@code this}
         */
        public Builder icon(@NotNull Supplier<ItemStack> iconSupplier) {
            this.iconSupplier = iconSupplier;
            return this;
        }

        /**
         * Adds a custom list of items to be displayed in a tab, such as items with enchantments, potions, or other NBT values.
         *
         * @param stacksForDisplay add {@link ItemStack}s to this list to show in the {@link ItemGroup}
         * @return {@code this}
         */
        public Builder appendItems(@Nullable Consumer<List<ItemStack>> stacksForDisplay) {
            this.stacksForDisplay = stacksForDisplay;
            return this;
        }

        /**
         * Set the {@link Text} used as the name when rendering the {@link ItemGroup}
         *
         * @param text The {@link Text} to render as the name
         * @return {@code this}
         */
        public Builder displayText(@NotNull Text text) {
            this.text = text;
            return this;
        }

        /**
         * @return a new {@link ArchitecturedItemGroup}
         */
        public ArchitecturedItemGroup build() {
            return register(index -> new ArchitecturedItemGroup(
                    index, String.format("%s.%s", this.identifier.getNamespace(), this.identifier.getPath()),
                    this.iconSupplier, this.stacksForDisplay, this.text
            ));
        }
    }
}
