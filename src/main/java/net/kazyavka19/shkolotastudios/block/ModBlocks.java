// Defines the folder path where this Java file lives within the project structure
package net.kazyavka19.shkolotastudios.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

import net.kazyavka19.shkolotastudios.ShkolotaStudios;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

// The main class container holding all our mod's custom blocks
public class ModBlocks {
    // Declares a public, static reference variable for our custom Cherry Juice Block
    public static Block CHERRY_JUICE_BLOCK;

    // A private helper method that creates and registers a placeable item version of a block
    private static void registerBlockItem(String name, Block block, RegistryKey<Block> blockKey) {
        // Creates a unique Minecraft path/resource ID using our mod's namespace and the block's name
        Identifier id = Identifier.of(ShkolotaStudios.MOD_ID, name);
        // Converts that resource ID into a strict RegistryKey needed for item registration in 1.21.2+
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);

        // Calls Minecraft's game registry to save our block's item equivalent into the global ITEM list
        Registry.register(Registries.ITEM,
                // Passes the strict registration key we just created to identify the item
                itemKey,
                // Instantiates the new BlockItem,
                // linking it to the physical block and binding the item key to its settings
                new BlockItem(block, new Item.Settings().registryKey(itemKey)));
    }

    // The public method called during mod initialization to register all our custom blocks
    public static void registerModBlocks(){
        // Prints a helpful loading message to the console log so we know block registration has started
        ShkolotaStudios.LOGGER.info("Registering Mod Blocks for " + ShkolotaStudios.MOD_ID);

        // Creates the unique identifier path specifically for our cherry juice block
        Identifier id = Identifier.of(ShkolotaStudios.MOD_ID,"cherry_juice_block");
        // Creates the strict RegistryKey needed to securely register this physical block in 1.21.2+
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK,id);

        // Registers the block into Minecraft's global BLOCK registry and saves it to our static variable
        CHERRY_JUICE_BLOCK = Registry.register(
                // Specifies that we are registering into the physical BLOCK registry list
                Registries.BLOCK,
                // Passes our strict block RegistryKey to secure its unique identity
                blockKey,
                // Instantiates a brand-new base Block object and opens up its settings builder
                new Block(AbstractBlock.Settings.create().
                        // Binds the block's key to its settings (1.21.2+ rule) and sets its breaking hardness to 1.0
                                registryKey(blockKey).strength(1.0f,1.0f).
                        // Gives the block a wooden acoustic property so it sounds like wood when placed or broken
                                sounds(BlockSoundGroup.WOOD)
                )
        );

        // Calls our helper method to automatically create and register the inventory item form of this block
        registerBlockItem("cherry_juice_block",CHERRY_JUICE_BLOCK,blockKey);

        // Hooks into the Fabric API event that allows us to inject things into existing creative tabs
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(
                // Adds our shiny new cherry juice block directly into the vanilla Building Blocks creative tab
                entries -> entries.add(CHERRY_JUICE_BLOCK));
    }
}