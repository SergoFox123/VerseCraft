package net.sergofox123.vercecraft;

import java.util.ArrayList;
import net.fabricmc.loader.api.ModContainer;
import net.frozenblock.lib.entrypoint.api.FrozenModInitializer;
import net.frozenblock.lib.mobcategory.api.entrypoint.FrozenMobCategoryEntrypoint;
import net.frozenblock.lib.mobcategory.impl.FrozenMobCategory;
import net.sergofox123.vercecraft.misc.VerseSharedConstants;
import net.sergofox123.vercecraft.registry.RegisterBlocks;
import org.jetbrains.annotations.NotNull;

public final class VerseCraft extends FrozenModInitializer implements FrozenMobCategoryEntrypoint {

	public VerseCraft() {
		super(VerseSharedConstants.MOD_ID);
	}

	@Override
	public void onInitialize(String modId, ModContainer container) {
		VerseSharedConstants.startMeasuring(this);

		RegisterBlocks.registerBlocks();

		RegisterBlocks.registerBlockProperties();

		VerseSharedConstants.stopMeasuring(this);
	}

	@Override
	public void newCategories(@NotNull ArrayList<FrozenMobCategory> context) {


	}
}
