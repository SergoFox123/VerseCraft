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

package net.sergofox123.versecraft.world.structure;

import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.sergofox123.versecraft.VerseSharedConstants;
import net.sergofox123.versecraft.registry.RegisterStructures;
import net.sergofox123.versecraft.tag.VerseCraftBiomeTags;

public class CrypticCryptGenerator {
	public static final ResourceKey<StructureSet> CRYPTIC_CRYPTS_KEY =  RegisterStructures.ofSet("cryptic_crypt");
	private static final ResourceKey<Structure> CRYPTIC_CRYPT_KEY = RegisterStructures.createKey("cryptic_crypt");
	public static final ResourceKey<StructureTemplatePool> CRYPTIC_CRYPT = Pools.parseKey(VerseSharedConstants.string("cryptic_crypt"));

	public static void bootstrap(@NotNull BootstrapContext<Structure> context) {
		HolderGetter<Biome> holderGetter = context.lookup(Registries.BIOME);
		HolderGetter<StructureTemplatePool> templatePool = context.lookup(Registries.TEMPLATE_POOL);

		context.register(
			CRYPTIC_CRYPT_KEY,
			new JigsawStructure(
				RegisterStructures.structure(
					holderGetter.getOrThrow(VerseCraftBiomeTags.HAS_CRYPTIC_CRYPT),
					GenerationStep.Decoration.UNDERGROUND_DECORATION,
					TerrainAdjustment.BURY
				),
				templatePool.getOrThrow(CRYPTIC_CRYPT),
				5,
				UniformHeight.of(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(0)),
				false
			)
		);
	}

	public static void bootstrapStructureSet(@NotNull BootstrapContext<StructureSet> context) {
		HolderGetter<Structure> structure = context.lookup(Registries.STRUCTURE);
		context.register(
			CRYPTIC_CRYPTS_KEY,
			new StructureSet(
				structure.getOrThrow(CRYPTIC_CRYPT_KEY),
				new RandomSpreadStructurePlacement(14, 8, RandomSpreadType.LINEAR, 253988502) // ancient city salt is 20083232
			)
		);
	}

	private static @NotNull String string(String name) {
		return VerseSharedConstants.string("cryptic_crypt/" + name);
	}

}
