package com.actionmao.maomaocraft.item;

import com.actionmao.maomaocraft.MaoMaoCraft;
import com.actionmao.maomaocraft.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    //物品栏组的属性值
    public static final RegistryKey<ItemGroup> MAO_GROUP = register("mao_group");


    //要想注册一个新的物品栏,请使用该方法
    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(MaoMaoCraft.MOD_ID,id));
    }

    //向物品栏添加物品
    public static void registerItemsToItemGroup(){
        Registry.register(
                Registries.ITEM_GROUP,
                MAO_GROUP,
                ItemGroup.create(ItemGroup.Row.TOP, -1)
                        .displayName(Text.translatable("itemGroup.mao_group"))
                        .icon(() -> new ItemStack(ModItems.MAO_CORE))
                        .entries((displayContext, entries) -> {
                            //mao_group中会展示的物品
                            entries.add(ModItems.MAO_CORE);
                            entries.add(ModBlocks.MAO_CORE_BLOCK);
                            entries.add(ModBlocks.RAW_MAO_CORE_BLOCK);
                            entries.add(ModBlocks.MAO_CORE_ORE);
                        })
                        .build()
        );

    }

    //初始化方法
    public static void registerModItemGroups() {
        registerItemsToItemGroup();
        MaoMaoCraft.LOGGER.info("Registering Item Groups");

    }





}
