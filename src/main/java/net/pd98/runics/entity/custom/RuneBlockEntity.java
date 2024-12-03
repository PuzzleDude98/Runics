package net.pd98.runics.entity.custom;

import com.google.gson.JsonObject;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.pd98.runics.entity.ModBlockEntities;

public class RuneBlockEntity extends BlockEntity {

    private JsonObject runedata;
    public RuneBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.RUNE_BLOCK_ENTITY, pos, state);
    }

    public JsonObject getData() {
        return this.runedata;
    }
}
