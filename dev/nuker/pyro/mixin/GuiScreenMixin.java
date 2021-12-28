/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.item.ItemStack
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f4F;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiScreen.class})
public class GuiScreenMixin {
    @Inject(method={"renderToolTip"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method4554(ItemStack stack, int x, int y, CallbackInfo info) {
        f4F event = new f4F(stack, x, y);
        Pyro.Method8978().Method7918(event);
        if (event.Method7947()) {
            info.Method9034();
        }
    }
}

