/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketCloseWindow
 */
package dev.nuker.pyro.mixin;

import net.minecraft.network.play.client.CPacketCloseWindow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={CPacketCloseWindow.class})
public interface CPacketCloseWindowAccessor {
    @Accessor(value="windowId")
    public int Method918();
}

