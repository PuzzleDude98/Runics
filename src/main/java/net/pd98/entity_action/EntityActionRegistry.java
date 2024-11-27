package net.pd98.entity_action;
import net.minecraft.util.Identifier;
import net.pd98.entity_action.types.heal;

import java.util.HashMap;
import java.util.Map;

public class EntityActionRegistry {

    private static final Map<Identifier, EntityAction> actions = new HashMap<>();

    static {
        // Register entity actions
        actions.put(Identifier.of( "heal"), new heal());
    }

    // Retrieve an action by its identifier
    public static EntityAction get(Identifier id) {
        return actions.get(id);
    }
}