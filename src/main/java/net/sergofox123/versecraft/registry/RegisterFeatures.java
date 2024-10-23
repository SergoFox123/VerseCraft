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

package net.sergofox123.versecraft.registry;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.MultifaceGrowthConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.sergofox123.versecraft.VerseSharedConstants;
import net.sergofox123.versecraft.world.impl.trunk.FallenLargeTrunkPlacer;
import net.sergofox123.versecraft.world.impl.trunk.FallenWithLogsTrunkPlacer;
import org.jetbrains.annotations.NotNull;

public class RegisterFeatures {

	public static final TrunkPlacerType<FallenWithLogsTrunkPlacer> FALLEN_WITH_LOGS_TRUNK_PLACER = registerTrunk("fallen_with_logs_trunk_placer", FallenWithLogsTrunkPlacer.CODEC);
	public static final TrunkPlacerType<FallenLargeTrunkPlacer> FALLEN_LARGE_TRUNK_PLACER = registerTrunk("fallen_large_trunk_placer", FallenLargeTrunkPlacer.CODEC);


	public static void init() {
	}

	@NotNull
	private static <P extends TrunkPlacer> TrunkPlacerType<P> registerTrunk(@NotNull String id, @NotNull MapCodec<P> codec) {
		return Registry.register(BuiltInRegistries.TRUNK_PLACER_TYPE, VerseSharedConstants.id(id), new TrunkPlacerType<>(codec));
	}

	@NotNull
	private static <P extends FoliagePlacer> FoliagePlacerType<P> registerFoliage(@NotNull String id, @NotNull MapCodec<P> codec) {
		return Registry.register(BuiltInRegistries.FOLIAGE_PLACER_TYPE, VerseSharedConstants.id(id), new FoliagePlacerType<>(codec));
	}

	@NotNull
	private static <FC extends FeatureConfiguration, T extends Feature<FC>> T register(@NotNull String id, @NotNull T feature) {
		return Registry.register(BuiltInRegistries.FEATURE, VerseSharedConstants.id(id), feature);
	}
}
