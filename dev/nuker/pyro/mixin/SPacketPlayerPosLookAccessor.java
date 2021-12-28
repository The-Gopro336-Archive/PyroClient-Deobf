/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 */
package dev.nuker.pyro.mixin;

import net.minecraft.network.play.server.SPacketPlayerPosLook;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={SPacketPlayerPosLook.class})
public interface SPacketPlayerPosLookAccessor {
    @Accessor(value="yaw")
    public void Method7129(float var1);

    @Accessor(value="pitch")
    public void Method7130(float var1);

    @Accessor(value="teleportId")
    public int Method7131();
}

