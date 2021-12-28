/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiChat
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.GuiTextField
 *  net.minecraft.util.text.ITextComponent
 *  org.lwjgl.input.Mouse
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Class8;
import dev.nuker.pyro.Config;
import dev.nuker.pyro.f4N;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.text.ITextComponent;
import org.lwjgl.input.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiChat.class})
public abstract class GuiChatMixin
extends GuiScreen {
    @Shadow
    protected GuiTextField Field7484;
    @Shadow
    private String Field7485;
    @Shadow
    private int Field7486;

    @Inject(method={"Lnet/minecraft/client/gui/GuiChat;keyTyped(CI)V"}, at={@Class0(value="RETURN")})
    public void Method12410(char typedChar, int keyCode, CallbackInfo info) {
        if (!(Minecraft.getMinecraft().currentScreen instanceof GuiChat) || Minecraft.getMinecraft().currentScreen instanceof f4N) {
            return;
        }
        if (this.Field7484.getText().startsWith(Config.Field3937.Field3931)) {
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new f4N(this.Field7484.getText(), this.Field7485, this.Field7486));
        }
    }

    @Inject(method={"drawScreen"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method12411(int mouseX, int mouseY, float partialTicks, CallbackInfo info) {
        if (Class8.Field5278.Field5276 != 0) {
            info.Method9034();
            GuiChatMixin.drawRect((int)2, (int)(this.height - Class8.Field5278.Field5276), (int)(this.width - 2), (int)(this.height - 2), (int)Integer.MIN_VALUE);
            this.Field7484.drawTextBox();
            ITextComponent itextcomponent = this.mc.ingameGUI.getChatGUI().getChatComponent(Mouse.getX(), Mouse.getY());
            if (itextcomponent != null && itextcomponent.getStyle().getHoverEvent() != null) {
                this.handleComponentHover(itextcomponent, mouseX, mouseY);
            }
            super.drawScreen(mouseX, mouseY, partialTicks);
        }
    }
}

