/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiBossOverlay
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.client.gui.GuiBossOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiBossOverlay.class})
public class GuiBossOverlayMixin {
    @Inject(method={"renderBossHealth"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method9494(CallbackInfo info) {
        if (((Boolean)PyroStatic.Field6443.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6443.Method279().Method7979()).booleanValue()) {
            info.Method9034();
        }
    }
}

