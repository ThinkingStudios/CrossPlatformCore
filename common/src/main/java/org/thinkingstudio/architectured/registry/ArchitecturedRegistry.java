package org.thinkingstudio.architectured.registry;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.Registries;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class ArchitecturedRegistry {
    public static Supplier<Registries> REGISTRIES;

    public Registrar<Item> ITEMS;
    public Registrar<Block> BLOCKS;
    public Registrar<BlockEntityType<?>> BLOCK_ENTITY_TYPE;
    public Registrar<ScreenHandlerType<?>> SCREEN_HANDLER_TYPE;
    public Registrar<EntityType<?>> ENTITY_TYPE;

    public ArchitecturedRegistry(String id) {
        REGISTRIES = Suppliers.memoize(() -> Registries.get(id));

        ITEMS = REGISTRIES.get().get(Registry.ITEM_KEY);
        BLOCKS = REGISTRIES.get().get(Registry.BLOCK_KEY);
        BLOCK_ENTITY_TYPE = REGISTRIES.get().get(Registry.BLOCK_ENTITY_TYPE_KEY);
        SCREEN_HANDLER_TYPE = REGISTRIES.get().get(Registry.MENU_KEY);
        ENTITY_TYPE = REGISTRIES.get().get(Registry.ENTITY_TYPE_KEY);
    }

    public ArchitecturedRegistry registry(String modid) {
        return new ArchitecturedRegistry(modid);
    }

    public RegistrySupplier<Item> registerItem(Identifier id, Supplier<Item> itemSupplier) {
        return ITEMS.register(id, itemSupplier);
    }

    public RegistrySupplier<Block> registerBlock(Identifier id, Supplier<Block> blockSupplier) {
        return BLOCKS.register(id, blockSupplier);
    }

    public RegistrySupplier<BlockEntityType<?>> registerBlcokEntityType(Identifier id, Supplier<BlockEntityType<?>> blockEntityTypeSupplier) {
        return BLOCK_ENTITY_TYPE.register(id, blockEntityTypeSupplier);
    }

    public RegistrySupplier<ScreenHandlerType<?>> registerScreenHandler(Identifier id, Supplier<ScreenHandlerType<?>> screenHandlerTypeSupplier) {
        return SCREEN_HANDLER_TYPE.register(id, screenHandlerTypeSupplier);
    }

    public RegistrySupplier<EntityType<?>> registerEntity(Identifier id, Supplier<EntityType<?>> entityTypeSupplier) {
        return ENTITY_TYPE.register(id, entityTypeSupplier);
    }
}
