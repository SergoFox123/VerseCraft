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
import net.frozenblock.lib.entity.api.category.entrypoint.FrozenMobCategoryEntrypoint;
import net.frozenblock.lib.entity.impl.category.FrozenMobCategory;
import net.frozenblock.lib.entrypoint.api.FrozenModInitializer;
import net.frozenblock.lib.feature_flag.api.FeatureFlagApi;
import net.sergofox123.versecraft.registry.RegisterBlocks;
import net.sergofox123.versecraft.registry.RegisterCreativeInventorySorting;
import net.sergofox123.versecraft.registry.RegisterEntityTypes;
import net.sergofox123.versecraft.registry.RegisterItems;

public final class VerseCraft extends FrozenModInitializer implements FrozenMobCategoryEntrypoint {

	public VerseCraft() {
		super(VerseSharedConstants.MOD_ID);
	}

	@Override
	public void onInitialize(String modId, ModContainer container) {
		if (FrozenBools.IS_DATAGEN) {
			VerseFeatureFlags.init();
			FeatureFlagApi.rebuild();
		}

		RegisterBlocks.registerBlocks();
		RegisterItems.init();
		RegisterItems.registerItems();
		RegisterEntityTypes.init();
		RegisterCreativeInventorySorting.init();
		RegisterBlocks.registerBlockProperties();
	}

	@Override
	public void newCategories(ArrayList<FrozenMobCategory> arrayList) {

	}
}
