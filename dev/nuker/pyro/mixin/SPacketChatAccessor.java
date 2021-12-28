/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketChat
 *  net.minecraft.util.text.ITextComponent
 */
package dev.nuker.pyro.mixin;

import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={SPacketChat.class})
public interface SPacketChatAccessor {
    @Accessor(value="chatComponent")
    public void Method9596(ITextComponent var1);
}

