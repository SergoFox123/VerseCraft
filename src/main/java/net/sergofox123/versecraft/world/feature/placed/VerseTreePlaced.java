package net.sergofox123.versecraft.world.feature.placed;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.sergofox123.versecraft.VerseSharedConstants;
import java.util.List;

public final class VerseTreePlaced {
	public static final BlockPredicate SNOW_TREE_PREDICATE = BlockPredicate.matchesBlocks(
		Direction.DOWN.getNormal(),
		Blocks.SNOW_BLOCK,
		Blocks.POWDER_SNOW
	);
	public static final List<PlacementModifier> SNOW_TREE_FILTER_DECORATOR = List.of(
		EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.not(BlockPredicate.matchesBlocks(Blocks.POWDER_SNOW)), 8),
		BlockPredicateFilter.forPredicate(SNOW_TREE_PREDICATE)
	);

	public static void registerTreePlaced() {
		VerseSharedConstants.logWithModId("Registering WilderTreePlaced for", true);
	}
}
