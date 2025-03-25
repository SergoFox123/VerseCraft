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

import java.util.function.Function;
import net.frozenblock.lib.item.api.sherd.SherdRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.sergofox123.versecraft.VerseFeatureFlags;
import net.sergofox123.versecraft.VerseSharedConstants;
import org.jetbrains.annotations.NotNull;
import static net.minecraft.world.item.Items.registerBlock;
import static net.minecraft.world.item.Items.registerItem;


public class RegisterItems {

	//Azalea
	public static final Item AZALEA_SIGN = registerBlock(RegisterBlocks.AZALEA_SIGN,
		(block, properties) -> new SignItem(block, RegisterBlocks.AZALEA_WALL_SIGN, properties),
		new Item.Properties().stacksTo(16)
	);
	public static final Item AZALEA_HANGING_SIGN = registerBlock(RegisterBlocks.AZALEA_HANGING_SIGN,
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

	public static final Item DRAGON_POTTERY_SHERD = registerSherd("dragon_pottery_sherd",
		Item::new,
		new Properties()
			.rarity(Rarity.UNCOMMON)
			.requiredFeatures(VerseFeatureFlags.FEATURE_FLAG)
	);

	public static final Item EGG_POTTERY_SHERD = registerSherd("egg_pottery_sherd",
		Item::new,
		new Properties()
			.rarity(Rarity.UNCOMMON)
			.requiredFeatures(VerseFeatureFlags.FEATURE_FLAG)
	);

	public static final Item EYE_POTTERY_SHERD = registerSherd("eye_pottery_sherd",
		Item::new,
		new Properties()
			.rarity(Rarity.UNCOMMON)
			.requiredFeatures(VerseFeatureFlags.FEATURE_FLAG)
	);

	public static final Item PILLAGER_POTTERY_SHERD = registerSherd("pillager_pottery_sherd",
		Item::new,
		new Properties()
			.rarity(Rarity.UNCOMMON)
			.requiredFeatures(VerseFeatureFlags.FEATURE_FLAG)
	);

	public static final Item PORTAL_POTTERY_SHERD = registerSherd("portal_pottery_sherd",
		Item::new,
		new Properties()
			.rarity(Rarity.UNCOMMON)
			.requiredFeatures(VerseFeatureFlags.FEATURE_FLAG)
	);

	public static final Item SWORD_POTTERY_SHERD = registerSherd("sword_pottery_sherd",
		Item::new,
		new Properties()
			.rarity(Rarity.UNCOMMON)
			.requiredFeatures(VerseFeatureFlags.FEATURE_FLAG)
	);

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

	private RegisterItems() {
		throw new UnsupportedOperationException("RegisterItems contains only static declarations.");
	}

	public static void init() {
	}

	private static @NotNull <T extends Item> T register(String name, @NotNull Function<Item.Properties, Item> function, Item.@NotNull Properties properties) {
		return (T) Items.registerItem(ResourceKey.create(Registries.ITEM, VerseSharedConstants.id(name)), function, properties);
	}

	private static @NotNull <T extends Item> T registerSherd(String name, @NotNull Function<Properties, Item> function, Item.@NotNull Properties properties) {
		T item = (T) Items.registerItem(ResourceKey.create(Registries.ITEM, VerseSharedConstants.id(name)), function, properties);
		SherdRegistry.register(item, VerseSharedConstants.id(name.replace("sherd", "pattern")));
		return item;
	}

	public static Function<Properties, Item> createBlockItemWithCustomItemName(Block block) {
		return properties -> new BlockItem(block, properties.useItemDescriptionPrefix());
	}
}
