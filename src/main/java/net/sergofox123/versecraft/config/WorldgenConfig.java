package net.sergofox123.versecraft.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.CollapsibleObject;
import net.frozenblock.lib.config.api.instance.Config;
import net.frozenblock.lib.config.api.instance.json.JsonConfig;
import net.frozenblock.lib.config.api.instance.json.JsonType;
import net.frozenblock.lib.config.api.registry.ConfigRegistry;
import net.frozenblock.lib.config.api.sync.annotation.EntrySyncData;
import net.sergofox123.versecraft.VerseSharedConstants;

public final class WorldgenConfig {

	public static final Config<WorldgenConfig> INSTANCE = ConfigRegistry.register(
		new JsonConfig<>(
			VerseSharedConstants.MOD_ID,
			WorldgenConfig.class,
			VerseSharedConstants.configPath("worldgen", true),
			JsonType.JSON5,
			null,
			null
		) {
			@Override
			public void onSave() throws Exception {
				super.onSave();
				this.onSync(null);
			}

			@Override
			public void onSync(WorldgenConfig syncInstance) {
				var config = this.config();
				GENERATE_GENERIC_RUINS = config.cryptic_crypt.plains;
			}
		}
	);

	public static volatile boolean GENERATE_GENERIC_RUINS = true;;

	@CollapsibleObject
	public final CrypticCrypt cryptic_crypt = new CrypticCrypt();

	public static class CrypticCrypt {
		@EntrySyncData("plains")
		public boolean plains = true;
	}

	public static class Vegetation {

	}

	public static WorldgenConfig get() {
		return get(false);
	}

	public static WorldgenConfig get(boolean real) {
		if (real)
			return INSTANCE.instance();
		return INSTANCE.config();
	}

	public static WorldgenConfig getWithSync() {
		return INSTANCE.configWithSync();
	}
}
