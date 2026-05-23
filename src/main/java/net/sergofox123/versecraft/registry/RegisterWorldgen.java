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

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.sergofox123.versecraft.VerseSharedConstants;

public class RegisterWorldgen {

	private static final ResourceKey<PlacedFeature> POP_FLOWER_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, VerseSharedConstants.id("pop_flower_placed"));
	private static final ResourceKey<PlacedFeature> SHORT_MYCELIUM_GRASS_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, VerseSharedConstants.id("short_mycelium_grass_placed"));
	private static final ResourceKey<PlacedFeature> TALL_MYCELIUM_GRASS_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, VerseSharedConstants.id("tall_mycelium_grass_placed"));
	private static final ResourceKey<PlacedFeature> GLOWSHROOM_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, VerseSharedConstants.id("glowshroom_placed"));

	public static void init() {
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.MUSHROOM_FIELDS), GenerationStep.Decoration.VEGETAL_DECORATION, POP_FLOWER_PLACED);
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.MUSHROOM_FIELDS), GenerationStep.Decoration.VEGETAL_DECORATION, SHORT_MYCELIUM_GRASS_PLACED);
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.MUSHROOM_FIELDS), GenerationStep.Decoration.VEGETAL_DECORATION, TALL_MYCELIUM_GRASS_PLACED);
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.MUSHROOM_FIELDS), GenerationStep.Decoration.VEGETAL_DECORATION, GLOWSHROOM_PLACED);
	}

	private RegisterWorldgen() {
		throw new UnsupportedOperationException("RegisterWorldgen contains only static declarations.");
	}
}
