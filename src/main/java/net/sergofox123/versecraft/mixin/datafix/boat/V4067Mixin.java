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
package net.sergofox123.versecraft.mixin.datafix.boat;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.types.templates.TypeTemplate;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.util.datafix.schemas.V4067;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(V4067.class)
public abstract class V4067Mixin {

	@Shadow
	protected abstract void registerChestBoat(Map<String, Supplier<TypeTemplate>> map, String string);

	@Inject(method = "registerEntities", at = @At("RETURN"))
	public void verseCraft$registerBlockEntities(
		Schema schema, CallbackInfoReturnable<Map<String, Supplier<TypeTemplate>>> info,
		@Local Map<String, Supplier<TypeTemplate>> map
	) {
		schema.registerSimple(map, "versecraft:azalea_boat");

		this.registerChestBoat(map, "versecraft:azalea_chest_boat");
	}
}
