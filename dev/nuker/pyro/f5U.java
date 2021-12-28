/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class8;
import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f5j;
import dev.nuker.pyro.f5k;
import dev.nuker.pyro.f5l;
import dev.nuker.pyro.f5q;
import dev.nuker.pyro.f5s;
import dev.nuker.pyro.f5t;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

public class f5u
extends f5k {
    public static int Field3050;
    public static int Field3051;
    public float Field3052;
    public float Field3053;
    public f5t Field3054;
    public boolean Field3055;
    public boolean Field3056;
    public boolean Field3057;
    public ScaledResolution Field3058 = null;

    public void Method4935(double d, double d2, double d3, double d4) {
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        PyroRenderUtil.Method12301(d, d2, d3, d4, 4.0f);
        GlStateManager.color((float)0.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        PyroRenderUtil.Method12301(d, d2, d3, d4, 2.0f);
    }

    @Override
    public void Method4904(ScaledResolution scaledResolution, int n, int n2) {
        this.Field3058 = scaledResolution;
        if (this.Field3055) {
            this.Field3056 = true;
            this.Method4938(n, n2);
            float f = (float)n - this.Field3052;
            float f2 = (float)n2 - this.Field3053;
            this.Method4903(Math.min(Math.max(0.0f, f), (float)scaledResolution.getScaledWidth() - this.Method740()));
            this.Method4910(Math.min(Math.max(0.0f, f2), (float)scaledResolution.getScaledHeight() - this.Method730()));
            if (this.Field3054 != null) {
                GlStateManager.color((float)0.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                double d = f + (this.Field3054.Field3033 == -1 ? 2.0f : (this.Field3054.Field3033 == 0 ? this.Method740() / 2.0f : this.Method740() - 2.0f));
                double d2 = f2 + (this.Field3054.Field3034 == -1 ? 2.0f : (this.Field3054.Field3034 == 0 ? this.Method730() / 2.0f : this.Method730() - 2.0f));
                switch (this.Field3054.Field3033) {
                    case -1: {
                        this.Method4935(0.0, d2, f, d2);
                        break;
                    }
                    case 1: {
                        this.Method4935(scaledResolution.getScaledWidth(), d2, f + this.Method740(), d2);
                        break;
                    }
                }
                switch (this.Field3054.Field3034) {
                    case -1: {
                        this.Method4935(d, 0.0, d, f2);
                        break;
                    }
                    case 1: {
                        this.Method4935(d, scaledResolution.getScaledHeight(), d, f2 + this.Method730());
                        break;
                    }
                }
            }
        } else if (this.Field3056) {
            this.Field3056 = false;
            Class8.Field5278.Method7321();
        }
        if (((Boolean)PyroStatic.Field6420.Method215().Method7979()).booleanValue() && (this.Field3010.Method4872() || f5u.Field313.currentScreen instanceof f5j)) {
            PyroRenderUtil.Method12316(this.Method4906(), this.Method4898(), this.Method4906() + this.Method740(), this.Method4898() + this.Method730(), this.Method4907() ? 1963986960 : 1979645952);
        }
        if (this.Method4937(n, n2)) {
            if (this.Field3010.Method4874()) {
                PyroRenderUtil.Method12316(this.Method4906(), this.Method4898(), this.Method4906() + this.Method740(), this.Method4898() + this.Method730(), 1345864260);
            }
        }
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)this.Method4906(), (float)this.Method4898(), (float)0.0f);
        this.Field3010.Method4875(this.Field3054, this.Method4906() + this.Method740() / 2.0f > (float)this.Field3058.getScaledWidth() / 2.0f ? (this.Method4898() + this.Method730() / 2.0f > (float)this.Field3058.getScaledHeight() / 2.0f ? 1 : 0) : (this.Method4898() + this.Method730() / 2.0f > (float)this.Field3058.getScaledHeight() / 2.0f ? 2 : 3), scaledResolution, (float)n - this.Method4906(), (float)n2 - this.Method4898());
        GlStateManager.popMatrix();
        if (this.Method4937(n, n2)) {
            if (!this.Field3010.Method4874()) {
                PyroRenderUtil.Method12316(this.Method4906(), this.Method4898(), this.Method4906() + this.Method740(), this.Method4898() + this.Method730(), 1345864260);
            }
            this.Field3057 = true;
        } else {
            this.Field3057 = false;
        }
    }

    @Override
    public void Method4824(boolean bl) {
        super.Method4824(bl);
    }

    @Override
    public void Method4899(ScaledResolution scaledResolution) {
        if (this.Field3055) {
            this.Field3055 = false;
            this.Field3057 = false;
            this.Method4903(this.Field3054 == null ? super.Method4906() : this.Field3054.Method4924(super.Method4906(), this.Method740(), this.Field3058.getScaledWidth()));
            this.Method4910(this.Field3054 == null ? super.Method4898() : this.Field3054.Method4925(super.Method4898(), this.Method730(), this.Field3058.getScaledHeight()));
            if (this.Field3054 != null) {
                switch (f5s.Field3106[this.Field3054.ordinal()]) {
                    case 1: {
                        Class8.Field5278.Method7309(this, 3);
                        break;
                    }
                    case 2: {
                        Class8.Field5278.Method7309(this, 0);
                        break;
                    }
                    case 3: {
                        Class8.Field5278.Method7309(this, 2);
                        break;
                    }
                    case 4: {
                        Class8.Field5278.Method7309(this, 1);
                        break;
                    }
                }
            }
        }
    }

    public void Method4936(boolean bl) {
        this.Field3055 = bl;
        if (bl) {
            Class8.Field5278.Method7314(this);
        }
    }

    public void Method455() {
    }

    public boolean Method4937(int n, int n2) {
        return (float)n >= this.Method4906() && (float)n < this.Method4906() + this.Method740() && (float)n2 >= this.Method4898() && (float)n2 < this.Method4898() + this.Method730();
    }

    public f5u(String string, String string2, f5q f5q2, boolean bl) {
        super(string, string2, f5q2, f5l.Single, !bl);
    }

    public void Method4938(int n, int n2) {
        boolean bl;
        if (this.Field3058 != null && !(bl = false)) {
            f5t f5t2 = f5t.Method4922((float)n - this.Field3052, (float)n2 - this.Field3053, this.Method740(), this.Method730(), this.Field3058.getScaledWidth(), this.Field3058.getScaledHeight(), 5);
            if (f5t2 != null) {
                this.Field3054 = f5t2;
            } else if (this.Field3054 != null) {
                f5t f5t3 = f5t.Method4922((float)n - this.Field3052, (float)n2 - this.Field3053, this.Method740(), this.Method730(), this.Field3058.getScaledWidth(), this.Field3058.getScaledHeight(), 25);
                this.Field3054 = f5t3 == null ? null : f5t3;
            }
        }
    }

    @Override
    public void Method4810(int n, int n2, int n3) {
        if ((float)n >= this.Method4906()) {
            if ((float)n <= this.Method4906() + this.Method740()) {
                if ((float)n2 >= this.Method4898() && (float)n2 <= this.Method4898() + this.Method730() && !this.Field3010.Method4827(n, n2, n3)) {
                    if (n3 == 0) {
                        if (this.Field3057) {
                            this.Field3055 = true;
                            this.Field3052 = (float)n - this.Method4906();
                            this.Field3053 = (float)n2 - this.Method4898();
                        } else {
                            this.Field3055 = false;
                        }
                    } else if (n3 == 1) {
                        this.Method4824(!this.Method4907());
                    }
                }
            }
        }
    }

    static {
        Field3051 = 25;
        Field3050 = 5;
    }

    public f5u(String string, String string2, f5q f5q2) {
        super(string, string2, f5q2, f5l.Single);
    }
}

