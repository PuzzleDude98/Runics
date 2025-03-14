package net.pd98.types;

import com.google.gson.JsonObject;
import net.pd98.Runics;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public abstract class ParsableObject {
    public abstract void parseJson(JsonObject json);

    public static Object parseOptionalObject(JsonObject json, String key, Map<String, ? extends Class<? extends ParsableObject>> type) {
        if (json.has(key)) {
            try {
                return parseObject(json.getAsJsonObject(key), type);
            } catch (Exception e) {
                Runics.LOGGER.error(e.toString());
            }
        }
        return null;
    }

    public static Object parseObject(JsonObject objectJson, Map<String, ? extends Class<? extends ParsableObject>> type) {
        try {
            Class<? extends ParsableObject> klass = type.get(objectJson.get("type").getAsString());
            if (klass == null) {
                Runics.LOGGER.warn("Unknown type: " + objectJson.get("type").getAsString());
                return null;
            }
            ParsableObject object = klass.getDeclaredConstructor().newInstance();
            object.parseJson(objectJson);
            return object;
        } catch (Exception e) {
            Runics.LOGGER.warn("Invalid object passed to parser!");
            return null;
        }
    }

    public static Object parseOptionalValue(JsonObject json, String key, @Nullable Object current) {
        if (!json.has(key)) {
            return current;
        }

        return switch (current) {
            case Integer i -> json.get(key).getAsInt();
            case Float f -> json.get(key).getAsFloat();
            case String s -> json.get(key).getAsString();
            case Boolean b -> json.get(key).getAsBoolean();
            default -> {
                Runics.LOGGER.warn("Tried to parse variable of unknown type: " + current.getClass());
                yield current;
            }
        };
    }

}
