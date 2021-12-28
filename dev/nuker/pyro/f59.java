/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f0z;
import dev.nuker.pyro.f4Z;
import dev.nuker.pyro.f58;

public class f59
extends f58 {
    public Object[] Field4115;
    public f4Z Field4116;
    public f0z Field4117;

    @Override
    public boolean Method4797(float f, float f2, float f3) {
        PyroRenderUtil.Method12316(this.Method4828() + 3.0f, this.Method4906() - 1.0f, -this.Method4828() + this.Method5094() - 2.0f, this.Method4906() + this.Method4908() - 3.0f, f0H.Field5479.Method7719());
        PyroRenderUtil.Method12313(this.Method4820(), this.Method4828() + 5.0f, this.Method4906(), f0H.Field5479.Method7708());
        PyroRenderUtil.Method12313("...", -this.Method4828() + this.Method5094() - this.Method5734("...") - 1.0f, this.Method4906(), f0H.Field5479.Method7708());
        return true;
    }

    @Override
    public String Method4820() {
        f0o f0o2 = (f0o)this.Field4111;
        return f0o2.Method5989() + " " + f0o2.Method7979();
    }

    public f59(f0z f0z2, f0o f0o2, float f, float f2, f4Z f4Z2) {
        super(f0o2, f, f2);
        this.Field4117 = f0z2;
        if (f0o2.Method7979().getClass().getEnumConstants() != null) {
            this.Field4115 = f0o2.Method7979().getClass().getEnumConstants();
        }
        this.Field4116 = f4Z2;
    }

    @Override
    public void Method4796(int n, int n2, int n3) {
        super.Method4796(n, n2, n3);
        if (n3 == 0) {
            f0o f0o2 = (f0o)this.Field4111;
            int n4 = -1;
            for (int i = 0; i < this.Field4115.length - 1; ++i) {
                if (this.Field4115[i] != f0o2.Method7979()) continue;
                n4 = i;
                break;
            }
            if (n4 >= this.Field4115.length - 1) {
                n4 = -1;
            }
            f0o2.Method7975(this.Field4115[++n4]);
            this.Field4116.Method455();
        } else if (n3 == 1) {
            if (!this.Method5737().isEmpty()) {
                this.Field4117.Method7989().Method5266(!this.Method5739());
                this.Method4824(!this.Method5739());
            }
        }
    }
}

