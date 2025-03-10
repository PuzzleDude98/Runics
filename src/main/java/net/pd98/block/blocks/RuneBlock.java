package net.pd98.block.blocks;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.serialization.MapCodec;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pd98.Runics;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class RuneBlock extends BlockWithEntity {
    public RuneBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(RuneBlock::new);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RuneBlockEntity(pos, state);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        if (world.isClient()) {
            return super.onUse(state, world, pos, player, hit);
        }

        if (!(world.getBlockEntity(pos) instanceof RuneBlockEntity runeBlockEntity)) {
            return super.onUse(state, world, pos, player, hit);
        }

        player.sendMessage(Text.literal(runeBlockEntity.getRuneData().toString()), true);

        return ActionResult.SUCCESS;
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient() || !(world.getBlockEntity(pos) instanceof RuneBlockEntity runeBlockEntity) || !(stack.isOf(Items.STICK) || stack.isOf(Items.BLAZE_ROD))) {
            return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
        }

        if (stack.isOf(Items.STICK)) {
            try {
                Path filePath = FabricLoader.getInstance().getConfigDir().resolve("runics/data.json");
                runeBlockEntity.setRuneData(JsonParser.parseString(Files.readString(filePath)).getAsJsonObject());
                player.sendMessage(Text.literal("Written!"), true);
                runeBlockEntity.parseJson();
            } catch (Exception e) {
                Runics.LOGGER.error(e.toString());
                return ActionResult.FAIL;
            }
        } else if (stack.isOf(Items.BLAZE_ROD)) {
            runeBlockEntity.trigger(player);
        }

        return ActionResult.SUCCESS;
    }
}
