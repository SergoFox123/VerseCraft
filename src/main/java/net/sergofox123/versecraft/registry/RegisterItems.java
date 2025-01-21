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

import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.frozenblock.lib.item.api.sherd.SherdRegistry;
import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.sergofox123.versecraft.impl.entity.VerseBoatType;
import net.sergofox123.versecraft.VerseFeatureFlags;
import net.sergofox123.versecraft.VerseSharedConstants;

public class RegisterItems {

	//Azalea sings
	public static final SignItem AZALEA_SIGN = new SignItem(new Item.Properties().stacksTo(16),
		RegisterBlocks.AZALEA_SIGN, RegisterBlocks.AZALEA_WALL_SIGN
	);

	public static final HangingSignItem AZALEA_HANGING_SIGN = new HangingSignItem(RegisterBlocks.AZALEA_HANGING_SIGN, RegisterBlocks.AZALEA_WALL_HANGING_SIGN,
		new Item.Properties().stacksTo(16)
	);

	//Boat
	public static final BoatItem AZALEA_BOAT = new BoatItem(false, VerseBoatType.AZALEA, new Item.Properties().stacksTo(1));
	public static final BoatItem AZALEA_CHEST_BOAT = new BoatItem(true, VerseBoatType.AZALEA, new Item.Properties().stacksTo(1));

	//Pottery Sherd

	public static final Item DRAGON_POTTERY_SHERD = new Item(new Item.Properties().requiredFeatures(VerseFeatureFlags.FEATURE_FLAG));

	public static final Item EGG_POTTERY_SHERD = new Item(new Item.Properties().requiredFeatures(VerseFeatureFlags.FEATURE_FLAG));

	public static final Item EYE_POTTERY_SHERD = new Item(new Item.Properties().requiredFeatures(VerseFeatureFlags.FEATURE_FLAG));

	public static final Item PILLAGER_POTTERY_SHERD = new Item(new Item.Properties().requiredFeatures(VerseFeatureFlags.FEATURE_FLAG));

	public static final Item PORTAL_POTTERY_SHERD = new Item(new Item.Properties().requiredFeatures(VerseFeatureFlags.FEATURE_FLAG));

	public static final Item SWORD_POTTERY_SHERD = new Item(new Item.Properties().requiredFeatures(VerseFeatureFlags.FEATURE_FLAG));


	//Seeds
	public static final Item ICEFLOWER_SEEDS = new ItemNameBlockItem(RegisterBlocks.ICEFLOWER_CROP, new Item.Properties()
	);

	public static final Item BLUE_ROSE_SEEDS = new ItemNameBlockItem(RegisterBlocks.BLUE_ROSE_CROP, new Item.Properties()
	);


	//Food
	public static final Item CHERRY = new Item(new Item.Properties().food(RegisterFood.CHERRY));

	public static final Item CRYSTALLIZED_HONEY  = new Item(new Item.Properties().food(RegisterFood.CRYSTALLIZED_HONEY));


	private RegisterItems() {
		throw new UnsupportedOperationException("RegisterItems contains only static declarations.");
	}

	public static void registerBlockItems() {

		registerItemAfter(Items.ACACIA_HANGING_SIGN, AZALEA_SIGN, "azalea_sign", CreativeModeTabs.FUNCTIONAL_BLOCKS);
		registerItemAfter(AZALEA_SIGN, AZALEA_HANGING_SIGN, "azalea_hanging_sign", CreativeModeTabs.FUNCTIONAL_BLOCKS);

	}

	public static void registerItems() {
		registerItemAfter(Items.CHORUS_FRUIT, CHERRY, "cherry", CreativeModeTabs.FOOD_AND_DRINKS);
		registerItemAfter(CHERRY, CRYSTALLIZED_HONEY, "crystallized_honey", CreativeModeTabs.FOOD_AND_DRINKS);


		registerItemAfter(Items.ACACIA_CHEST_BOAT, AZALEA_BOAT, "azalea_boat", CreativeModeTabs.TOOLS_AND_UTILITIES);
		registerItemAfter(AZALEA_BOAT, AZALEA_CHEST_BOAT, "azalea_chest_boat", CreativeModeTabs.TOOLS_AND_UTILITIES);
	}

