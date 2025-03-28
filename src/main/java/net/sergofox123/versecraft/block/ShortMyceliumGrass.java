package net.sergofox123.versecraft.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.DryVegetationBlock;
import net.minecraft.world.level.block.ShortDryGrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.sergofox123.versecraft.registry.RegisterBlocks;

public class ShortMyceliumGrass extends DryVegetationBlock implements BonemealableBlock {
	public static final MapCodec<ShortMyceliumGrass> CODEC = simpleCodec(ShortMyceliumGrass::new);
	private static final VoxelShape SHAPE = Block.column((double)12.0F, (double)0.0F, (double)10.0F);

	public MapCodec<ShortMyceliumGrass> codec() {
		return CODEC;
	}

	public ShortMyceliumGrass(BlockBehaviour.Properties properties) {
		super(properties);
	}

	protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return SHAPE;
	}

	public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
		return true;
	}

	public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
		return true;
	}

	public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
		serverLevel.setBlockAndUpdate(blockPos, RegisterBlocks.TALL_MYCELIUM_GRASS.defaultBlockState());
	}
}
