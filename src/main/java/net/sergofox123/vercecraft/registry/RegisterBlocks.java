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

package net.sergofox123.vercecraft.registry;


import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.frozenblock.lib.shadow.org.intellij.lang.annotations.Identifier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.sergofox123.vercecraft.VerseSharedConstants;
import static net.minecraft.world.level.block.Blocks.*;


public class RegisterBlocks {

	public static final BlockSetType AZALEA_SET = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).register(VerseSharedConstants.id("azalea"));
	public static final WoodType AZALEA_WOOD_TYPE = WoodTypeBuilder.copyOf(WoodType.ACACIA).register(VerseSharedConstants.id("azalea"), AZALEA_SET);

	private static final MapColor AZALEA_PLANKS_COLOR = MapColor.TERRACOTTA_WHITE;

	private static final MapColor AZALEA_BARK_COLOR = MapColor.TERRACOTTA_WHITE;

	public static final Block AZALEA_LOG = Blocks.log(AZALEA_PLANKS_COLOR, AZALEA_BARK_COLOR);

	public static final Block STRIPPED_AZALEA_LOG = Blocks.log(AZALEA_PLANKS_COLOR, AZALEA_BARK_COLOR);

	public static final RotatedPillarBlock STRIPPED_AZALEA_WOOD = new RotatedPillarBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final RotatedPillarBlock AZALEA_WOOD = new RotatedPillarBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
			.mapColor(AZALEA_BARK_COLOR)
	);

	public static final Block AZALEA_PLANKS = new Block(
		BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final StairBlock AZALEA_STAIRS = new StairBlock(
		AZALEA_PLANKS.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(AZALEA_PLANKS)
	);

	public static final Block AZALEA_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final FenceBlock AZALEA_FENCE = new FenceBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final Block AZALEA_FENCE_GATE = new FenceGateBlock(
		AZALEA_WOOD_TYPE,
		BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final DoorBlock AZALEA_DOOR = new DoorBlock(
		AZALEA_SET,
		BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final TrapDoorBlock AZALEA_TRAPDOOR = new TrapDoorBlock(
		AZALEA_SET,
		BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final PressurePlateBlock AZALEA_PRESSURE_PLATE = new PressurePlateBlock(
		AZALEA_SET,
		BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final Block AZALEA_BUTTON = Blocks.woodenButton(AZALEA_SET);

	//Acacia Mosaic

	public static final Block ACACIA_MOSAIC = new Block(
		BlockBehaviour.Properties.ofFullCopy(ACACIA_PLANKS)

	);

	public static final StairBlock ACACIA_MOSAIC_STAIRS = new StairBlock(
		ACACIA_STAIRS.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_STAIRS)
	);

	public static final SlabBlock ACACIA_MOSAIC_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_SLAB)
	);

	//Birch Mosaic

	public static final Block BIRCH_MOSAIC = new Block(
		BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
	);

	public static final StairBlock BIRCH_MOSAIC_STAIRS = new StairBlock(
		BIRCH_PLANKS.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_STAIRS)
	);

	public static final SlabBlock BIRCH_MOSAIC_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_SLAB)
	);

	//Cherry Mosaic

	public static final Block CHERRY_MOSAIC = new Block(
		BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
	);

	public static final StairBlock CHERRY_MOSAIC_STAIRS = new StairBlock(
		CHERRY_PLANKS.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_STAIRS)
	);

	public static final SlabBlock CHERRY_MOSAIC_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_SLAB)

	);

	//Crimson Mosaic

	public static final Block CRIMSON_MOSAIC = new Block(
		BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
	);

	public static final StairBlock CRIMSON_MOSAIC_STAIRS = new StairBlock(
		CRIMSON_PLANKS.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STAIRS)
	);

	public static final SlabBlock CRIMSON_MOSAIC_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SLAB)
	);

	//Dark Oak Mosaic

	public static final Block DARK_OAK_MOSAIC = new Block(
		BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
	);

	public static final StairBlock DARK_OAK_MOSAIC_STAIRS = new StairBlock(
		DARK_OAK_PLANKS.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_STAIRS)
	);

	public static final SlabBlock DARK_OAK_MOSAIC_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_SLAB)

	);

	//Jungle Mosaic

	public static final Block JUNGLE_MOSAIC = new Block(
		BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
	);

	public static final StairBlock JUNGLE_MOSAIC_STAIRS = new StairBlock(
		JUNGLE_PLANKS.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_STAIRS)

	);

	public static final SlabBlock JUNGLE_MOSAIC_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SLAB)

	);

	//Mangrove Mosaic

	public static final Block MANGROVE_MOSAIC = new Block(
		BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
	);

	public static final StairBlock MANGROVE_MOSAIC_STAIRS = new StairBlock(
		ACACIA_PLANKS.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_STAIRS)
	);

	public static final SlabBlock MANGROVE_MOSAIC_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_SLAB)

	);

	//Oak Mosaic

	public static final Block OAK_MOSAIC = new Block(
		BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
	);

	public static final StairBlock OAK_MOSAIC_STAIRS = new StairBlock(
		OAK_PLANKS.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)
	);

	public static final SlabBlock OAK_MOSAIC_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)

	);

	//Spruce Mosaic

	public static final Block SPRUCE_MOSAIC = new Block(
		BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
	);

	public static final StairBlock SPRUCE_MOSAIC_STAIRS = new StairBlock(
		SPRUCE_PLANKS.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_STAIRS)
	);

	public static final SlabBlock SPRUCE_MOSAIC_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_SLAB)
	);

	//Warped

	public static final Block WARPED_MOSAIC = new Block(
		BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
	);

	public static final StairBlock WARPED_MOSAIC_STAIRS = new StairBlock(
		WARPED_PLANKS.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STAIRS)
	);

	public static final SlabBlock WARPED_MOSAIC_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_SLAB)

	);

	//Tuff

	public static final Block CRACKED_TUFF_BRICKS = new Block(
		BlockBehaviour.Properties.ofFullCopy(TUFF)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.TUFF)
	);

	//Calcite
	public static final StairBlock CALCITE_STAIRS = new StairBlock(
		CALCITE.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(CALCITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE)
	);

	public static final SlabBlock CALCITE_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(CALCITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE));


	public static final WallBlock CALCITE_WALL = new WallBlock(
		BlockBehaviour.Properties.ofFullCopy(CALCITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE)
	);

	public static final Block CHISELED_CALCITE = new Block(
		BlockBehaviour.Properties.ofFullCopy(CALCITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE)
	);

	//Polished Calcite

	public static final Block POLISHED_CALCITE = new Block(
		BlockBehaviour.Properties.ofFullCopy(CALCITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE)
	);

	public static final StairBlock POLISHED_CALCITE_STAIRS = new StairBlock(
		CALCITE.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(CALCITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE)
	);

	public static final SlabBlock POLISHED_CALCITE_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(CALCITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE));

	public static final WallBlock POLISHED_CALCITE_WALL = new WallBlock(
		BlockBehaviour.Properties.ofFullCopy(CALCITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE)
	);

	//Calcite Bricks

	public static final Block CALCITE_BRICKS = new Block(
		BlockBehaviour.Properties.ofFullCopy(CALCITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE)
	);

	public static final Block CRACKED_CALCITE_BRICKS = new Block(
		BlockBehaviour.Properties.ofFullCopy(CALCITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE)
	);


	public static final StairBlock CALCITE_BRICKS_STAIRS = new StairBlock(
		CALCITE.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(CALCITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE)
	);

	public static final SlabBlock CALCITE_BRICKS_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(CALCITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE));

	public static final WallBlock CALCITE_BRICKS_WALL = new WallBlock(
		BlockBehaviour.Properties.ofFullCopy(CALCITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE)
	);

	public static final Block CHISELED_CALCITE_BRICKS = new Block(
		BlockBehaviour.Properties.ofFullCopy(CALCITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE)
	);

	public static void registerBB() {

		//Azalea
		registerBlockAfter(Items.ACACIA_BUTTON,"azalea_log", AZALEA_LOG, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_LOG,"azalea_wood", AZALEA_WOOD, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_WOOD,"stripped_azalea_log", STRIPPED_AZALEA_LOG, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(STRIPPED_AZALEA_LOG,"stripped_azalea_wood", STRIPPED_AZALEA_WOOD, CreativeModeTabs.BUILDING_BLOCKS);

		registerBlockAfter(STRIPPED_AZALEA_WOOD,"azalea_planks", AZALEA_PLANKS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_PLANKS,"azalea_stairs", AZALEA_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_STAIRS,"azalea_slab", AZALEA_SLAB, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_SLAB,"azalea_fence", AZALEA_FENCE, CreativeModeTabs.BUILDING_BLOCKS);


		//Acacia Mosaic
		registerBlockAfter(Items.ACACIA_PLANKS,"acacia_mosaic", ACACIA_MOSAIC, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.ACACIA_STAIRS,"acacia_mosaic_stairs", ACACIA_MOSAIC_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.ACACIA_SLAB,"acacia_mosaic_slab", ACACIA_MOSAIC_SLAB, CreativeModeTabs.BUILDING_BLOCKS);

		//Birch Mosaic
		registerBlockAfter(Items.BIRCH_PLANKS,"birch_mosaic", BIRCH_MOSAIC, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.BIRCH_STAIRS,"birch_mosaic_stairs", BIRCH_MOSAIC_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.BIRCH_SLAB,"birch_mosaic_slab", BIRCH_MOSAIC_SLAB, CreativeModeTabs.BUILDING_BLOCKS);

		//Cherry Mosaic
		registerBlockAfter(Items.CHERRY_PLANKS,"cherry_mosaic", CHERRY_MOSAIC, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.CHERRY_STAIRS,"cherry_mosaic_stairs", CHERRY_MOSAIC_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.CHERRY_SLAB,"cherry_mosaic_slab", CHERRY_MOSAIC_SLAB, CreativeModeTabs.BUILDING_BLOCKS);

		//Crimson Mosaic
		registerBlockAfter(Items.CRIMSON_PLANKS,"crimson_mosaic", CRIMSON_MOSAIC, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.CRIMSON_STAIRS,"crimson_mosaic_stairs", CRIMSON_MOSAIC_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.CRIMSON_SLAB,"crimson_mosaic_slab", CRIMSON_MOSAIC_SLAB, CreativeModeTabs.BUILDING_BLOCKS);

		//Dark Oak Mosaic
		registerBlockAfter(Items.DARK_OAK_PLANKS,"dark_oak_mosaic", DARK_OAK_MOSAIC, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.DARK_OAK_STAIRS,"dark_oak_mosaic_stairs", DARK_OAK_MOSAIC_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.DARK_OAK_SLAB,"dark_oak_mosaic_slab", DARK_OAK_MOSAIC_SLAB, CreativeModeTabs.BUILDING_BLOCKS);

		//Jungle Mosaic
		registerBlockAfter(Items.JUNGLE_PLANKS,"jungle_mosaic", JUNGLE_MOSAIC, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.JUNGLE_STAIRS,"jungle_mosaic_stairs", JUNGLE_MOSAIC_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.JUNGLE_SLAB,"jungle_mosaic_slab", JUNGLE_MOSAIC_SLAB, CreativeModeTabs.BUILDING_BLOCKS);

		//Mangrove Mosaic
		registerBlockAfter(Items.MANGROVE_PLANKS,"mangrove_mosaic", MANGROVE_MOSAIC, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.MANGROVE_STAIRS,"mangrove_mosaic_stairs", MANGROVE_MOSAIC_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.MANGROVE_SLAB,"mangrove_mosaic_slab", MANGROVE_MOSAIC_SLAB, CreativeModeTabs.BUILDING_BLOCKS);

        //Oak Mosaic
		registerBlockAfter(Items.OAK_PLANKS,"oak_mosaic", OAK_MOSAIC, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.OAK_STAIRS,"oak_mosaic_stairs", OAK_MOSAIC_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.OAK_SLAB,"oak_mosaic_slab", OAK_MOSAIC_SLAB, CreativeModeTabs.BUILDING_BLOCKS);

		//Spruce Mosaic
		registerBlockAfter(Items.SPRUCE_PLANKS,"spruce_mosaic", SPRUCE_MOSAIC, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.SPRUCE_STAIRS,"spruce_mosaic_stairs", SPRUCE_MOSAIC_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.SPRUCE_SLAB,"spruce_mosaic_slab", SPRUCE_MOSAIC_SLAB, CreativeModeTabs.BUILDING_BLOCKS);

		//Warped Mosaic
		registerBlockAfter(Items.WARPED_PLANKS,"warped_mosaic", WARPED_MOSAIC, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.WARPED_STAIRS,"warped_mosaic_stairs", WARPED_MOSAIC_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.WARPED_SLAB,"warped_mosaic_slab", WARPED_MOSAIC_SLAB, CreativeModeTabs.BUILDING_BLOCKS);

		//Tuff
		registerBlockAfter(Items.TUFF_BRICKS,"cracked_tuff_bricks", CRACKED_TUFF_BRICKS, CreativeModeTabs.BUILDING_BLOCKS);


		//Calcite
		FrozenCreativeTabs.addAfter(Items.REINFORCED_DEEPSLATE, Items.CALCITE, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.CALCITE,"calcite_stairs", CALCITE_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(CALCITE_STAIRS,"calcite_slab", CALCITE_SLAB, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(CALCITE_SLAB,"calcite_wall", CALCITE_WALL, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(CALCITE_WALL,"chiseled_calcite", CHISELED_CALCITE, CreativeModeTabs.BUILDING_BLOCKS);

		//Polished Calcite
		registerBlockAfter(CHISELED_CALCITE,"polished_calcite", POLISHED_CALCITE, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(POLISHED_CALCITE,"polished_calcite_stairs", POLISHED_CALCITE_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(POLISHED_CALCITE_STAIRS,"polished_calcite_slab", POLISHED_CALCITE_SLAB, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(POLISHED_CALCITE_SLAB,"polished_calcite_wall", POLISHED_CALCITE_WALL, CreativeModeTabs.BUILDING_BLOCKS);

		//Calcite Bricks
		registerBlockAfter(POLISHED_CALCITE_WALL,"calcite_bricks", CALCITE_BRICKS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(CALCITE_BRICKS,"calcite_bricks_stairs", CALCITE_BRICKS_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(CALCITE_BRICKS_STAIRS,"calcite_bricks_slab", CALCITE_BRICKS_SLAB, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(CALCITE_BRICKS_SLAB,"calcite_bricks_wall", CALCITE_BRICKS_WALL, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(CALCITE_BRICKS_WALL,"chiseled_calcite_bricks", CHISELED_CALCITE_BRICKS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockBefore(CALCITE_BRICKS_STAIRS,"cracked_calcite_bricks", CRACKED_CALCITE_BRICKS, CreativeModeTabs.BUILDING_BLOCKS);

	}

	public static void registerWoods() {
		String azalea = "azalea";

		String wood = azalea;
		//Azalea
		registerBlockAfter(Items.ACACIA_BUTTON, wood + "_log", AZALEA_LOG, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_LOG, wood + "_wood", AZALEA_WOOD, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_WOOD, "stripped_" + wood + "_log", STRIPPED_AZALEA_LOG, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(STRIPPED_AZALEA_LOG, "stripped_" + wood + "_wood", STRIPPED_AZALEA_WOOD, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(STRIPPED_AZALEA_WOOD, wood + "_planks", AZALEA_PLANKS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_PLANKS, wood + "_stairs", AZALEA_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_STAIRS, wood + "_slab", AZALEA_SLAB, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_SLAB, wood + "_fence", AZALEA_FENCE, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_FENCE, wood + "_fence_gate", AZALEA_FENCE_GATE, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_FENCE_GATE, wood + "_door", AZALEA_DOOR, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_DOOR, wood + "_trapdoor", AZALEA_TRAPDOOR, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_TRAPDOOR, wood + "_pressure_plate", AZALEA_PRESSURE_PLATE, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_PRESSURE_PLATE, wood + "_button", AZALEA_BUTTON, CreativeModeTabs.BUILDING_BLOCKS);
	}

	public static void registerBlocks() {
		VerseSharedConstants.logWithModId("Registering Blocks for", VerseSharedConstants.UNSTABLE_LOGGING);

		registerBB();

	}


	private static void registerFlammability() {
		VerseSharedConstants.logWithModId("Registering Flammability for", VerseSharedConstants.UNSTABLE_LOGGING);
		var flammableBlockRegistry = FlammableBlockRegistry.getDefaultInstance();

		flammableBlockRegistry.add(RegisterBlocks.ACACIA_MOSAIC, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.ACACIA_MOSAIC_STAIRS, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.ACACIA_MOSAIC_SLAB, 5, 20);

		flammableBlockRegistry.add(RegisterBlocks.BIRCH_MOSAIC, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.BIRCH_MOSAIC_STAIRS, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.BIRCH_MOSAIC_SLAB, 5, 20);

		flammableBlockRegistry.add(RegisterBlocks.CHERRY_MOSAIC, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.CHERRY_MOSAIC_STAIRS, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.CHERRY_MOSAIC_SLAB, 5, 20);

		flammableBlockRegistry.add(RegisterBlocks.DARK_OAK_MOSAIC, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.DARK_OAK_MOSAIC_STAIRS, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.DARK_OAK_MOSAIC_SLAB, 5, 20);

		flammableBlockRegistry.add(RegisterBlocks.JUNGLE_MOSAIC, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.JUNGLE_MOSAIC_STAIRS, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.JUNGLE_MOSAIC_SLAB, 5, 20);

		flammableBlockRegistry.add(RegisterBlocks.JUNGLE_MOSAIC, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.JUNGLE_MOSAIC_STAIRS, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.JUNGLE_MOSAIC_SLAB, 5, 20);

		flammableBlockRegistry.add(RegisterBlocks.MANGROVE_MOSAIC, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.MANGROVE_MOSAIC_STAIRS, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.MANGROVE_MOSAIC_SLAB, 5, 20);

		flammableBlockRegistry.add(RegisterBlocks.OAK_MOSAIC, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.OAK_MOSAIC_STAIRS, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.OAK_MOSAIC_SLAB, 5, 20);

		flammableBlockRegistry.add(RegisterBlocks.SPRUCE_MOSAIC, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.SPRUCE_MOSAIC_STAIRS, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.SPRUCE_MOSAIC_SLAB, 5, 20);
	}

	private static void registerFuels() {
		VerseSharedConstants.logWithModId("Registering Fuels for", VerseSharedConstants.UNSTABLE_LOGGING);
		FuelRegistry registry = FuelRegistry.INSTANCE;

		registry.add(ACACIA_MOSAIC.asItem(), 300);
		registry.add(ACACIA_MOSAIC_SLAB.asItem(), 150);
		registry.add(ACACIA_MOSAIC_STAIRS.asItem(), 300);

		registry.add(BIRCH_MOSAIC.asItem(), 300);
		registry.add(BIRCH_MOSAIC_SLAB.asItem(), 150);
		registry.add(BIRCH_MOSAIC_STAIRS.asItem(), 300);

		registry.add(CHERRY_MOSAIC.asItem(), 300);
		registry.add(CHERRY_MOSAIC_SLAB.asItem(), 150);
		registry.add(CHERRY_MOSAIC_STAIRS.asItem(), 300);

		registry.add(DARK_OAK_MOSAIC.asItem(), 300);
		registry.add(DARK_OAK_MOSAIC_SLAB.asItem(), 150);
		registry.add(DARK_OAK_MOSAIC_STAIRS.asItem(), 300);

		registry.add(JUNGLE_MOSAIC.asItem(), 300);
		registry.add(JUNGLE_MOSAIC_SLAB.asItem(), 150);
		registry.add(JUNGLE_MOSAIC_STAIRS.asItem(), 300);

		registry.add(MANGROVE_MOSAIC.asItem(), 300);
		registry.add(MANGROVE_MOSAIC_SLAB.asItem(), 150);
		registry.add(MANGROVE_MOSAIC_STAIRS.asItem(), 300);

		registry.add(OAK_MOSAIC.asItem(), 300);
		registry.add(OAK_MOSAIC_SLAB.asItem(), 150);
		registry.add(OAK_MOSAIC_STAIRS.asItem(), 300);

		registry.add(SPRUCE_MOSAIC.asItem(), 300);
		registry.add(SPRUCE_MOSAIC_SLAB.asItem(), 150);
		registry.add(SPRUCE_MOSAIC_STAIRS.asItem(), 300);
	}

	public static void registerBlockProperties() {


		registerFlammability();
		registerFuels();
		registerWoods();
	}

	private static void registerBlock(String path, Block block) {
		actualRegisterBlock(path, block);
	}

	@SafeVarargs
	private static void registerBlockBefore(ItemLike comparedItem, String path, Block block, ResourceKey<CreativeModeTab>... tabs) {
		registerBlockItemBefore(comparedItem, path, block, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
		actualRegisterBlock(path, block);
	}

	@SafeVarargs
	private static void registerBlockAfter(ItemLike comparedItem, String path, Block block, ResourceKey<CreativeModeTab>... tabs) {
		registerBlockItemAfter(comparedItem, path, block, tabs);
		actualRegisterBlock(path, block);
	}

	@SafeVarargs
	private static void registerBlockItemBefore(ItemLike comparedItem, String path, Block block, CreativeModeTab.TabVisibility tabVisibility, ResourceKey<CreativeModeTab>... tabs) {
		actualRegisterBlockItem(path, block);
		FrozenCreativeTabs.addBefore(comparedItem, block, tabVisibility, tabs);
	}

	@SafeVarargs
	private static void registerBlockItemAfter(ItemLike comparedItem, String name, Block block, ResourceKey<CreativeModeTab>... tabs) {
		registerBlockItemAfter(comparedItem, name, block, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
	}

	@SafeVarargs
	private static void registerBlockItemAfter(ItemLike comparedItem, String path, Block block, CreativeModeTab.TabVisibility visibility, ResourceKey<CreativeModeTab>... tabs) {
		actualRegisterBlockItem(path, block);
		FrozenCreativeTabs.addAfter(comparedItem, block, visibility, tabs);
	}

	private static void actualRegisterBlock(String path, Block block) {
		if (BuiltInRegistries.BLOCK.getOptional(VerseSharedConstants.id(path)).isEmpty()) {
			Registry.register(BuiltInRegistries.BLOCK, VerseSharedConstants.id(path), block);
		}
	}

	private static void actualRegisterBlockItem(String path, Block block) {
		if (BuiltInRegistries.ITEM.getOptional(VerseSharedConstants.id(path)).isEmpty()) {
			Registry.register(BuiltInRegistries.ITEM, VerseSharedConstants.id(path), new BlockItem(block, new Item.Properties()));
		}
	}
}
