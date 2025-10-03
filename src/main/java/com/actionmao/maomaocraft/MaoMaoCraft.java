package com.actionmao.maomaocraft;

import com.actionmao.maomaocraft.block.ModBlocks;
import com.actionmao.maomaocraft.item.ModItemGroups;
import com.actionmao.maomaocraft.item.ModItems;
import com.actionmao.maomaocraft.mixin.GrassColorsMixin;
import com.actionmao.maomaocraft.tags.ModBlockTags;
import com.actionmao.maomaocraft.tags.ModItemTags;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaoMaoCraft implements ModInitializer {
	public static final String MOD_ID = "maomaocraft";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		//注册加载
		ModItems.registerModItems();
		ModItemGroups.registerModItemGroups();
		ModBlocks.registerModBlocks();
		ModBlockTags.registerModBlockTags();
		ModItemTags.registerModItemTags();

		//调用GrassColorsMixin中的getter/setter
		int[] colorMap = GrassColorsMixin.getColorMap();
		LOGGER.info("Grass Color Map length: {}", colorMap.length);
		GrassColorsMixin.setColorMap(new int[128]);
		LOGGER.info("New Grass Color Map length: {}", GrassColorsMixin.getColorMap().length);


		LOGGER.info("Hello Fabric world!");
	}

}