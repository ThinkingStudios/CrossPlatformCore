package org.thinkingstudio.architectured.mixin;

import net.minecraft.item.ItemGroup;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.thinkingstudio.architectured.impl.item.ItemGroupExtensions;

@Mixin(ItemGroup.class)
public abstract class ItemGroupMixin implements ItemGroupExtensions {
    @Shadow
    @Final
    @Mutable
    public static ItemGroup[] GROUPS;

    @Override
    public void architectured$expandArray() {
        ItemGroup[] tempGroups = GROUPS;
        GROUPS = new ItemGroup[GROUPS.length + 1];

        System.arraycopy(tempGroups, 0, GROUPS, 0, tempGroups.length);
    }
}
