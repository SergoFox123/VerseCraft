package net.sergofox123.versecraft.registry;

import net.frozenblock.lib.item.impl.sherd.DecoratedPotPatternRegistryEntrypoint;
import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.sergofox123.versecraft.VerseSharedConstants;

public class RegisterDecoratedPotPattern implements DecoratedPotPatternRegistryEntrypoint {

	@Override
	public void bootstrap(Registry<DecoratedPotPattern> registry) {

		register(registry, "dragon");
		register(registry, "egg");
		register(registry, "pillager");
		register(registry, "portal");
		register(registry, "sword");

	}

	public static void register(@NotNull Registry<DecoratedPotPattern> registry, String sherdName) {
		ResourceLocation location = VerseSharedConstants.id(sherdName + "_pottery_pattern");
		DecoratedPotPatternRegistryEntrypoint.register(
			registry,
			ResourceKey.create(Registries.DECORATED_POT_PATTERN, location),
			location
		);
	}

}

