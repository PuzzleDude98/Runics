package net.pd98.runics.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.pd98.runics.entity.ModBlockEntities;
import net.pd98.runics.entity.custom.RuneBlockEntity;
import org.jetbrains.annotations.Nullable;

public class RuneBlock extends BlockWithEntity implements BlockEntityProvider {

    private static final VoxelShape SHAPE = RuneBlock.createCuboidShape(0,0,0,16,1,16);

    public RuneBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return ModBlockEntities.RUNE_BLOCK_ENTITY.instantiate(pos, state);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
//            CHECK IF RUNE IS ACTION ON USE
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof RuneBlockEntity runeBlockEntity && player != null) {
                player.sendMessage(Text.literal("Right clicked rune at " + pos.toShortString()));
            }
        }
        return ActionResult.success(world.isClient);
    }
}
