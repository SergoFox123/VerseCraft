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
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FireflyBushBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.TintedParticleLeavesBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.sergofox123.versecraft.VerseSharedConstants;
import net.sergofox123.versecraft.block.BlueRoseCropBlock;
import net.sergofox123.versecraft.block.IceflowerCropBlock;
import net.sergofox123.versecraft.block.ShortMyceliumGrass;
import net.sergofox123.versecraft.block.TallMyceliumGrass;
import static net.minecraft.world.level.block.Blocks.*;
import static net.minecraft.world.level.block.Blocks.WARPED_STAIRS;


public class RegisterBlocks {

	public static final BlockSetType AZALEA_SET = BlockSetTypeBuilder.copyOf(BlockSetType.CHERRY).register(VerseSharedConstants.id("azalea"));
	public static final WoodType AZALEA_WOOD_TYPE = WoodTypeBuilder.copyOf(WoodType.CHERRY).register(VerseSharedConstants.id("azalea"), AZALEA_SET);
	public static final BlockSetType PALM_SET = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).register(VerseSharedConstants.id("palm"));
	public static final WoodType PALM_WOOD_TYPE = WoodTypeBuilder.copyOf(WoodType.OAK).register(VerseSharedConstants.id("palm"), PALM_SET);


	private static final MapColor AZALEA_PLANKS_COLOR = MapColor.TERRACOTTA_WHITE;
	private static final MapColor AZALEA_BARK_COLOR = MapColor.TERRACOTTA_WHITE;
	private static final MapColor PALM_PLANKS_COLOR = MapColor.TERRACOTTA_YELLOW;
	private static final MapColor PALM_BARK_COLOR = MapColor.TERRACOTTA_YELLOW;

	//Log
	public static final Block AZALEA_LOG = register("azalea_log",
		RotatedPillarBlock::new,
		Blocks.logProperties(AZALEA_PLANKS_COLOR, AZALEA_BARK_COLOR, SoundType.CHERRY_WOOD)
	);

	public static final Block PALM_LOG = register("palm_log",
		RotatedPillarBlock::new,
		Blocks.logProperties(PALM_PLANKS_COLOR, PALM_BARK_COLOR, SoundType.WOOD)
	);

	//Stripped Log
	public static final Block STRIPPED_AZALEA_LOG = register("stripped_azalea_log",
		RotatedPillarBlock::new,
		Blocks.logProperties(AZALEA_PLANKS_COLOR, AZALEA_PLANKS_COLOR, SoundType.CHERRY_WOOD)
	);

	public static final Block STRIPPED_PALM_LOG = register("stripped_palm_log",
		RotatedPillarBlock::new,
		Blocks.logProperties(PALM_PLANKS_COLOR, PALM_PLANKS_COLOR, SoundType.WOOD)
	);

	//Wood
	public static final RotatedPillarBlock AZALEA_WOOD = register("azalea_wood",
		RotatedPillarBlock::new,
		Properties.ofFullCopy(Blocks.CHERRY_WOOD)
			.mapColor(AZALEA_BARK_COLOR)
	);

	public static final RotatedPillarBlock PALM_WOOD = register("palm_wood",
		RotatedPillarBlock::new,
		Properties.ofFullCopy(OAK_WOOD)
			.mapColor(PALM_BARK_COLOR)
	);

	//Stripped Wood
	public static final RotatedPillarBlock STRIPPED_AZALEA_WOOD = register("stripped_azalea_wood",
		RotatedPillarBlock::new,
		Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_WOOD)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final RotatedPillarBlock STRIPPED_PALM_WOOD = register("stripped_palm_wood",
		RotatedPillarBlock::new,
		Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	//Planks
	public static final Block AZALEA_PLANKS = register("azalea_planks",
		Block::new,
		Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final Block PALM_PLANKS = register("palm_planks",
		Block::new,
		Properties.ofFullCopy(Blocks.OAK_PLANKS)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	//Planks stairs
	public static final StairBlock AZALEA_STAIRS = register("azalea_stairs",
		properties -> new StairBlock(AZALEA_PLANKS.defaultBlockState(), properties),
		Properties.ofFullCopy(CHERRY_STAIRS)
	);

	public static final StairBlock PALM_STAIRS = register("palm_stairs",
		properties -> new StairBlock(PALM_PLANKS.defaultBlockState(), properties),
		Properties.ofFullCopy(OAK_STAIRS)
	);

	//Planks slab
	public static final Block AZALEA_SLAB = register("azalea_slab",
		SlabBlock::new,
		Properties.ofFullCopy(Blocks.CHERRY_SLAB)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final Block PALM_SLAB = register("palm_slab",
		SlabBlock::new,
		Properties.ofFullCopy(Blocks.OAK_SLAB)
			.mapColor(PALM_PLANKS_COLOR)
	);

	//Wood Fence
	public static final FenceBlock AZALEA_FENCE = register("azalea_fence",
		FenceBlock::new,
		Properties.ofFullCopy(Blocks.CHERRY_FENCE)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final FenceBlock PALM_FENCE = register("palm_fence",
		FenceBlock::new,
		Properties.ofFullCopy(Blocks.OAK_FENCE)
			.mapColor(PALM_PLANKS_COLOR)
	);

	//Wood Fence Gate
	public static final Block AZALEA_FENCE_GATE = register("azalea_fence_gate",
		properties -> new FenceGateBlock(AZALEA_WOOD_TYPE, properties),
		Properties.ofFullCopy(Blocks.CHERRY_FENCE_GATE)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final Block PALM_FENCE_GATE = register("palm_fence_gate",
		properties -> new FenceGateBlock(AZALEA_WOOD_TYPE, properties),
		Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)
			.mapColor(PALM_PLANKS_COLOR)
	);

	//Wooden Doors
	public static final DoorBlock AZALEA_DOOR = register("azalea_door",
		properties -> new DoorBlock(AZALEA_SET, properties),
		Properties.ofFullCopy(Blocks.CHERRY_DOOR).mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final DoorBlock PALM_DOOR = register("palm_door",
		properties -> new DoorBlock(PALM_SET, properties),
		Properties.ofFullCopy(Blocks.OAK_DOOR).mapColor(PALM_PLANKS_COLOR)
	);

	//Wooden Trapdoors
	public static final TrapDoorBlock AZALEA_TRAPDOOR = register("azalea_trapdoor",
		properties -> new TrapDoorBlock(AZALEA_SET, properties),
		Properties.ofFullCopy(Blocks.CHERRY_TRAPDOOR).mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final TrapDoorBlock PALM_TRAPDOOR = register("palm_trapdoor",
		properties -> new TrapDoorBlock(PALM_SET, properties),
		Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).mapColor(PALM_PLANKS_COLOR)
	);

	//Wooden PressurePlate
	public static final PressurePlateBlock AZALEA_PRESSURE_PLATE = register("azalea_pressure_plate",
		properties -> new PressurePlateBlock(AZALEA_SET, properties),
		Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final PressurePlateBlock PALM_PRESSURE_PLATE = register("palm_pressure_plate",
		properties -> new PressurePlateBlock(PALM_SET, properties),
		Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(PALM_PLANKS_COLOR)
	);

	//Wooden button
	public static final Block AZALEA_BUTTON = register("azalea_button",
		properties -> new ButtonBlock(AZALEA_SET, 30, properties),
		Blocks.buttonProperties()
	);

	public static final Block PALM_BUTTON = register("palm_button",
		properties -> new ButtonBlock(PALM_SET, 30, properties),
		Blocks.buttonProperties()
	);

	//Wooden Sign
	public static final SignBlock AZALEA_SIGN = registerWithoutItem("azalea_sign",
		properties -> new StandingSignBlock(AZALEA_WOOD_TYPE, properties),
		BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_SIGN)
			.mapColor(AZALEA_LOG.defaultMapColor())
	);

	public static final SignBlock PALM_SIGN = registerWithoutItem("palm_sign",
		properties -> new StandingSignBlock(PALM_WOOD_TYPE, properties),
		Properties.ofFullCopy(Blocks.OAK_SIGN)
			.mapColor(PALM_LOG.defaultMapColor())
	);

	public static final SignBlock AZALEA_WALL_SIGN = registerWithoutItem("azalea_wall_sign",
		properties -> new WallSignBlock(AZALEA_WOOD_TYPE, properties),
		Properties.ofFullCopy(Blocks.CHERRY_WALL_SIGN)
			.mapColor(AZALEA_LOG.defaultMapColor())
			.overrideDescription(AZALEA_SIGN.getDescriptionId())
			.overrideLootTable(AZALEA_SIGN.getLootTable())
	);

	public static final SignBlock PALM_WALL_SIGN = registerWithoutItem("palm_wall_sign",
		properties -> new WallSignBlock(PALM_WOOD_TYPE, properties),
		Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)
			.mapColor(PALM_LOG.defaultMapColor())
			.overrideDescription(PALM_SIGN.getDescriptionId())
			.overrideLootTable(PALM_SIGN.getLootTable())
	);

	//Wooden hanging sing
	public static final CeilingHangingSignBlock AZALEA_HANGING_SIGN = registerWithoutItem("azalea_hanging_sign",
		properties -> new CeilingHangingSignBlock(AZALEA_WOOD_TYPE, properties),
		Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)
			.mapColor(AZALEA_LOG.defaultMapColor())
	);

	public static final CeilingHangingSignBlock PALM_HANGING_SIGN = registerWithoutItem("palm_hanging_sign",
		properties -> new CeilingHangingSignBlock(PALM_WOOD_TYPE, properties),
		Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)
			.mapColor(PALM_LOG.defaultMapColor())
	);

	public static final WallHangingSignBlock AZALEA_WALL_HANGING_SIGN = registerWithoutItem("azalea_wall_hanging_sign",
		properties -> new WallHangingSignBlock(AZALEA_WOOD_TYPE, properties),
		Properties.ofFullCopy(Blocks.CHERRY_WALL_HANGING_SIGN)
			.mapColor(AZALEA_LOG.defaultMapColor())
			.overrideDescription(AZALEA_HANGING_SIGN.getDescriptionId())
			.overrideLootTable(AZALEA_HANGING_SIGN.getLootTable())
	);

	public static final WallHangingSignBlock PALM_WALL_HANGING_SIGN = registerWithoutItem("palm_wall_hanging_sign",
		properties -> new WallHangingSignBlock(PALM_WOOD_TYPE, properties),
		Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)
			.mapColor(PALM_LOG.defaultMapColor())
			.overrideDescription(PALM_HANGING_SIGN.getDescriptionId())
			.overrideLootTable(PALM_HANGING_SIGN.getLootTable())
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

	public static final BlockFamily PALM = BlockFamilies.familyBuilder(PALM_PLANKS)
		.button(PALM_BUTTON)
		.slab(PALM_SLAB)
		.stairs(PALM_STAIRS)
		.fence(PALM_FENCE)
		.fenceGate(PALM_FENCE_GATE)
		.pressurePlate(PALM_PRESSURE_PLATE)
		.sign(AZALEA_SIGN, AZALEA_WALL_SIGN)
		.door(PALM_DOOR)
		.trapdoor(PALM_TRAPDOOR)
		.recipeGroupPrefix("wooden")
		.recipeUnlockedBy("has_planks")
		.getFamily();

	public static final Block PALM_LEAVES = register("palm_leaves",
		properties -> new TintedParticleLeavesBlock(0.01F, properties),
		Blocks.leavesProperties(SoundType.GRASS)
	);

	//Acacia Mosaic

	public static final Block ACACIA_MOSAIC = register("acacia_mosaic",
		Block::new,
		Properties.ofFullCopy(ACACIA_PLANKS)
	);

	public static final StairBlock ACACIA_MOSAIC_STAIRS = register("acacia_mosaic_stairs",
		properties -> new StairBlock(ACACIA_PLANKS.defaultBlockState(), properties),
		Properties.ofFullCopy(ACACIA_STAIRS)
	);

	public static final SlabBlock ACACIA_MOSAIC_SLAB = register("acacia_mosaic_slab",
		SlabBlock::new,
		Properties.ofFullCopy(ACACIA_SLAB)
	);

	//Azalea Mosaic

	public static final Block AZALEA_MOSAIC = register("azalea_mosaic",
		Block::new,
		Properties.ofFullCopy(AZALEA_PLANKS)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	public static final StairBlock AZALEA_MOSAIC_STAIRS = register("azalea_mosaic_stairs",
		properties -> new StairBlock(AZALEA_PLANKS.defaultBlockState(), properties),
		Properties.ofFullCopy(AZALEA_STAIRS)
	);

	public static final SlabBlock AZALEA_MOSAIC_SLAB = register("azalea_mosaic_slab",
		SlabBlock::new,
		Properties.ofFullCopy(AZALEA_SLAB)
			.mapColor(AZALEA_PLANKS_COLOR)
	);

	//Birch Mosaic

	public static final Block BIRCH_MOSAIC = register("birch_mosaic",
		Block::new,
		Properties.ofFullCopy(BIRCH_PLANKS)
	);

	public static final StairBlock BIRCH_MOSAIC_STAIRS = register("birch_mosaic_stairs",
		properties -> new StairBlock(BIRCH_PLANKS.defaultBlockState(), properties),
		Properties.ofFullCopy(BIRCH_STAIRS)
	);

	public static final SlabBlock BIRCH_MOSAIC_SLAB = register("birch_mosaic_slab",
		SlabBlock::new,
		Properties.ofFullCopy(BIRCH_SLAB)
	);

	//Cherry Mosaic

	public static final Block CHERRY_MOSAIC = register("cherry_mosaic",
		Block::new,
		Properties.ofFullCopy(CHERRY_PLANKS)
	);

	public static final StairBlock CHERRY_MOSAIC_STAIRS = register("cherry_mosaic_stairs",
		properties -> new StairBlock(CHERRY_PLANKS.defaultBlockState(), properties),
		Properties.ofFullCopy(CHERRY_STAIRS)
	);

	public static final SlabBlock CHERRY_MOSAIC_SLAB = register("cherry_mosaic_slab",
		SlabBlock::new,
		Properties.ofFullCopy(CHERRY_SLAB)
	);

	//Crimson Mosaic

	public static final Block CRIMSON_MOSAIC = register("crimson_mosaic",
		Block::new,
		Properties.ofFullCopy(CRIMSON_PLANKS)
	);

	public static final StairBlock CRIMSON_MOSAIC_STAIRS = register("crimson_mosaic_stairs",
		properties -> new StairBlock(CRIMSON_PLANKS.defaultBlockState(), properties),
		Properties.ofFullCopy(CRIMSON_STAIRS)
	);

	public static final SlabBlock CRIMSON_MOSAIC_SLAB = register("crimson_mosaic_slab",
		SlabBlock::new,
		Properties.ofFullCopy(CRIMSON_SLAB)
	);

	//Dark Oak Mosaic

	public static final Block DARK_OAK_MOSAIC = register("dark_oak_mosaic",
		Block::new,
		Properties.ofFullCopy(DARK_OAK_PLANKS)
	);

	public static final StairBlock DARK_OAK_MOSAIC_STAIRS = register("dark_oak_mosaic_stairs",
		properties -> new StairBlock(DARK_OAK_PLANKS.defaultBlockState(), properties),
		Properties.ofFullCopy(DARK_OAK_STAIRS)
	);

	public static final SlabBlock DARK_OAK_MOSAIC_SLAB = register("dark_oak_mosaic_slab",
		SlabBlock::new,
		Properties.ofFullCopy(DARK_OAK_SLAB)
	);

	//Jungle Mosaic

	public static final Block JUNGLE_MOSAIC = register("jungle_mosaic",
		Block::new,
		Properties.ofFullCopy(JUNGLE_PLANKS)
	);

	public static final StairBlock JUNGLE_MOSAIC_STAIRS = register("jungle_mosaic_stairs",
		properties -> new StairBlock(JUNGLE_PLANKS.defaultBlockState(), properties),
		Properties.ofFullCopy(JUNGLE_STAIRS)
	);

	public static final SlabBlock JUNGLE_MOSAIC_SLAB = register("jungle_mosaic_slab",
		SlabBlock::new,
		Properties.ofFullCopy(JUNGLE_SLAB)
	);

	//Mangrove Mosaic

	public static final Block MANGROVE_MOSAIC = register("mangrove_mosaic",
		Block::new,
		Properties.ofFullCopy(MANGROVE_PLANKS)
	);

	public static final StairBlock MANGROVE_MOSAIC_STAIRS = register("mangrove_mosaic_stairs",
		properties -> new StairBlock(MANGROVE_PLANKS.defaultBlockState(), properties),
		Properties.ofFullCopy(MANGROVE_STAIRS)
	);

	public static final SlabBlock MANGROVE_MOSAIC_SLAB = register("mangrove_mosaic_slab",
		SlabBlock::new,
		Properties.ofFullCopy(MANGROVE_SLAB)
	);

	//Oak Mosaic

	public static final Block OAK_MOSAIC = register("oak_mosaic",
		Block::new,
		Properties.ofFullCopy(OAK_PLANKS)
	);

	public static final StairBlock OAK_MOSAIC_STAIRS = register("oak_mosaic_stairs",
		properties -> new StairBlock(OAK_PLANKS.defaultBlockState(), properties),
		Properties.ofFullCopy(OAK_STAIRS)
	);

	public static final SlabBlock OAK_MOSAIC_SLAB = register("oak_mosaic_slab",
		SlabBlock::new,
		Properties.ofFullCopy(OAK_SLAB)
	);

	//Spruce Mosaic

	public static final Block SPRUCE_MOSAIC = register("spruce_mosaic",
		Block::new,
		Properties.ofFullCopy(SPRUCE_PLANKS)
	);

	public static final StairBlock SPRUCE_MOSAIC_STAIRS = register("spruce_mosaic_stairs",
		properties -> new StairBlock(SPRUCE_PLANKS.defaultBlockState(), properties),
		Properties.ofFullCopy(SPRUCE_STAIRS)
	);

	public static final SlabBlock SPRUCE_MOSAIC_SLAB = register("spruce_mosaic_slab",
		SlabBlock::new,
		Properties.ofFullCopy(SPRUCE_SLAB)
	);

	//Pale Oak

	public static final Block PALE_OAK_MOSAIC = register("pale_oak_mosaic",
		Block::new,
		Properties.ofFullCopy(PALE_OAK_PLANKS)
	);

	public static final StairBlock PALE_OAK_MOSAIC_STAIRS = register("pale_oak_mosaic_stairs",
		properties -> new StairBlock(PALE_OAK_PLANKS.defaultBlockState(), properties),
		Properties.ofFullCopy(PALE_OAK_STAIRS)
	);

	public static final SlabBlock PALE_OAK_MOSAIC_SLAB = register("pale_oak_mosaic_slab",
		SlabBlock::new,
		Properties.ofFullCopy(PALE_OAK_SLAB)
	);

	//Warped

	public static final Block WARPED_MOSAIC = register("warped_mosaic",
		Block::new,
		Properties.ofFullCopy(WARPED_PLANKS)
	);

	public static final StairBlock WARPED_MOSAIC_STAIRS = register("warped_mosaic_stairs",
		properties -> new StairBlock(WARPED_PLANKS.defaultBlockState(), properties),
		Properties.ofFullCopy(WARPED_STAIRS)
	);

	public static final SlabBlock WARPED_MOSAIC_SLAB = register("warped_mosaic_slab",
		SlabBlock::new,
		Properties.ofFullCopy(WARPED_SLAB)
	);

	//Tuff

	public static final Block CRACKED_TUFF_BRICKS = register("cracked_tuff_bricks",
		Block::new,
		Properties.ofFullCopy(TUFF)
			.strength(1.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.TUFF)
	);

	//Calcite

	public static final StairBlock CALCITE_STAIRS = register("calcite_stairs",
		properties -> new StairBlock(CALCITE.defaultBlockState(), properties),
		Properties.ofFullCopy(CALCITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE));

	public static final SlabBlock CALCITE_SLAB = register("calcite_slab",
		SlabBlock::new,
		Properties.ofFullCopy(CALCITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE));


	public static final WallBlock CALCITE_WALL = register("calcite_wall",
		WallBlock::new,
		Properties.ofFullCopy(CALCITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE));


	public static final Block CHISELED_CALCITE = register("chiseled_calcite",
		Block::new,
		Properties.ofFullCopy(CALCITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE));

	//Polished Calcite

	public static final Block POLISHED_CALCITE = register("polished_calcite",
		Block::new,
		Properties.ofFullCopy(CALCITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE));

	public static final StairBlock POLISHED_CALCITE_STAIRS = register("polished_calcite_stairs",
		properties -> new StairBlock(CALCITE.defaultBlockState(), properties),
		Properties.ofFullCopy(CALCITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE));

	public static final SlabBlock POLISHED_CALCITE_SLAB = register("polished_calcite_slab",
		SlabBlock::new,
		Properties.ofFullCopy(CALCITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE));

	public static final WallBlock POLISHED_CALCITE_WALL = register("polished_calcite_wall",
		WallBlock::new,
		Properties.ofFullCopy(CALCITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE));

	//Calcite Bricks

	public static final Block CALCITE_BRICKS = register("calcite_bricks",
		Block::new,
		Properties.ofFullCopy(CALCITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE));

	public static final Block CRACKED_CALCITE_BRICKS = register("cracked_calcite_bricks",
		Block::new,
		Properties.ofFullCopy(CALCITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE));


	public static final StairBlock CALCITE_BRICKS_STAIRS = register("calcite_bricks_stairs",
		properties -> new StairBlock(CALCITE.defaultBlockState(), properties),
		Properties.ofFullCopy(CALCITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE));

	public static final SlabBlock CALCITE_BRICKS_SLAB = register("calcite_bricks_slab",
		SlabBlock::new,
		Properties.ofFullCopy(CALCITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE));

	public static final WallBlock CALCITE_BRICKS_WALL = register("calcite_bricks_wall",
		WallBlock::new,
		Properties.ofFullCopy(CALCITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE));

	public static final Block CHISELED_CALCITE_BRICKS = register("chiseled_calcite_bricks",
		Block::new,
		Properties.ofFullCopy(CALCITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.CALCITE));

	//Dripstone

	public static final StairBlock DRIPSTONE_STAIRS = register("dripstone_stairs",
		properties -> new StairBlock(DRIPSTONE_BLOCK.defaultBlockState(), properties),
		Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK));

	public static final SlabBlock DRIPSTONE_SLAB = register("dripstone_slab",
		SlabBlock::new,
		Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK));

	public static final WallBlock DRIPSTONE_WALL = register("dripstone_wall",
		WallBlock::new,
		Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK));

	public static final Block CHISELED_DRIPSTONE = register("chiseled_dripstone",
		Block::new,
		Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK));

	//Polished Dripstone

	public static final Block POLISHED_DRIPSTONE = register("polished_dripstone",
		Block::new,
		Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK));

	public static final StairBlock POLISHED_DRIPSTONE_STAIRS = register("polished_dripstone_stairs",
		properties -> new StairBlock(DRIPSTONE_BLOCK.defaultBlockState(), properties),
		Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK));

	public static final SlabBlock POLISHED_DRIPSTONE_SLAB = register("polished_dripstone_slab",
		SlabBlock::new,
		Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK));

	public static final WallBlock POLISHED_DRIPSTONE_WALL = register("polished_dripstone_wall",
		WallBlock::new,
		Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK));

	//Dripstone Bricks

	public static final Block DRIPSTONE_BRICKS = register("dripstone_bricks",
		Block::new,
		Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK));

	public static final Block CRACKED_DRIPSTONE_BRICKS = register("cracked_dripstone_bricks",
		Block::new,
		Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK));

	public static final StairBlock DRIPSTONE_BRICKS_STAIRS = register("dripstone_bricks_stairs",
		properties -> new StairBlock(DRIPSTONE_BLOCK.defaultBlockState(), properties),
		Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK));

	public static final SlabBlock DRIPSTONE_BRICKS_SLAB = register("dripstone_bricks_slab",
		SlabBlock::new,
		Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK));

	public static final WallBlock DRIPSTONE_BRICKS_WALL = register("dripstone_bricks_wall",
		WallBlock::new,
		Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK));

	public static final Block CHISELED_DRIPSTONE_BRICKS = register("chiseled_dripstone_bricks",
		Block::new,
		Properties.ofFullCopy(DRIPSTONE_BLOCK)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.DRIPSTONE_BLOCK));

	//Diorite

	public static final Block CHISELED_DIORITE = register("chiseled_diorite",
		Block::new,
		Properties.ofFullCopy(DIORITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final WallBlock POLISHED_DIORITE_WALL = register("polished_diorite_wall",
		WallBlock::new,
		Properties.ofFullCopy(DIORITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final Block DIORITE_BRICKS = register("diorite_bricks",
		Block::new,
		Properties.ofFullCopy(DIORITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final Block CRACKED_DIORITE_BRICKS = register("cracked_diorite_bricks",
		Block::new,
		Properties.ofFullCopy(DIORITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final StairBlock DIORITE_BRICKS_STAIRS = register("diorite_bricks_stairs",
		properties -> new StairBlock(DIORITE.defaultBlockState(), properties),
		Properties.ofFullCopy(DIORITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final SlabBlock DIORITE_BRICKS_SLAB = register("diorite_bricks_slab",
		SlabBlock::new,
		Properties.ofFullCopy(DIORITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final WallBlock DIORITE_BRICKS_WALL = register("diorite_bricks_wall",
		WallBlock::new,
		Properties.ofFullCopy(DIORITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final Block CHISELED_DIORITE_BRICKS = register("chiseled_diorite_bricks",
		Block::new,
		Properties.ofFullCopy(DIORITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	//Andesite

	public static final Block CHISELED_ANDESITE = register("chiseled_andesite",
		Block::new,
		Properties.ofFullCopy(ANDESITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final WallBlock POLISHED_ANDESITE_WALL = register("polished_andesite_wall",
		WallBlock::new,
		Properties.ofFullCopy(ANDESITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final Block ANDESITE_BRICKS = register("andesite_bricks",
		Block::new,
		Properties.ofFullCopy(ANDESITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final Block CRACKED_ANDESITE_BRICKS = register("cracked_andesite_bricks",
		Block::new,
		Properties.ofFullCopy(ANDESITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final StairBlock ANDESITE_BRICKS_STAIRS = register("andesite_bricks_stairs",
		properties -> new StairBlock(ANDESITE.defaultBlockState(), properties),
		Properties.ofFullCopy(ANDESITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final SlabBlock ANDESITE_BRICKS_SLAB = register("andesite_bricks_slab",
		SlabBlock::new,
		Properties.ofFullCopy(ANDESITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final WallBlock ANDESITE_BRICKS_WALL = register("andesite_bricks_wall",
		WallBlock::new,
		Properties.ofFullCopy(ANDESITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final Block CHISELED_ANDESITE_BRICKS = register("chiseled_andesite_bricks",
		Block::new,
		Properties.ofFullCopy(ANDESITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	//Granite

	public static final Block CHISELED_GRANITE = register("chiseled_granite",
		Block::new,
		Properties.ofFullCopy(GRANITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final WallBlock POLISHED_GRANITE_WALL = register("polished_granite_wall",
		WallBlock::new,
		Properties.ofFullCopy(GRANITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final Block GRANITE_BRICKS = register("granite_bricks",
		Block::new,
		Properties.ofFullCopy(GRANITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final Block CRACKED_GRANITE_BRICKS = register("cracked_granite_bricks",
		Block::new,
		Properties.ofFullCopy(GRANITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final StairBlock GRANITE_BRICKS_STAIRS = register("granite_bricks_stairs",
		properties -> new StairBlock(GRANITE.defaultBlockState(), properties),
		Properties.ofFullCopy(GRANITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final SlabBlock GRANITE_BRICKS_SLAB = register("granite_bricks_slab",
		SlabBlock::new,
		Properties.ofFullCopy(GRANITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final WallBlock GRANITE_BRICKS_WALL = register("granite_bricks_wall",
		WallBlock::new,
		Properties.ofFullCopy(GRANITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	public static final Block CHISELED_GRANITE_BRICKS = register("chiseled_granite_bricks",
		Block::new,
		Properties.ofFullCopy(GRANITE)
			.strength(1.5f)
			.requiresCorrectToolForDrops()
			.sound(SoundType.STONE));

	//Plants

	public static final Block BLUE_ROSE = register("blue_rose",
		properties -> new FlowerBlock(MobEffects.SATURATION, 0.0F, properties),
		Properties.of()
			.mapColor(MapColor.PLANT)
			.noCollission()
			.instabreak()
			.sound(SoundType.GRASS)
			.offsetType(BlockBehaviour.OffsetType.XZ)
			.pushReaction(PushReaction.DESTROY)
	);

	public static final Block BLUE_ROSE_CROP = register("blue_rose_crop",
		BlueRoseCropBlock::new,
		Properties.of()
			.mapColor(MapColor.PLANT)
			.noCollission()
			.randomTicks()
			.instabreak()
			.sound(SoundType.CROP)
			.pushReaction(PushReaction.DESTROY)
	);

	public static final Block POTTED_BLUE_ROSE = register("potted_blue_rose",
		properties -> new FlowerPotBlock(BLUE_ROSE, properties),
		Blocks.flowerPotProperties()
	);

	public static final Block ICEFLOWER = register("iceflower",
		properties -> new FlowerBlock(MobEffects.SATURATION, 0.0F, properties),
		Properties.of()
			.mapColor(MapColor.PLANT)
			.noCollission()
			.instabreak()
			.sound(SoundType.GRASS)
			.offsetType(BlockBehaviour.OffsetType.XZ)
			.pushReaction(PushReaction.DESTROY)
	);

	public static final Block ICEFLOWER_CROP = register("iceflower_crop",
		IceflowerCropBlock::new,
		Properties.of()
			.mapColor(MapColor.PLANT)
			.noCollission()
			.randomTicks()
			.instabreak()
			.sound(SoundType.CROP)
			.pushReaction(PushReaction.DESTROY)
	);

	public static final Block POTTED_ICEFLOWER = register("potted_iceflower",
		properties -> new FlowerPotBlock(ICEFLOWER, properties),
		Blocks.flowerPotProperties()
	);

	public static final ShortMyceliumGrass SHORT_MYCELIUM_GRASS = register("short_mycelium_grass",
		ShortMyceliumGrass::new,
		Properties.ofFullCopy(SHORT_DRY_GRASS)
			.mapColor(MapColor.PLANT)
			.replaceable()
			.noOcclusion()
			.instabreak()
			.sound(SoundType.GRASS)
			.offsetType(BlockBehaviour.OffsetType.XZ)
			.ignitedByLava()
			.pushReaction(PushReaction.DESTROY)
	);

	public static final TallMyceliumGrass TALL_MYCELIUM_GRASS = register("tall_mycelium_grass",
		TallMyceliumGrass::new,
		Properties.ofFullCopy(TALL_DRY_GRASS)
			.mapColor(MapColor.PLANT)
			.replaceable()
			.noOcclusion()
			.instabreak()
			.sound(SoundType.GRASS)
			.offsetType(BlockBehaviour.OffsetType.XZ)
			.ignitedByLava()
			.pushReaction(PushReaction.DESTROY)
	);

	public static final Block POP_FLOWER = register("pop_flower",
		properties -> new FlowerBlock(MobEffects.SATURATION, 0.0F, properties),
		Properties.of()
			.mapColor(MapColor.PLANT)
			.noCollission()
			.instabreak()
			.sound(SoundType.GRASS)
			.offsetType(BlockBehaviour.OffsetType.XZ)
			.pushReaction(PushReaction.DESTROY)
	);

	public static final Block POTTED_POP_FLOWER = register("potted_pop_flower",
		properties -> new FlowerPotBlock(POP_FLOWER, properties),
		Blocks.flowerPotProperties()
	);

	public static final FireflyBushBlock GLOWSHROOM = register("glowshroom",
		FireflyBushBlock::new,
		Properties.ofFullCopy(FIREFLY_BUSH)
			.mapColor(MapColor.COLOR_YELLOW)
			.sound(SoundType.FUNGUS)
			.offsetType(BlockBehaviour.OffsetType.XZ)
			.lightLevel(state -> 6)
	);

	public static void registerBlocks() {

	}

	private static void registerFlammability() {

		var flammableBlockRegistry = FlammableBlockRegistry.getDefaultInstance();

		flammableBlockRegistry.add(RegisterBlocks.ACACIA_MOSAIC, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.ACACIA_MOSAIC_STAIRS, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.ACACIA_MOSAIC_SLAB, 5, 20);

		flammableBlockRegistry.add(RegisterBlocks.AZALEA_MOSAIC, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.AZALEA_MOSAIC_STAIRS, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.AZALEA_MOSAIC_SLAB, 5, 20);

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

		flammableBlockRegistry.add(RegisterBlocks.PALE_OAK_MOSAIC, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.PALE_OAK_MOSAIC_STAIRS, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.PALE_OAK_MOSAIC_SLAB, 5, 20);

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

		flammableBlockRegistry.add(RegisterBlocks.PALM_LOG, 5, 5);
		flammableBlockRegistry.add(RegisterBlocks.STRIPPED_PALM_LOG, 5, 5);
		flammableBlockRegistry.add(RegisterBlocks.PALM_WOOD, 5, 5);
		flammableBlockRegistry.add(RegisterBlocks.STRIPPED_PALM_WOOD, 5, 5);
		flammableBlockRegistry.add(RegisterBlocks.PALM_PLANKS, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.PALM_STAIRS, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.PALM_FENCE, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.PALM_SLAB, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.PALM_FENCE_GATE, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.PALM_PRESSURE_PLATE, 5, 20);
		flammableBlockRegistry.add(RegisterBlocks.PALM_BUTTON, 5, 20);

		flammableBlockRegistry.add(RegisterBlocks.ICEFLOWER, 100, 60);
		flammableBlockRegistry.add(RegisterBlocks.BLUE_ROSE, 100, 60);

		flammableBlockRegistry.add(RegisterBlocks.TALL_MYCELIUM_GRASS, 100, 60);
		flammableBlockRegistry.add(RegisterBlocks.SHORT_MYCELIUM_GRASS, 100, 60);
		flammableBlockRegistry.add(RegisterBlocks.POP_FLOWER, 100, 60);
	}

	private static void registerStrippable() {
		StrippableBlockRegistry.register(AZALEA_LOG, STRIPPED_AZALEA_LOG);
		StrippableBlockRegistry.register(AZALEA_WOOD, STRIPPED_AZALEA_WOOD);

		StrippableBlockRegistry.register(PALM_LOG, STRIPPED_PALM_LOG);
		StrippableBlockRegistry.register(PALM_WOOD, STRIPPED_PALM_WOOD);
	}

	private static void registerFuels() {

		FuelRegistryEvents.BUILD.register((builder, context) -> {
			builder.add(RegisterItems.AZALEA_BOAT, 1200);
			builder.add(RegisterItems.AZALEA_CHEST_BOAT, 1200);
			builder.add(AZALEA_LOG.asItem(), 300);
			builder.add(STRIPPED_AZALEA_LOG.asItem(), 300);
			builder.add(AZALEA_WOOD.asItem(), 300);
			builder.add(STRIPPED_AZALEA_WOOD.asItem(), 300);
			builder.add(AZALEA_PLANKS.asItem(), 300);
			builder.add(AZALEA_SLAB.asItem(), 150);
			builder.add(AZALEA_STAIRS.asItem(), 300);
			builder.add(AZALEA_PRESSURE_PLATE.asItem(), 300);
			builder.add(AZALEA_BUTTON.asItem(), 100);
			builder.add(AZALEA_TRAPDOOR.asItem(), 300);
			builder.add(AZALEA_FENCE_GATE.asItem(), 300);
			builder.add(AZALEA_FENCE.asItem(), 300);
			builder.add(RegisterItems.AZALEA_SIGN, 300);
			builder.add(RegisterItems.AZALEA_HANGING_SIGN, 800);

			builder.add(AZALEA_MOSAIC.asItem(), 300);
			builder.add(AZALEA_MOSAIC_SLAB.asItem(), 150);
			builder.add(AZALEA_MOSAIC_STAIRS.asItem(), 300);

			builder.add(ACACIA_MOSAIC.asItem(), 300);
			builder.add(ACACIA_MOSAIC_SLAB.asItem(), 150);
			builder.add(ACACIA_MOSAIC_STAIRS.asItem(), 300);

			builder.add(BIRCH_MOSAIC.asItem(), 300);
			builder.add(BIRCH_MOSAIC_SLAB.asItem(), 150);
			builder.add(BIRCH_MOSAIC_STAIRS.asItem(), 300);

			builder.add(CHERRY_MOSAIC.asItem(), 300);
			builder.add(CHERRY_MOSAIC_SLAB.asItem(), 150);
			builder.add(CHERRY_MOSAIC_STAIRS.asItem(), 300);

			builder.add(DARK_OAK_MOSAIC.asItem(), 300);
			builder.add(DARK_OAK_MOSAIC_SLAB.asItem(), 150);
			builder.add(DARK_OAK_MOSAIC_STAIRS.asItem(), 300);

			builder.add(JUNGLE_MOSAIC.asItem(), 300);
			builder.add(JUNGLE_MOSAIC_SLAB.asItem(), 150);
			builder.add(JUNGLE_MOSAIC_STAIRS.asItem(), 300);

			builder.add(MANGROVE_MOSAIC.asItem(), 300);
			builder.add(MANGROVE_MOSAIC_SLAB.asItem(), 150);
			builder.add(MANGROVE_MOSAIC_STAIRS.asItem(), 300);

			builder.add(OAK_MOSAIC.asItem(), 300);
			builder.add(OAK_MOSAIC_SLAB.asItem(), 150);
			builder.add(OAK_MOSAIC_STAIRS.asItem(), 300);

			builder.add(SPRUCE_MOSAIC.asItem(), 300);
			builder.add(SPRUCE_MOSAIC_SLAB.asItem(), 150);
			builder.add(SPRUCE_MOSAIC_STAIRS.asItem(), 300);

			builder.add(PALE_OAK_MOSAIC.asItem(), 300);
			builder.add(PALE_OAK_MOSAIC_SLAB.asItem(), 150);
			builder.add(PALE_OAK_MOSAIC_STAIRS.asItem(), 300);

			builder.add(BLUE_ROSE.asItem(), 150);
			builder.add(ICEFLOWER.asItem(), 150);

		});
	}



	public static void registerBlockProperties() {

		registerFuels();
		registerStrippable();
		registerFlammability();

		var sign = (FabricBlockEntityType) BlockEntityType.SIGN;
		var hangingSign = (FabricBlockEntityType) BlockEntityType.HANGING_SIGN;

		sign.addSupportedBlock(AZALEA_SIGN);
		sign.addSupportedBlock(AZALEA_WALL_SIGN);

		sign.addSupportedBlock(PALM_SIGN);
		sign.addSupportedBlock(PALM_WALL_SIGN);


		hangingSign.addSupportedBlock(AZALEA_HANGING_SIGN);
		hangingSign.addSupportedBlock(AZALEA_WALL_HANGING_SIGN);

		hangingSign.addSupportedBlock(PALM_HANGING_SIGN);
		hangingSign.addSupportedBlock(PALM_WALL_HANGING_SIGN);
	}

	private RegisterBlocks() {
		throw new UnsupportedOperationException("WWBlocks contains only static declarations.");
	}

	private static <T extends Block> T registerWithoutItem(String path, Function<Properties, T> block, Properties properties) {
		ResourceLocation id = VerseSharedConstants.id(path);
		return doRegister(id, makeBlock(block, properties, id));
	}

	private static <T extends Block> T register(String path, Function<Properties, T> block, Properties properties) {
		T registered = registerWithoutItem(path, block, properties);
		Items.registerBlock(registered);
		return registered;
	}

	private static <T extends Block> T doRegister(ResourceLocation id, T block) {
		if (BuiltInRegistries.BLOCK.getOptional(id).isEmpty()) {
			return Registry.register(BuiltInRegistries.BLOCK, id, block);
		}
		throw new IllegalArgumentException("Block with id " + id + " is already in the block registry.");
	}

	private static <T extends Block> T makeBlock(Function<Properties, T> function, Properties properties, ResourceLocation id) {
		return function.apply(properties.setId(ResourceKey.create(Registries.BLOCK, id)));
	}
}
