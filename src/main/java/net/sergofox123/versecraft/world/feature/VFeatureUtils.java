package net.sergofox123.versecraft.world.feature;

import net.frozenblock.lib.worldgen.feature.api.FrozenLibConfiguredFeature;
import net.sergofox123.versecraft.VerseSharedConstants;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.jetbrains.annotations.NotNull;

public class VFeatureUtils {

	private VFeatureUtils() {
		throw new UnsupportedOperationException("FeatureUtils contains only static declarations.");
	}

	@NotNull
	public static FrozenLibConfiguredFeature<NoneFeatureConfiguration, ConfiguredFeature<NoneFeatureConfiguration, ?>> register(@NotNull String id, @NotNull Feature<NoneFeatureConfiguration> feature) {
		return register(id, feature, FeatureConfiguration.NONE);
	}

	@NotNull
	public static <FC extends FeatureConfiguration, F extends Feature<FC>> FrozenLibConfiguredFeature<FC, ConfiguredFeature<FC, ?>> register(@NotNull String id, F feature, @NotNull FC config) {
		var key = VerseSharedConstants.id(id);
		FrozenLibConfiguredFeature<FC, ConfiguredFeature<FC, ?>> frozen = new FrozenLibConfiguredFeature<>(key);
		frozen.makeAndSetHolder(feature, config);
		return frozen;
	}

	@NotNull
	public static <FC extends FeatureConfiguration, F extends Feature<FC>> FrozenLibConfiguredFeature<FC, ConfiguredFeature<FC, ?>> register(@NotNull String id) {
		var key = VerseSharedConstants.id(id);
		return new FrozenLibConfiguredFeature<>(key);
	}
}
