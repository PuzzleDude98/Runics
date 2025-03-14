package net.pd98.types.entity_condition_types;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.pd98.Runics;
import net.pd98.TypeMaps;

import java.util.List;

public class andEntity extends EntityCondition{

    private List<EntityCondition> conditions;

    @Override
    public void parseJson(JsonObject json) {
        for (JsonElement object : json.get("conditions").getAsJsonArray()) {
            try {
                parseObject((JsonObject) object, TypeMaps.entityConditionTypes);
            } catch (Exception e) {
                Runics.LOGGER.warn("Non object element found in meta condition: " + object.toString());
            }
        }
    }

    @Override
    public boolean evaluate(World world, Entity entity) {
        return false;
    }
}
