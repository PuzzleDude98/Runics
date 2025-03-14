package net.pd98.types.entity_condition_types;

import com.google.gson.JsonObject;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.pd98.types.data_types.Comparison;

public class time_of_day extends EntityCondition{

    private int compare_to;
    private Comparison comparison;

    @Override
    public void parseJson(JsonObject json) {
        compare_to = json.get("compare_to").getAsInt();
        comparison = new Comparison((String) parseOptionalValue(json, "comparison", "=="));

        super.parseJson(json);
    }

    @Override
    public boolean evaluateBase(World world, Entity entity) {
        return comparison.evaluate((int) world.getTimeOfDay(), compare_to);
    }
}
