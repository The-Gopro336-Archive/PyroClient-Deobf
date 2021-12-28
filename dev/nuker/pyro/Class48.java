/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityOtherPlayerMP
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiMainMenu
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.resources.I18n
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.text.TextFormatting
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class41;
import dev.nuker.pyro.Class44;
import dev.nuker.pyro.Class45;
import dev.nuker.pyro.Class46;
import dev.nuker.pyro.Class47;
import dev.nuker.pyro.Class50;
import dev.nuker.pyro.alt.Alt;
import dev.nuker.pyro.alt.AltLogic;
import dev.nuker.pyro.alt.AltManager;
import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Class48
extends GuiScreen {
    public static Logger Field4679 = LogManager.getLogger();
    public Class41 Field4680 = new Class41();
    public GuiScreen Field4681;
    public GuiButton Field4682;
    public GuiButton Field4683;
    public GuiButton Field4684;
    public Class45 Field4685;
    public boolean Field4686;
    public boolean Field4687;
    public String Field4688 = "";
    public Class44 Field4689;

    public void actionPerformed(GuiButton guiButton) {
        if (guiButton.enabled) {
            Class46 class46 = this.Field4685.Method6845();
            switch (guiButton.id) {
                case 0: {
                    this.mc.displayGuiScreen((GuiScreen)new GuiMainMenu());
                    break;
                }
                case 1: {
                    class46.Method6823();
                    break;
                }
                case 2: {
                    AltManager.Field6702.Method9678(class46.Field4669);
                    this.Field4685.Field4677.remove(class46);
                    this.Method6847(this.Field4685.Method6845());
                    break;
                }
                case 4: {
                    this.Field4688 = "";
                    this.mc.displayGuiScreen((GuiScreen)new Class50(this, this, "Add Account"));
                    break;
                }
                case 3: {
                    this.Field4688 = "";
                    this.mc.displayGuiScreen((GuiScreen)new Class47(this, this, "Login"));
                    break;
                }
            }
        }
    }

    public void drawScreen(int n, int n2, float f) {
        String string;
        this.drawDefaultBackground();
        this.Field4685.drawScreen(n, n2, f);
        this.drawCenteredString(this.fontRenderer, "Select account", this.width / 2, 20, 0xFFFFFF);
        EntityOtherPlayerMP entityOtherPlayerMP = this.Field4689.Field4632;
        Alt alt = null;
        if (this.Field4685.Method6845() != null) {
            entityOtherPlayerMP = this.Field4685.Method6845().Field4670.Field4632;
            alt = this.Field4685.Method6845().Field4669;
        }
        int n3 = this.width / 4 * 3 + this.width / 8;
        this.Field4680.Method6787(n3, this.height - 95 - this.height / 20, (int)((double)this.height / 4.6), (EntityPlayer)entityOtherPlayerMP);
        String string2 = entityOtherPlayerMP.getGameProfile().getName();
        String string3 = entityOtherPlayerMP == this.Field4689.Field4632 || (alt.Method1432() ? alt.Method1433().getName().equals(Minecraft.getMinecraft().getSession().getProfile().getName()) : alt.Method1433().getId().equals(Minecraft.getMinecraft().getSession().getProfile().getId())) ? (AltLogic.Method7697() ? (Object)TextFormatting.RED + "Cracked" : (this.Field4687 ? (this.Field4686 ? (Object)TextFormatting.GREEN + "Premium" : (Object)TextFormatting.YELLOW + "Invalid Session") : (Object)TextFormatting.GRAY + "Unknown Status")) : (string = alt.Method1432() ? (Object)TextFormatting.RED + "Cracked" : (Object)TextFormatting.GREEN + "Authenticated");
        String string4 = entityOtherPlayerMP == this.Field4689.Field4632 || (alt.Method1432() ? alt.Method1433().getName().equals(Minecraft.getMinecraft().getSession().getProfile().getName()) : alt.Method1433().getId().equals(Minecraft.getMinecraft().getSession().getProfile().getId())) ? (Object)TextFormatting.BLUE + "In Use" : "";
        int n4 = this.fontRenderer.getStringWidth(string2);
        int n5 = this.fontRenderer.getStringWidth(string);
        int n6 = this.fontRenderer.getStringWidth(string4);
        this.fontRenderer.drawString(string2, n3 - n4 / 2, this.height - 90, -1);
        this.fontRenderer.drawString(string, n3 - n5 / 2, this.height - 90 + this.fontRenderer.FONT_HEIGHT + 1, -1);
        this.fontRenderer.drawString(string4, n3 - n6 / 2, this.height - 90 + this.fontRenderer.FONT_HEIGHT * 2 + 2, -1);
        this.drawCenteredString(this.fontRenderer, (Object)TextFormatting.DARK_RED + this.Field4688, this.width / 2, this.height - 64, -1);
        super.drawScreen(n, n2, f);
    }

    public void handleMouseInput() {
        super.handleMouseInput();
        this.Field4685.handleMouseInput();
    }

    public void Method6846() {
        this.Field4683 = this.addButton(new GuiButton(1, this.width / 2 - 154, this.height - 52, 150, 20, I18n.format((String)"Login", (Object[])new Object[0])));
        this.addButton(new GuiButton(3, this.width / 2 + 4, this.height - 52, 150, 20, I18n.format((String)"Direct Login", (Object[])new Object[0])));
        this.Field4684 = this.addButton(new GuiButton(4, this.width / 2 - 154, this.height - 28, 72, 20, "Add"));
        this.Field4682 = this.addButton(new GuiButton(2, this.width / 2 - 76, this.height - 28, 72, 20, "Remove"));
        this.addButton(new GuiButton(0, this.width / 2 + 4, this.height - 28, 150, 20, I18n.format((String)"gui.cancel", (Object[])new Object[0])));
        this.Method6847(this.Field4685.Method6845());
    }

    public void Method6797() {
        this.Field4686 = !AltLogic.Method7697() && AltLogic.Method7698();
        this.Field4687 = true;
    }

    public void Method6847(@Nullable Class46 class46) {
        boolean bl;
        this.Field4683.enabled = bl = class46 != null;
        this.Field4682.enabled = bl;
    }

    public static Class45 Method6848(Class48 class48) {
        return class48.Field4685;
    }

    public void mouseReleased(int n, int n2, int n3) {
        super.mouseReleased(n, n2, n3);
        this.Field4685.mouseReleased(n, n2, n3);
    }

    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        this.Field4685.mouseClicked(n, n2, n3);
    }

    public void initGui() {
        this.Field4685 = new Class45(this, this.mc, this.width / 4 * 3, this.height, 32, this.height - 68, 46);
        Optional<Class46> optional = this.Field4685.Field4677.stream().filter(Class48::Method6849).findFirst();
        optional.ifPresent(this::Method6850);
        this.Method6846();
        this.Field4689 = this.Field4680.Method6785(this.mc.getSession().getProfile());
    }

    public Class48(GuiScreen guiScreen) {
        this.Field4681 = guiScreen;
        this.Field4686 = false;
        this.Field4687 = false;
        new Thread(this::Method6797).start();
    }

    public static boolean Method6849(Class46 class46) {
        return class46.Field4669.Method1433().getId().equals(Minecraft.getMinecraft().getSession().getProfile().getId());
    }

    public void Method6850(Class46 class46) {
        this.Field4685.Method6843(this.Field4685.Field4677.indexOf(class46));
    }
}

