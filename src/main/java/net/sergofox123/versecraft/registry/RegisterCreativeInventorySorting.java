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

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.frozenblock.lib.item.api.ItemBlockStateTagUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

public class RegisterCreativeInventorySorting {

	public static void init() {

		// AZALEA (BUILDING BLOCKS)
		addAfterInBuildingBlocks(Items.ACACIA_BUTTON, RegisterBlocks.AZALEA_LOG);
		addAfterInBuildingBlocks(RegisterBlocks.AZALEA_LOG, RegisterBlocks.AZALEA_WOOD);
		addAfterInBuildingBlocks(RegisterBlocks.AZALEA_WOOD, RegisterBlocks.STRIPPED_AZALEA_LOG);
		addAfterInBuildingBlocks(RegisterBlocks.STRIPPED_AZALEA_LOG, RegisterBlocks.STRIPPED_AZALEA_WOOD);
		addAfterInBuildingBlocks(RegisterBlocks.STRIPPED_AZALEA_WOOD, RegisterBlocks.AZALEA_PLANKS);
		addAfterInBuildingBlocks(RegisterBlocks.AZALEA_PLANKS, RegisterBlocks.AZALEA_STAIRS);
		addAfterInBuildingBlocks(RegisterBlocks.AZALEA_STAIRS, RegisterBlocks.AZALEA_SLAB);
		addAfterInBuildingBlocks(RegisterBlocks.AZALEA_SLAB, RegisterBlocks.AZALEA_FENCE);
		addAfterInBuildingBlocks(RegisterBlocks.AZALEA_FENCE, RegisterBlocks.AZALEA_FENCE_GATE);
		addAfterInBuildingBlocks(RegisterBlocks.AZALEA_FENCE_GATE, RegisterBlocks.AZALEA_DOOR);
		addAfterInBuildingBlocks(RegisterBlocks.AZALEA_DOOR, RegisterBlocks.AZALEA_TRAPDOOR);
		addAfterInBuildingBlocks(RegisterBlocks.AZALEA_TRAPDOOR, RegisterBlocks.AZALEA_PRESSURE_PLATE);
		addAfterInBuildingBlocks(RegisterBlocks.AZALEA_PRESSURE_PLATE, RegisterBlocks.AZALEA_BUTTON);

		// AZALEA (NATURAL BLOCKS)
		addAfterInNaturalBlocks(Items.ACACIA_LOG, RegisterBlocks.AZALEA_LOG);

		// AZALEA (TOOLS AND UTILITIES)
		addAfterInToolsAndUtilities(Items.ACACIA_CHEST_BOAT, RegisterItems.AZALEA_BOAT);
		addAfterInToolsAndUtilities(RegisterItems.AZALEA_BOAT, RegisterItems.AZALEA_CHEST_BOAT);

		// AZALEA (FUNCTIONAL BLOCKS)
		addAfterInFunctionalBlocks(Items.ACACIA_HANGING_SIGN, RegisterItems.AZALEA_SIGN);
		addAfterInFunctionalBlocks(RegisterItems.AZALEA_SIGN, RegisterItems.AZALEA_HANGING_SIGN);


		// PALM (BUILDING BLOCKS)
		addAfterInBuildingBlocks(Items.JUNGLE_BUTTON, RegisterBlocks.PALM_LOG);
		addAfterInBuildingBlocks(RegisterBlocks.PALM_LOG, RegisterBlocks.PALM_WOOD);
		addAfterInBuildingBlocks(RegisterBlocks.PALM_WOOD, RegisterBlocks.STRIPPED_PALM_LOG);
		addAfterInBuildingBlocks(RegisterBlocks.STRIPPED_PALM_LOG, RegisterBlocks.STRIPPED_PALM_WOOD);
		addAfterInBuildingBlocks(RegisterBlocks.STRIPPED_PALM_WOOD, RegisterBlocks.PALM_PLANKS);
		addAfterInBuildingBlocks(RegisterBlocks.PALM_PLANKS, RegisterBlocks.PALM_STAIRS);
		addAfterInBuildingBlocks(RegisterBlocks.PALM_STAIRS, RegisterBlocks.PALM_SLAB);
		addAfterInBuildingBlocks(RegisterBlocks.PALM_SLAB, RegisterBlocks.PALM_FENCE);
		addAfterInBuildingBlocks(RegisterBlocks.PALM_FENCE, RegisterBlocks.PALM_FENCE_GATE);
		addAfterInBuildingBlocks(RegisterBlocks.PALM_FENCE_GATE, RegisterBlocks.PALM_DOOR);
		addAfterInBuildingBlocks(RegisterBlocks.PALM_DOOR, RegisterBlocks.PALM_TRAPDOOR);
		addAfterInBuildingBlocks(RegisterBlocks.PALM_TRAPDOOR, RegisterBlocks.PALM_PRESSURE_PLATE);
		addAfterInBuildingBlocks(RegisterBlocks.PALM_PRESSURE_PLATE, RegisterBlocks.PALM_BUTTON);

		// PALM (NATURAL BLOCKS)
		addAfterInNaturalBlocks(Items.JUNGLE_LOG, RegisterBlocks.PALM_LOG);

		// PALM (TOOLS AND UTILITIES)
		addAfterInToolsAndUtilities(Items.JUNGLE_CHEST_BOAT, RegisterItems.PALM_BOAT);
		addAfterInToolsAndUtilities(RegisterItems.PALM_BOAT, RegisterItems.PALM_CHEST_BOAT);

		// PALM (FUNCTIONAL BLOCKS)
		addAfterInFunctionalBlocks(Items.ACACIA_HANGING_SIGN, RegisterItems.PALM_SIGN);
		addAfterInFunctionalBlocks(RegisterItems.PALM_SIGN, RegisterItems.PALM_HANGING_SIGN);


		//Acacia Mosaic
		addAfterInBuildingBlocks(Items.ACACIA_PLANKS, RegisterBlocks.ACACIA_MOSAIC);
		addAfterInBuildingBlocks(Items.ACACIA_STAIRS, RegisterBlocks.ACACIA_MOSAIC_STAIRS);
		addAfterInBuildingBlocks(Items.ACACIA_SLAB, RegisterBlocks.ACACIA_MOSAIC_SLAB);

		//Azalea Mosaic
		addAfterInBuildingBlocks(RegisterBlocks.AZALEA_PLANKS, RegisterBlocks.AZALEA_MOSAIC);
		addAfterInBuildingBlocks(RegisterBlocks.AZALEA_STAIRS, RegisterBlocks.AZALEA_MOSAIC_STAIRS);
		addAfterInBuildingBlocks(RegisterBlocks.AZALEA_SLAB, RegisterBlocks.AZALEA_MOSAIC_SLAB);

		//Birch Mosaic
		addAfterInBuildingBlocks(Items.BIRCH_PLANKS, RegisterBlocks.BIRCH_MOSAIC);
		addAfterInBuildingBlocks(Items.BIRCH_STAIRS, RegisterBlocks.BIRCH_MOSAIC_STAIRS);
		addAfterInBuildingBlocks(Items.BIRCH_SLAB, RegisterBlocks.BIRCH_MOSAIC_SLAB);

		//Cherry Mosaic
		addAfterInBuildingBlocks(Items.CHERRY_PLANKS, RegisterBlocks.CHERRY_MOSAIC);
		addAfterInBuildingBlocks(Items.CHERRY_STAIRS, RegisterBlocks.CHERRY_MOSAIC_STAIRS);
		addAfterInBuildingBlocks(Items.CHERRY_SLAB, RegisterBlocks.CHERRY_MOSAIC_SLAB);

		//Crimson Mosaic
		addAfterInBuildingBlocks(Items.CRIMSON_PLANKS, RegisterBlocks.CRIMSON_MOSAIC);
		addAfterInBuildingBlocks(Items.CRIMSON_STAIRS, RegisterBlocks.CRIMSON_MOSAIC_STAIRS);
		addAfterInBuildingBlocks(Items.CRIMSON_SLAB, RegisterBlocks.CRIMSON_MOSAIC_SLAB);

		//Dark Oak Mosaic
		addAfterInBuildingBlocks(Items.DARK_OAK_PLANKS, RegisterBlocks.DARK_OAK_MOSAIC);
		addAfterInBuildingBlocks(Items.DARK_OAK_STAIRS, RegisterBlocks.DARK_OAK_MOSAIC_STAIRS);
		addAfterInBuildingBlocks(Items.DARK_OAK_SLAB, RegisterBlocks.DARK_OAK_MOSAIC_SLAB);

		//Jungle Mosaic
		addAfterInBuildingBlocks(Items.JUNGLE_PLANKS, RegisterBlocks.JUNGLE_MOSAIC);
		addAfterInBuildingBlocks(Items.JUNGLE_STAIRS, RegisterBlocks.JUNGLE_MOSAIC_STAIRS);
		addAfterInBuildingBlocks(Items.JUNGLE_SLAB, RegisterBlocks.JUNGLE_MOSAIC_SLAB);

		//Mangrove Mosaic
		addAfterInBuildingBlocks(Items.MANGROVE_PLANKS, RegisterBlocks.MANGROVE_MOSAIC);
		addAfterInBuildingBlocks(Items.MANGROVE_STAIRS, RegisterBlocks.MANGROVE_MOSAIC_STAIRS);
		addAfterInBuildingBlocks(Items.MANGROVE_SLAB, RegisterBlocks.MANGROVE_MOSAIC_SLAB);

		//Oak Mosaic
		addAfterInBuildingBlocks(Items.OAK_PLANKS, RegisterBlocks.OAK_MOSAIC);
		addAfterInBuildingBlocks(Items.OAK_STAIRS,RegisterBlocks.OAK_MOSAIC_STAIRS);
		addAfterInBuildingBlocks(Items.OAK_SLAB, RegisterBlocks.OAK_MOSAIC_SLAB);

		//Spruce Mosaic
		addAfterInBuildingBlocks(Items.SPRUCE_PLANKS, RegisterBlocks.SPRUCE_MOSAIC);
		addAfterInBuildingBlocks(Items.SPRUCE_STAIRS, RegisterBlocks.SPRUCE_MOSAIC_STAIRS);
		addAfterInBuildingBlocks(Items.SPRUCE_SLAB, RegisterBlocks.SPRUCE_MOSAIC_SLAB);

		//Pale Oak
		addAfterInBuildingBlocks(Items.PALE_OAK_PLANKS, RegisterBlocks.PALE_OAK_MOSAIC);
		addAfterInBuildingBlocks(Items.PALE_OAK_STAIRS, RegisterBlocks.PALE_OAK_MOSAIC_STAIRS);
		addAfterInBuildingBlocks(Items.PALE_OAK_SLAB, RegisterBlocks.PALE_OAK_MOSAIC_SLAB);

		//Warped Mosaic
		addAfterInBuildingBlocks(Items.WARPED_PLANKS, RegisterBlocks.WARPED_MOSAIC);
		addAfterInBuildingBlocks(Items.WARPED_STAIRS, RegisterBlocks.WARPED_MOSAIC_STAIRS);
		addAfterInBuildingBlocks(Items.WARPED_SLAB, RegisterBlocks.WARPED_MOSAIC_SLAB);

		//Tuff
		addAfterInBuildingBlocks(Items.TUFF_BRICKS, RegisterBlocks.CRACKED_TUFF_BRICKS);

		//Diorite
		addAfterInBuildingBlocks(Items.DIORITE_WALL, RegisterBlocks.CHISELED_DIORITE);
		addAfterInBuildingBlocks(Items.POLISHED_DIORITE_SLAB, RegisterBlocks.POLISHED_DIORITE_WALL);
		addAfterInBuildingBlocks(RegisterBlocks.POLISHED_DIORITE_WALL, RegisterBlocks.DIORITE_BRICKS);
		addAfterInBuildingBlocks(RegisterBlocks.DIORITE_BRICKS, RegisterBlocks.CRACKED_DIORITE_BRICKS);
		addAfterInBuildingBlocks(RegisterBlocks.CRACKED_DIORITE_BRICKS, RegisterBlocks.DIORITE_BRICKS_STAIRS);
		addAfterInBuildingBlocks(RegisterBlocks.DIORITE_BRICKS_STAIRS, RegisterBlocks.DIORITE_BRICKS_SLAB);
		addAfterInBuildingBlocks(RegisterBlocks.DIORITE_BRICKS_SLAB, RegisterBlocks.DIORITE_BRICKS_WALL);
		addAfterInBuildingBlocks(RegisterBlocks.DIORITE_BRICKS_WALL, RegisterBlocks.CHISELED_DIORITE_BRICKS);

		//Andesite
		addAfterInBuildingBlocks(Items.ANDESITE_WALL, RegisterBlocks.CHISELED_ANDESITE);
		addAfterInBuildingBlocks(Items.POLISHED_ANDESITE_SLAB, RegisterBlocks.POLISHED_ANDESITE_WALL);
		addAfterInBuildingBlocks(RegisterBlocks.POLISHED_ANDESITE_WALL, RegisterBlocks.ANDESITE_BRICKS);
		addAfterInBuildingBlocks(RegisterBlocks.ANDESITE_BRICKS, RegisterBlocks.CRACKED_ANDESITE_BRICKS);
		addAfterInBuildingBlocks(RegisterBlocks.CRACKED_ANDESITE_BRICKS, RegisterBlocks.ANDESITE_BRICKS_STAIRS);
		addAfterInBuildingBlocks(RegisterBlocks.ANDESITE_BRICKS_STAIRS, RegisterBlocks.ANDESITE_BRICKS_SLAB);
		addAfterInBuildingBlocks(RegisterBlocks.ANDESITE_BRICKS_SLAB, RegisterBlocks.ANDESITE_BRICKS_WALL);
		addAfterInBuildingBlocks(RegisterBlocks.ANDESITE_BRICKS_WALL, RegisterBlocks.CHISELED_ANDESITE_BRICKS);

		//Granite
		addAfterInBuildingBlocks(Items.GRANITE_WALL, RegisterBlocks.CHISELED_GRANITE);
		addAfterInBuildingBlocks(Items.POLISHED_GRANITE_SLAB, RegisterBlocks.POLISHED_GRANITE_WALL);
		addAfterInBuildingBlocks(RegisterBlocks.POLISHED_GRANITE_WALL, RegisterBlocks.GRANITE_BRICKS);
		addAfterInBuildingBlocks(RegisterBlocks.GRANITE_BRICKS, RegisterBlocks.CRACKED_GRANITE_BRICKS);
		addAfterInBuildingBlocks(RegisterBlocks.CRACKED_GRANITE_BRICKS, RegisterBlocks.GRANITE_BRICKS_STAIRS);
		addAfterInBuildingBlocks(RegisterBlocks.GRANITE_BRICKS_STAIRS,RegisterBlocks.GRANITE_BRICKS_SLAB);
		addAfterInBuildingBlocks(RegisterBlocks.GRANITE_BRICKS_SLAB,RegisterBlocks.GRANITE_BRICKS_WALL);
		addAfterInBuildingBlocks(RegisterBlocks.GRANITE_BRICKS_WALL, RegisterBlocks.CHISELED_GRANITE_BRICKS);

		//Calcite
		FrozenCreativeTabs.addAfter(Items.REINFORCED_DEEPSLATE, Items.CALCITE, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, CreativeModeTabs.BUILDING_BLOCKS);
		addAfterInBuildingBlocks(Items.CALCITE, RegisterBlocks.CALCITE_STAIRS);
		addAfterInBuildingBlocks(RegisterBlocks.CALCITE_STAIRS, RegisterBlocks.CALCITE_SLAB);
		addAfterInBuildingBlocks(RegisterBlocks.CALCITE_SLAB, RegisterBlocks.CALCITE_WALL);
		addAfterInBuildingBlocks(RegisterBlocks.CALCITE_WALL, RegisterBlocks.CHISELED_CALCITE);

		//Polished Calcite
		addAfterInBuildingBlocks(RegisterBlocks.CHISELED_CALCITE, RegisterBlocks.POLISHED_CALCITE);
		addAfterInBuildingBlocks(RegisterBlocks.POLISHED_CALCITE, RegisterBlocks.POLISHED_CALCITE_STAIRS);
		addAfterInBuildingBlocks(RegisterBlocks.POLISHED_CALCITE_STAIRS, RegisterBlocks.POLISHED_CALCITE_SLAB);
		addAfterInBuildingBlocks(RegisterBlocks.POLISHED_CALCITE_SLAB, RegisterBlocks.POLISHED_CALCITE_WALL);

		//Calcite Bricks
		addAfterInBuildingBlocks(RegisterBlocks.POLISHED_CALCITE_WALL, RegisterBlocks.CALCITE_BRICKS);
		addAfterInBuildingBlocks(RegisterBlocks.CALCITE_BRICKS, RegisterBlocks.CALCITE_BRICKS_STAIRS);
		addAfterInBuildingBlocks(RegisterBlocks.CALCITE_BRICKS_STAIRS, RegisterBlocks.CALCITE_BRICKS_SLAB);
		addAfterInBuildingBlocks(RegisterBlocks.CALCITE_BRICKS_SLAB, RegisterBlocks.CALCITE_BRICKS_WALL);
		addAfterInBuildingBlocks(RegisterBlocks.CALCITE_BRICKS_WALL, RegisterBlocks.CHISELED_CALCITE_BRICKS);
		addAfterInBuildingBlocks(RegisterBlocks.CALCITE_BRICKS_STAIRS, RegisterBlocks.CRACKED_CALCITE_BRICKS);

		//Dripstone
		FrozenCreativeTabs.addAfter(Items.CHISELED_TUFF_BRICKS, Items.DRIPSTONE_BLOCK, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, CreativeModeTabs.BUILDING_BLOCKS);
		addAfterInBuildingBlocks(Items.DRIPSTONE_BLOCK, RegisterBlocks.DRIPSTONE_STAIRS);
		addAfterInBuildingBlocks(RegisterBlocks.DRIPSTONE_STAIRS, RegisterBlocks.DRIPSTONE_SLAB);
		addAfterInBuildingBlocks(RegisterBlocks.DRIPSTONE_SLAB, RegisterBlocks.DRIPSTONE_WALL);
		addAfterInBuildingBlocks(RegisterBlocks.DRIPSTONE_WALL, RegisterBlocks.CHISELED_DRIPSTONE);

		//Polished Dripstone
		addAfterInBuildingBlocks(RegisterBlocks.CHISELED_DRIPSTONE, RegisterBlocks.POLISHED_DRIPSTONE);
		addAfterInBuildingBlocks(RegisterBlocks.POLISHED_DRIPSTONE, RegisterBlocks.POLISHED_DRIPSTONE_STAIRS);
		addAfterInBuildingBlocks(RegisterBlocks.POLISHED_DRIPSTONE_STAIRS, RegisterBlocks.POLISHED_DRIPSTONE_SLAB);
		addAfterInBuildingBlocks(RegisterBlocks.POLISHED_DRIPSTONE_SLAB, RegisterBlocks.POLISHED_DRIPSTONE_WALL);

		//Dripstone Bricks

		addAfterInBuildingBlocks(RegisterBlocks.POLISHED_DRIPSTONE_WALL, RegisterBlocks.DRIPSTONE_BRICKS);
		addAfterInBuildingBlocks(RegisterBlocks.DRIPSTONE_BRICKS, RegisterBlocks.DRIPSTONE_BRICKS_STAIRS);
		addAfterInBuildingBlocks(RegisterBlocks.DRIPSTONE_BRICKS_STAIRS, RegisterBlocks.DRIPSTONE_BRICKS_SLAB);
		addAfterInBuildingBlocks(RegisterBlocks.DRIPSTONE_BRICKS_SLAB, RegisterBlocks.DRIPSTONE_BRICKS_WALL);
		addAfterInBuildingBlocks(RegisterBlocks.DRIPSTONE_BRICKS_WALL, RegisterBlocks.CHISELED_DRIPSTONE_BRICKS);
		addAfterInBuildingBlocks(RegisterBlocks.DRIPSTONE_BRICKS_STAIRS, RegisterBlocks.CRACKED_DRIPSTONE_BRICKS);


		//Sherds

		addAfterInIngredients(Items.BURN_POTTERY_SHERD, RegisterItems.DRAGON_POTTERY_SHERD);
		addAfterInIngredients(RegisterItems.DRAGON_POTTERY_SHERD, RegisterItems.EGG_POTTERY_SHERD);
		addAfterInIngredients(RegisterItems.EGG_POTTERY_SHERD, RegisterItems.PILLAGER_POTTERY_SHERD);
		addAfterInIngredients(RegisterItems.PILLAGER_POTTERY_SHERD, RegisterItems.PORTAL_POTTERY_SHERD);
		addAfterInIngredients(RegisterItems.PORTAL_POTTERY_SHERD, RegisterItems.SWORD_POTTERY_SHERD);
		addBeforeInIngredients(RegisterItems.EGG_POTTERY_SHERD, RegisterItems.EYE_POTTERY_SHERD);

		//Food
		addAfterInFoodAndDrinks(Items.CHORUS_FRUIT, RegisterItems.CHERRY);

		//Plants
		addAfterInNaturalBlocks(Items.TORCHFLOWER, RegisterBlocks.ICEFLOWER);
		addAfterInNaturalBlocks(Items.TORCHFLOWER_SEEDS, RegisterItems.ICEFLOWER_SEEDS);

		addAfterInNaturalBlocks(RegisterBlocks.ICEFLOWER, RegisterBlocks.BLUE_ROSE);
		addAfterInNaturalBlocks(Items.PITCHER_POD, RegisterItems.BLUE_ROSE_SEEDS);

		addAfterInNaturalBlocks(Items.SHORT_GRASS, RegisterBlocks.SHORT_MYCELIUM_GRASS);
		addAfterInNaturalBlocks(Items.TALL_GRASS, RegisterBlocks.TALL_MYCELIUM_GRASS);
		addAfterInNaturalBlocks(Items.PINK_PETALS, RegisterBlocks.POP_FLOWER);
		addAfterInNaturalBlocks(RegisterBlocks.POP_FLOWER, RegisterBlocks.GLOWSHROOM);


	}



