package com.actionmao.maomaocraft.datagen;

import com.actionmao.maomaocraft.block.ModBlocks;
import com.actionmao.maomaocraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

//数据生成 -> 简化书写战利品列表(如:掉落物)
public class ModLootTableProvider extends FabricBlockLootTableProvider {

    //构造方法
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    //成员方法
    @Override
    public void generate() {
        addDrop(ModBlocks.MAO_CORE_BLOCK);
        addDrop(ModBlocks.RAW_MAO_CORE_BLOCK);
        //针对于一般矿石的掉落物设置写法
        //addDrop(ModBlocks.MAO_CORE_ORE, oreDrops(ModBlocks.MAO_CORE_ORE, ModItems.RAW_MAO_CORE));
        //针对于mao_core_ore的掉落物写法
        addDrop(ModBlocks.MAO_CORE_ORE, maoCoreOreDrops(ModBlocks.MAO_CORE_ORE));
    }

    public LootTable.Builder maoCoreOreDrops(Block drop) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(ModItems.RAW_MAO_CORE)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 64.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
