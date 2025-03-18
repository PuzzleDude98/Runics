package net.pd98.types.meta_condition_types;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.pd98.Runics;
import net.pd98.TypeMaps;
import net.pd98.types.entity_condition_types.EntityCondition;

import java.util.ArrayList;
import java.util.List;

public class andEntity extends EntityCondition {

    private List<EntityCondition> conditions = new ArrayList<>();

    @Override
    public void parseJson(JsonObject json) {
        for (JsonElement object : json.get("conditions").getAsJsonArray()) {
            try {
                conditions.add((EntityCondition) parseObject((JsonObject) object, TypeMaps.entityConditionTypes));
            } catch (Exception e) {
                Runics.LOGGER.warn("Non object element found in meta condition: " + object.toString());
            }
        }

        super.parseJson(json);
    }

    @Override
    public boolean evaluateBase(World world, Entity entity) {
        for (EntityCondition condition : conditions) {
            if (!condition.evaluate(world, entity)) {
                return false;
            }
        }
        return true;
    }
}
