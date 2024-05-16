package net.sergofox123.vercecraft.misc;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.frozenblock.lib.feature_flag.api.FrozenFeatureFlags;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import org.jetbrains.annotations.NotNull;

public final class VerseCraftDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(@NotNull FabricDataGenerator dataGenerator) {
		FrozenFeatureFlags.rebuild();
		final FabricDataGenerator.Pack pack = dataGenerator.createPack();


	}

	@Override
	public void buildRegistry(@NotNull RegistrySetBuilder registryBuilder) {
		VerseSharedConstants.logWithModId("Registering Biomes for", VerseSharedConstants.UNSTABLE_LOGGING);

	}

}
