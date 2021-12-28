/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.GuiTextField
 *  net.minecraft.util.text.TextFormatting
 *  org.lwjgl.input.Keyboard
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class43;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.input.Keyboard;

public class Class49
extends GuiScreen {
    public GuiTextField Field4655;
    public Class43 Field4656;
    public String Field4657;
    public GuiScreen Field4658;
    public String Field4659 = "";

    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawString(this.fontRenderer, "Email/Username", this.width / 2 - 100, 38, 0xA0A0A0);
        this.drawString(this.fontRenderer, "Password (Leave blank for cracked)", this.width / 2 - 100, 79, 0xA0A0A0);
        this.drawCenteredString(this.fontRenderer, (Object)TextFormatting.DARK_RED + this.Field4659, this.width / 2, this.height / 4 + 70, -1);
        GuiTextField guiTextField = this.Field4655;
        guiTextField.drawTextBox();
        Class43 class43 = this.Field4656;
        try {
            class43.Method6810();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        super.drawScreen(n, n2, f);
    }

    public void mouseClicked(int n, int n2, int n3) {
        this.Field4655.mouseClicked(n, n2, n3);
        this.Field4656.Method6790(n, n2, n3);
        super.mouseClicked(n, n2, n3);
    }

    public void onGuiClosed() {
        Keyboard.enableRepeatEvents((boolean)false);
    }

    public void keyTyped(char c, int n) {
        this.Field4655.textboxKeyTyped(c, n);
        this.Field4656.Method6811(c, n);
        if (c == '\t') {
            if (this.Field4655.isFocused()) {
                this.Field4655.setFocused(false);
                this.Field4656.Method4816(true);
            } else if (this.Field4656.Method5694()) {
                this.Field4655.setFocused(false);
                this.Field4656.Method4816(false);
            }
        }
        if (c == '\r') {
            this.actionPerformed((GuiButton)this.buttonList.get(0));
        }
    }

    public void updateScreen() {
        this.Field4655.updateCursorCounter();
        this.Field4656.Method6817();
    }

    public void Method6411(String string, String string2) {
        throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
    }

    public void initGui() {
        Keyboard.enableRepeatEvents((boolean)true);
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 96 + 12, this.Field4657));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 100, this.height / 4 + 96 + 36, "Cancel"));
        this.Field4655 = new GuiTextField(0, this.fontRenderer, this.width / 2 - 100, 51, 200, 20);
        this.Field4656 = new Class43(2, this.fontRenderer, this.width / 2 - 100, 91, 200, 20);
        this.Field4655.setMaxStringLength(200);
        this.Field4656.Method5680(200);
    }

    public void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 1) {
            if (!this.Field4655.getText().isEmpty()) {
                this.Method6411(this.Field4655.getText(), this.Field4656.Method6789());
            }
        } else if (guiButton.id == 2) {
            Minecraft.getMinecraft().displayGuiScreen(this.Field4658);
        }
    }

    public Class49(GuiScreen guiScreen, String string) {
        this.Field4657 = string;
        this.Field4658 = guiScreen;
    }
}

