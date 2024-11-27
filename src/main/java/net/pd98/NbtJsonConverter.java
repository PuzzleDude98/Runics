package net.pd98;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.minecraft.nbt.*;

public class NbtJsonConverter {

    public static JsonObject nbtToJson(NbtCompound nbt) {
        JsonObject jsonObject = new JsonObject();

        for (String key : nbt.getKeys()) {
            NbtElement element = nbt.get(key);
            jsonObject.add(key, nbtElementToJson(element));
        }

        return jsonObject;
    }

    private static JsonElement nbtElementToJson(NbtElement element) {
        switch (element.getType()) {
            case NbtElement.STRING_TYPE:
                return new JsonPrimitive(((NbtString) element).asString());
            case NbtElement.INT_TYPE:
                return new JsonPrimitive(((NbtInt) element).intValue());
            case NbtElement.FLOAT_TYPE:
                return new JsonPrimitive(((NbtFloat) element).floatValue());
            case NbtElement.DOUBLE_TYPE:
                return new JsonPrimitive(((NbtDouble) element).doubleValue());
            case NbtElement.BYTE_TYPE:
                return new JsonPrimitive(((NbtByte) element).byteValue());
            case NbtElement.LONG_TYPE:
                return new JsonPrimitive(((NbtLong) element).longValue());
            case NbtElement.SHORT_TYPE:
                return new JsonPrimitive(((NbtShort) element).shortValue());
            case NbtElement.LIST_TYPE:
                return nbtListToJson((NbtList) element);
            case NbtElement.COMPOUND_TYPE:
                return nbtToJson((NbtCompound) element);
            default:
                return null; // Handle unexpected types if necessary
        }
    }

    private static JsonArray nbtListToJson(NbtList list) {
        JsonArray jsonArray = new JsonArray();

        for (NbtElement element : list) {
            jsonArray.add(nbtElementToJson(element));
        }

        return jsonArray;
    }
}
