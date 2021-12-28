/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiSubtitleOverlay
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Class8;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f4E;
import net.minecraft.client.gui.GuiSubtitleOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiSubtitleOverlay.class})
public abstract class GuiSubtitleOverlayMixin {
    @Inject(method={"renderSubtitles"}, at={@Class0(value="HEAD")})
    private void Method4628(CallbackInfo callbackInfo) {
        Pyro.Field6183.Method7918(new f4E());
        Class8.Field5278.Method865();
    }
}

