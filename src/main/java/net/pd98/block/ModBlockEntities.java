package net.pd98.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pd98.Runics;
import net.pd98.block.blocks.RuneBlockEntity;

public class ModBlockEntities {

    public static final BlockEntityType<RuneBlockEntity> RUNE_BLOCK_ENTITY =
            register("rune", RuneBlockEntity::new, ModBlocks.RUNE_BLOCK);


    private static <T extends BlockEntity> BlockEntityType<T> register(
            String name,
            FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory,
            Block... blocks
    ) {
        Identifier id = Identifier.of(Runics.MOD_ID, name);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }

    public static void registerBlockEntityTypes() {

        Runics.LOGGER.info("Registering runic block entities!");
    }
}
