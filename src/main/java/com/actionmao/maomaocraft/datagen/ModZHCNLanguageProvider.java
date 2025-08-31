package com.actionmao.maomaocraft.datagen;

import com.actionmao.maomaocraft.block.ModBlocks;
import com.actionmao.maomaocraft.item.ModItemGroups;
import com.actionmao.maomaocraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModZHCNLanguageProvider extends FabricLanguageProvider {
    public ModZHCNLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput,"zh_cn", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.CAT_CORE, "猫猫核心");
        translationBuilder.add(ModItems.RAW_CAT_CORE, "猫猫核心粗矿");
        translationBuilder.add(ModItems.CATNIP, "猫薄荷");
        translationBuilder.add(ModItems.CATNIP_COOKIE_FOOD, "猫薄荷饼干");
        translationBuilder.add(ModItems.CATNIP_COOKIE_FOOD_WITH_FEATHER, "羽毛味猫薄荷饼干");
        translationBuilder.add(ModItems.CATNIP_COOKIE_FOOD_WITH_WOODEN_PICKAXE, "木镐味猫薄荷饼干");
        translationBuilder.add(ModItems.CATNIP_COOKIE_FOOD_WITH_WOODEN_SWORD, "木剑味猫薄荷饼干");
        translationBuilder.add(ModItems.CATNIP_COOKIE_FOOD_WITH_WOODEN_SHOVEL, "木锹味猫薄荷饼干");
        translationBuilder.add(ModItems.CATNIP_COOKIE_FOOD_WITH_WIND_CHARGE, "风弹味猫薄荷饼干");
        translationBuilder.add(ModItems.CATNIP_COOKIE_FOOD_WITH_LAVA_BUCKET, "岩浆桶味猫薄荷饼干");
        translationBuilder.add(ModItems.CATNIP_COOKIE_FOOD_WITH_TNT, "TNT味猫薄荷饼干");

        translationBuilder.add(ModBlocks.CAT_CORE_BLOCK, "猫猫核心块");
        translationBuilder.add(ModBlocks.RAW_CAT_CORE_BLOCK, "猫猫核心粗矿块");
        translationBuilder.add(ModBlocks.CAT_CORE_ORE, "猫猫核心矿石");
        translationBuilder.add(ModItemGroups.CAT_GROUP, "猫猫物品组");
        translationBuilder.add(ModItemGroups.CAT_GROUP_FOR_FOOD, "猫猫食品组");

    }
}
