/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketEntityVelocity
 */
package dev.nuker.pyro.mixin;

import net.minecraft.network.play.server.SPacketEntityVelocity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={SPacketEntityVelocity.class})
public interface SPacketEntityVelocityAccessor {
    @Accessor(value="motionX")
    public int Method4287();

    @Accessor(value="motionX")
    public void Method4288(int var1);

    @Accessor(value="motionY")
    public int Method4289();

    @Accessor(value="motionY")
    public void Method4290(int var1);

    @Accessor(value="motionZ")
    public int Method4291();

    @Accessor(value="motionZ")
    public void Method4292(int var1);

    @Accessor(value="entityID")
    public int Method4293();
}

