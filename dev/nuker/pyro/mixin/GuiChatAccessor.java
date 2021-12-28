/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiChat
 */
package dev.nuker.pyro.mixin;

import net.minecraft.client.gui.GuiChat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={GuiChat.class})
public interface GuiChatAccessor {
    @Accessor(value="sentHistoryCursor")
    public int Method4298();

    @Accessor(value="sentHistoryCursor")
    public void Method4299(int var1);

    @Accessor(value="historyBuffer")
    public void Method4300(String var1);
}

