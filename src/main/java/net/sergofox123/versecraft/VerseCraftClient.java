/*
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, see <https://www.gnu.org/licenses/>.
 */

package net.sergofox123.versecraft;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.sergofox123.versecraft.client.ModelLayers;
import net.sergofox123.versecraft.registry.RegisterBlocks;

@Environment(EnvType.CLIENT)
public final class VerseCraftClient implements ClientModInitializer {


	@Override
	public void onInitializeClient() {

		ModelLayers.init();

		//Plants
		BlockRenderLayerMap.putBlock(RegisterBlocks.BLUE_ROSE, ChunkSectionLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(RegisterBlocks.BLUE_ROSE_CROP, ChunkSectionLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(RegisterBlocks.POTTED_BLUE_ROSE, ChunkSectionLayer.CUTOUT);

		BlockRenderLayerMap.putBlock(RegisterBlocks.ICEFLOWER, ChunkSectionLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(RegisterBlocks.ICEFLOWER_CROP, ChunkSectionLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(RegisterBlocks.POTTED_ICEFLOWER, ChunkSectionLayer.CUTOUT);

		BlockRenderLayerMap.putBlock(RegisterBlocks.SHORT_MYCELIUM_GRASS, ChunkSectionLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(RegisterBlocks.TALL_MYCELIUM_GRASS, ChunkSectionLayer.CUTOUT);

		BlockRenderLayerMap.putBlock(RegisterBlocks.POP_FLOWER, ChunkSectionLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(RegisterBlocks.POTTED_POP_FLOWER, ChunkSectionLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(RegisterBlocks.GLOWSHROOM, ChunkSectionLayer.CUTOUT);


		//Blocks

		BlockRenderLayerMap.putBlock(RegisterBlocks.AZALEA_DOOR, ChunkSectionLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(RegisterBlocks.AZALEA_TRAPDOOR, ChunkSectionLayer.CUTOUT);
	}
}
