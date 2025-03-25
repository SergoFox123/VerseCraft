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
import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalBooleanRef;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.sergofox123.versecraft.impl.client.DecoratedPotBlockEntityInterface;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.DecoratedPotRenderer;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(DecoratedPotRenderer.class)
public class DecoratedPotRendererMixin {

	@Inject(
		method = "render(Lnet/minecraft/world/level/block/entity/DecoratedPotBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IILnet/minecraft/world/phys/Vec3;)V",
		at = @At(
			value = "FIELD",
			target = "Lnet/minecraft/world/level/block/entity/DecoratedPotBlockEntity$WobbleStyle;duration:I",
			ordinal = 0
		)
	)
	public void verseCraft$prepareIsFlipped(
		DecoratedPotBlockEntity decoratedPotBlockEntity, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j, Vec3 cameraPos, CallbackInfo info,
		@Share("verseCraft$isFlipped") LocalBooleanRef isFlipped
	) {
		isFlipped.set(decoratedPotBlockEntity instanceof DecoratedPotBlockEntityInterface decoratedPotBlockEntityInterface
			&& decoratedPotBlockEntityInterface.verseCraft$isWobbleFlipped()
		);
	}

	@WrapOperation(
		method = "render(Lnet/minecraft/world/level/block/entity/DecoratedPotBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IILnet/minecraft/world/phys/Vec3;)V",
		at = @At(
			value = "INVOKE",
			target = "Lcom/mojang/math/Axis;rotation(F)Lorg/joml/Quaternionf;"
		)
	)
	public Quaternionf verseCraft$flipWobble(
		Axis instance, float v, Operation<Quaternionf> original,
		@Share("verseCraft$isFlipped") LocalBooleanRef isFlipped
	) {
		return original.call(instance, v * (isFlipped.get() ? -1 : 1F));
	}

}
