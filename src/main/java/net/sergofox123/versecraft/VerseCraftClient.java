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

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.sergofox123.versecraft.registry.RegisterBlocks;

@Environment(EnvType.CLIENT)
public final class VerseCraftClient implements ClientModInitializer {

	public static final String BLANK_DECORATED_NAME = "decorated_pot_blank_side";

	public static final String DRAGON_POTTERY_PATTERN_NAME = "dragon_pottery_pattern";
	public static final String EGG_POTTERY_PATTERN_NAME = "egg_pottery_pattern";
	public static final String PILLAGER_POTTERY_PATTERN_NAME = "pillager_pottery_pattern";
	public static final String PORTAL_POTTERY_PATTERN_NAME = "portal_pottery_pattern";
	public static final String SWORD_POTTERY_PATTERN_NAME = "sword_pottery_pattern";


	public static final ResourceKey<DecoratedPotPattern> BLANK_DECORATED = ResourceKey.create(Registries.DECORATED_POT_PATTERN, VerseSharedConstants.id(BLANK_DECORATED_NAME));

	public static final ResourceKey<DecoratedPotPattern> DRAGON_POTTERY_PATTERN = ResourceKey.create(Registries.DECORATED_POT_PATTERN, VerseSharedConstants.id(DRAGON_POTTERY_PATTERN_NAME));
	public static final ResourceKey<DecoratedPotPattern> EGG_POTTERY_PATTERN = ResourceKey.create(Registries.DECORATED_POT_PATTERN, VerseSharedConstants.id(EGG_POTTERY_PATTERN_NAME));
	public static final ResourceKey<DecoratedPotPattern> PILLAGER_POTTERY_PATTERN = ResourceKey.create(Registries.DECORATED_POT_PATTERN, VerseSharedConstants.id(PILLAGER_POTTERY_PATTERN_NAME));
	public static final ResourceKey<DecoratedPotPattern> PORTAL_POTTERY_PATTERN = ResourceKey.create(Registries.DECORATED_POT_PATTERN, VerseSharedConstants.id(PORTAL_POTTERY_PATTERN_NAME));
	public static final ResourceKey<DecoratedPotPattern> SWORD_POTTERY_PATTERN = ResourceKey.create(Registries.DECORATED_POT_PATTERN, VerseSharedConstants.id(SWORD_POTTERY_PATTERN_NAME));


	@Override
	public void onInitializeClient() {

		BlockRenderLayerMap renderLayerRegistry = BlockRenderLayerMap.INSTANCE;

		renderLayerRegistry.putBlock(RegisterBlocks.AZALEA_DOOR, RenderType.cutout());
		renderLayerRegistry.putBlock(RegisterBlocks.AZALEA_TRAPDOOR, RenderType.cutout());

	}


}
