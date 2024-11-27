package net.pd98.rune;

import com.google.gson.JsonObject;
import net.minecraft.entity.Entity;
import net.minecraft.world.event.GameEvent;

public interface RuneType {
    void onEvent(Entity entity, JsonObject runeData, GameEvent event);
}