package net.pd98.rune.types;

import com.google.gson.JsonObject;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.world.event.GameEvent;
import net.pd98.entity_action.EntityAction;
import net.pd98.entity_action.EntityActionRegistry;
import net.pd98.rune.RuneType;

public class action_on_being_used implements RuneType {
    @Override
    public void onEvent(Entity entity, JsonObject runeData, GameEvent event) {
        // Only activate when the event is a right-click
        if (event == GameEvent.BLOCK_DESTROY.value()) {
            // Get the action type from the rune data
            if (runeData.has("entity_action")) {
                String actionType = runeData.getAsJsonObject("entity_action").get("type").getAsString();
                // Use the Identifier to retrieve the action
                Identifier actionId = Identifier.of("runicmod", actionType);
                EntityAction action = EntityActionRegistry.get(actionId);

                if (action != null) {
                    // Execute the action
                    action.execute(entity, runeData);
                }
            }
        }
    }
}