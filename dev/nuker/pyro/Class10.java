/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class31;
import java.util.Collection;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public class Class10 {
    @NotNull
    public Class31 Method4805(@NotNull String string) {
        Class31 class31 = new Class31();
        Collection collection = StringsKt.Method11514(string, new String[]{"\n"}, false, 0, 6, null);
        Class31 class312 = class31;
        boolean bl = false;
        Collection collection2 = collection;
        String[] arrstring = collection2.toArray(new String[0]);
        if (arrstring == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String[] arrstring2 = arrstring;
        class312.Method6726(arrstring2);
        return class31;
    }

    public Class10() {
    }

    public Class10(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

