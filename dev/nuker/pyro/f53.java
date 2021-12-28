/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f0n;
import dev.nuker.pyro.f0w;
import dev.nuker.pyro.f58;

public class f53
extends f58 {
    @Override
    public void Method4796(int n, int n2, int n3) {
        super.Method4796(n, n2, n3);
        if (n3 == 1) {
            if (!this.Method5737().isEmpty()) {
                this.Method4824(!this.Method5739());
            }
        }
    }

    @Override
    public String Method4820() {
        return ((f0n)this.Field4111).Method5989();
    }

    public f53(f0w f0w2, float f, float f2) {
        super(f0w2, f, f2);
    }

    @Override
    public boolean Method4797(float f, float f2, float f3) {
        PyroRenderUtil.Method12316(this.Method4828() + 3.0f, this.Method4906() - 2.0f, -this.Method4828() + this.Method5094() - 2.0f, this.Method4906() + this.Method4908() - 3.0f, f0H.Field5479.Method7719());
        PyroRenderUtil.Method12313(this.Method4820(), this.Method4828() + 5.0f, this.Method4906(), f0H.Field5479.Method7708());
        if (!this.Method5737().isEmpty()) {
            if (!this.Method5739()) {
                PyroRenderUtil.Method12313("...", -this.Method4828() + this.Method5094() - this.Method5734("...") - 1.0f, this.Method4906(), f0H.Field5479.Method7708());
            } else {
                float f4 = this.Method5734(".");
                float f5 = -5.0f;
                for (int i = 0; i < 3; ++i) {
                    PyroRenderUtil.Method12313(".", -this.Method4828() + this.Method5094() - f4 - 1.0f, this.Method4906() + f5, f0H.Field5479.Method7708());
                    f5 += 3.0f;
                }
            }
        }
        return false;
    }
}

