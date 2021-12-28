/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f55;
import dev.nuker.pyro.f58;

public class f54
extends f58 {
    public f55 Field4053;
    public Object Field4054;
    public boolean Field4055;
    public f55 Field4056;

    @Override
    public boolean Method4797(float f, float f2, float f3) {
        if (this.Field4055) {
            PyroRenderUtil.Method12316(this.Method4828() + 3.0f, this.Method4906() - 2.0f, -this.Method4828() + this.Method5094() - 2.0f, this.Method4906() + this.Method4908() - 3.0f, f0H.Field5479.Method7719());
        }
        PyroRenderUtil.Method12313(this.Method4820(), this.Method4828() + 5.0f, this.Method4906(), -1);
        return false;
    }

    public boolean Method4832() {
        return this.Field4055;
    }

    @Override
    public void Method4796(int n, int n2, int n3) {
        super.Method4796(n, n2, n3);
        if (n3 == 0) {
            this.Field4053.Method5711(this);
        } else if (n3 == 1 && !this.Method5737().isEmpty()) {
            this.Method4824(!this.Method5739());
        }
    }

    public f54(f55 f552, f55 f553, Object object, float f, float f2) {
        this.Field4056 = f552;
        super(f553.Method5753(), f, f2);
        this.Field4053 = f553;
        this.Field4054 = object;
    }

    public Object Method5706() {
        return this.Field4054;
    }

    @Override
    public String Method4820() {
        return String.valueOf(this.Field4054);
    }

    public void Method5707(boolean bl) {
        this.Field4055 = bl;
    }
}

