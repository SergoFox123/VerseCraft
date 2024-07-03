package net.sergofox123.vercecraft.mixin.common.decorated_pot;


import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.sergofox123.vercecraft.impl.DecoratedPotBlockEntityInterface;
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
	public void verseCraft$flipWobble(int i, int j, CallbackInfoReturnable<Boolean> cir) {
		this.verseCraft$flipWobble = !this.verseCraft$flipWobble;
	}

	@Unique
	@Override
	public boolean verseCraft$isWobbleFlipped() {
		return this.verseCraft$flipWobble;
	}
}
