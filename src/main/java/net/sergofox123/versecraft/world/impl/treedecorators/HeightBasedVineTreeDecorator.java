package net.sergofox123.versecraft.world.impl.treedecorators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import org.jetbrains.annotations.NotNull;

public class HeightBasedVineTreeDecorator extends TreeDecorator {
	public static final MapCodec<HeightBasedVineTreeDecorator> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(
		Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter((treeDecorator) -> treeDecorator.probability),
		Codec.intRange(-63, 319).fieldOf("max_height").forGetter((treeDecorator) -> treeDecorator.maxHeight),
		Codec.floatRange(0.0F, 1.0F).fieldOf("placement_chance").forGetter((treeDecorator) -> treeDecorator.placementChance)
	).apply(instance, HeightBasedVineTreeDecorator::new));

	private final float probability;
	private final int maxHeight;
	private final float placementChance;

	public HeightBasedVineTreeDecorator(float probability, int maxHeight, float placementChance) {
		this.probability = probability;
		this.maxHeight = maxHeight;
		this.placementChance = placementChance;
	}

	@NotNull
	protected TreeDecoratorType<?> type() {
		return VerseTreeDecorators.HEIGHT_BASED_VINE_TREE_DECORATOR;
	}

	public void place(@NotNull TreeDecorator.Context generator) {
		RandomSource random = generator.random();
		if (random.nextFloat() <= this.probability) {
			ObjectArrayList<BlockPos> poses = new ObjectArrayList<>(generator.logs());
			poses.addAll(generator.roots());
			Util.shuffle(poses, random);
			BlockState vineState = Blocks.VINE.defaultBlockState();
			BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
			for (BlockPos pos : poses) {
				if (pos.getY() <= this.maxHeight) {
					for (Direction direction : Direction.Plane.HORIZONTAL) {
						if (random.nextFloat() <= this.placementChance) {
							mutableBlockPos.setWithOffset(pos, direction);
							if (generator.isAir(mutableBlockPos)) {
								generator.setBlock(mutableBlockPos, vineState.setValue(VineBlock.PROPERTY_BY_DIRECTION.get(direction.getOpposite()), true));
							}
						}
					}
				}
			}
		}
	}
}
