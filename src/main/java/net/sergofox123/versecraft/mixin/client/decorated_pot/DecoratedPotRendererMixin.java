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
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import java.util.Objects;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.DecoratedPotRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import net.sergofox123.versecraft.VerseCraftClient;
import net.sergofox123.versecraft.impl.DecoratedPotBlockEntityInterface;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DecoratedPotRenderer.class)
public class DecoratedPotRendererMixin {
	@Unique
	private static final Material verseCraft$BLANK_MATERIAL = Objects.requireNonNull(Sheets.getDecoratedPotMaterial(VerseCraftClient.BLANK_DECORATED));

	@Unique
	private boolean verseCraft$isMisMatched;

	@Inject(
		method = "render(Lnet/minecraft/world/level/block/entity/DecoratedPotBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V",
		at = @At("HEAD")
	)
	public void verseCraft$render(
		DecoratedPotBlockEntity decoratedPotBlockEntity, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j, CallbackInfo info
	) {
		this.verseCraft$setupMisMatched(decoratedPotBlockEntity);
	}

	@Inject(
		method = "render(Lnet/minecraft/world/level/block/entity/DecoratedPotBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V",
		at = @At(
			value = "FIELD",
			target = "Lnet/minecraft/world/level/block/entity/DecoratedPotBlockEntity$WobbleStyle;duration:I",
			ordinal = 0
		)
	)
	public void verseCraft$prepareIsFlipped(
		DecoratedPotBlockEntity decoratedPotBlockEntity, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j, CallbackInfo info,
		@Share("verseCraft$isFlipped") LocalBooleanRef isFlipped
	) {
		isFlipped.set(((DecoratedPotBlockEntityInterface)decoratedPotBlockEntity).verseCraft$isWobbleFlipped());
	}

	@WrapOperation(
		method = "render(Lnet/minecraft/world/level/block/entity/DecoratedPotBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V",
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

	@Unique
	private void verseCraft$setupMisMatched(@NotNull DecoratedPotBlockEntity decoratedPotBlockEntity) {
		boolean hasBlank = false;
		boolean hasDecorated = false;
		for (Item item : decoratedPotBlockEntity.getDecorations().ordered().stream().toList()) {
			if (
				Sheets.getDecoratedPotMaterial(DecoratedPotPatterns.getPatternFromItem(Items.BRICK)) ==
					Sheets.getDecoratedPotMaterial(DecoratedPotPatterns.getPatternFromItem(item))
			) {
				hasBlank = true;
			} else {
				hasDecorated = true;
			}
		}
		this.verseCraft$isMisMatched = hasBlank && hasDecorated;
	}

	@Inject(
		method = "renderSide",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/model/geom/ModelPart;render(Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/blaze3d/vertex/VertexConsumer;II)V",
			shift = At.Shift.BEFORE
		)
	)
	private void verseCraft$renderSide(
		ModelPart modelPart, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j, @Nullable Material material, CallbackInfo info,
		@Share("verseCraft$newPattern") LocalBooleanRef newPattern, @Share("verseCraft$blankVertexConsumer") LocalRef<VertexConsumer> blankVertexConsumer
	) {
		if (material == Sheets.getDecoratedPotMaterial(DecoratedPotPatterns.getPatternFromItem(Items.BRICK)) && this.verseCraft$isMisMatched) {
			newPattern.set(true);
			blankVertexConsumer.set(verseCraft$BLANK_MATERIAL.buffer(multiBufferSource, RenderType::entitySolid));
		}
	}

	@WrapOperation(
		method = "renderSide",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/model/geom/ModelPart;render(Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/blaze3d/vertex/VertexConsumer;II)V"
		)
	)
	private void verseCraft$renderSideFix(
		ModelPart instance, PoseStack poseStack, VertexConsumer vertexConsumer, int i, int j, Operation<Void> original,
		@Share("verseCraft$newPattern") LocalBooleanRef newPattern, @Share("verseCraft$blankVertexConsumer") LocalRef<VertexConsumer> blankVertexConsumer
	) {
		original.call(
			instance,
			poseStack,
			newPattern.get() ? blankVertexConsumer.get() : vertexConsumer,
			i,
			j
		);
	}

}
