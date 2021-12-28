/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class8;
import dev.nuker.pyro.f4P;
import dev.nuker.pyro.f4U;
import net.minecraft.client.gui.ScaledResolution;

public class f5j
extends f4P {
    public f5j() {
        this.Field4077 = 120;
        this.Field4078.add(new f4U("Combat", this.Method5679(), 10.0f));
        this.Field4078.add(new f4U("General", this.Method5679(), 10.0f));
        this.Field4078.add(new f4U("Misc", this.Method5679(), 10.0f));
    }

    @Override
    public void mouseReleased(int n, int n2, int n3) {
        super.mouseReleased(n, n2, n3);
        Class8.Field5278.Method462();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        Class8.Field5278.Method4810(n, n2, n3);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        ScaledResolution scaledResolution = new ScaledResolution(this.mc);
        Class8.Field5278.Method7302(scaledResolution, n, n2, true);
    }
}

