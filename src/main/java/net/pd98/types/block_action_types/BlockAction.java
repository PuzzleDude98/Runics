package net.pd98.types.block_action_types;

import com.google.gson.JsonObject;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pd98.types.ParsableObject;

public abstract class BlockAction extends ParsableObject {

    public abstract void trigger(World world, BlockPos pos);
}
