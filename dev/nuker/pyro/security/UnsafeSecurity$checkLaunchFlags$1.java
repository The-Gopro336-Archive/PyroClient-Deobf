/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro.security;

import java.util.function.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

public class UnsafeSecurity$checkLaunchFlags$1
implements Predicate {
    public String Field7102;

    /*
     * WARNING - void declaration
     */
    public boolean Method11733(@Nullable String string) {
        void s;
        CharSequence charSequence = this.Field7102;
        void v1 = s;
        if (v1 == null) {
            Intrinsics.Method6551();
        }
        return StringsKt.Method11503(charSequence, (CharSequence)v1, false, 2, null);
    }

    public UnsafeSecurity$checkLaunchFlags$1(String string) {
        this.Field7102 = string;
    }

    public boolean test(Object object) {
        return this.Method11733((String)object);
    }
}

