package net.pd98.runics.entity;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pd98.runics.Runics;
import net.pd98.runics.block.ModBlocks;
import net.pd98.runics.entity.custom.RuneBlockEntity;

public class ModBlockEntities {
    public static final BlockEntityType<RuneBlockEntity> RUNE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Runics.MOD_ID, "rune"),
            BlockEntityType.Builder.create(RuneBlockEntity::new, ModBlocks.RUNE).build());

    public static void registerModBlockEntities() {
        Runics.LOGGER.info("Registering block entities for " + Runics.MOD_ID);
    }
}
