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

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.blockentity.DecoratedPotRenderer;
import net.minecraft.client.renderer.blockentity.state.DecoratedPotRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.phys.Vec3;
import net.sergofox123.versecraft.impl.client.DecoratedPotBlockEntityInterface;
import net.sergofox123.versecraft.impl.client.DecoratedPotRenderStateInterface;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(DecoratedPotRenderer.class)
public class DecoratedPotRendererMixin {

	@Inject(
		method = "extractRenderState(Lnet/minecraft/world/level/block/entity/DecoratedPotBlockEntity;Lnet/minecraft/client/renderer/blockentity/state/DecoratedPotRenderState;FLnet/minecraft/world/phys/Vec3;Lnet/minecraft/client/renderer/feature/ModelFeatureRenderer$CrumblingOverlay;)V",
		at = @At("TAIL")
	)
	public void verseCraft$setIsFlipped(
		DecoratedPotBlockEntity decoratedPot,
		DecoratedPotRenderState renderState,
		float partialTick,
		Vec3 cameraPos,
		ModelFeatureRenderer.CrumblingOverlay crumblingOverlay,
		CallbackInfo info
	) {
		if (!(decoratedPot instanceof DecoratedPotBlockEntityInterface potInterface)) return;
		if (!(renderState instanceof DecoratedPotRenderStateInterface stateInterface)) return;
		stateInterface.verseCraft$setWobbleFlipped(potInterface.verseCraft$isWobbleFlipped());
	}

	@WrapOperation(
		method = "submit(Lnet/minecraft/client/renderer/blockentity/state/DecoratedPotRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;Lnet/minecraft/client/renderer/state/CameraRenderState;)V",
		at = @At(
			value = "INVOKE",
			target = "Lcom/mojang/math/Axis;rotation(F)Lorg/joml/Quaternionf;"
		)
	)
	public Quaternionf trailierTales$flipWobble(
		Axis instance, float v, Operation<Quaternionf> original,
		@Local(argsOnly = true) DecoratedPotRenderState renderState
	) {
		float multiplier = 1F;
		if (renderState instanceof DecoratedPotRenderStateInterface stateInterface) multiplier = stateInterface.verseCraft$isWobbleFlipped() ? -1F : 1F;
		return original.call(instance, v * multiplier);
	}

}
