package org.thinkingstudio.architectured.item.setting;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.collection.DefaultedList;

/**
 * Allows an item to conditionally specify the recipe remainder.
 * The recipe remainder is an {@link ItemStack} instead of an {@link Item}.
 * This can be used to allow your item to get damaged instead of
 * getting removed when used in crafting.
 * <p>
 * Recipe remainder providers can be set with {@link ArchitecturedItemSettings#recipeRemainder(RecipeRemainderProvider)}.
 */
@FunctionalInterface
public interface RecipeRemainderProvider {
    /**
     * An {@link ItemStack} aware version of {@link Item#getRecipeRemainder()}.
     *
     * @param original the input item stack
     * @param recipe the recipe being used
     * @return the recipe remainder
     */
    @Contract(value = "_, _ -> new")
    ItemStack getRecipeRemainder(ItemStack original, @Nullable Recipe<?> recipe);

    static DefaultedList<ItemStack> getRemainingStacks(Inventory inventory, Recipe<?> recipe, DefaultedList<ItemStack> defaultedList) {
        for (int i = 0; i < defaultedList.size(); ++i) {
            ItemStack stack = inventory.getStack(i);
            ItemStack remainder = RecipeRemainderLogicHandler.getRemainder(stack, recipe);

            if (!remainder.isEmpty()) {
                defaultedList.set(i, remainder);
            }
        }

        return defaultedList;
    }
}
