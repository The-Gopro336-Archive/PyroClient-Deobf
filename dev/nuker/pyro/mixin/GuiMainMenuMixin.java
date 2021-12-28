/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiMainMenu
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.text.TextFormatting
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Class41;
import dev.nuker.pyro.Class44;
import dev.nuker.pyro.Class48;
import dev.nuker.pyro.Config;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.alt.AltLogic;
import dev.nuker.pyro.f0J;
import dev.nuker.pyro.f4K;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiMainMenu.class})
public abstract class GuiMainMenuMixin
extends GuiScreen {
    private boolean Field3910;
    private boolean Field3911;
    private Class41 Field3912;
    private Class44 Field3913;
    private int Field3914 = 0;
    private static final ResourceLocation Field3915 = new ResourceLocation("pyro:assets/textures/logosmall.png");

    @Inject(method={"<init>"}, at={@Class0(value="RETURN")})
    private void Method5609(CallbackInfo ci) {
        this.Field3910 = false;
        this.Field3911 = false;
        new Thread(() -> {
            this.Field3910 = !AltLogic.Method7697() && AltLogic.Method7698();
            this.Field3911 = true;
        }).start();
        this.Field3912 = new Class41();
    }

    @Inject(method={"initGui"}, at={@Class0(value="RETURN")})
    private void Method5610(CallbackInfo ci) {
        this.Field3914 = 0;
        for (GuiButton guiButton : this.buttonList) {
            if (guiButton.y <= this.Field3914) continue;
            this.Field3914 = guiButton.y;
        }
        this.buttonList.add(new GuiButton(-1337, this.width / 2 + 104, this.Field3914, 98, 20, "Alt Manager"));
        this.Field3913 = this.Field3912.Method6785(this.mc.getSession().getProfile());
    }

    @Inject(method={"drawScreen"}, at={@Class0(value="RETURN")})
    private void Method5611(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
        Pyro.Method8991();
    }

    @Inject(method={"actionPerformed"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method5612(GuiButton button, CallbackInfo ci) {
        if (button.id == -1337) {
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new Class48((GuiScreen)new GuiMainMenu()));
            ci.Method9034();
        }
    }

    @Inject(method={"drawScreen"}, at={@Class0(value="RETURN")})
    private void Method5613(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
        int y = this.Field3914 - 4;
        int x = this.width / 2 + 104 + 47;
        int height = 47;
        this.Field3912.Method6787(x, y, height, (EntityPlayer)this.Field3913.Field4632);
        this.Method5614(x, y - 92);
        if (!Config.Field3937.Field3932) {
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new f4K(this));
        }
    }

    private void Method5614(int x, int y) {
        String line1 = this.mc.getSession().getUsername();
        String line2 = AltLogic.Method7697() ? (Object)TextFormatting.RED + "Cracked" : (this.Field3911 ? (this.Field3910 ? (Object)TextFormatting.GREEN + "Premium" : (Object)TextFormatting.YELLOW + "Invalid Session") : (Object)TextFormatting.GRAY + "Unknown Status");
        int width1 = this.fontRenderer.getStringWidth(line1);
        int width2 = this.fontRenderer.getStringWidth(line2);
        int width = Math.max(width1, width2) + 2;
        GuiScreen.drawRect((int)(x - width / 2), (int)(y - this.fontRenderer.FONT_HEIGHT * 2 - 2), (int)(x + width / 2), (int)y, (int)new Color(0, 0, 0, 70).getRGB());
        f0J.Field5485.Method7773(this.fontRenderer, line1, x - width1 / 2, y - this.fontRenderer.FONT_HEIGHT * 2 - 1, -1);
        f0J.Field5485.Method7773(this.fontRenderer, line2, x - width2 / 2, y - this.fontRenderer.FONT_HEIGHT, -1);
    }
}

