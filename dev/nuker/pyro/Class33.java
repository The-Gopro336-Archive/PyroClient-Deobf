/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class36;
import dev.nuker.pyro.Module;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Class33
implements Function {
    public static Class33 Field4580 = new Class33();

    @NotNull
    public Class36 Method6732(@Nullable String string) {
        return new Class36(string, new Module[0]);
    }

    public Object apply(Object object) {
        return this.Method6732((String)object);
    }
}

