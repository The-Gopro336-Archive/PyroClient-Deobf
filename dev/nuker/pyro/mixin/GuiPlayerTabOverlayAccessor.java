/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiPlayerTabOverlay
 *  net.minecraft.util.text.ITextComponent
 */
package dev.nuker.pyro.mixin;

import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={GuiPlayerTabOverlay.class})
public interface GuiPlayerTabOverlayAccessor {
    @Accessor(value="footer")
    public ITextComponent Method12402();

    @Accessor(value="header")
    public ITextComponent Method12403();

    @Accessor(value="lastTimeOpened")
    public long Method12404();
}

