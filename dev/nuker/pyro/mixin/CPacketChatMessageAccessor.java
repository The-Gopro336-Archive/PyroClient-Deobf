/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketChatMessage
 */
package dev.nuker.pyro.mixin;

import net.minecraft.network.play.client.CPacketChatMessage;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Debug(export=true, print=true)
@Mixin(value={CPacketChatMessage.class})
public interface CPacketChatMessageAccessor {
    @Accessor(value="message")
    public String Method1802();

    @Accessor(value="message")
    public void Method1803(String var1);
}

