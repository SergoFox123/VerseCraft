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

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.sergofox123.versecraft.VerseSharedConstants;
import org.jetbrains.annotations.NotNull;

public class RegisterStructurePieceTypes {

	public static void init() {
	}

	private static @NotNull StructurePieceType setFullContextPieceId(StructurePieceType type, String id) {
		return Registry.register(BuiltInRegistries.STRUCTURE_PIECE, VerseSharedConstants.id(id), type);
	}

	private static @NotNull StructurePieceType setPieceId(StructurePieceType.ContextlessType simplePieceType, String id) {
		return setFullContextPieceId(simplePieceType, id);
	}

	private static @NotNull StructurePieceType setTemplatePieceId(StructurePieceType.StructureTemplateType managerAwarePieceType, String id) {
		return setFullContextPieceId(managerAwarePieceType, id);
	}
}
