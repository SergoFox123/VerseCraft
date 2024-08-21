package net.sergofox123.versecraft.registry;

import com.google.common.collect.ImmutableList;
import java.util.Map;
import net.frozenblock.lib.worldgen.structure.api.AppendSherds;
import net.frozenblock.lib.worldgen.structure.api.BlockStateRespectingProcessorRule;
import net.frozenblock.lib.worldgen.structure.api.BlockStateRespectingRuleProcessor;
import net.sergofox123.versecraft.VerseSharedConstants;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.AlwaysTrueTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.PosAlwaysTrueTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.ProcessorRule;
import net.minecraft.world.level.levelgen.structure.templatesystem.RandomBlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraft.world.level.levelgen.structure.templatesystem.rule.blockentity.AppendLoot;
import net.minecraft.world.level.storage.loot.LootTable;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;


public final class RegisterStructures {

	private RegisterStructures() {
		throw new UnsupportedOperationException("RegisterStructures contains only static declarations.");
	}

	@NotNull
	public static ResourceKey<StructureSet> ofSet(@NotNull String id) {
		return ResourceKey.create(Registries.STRUCTURE_SET, VerseSharedConstants.id(id));
	}

	public static void bootstrapTemplatePool(@NotNull BootstrapContext<StructureTemplatePool> context) {

	}

	public static void bootstrap(@NotNull BootstrapContext<Structure> context) {


	}

	public static void bootstrapStructureSet(@NotNull BootstrapContext<StructureSet> context) {


	}

	public static void bootstrapProcessor(@NotNull BootstrapContext<StructureProcessorList> context) {


	}

	@Contract("_, _, _, _ -> new")
	public static @NotNull RuleProcessor archyLootProcessor(Block original, @NotNull Block suspicious, ResourceKey<LootTable> registryKey, float chance) {
		return new RuleProcessor(
			ImmutableList.of(
				archyProcessorRule(original, suspicious, registryKey, chance)
			)
		);
	}

	@Contract("_, _, _, _ -> new")
	public static @NotNull ProcessorRule archyProcessorRule(Block original, @NotNull Block suspicious, ResourceKey<LootTable> registryKey, float chance) {
		return new ProcessorRule(
			new RandomBlockMatchTest(original, chance),
			AlwaysTrueTest.INSTANCE,
			PosAlwaysTrueTest.INSTANCE,
			suspicious.defaultBlockState(),
			new AppendLoot(registryKey)
		);
	}

	@Contract("_, _ -> new")
	public static @NotNull BlockStateRespectingRuleProcessor decoratedPotSherdProcessor(float chance, Item... sherds) {
		return new BlockStateRespectingRuleProcessor(
			ImmutableList.of(
				new BlockStateRespectingProcessorRule(
					new RandomBlockMatchTest(Blocks.DECORATED_POT, chance),
					AlwaysTrueTest.INSTANCE,
					PosAlwaysTrueTest.INSTANCE,
					Blocks.DECORATED_POT,
					new AppendSherds(chance, false, sherds)
				)
			)
		);
	}

	@NotNull
	public static ResourceKey<Structure> createKey(@NotNull String id) {
		return ResourceKey.create(Registries.STRUCTURE, VerseSharedConstants.id(id));
	}

	@NotNull
	public static Structure.StructureSettings structure(
		@NotNull HolderSet<Biome> holderSet,
		@NotNull Map<MobCategory, StructureSpawnOverride> spawns,
		@NotNull GenerationStep.Decoration featureStep,
		@NotNull TerrainAdjustment terrainAdaptation
	) {
		return new Structure.StructureSettings(holderSet, spawns, featureStep, terrainAdaptation);
	}

	@NotNull
	public static Structure.StructureSettings structure(
		@NotNull HolderSet<Biome> holderSet,
		@NotNull GenerationStep.Decoration featureStep,
		@NotNull TerrainAdjustment terrainAdaptation
	) {
		return structure(holderSet, Map.of(), featureStep, terrainAdaptation);
	}

	public static void register(@NotNull BootstrapContext<StructureTemplatePool> pool, String location, StructureTemplatePool templatePool) {
		pool.register(Pools.parseKey(location), templatePool);
	}

}
