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
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.sergofox123.versecraft.registry.RegisterBlocks;
import net.sergofox123.versecraft.registry.RegisterItems;
import org.jetbrains.annotations.NotNull;

public class IceflowerCropBlock extends CropBlock {
	public static final MapCodec<IceflowerCropBlock> CODEC = simpleCodec(IceflowerCropBlock::new);
	public static final int MAX_AGE = 2;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_1;
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
		Block.box(5D, 0D, 5D, 11D, 6D, 11D),
		Block.box(5D, 0D, 5D, 11D, 10D, 11D)
	};
	private static final int BONEMEAL_INCREASE = 1;

	@Override
	@NotNull
	public MapCodec<IceflowerCropBlock> codec() {
		return CODEC;
	}

	public IceflowerCropBlock(BlockBehaviour.Properties settings) {
		super(settings);
	}

	@Override
	protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AGE);
	}

	@Override
	@NotNull
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE_BY_AGE[this.getAge(state)];
	}

	@Override
	@NotNull
	protected IntegerProperty getAgeProperty() {
		return AGE;
	}

	@Override
	public int getMaxAge() {
		return MAX_AGE;
	}

	@Override
	@NotNull
	protected ItemLike getBaseSeedId() {
		return RegisterItems.ICEFLOWER_SEEDS;
	}

	@Override
	@NotNull
	public BlockState getStateForAge(int age) {
		return age == MAX_AGE ? RegisterBlocks.ICEFLOWER.defaultBlockState() : super.getStateForAge(age);
	}

	@Override
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, @NotNull RandomSource random) {
		if (random.nextInt(3) != 0) super.randomTick(state, level, pos, random);
	}

	@Override
	protected int getBonemealAgeIncrease(Level level) {
		return BONEMEAL_INCREASE;
	}
}
