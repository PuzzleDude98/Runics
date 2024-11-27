package net.pd98.entity_action.types;

import com.google.gson.JsonObject;
import net.minecraft.entity.Entity;
import net.pd98.entity_action.EntityAction;

public class heal implements EntityAction {
    @Override
    public void execute(Entity entity, JsonObject runeData) {
        entity.addVelocity(0, runeData.get("amount").getAsFloat(),0);
    }
}
