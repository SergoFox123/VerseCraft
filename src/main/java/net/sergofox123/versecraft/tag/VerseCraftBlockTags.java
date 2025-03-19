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

package net.sergofox123.versecraft.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.sergofox123.versecraft.VerseSharedConstants;
import org.jetbrains.annotations.NotNull;

public class VerseCraftBlockTags {


	private VerseCraftBlockTags() {
		throw new UnsupportedOperationException("VerseCraftBlockTags contains only static declarations.");
	}

	@NotNull
	private static TagKey<Block> bind(@NotNull String path) {
		return TagKey.create(Registries.BLOCK, VerseSharedConstants.id(path));
	}
}
