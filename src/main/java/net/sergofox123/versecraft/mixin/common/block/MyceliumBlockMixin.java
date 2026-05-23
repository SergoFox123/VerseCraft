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

package net.sergofox123.versecraft.mixin.common.block;

import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.MyceliumBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.sergofox123.versecraft.VerseSharedConstants;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(MyceliumBlock.class)
public abstract class MyceliumBlockMixin implements BonemealableBlock {
	@Unique
	private static final ResourceKey<PlacedFeature> VERSECRAFT$SHORT_MYCELIUM_GRASS_BONEMEAL = ResourceKey.create(Registries.PLACED_FEATURE, VerseSharedConstants.id("short_mycelium_grass_bonemeal"));
	@Unique
	private static final ResourceKey<PlacedFeature> VERSECRAFT$TALL_MYCELIUM_GRASS_BONEMEAL = ResourceKey.create(Registries.PLACED_FEATURE, VerseSharedConstants.id("tall_mycelium_grass_bonemeal"));
	@Unique
	private static final ResourceKey<PlacedFeature> VERSECRAFT$POP_FLOWER_BONEMEAL = ResourceKey.create(Registries.PLACED_FEATURE, VerseSharedConstants.id("pop_flower_bonemeal"));
	@Unique
	private static final ResourceKey<PlacedFeature> VERSECRAFT$GLOWSHROOM_BONEMEAL = ResourceKey.create(Registries.PLACED_FEATURE, VerseSharedConstants.id("glowshroom_bonemeal"));

	@Override
	public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
		BlockPos above = blockPos.above();
		return levelReader.getBlockState(above).isAir() && levelReader.isInsideBuildHeight(above);
	}

	@Override
	public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
		return true;
	}

	@Override
	public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
		Registry<PlacedFeature> placedFeatures = serverLevel.registryAccess().lookupOrThrow(Registries.PLACED_FEATURE);
		BlockPos origin = blockPos.above();

		for (int i = 0; i < 128; ++i) {
			BlockPos candidatePos = origin;
			boolean canPlace = true;

			for (int j = 0; j < i / 16; ++j) {
				candidatePos = candidatePos.offset(
					randomSource.nextInt(3) - 1,
					(randomSource.nextInt(3) - 1) * randomSource.nextInt(3) / 2,
					randomSource.nextInt(3) - 1
				);

				if (!serverLevel.getBlockState(candidatePos.below()).is(Blocks.MYCELIUM) || serverLevel.getBlockState(candidatePos).isCollisionShapeFullBlock(serverLevel, candidatePos)) {
					canPlace = false;
					break;
				}
			}

			if (canPlace && !serverLevel.isOutsideBuildHeight(candidatePos) && serverLevel.getBlockState(candidatePos).isAir()) {
				BlockPos placePos = candidatePos;
				this.versecraft$selectBonemealFeature(placedFeatures, randomSource)
					.ifPresent(feature -> feature.value().place(serverLevel, serverLevel.getChunkSource().getGenerator(), randomSource, placePos));
			}
		}
	}

	@Override
	public BonemealableBlock.Type getType() {
		return BonemealableBlock.Type.NEIGHBOR_SPREADER;
	}

	@Unique
	private Optional<Holder.Reference<PlacedFeature>> versecraft$selectBonemealFeature(Registry<PlacedFeature> placedFeatures, RandomSource randomSource) {
		int choice = randomSource.nextInt(12);
		if (choice == 0) {
			return placedFeatures.get(VERSECRAFT$GLOWSHROOM_BONEMEAL);
		}
		if (choice == 1) {
			return placedFeatures.get(VERSECRAFT$POP_FLOWER_BONEMEAL);
		}
		if (choice < 5) {
			return placedFeatures.get(VERSECRAFT$TALL_MYCELIUM_GRASS_BONEMEAL);
		}
		return placedFeatures.get(VERSECRAFT$SHORT_MYCELIUM_GRASS_BONEMEAL);
	}
}
