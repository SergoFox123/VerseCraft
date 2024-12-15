package net.sergofox123.versecraft.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class RegisterFood {

	public static final FoodProperties CHERRY = new FoodProperties.Builder().nutrition(3).saturationModifier(1.0F).build();

	private RegisterFood() {
		throw new UnsupportedOperationException("RegisterFood contains only static declarations.");
	}
}
