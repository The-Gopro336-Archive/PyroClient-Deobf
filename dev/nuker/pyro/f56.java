/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.IntegerSetting;
import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f0w;
import dev.nuker.pyro.f51;
import dev.nuker.pyro.f58;
import dev.nuker.pyro.f5d;

public class f56
extends f58 {
    public boolean Field4068 = false;

    @Override
    public void Method4796(int n, int n2, int n3) {
        super.Method4796(n, n2, n3);
        if (n3 == 0) {
            this.Field4068 = true;
        } else if (n3 == 1 && !this.Method5737().isEmpty()) {
            this.Method4824(!this.Method5739());
        }
    }

    @Override
    public boolean Method4797(float f, float f2, float f3) {
        float f4;
        IntegerSetting integerSetting = (IntegerSetting)this.Field4111;
        int n = integerSetting.Method5966();
        int n2 = integerSetting.Method5968();
        if (this.Field4068) {
            f4 = (f + this.Method4828()) / this.Method5094();
            if (f4 < 0.0f) {
                f4 = 0.0f;
            }
            if (f4 > 1.0f) {
                f4 = 1.0f;
            }
            int n3 = (int)Math.max((float)n2, f4 * (float)n);
            integerSetting.Method7975(n3);
        }
        f4 = (float)Math.max((Integer)integerSetting.Method7979() - n2, 0) / (float)(n - n2);
        f4 = Math.min(1.0f, f4);
        PyroRenderUtil.Method12316(this.Method4828() + 3.0f, this.Method4906() - 2.0f, -this.Method4828() + this.Method5094() * f4 - 2.0f, this.Method4906() + this.Method4908() - 3.0f, f0H.Field5479.Method7719());
        PyroRenderUtil.Method12313(this.Method4820(), this.Method4828() + 5.0f, this.Method4906(), f0H.Field5479.Method7708());
        if (!this.Method5737().isEmpty()) {
            if (!this.Method5739()) {
                PyroRenderUtil.Method12313("...", -this.Method4828() + this.Method5094() - this.Method5734("...") - 1.0f, this.Method4906(), f0H.Field5479.Method7708());
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

    @Override
    public String Method4820() {
        IntegerSetting integerSetting = (IntegerSetting)this.Field4111;
        return integerSetting.Method5989() + " " + integerSetting.Method7979();
    }

    public f56(f0w f0w2, float f, float f2) {
        super(f0w2, f, f2);
        IntegerSetting integerSetting = (IntegerSetting)f0w2;
        this.Method5737().add(new f5d(this, integerSetting.Method5989(), f, f2));
        this.Method5737().add(new f51(this));
        String string = this.Method5738();
        string = string != null ? string + "\nThis option can be right clicked inorder to change it's exact value!" : "This option can be right clicked inorder to change it's exact value!";
        this.Method5736(string);
    }

    @Override
    public void Method4810(int n, int n2, int n3) {
        super.Method4810(n, n2, n3);
        this.Field4068 = false;
    }
}

