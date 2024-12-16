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


import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.frozenblock.lib.block.api.FrozenCeilingHangingSignBlock;
import net.frozenblock.lib.block.api.FrozenSignBlock;
import net.frozenblock.lib.block.api.FrozenWallHangingSignBlock;
import net.frozenblock.lib.block.api.FrozenWallSignBlock;
import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.sergofox123.versecraft.VerseSharedConstants;
import net.sergofox123.versecraft.block.BlueRoseCropBlock;
import net.sergofox123.versecraft.block.IceflowerCropBlock;
import static net.minecraft.world.level.block.Blocks.*;


public class RegisterBlocks {

	public static final BlockSetType AZALEA_SET = BlockSetTypeBuilder.copyOf(BlockSetType.CHERRY).register(VerseSharedConstants.id("azalea"));
	public static final WoodType AZALEA_WOOD_TYPE = WoodTypeBuilder.copyOf(WoodType.CHERRY).register(VerseSharedConstants.id("azalea"), AZALEA_SET);

	public static final BlockSetType COPPER_SET = BlockSetTypeBuilder.copyOf(BlockSetType.COPPER).register(VerseSharedConstants.id("copper"));


	private static final MapColor AZALEA_PLANKS_COLOR = MapColor.TERRACOTTA_WHITE;

	private static final MapColor AZALEA_BARK_COLOR = MapColor.TERRACOTTA_WHITE;

