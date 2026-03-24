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

import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.sergofox123.versecraft.VerseSharedConstants;
import net.sergofox123.versecraft.registry.RegisterEntityTypes;

public class ModelLayers {

	// BOATS
	public static final ModelLayerLocation AZALEA_BOAT = new ModelLayerLocation(VerseSharedConstants.id("boat/azalea"), "main");
	public static final ModelLayerLocation AZALEA_CHEST_BOAT = new ModelLayerLocation(VerseSharedConstants.id("chest_boat/azalea"), "main");

	public static void init() {

		EntityRenderers.register(RegisterEntityTypes.AZALEA_BOAT, context -> new BoatRenderer(context, AZALEA_BOAT));
		EntityRenderers.register(RegisterEntityTypes.AZALEA_CHEST_BOAT, context -> new BoatRenderer(context, AZALEA_CHEST_BOAT));

		final LayerDefinition boat = BoatModel.createBoatModel();
		final LayerDefinition chestBoat = BoatModel.createChestBoatModel();

		ModelLayerRegistry.registerModelLayer(AZALEA_BOAT, () -> boat);
		ModelLayerRegistry.registerModelLayer(AZALEA_CHEST_BOAT, () -> chestBoat);

	}
}
