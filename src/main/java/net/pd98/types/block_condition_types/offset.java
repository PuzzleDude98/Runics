package net.pd98.types.block_condition_types;

import com.google.gson.JsonObject;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pd98.TypeMaps;

public class offset extends BlockCondition {

    private BlockCondition condition;
    private int x = 0;
    private int y = 0;
    private int z = 0;

    @Override
    public void parseJson(JsonObject json) {
        condition = (BlockCondition) parseOptionalObject(json, "condition", TypeMaps.blockConditionTypes);

        x = (int) parseOptionalValue(json, "x", x);
        y = (int) parseOptionalValue(json, "y", y);
        z = (int) parseOptionalValue(json, "z", z);

        super.parseJson(json);
    }

    @Override
    public boolean evaluateBase(World world, BlockPos pos) {
        return condition.evaluate(world, pos.add(x,y,z));
    }
}
