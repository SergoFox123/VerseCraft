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
