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

import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.sergofox123.versecraft.VerseSharedConstants;
import net.sergofox123.versecraft.world.biome.NewPlains;


public final class RegisterWorldgen {

	public static final ResourceKey<Biome> NEW_PLAINS = NewPlains.INSTANCE.getKey();

	private RegisterWorldgen() {
		throw new UnsupportedOperationException("RegisterWorldgen contains only static declarations.");
	}



	public static void init() {

	}

	public static void bootstrap(@NotNull BootstrapContext<Biome> context) {
		VerseSharedConstants.logWithModId("Registering Biomes for", VerseSharedConstants.UNSTABLE_LOGGING);

		register(context, NEW_PLAINS, NewPlains.INSTANCE.create(context));
	}

	private static void register(@NotNull BootstrapContext<Biome> entries, @NotNull ResourceKey<Biome> key, @NotNull Biome biome) {
		VerseSharedConstants.log("Registering biome " + key.location(), true);
		entries.register(key, biome);
	}
}
