package net.pd98.types.meta_condition_types;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pd98.Runics;
import net.pd98.TypeMaps;
import net.pd98.types.block_condition_types.BlockCondition;

import java.util.ArrayList;
import java.util.List;

public class andBlock extends BlockCondition {

    private List<BlockCondition> conditions = new ArrayList<>();

    @Override
    public void parseJson(JsonObject json) {
        for (JsonElement object : json.get("conditions").getAsJsonArray()) {
            try {
                conditions.add((BlockCondition) parseObject((JsonObject) object, TypeMaps.blockConditionTypes));
            } catch (Exception e) {
                Runics.LOGGER.warn("Non object element found in meta condition: " + object.toString());
            }
        }

        super.parseJson(json);
    }

    @Override
    public boolean evaluateBase(World world, BlockPos pos) {
        for (BlockCondition condition : conditions) {
            if (!condition.evaluate(world, pos)) {
                return false;
            }
        }
        return true;
    }
}
