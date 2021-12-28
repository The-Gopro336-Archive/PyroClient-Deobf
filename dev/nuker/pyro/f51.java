/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f4Q;
import dev.nuker.pyro.f58;

public class f51
extends f4Q {
    public f58 Field4081;

    @Override
    public boolean Method4797(float f, float f2, float f3) {
        PyroRenderUtil.Method12313(this.Method4820(), this.Method4828() + 5.0f, this.Method4906(), f0H.Field5479.Method7708());
        return false;
    }

    @Override
    public void Method4796(int n, int n2, int n3) {
        super.Method4796(n, n2, n3);
        if (n3 == 0) {
            this.Field4081.Method5753().Method7975(this.Field4081.Method5753().Method7966());
        }
    }

    public f51(f58 f582) {
        super("Defaults", 0.0f, 0.0f, 115.0f, PyroRenderUtil.Method740() + 2.0f);
        this.Field4081 = f582;
    }
}

