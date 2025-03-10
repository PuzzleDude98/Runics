package net.pd98.types;

import com.google.gson.JsonObject;
import net.pd98.Runics;

import java.util.Map;

public abstract class ParsableObject {
    public abstract void parseJson(JsonObject json);

    public Object parseObject(JsonObject json, String key, Map<String, ? extends Class<? extends ParsableObject>> type) {
        if (json.has(key)) {
            try {
                JsonObject objectJson = json.getAsJsonObject(key);
                Class<? extends ParsableObject> klass = type.get(objectJson.get("type").getAsString());
                ParsableObject object = klass.getDeclaredConstructor().newInstance();
                object.parseJson(objectJson);
                return object;
            } catch (Exception e) {
                Runics.LOGGER.error(e.toString());
            }
        }
        return null;
    }
}
