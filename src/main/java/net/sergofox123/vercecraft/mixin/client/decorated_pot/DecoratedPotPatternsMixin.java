package net.sergofox123.vercecraft.mixin.client.decorated_pot;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import java.util.Map;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import net.sergofox123.vercecraft.VerseCraftClient;
import net.sergofox123.vercecraft.VerseSharedConstants;
import net.sergofox123.vercecraft.registry.RegisterItems;
import org.jetbrains.annotations.Contract;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DecoratedPotPatterns.class)
public class DecoratedPotPatternsMixin {

	@ModifyExpressionValue(method = "<clinit>",
		at = @At(
			value = "INVOKE",
			target = "Ljava/util/Map;ofEntries([Ljava/util/Map$Entry;)Ljava/util/Map;"
		)
	)
	private static Map<Item, ResourceKey<DecoratedPotPattern>> verseCraft$addNewSherds(Map<Item, ResourceKey<DecoratedPotPattern>> original) {
		Object2ObjectLinkedOpenHashMap<Item, ResourceKey<DecoratedPotPattern>> newMap = new Object2ObjectLinkedOpenHashMap<>();
		newMap.putAll(original);

		newMap.put(RegisterItems.DRAGON_POTTERY_SHERD, VerseCraftClient.DRAGON_POTTERY_PATTERN);


		return Map.copyOf(newMap);
	}

	@Inject(method = "bootstrap", at = @At(value = "RETURN", shift = At.Shift.BEFORE))
	private static void verseCraft$bootstrap(Registry<DecoratedPotPattern> registry, CallbackInfoReturnable<DecoratedPotPattern> info) {
		verseCraft$register(registry, VerseCraftClient.BLANK_DECORATED, VerseCraftClient.BLANK_DECORATED_NAME);


		verseCraft$register(registry, VerseCraftClient.DRAGON_POTTERY_PATTERN, VerseCraftClient.DRAGON_POTTERY_PATTERN_NAME);

	}

	@Contract("_, _, _ -> new")
	@Unique
	private static void verseCraft$register(Registry<DecoratedPotPattern> registry, ResourceKey<DecoratedPotPattern> registryKey, String path) {
		Registry.register(registry, registryKey, new DecoratedPotPattern(VerseSharedConstants.id(path)));
	}

}
