/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.GuiListExtended$IGuiListEntry
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.text.TextFormatting
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class44;
import dev.nuker.pyro.Class45;
import dev.nuker.pyro.Class48;
import dev.nuker.pyro.alt.Alt;
import dev.nuker.pyro.alt.AltLogic;
import dev.nuker.pyro.alt.AltManager;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class Class46
implements GuiListExtended.IGuiListEntry {
    public static ResourceLocation Field4665 = new ResourceLocation("textures/gui/world_selection.png");
    public Minecraft Field4666;
    public Class48 Field4667;
    public Class45 Field4668;
    public Alt Field4669;
    public Class44 Field4670;
    public long Field4671;

    public void drawEntry(int n, int n2, int n3, int n4, int n5, int n6, int n7, boolean bl, float f) {
        String string;
        String string2;
        Minecraft.getMinecraft().player = this.Field4667.Field4680.Field4630;
        String string3 = this.Field4669.Method1436();
        String string4 = this.Field4669.Method1432() ? (Object)TextFormatting.RED + "Cracked" : (string2 = (Object)TextFormatting.GRAY + this.Field4669.Method1434());
        String string5 = (this.Field4669.Method1432() ? this.Field4669.Method1433().getName().equals(Minecraft.getMinecraft().getSession().getProfile().getName()) : this.Field4669.Method1433().getId().equals(Minecraft.getMinecraft().getSession().getProfile().getId())) ? (Object)TextFormatting.BLUE + "In Use" : (string = "");
        String string6 = this.Field4669.Method1432() ? string : (Object)TextFormatting.GREEN + "Premium";
        this.Field4666.fontRenderer.drawString(string3, n2 + 32 + 3, n3 + 1, -1);
        this.Field4666.fontRenderer.drawString(string2, n2 + 32 + 3, n3 + this.Field4666.fontRenderer.FONT_HEIGHT + 3, -1);
        this.Field4666.fontRenderer.drawString(string6, n2 + 32 + 3, n3 + this.Field4666.fontRenderer.FONT_HEIGHT + this.Field4666.fontRenderer.FONT_HEIGHT + 3, -1);
        this.Field4666.fontRenderer.drawString(this.Field4669.Method1432() ? "" : string, n2 + 32 + 3, n3 + this.Field4666.fontRenderer.FONT_HEIGHT * 3 + 3, -1);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.Field4667.Field4680.Method6787(n2 + 16, n3 + n5 - 2, 20, (EntityPlayer)this.Field4670.Field4632);
        if (this.Field4666.gameSettings.touchscreen || bl) {
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)0.0f, (float)0.0f, (float)100.0f);
            Gui.drawRect((int)n2, (int)n3, (int)(n2 + 32), (int)(n3 + 42), (int)new Color(255, 255, 255, 30).getRGB());
            GlStateManager.popMatrix();
        }
    }

    public void updatePosition(int n, int n2, int n3, float f) {
    }

    public void mouseReleased(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    public boolean mousePressed(int n, int n2, int n3, int n4, int n5, int n6) {
        this.Field4668.Method6843(n);
        this.Field4667.Method6847(this);
        if (n5 <= 32) {
            this.Method6823();
            return true;
        }
        if (Minecraft.getSystemTime() - this.Field4671 < 250L) {
            this.Method6823();
            return true;
        }
        this.Field4671 = Minecraft.getSystemTime();
        return false;
    }

    public void Method6823() {
        AltManager.Field6702.Method9679(this.Field4669);
        if (this.Field4669.Method1432()) {
            AltLogic.Method7696(this.Field4669.Method1436());
        } else {
            switch (AltLogic.Method7694(this.Field4669.Method1434(), this.Field4669.Method1438())) {
                case 0: {
                    this.Field4667.Field4687 = false;
                    new Thread(this::Method6824).start();
                    this.Field4667.Field4688 = "";
                    break;
                }
                case 1: {
                    this.Field4667.Field4688 = "Invalid email or password";
                    break;
                }
                case 2: {
                    this.Field4667.Field4688 = "Unable to connect to authentication servers";
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void Method6824() {
        this.Field4667.Field4686 = !AltLogic.Method7697() && AltLogic.Method7698();
        this.Field4667.Field4687 = true;
    }

    public Class46(Class45 class45, Alt alt) {
        this.Field4668 = class45;
        this.Field4667 = class45.Method6841();
        this.Field4666 = Minecraft.getMinecraft();
        this.Field4669 = alt;
        this.Field4670 = this.Field4667.Field4680.Method6786(alt);
    }
}

