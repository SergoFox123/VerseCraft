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
