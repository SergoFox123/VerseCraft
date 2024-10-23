package net.sergofox123.versecraft.world.feature;

import java.util.List;
import net.frozenblock.lib.worldgen.feature.api.FrozenPlacedFeature;
import net.frozenblock.lib.worldgen.feature.api.placementmodifier.NoisePlacementFilter;
import net.sergofox123.versecraft.VerseSharedConstants;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import org.jetbrains.annotations.NotNull;

public class VersePlacementUtils {

	private VersePlacementUtils() {
		throw new UnsupportedOperationException("VersePlacementUtils contains only static declarations.");
	}

	@NotNull
	@SuppressWarnings({"unchecked", "rawtypes"})
	public static <FC extends FeatureConfiguration> FrozenPlacedFeature register(@NotNull String id, Holder<ConfiguredFeature<FC, ?>> configured, @NotNull List<PlacementModifier> modifiers) {
		return new FrozenPlacedFeature(VerseSharedConstants.id(id))
			.makeAndSetHolder((Holder) configured, modifiers);
	}

	@NotNull
	public static <FC extends FeatureConfiguration> FrozenPlacedFeature register(@NotNull String id, Holder<ConfiguredFeature<FC, ?>> registryEntry, @NotNull PlacementModifier... modifiers) {
		return register(id, registryEntry, List.of(modifiers));
	}

	@NotNull
	public static FrozenPlacedFeature register(@NotNull String id) {
		var key = VerseSharedConstants.id(id);
		return new FrozenPlacedFeature(key);
	}

}
