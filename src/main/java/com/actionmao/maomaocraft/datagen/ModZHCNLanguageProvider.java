package com.actionmao.maomaocraft.datagen;

import com.actionmao.maomaocraft.block.ModBlocks;
import com.actionmao.maomaocraft.item.ModItemGroups;
import com.actionmao.maomaocraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModZHCNLanguageProvider extends FabricLanguageProvider {
    protected ModZHCNLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput,"zh_cn", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.CAT_CORE, "猫猫核心");
        translationBuilder.add(ModItems.RAW_CAT_CORE, "猫猫核心粗矿");
        translationBuilder.add(ModItems.CATNIP_COOKIE_FOOD, "猫薄荷饼");

        translationBuilder.add(ModBlocks.CAT_CORE_BLOCK, "猫猫核心块");
        translationBuilder.add(ModBlocks.RAW_CAT_CORE_BLOCK, "猫猫核心粗矿块");
        translationBuilder.add(ModBlocks.CAT_CORE_ORE, "猫猫核心矿石");
        translationBuilder.add(ModItemGroups.CAT_GROUP, "MaoMao");
    }
}
