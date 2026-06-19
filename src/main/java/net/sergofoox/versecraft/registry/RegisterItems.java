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

import java.util.function.Function;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SignItem;
import net.sergofoox.versecraft.VerseSharedConstants;
import net.sergofoox.versecraft.misc.ItemImp;
import static net.minecraft.world.item.Items.createBlockItemWithCustomItemName;

public class RegisterItems {

	//Azalea
	public static final Item AZALEA_SIGN = Items.registerBlock(BlockItemId.create(VerseSharedConstants.id("azalea_sign"), VerseSharedConstants.id("azalea_sign")), RegisterBlocks.AZALEA_SIGN,
		(block, properties) -> new SignItem(block, RegisterBlocks.AZALEA_WALL_SIGN, properties),
		new Item.Properties().stacksTo(16)
	);
	public static final Item AZALEA_HANGING_SIGN = Items.registerBlock(BlockItemId.create(VerseSharedConstants.id("azalea_hanging_sign"), VerseSharedConstants.id("azalea_hanging_sign")), RegisterBlocks.AZALEA_HANGING_SIGN,
		(block, properties) -> new HangingSignItem(block, RegisterBlocks.AZALEA_WALL_HANGING_SIGN, properties),
		new Item.Properties().stacksTo(16)
	);

	public static final BoatItem AZALEA_BOAT = register("azalea_boat",
		properties -> new BoatItem(RegisterEntityTypes.AZALEA_BOAT, properties),
		new Item.Properties()
			.stacksTo(1)
	);
	public static final BoatItem AZALEA_CHEST_BOAT = register("azalea_chest_boat",
		properties -> new BoatItem(RegisterEntityTypes.AZALEA_CHEST_BOAT, properties),
		new Item.Properties()
			.stacksTo(1)
	);

    //Pottery Sherd

	public static final Item DRAGON_POTTERY_SHERD = registerPotterySherd(ItemImp.DRAGON_POTTERY_SHERD);
	public static final Item EGG_POTTERY_SHERD = registerPotterySherd(ItemImp.EGG_POTTERY_SHERD);
	public static final Item EYE_POTTERY_SHERD = registerPotterySherd(ItemImp.EYE_POTTERY_SHERD);
	public static final Item PILLAGER_POTTERY_SHERD = registerPotterySherd(ItemImp.PILLAGER_POTTERY_SHERD);
	public static final Item PORTAL_POTTERY_SHERD = registerPotterySherd(ItemImp.PORTAL_POTTERY_SHERD);
	public static final Item SWORD_POTTERY_SHERD = registerPotterySherd(ItemImp.SWORD_POTTERY_SHERD);

	//Food
	public static final Item CHERRY = register("cherry", Item::new, new Item.Properties().food(RegisterFood.CHERRY));

	//Seeds

	public static final Item BLUE_ROSE_SEEDS = register("blue_rose_seeds",
		createBlockItemWithCustomItemName(RegisterBlocks.BLUE_ROSE_CROP),
		new Properties()
	);

	public static final Item ICEFLOWER_SEEDS = register("iceflower_seeds",
		createBlockItemWithCustomItemName(RegisterBlocks.ICEFLOWER_CROP),
		new Properties()
	);

	public static void registerItems() {
		registerDispenses();
	}

	private static void registerDispenses() {

	}

	private RegisterItems() {
		throw new UnsupportedOperationException("RegisterItems contains only static declarations.");
	}

	public static void init() {
	}

	private static <T extends Item> T register(String name, Function<Item.Properties, Item> function, Item.Properties properties) {
		return (T) Items.registerItem(ResourceKey.create(Registries.ITEM, VerseSharedConstants.id(name)), function, properties);
	}

	public static Item registerPotterySherd(ResourceKey<Item> id) {
		return Items.registerItem(id, new Properties().rarity(Rarity.UNCOMMON));
	}

}
