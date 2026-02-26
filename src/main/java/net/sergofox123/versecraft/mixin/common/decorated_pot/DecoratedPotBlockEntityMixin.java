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

package net.sergofox123.versecraft.mixin.common.decorated_pot;


import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.sergofox123.versecraft.impl.client.DecoratedPotBlockEntityInterface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DecoratedPotBlockEntity.class)
public class DecoratedPotBlockEntityMixin implements DecoratedPotBlockEntityInterface {
	@Unique
	private boolean verseCraft$flipWobble = false;

	@Inject(
		method = "triggerEvent",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/level/Level;getGameTime()J"
		)
	)
	public void verseCraft$flipWobble(int event, int data, CallbackInfoReturnable<Boolean> info) {
		this.verseCraft$flipWobble = !this.verseCraft$flipWobble;
	}

	@Unique
	@Override
	public boolean verseCraft$isWobbleFlipped() {
		return this.verseCraft$flipWobble;
	}
}
