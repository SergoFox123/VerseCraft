package net.sergofoox.versecraft.misc;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.sergofoox.versecraft.VerseSharedConstants;

public class ItemImp {

	public static final ResourceKey<Item> DRAGON_POTTERY_SHERD = create("dragon_pottery_sherd");
	public static final ResourceKey<Item> EGG_POTTERY_SHERD = create("egg_pottery_sherd");
	public static final ResourceKey<Item> EYE_POTTERY_SHERD = create("eye_pottery_sherd");
	public static final ResourceKey<Item> PILLAGER_POTTERY_SHERD = create("pillager_pottery_sherd");
	public static final ResourceKey<Item> PORTAL_POTTERY_SHERD = create("portal_pottery_sherd");
	public static final ResourceKey<Item> SWORD_POTTERY_SHERD = create("sword_pottery_sherd");

	private static ResourceKey<Item> create(String name) {
		return ResourceKey.create(Registries.ITEM, VerseSharedConstants.id(name));
	}
}
