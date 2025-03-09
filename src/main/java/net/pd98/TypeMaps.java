package net.pd98;

import net.pd98.types.Rune;
import net.pd98.types.block_action_types.BlockAction;
import net.pd98.types.block_action_types.explode;
import net.pd98.types.rune_types.action_on_rune_use;

import java.util.HashMap;
import java.util.Map;

public class TypeMaps {

    public static final Map<String, Class<? extends Rune>> runeTypes = new HashMap<>();

    public static final Map<String, Class<? extends BlockAction>> blockActionTypes = new HashMap<>();

    static {
        runeTypes.put("action_on_rune_use", action_on_rune_use.class);

        blockActionTypes.put("explode", explode.class);
    }

    public static void initialize() {
        Runics.LOGGER.info("Initializing type dictionaries!");
    }

}
