package net.pd98.types.rune_types;

import com.google.gson.JsonObject;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pd98.Runics;
import net.pd98.TypeMaps;
import net.pd98.types.ParsableObject;
import net.pd98.types.Rune;
import net.pd98.types.block_action_types.BlockAction;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class action_on_rune_use extends Rune {
    private BlockAction blockAction;

    public void trigger(World world, BlockPos pos, PlayerEntity player) {
        if (blockAction != null) {
            blockAction.trigger(world, pos);
        }
    }

    @Override
    public void parseJson(JsonObject json) {
        blockAction = (BlockAction) parseObject(json, "block_action", TypeMaps.blockActionTypes);
    }
}
