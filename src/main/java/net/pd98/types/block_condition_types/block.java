package net.pd98.types.block_condition_types;

import com.google.gson.JsonObject;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class block extends BlockCondition{

    private Identifier block;
    @Override
    public boolean evaluateBase(World world, BlockPos pos) {
        return Registries.BLOCK.getId(world.getBlockState(pos).getBlock()).equals(block);
    }

    @Override
    public void parseJson(JsonObject json) {
        block = Identifier.of(json.get("block").getAsString());
        super.parseJson(json);
    }
}
