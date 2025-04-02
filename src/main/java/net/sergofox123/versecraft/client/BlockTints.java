package net.sergofox123.versecraft.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.frozenblock.lib.block.client.api.TintRegistryHelper;
import net.sergofox123.versecraft.registry.RegisterBlocks;

@Environment(EnvType.CLIENT)
public final class BlockTints {

	public static void applyTints() {

		TintRegistryHelper.registerAverageFoliageColorForBlock(RegisterBlocks.PALM_LEAVES);
	}
}
