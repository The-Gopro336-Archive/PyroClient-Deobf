/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f0w;
import dev.nuker.pyro.gui.ClickGui;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class fbb
implements Consumer {
    public static fbb Field2049 = new fbb();

    public void Method374(@NotNull f0w f0w2) {
        ClickGui.Field2428.Method8969();
        f0H.Field5478 = ((Number)f0w2.Method7979()).doubleValue();
    }

    public void accept(Object object) {
        this.Method374((f0w)object);
    }
}

