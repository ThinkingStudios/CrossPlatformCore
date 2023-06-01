package org.thinkingstudio.architectured.item.setting;

import java.util.function.Consumer;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

@FunctionalInterface
public interface CustomDamageHandler {
    /**
     * Called to apply damage to the given stack.
     * This can be used to e.g. drain from a battery before actually damaging the item.
     *
     * @param stack         the {@link ItemStack} that is being damaged
     * @param amount        the amount of damage originally requested
     * @param entity        the {@link LivingEntity} whose item is being damaged
     * @param breakCallback callback when the stack reaches zero damage. See {@link ItemStack#damage(int, LivingEntity, Consumer)} and its callsites for more information.
     * @return the amount of damage to pass to vanilla's logic
     */
    int damage(ItemStack stack, int amount, LivingEntity entity, Consumer<LivingEntity> breakCallback);
}
