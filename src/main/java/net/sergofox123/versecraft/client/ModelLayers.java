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
