/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketPlayer
 */
package dev.nuker.pyro.mixin;

import net.minecraft.network.play.client.CPacketPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={CPacketPlayer.class})
public interface CPacketPlayerAccessor {
    @Accessor(value="y")
    public void Method8718(double var1);

    @Accessor(value="y")
    public double Method8719();

    @Accessor(value="x")
    public double Method8720();

    @Accessor(value="z")
    public double Method8721();

    @Accessor(value="onGround")
    public void Method8722(boolean var1);

    @Accessor(value="rotating")
    public boolean Method8723();

    @Accessor(value="rotating")
    public void Method8724(boolean var1);

    @Accessor(value="yaw")
    public float Method8725();

    @Accessor(value="pitch")
    public float Method8726();

    @Accessor(value="yaw")
    public void Method8727(float var1);

    @Accessor(value="pitch")
    public void Method8728(float var1);
}