	private static void addBeforeInBuildingBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.BUILDING_BLOCKS);
	}

	private static void addAfterInBuildingBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.BUILDING_BLOCKS);
	}

	private static void addBeforeInNaturalBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.NATURAL_BLOCKS);
	}

	private static void addAfterInNaturalBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.NATURAL_BLOCKS);
	}

	private static void addAfterInBuildingAndNaturalBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.BUILDING_BLOCKS, CreativeModeTabs.NATURAL_BLOCKS);
	}

	private static void addAfterInNaturalAndFunctionalBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.NATURAL_BLOCKS, CreativeModeTabs.FUNCTIONAL_BLOCKS);
	}

	private static void addAfterInFunctionalBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.FUNCTIONAL_BLOCKS);
	}

	private static void addBeforeInRedstoneBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.REDSTONE_BLOCKS);
	}

	private static void addInToolsAndUtilities(ItemLike item) {
		FrozenCreativeTabs.add(item, CreativeModeTabs.TOOLS_AND_UTILITIES);
	}

	private static void addAfterInToolsAndUtilities(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.TOOLS_AND_UTILITIES);
	}

	private static void addBeforeInIngredients(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.INGREDIENTS);
	}

	private static void addAfterInIngredients(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.INGREDIENTS);
	}


	private static void addBeforeInFoodAndDrinks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.FOOD_AND_DRINKS);
	}

	private static void addAfterInFoodAndDrinks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.FOOD_AND_DRINKS);
	}

	private static void addAfterInCombat(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.COMBAT);
	}

	private static void addBeforeInSpawnEggs(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.SPAWN_EGGS);
	}

	private static void addAfterInSpawnEggs(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.SPAWN_EGGS);
	}

	@SafeVarargs
	private static void addInstrumentBefore(
		@NotNull Item comparedItem,
		@NotNull Item instrument,
		@NotNull TagKey<Instrument> tagKey,
		@NotNull ResourceKey<CreativeModeTab>... tabs
	) {
		FrozenCreativeTabs.addInstrumentBefore(comparedItem, instrument, tagKey, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
	}
}
