package net.pd98.runics.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pd98.runics.Runics;
import net.pd98.runics.block.custom.RuneBlock;

public class ModBlocks {

    public static final Block RUNE = registerBlock("rune", new RuneBlock(AbstractBlock.Settings.create().breakInstantly()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Runics.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(Runics.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Runics.LOGGER.info("Registering blocks for " + Runics.MOD_ID);
    }
}
