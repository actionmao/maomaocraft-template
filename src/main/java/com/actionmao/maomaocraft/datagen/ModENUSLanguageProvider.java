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
        translationBuilder.add(ModItems.RAW_CAT_CORE, "Cat Mao Core");
        translationBuilder.add(ModItems.CATNIP_COOKIE_FOOD, "Catnip Cookie Food");

        translationBuilder.add(ModBlocks.CAT_CORE_BLOCK, "Cat Core Block");
        translationBuilder.add(ModBlocks.RAW_CAT_CORE_BLOCK, "Raw Cat Core Block");
        translationBuilder.add(ModBlocks.CAT_CORE_ORE, "Cat Core Ore");
        translationBuilder.add(ModItemGroups.CAT_GROUP, "Cat Group");
    }
}
