/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketVehicleMove
 */
package dev.nuker.pyro.mixin;

import net.minecraft.network.play.client.CPacketVehicleMove;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={CPacketVehicleMove.class})
public interface CPacketVehicleMoveAccessor {
    @Accessor(value="y")
    public void Method12239(double var1);
}

