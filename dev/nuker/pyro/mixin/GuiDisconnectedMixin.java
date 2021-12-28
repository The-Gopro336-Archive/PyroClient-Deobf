/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiDisconnected
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.multiplayer.GuiConnecting
 *  net.minecraft.util.text.ITextComponent
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f83;
import java.util.Date;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiDisconnected.class})
public class GuiDisconnectedMixin
extends GuiScreen {
    @Shadow
    private int Field6996;
    @Shadow
    @Final
    private GuiScreen Field6997;
    private long Field6998 = -5L;
    private GuiButton Field6999;

    @Inject(method={"<init>"}, at={@Class0(value="RETURN")})
    private void Method11574(GuiScreen screen, String reasonLocalizationKey, ITextComponent chatComp, CallbackInfo ci) {
        if (((Boolean)PyroStatic.Field6415.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6415.Method274().Method7979()).booleanValue()) {
            this.Field6998 = new Date().getTime() + (long)((int)((Double)PyroStatic.Field6415.Method238().Method7979() * 1000.0));
        }
    }

    @Inject(method={"initGui"}, at={@Class0(value="RETURN")})
    private void Method11575(CallbackInfo ci) {
        if (((Boolean)PyroStatic.Field6415.Method274().Method7979()).booleanValue()) {
            this.buttonList.add(new GuiButton(0, this.width / 2 - 100, Math.min(this.height / 2 + this.Field6996 / 2 + this.fontRenderer.FONT_HEIGHT, this.height - 30) + 21, "Reconnect"));
            this.Field6999 = new GuiButton(0, this.width / 2 - 100, Math.min(this.height / 2 + this.Field6996 / 2 + this.fontRenderer.FONT_HEIGHT, this.height - 30) + 42, "Auto Reconnect");
            this.buttonList.add(this.Field6999);
        }
    }

    @Inject(method={"actionPerformed"}, at={@Class0(value="INVOKE")}, cancellable=true)
    private void Method11576(GuiButton button, CallbackInfo ci) {
        if (((Boolean)PyroStatic.Field6415.Method274().Method7979()).booleanValue()) {
            if (this.buttonList.indexOf((Object)button) == 1 && f83.Field3315 != null) {
                Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GuiConnecting(this.Field6997, Minecraft.getMinecraft(), f83.Field3315));
                ci.Method9034();
            } else if (this.buttonList.indexOf((Object)button) == 2) {
                PyroStatic.Field6415.Field5236.Method5266((Boolean)PyroStatic.Field6415.Field5236.Method5264() == false);
                this.Field6998 = (Boolean)PyroStatic.Field6415.Field5236.Method5264() != false ? new Date().getTime() + (long)((int)((Double)PyroStatic.Field6415.Method238().Method7979() * 1000.0)) : -5L;
                ci.Method9034();
            }
        }
    }

    public void updateScreen() {
        super.updateScreen();
        if (((Boolean)PyroStatic.Field6415.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6415.Method274().Method7979()).booleanValue() && f83.Field3315 != null && this.Field6998 != -5L) {
            long timeDiff = this.Field6998 - new Date().getTime();
            this.Field6999.displayString = "Auto Reconnect (" + timeDiff / 1000L + ")";
            if (timeDiff < 0L) {
                Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GuiConnecting(this.Field6997, Minecraft.getMinecraft(), f83.Field3315));
            }
        }
    }
}

