package net.sergofox123.vercecraft.registry;

import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.sergofox123.vercecraft.BoatTypeVerse;
import net.sergofox123.vercecraft.VerseSharedConstants;

public class RegisterItems {

	public static final SignItem AZALEA_SIGN = new SignItem(new Item.Properties().stacksTo(16),
		RegisterBlocks.AZALEA_SIGN, RegisterBlocks.AZALEA_WALL_SIGN
	);

	public static final HangingSignItem AZALEA_HANGING_SIGN = new HangingSignItem(RegisterBlocks.AZALEA_HANGING_SIGN, RegisterBlocks.AZALEA_WALL_HANGING_SIGN,
		new Item.Properties().stacksTo(16)
	);

	public static final BoatItem AZALEA_BOAT = new BoatItem(false, BoatTypeVerse.AZALEA, new Item.Properties().stacksTo(1));
	public static final BoatItem AZALEA_CHEST_BOAT = new BoatItem(true, BoatTypeVerse.AZALEA, new Item.Properties().stacksTo(1));

	private RegisterItems() {
		throw new UnsupportedOperationException("RegisterItems contains only static declarations.");
	}

	public static void registerBlockItems() {

		registerItemAfter(Items.ACACIA_HANGING_SIGN, AZALEA_SIGN, "azalea_sign", CreativeModeTabs.FUNCTIONAL_BLOCKS);
		registerItemAfter(AZALEA_SIGN, AZALEA_HANGING_SIGN, "azalea_hanging_sign", CreativeModeTabs.FUNCTIONAL_BLOCKS);

	}

	public static void registerItems() {

		registerItemAfter(Items.ACACIA_CHEST_BOAT, AZALEA_BOAT, "azalea_boat", CreativeModeTabs.TOOLS_AND_UTILITIES);
		registerItemAfter(AZALEA_BOAT, AZALEA_CHEST_BOAT, "azalea_chest_boat", CreativeModeTabs.TOOLS_AND_UTILITIES);
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

	private static void actualRegister(@NotNull Item item, @NotNull String path) {
		if (BuiltInRegistries.ITEM.getOptional(VerseSharedConstants.id(path)).isEmpty()) {
			Registry.register(BuiltInRegistries.ITEM, VerseSharedConstants.id(path), item);
		}
	}

	private static <S extends RecipeSerializer<T>, T extends Recipe<?>> @NotNull S registerSerializer(String key, S recipeSerializer) {
		return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, VerseSharedConstants.id(key), recipeSerializer);
	}
}
