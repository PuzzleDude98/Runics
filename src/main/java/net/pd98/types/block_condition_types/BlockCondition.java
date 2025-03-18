package net.pd98.types.block_condition_types;

import com.google.gson.JsonObject;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pd98.types.ParsableObject;

public abstract class BlockCondition extends ParsableObject {
    
    boolean inverted = false;

    public abstract boolean evaluateBase(World world, BlockPos pos);

    public boolean evaluate(World world, BlockPos pos) {
        return inverted != evaluateBase(world, pos);
    }

    public void parseJson(JsonObject json) {
        inverted = (boolean) parseOptionalValue(json, "inverted", inverted);
    }
}
