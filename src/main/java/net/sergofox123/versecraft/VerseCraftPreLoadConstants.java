package net.sergofox123.versecraft;

import java.nio.file.Path;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class VerseCraftPreLoadConstants {
	public static final String MOD_ID = "versecraft";

	@Contract(pure = true)
	public static @NotNull Path configPath(String name, boolean json5) {
		return Path.of("./config/" + MOD_ID + "/" + name + "." + (json5 ? "json5" : "json"));
	}
}
