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

package net.sergofox123.versecraft;

import java.util.ArrayList;
import net.fabricmc.loader.api.ModContainer;
import net.frozenblock.lib.FrozenBools;
import net.frozenblock.lib.entrypoint.api.FrozenModInitializer;
import net.frozenblock.lib.feature_flag.api.FrozenFeatureFlags;
import net.frozenblock.lib.mobcategory.api.entrypoint.FrozenMobCategoryEntrypoint;
import net.frozenblock.lib.mobcategory.impl.FrozenMobCategory;
import net.sergofox123.versecraft.registry.RegisterBlocks;

import net.sergofox123.versecraft.registry.RegisterItems;
import org.jetbrains.annotations.NotNull;

public final class VerseCraft extends FrozenModInitializer {

	public VerseCraft() {
		super(VerseSharedConstants.MOD_ID);
	}

	@Override
	public void onInitialize(String modId, ModContainer container) {
		if (FrozenBools.IS_DATAGEN) {
			VerseFeatureFlags.init();
			FrozenFeatureFlags.rebuild();
		}

		RegisterBlocks.registerBlocks();

		RegisterItems.registerItems();
		RegisterItems.registerBlockItems();
		RegisterItems.init();


		RegisterBlocks.registerBlockProperties();

	}
}
