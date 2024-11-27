package net.pd98.entity_action;

import com.google.gson.JsonObject;
import net.minecraft.entity.Entity;

public interface EntityAction {
    void execute(Entity entity, JsonObject runeData);
}