	public static final Block AZALEA_LOG = new RotatedPillarBlock(
		BlockBehaviour.Properties.ofFullCopy(CHERRY_LOG)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final Block STRIPPED_AZALEA_LOG = new RotatedPillarBlock(
		BlockBehaviour.Properties.ofFullCopy(STRIPPED_CHERRY_LOG)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final RotatedPillarBlock STRIPPED_AZALEA_WOOD = new RotatedPillarBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_WOOD)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final RotatedPillarBlock AZALEA_WOOD = new RotatedPillarBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_WOOD)
			.mapColor(AZALEA_BARK_COLOR)
	);

	public static final Block AZALEA_PLANKS = new Block(
		BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final StairBlock AZALEA_STAIRS = new StairBlock(
		AZALEA_PLANKS.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(CHERRY_PLANKS)
	);

	public static final Block AZALEA_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_SLAB)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final FenceBlock AZALEA_FENCE = new FenceBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_FENCE)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final Block AZALEA_FENCE_GATE = new FenceGateBlock(
		AZALEA_WOOD_TYPE,
		BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_FENCE_GATE)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final DoorBlock AZALEA_DOOR = new DoorBlock(
		AZALEA_SET,
		BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_DOOR).mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final TrapDoorBlock AZALEA_TRAPDOOR = new TrapDoorBlock(
		AZALEA_SET,
		BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_TRAPDOOR)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final PressurePlateBlock AZALEA_PRESSURE_PLATE = new PressurePlateBlock(
		AZALEA_SET,
		BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PRESSURE_PLATE).mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final Block AZALEA_BUTTON = Blocks.woodenButton(AZALEA_SET);

	public static final FrozenSignBlock AZALEA_SIGN = new FrozenSignBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_SIGN)
			.mapColor(AZALEA_LOG.defaultMapColor()),
		AZALEA_WOOD_TYPE,
		ResourceKey.create(Registries.LOOT_TABLE, VerseSharedConstants.id("blocks/azalea_sign"))
	);

	public static final FrozenWallSignBlock AZALEA_WALL_SIGN = new FrozenWallSignBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_WALL_SIGN)
			.mapColor(AZALEA_LOG.defaultMapColor())
			.dropsLike(AZALEA_SIGN),
		AZALEA_WOOD_TYPE,
		ResourceKey.create(Registries.LOOT_TABLE, VerseSharedConstants.id("blocks/azalea_sign"))
	);

	public static final FrozenCeilingHangingSignBlock AZALEA_HANGING_SIGN = new FrozenCeilingHangingSignBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_HANGING_SIGN)
			.mapColor(AZALEA_LOG.defaultMapColor()),
		AZALEA_WOOD_TYPE,
		ResourceKey.create(Registries.LOOT_TABLE, VerseSharedConstants.id("blocks/azalea_hanging_sign"))
	);
	public static final FrozenWallHangingSignBlock AZALEA_WALL_HANGING_SIGN = new FrozenWallHangingSignBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_WALL_HANGING_SIGN)
			.mapColor(AZALEA_LOG.defaultMapColor())
			.dropsLike(AZALEA_HANGING_SIGN),
		AZALEA_WOOD_TYPE,
		ResourceKey.create(Registries.LOOT_TABLE, VerseSharedConstants.id("blocks/azalea_hanging_sign"))
	);

	public static final BlockFamily AZALEA = BlockFamilies.familyBuilder(AZALEA_PLANKS)
		.button(AZALEA_BUTTON)
		.slab(AZALEA_SLAB)
		.stairs(AZALEA_STAIRS)
		.fence(AZALEA_FENCE)
		.fenceGate(AZALEA_FENCE_GATE)
		.pressurePlate(AZALEA_PRESSURE_PLATE)
		.sign(AZALEA_SIGN, AZALEA_WALL_SIGN)
		.door(AZALEA_DOOR)
		.trapdoor(AZALEA_TRAPDOOR)
		.recipeGroupPrefix("wooden")
		.recipeUnlockedBy("has_planks")
		.getFamily();

	//Azalea Mosaic

	public static final Block AZALEA_MOSAIC = new Block(
		BlockBehaviour.Properties.ofFullCopy(AZALEA_PLANKS)
	);

	public static final StairBlock AZALEA_MOSAIC_STAIRS = new StairBlock(
		AZALEA_PLANKS.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(AZALEA_PLANKS)
	);

	public static final SlabBlock AZALEA_MOSAIC_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(AZALEA_PLANKS)
	);

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

	//Dripstone

	public static final StairBlock DRIPSTONE_STAIRS = new StairBlock(
		DRIPSTONE_BLOCK.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK)
	);

	public static final SlabBlock DRIPSTONE_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK));


	public static final WallBlock DRIPSTONE_WALL = new WallBlock(
		BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK)
	);

	public static final Block CHISELED_DRIPSTONE = new Block(
		BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK)
	);

	//Polished Dripstone

	public static final Block POLISHED_DRIPSTONE = new Block(
		BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK)
	);

	public static final StairBlock POLISHED_DRIPSTONE_STAIRS = new StairBlock(
		DRIPSTONE_BLOCK.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK)
	);

	public static final SlabBlock POLISHED_DRIPSTONE_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK));

	public static final WallBlock POLISHED_DRIPSTONE_WALL = new WallBlock(
		BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK)
	);

	//Dripstone Bricks

	public static final Block DRIPSTONE_BRICKS = new Block(
		BlockBehaviour.Properties.ofFullCopy(CALCITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE)
	);

	public static final Block CRACKED_DRIPSTONE_BRICKS = new Block(
		BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK)
	);


	public static final StairBlock DRIPSTONE_BRICKS_STAIRS = new StairBlock(
		DRIPSTONE_BLOCK.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK)
	);

	public static final SlabBlock DRIPSTONE_BRICKS_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK));

	public static final WallBlock DRIPSTONE_BRICKS_WALL = new WallBlock(
		BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK)
	);

	public static final Block CHISELED_DRIPSTONE_BRICKS = new Block(
		BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK)
	);

	//Diorite

	public static final Block CHISELED_DIORITE = new Block(
		BlockBehaviour.Properties.ofFullCopy(DIORITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE)
	);

	public static final WallBlock POLISHED_DIORITE_WALL = new WallBlock(
		BlockBehaviour.Properties.ofFullCopy(DIORITE_WALL)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE)
	);

	public static final Block DIORITE_BRICKS = new Block(
		BlockBehaviour.Properties.ofFullCopy(DIORITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE)
	);

	public static final Block CRACKED_DIORITE_BRICKS = new Block(
		BlockBehaviour.Properties.ofFullCopy(DIORITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE)
	);

	public static final StairBlock DIORITE_BRICKS_STAIRS = new StairBlock(
		DRIPSTONE_BLOCK.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(DIORITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE)
	);

	public static final SlabBlock DIORITE_BRICKS_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(DIORITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final WallBlock DIORITE_BRICKS_WALL = new WallBlock(
		BlockBehaviour.Properties.ofFullCopy(DIORITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE)
	);

	public static final Block CHISELED_DIORITE_BRICKS = new Block(
		BlockBehaviour.Properties.ofFullCopy(DIORITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE)
	);

	//Andesite

	public static final Block CHISELED_ANDESITE = new Block(
		BlockBehaviour.Properties.ofFullCopy(ANDESITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE)
	);

	public static final WallBlock POLISHED_ANDESITE_WALL = new WallBlock(
		BlockBehaviour.Properties.ofFullCopy(ANDESITE_WALL)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE)
	);

	public static final Block ANDESITE_BRICKS = new Block(
		BlockBehaviour.Properties.ofFullCopy(ANDESITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE)
	);

	public static final Block CRACKED_ANDESITE_BRICKS = new Block(
		BlockBehaviour.Properties.ofFullCopy(ANDESITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE)
	);

	public static final StairBlock ANDESITE_BRICKS_STAIRS = new StairBlock(
		DRIPSTONE_BLOCK.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(ANDESITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE)
	);

	public static final SlabBlock ANDESITE_BRICKS_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(ANDESITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final WallBlock ANDESITE_BRICKS_WALL = new WallBlock(
		BlockBehaviour.Properties.ofFullCopy(ANDESITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE)
	);

	public static final Block CHISELED_ANDESITE_BRICKS = new Block(
		BlockBehaviour.Properties.ofFullCopy(ANDESITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE)
	);

	//Granite

	public static final Block CHISELED_GRANITE = new Block(
		BlockBehaviour.Properties.ofFullCopy(GRANITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE)
	);

	public static final WallBlock POLISHED_GRANITE_WALL = new WallBlock(
		BlockBehaviour.Properties.ofFullCopy(GRANITE_WALL)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE)
	);

	public static final Block GRANITE_BRICKS = new Block(
		BlockBehaviour.Properties.ofFullCopy(GRANITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE)
	);

	public static final Block CRACKED_GRANITE_BRICKS = new Block(
		BlockBehaviour.Properties.ofFullCopy(GRANITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE)
	);

	public static final StairBlock GRANITE_BRICKS_STAIRS = new StairBlock(
		DRIPSTONE_BLOCK.defaultBlockState(),
		BlockBehaviour.Properties.ofFullCopy(GRANITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE)
	);

	public static final SlabBlock GRANITE_BRICKS_SLAB = new SlabBlock(
		BlockBehaviour.Properties.ofFullCopy(GRANITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final WallBlock GRANITE_BRICKS_WALL = new WallBlock(
		BlockBehaviour.Properties.ofFullCopy(GRANITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE)
	);

	public static final Block CHISELED_GRANITE_BRICKS = new Block(
		BlockBehaviour.Properties.ofFullCopy(GRANITE)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE)
	);

	//Plants

	public static final FlowerBlock ICEFLOWER = new FlowerBlock(
		MobEffects.SATURATION,
		0.0F,
		BlockBehaviour.Properties.ofFullCopy(TORCHFLOWER)
			.mapColor(MapColor.PLANT)
	); 	//Placeholder code

	public static final Block ICEFLOWER_CROP = new IceflowerCropBlock(
		BlockBehaviour.Properties.of()
			.mapColor(MapColor.PLANT)
			.noCollission()
			.randomTicks()
			.instabreak()
			.sound(SoundType.CROP)
			.pushReaction(PushReaction.DESTROY)
	);

	public static final Block POTTED_ICEFLOWER = Blocks.flowerPot(ICEFLOWER);

	public static final FlowerBlock BLUE_ROSE = new FlowerBlock(
		MobEffects.SATURATION,
		0.0F,
		BlockBehaviour.Properties.ofFullCopy(TORCHFLOWER)
			.mapColor(MapColor.PLANT)
	); 	//Placeholder code

	public static final Block BLUE_ROSE_CROP = new BlueRoseCropBlock(
		BlockBehaviour.Properties.of()
			.mapColor(MapColor.PLANT)
			.noCollission()
			.randomTicks()
			.instabreak()
			.sound(SoundType.CROP)
			.pushReaction(PushReaction.DESTROY)
	);

	public static final Block POTTED_BLUE_ROSE = Blocks.flowerPot(BLUE_ROSE);

	public static void registerBB() {


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

		//Diorite
		registerBlockAfter(Items.DIORITE_WALL,"chiseled_diorite", CHISELED_DIORITE, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.POLISHED_DIORITE_SLAB,"polished_diorite_wall", POLISHED_DIORITE_WALL, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(POLISHED_DIORITE_WALL,"diorite_bricks", DIORITE_BRICKS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(DIORITE_BRICKS,"cracked_diorite_bricks", CRACKED_DIORITE_BRICKS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(CRACKED_DIORITE_BRICKS,"diorite_bricks_stairs", DIORITE_BRICKS_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(DIORITE_BRICKS_STAIRS,"diorite_bricks_slab", DIORITE_BRICKS_SLAB, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(DIORITE_BRICKS_SLAB,"diorite_bricks_wall", DIORITE_BRICKS_WALL, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(DIORITE_BRICKS_WALL,"chiseled_diorite_bricks", CHISELED_DIORITE_BRICKS, CreativeModeTabs.BUILDING_BLOCKS);

        //Andesite
		registerBlockAfter(Items.ANDESITE_WALL,"chiseled_andesite", CHISELED_ANDESITE, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.POLISHED_ANDESITE_SLAB,"polished_andesite_wall", POLISHED_ANDESITE_WALL, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(POLISHED_ANDESITE_WALL,"andesite_bricks", ANDESITE_BRICKS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(ANDESITE_BRICKS,"cracked_andesite_bricks", CRACKED_ANDESITE_BRICKS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(CRACKED_ANDESITE_BRICKS,"andesite_bricks_stairs", ANDESITE_BRICKS_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(ANDESITE_BRICKS_STAIRS,"andesite_bricks_slab", ANDESITE_BRICKS_SLAB, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(ANDESITE_BRICKS_SLAB,"andesite_bricks_wall", ANDESITE_BRICKS_WALL, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(ANDESITE_BRICKS_WALL,"chiseled_andesite_bricks", CHISELED_ANDESITE_BRICKS, CreativeModeTabs.BUILDING_BLOCKS);

		//Granite
		registerBlockAfter(Items.GRANITE_WALL,"chiseled_granite", CHISELED_GRANITE, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.POLISHED_GRANITE_SLAB,"polished_granite_wall", POLISHED_GRANITE_WALL, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(POLISHED_GRANITE_WALL,"granite_bricks", GRANITE_BRICKS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(GRANITE_BRICKS,"cracked_granite_bricks", CRACKED_GRANITE_BRICKS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(CRACKED_GRANITE_BRICKS,"granite_bricks_stairs", GRANITE_BRICKS_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(GRANITE_BRICKS_STAIRS,"granite_bricks_slab", GRANITE_BRICKS_SLAB, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(GRANITE_BRICKS_SLAB,"granite_bricks_wall", GRANITE_BRICKS_WALL, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(GRANITE_BRICKS_WALL,"chiseled_granite_bricks", CHISELED_GRANITE_BRICKS, CreativeModeTabs.BUILDING_BLOCKS);

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

		//Dripstone
		FrozenCreativeTabs.addAfter(Items.CHISELED_TUFF_BRICKS, Items.DRIPSTONE_BLOCK, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(Items.DRIPSTONE_BLOCK,"dripstone_stairs", DRIPSTONE_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(DRIPSTONE_STAIRS,"dripstone_slab", DRIPSTONE_SLAB, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(DRIPSTONE_SLAB,"dripstone_wall", DRIPSTONE_WALL, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(DRIPSTONE_WALL,"chiseled_dripstone", CHISELED_DRIPSTONE, CreativeModeTabs.BUILDING_BLOCKS);

		//Polished Dripstone
		registerBlockAfter(CHISELED_DRIPSTONE,"polished_dripstone", POLISHED_DRIPSTONE, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(POLISHED_DRIPSTONE,"polished_dripstone_stairs", POLISHED_DRIPSTONE_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(POLISHED_DRIPSTONE_STAIRS,"polished_dripstone_slab", POLISHED_DRIPSTONE_SLAB, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(POLISHED_DRIPSTONE_SLAB,"polished_dripstone_wall", POLISHED_DRIPSTONE_WALL, CreativeModeTabs.BUILDING_BLOCKS);

		//Dripstone Bricks

		registerBlockAfter(POLISHED_DRIPSTONE_WALL,"dripstone_bricks", DRIPSTONE_BRICKS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(DRIPSTONE_BRICKS,"dripstone_bricks_stairs", DRIPSTONE_BRICKS_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(DRIPSTONE_BRICKS_STAIRS,"dripstone_bricks_slab", DRIPSTONE_BRICKS_SLAB, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(DRIPSTONE_BRICKS_SLAB,"dripstone_bricks_wall", DRIPSTONE_BRICKS_WALL, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(DRIPSTONE_BRICKS_WALL,"chiseled_dripstone_bricks", CHISELED_DRIPSTONE_BRICKS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockBefore(DRIPSTONE_BRICKS_STAIRS,"cracked_dripstone_bricks", CRACKED_DRIPSTONE_BRICKS, CreativeModeTabs.BUILDING_BLOCKS);


		//Azalea Wood
		registerBlockAfter(Items.ACACIA_BUTTON,"azalea_log", AZALEA_LOG, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_LOG,"azalea_wood", AZALEA_WOOD, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_WOOD, "stripped_azalea_log", STRIPPED_AZALEA_LOG, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(STRIPPED_AZALEA_LOG,"stripped_azalea_wood" , STRIPPED_AZALEA_WOOD, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(STRIPPED_AZALEA_WOOD, "azalea_planks", AZALEA_PLANKS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_PLANKS,"azalea_mosaic", AZALEA_MOSAIC, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_MOSAIC,"azalea_stairs", AZALEA_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_STAIRS, "azalea_mosaic_stairs", AZALEA_MOSAIC_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_MOSAIC_STAIRS,"azalea_slab", AZALEA_SLAB, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_SLAB, "azalea_mosaic_slab", AZALEA_MOSAIC_SLAB, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_MOSAIC_SLAB,"azalea_fence", AZALEA_FENCE, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_FENCE,"azalea_fence_gate", AZALEA_FENCE_GATE, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_FENCE_GATE,"azalea_door", AZALEA_DOOR, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_DOOR,"azalea_trapdoor", AZALEA_TRAPDOOR, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_TRAPDOOR,"azalea_pressure_plate", AZALEA_PRESSURE_PLATE, CreativeModeTabs.BUILDING_BLOCKS);
		registerBlockAfter(AZALEA_PRESSURE_PLATE,"azalea_button", AZALEA_BUTTON, CreativeModeTabs.BUILDING_BLOCKS);

		registerBlock("azalea_sign", AZALEA_SIGN);
		registerBlock("azalea_wall_sign", AZALEA_WALL_SIGN);
		registerBlock("azalea_hanging_sign", AZALEA_HANGING_SIGN);
		registerBlock("azalea_wall_hanging_sign", AZALEA_WALL_HANGING_SIGN);

		//Natural
		registerBlockAfter(Items.ACACIA_LOG,"azalea_log", AZALEA_LOG, CreativeModeTabs.NATURAL_BLOCKS);

		//Plants

		registerBlockAfter(Items.TORCHFLOWER,"iceflower", ICEFLOWER, CreativeModeTabs.NATURAL_BLOCKS);
		registerBlock("iceflower_crop", ICEFLOWER_CROP);
		registerBlock("potted_iceflower", POTTED_ICEFLOWER);

		registerBlockBefore(ICEFLOWER,"blue_rose", BLUE_ROSE, CreativeModeTabs.NATURAL_BLOCKS);
		registerBlock("blue_rose_crop", BLUE_ROSE_CROP);
		registerBlock("potted_blue_rose", POTTED_BLUE_ROSE);

	}


	public static void registerBlocks() {

		registerBB();

	}


	private static void registerFlammability() {

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

		flammableBlockRegistry.add(RegisterBlocks.AZALEA_LOG, 5, 5);
		flammableBlockRegistry.add(RegisterBlocks.STRIPPED_AZALEA_LOG, 5, 5);
		flammableBlockRegistry.add(RegisterBlocks.AZALEA_WOOD, 5, 5);
		flammableBlockRegistry.add(RegisterBlocks.STRIPPED_AZALEA_WOOD, 5, 5);
		flammableBlockRegistry.add(RegisterBlocks.AZALEA_PLANKS, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.AZALEA_STAIRS, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.AZALEA_FENCE, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.AZALEA_SLAB, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.AZALEA_FENCE_GATE, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.AZALEA_PRESSURE_PLATE, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.AZALEA_BUTTON, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.AZALEA_SIGN, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.AZALEA_WALL_SIGN, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.AZALEA_HANGING_SIGN, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.AZALEA_WALL_HANGING_SIGN, 5, 20);

		flammableBlockRegistry.add(RegisterBlocks.AZALEA_MOSAIC, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.AZALEA_MOSAIC_STAIRS, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.AZALEA_MOSAIC_SLAB, 5, 20);

		flammableBlockRegistry.add(RegisterBlocks.ICEFLOWER, 100, 60);
		flammableBlockRegistry.add(RegisterBlocks.BLUE_ROSE, 100, 60);
	}

	private static void registerStrippable() {
		StrippableBlockRegistry.register(AZALEA_LOG, STRIPPED_AZALEA_LOG);
		StrippableBlockRegistry.register(AZALEA_WOOD, STRIPPED_AZALEA_WOOD);
	}

	private static void registerFuels() {

		FuelRegistry registry = FuelRegistry.INSTANCE;

		registry.add(ACACIA_MOSAIC.asItem(), 300);
		registry.add(ACACIA_MOSAIC_SLAB.asItem(), 150);
		registry.add(ACACIA_MOSAIC_STAIRS.asItem(), 300);

		registry.add(AZALEA_MOSAIC.asItem(), 300);
		registry.add(AZALEA_MOSAIC_SLAB.asItem(), 150);
		registry.add(AZALEA_MOSAIC_STAIRS.asItem(), 300);

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

		registerFuels();
		registerStrippable();
		registerFlammability();

		var sign = (FabricBlockEntityType) BlockEntityType.SIGN;
		var hangingSign = (FabricBlockEntityType) BlockEntityType.HANGING_SIGN;

		sign.addSupportedBlock(AZALEA_SIGN);
		sign.addSupportedBlock(AZALEA_WALL_SIGN);

		hangingSign.addSupportedBlock(AZALEA_HANGING_SIGN);
		hangingSign.addSupportedBlock(AZALEA_WALL_HANGING_SIGN);
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
