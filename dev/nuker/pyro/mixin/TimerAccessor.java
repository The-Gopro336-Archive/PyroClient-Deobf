/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Timer
 */
package dev.nuker.pyro.mixin;

import net.minecraft.util.Timer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={Timer.class})
public interface TimerAccessor {
    @Accessor(value="tickLength")
    public float Method12405();

    @Accessor(value="tickLength")
    public void Method12406(float var1);
}

