package net.pd98.types;

import com.google.gson.JsonObject;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pd98.TypeMaps;
import net.pd98.types.block_condition_types.BlockCondition;

public abstract class Rune extends ParsableObject{

    private BlockCondition condition;

    @Override
    public void parseJson(JsonObject json) {
        condition = (BlockCondition) parseOptionalObject(json, "condition", TypeMaps.blockConditionTypes);
    }

    public void trigger(World world, BlockPos pos, PlayerEntity player) {
        if (condition != null && !condition.evaluateBase(world, pos)) {
            return;
        }
    };
}
