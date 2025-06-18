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

package net.sergofox123.versecraft.worldgen.features;

import net.frozenblock.lib.worldgen.feature.api.FrozenLibConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.sergofox123.versecraft.VerseSharedConstants;
import org.jetbrains.annotations.NotNull;

public class VFeatureUtils {

	private VFeatureUtils() {
		throw new UnsupportedOperationException("FeatureUtils contains only static declarations.");
	}

	@NotNull
	public static FrozenLibConfiguredFeature<NoneFeatureConfiguration> register(@NotNull String id, @NotNull Feature<NoneFeatureConfiguration> feature) {
		return register(id, feature, FeatureConfiguration.NONE);
	}

	@NotNull
	public static <FC extends FeatureConfiguration, F extends Feature<FC>> FrozenLibConfiguredFeature<FC> register(@NotNull String id, F feature, @NotNull FC config) {
		var key = VerseSharedConstants.id(id);
		FrozenLibConfiguredFeature<FC> frozen = new FrozenLibConfiguredFeature<>(key);
		frozen.makeAndSetHolder(feature, config);
		return frozen;
	}

	@NotNull
	public static <FC extends FeatureConfiguration, F extends Feature<FC>> FrozenLibConfiguredFeature<FC> register(@NotNull String id) {
		var key = VerseSharedConstants.id(id);
		return new FrozenLibConfiguredFeature<>(key);
	}
}
