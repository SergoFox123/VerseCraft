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
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.sergofox123.versecraft.registry.RegisterBlocks;

@Environment(EnvType.CLIENT)
public final class VerseCraftClient implements ClientModInitializer {




	@Override
	public void onInitializeClient() {

		BlockRenderLayerMap renderLayerRegistry = BlockRenderLayerMap.INSTANCE;

		renderLayerRegistry.putBlock(RegisterBlocks.AZALEA_DOOR, RenderType.cutout());
		renderLayerRegistry.putBlock(RegisterBlocks.AZALEA_TRAPDOOR, RenderType.cutout());

		renderLayerRegistry.putBlock(RegisterBlocks.ICEFLOWER, RenderType.cutout());
		renderLayerRegistry.putBlock(RegisterBlocks.POTTED_ICEFLOWER, RenderType.cutout());
		renderLayerRegistry.putBlock(RegisterBlocks.ICEFLOWER_CROP, RenderType.cutout());

		renderLayerRegistry.putBlock(RegisterBlocks.BLUE_ROSE, RenderType.cutout());
		renderLayerRegistry.putBlock(RegisterBlocks.POTTED_BLUE_ROSE, RenderType.cutout());
		renderLayerRegistry.putBlock(RegisterBlocks.BLUE_ROSE_CROP, RenderType.cutout());
	}
}
