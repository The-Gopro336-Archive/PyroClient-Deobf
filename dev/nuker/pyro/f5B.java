/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.ScaledResolution
 *  org.lwjgl.input.Keyboard
 */
package dev.nuker.pyro;

import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.IntegerSetting;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0w;
import dev.nuker.pyro.f5d;
import dev.nuker.pyro.f5g;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Keyboard;

public class f5b
extends GuiScreen {
    public GuiScreen Field2924;
    public f5d Field2925;
    public String Field2926;
    public f5g Field2927;

    public void drawScreen(int n, int n2, float f) {
        this.Field2924.drawScreen(-1337, -1337, f);
        this.Field2927.Method4797(n, n2, f);
    }

    public f5b(String string, GuiScreen guiScreen, f5d f5d2) {
        this.Field2926 = string;
        this.Field2924 = guiScreen;
        this.Field2925 = f5d2;
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        float f = scaledResolution.getScaledWidth() / 2;
        float f2 = scaledResolution.getScaledHeight() / 2 + 40;
        this.Field2927 = new f5g(string, f, f2);
        f0w f0w2 = this.Field2925.Method4795().Method5753();
        if (f0w2 instanceof DoubleSetting) {
            DoubleSetting doubleSetting = (DoubleSetting)f0w2;
            this.Field2927.Method4802().Method4800(String.valueOf(doubleSetting.Method7979()));
        } else if (f0w2 instanceof IntegerSetting) {
            IntegerSetting integerSetting = (IntegerSetting)f0w2;
            this.Field2927.Method4802().Method4800(String.valueOf(integerSetting.Method7979()));
        }
    }

    public void mouseReleased(int n, int n2, int n3) {
        this.Field2927.Method4810(n, n2, n3);
    }

    public void mouseClicked(int n, int n2, int n3) {
        this.Field2927.Method4796(n, n2, n3);
    }

    public void keyTyped(char c, int n) {
        if (Keyboard.getKeyName((int)n).equals("ESCAPE")) {
            this.mc.displayGuiScreen(this.Field2924);
            Pyro.Field6182.Method8989(this.Field2927.Method4802().Method4799());
            return;
        }
        if (Keyboard.getKeyName((int)n).equals("RETURN")) {
            this.Method4816(true);
        } else {
            this.Field2927.Method4798(c, n);
        }
    }

    public void Method4816(boolean bl) {
        if (!bl) {
            this.mc.displayGuiScreen(this.Field2924);
        } else {
            try {
                f0w f0w2 = this.Field2925.Method4795().Method5753();
                if (f0w2 instanceof DoubleSetting) {
                    DoubleSetting doubleSetting = (DoubleSetting)f0w2;
                    double d = Double.parseDouble(this.Field2927.Method4802().Method4799());
                    doubleSetting.Method7975(d);
                } else if (f0w2 instanceof IntegerSetting) {
                    IntegerSetting integerSetting = (IntegerSetting)f0w2;
                    int n = Integer.parseInt(this.Field2927.Method4802().Method4799());
                    integerSetting.Method7975(n);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            this.mc.displayGuiScreen(this.Field2924);
        }
    }
}

