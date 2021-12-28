/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class34;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0w;
import java.util.function.Consumer;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

public class Class25
implements Consumer {
    public Module Field3254;
    public Ref.BooleanRef Field3255;
    public f0w Field3256;

    public Class25(Module module, Ref.BooleanRef booleanRef, f0w f0w2) {
        this.Field3254 = module;
        this.Field3255 = booleanRef;
        this.Field3256 = f0w2;
    }

    public void Method374(@NotNull f0w f0w2) {
        Class34.Field4599.Method6753(this.Field3254);
    }

    public void accept(Object object) {
        this.Method374((f0w)object);
    }
}

