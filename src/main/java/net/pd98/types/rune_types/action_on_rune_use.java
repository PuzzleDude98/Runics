package net.pd98.types.rune_types;

import com.google.gson.JsonObject;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pd98.TypeMaps;
import net.pd98.types.Rune;
import net.pd98.types.block_action_types.BlockAction;
import net.pd98.types.entity_action_types.EntityAction;
import net.pd98.types.entity_condition_types.EntityCondition;

public class action_on_rune_use extends Rune {
    private BlockAction block_action;
    private EntityAction entity_action;
    private EntityCondition entity_condition;

    public void trigger(World world, BlockPos pos, PlayerEntity player) {
        super.trigger(world, pos, player);

        if (entity_condition != null && !entity_condition.evaluate(world, player)) {
            return;
        }

        if (block_action != null) {
            block_action.trigger(world, pos);
        }

        if (entity_action != null) {
            entity_action.trigger(world, player);
        }
    }

    @Override
    public void parseJson(JsonObject json) {
        block_action = (BlockAction) parseOptionalObject(json, "block_action", TypeMaps.blockActionTypes);
        entity_action = (EntityAction) parseOptionalObject(json, "entity_action", TypeMaps.entityActionTypes);
        entity_condition = (EntityCondition) parseOptionalObject(json, "entity_condition", TypeMaps.entityConditionTypes);

        super.parseJson(json);
    }
}
