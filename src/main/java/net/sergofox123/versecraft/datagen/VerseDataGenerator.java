package net.sergofox123.versecraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.frozenblock.lib.feature_flag.api.FrozenFeatureFlags;
import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.sergofox123.versecraft.VerseSharedConstants;
import net.sergofox123.versecraft.tag.VerseBiomeTags;

public class VerseDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(@NotNull FabricDataGenerator dataGenerator) {
		FrozenFeatureFlags.rebuild();
		final FabricDataGenerator.Pack pack = dataGenerator.createPack();


		//Data
	}

	public void buildRegistry(@NotNull RegistrySetBuilder registryBuilder) {
		VerseSharedConstants.logWithModId("Registering Biomes for", VerseSharedConstants.UNSTABLE_LOGGING);

		registryBuilder.add(Registries.CONFIGURED_FEATURE, VerseFeatureBootstrap::bootstrapConfigured);
		registryBuilder.add(Registries.PLACED_FEATURE, VerseFeatureBootstrap::bootstrapPlaced);

	}

}
