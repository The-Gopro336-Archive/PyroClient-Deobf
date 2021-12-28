/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class f8e {
    @NotNull
    public List<String> Field3592;

    public f8e() {
        List list;
        f8e f8e2 = this;
        boolean bl = false;
        f8e2.Field3592 = list = (List)new ArrayList();
    }

    public void Method5366(@NotNull List list) {
        this.Field3592 = list;
    }

    @NotNull
    public List Method5367() {
        return this.Field3592;
    }
}

