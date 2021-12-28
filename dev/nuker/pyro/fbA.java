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

public class fbA {
    @NotNull
    public List<String> Field1757;

    public fbA() {
        List list;
        fbA fbA2 = this;
        boolean bl = false;
        fbA2.Field1757 = list = (List)new ArrayList();
    }

    @NotNull
    public List Method2451() {
        return this.Field1757;
    }

    public void Method2452(@NotNull List list) {
        this.Field1757 = list;
    }
}

