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

package net.sergofox123.versecraft.mixin.common.entity.boat;

import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.sergofox123.versecraft.BoatTypeVerse;
import net.sergofox123.versecraft.registry.RegisterItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Boat.class)
public class BoatDropsMixin {

	@Inject(method = "getDropItem", at = @At("RETURN"), cancellable = true)
	public void verseCraft$getModdedBoats(CallbackInfoReturnable<Item> info) {
		var boat = Boat.class.cast(this);
		if (boat.getVariant() == BoatTypeVerse.AZALEA) {
			info.setReturnValue(RegisterItems.AZALEA_BOAT);
		}
	}
}
