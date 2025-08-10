package com.actionmao.maomaocraft.datagen;

import com.actionmao.maomaocraft.block.ModBlocks;
import com.actionmao.maomaocraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.MaceItem;

public class ModModelsProvider extends FabricModelProvider {
    //构造方法
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }


    //成员方法
    //针对于block
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //小特性
        //同时对resources/blockstates和resources/models生效
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAO_CORE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_MAO_CORE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAO_CORE_ORE);

    }
    //针对于item
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MAO_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_MAO_CORE, Models.GENERATED);

    }
}
