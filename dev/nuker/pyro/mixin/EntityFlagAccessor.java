/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 */
package dev.nuker.pyro.mixin;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={Entity.class})
public interface EntityFlagAccessor {
    @Invoker(value="getFlag")
    public boolean Method2969(int var1);

    @Invoker(value="setFlag")
    public void Method2970(int var1, boolean var2);
}

