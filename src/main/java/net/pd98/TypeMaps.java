package net.pd98;

import net.pd98.types.Rune;
import net.pd98.types.block_action_types.BlockAction;
import net.pd98.types.block_action_types.explode;
import net.pd98.types.block_condition_types.BlockCondition;
import net.pd98.types.block_condition_types.block;
import net.pd98.types.block_condition_types.offset;
import net.pd98.types.entity_action_types.EntityAction;
import net.pd98.types.entity_action_types.add_velocity;
import net.pd98.types.entity_condition_types.EntityCondition;
import net.pd98.types.meta_condition_types.andEntity;
import net.pd98.types.entity_condition_types.on_fire;
import net.pd98.types.entity_condition_types.time_of_day;
import net.pd98.types.rune_types.action_on_rune_use;

import java.util.HashMap;
import java.util.Map;

public class TypeMaps {

    public static final Map<String, Class<? extends Rune>> runeTypes = new HashMap<>();

    public static final Map<String, Class<? extends BlockAction>> blockActionTypes = new HashMap<>();

    public static final Map<String, Class<? extends BlockCondition>> blockConditionTypes = new HashMap<>();

    public static final Map<String, Class<? extends EntityCondition>> entityConditionTypes = new HashMap<>();

    public static final Map<String, Class<? extends EntityAction>> entityActionTypes = new HashMap<>();

    static {
        runeTypes.put("action_on_rune_use", action_on_rune_use.class);

        blockActionTypes.put("explode", explode.class);

        blockConditionTypes.put("offset", offset.class);
        blockConditionTypes.put("block", block.class);

        entityActionTypes.put("add_velocity", add_velocity.class);

        entityConditionTypes.put("on_fire", on_fire.class);
        entityConditionTypes.put("time_of_day", time_of_day.class);
        entityConditionTypes.put("and", andEntity.class);
    }

}
