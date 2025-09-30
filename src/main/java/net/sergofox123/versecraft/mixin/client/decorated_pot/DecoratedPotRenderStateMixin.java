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

package net.sergofox123.versecraft.mixin.client.decorated_pot;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.blockentity.state.DecoratedPotRenderState;
import net.sergofox123.versecraft.impl.client.DecoratedPotRenderStateInterface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Environment(EnvType.CLIENT)
@Mixin(DecoratedPotRenderState.class)
public class DecoratedPotRenderStateMixin implements DecoratedPotRenderStateInterface {

	@Unique
	private boolean verseCraft$isWobbleFlipped = false;

	@Unique
	@Override
	public void verseCraft$setWobbleFlipped(boolean flipped) {
		this.verseCraft$isWobbleFlipped = flipped;
	}

	@Unique
	@Override
	public boolean verseCraft$isWobbleFlipped() {
		return this.verseCraft$isWobbleFlipped;
	}
}
