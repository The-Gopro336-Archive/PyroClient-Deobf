/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  dev.nuker.pyro.f55$dev.nuker.pyro.f54
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f0w;
import dev.nuker.pyro.f55;
import dev.nuker.pyro.f58;
import java.util.ArrayList;

public class f55
extends f58 {
    public Object[] Field4065;
    public ArrayList<f54> Field4066 = new ArrayList();

    @Override
    public boolean Method4797(float f, float f2, float f3) {
        PyroRenderUtil.Method12316(this.Method4828() + 3.0f, this.Method4906() - 1.0f, -this.Method4828() + this.Method5094() - 2.0f, this.Method4906() + this.Method4908() - 3.0f, f0H.Field5479.Method7719());
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
        return true;
    }

    public void Method455() {
        this.Method5737().clear();
        f0o f0o2 = (f0o)this.Field4111;
        if (f0o2.Method7979().getClass().getEnumConstants() != null) {
            this.Field4065 = f0o2.Method7979().getClass().getEnumConstants();
            for (Object object : this.Field4065) {
                dev.nuker.pyro.f54 f542 = new dev.nuker.pyro.f54(this, this, object, this.Method5094(), this.Method4908());
                this.Field4088.add(f542);
                this.Field4066.add((f54)f542);
                if (f0o2.Method7979() != object) continue;
                f542.Method5707(true);
            }
        }
    }

    @Override
    public void Method4796(int n, int n2, int n3) {
        super.Method4796(n, n2, n3);
        if (n3 == 0) {
            f0o f0o2 = (f0o)this.Field4111;
            int n4 = -1;
            for (int i = 0; i < this.Field4065.length - 1; ++i) {
                if (this.Field4065[i] != f0o2.Method7979()) continue;
                n4 = i;
                break;
            }
            if (n4 >= this.Field4065.length - 1) {
                n4 = -1;
            }
            f0o2.Method7975(this.Field4065[++n4]);
            this.Method455();
        } else if (n3 == 1) {
            if (!this.Method5737().isEmpty()) {
                this.Method4824(!this.Method5739());
            }
        }
    }

    @Override
    public String Method4820() {
        f0o f0o2 = (f0o)this.Field4111;
        return f0o2.Method5989() + " " + f0o2.Method7979();
    }

    public f55(f0w f0w2, float f, float f2) {
        super(f0w2, f, f2);
        this.Method455();
    }

    public void Method5711(dev.nuker.pyro.f54 f542) {
        this.Field4111.Method7975(f542.Method5706());
        for (dev.nuker.pyro.f54 f543 : this.Field4066) {
            f543.Method5707(false);
        }
        f542.Method5707(true);
    }
}

