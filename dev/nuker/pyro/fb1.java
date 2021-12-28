/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f0w;
import dev.nuker.pyro.fb2;
import dev.nuker.pyro.fb3;
import dev.nuker.pyro.fb4;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class fb1
implements Consumer {
    public fb4 Field1686;

    public void accept(Object object) {
        this.Method374((f0w)object);
    }

    public fb1(fb4 fb42) {
        this.Field1686 = fb42;
    }

    public void Method374(@NotNull f0w f0w2) {
        if (((Boolean)this.Field1686.Field5236.Method5264()).booleanValue()) {
            switch (fb3.Field1695[((fb2)((Object)f0w2.Method7979())).ordinal()]) {
                case 1: {
                    this.Field1686.Method2399(false);
                    this.Field1686.Method2406(true);
                    break;
                }
                case 2: {
                    this.Field1686.Method2406(false);
                    this.Field1686.Method2399(true);
                    break;
                }
            }
        }
    }
}

