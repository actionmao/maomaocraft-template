package com.actionmao.maomaocraft.datagen;

import com.actionmao.maomaocraft.block.ModBlocks;
import com.actionmao.maomaocraft.item.ModItemGroups;
import com.actionmao.maomaocraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
//数据生成 -> 简化语言文件的生成
//Translate -> English(US)
public class ModENUSLanguageProvider extends FabricLanguageProvider {
    //构造方法
    public ModENUSLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    //成员方法
    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.CAT_CORE, "Cat Core");
        translationBuilder.add(ModItems.RAW_CAT_CORE, "Raw Cat Core");
        translationBuilder.add(ModItems.CATNIP, "Catnip");
        translationBuilder.add(ModItems.CATNIP_COOKIE_FOOD, "Catnip Cookie Food");
        translationBuilder.add(ModItems.CATNIP_COOKIE_FOOD_WITH_FEATHER, "Catnip Cookie Food With Feather");
        translationBuilder.add(ModItems.CATNIP_COOKIE_FOOD_WITH_WOODEN_PICKAXE, "Catnip Cookie Food With Wooden Pickaxe");
        translationBuilder.add(ModItems.CATNIP_COOKIE_FOOD_WITH_WOODEN_SWORD, "Catnip Cookie Food With Wooden Sword");
        translationBuilder.add(ModItems.CATNIP_COOKIE_FOOD_WITH_WOODEN_SHOVEL, "Catnip Cookie Food With Wooden Shovel");
        translationBuilder.add(ModItems.CATNIP_COOKIE_FOOD_WITH_WIND_CHARGE, "Catnip Cookie Food With Wind Charge");
        translationBuilder.add(ModItems.CATNIP_COOKIE_FOOD_WITH_LAVA_BUCKET, "Catnip Cookie Food With Lava Bucket");
        translationBuilder.add(ModItems.CATNIP_COOKIE_FOOD_WITH_TNT, "Catnip Cookie Food With TNT");

        translationBuilder.add(ModBlocks.CAT_CORE_BLOCK, "Cat Core Block");
        translationBuilder.add(ModBlocks.RAW_CAT_CORE_BLOCK, "Raw Cat Core Block");
        translationBuilder.add(ModBlocks.CAT_CORE_ORE, "Cat Core Ore");
        translationBuilder.add(ModItemGroups.CAT_GROUP, "Cat Group");
        translationBuilder.add(ModItemGroups.CAT_GROUP_FOR_FOOD, "Cat Group For Food");
    }
}
