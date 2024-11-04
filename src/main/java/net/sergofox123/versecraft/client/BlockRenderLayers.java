package net.sergofox123.versecraft.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.sergofox123.versecraft.registry.RegisterBlocks;

@Environment(EnvType.CLIENT)
public class BlockRenderLayers {

	public static void init() {
		BlockRenderLayerMap renderLayerRegistry = BlockRenderLayerMap.INSTANCE;

		renderLayerRegistry.putBlock(RegisterBlocks.AZALEA_DOOR, RenderType.cutout());
		renderLayerRegistry.putBlock(RegisterBlocks.AZALEA_TRAPDOOR, RenderType.cutout());

	}
}
