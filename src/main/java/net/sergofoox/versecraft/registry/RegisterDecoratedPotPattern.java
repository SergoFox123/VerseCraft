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

package net.sergofoox.versecraft.registry;

import net.frozenblock.lib.item.impl.sherd.DecoratedPotPatternRegistryEntrypoint;
import net.minecraft.world.item.Item;
import net.sergofoox.versecraft.VerseSharedConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.sergofoox.versecraft.misc.ItemImp;
import java.util.function.BiConsumer;

public class RegisterDecoratedPotPattern implements DecoratedPotPatternRegistryEntrypoint {

	public static final ResourceKey<DecoratedPotPattern> DRAGON = create("dragon");
	public static final ResourceKey<DecoratedPotPattern> EGG = create("egg");
	public static final ResourceKey<DecoratedPotPattern> EYE = create("eye");
	public static final ResourceKey<DecoratedPotPattern> PILLAGER = create("pillager");
	public static final ResourceKey<DecoratedPotPattern> PORTAL = create("portal");
	public static final ResourceKey<DecoratedPotPattern> SWORD = create("sword");


	@Override
	public void bootstrap(Registry<DecoratedPotPattern> registry) {
		register(registry, "dragon");
		register(registry, "egg");
		register(registry, "eye");
		register(registry, "pillager");
		register(registry, "portal");
		register(registry, "sword");
	}

	@Override
	public void itemToPatternMappings(BiConsumer<ResourceKey<Item>, ResourceKey<DecoratedPotPattern>> biConsumer) {
		biConsumer.accept(ItemImp.DRAGON_POTTERY_SHERD, DRAGON);
		biConsumer.accept(ItemImp.EGG_POTTERY_SHERD, EGG);
		biConsumer.accept(ItemImp.EYE_POTTERY_SHERD, EYE);
		biConsumer.accept(ItemImp.PILLAGER_POTTERY_SHERD, PILLAGER);
		biConsumer.accept(ItemImp.PORTAL_POTTERY_SHERD, PORTAL);
		biConsumer.accept(ItemImp.SWORD_POTTERY_SHERD, SWORD);
	}

	private static void register(Registry<DecoratedPotPattern> registry, String sherdName) {
		DecoratedPotPatternRegistryEntrypoint.register(
			registry,
			ResourceKey.create(Registries.DECORATED_POT_PATTERN, VerseSharedConstants.id(sherdName)),
			VerseSharedConstants.id(sherdName + "_pottery_pattern")
		);
	}

	private static ResourceKey<DecoratedPotPattern> create(String id) {
		return ResourceKey.create(Registries.DECORATED_POT_PATTERN, VerseSharedConstants.id(id));
	}
}
