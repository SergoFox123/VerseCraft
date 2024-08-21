package net.sergofox123.versecraft.registry;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.sergofox123.versecraft.VerseSharedConstants;

public class RegisterStructureTypes {


	public static void init() {
	}

	private static <S extends Structure> StructureType<S> register(String id, MapCodec<S> codec) {
		return Registry.register(BuiltInRegistries.STRUCTURE_TYPE, VerseSharedConstants.id(id), () -> codec);
	}
}
