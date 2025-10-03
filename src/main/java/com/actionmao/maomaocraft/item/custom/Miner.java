package com.actionmao.maomaocraft.item.custom;

import com.actionmao.maomaocraft.tags.ModBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.entity.ItemEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;

import java.util.ArrayList;
import java.util.List;

public class Miner extends Item {
    //属性
    private boolean isContinue;
    private int initialCount;
    private int initialShortCount;
    private int shortCount;


    public Miner(Settings settings) {
        super(settings);
    }

    public Miner(Settings settings, boolean isContinue, int count, int shortCount) {
        super(settings);
        this.isContinue = isContinue;
        this.initialCount = count;
        this.initialShortCount = shortCount;
    }

    public boolean isContinue() {
        return isContinue;
    }

    public void setContinue(boolean aContinue) {
        isContinue = aContinue;
    }

    public int getInitialCount() {
        return initialCount;
    }

    public void setInitialCount(int initialCount) {
        this.initialCount = initialCount;
    }

    public int getInitialShortCount() {
        return initialShortCount;
    }

    public void setInitialShortCount(int initialShortCount) {
        this.initialShortCount = initialShortCount;
    }


    //成员方法

    //检测矿石
    public ArrayList<BlockPos> prospect(ItemUsageContext context, PlayerEntity player, World world, int round, BlockPos pos) {
        ArrayList<BlockPos> newList = new ArrayList<>();
        int StartY = Math.min((pos.getY() + 64), (round / 2));
        for (int y = -StartY; y <= round / 2; y++) {
            for (int x = -(round / 2); x <= round / 2; x++) {
                for (int z = -(round / 2); z <= round / 2; z++) {
                    //目标方块的坐标
                    BlockPos searchedBlockPos = pos.up(y).north(x).east(z);
                    //获取目标方块的名字
                    BlockState blockState = world.getBlockState(searchedBlockPos);
                    String blockName = blockState.getBlock().getName().getString();
                    if (isBlockOre(blockState)) {
                        context.getStack().damage(1, player, EquipmentSlot.MAINHAND);
                        //表明找到了目标方块
                        //1.将方块坐标存入列表
                        newList.add(searchedBlockPos);
                        //2.破坏方块
                        //<1>破坏后产生烟花爆炸声
                        //<2>产生掉落物,产生后立即按一定速度直线回到玩家身边
                        damageBlock(searchedBlockPos, blockState, world, player);
                        if (isContinue) {
                            //3.shortCount--
                            shortCount--;
                            //4.如果shortCount >= 0,以3*3*3范围递归本方法
                            if (shortCount >= 0) {
                                ArrayList<BlockPos> prospect = prospect(context, player, world, 3, searchedBlockPos);
                                newList.addAll(prospect);
                            }
                        } else {
                            break;
                        }


                    }
                }
            }
        }
        return newList;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.maomaocraft.miner.shift_tooltip"));
        } else {
            tooltip.add(Text.translatable("item.maomaocraft.miner.tooltip"));
        }
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        int count = initialCount;
        shortCount = initialShortCount;
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        int round;
        if (!world.isClient) {
            //判断范围
            if (!Screen.hasShiftDown()) {
                //5格范围
                round = 5;
                context.getStack().damage(2, player, EquipmentSlot.MAINHAND);
            } else {
                //13格范围
                round = 13;
                context.getStack().damage(16, player, EquipmentSlot.MAINHAND);
            }

            //创建集合
            ArrayList<BlockPos> list = new ArrayList<>();
            list.add(pos);
            ArrayList<BlockPos> newList = new ArrayList<>();

            while (true) {
                for (BlockPos blockPos : list) {
                    //遍历执行矿物检测
                    newList.addAll(prospect(context, player, world, round, blockPos));
                    //消耗耐久度
                    context.getStack().damage(3, player, EquipmentSlot.MAINHAND);
                }
                count--;
                if (count <= 0) break;
                list = newList;
            }


        }

        return super.useOnBlock(context);
    }

    private boolean isBlockOre(BlockState blockState) {
        return blockState.isIn(ModBlockTags.ORE_LIST);
    }


    /**
     * 破坏方块并生成效果
     *
     * @param pos    方块位置
     * @param state  方块状态
     * @param world  世界
     * @param player 玩家
     */
    private void damageBlock(BlockPos pos, BlockState state, World world, PlayerEntity player) {
        if (world.isClient) {
            // 客户端处理粒子效果和音效
            spawnParticleEffect(pos, world, state);
            /*world.playSound(pos.getX(), pos.getY(), pos.getZ(),
                    SoundEvents.ENTITY_FIREWORK_ROCKET_BLAST, SoundCategory.BLOCKS,
                    1.0f, 1.0f, false);*/
        } else {
            // 服务器端处理方块破坏和掉落物生成
            boolean broken = world.breakBlock(pos, false, player);
            if (broken) {
                if (player != null) {
//                    ArrayList<ItemEntity> itemEntities = new ArrayList<>();
                    List<ItemStack> drops = Block.getDroppedStacks(state, (ServerWorld) world, pos, world.getBlockEntity(pos), player, ItemStack.EMPTY);
                    Vec3d playerPos = new Vec3d(player.getX(), player.getY() + player.getStandingEyeHeight(), player.getZ());

                    for (ItemStack stack : drops) {
                        ItemEntity itemEntity = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, stack);
//                        itemEntities.add(itemEntity);
                        world.spawnEntity(itemEntity);
                        world.breakBlock(pos, true);
                        // 将掉落物直接传送至玩家
                        itemEntity.setPos(playerPos.x, playerPos.y, playerPos.z);
                        itemEntity.setVelocity(Vec3d.ZERO);

                    }
                    // 播放烟花爆炸声
                    world.playSound(
                            null,
                            pos,
                            SoundEvents.ENTITY_FIREWORK_ROCKET_BLAST,
                            SoundCategory.BLOCKS,
                            1.0f,
                            1.0f
                    );
                    // 让掉落物飞向玩家
                    /*if (!itemEntities.isEmpty()) {
                        Vec3d playerPos = new Vec3d(player.getX(), player.getY() + player.getStandingEyeHeight(), player.getZ());
                        itemEntities.forEach(item -> {
                            Vec3d direction = playerPos.subtract(item.getPos()).normalize().multiply(0.2);
                            item.setVelocity(direction);
                        });

                    }*/


                }

            }

        }
    }

    /**
     * 生成对应颜色的粒子效果
     *
     * @param pos   方块位置
     * @param world 世界
     * @param state 方块状态
     */
    private void spawnParticleEffect(BlockPos pos, World world, BlockState state) {
        Random random = world.getRandom();
        ParticleEffect particleType = ParticleTypes.FIREWORK; // 默认粒子类型

        // 这里可以根据不同的矿石类型设置不同的粒子颜色
        // 示例：根据方块的默认颜色生成粒子
        int color = state.getMapColor(world, pos).getRenderColor(MapColor.Brightness.HIGH);
        float red = (color >> 16 & 0xFF) / 255.0F;
        float green = (color >> 8 & 0xFF) / 255.0F;
        float blue = (color & 0xFF) / 255.0F;

        // 生成粒子并设置颜色
        for (int i = 0; i < 15; i++) {
            double x = pos.getX() + random.nextDouble();
            double y = pos.getY() + random.nextDouble();
            double z = pos.getZ() + random.nextDouble();
            world.addParticle(particleType, x, y, z,
                    random.nextGaussian() * 0.05,
                    random.nextGaussian() * 0.05,
                    random.nextGaussian() * 0.05
            );
        }
    }
}

