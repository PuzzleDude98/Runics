package net.pd98;

import net.fabricmc.api.ModInitializer;

import net.pd98.block.ModBlockEntities;
import net.pd98.block.ModBlocks;
import net.pd98.types.Rune;
import net.pd98.types.rune_types.action_on_rune_use;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Runics implements ModInitializer {
	public static final String MOD_ID = "runics";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		ModBlocks.registerBlocks();
		ModBlockEntities.registerBlockEntityTypes();
	}
}