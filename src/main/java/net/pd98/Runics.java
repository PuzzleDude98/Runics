package net.pd98;

import net.fabricmc.api.ModInitializer;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pd98.blocks.RuneBlock;
import net.pd98.blocks.RuneBlockEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runics implements ModInitializer {
	public static final String MOD_ID = "runics";

	public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
		return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of("tutorial", path), blockEntityType);
	}

	public static final RuneBlock RUNE_BLOCK = register("rune_block", new RuneBlock(AbstractBlock.Settings.create()));

	public static final BlockEntityType<RuneBlockEntity> RUNE_BLOCK_ENTITY = register(
			"demo_block",
			// For versions 1.21.2 and above,
			// replace `BlockEntityType.Builder` with `FabricBlockEntityTypeBuilder`.
			BlockEntityType.Builder.create(RuneBlockEntity::new, RUNE_BLOCK).build()
	);

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");


	}
}