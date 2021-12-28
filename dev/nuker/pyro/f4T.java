/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f4Q;

public class f4T
extends f4Q {
    public boolean Field4060;
    public float Field4061;
    public float Field4062;
    public float Field4063;
    public float Field4064;

    public float Method740() {
        return this.Field4062;
    }

    @Override
    public boolean Method4797(float f, float f2, float f3) {
        if (this.Field4060) {
            this.Method4910(f + this.Method4828() - this.Field4063);
            this.Method4903(f2 + this.Method4906() - this.Field4064);
        }
        if (this.Field4061 > 0.0f) {
            this.Field4061 -= 10.0f;
            if (this.Field4061 <= 0.0f) {
                this.Field4061 = 0.0f;
                this.Method4824(!this.Method5739());
            }
        }
        return super.Method4797(f, f2, f3);
    }

    public void Method5710(float f) {
        this.Field4062 = f;
    }

    @Override
    public void Method4810(int n, int n2, int n3) {
        super.Method4810(n, n2, n3);
        this.Field4060 = false;
    }

    public f4T(String string, float f, float f2, float f3, float f4, float f5) {
        super(string, f, f2, f3, f4);
        this.Field4062 = f5;
    }

    @Override
    public void Method4796(int n, int n2, int n3) {
        super.Method4796(n, n2, n3);
        double d = f0H.Field5479.Method7706();
        float f = (float)((double)((float)n - this.Method4828()) / d);
        float f2 = (float)((double)((float)n2 - this.Method4906()) / d);
        if (f >= 0.0f && f <= this.Method5094() && f2 >= 0.0f) {
            if ((double)f2 < (double)this.Field4062 * d) {
                if (n3 == 0) {
                    this.Field4060 = true;
                    this.Field4063 = f;
                    this.Field4064 = f2;
                } else if (n3 == 1) {
                    this.Field4061 = this.Method4908();
                }
            }
        }
    }
}

