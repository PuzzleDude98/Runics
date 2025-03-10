package net.pd98.types.entity_condition_types;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.pd98.types.ParsableObject;

public abstract class EntityCondition extends ParsableObject {

    public abstract boolean evaluate(World world, Entity entity);

}
