package com.actionmao.maomaocraft.item;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class CatnipCookieFoodWithTnt extends Item {
    // 爆炸威力（原版TNT为4.0F）
    private static final float EXPLOSION_POWER = 4.0F;

    public CatnipCookieFoodWithTnt(Settings settings) {
        super(settings);
    }

    // 玩家右键使用物品时触发（直接使用而非喂猫）
    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        World world = user.getWorld();

        // 仅在服务器端执行爆炸逻辑（避免客户端与服务器不同步）
        if (!world.isClient) {
            // 播放引信音效
            world.playSound(null, entity.getX(), entity.getY(), entity.getZ(),
                    SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);

            // 延迟10 ticks（0.5秒）后爆炸，模拟TNT引信
            world.createExplosion(
                    user, // 爆炸源（可为null）
                    entity.getX(), // 爆炸X坐标（以被作用实体为中心）
                    entity.getY(), // 爆炸Y坐标
                    entity.getZ(), // 爆炸Z坐标
                    EXPLOSION_POWER, // 爆炸威力
                    World.ExplosionSourceType.TNT // 是否破坏方块（可选：NONE不破坏）
            );
        }

        // 消耗物品
        if (!user.getAbilities().creativeMode) {
            stack.decrement(1);
        }

        return ActionResult.success(world.isClient);
    }

    // 玩家自己食用时也触发爆炸
    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient) {
            world.playSound(null, user.getX(), user.getY(), user.getZ(),
                    SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);

            world.createExplosion(
                    user,
                    user.getX(),
                    user.getY(),
                    user.getZ(),
                    EXPLOSION_POWER,
                    World.ExplosionSourceType.TNT
            );
        }

        return super.finishUsing(stack, world, user);
    }
}
