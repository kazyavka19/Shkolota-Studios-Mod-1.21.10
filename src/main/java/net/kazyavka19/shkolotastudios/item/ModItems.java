package net.kazyavka19.shkolotastudios.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kazyavka19.shkolotastudios.ShkolotaStudios;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.consume.UseAction;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static Item CHERRY_JUICE;

    public static void registerModItems() {
        ShkolotaStudios.LOGGER.info("Registering Mod Items for " + ShkolotaStudios.MOD_ID);

        // 1. Create the Identifier
        Identifier id = Identifier.of(ShkolotaStudios.MOD_ID, "cherry_juice");

        // 2. Create the RegistryKey from the Identifier
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        // 3. Register the item using the key, and bind that key into the Item.Settings
        CHERRY_JUICE = Registry.register(
                Registries.ITEM,
                key,
                new Item(new Item.Settings()
                        .registryKey(key)
                        .maxCount(16)
                )
        );

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(CHERRY_JUICE);
        });
    }
}