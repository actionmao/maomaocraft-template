package com.actionmao.maomaocraft.mixin;

import net.minecraft.entity.mob.EndermanEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(EndermanEntity.class)
public interface EndermanEntityMixin {
    //invoker注解:调用方法
    @Invoker("teleportTo")
    boolean invokeTeleportTo(double x, double y, double z);

}
