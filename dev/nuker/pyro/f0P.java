/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class56;
import dev.nuker.pyro.IntegerSetting;
import dev.nuker.pyro.f0R;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;

public class f0P
implements Consumer {
    public f0R Field5506;
    public IntegerSetting Field5507;

    public void accept(Object object) {
        this.Method4838((Double)object);
    }

    public void Method4838(Double d) {
        this.Field5507.Method7975((int)d.doubleValue());
        if (!this.Field5506.Method7835()) {
            Class56 class56 = this.Field5506.Method7870();
            if (class56 == null) {
                Intrinsics.Method6551();
            }
            class56.Method5266((int)d.doubleValue());
        }
        this.Field5506.Method7833(false);
    }

    public f0P(f0R f0R2, IntegerSetting integerSetting) {
        this.Field5506 = f0R2;
        this.Field5507 = integerSetting;
    }
}

