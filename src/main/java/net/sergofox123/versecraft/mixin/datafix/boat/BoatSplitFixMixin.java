package net.sergofox123.versecraft.mixin.datafix.boat;

import net.minecraft.util.datafix.fixes.BoatSplitFix;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoatSplitFix.class)
public class BoatSplitFixMixin {

	@Inject(
		method = "mapVariantToNormalBoat",
		at = @At("HEAD"),
		cancellable = true
	)
	private static void verseCraft$mapVariantToNormalBoat(String string, CallbackInfoReturnable<String> info) {
		if (string.equals("versecraftazalea")) {
			info.setReturnValue("versecraft:azalea_boat");
		}
	}

	@Inject(
		method = "mapVariantToChestBoat",
		at = @At("HEAD"),
		cancellable = true
	)
	private static void verseCraft$mapVariantToChestBoat(String string, CallbackInfoReturnable<String> info) {
		if (string.equals("versecraftazalea")) {
			info.setReturnValue("versecraft:azalea_chest_boat");
		}
	}

}
