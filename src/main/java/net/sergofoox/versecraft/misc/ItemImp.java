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

package net.sergofoox.versecraft.misc;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.sergofoox.versecraft.VerseSharedConstants;

public class ItemImp {

	public static final ResourceKey<Item> DRAGON_POTTERY_SHERD = create("dragon_pottery_sherd");
	public static final ResourceKey<Item> EGG_POTTERY_SHERD = create("egg_pottery_sherd");
	public static final ResourceKey<Item> EYE_POTTERY_SHERD = create("eye_pottery_sherd");
	public static final ResourceKey<Item> PILLAGER_POTTERY_SHERD = create("pillager_pottery_sherd");
	public static final ResourceKey<Item> PORTAL_POTTERY_SHERD = create("portal_pottery_sherd");
	public static final ResourceKey<Item> SWORD_POTTERY_SHERD = create("sword_pottery_sherd");

	private static ResourceKey<Item> create(String name) {
		return ResourceKey.create(Registries.ITEM, VerseSharedConstants.id(name));
	}
}
