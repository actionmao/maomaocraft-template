package com.actionmao.maomaocraft.block;

import com.actionmao.maomaocraft.MaoMaoCraft;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    //具体方块注册
    public static final Block MAO_CORE_BLOCK = register("mao_core_block", new Block(AbstractBlock.Settings.create().requiresTool().strength(3.0F, 4.0F)));
    public static final Block RAW_MAO_CORE_BLOCK = register("raw_mao_core_block", new Block(AbstractBlock.Settings.create().requiresTool().strength(3.0F, 3.0F)));
    public static final Block MAO_CORE_ORE = register("mao_core_ore", new Block(AbstractBlock.Settings.create().requiresTool().strength(4.5F, 6.0F)));


    //注册方块方法(BlockItem)
    public static void registerBlockItems(String id, Block block) {
        Item item = Registry.register(Registries.ITEM, Identifier.of(MaoMaoCraft.MOD_ID, id), new BlockItem(block, new Item.Settings()));
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
    }

    //注册方块方法(Block)
    //要想注册一个新的方块物品,请使用该方法
    public static Block register(String id, Block block) {
        registerBlockItems(id, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MaoMaoCraft.MOD_ID, id), block);
    }


    //静态初始化
    //目的:加载所有static关键字
    public static void registerModBlocks() {
        MaoMaoCraft.LOGGER.info("Registering Mod Blocks");

    }

}
