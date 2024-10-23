package net.sergofox123.versecraft.tag;


import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.sergofox123.versecraft.VerseSharedConstants;
import org.jetbrains.annotations.NotNull;

public final class VerseBlockTags {

	public static final TagKey<Block> FALLEN_TREE_PLACEABLE = bind("feature/fallen_tree_placeable");


	private VerseBlockTags() {
		throw new UnsupportedOperationException("BlockTags contains only static declarations.");
	}

	@NotNull
	private static TagKey<Block> bind(@NotNull String path) {
		return TagKey.create(Registries.BLOCK, VerseSharedConstants.id(path));
	}
}
