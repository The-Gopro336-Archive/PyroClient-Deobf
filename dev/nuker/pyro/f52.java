/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f0w;
import dev.nuker.pyro.f51;
import dev.nuker.pyro.f58;
import dev.nuker.pyro.f5d;

public class f52
extends f58 {
    public boolean Field4093 = false;
    public float Field4094 = 0.0f;
    public float Field4095 = 0.0f;

    @Override
    public void Method4810(int n, int n2, int n3) {
        super.Method4810(n, n2, n3);
        this.Field4093 = false;
    }

    @Override
    public void Method4796(int n, int n2, int n3) {
        super.Method4796(n, n2, n3);
        if (n3 == 0) {
            this.Field4093 = true;
            this.Field4094 = n;
            this.Field4095 = (float)((Double)((DoubleSetting)this.Field4111).Method7979()).doubleValue();
        } else if (n3 == 1 && !this.Method5737().isEmpty()) {
            this.Method4824(!this.Method5739());
        }
    }

    @Override
    public String Method4820() {
        DoubleSetting doubleSetting = (DoubleSetting)this.Field4111;
        return String.format("%s %.2f", doubleSetting.Method5989(), Float.valueOf((float)((Double)doubleSetting.Method7979()).doubleValue()));
    }

    public f52(f0w f0w2, float f, float f2) {
        super(f0w2, f, f2);
        DoubleSetting doubleSetting = (DoubleSetting)f0w2;
        this.Method5737().add(new f5d(this, doubleSetting.Method5989(), f, f2));
        this.Method5737().add(new f51(this));
        String string = this.Method5738();
        string = string != null ? string + "\nThis option can be right clicked inorder to change it's exact value!" : "This option can be right clicked inorder to change it's exact value!";
        this.Method5736(string);
    }

    @Override
    public boolean Method4797(float f, float f2, float f3) {
        float f4;
        DoubleSetting doubleSetting = (DoubleSetting)this.Field4111;
        double d = doubleSetting.Method12508();
        double d2 = doubleSetting.Method12511();
        if (this.Field4093) {
            f4 = (f - this.Method4828()) / (this.Method5094() - this.Method4828() * 2.0f);
            if (f4 < 0.0f) {
                f4 = 0.0f;
            }
            if (f4 > 1.0f) {
                f4 = 1.0f;
            }
            double d3 = d + (double)f4 * (d2 - d);
            doubleSetting.Method7975(d3);
        }
        f4 = (float)(((Double)doubleSetting.Method7979() - doubleSetting.Method12508()) / (doubleSetting.Method12511() - doubleSetting.Method12508()));
        PyroRenderUtil.Method12316(this.Method4828() + 3.0f, this.Method4906() - 2.0f, this.Method5094() * f4 - this.Method4828() - 2.0f, this.Method4906() + this.Method4908() - 3.0f, f0H.Field5479.Method7719());
        PyroRenderUtil.Method12313(this.Method4820(), this.Method4828() + 5.0f, this.Method4906(), f0H.Field5479.Method7708());
        if (!this.Method5737().isEmpty()) {
            if (!this.Method5739()) {
                PyroRenderUtil.Method12313("...", this.Method5094() - this.Method4828() - this.Method5734("...") - 1.0f, this.Method4906(), f0H.Field5479.Method7708());
            } else {
                float f5 = this.Method5734(".");
                float f6 = -5.0f;
                for (int i = 0; i < 3; ++i) {
                    PyroRenderUtil.Method12313(".", -this.Method4828() + this.Method5094() - f5 - 1.0f, this.Method4906() + f6, f0H.Field5479.Method7708());
                    f6 += 3.0f;
                }
            }
        }
        return false;
    }
}

