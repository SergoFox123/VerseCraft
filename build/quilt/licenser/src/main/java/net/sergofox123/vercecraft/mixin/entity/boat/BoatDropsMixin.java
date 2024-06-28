package net.sergofox123.vercecraft.mixin.entity.boat;

import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.sergofox123.vercecraft.BoatTypeVerse;
import net.sergofox123.vercecraft.registry.RegisterItems;
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
