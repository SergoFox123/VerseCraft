package net.sergofox123.versecraft.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.frozenblock.lib.entity.api.spawnplacement.FrozenSpawnPlacementTypes;
import net.frozenblock.lib.mobcategory.api.FrozenMobCategories;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.level.levelgen.Heightmap;
import org.jetbrains.annotations.NotNull;

import net.sergofox123.versecraft.VerseSharedConstants;
import org.jetbrains.annotations.NotNull;

public class RegisterEntityTypes {

	// BOATS

	public static final EntityType<Boat> AZALEA_BOAT = register(
		"cypress_boat",
		EntityType.Builder.of(EntityType.boatFactory(() -> RegisterItems.AZALEA_BOAT), MobCategory.MISC)
			.noLootTable()
			.sized(1.375F, 0.5625F)
			.eyeHeight(0.5625F)
			.clientTrackingRange(10)
	);

	public static final EntityType<ChestBoat> AZALEA_CHEST_BOAT = register(
		"cypress_chest_boat",
		EntityType.Builder.of(EntityType.chestBoatFactory(() -> RegisterItems.AZALEA_CHEST_BOAT), MobCategory.MISC)
			.noLootTable()
			.sized(1.375F, 0.5625F)
			.eyeHeight(0.5625F)
			.clientTrackingRange(10)
	);

	static {
		VerseSharedConstants.logWithModId("Registering Entities for", VerseSharedConstants.UNSTABLE_LOGGING);
	}

	private static <T extends Entity> @NotNull EntityType<T> register(String string, EntityType.@NotNull Builder<T> builder) {
		ResourceKey<EntityType<?>> resourceKey = ResourceKey.create(Registries.ENTITY_TYPE, VerseSharedConstants.id(string));
		return Registry.register(BuiltInRegistries.ENTITY_TYPE, resourceKey, builder.build(resourceKey));
	}
}
