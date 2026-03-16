package net.sergofox123.versecraft.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.RenderStateDataKey;

@Environment(EnvType.CLIENT)
public class RenderStateDataKeys {

	public static final RenderStateDataKey<Boolean> DECORATED_POT_WOBBLE_FLIPPED = RenderStateDataKey.create();

	public static void init() {
	}
}
