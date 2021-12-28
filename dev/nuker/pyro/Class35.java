/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class36;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.gui.ClickGui$Window;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

public class Class35
implements Consumer {
    public Class36 Field4596;

    public void accept(Object object) {
        this.Method6747((ClickGui$Window)object);
    }

    public Class35(Class36 class36) {
        this.Field4596 = class36;
    }

    public void Method6747(@Nullable ClickGui$Window clickGui$Window) {
        for (Module module : this.Field4596.Method6763()) {
            ClickGui$Window clickGui$Window2 = clickGui$Window;
            if (clickGui$Window2 == null) {
                Intrinsics.Method6551();
            }
            module.Method7261(clickGui$Window2);
        }
    }
}

