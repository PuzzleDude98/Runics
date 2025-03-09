package net.pd98.types.block_action_types;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pd98.types.data_types.DestructionType;

import java.util.Optional;

public class explode extends BlockAction{
    public float power;
    public DestructionType destruction_type = DestructionType.BREAK;

    public boolean create_fire = false;

    @Override
    public void trigger(World world, BlockPos pos) {
        world.createExplosion(null, pos.getX()+0.5, pos.getY()+0.5, pos.getZ()+0.5, power, create_fire, World.ExplosionSourceType.NONE);
    }

    @Override
    public void parseJson(JsonObject json) {
        power = json.get("power").getAsFloat();
        destruction_type = Optional.ofNullable(DestructionType.fromString(json.get("destruction_type").getAsString())).orElse(destruction_type);
        create_fire = Optional.of(json.get("create_fire")).map(JsonElement::getAsBoolean).orElse(create_fire);
    }
}
