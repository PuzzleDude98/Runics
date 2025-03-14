package net.pd98.types.entity_condition_types;

import com.google.gson.JsonObject;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.pd98.types.ParsableObject;

public abstract class EntityCondition extends ParsableObject {
    private boolean inverted = false;

    public abstract boolean evaluateBase(World world, Entity entity);

    public boolean evaluate(World world, Entity entity) {
        return inverted != evaluateBase(world, entity);
    }

    public void parseJson(JsonObject json) {
        inverted = (boolean) parseOptionalValue(json, "inverted", inverted);
    }

}
