package net.pd98.types.entity_action_types;

import com.google.gson.JsonObject;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class add_velocity extends EntityAction{

    private float x = 0;
    private float y = 0;
    private float z = 0;

    private boolean client = true;
    private boolean server = true;
    private boolean set = false;

    @Override
    public void parseJson(JsonObject json) {
        x = json.has("x") ? json.get("x").getAsFloat() : x;
        y = json.has("y") ? json.get("y").getAsFloat() : y;
        z = json.has("z") ? json.get("z").getAsFloat() : z;

        client = json.has("client") ? json.get("client").getAsBoolean() : client;
        server = json.has("server") ? json.get("server").getAsBoolean() : server;

        set = json.has("set") ? json.get("set").getAsBoolean() : set;
    }

    @Override
    public void trigger(World world, Entity entity) {

        if ((world.isClient && !client) || (!world.isClient && !server)) {
            return;
        }

        if (set) {
            entity.setVelocity(x,y,z);
        } else {
            entity.addVelocity(x,y,z);
        }
    }
}
