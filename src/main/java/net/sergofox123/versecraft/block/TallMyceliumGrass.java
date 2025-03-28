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
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.sergofox123.versecraft.registry.RegisterBlocks;

public class TallMyceliumGrass extends DryVegetationBlock implements BonemealableBlock {
	public static final MapCodec<TallMyceliumGrass> CODEC = simpleCodec(TallMyceliumGrass::new);
	private static final VoxelShape SHAPE = Block.column((double)14.0F, (double)0.0F, (double)16.0F);

	public MapCodec<TallMyceliumGrass> codec() {
		return CODEC;
	}

	public TallMyceliumGrass(BlockBehaviour.Properties properties) {
		super(properties);
	}

	protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return SHAPE;
	}

	public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
		return BonemealableBlock.hasSpreadableNeighbourPos(levelReader, blockPos, RegisterBlocks.SHORT_MYCELIUM_GRASS.defaultBlockState());
	}

	public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
		return true;
	}

	public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
		BonemealableBlock.findSpreadableNeighbourPos(serverLevel, blockPos, RegisterBlocks.SHORT_MYCELIUM_GRASS.defaultBlockState()).ifPresent((blockPosx) -> serverLevel.setBlockAndUpdate(blockPosx, RegisterBlocks.SHORT_MYCELIUM_GRASS.defaultBlockState()));
	}
}

