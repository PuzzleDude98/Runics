package net.pd98.types.rune_types;

import com.google.gson.JsonObject;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pd98.Runics;
import net.pd98.TypeMaps;
import net.pd98.types.Rune;
import net.pd98.types.block_action_types.BlockAction;

import java.lang.reflect.InvocationTargetException;

public class action_on_rune_use extends Rune {
    private BlockAction blockAction;

    public void trigger(World world, BlockPos pos, PlayerEntity player) {
        blockAction.trigger(world, pos);
    }

    @Override
    public void parseJson(JsonObject json) {
        try {
            JsonObject block_action = json.getAsJsonObject("block_action");
            Class<? extends BlockAction> klass = TypeMaps.blockActionTypes.get(block_action.get("type").getAsString());
            blockAction = klass.getDeclaredConstructor().newInstance();
            blockAction.parseJson(block_action);
        } catch (Exception e) {
            Runics.LOGGER.error(e.toString());
        }
    }
}
