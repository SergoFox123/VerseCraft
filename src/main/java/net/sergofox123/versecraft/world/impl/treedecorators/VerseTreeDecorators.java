package net.sergofox123.versecraft.world.impl.treedecorators;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.sergofox123.versecraft.VerseSharedConstants;
import org.jetbrains.annotations.NotNull;

public class VerseTreeDecorators {

	public static final TreeDecoratorType<HeightBasedVineTreeDecorator> HEIGHT_BASED_VINE_TREE_DECORATOR = register("height_based_vine_tree_decorator", HeightBasedVineTreeDecorator.CODEC);

	public static void generateTreeDecorators() {
		//Just to ensure the class is loaded.
	}

	@NotNull
	private static <P extends TreeDecorator> TreeDecoratorType<P> register(@NotNull String id, @NotNull MapCodec<P> codec) {
		return Registry.register(BuiltInRegistries.TREE_DECORATOR_TYPE, VerseSharedConstants.id(id), new TreeDecoratorType<P>(codec));
	}
}
