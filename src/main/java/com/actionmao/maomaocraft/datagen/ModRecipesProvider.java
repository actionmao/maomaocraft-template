package com.actionmao.maomaocraft.datagen;

import com.actionmao.maomaocraft.MaoMaoCraft;
import com.actionmao.maomaocraft.block.ModBlocks;
import com.actionmao.maomaocraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

//数据生成 -> 简化所有与原版合成有关(如:工作台,熔炉,高炉)操作
public class ModRecipesProvider extends FabricRecipeProvider {
    //放入炉内的物品就是list集合中的每一个参数, 预期的生成物叫做mao_core
    //list集合中的元素就在list.of()的括号中
    public static final List<ItemConvertible> MAO_CORE = List.of(ModItems.RAW_CAT_CORE, ModBlocks.CAT_CORE_ORE);

    //构造方法
    public ModRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }


    //数据生成用于合成的成员方法
    @Override
    public void generate(RecipeExporter recipeExporter) {
        //mao_core与mao_core_block可逆合成
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.CAT_CORE,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.CAT_CORE_BLOCK);
        //raw_mao_core与raw_mao_core_block可逆合成
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.RAW_CAT_CORE,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_CAT_CORE_BLOCK);
        //冶炼raw_mao_core
        //ModItems中的mao_core ->生成物
        //1.熔炉
        offerSmelting(recipeExporter, MAO_CORE, RecipeCategory.MISC, ModItems.CAT_CORE, 0.5F, 20, "mao_core");
        //2.高炉
        offerBlasting(recipeExporter, MAO_CORE, RecipeCategory.MISC, ModItems.CAT_CORE, 0.5F, 10, "mao_core");
        //3.营火
        offerFoodCookingRecipe(recipeExporter, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new,
                60, ModItems.RAW_CAT_CORE, ModItems.CAT_CORE, 0.35F);
        //有序合成
        //合成方式:3个mud排成一排
        //clay ->生成物
        //criterion -> 解锁配方条件是:玩家拥有mud
        //offerTo -> 确保解锁配方的json文件生成在data/maomaocraft/recipe下
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.CLAY, 3)
                .pattern("###").input('#', Ingredient.ofItems(Items.MUD))
                .criterion("has_item", RecipeProvider.conditionsFromItem(Items.MUD))
                .offerTo(recipeExporter, Identifier.of(MaoMaoCraft.MOD_ID, "mud_to_clay"));

        //无序合成
        //合成方式:1个stone和一个raw_mao_core
        //生成物:mao_core_ore(就是原矿方块)
        //criterion -> 解锁配方条件是:玩家拥有raw_mao_core或stone中的一个
        //offerTo -> 确保解锁配方的json文件生成在data/maomaocraft/recipe下
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CAT_CORE_ORE)
                .input(ModItems.RAW_CAT_CORE)
                .input(Items.STONE)
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.RAW_CAT_CORE))
                .criterion("has_item", RecipeProvider.conditionsFromItem(Items.STONE))
                .offerTo(recipeExporter, Identifier.of(MaoMaoCraft.MOD_ID, "mao_core_ore"));
    }
}
