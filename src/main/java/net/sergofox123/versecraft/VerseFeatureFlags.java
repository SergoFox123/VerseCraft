package net.sergofox123.versecraft;

import net.frozenblock.lib.FrozenBools;
import net.frozenblock.lib.feature_flag.api.FrozenFeatureFlags;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;

public class VerseFeatureFlags {
	public static final FeatureFlag VERSE_CRAFT = FrozenFeatureFlags.builder.create(VerseSharedConstants.id(VerseSharedConstants.MOD_ID));
	public static final FeatureFlagSet VERSE_CRAFT_FLAG_SET = FeatureFlagSet.of(VERSE_CRAFT);

	public static final FeatureFlag FEATURE_FLAG = FrozenBools.IS_DATAGEN ? VERSE_CRAFT : FeatureFlags.VANILLA;

	public static void init() {
	}
}
