package com.actionmao.maomaocraft.item;

import com.actionmao.maomaocraft.MaoMaoCraft;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    //物品注册
    public static final Item CAT_CORE = registerItems("mao_core", new Item(new Item.Settings()));
    public static final Item RAW_CAT_CORE = registerItems("raw_mao_core", new Item(new Item.Settings()));
    public static final Item CATNIP_COOKIE_FOOD = registerItems("catnip_cookie_food", new Item(new Item.Settings().food(ModFoodComponents.CATNIP_COOKIE_FOOD)));


    //普通物品注册
    //要想注册一个新的物品,请使用该方法
    public static Item registerItems(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MaoMaoCraft.MOD_ID, id), item);
    }

    //将物品加入到物品栏中(通过Fabric API)
    public static void addItemToIG(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.add(CAT_CORE);
    }

    //静态初始化方法
    //模组调用时被调用
    //特性:加载该方法,使本类的所有static关键字加载进Minecraft中
    public static void registerModItems(){
        //Fabric实现添加物品至原版物品栏中(分类:原材料)
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIG);


        //输出日志
        MaoMaoCraft.LOGGER.info("Registering Items");
    }
}
