/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class55;
import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f4Q;

public class f5e
extends f4Q {
    public f5e(String string, float f, float f2, float f3, float f4) {
        super(string, f, f2, f3, f4);
    }

    @Override
    public boolean Method4797(float f, float f2, float f3) {
        PyroRenderUtil.Method12316(this.Method4828(), this.Method4906(), this.Method4828() + this.Method5094(), this.Method4906() + this.Method4908(), this.Method4900() ? -65521 : f0H.Field5479.Method7719());
        Class55.Field4429.Field4431.Method5670(this.Method4820(), this.Method4828() + this.Method5094() / 2.0f, this.Method4906() + 5.0f, -1, true);
        return super.Method4797(f, f2, f3);
    }
}

