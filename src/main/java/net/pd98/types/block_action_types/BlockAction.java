package net.pd98.types.block_action_types;

import com.google.gson.JsonObject;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BlockAction {

    public abstract void trigger(World world, BlockPos pos);

    public abstract void parseJson(JsonObject json);
}
