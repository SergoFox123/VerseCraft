package net.sergofox123.versecraft.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.sergofox123.versecraft.VerseSharedConstants;
import net.sergofox123.versecraft.registry.RegisterEntityTypes;

public class ModelLayers {

	// BOATS
	public static final ModelLayerLocation AZALEA_BOAT = new ModelLayerLocation(VerseSharedConstants.id("boat/azalea"), "main");
	public static final ModelLayerLocation AZALEA_CHEST_BOAT = new ModelLayerLocation(VerseSharedConstants.id("chest_boat/azalea"), "main");


	public static void init() {


		EntityRendererRegistry.register(RegisterEntityTypes.AZALEA_BOAT, context -> new BoatRenderer(context, AZALEA_BOAT));
		EntityRendererRegistry.register(RegisterEntityTypes.AZALEA_CHEST_BOAT, context -> new BoatRenderer(context, AZALEA_CHEST_BOAT));

		LayerDefinition boat = BoatModel.createBoatModel();
		LayerDefinition chestBoat = BoatModel.createChestBoatModel();

		EntityModelLayerRegistry.registerModelLayer(AZALEA_BOAT, () -> boat);
		EntityModelLayerRegistry.registerModelLayer(AZALEA_CHEST_BOAT, () -> chestBoat);

	}
}
