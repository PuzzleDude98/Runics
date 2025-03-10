package net.pd98.types.entity_action_types;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.pd98.types.ParsableObject;

public abstract class EntityAction extends ParsableObject {

    public abstract void trigger(World world, Entity entity);

}
