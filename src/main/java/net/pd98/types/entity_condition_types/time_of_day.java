package net.pd98.types.entity_condition_types;

import com.google.gson.JsonObject;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class time_of_day extends EntityCondition{

    private int compare_to;

    @Override
    public void parseJson(JsonObject json) {
        compare_to = json.get("compare_to").getAsInt();
    }

    @Override
    public boolean evaluate(World world, Entity entity) {
        return (world.getTimeOfDay() == compare_to);
    }
}
