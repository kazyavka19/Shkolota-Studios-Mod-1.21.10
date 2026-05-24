package net.kazyavka19.shkolotastudios.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kazyavka19.shkolotastudios.ShkolotaStudios;
import net.kazyavka19.shkolotastudios.block.ModBlocks;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup SHKOLOTA_ITEMS_GROUP = Registry.register(
            Registries.ITEM_GROUP, Identifier.of(ShkolotaStudios.MOD_ID,"shkolota_item_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CHERRY_JUICE))
                    .displayName(Text.translatable("itemgroup.shkolotastudios.shkolota_item_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CHERRY_JUICE);
                    }).build());

    public static final ItemGroup SHKOLOTA_BLOCK_GROUP = Registry.register(
            Registries.ITEM_GROUP, Identifier.of(ShkolotaStudios.MOD_ID,"shkolota_block_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.CHERRY_JUICE_BLOCK))
                    .displayName(Text.translatable("itemgroup.shkolotastudios.shkolota_block_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.CHERRY_JUICE_BLOCK);
                    }).build());


    public static void registerModItemGroup(){
        ShkolotaStudios.LOGGER.info("Registering Item Group for " + ShkolotaStudios.MOD_ID);
    }
}
