package net.pd98.block.blocks;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.JsonOps;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.nbt.NbtOps;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.pd98.Runics;
import net.pd98.block.ModBlockEntities;

public class RuneBlockEntity extends BlockEntity {
    public RuneBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.RUNE_BLOCK_ENTITY, pos, state);
    }

    private JsonElement runeData = new JsonObject();

    public JsonElement getRuneData() {
        return runeData;
    }

    public void setRuneData(JsonElement runeData) {
        this.runeData = runeData;
        markDirty();
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.readNbt(nbt, registries);
        runeData = NbtOps.INSTANCE.convertTo(JsonOps.INSTANCE, nbt.get("runeData"));
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        nbt.put("runeData", JsonOps.INSTANCE.convertTo(NbtOps.INSTANCE, runeData));
        super.writeNbt(nbt, registries);
    }
}
