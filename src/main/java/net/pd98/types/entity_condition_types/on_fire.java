package net.pd98.types.entity_condition_types;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class on_fire extends EntityCondition{
    @Override
    public boolean evaluateBase(World world, Entity entity) {
        return entity.isOnFire();
    }
}
