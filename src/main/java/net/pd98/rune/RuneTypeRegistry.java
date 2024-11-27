package net.pd98.rune;

import net.minecraft.util.Identifier;
import java.util.Map;
import java.util.HashMap;


public class RuneTypeRegistry {
    private static final Map<Identifier, RuneType> REGISTERED_RUNES = new HashMap<>();

    public static void register(Identifier id, RuneType runeType) {
        REGISTERED_RUNES.put(id, runeType);
    }

    public static RuneType get(Identifier id) {
        return REGISTERED_RUNES.get(id);
    }
}
