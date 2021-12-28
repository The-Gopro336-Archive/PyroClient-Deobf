/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.renderer.GlStateManager
 *  org.lwjgl.input.Mouse
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f4Q;
import dev.nuker.pyro.f4W;
import java.util.ArrayList;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.input.Mouse;

public class f4P
extends GuiScreen {
    public int Field4077 = 10;
    public ArrayList<f4Q> Field4078 = new ArrayList();
    public f4Q Field4079 = null;
    public int Field4080 = 0;

    public int Method5679() {
        return this.Field4077 += 125;
    }

    public static void Method5729(char c, int n, f4Q f4Q2) {
        f4Q2.Method4798(c, n);
    }

    public void mouseReleased(int n, int n2, int n3) {
        super.mouseReleased(n, n2, n3);
        double d = f0H.Field5479.Method7706();
        float f = n;
        float f2 = n2 - this.Field4080;
        f = (float)((double)f / d);
        f2 = (float)((double)f2 / d);
        int n4 = (int)f;
        int n5 = (int)f2;
        this.Field4078.forEach(arg_0 -> f4P.Method5731(n4, n5, n3, arg_0));
    }

    public void Method5730(f4W f4W2) {
        this.Field4079 = f4W2;
    }

    public void keyTyped(char c, int n) {
        super.keyTyped(c, n);
        this.Field4078.forEach(arg_0 -> f4P.Method5729(c, n, arg_0));
    }

    public boolean doesGuiPauseGame() {
        return false;
    }

    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        for (int i = this.Field4078.size() - 1; i >= 0; --i) {
            f4Q f4Q2 = this.Field4078.get(i);
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)f4Q2.Method4828(), (float)(f4Q2.Method4906() + (float)this.Field4080), (float)0.0f);
            double d = f0H.Field5479.Method7706();
            GlStateManager.scale((double)d, (double)d, (double)d);
            float f2 = (float)n - f4Q2.Method4828();
            float f3 = (float)n2 - f4Q2.Method4906() - (float)this.Field4080;
            f2 = (float)((double)f2 / d);
            f3 = (float)((double)f3 / d);
            f4Q2.Method4797(f2, f3, f);
            GlStateManager.popMatrix();
        }
        if (this.Field4079 != null) {
            this.Field4078.remove(this.Field4079);
            this.Field4078.add(0, this.Field4079);
            this.Field4079 = null;
        }
    }

    public static void Method5731(int n, int n2, int n3, f4Q f4Q2) {
        f4Q2.Method4810(n, n2, n3);
    }

    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        f4Q f4Q2 = null;
        float f = n2 - this.Field4080;
        for (f4Q f4Q3 : this.Field4078) {
            if (!((float)n >= f4Q3.Method4828()) || !((float)n <= f4Q3.Method4828() + f4Q3.Method5094()) || !((float)(n2 - this.Field4080) >= f4Q3.Method4906()) || !((float)(n2 - this.Field4080) <= f4Q3.Method4906() + f4Q3.Method4908())) continue;
            f4Q2 = f4Q3;
            break;
        }
        if (f4Q2 != null) {
            double d = f0H.Field5479.Method7706();
            float f2 = n;
            this.Field4078.remove(f4Q2);
            this.Field4078.add(0, f4Q2);
            f4Q2.Method4796((int)f2, (int)f, n3);
        }
    }

    public void handleMouseInput() {
        super.handleMouseInput();
        int n = Mouse.getEventDWheel();
        if (n != 0) {
            if (n > 1) {
                n = 1;
            }
            if (n < -1) {
                n = -1;
            }
            if (!f4P.isShiftKeyDown()) {
                n *= 25;
            }
            this.Field4080 += n;
            this.Field4080 = Math.min(0, this.Field4080);
        }
    }
}

