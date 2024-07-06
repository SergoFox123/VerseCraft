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
		newMap.put(RegisterItems.EGG_POTTERY_SHERD, VerseCraftClient.EGG_POTTERY_PATTERN);
		newMap.put(RegisterItems.PILLAGER_POTTERY_SHERD, VerseCraftClient.PILLAGER_POTTERY_PATTERN);
		newMap.put(RegisterItems.PORTAL_POTTERY_SHERD, VerseCraftClient.PORTAL_POTTERY_PATTERN);
		newMap.put(RegisterItems.SWORD_POTTERY_SHERD, VerseCraftClient.SWORD_POTTERY_PATTERN);



		return Map.copyOf(newMap);
	}

	@Inject(method = "bootstrap", at = @At(value = "RETURN", shift = At.Shift.BEFORE))
	private static void verseCraft$bootstrap(Registry<DecoratedPotPattern> registry, CallbackInfoReturnable<DecoratedPotPattern> info) {
		verseCraft$register(registry, VerseCraftClient.BLANK_DECORATED, VerseCraftClient.BLANK_DECORATED_NAME);


		verseCraft$register(registry, VerseCraftClient.DRAGON_POTTERY_PATTERN, VerseCraftClient.DRAGON_POTTERY_PATTERN_NAME);
		verseCraft$register(registry, VerseCraftClient.EGG_POTTERY_PATTERN, VerseCraftClient.EGG_POTTERY_PATTERN_NAME);
		verseCraft$register(registry, VerseCraftClient.PILLAGER_POTTERY_PATTERN, VerseCraftClient.PILLAGER_POTTERY_PATTERN_NAME);
		verseCraft$register(registry, VerseCraftClient.PORTAL_POTTERY_PATTERN, VerseCraftClient.PORTAL_POTTERY_PATTERN_NAME);
		verseCraft$register(registry, VerseCraftClient.SWORD_POTTERY_PATTERN, VerseCraftClient.SWORD_POTTERY_PATTERN_NAME);
	}

	@Contract("_, _, _ -> new")
	@Unique
	private static void verseCraft$register(Registry<DecoratedPotPattern> registry, ResourceKey<DecoratedPotPattern> registryKey, String path) {
		Registry.register(registry, registryKey, new DecoratedPotPattern(VerseSharedConstants.id(path)));
	}

}
