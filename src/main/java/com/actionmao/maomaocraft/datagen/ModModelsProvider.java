package com.actionmao.maomaocraft.datagen;

import com.actionmao.maomaocraft.block.ModBlocks;
import com.actionmao.maomaocraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CAT_CORE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_CAT_CORE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CAT_CORE_ORE);

    }
    //针对于item
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CAT_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_CAT_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CATNIP, Models.GENERATED);
        itemModelGenerator.register(ModItems.CATNIP_COOKIE_FOOD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CATNIP_COOKIE_FOOD_WITH_FEATHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CATNIP_COOKIE_FOOD_WITH_WOODEN_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CATNIP_COOKIE_FOOD_WITH_WOODEN_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CATNIP_COOKIE_FOOD_WITH_WOODEN_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CATNIP_COOKIE_FOOD_WITH_WIND_CHARGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CATNIP_COOKIE_FOOD_WITH_LAVA_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CATNIP_COOKIE_FOOD_WITH_TNT, Models.GENERATED);
    }
}
