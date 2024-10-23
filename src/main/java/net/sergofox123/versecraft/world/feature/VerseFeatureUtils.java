package net.sergofox123.versecraft.world.feature;

import net.frozenblock.lib.worldgen.feature.api.FrozenConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.sergofox123.versecraft.VerseSharedConstants;
import org.jetbrains.annotations.NotNull;

public final class VerseFeatureUtils {
	private VerseFeatureUtils() {
		throw new UnsupportedOperationException("VerseFeatureUtils contains only static declarations.");
	}

	@NotNull
	public static FrozenConfiguredFeature<NoneFeatureConfiguration, ConfiguredFeature<NoneFeatureConfiguration, ?>> register(@NotNull String id, @NotNull Feature<NoneFeatureConfiguration> feature) {
		return register(id, feature, FeatureConfiguration.NONE);
	}

	@NotNull
	public static <FC extends FeatureConfiguration, F extends Feature<FC>> FrozenConfiguredFeature<FC, ConfiguredFeature<FC, ?>> register(@NotNull String id, F feature, @NotNull FC config) {
		var key = VerseSharedConstants.id(id);
		FrozenConfiguredFeature<FC, ConfiguredFeature<FC, ?>> frozen = new FrozenConfiguredFeature<>(key);
		frozen.makeAndSetHolder(feature, config);
		return frozen;
	}

	@NotNull
	public static <FC extends FeatureConfiguration, F extends Feature<FC>> FrozenConfiguredFeature<FC, ConfiguredFeature<FC, ?>> register(@NotNull String id) {
		var key = VerseSharedConstants.id(id);
		return new FrozenConfiguredFeature<>(key);
	}
}
