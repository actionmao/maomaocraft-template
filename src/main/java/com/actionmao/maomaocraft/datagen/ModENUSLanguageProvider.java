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
        translationBuilder.add(ModItems.MAO_CORE, "Mao Core");
        translationBuilder.add(ModItems.RAW_MAO_CORE, "Raw Mao Core");
        translationBuilder.add(ModBlocks.MAO_CORE_BLOCK, "Mao Core Block");
        translationBuilder.add(ModBlocks.RAW_MAO_CORE_BLOCK, "Raw Mao Core Block");
        translationBuilder.add(ModBlocks.MAO_CORE_ORE, "Mao Core Ore");
        translationBuilder.add(ModItemGroups.MAO_GROUP, "Mao Group");
    }
}
