package net.sergofox123.versecraft.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.sergofox123.versecraft.VerseSharedConstants;
import org.jetbrains.annotations.NotNull;

public class VerseCraftBiomeTags {

	public static final TagKey<Biome> HAS_CRYPTIC_CRYPT = bind("has_structure/cryptic_crypt");

	@NotNull
	private static TagKey<Biome> bind(@NotNull String path) {
		return TagKey.create(Registries.BIOME, VerseSharedConstants.id(path));
	}
}

