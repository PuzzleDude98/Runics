package net.pd98.types.block_condition_types;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pd98.types.ParsableObject;

public abstract class BlockCondition extends ParsableObject {

    public abstract boolean evaluate(World world, BlockPos pos);

}
