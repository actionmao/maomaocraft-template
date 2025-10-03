package com.actionmao.maomaocraft.tags;

import com.actionmao.maomaocraft.MaoMaoCraft;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public ModItemTags() {}

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(MaoMaoCraft.MOD_ID, id));
    }

    public static void registerModItemTags() {
        MaoMaoCraft.LOGGER.info("Registering Item Tags");
    }
}
