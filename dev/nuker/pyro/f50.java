/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f0l;
import dev.nuker.pyro.f0w;
import dev.nuker.pyro.f58;
import dev.nuker.pyro.f5a;

public class f50
extends f58 {
    public f50(f0w f0w2, float f, float f2) {
        super(f0w2, f, f2);
        this.Field4088.add(new f5a((f0l)f0w2, f));
    }

    @Override
    public String Method4820() {
        return ((f0l)this.Field4111).Method5989();
    }

    @Override
    public void Method4796(int n, int n2, int n3) {
        super.Method4796(n, n2, n3);
        if (n3 == 1 && !this.Method5737().isEmpty()) {
            this.Method4824(!this.Method5739());
        }
    }

    @Override
    public boolean Method4797(float f, float f2, float f3) {
        PyroRenderUtil.Method12316(-this.Method4828() + this.Method5094() - 8.0f, this.Method4906() + 1.0f, -this.Method4828() + this.Method5094() - 3.0f, this.Method4906() + this.Method4908() - 6.0f, ((f00)((f0l)this.Field4111).Method7979()).Method7515());
        PyroRenderUtil.Method12313(this.Method4820(), this.Method4828() + 5.0f, this.Method4906(), f0H.Field5479.Method7708());
        return true;
    }
}

