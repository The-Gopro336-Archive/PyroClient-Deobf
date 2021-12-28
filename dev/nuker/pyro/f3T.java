/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f3U;
import dev.nuker.pyro.f3V;
import dev.nuker.pyro.f3W;
import dev.nuker.pyro.f3X;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

public class f3T {
    @NotNull
    public static List<Pair<Class<?>, f3X>> Field3899;
    public static f3T Field3900;

    static {
        f3T f3T2;
        Field3900 = f3T2 = new f3T();
        Field3899 = CollectionsKt.Method1014(TuplesKt.Method2826(Boolean.TYPE, f3U.Field3903), TuplesKt.Method2826(Integer.TYPE, f3V.Field3941), TuplesKt.Method2826(String.class, f3W.Field3944));
    }

    @NotNull
    public List Method5599() {
        return Field3899;
    }
}

