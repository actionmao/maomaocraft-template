package com.actionmao.maomaocraft;

import com.actionmao.maomaocraft.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

//数据生成器
public class MaoMaoCraftDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		//添加数据生成类(datagen包下)
		//注意:要让这些类的构造方法有权限被调用 -> 其中一种解决方案(public)
		pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModENUSLanguageProvider::new);
		pack.addProvider(ModItemTagsProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelsProvider::new);
		pack.addProvider(ModRecipesProvider::new);
		pack.addProvider(ModZHCNLanguageProvider::new);

	}
}