	public static void init() {

		registerSherdAfter(Items.BURN_POTTERY_SHERD, DRAGON_POTTERY_SHERD, "dragon_pottery_sherd", CreativeModeTabs.INGREDIENTS);
		registerSherdAfter(DRAGON_POTTERY_SHERD, EGG_POTTERY_SHERD, "egg_pottery_sherd", CreativeModeTabs.INGREDIENTS);
		registerSherdAfter(EGG_POTTERY_SHERD, PILLAGER_POTTERY_SHERD, "pillager_pottery_sherd", CreativeModeTabs.INGREDIENTS);
		registerSherdBefore(EGG_POTTERY_SHERD, EYE_POTTERY_SHERD, "eye_pottery_sherd", CreativeModeTabs.INGREDIENTS);
		registerSherdAfter(PILLAGER_POTTERY_SHERD, PORTAL_POTTERY_SHERD, "portal_pottery_sherd", CreativeModeTabs.INGREDIENTS);
		registerSherdAfter(PORTAL_POTTERY_SHERD, SWORD_POTTERY_SHERD, "sword_pottery_sherd", CreativeModeTabs.INGREDIENTS);

		registerItemAfter(Items.TORCHFLOWER_SEEDS, ICEFLOWER_SEEDS, "iceflower_seeds", CreativeModeTabs.NATURAL_BLOCKS);
		registerItemAfter(Items.PITCHER_POD, BLUE_ROSE_SEEDS, "blue_rose_seeds", CreativeModeTabs.NATURAL_BLOCKS);

	}

	@SafeVarargs
	private static void registerItem(@NotNull Item item, @NotNull String path, @NotNull ResourceKey<CreativeModeTab>... tabs) {
		actualRegister(item, path);
		FrozenCreativeTabs.add(item, tabs);
	}

	@SafeVarargs
	private static void registerItemBefore(@NotNull ItemLike comparedItem, @NotNull Item item, @NotNull String path, @NotNull ResourceKey<CreativeModeTab>... tabs) {
		registerItemBefore(comparedItem, item, path, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
	}

	@SafeVarargs
	private static void registerItemBefore(@NotNull ItemLike comparedItem, @NotNull Item item, @NotNull String path, @NotNull CreativeModeTab.TabVisibility tabVisibility, @NotNull ResourceKey<CreativeModeTab>... tabs) {
		actualRegister(item, path);
		FrozenCreativeTabs.addBefore(comparedItem, item, tabVisibility, tabs);
	}

	@SafeVarargs
	private static void registerItemAfter(@NotNull ItemLike comparedItem, @NotNull Item item, @NotNull String path, @NotNull ResourceKey<CreativeModeTab>... tabs) {
		registerItemAfter(comparedItem, item, path, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
	}

	@SafeVarargs
	private static void registerItemAfter(@NotNull ItemLike comparedItem, @NotNull Item item, @NotNull String path, @NotNull CreativeModeTab.TabVisibility tabVisibility, @NotNull ResourceKey<CreativeModeTab>... tabs) {
		actualRegister(item, path);
		FrozenCreativeTabs.addAfter(comparedItem, item, tabVisibility, tabs);
	}

	private static boolean actualRegister(@NotNull Item item, @NotNull String path) {
		if (BuiltInRegistries.ITEM.getOptional(VerseSharedConstants.id(path)).isEmpty()) {
			Registry.register(BuiltInRegistries.ITEM, VerseSharedConstants.id(path), item);
			return true;
		}
		return false;
	}

	private static <S extends RecipeSerializer<T>, T extends Recipe<?>> @NotNull S registerSerializer(String key, S recipeSerializer) {
		return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, VerseSharedConstants.id(key), recipeSerializer);
	}

	@SafeVarargs
	private static void registerSherdBefore(@NotNull ItemLike comparedItem, @NotNull Item item, @NotNull String path, @NotNull ResourceKey<CreativeModeTab>... tabs) {
		registerSherdBefore(comparedItem, item, path, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
	}

	@SafeVarargs
	private static void registerSherdBefore(@NotNull ItemLike comparedItem, @NotNull Item item, @NotNull String path, @NotNull CreativeModeTab.TabVisibility tabVisibility, @NotNull ResourceKey<CreativeModeTab>... tabs) {
		actualRegisterSherd(item, path);
		FrozenCreativeTabs.addBefore(comparedItem, item, tabVisibility, tabs);
	}

	@SafeVarargs
	private static void registerSherdAfter(@NotNull ItemLike comparedItem, @NotNull Item item, @NotNull String path, @NotNull ResourceKey<CreativeModeTab>... tabs) {
		registerSherdAfter(comparedItem, item, path, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
	}

	@SafeVarargs
	private static void registerSherdAfter(@NotNull ItemLike comparedItem, @NotNull Item item, @NotNull String path, @NotNull CreativeModeTab.TabVisibility tabVisibility, @NotNull ResourceKey<CreativeModeTab>... tabs) {
		actualRegisterSherd(item, path);
		FrozenCreativeTabs.addAfter(comparedItem, item, tabVisibility, tabs);
	}

	private static void actualRegisterSherd(@NotNull Item item, @NotNull String path) {
		if (actualRegister(item, path)) {
			SherdRegistry.register(item, VerseSharedConstants.id(path.replace("sherd", "pattern")));
		}
	}
}
