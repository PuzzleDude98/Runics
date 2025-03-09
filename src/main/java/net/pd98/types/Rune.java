package net.pd98.types;

import com.google.gson.JsonObject;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class Rune {

    public abstract void parseJson(JsonObject json);

    public abstract void trigger(World world, BlockPos pos, PlayerEntity player);
}
