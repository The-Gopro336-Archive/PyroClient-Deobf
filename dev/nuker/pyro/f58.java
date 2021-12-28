/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f0w;
import dev.nuker.pyro.f4Q;

public class f58
extends f4Q {
    public T Field4111;

    public f58(f0w f0w2, float f, float f2) {
        super(f0w2.Method7977(), 0.0f, 0.0f, f, f2);
        this.Field4111 = f0w2;
        this.Method5736(f0w2.Method7969());
    }

    public f0w Method5753() {
        return this.Field4111;
    }

    @Override
    public boolean Method4797(float f, float f2, float f3) {
        PyroRenderUtil.Method12313(this.Method4820(), this.Method4828() + 4.0f, this.Method4906(), f0H.Field5479.Method7708());
        return super.Method4797(f, f2, f3);
    }
}

