package net.sergofox123.versecraft.mixin.datafix.boat;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.types.templates.TypeTemplate;
import net.minecraft.util.datafix.schemas.V4067;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import java.util.Map;
import java.util.function.Supplier;

@Mixin(V4067.class)
public abstract class V4067Mixin {

	@Shadow
	protected abstract void registerChestBoat(Map<String, Supplier<TypeTemplate>> map, String string);

	@WrapOperation(
		method = "registerEntities",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/util/datafix/schemas/NamespacedSchema;registerEntities(Lcom/mojang/datafixers/schemas/Schema;)Ljava/util/Map;",
			ordinal = 0
		)
	)
	public Map<String, Supplier<TypeTemplate>> wilderWild$registerEntities(V4067 instance, Schema schema, Operation<Map<String, Supplier<TypeTemplate>>> original) {
		Map<String, Supplier<TypeTemplate>> map = original.call(instance, schema);
		schema.registerSimple(map, "versecraft:azalea_boat");


		this.registerChestBoat(map, "versecraft:azalea_chest_boat");
		return map;
	}
}
