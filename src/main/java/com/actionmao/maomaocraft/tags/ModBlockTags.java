package com.actionmao.maomaocraft.tags;

import com.actionmao.maomaocraft.MaoMaoCraft;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {

    public static final TagKey<Block> ORE_LIST = of("ore_list");

    private ModBlockTags() {}

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MaoMaoCraft.MOD_ID, id));
    }

    public static void registerModBlockTags() {
        MaoMaoCraft.LOGGER.info("Registering Block Tags");
    }
}
