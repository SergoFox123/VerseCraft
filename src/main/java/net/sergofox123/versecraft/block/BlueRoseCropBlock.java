/*
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, see <https://www.gnu.org/licenses/>.
 */

package net.sergofox123.versecraft.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.sergofox123.versecraft.registry.RegisterBlocks;
import net.sergofox123.versecraft.registry.RegisterItems;

public class BlueRoseCropBlock extends CropBlock {
	public static final MapCodec<net.minecraft.world.level.block.TorchflowerCropBlock> CODEC = simpleCodec(net.minecraft.world.level.block.TorchflowerCropBlock::new);
	public static final int MAX_AGE = 2;
	public static final IntegerProperty AGE;
	private static final float AABB_OFFSET = 3.0F;
	private static final VoxelShape[] SHAPE_BY_AGE;
	private static final int BONEMEAL_INCREASE = 1;

	public MapCodec<net.minecraft.world.level.block.TorchflowerCropBlock> codec() {
		return CODEC;
	}

	public BlueRoseCropBlock(BlockBehaviour.Properties settings) {
		super(settings);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(new Property[]{AGE});
	}

	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return SHAPE_BY_AGE[this.getAge(state)];
	}

	protected IntegerProperty getAgeProperty() {
		return AGE;
	}

	public int getMaxAge() {
		return 2;
	}

	protected ItemLike getBaseSeedId() {
		return RegisterItems.BLUE_ROSE_SEEDS;
	}

	public BlockState getStateForAge(int age) {
		return age == 2 ? RegisterBlocks.BLUE_ROSE.defaultBlockState() : super.getStateForAge(age);
	}

	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
		if (random.nextInt(3) != 0) {
			super.randomTick(state, world, pos, random);
		}

	}

	protected int getBonemealAgeIncrease(Level world) {
		return 1;
	}

	static {
		AGE = BlockStateProperties.AGE_1;
		SHAPE_BY_AGE = new VoxelShape[]{Block.box(5.0, 0.0, 5.0, 11.0, 6.0, 11.0), Block.box(5.0, 0.0, 5.0, 11.0, 10.0, 11.0)};
	}
}
