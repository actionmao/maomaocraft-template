package com.actionmao.maomaocraft.datagen;

import com.actionmao.maomaocraft.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

//数据生成 -> 简化tags
public class ModBlockTagsProvider extends FabricTagProvider.BlockTagProvider {
    //构造方法
    public ModBlockTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.MAO_CORE_BLOCK)
                .add(ModBlocks.MAO_CORE_ORE)
                .add(ModBlocks.RAW_MAO_CORE_BLOCK);
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.RAW_MAO_CORE_BLOCK);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.MAO_CORE_ORE);
    }
}
