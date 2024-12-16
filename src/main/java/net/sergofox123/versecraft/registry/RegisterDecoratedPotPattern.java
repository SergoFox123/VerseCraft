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

package net.sergofox123.versecraft.registry;

import net.frozenblock.lib.item.impl.sherd.DecoratedPotPatternRegistryEntrypoint;
import net.sergofox123.versecraft.VerseSharedConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import org.jetbrains.annotations.NotNull;

public class RegisterDecoratedPotPattern implements DecoratedPotPatternRegistryEntrypoint {

	@Override
	public void bootstrap(Registry<DecoratedPotPattern> registry) {
		register(registry, "dragon");
		register(registry, "egg");
		register(registry, "eye");
		register(registry, "pillager");
		register(registry, "portal");
		register(registry, "sword");

	}

	public static void register(@NotNull Registry<DecoratedPotPattern> registry, String sherdName) {
		ResourceLocation location = VerseSharedConstants.id(sherdName + "_pottery_pattern");
		DecoratedPotPatternRegistryEntrypoint.register(
			registry,
			ResourceKey.create(Registries.DECORATED_POT_PATTERN, location),
			location
		);
	}
}

