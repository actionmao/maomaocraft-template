package com.actionmao.maomaocraft.mixin;

import net.minecraft.world.biome.GrassColors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(GrassColors.class)
public interface GrassColorsMixin {
    //Accessor注解作用:生成getter和setter方法
    @Accessor("colorMap")
    static int[] getColorMap() {
        //这只是"占位符",Mixin会将其处理为返回colorMap的逻辑
        throw new AssertionError();
    }

    @Accessor("colorMap")
    static void setColorMap(int[] colorMap) {
        //逻辑是 “将参数值赋值给 colorMap 字段”
        throw new AssertionError();
    }
}
