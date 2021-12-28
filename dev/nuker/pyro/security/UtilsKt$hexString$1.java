/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro.security;

import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

public class UtilsKt$hexString$1
extends Lambda
implements Function1 {
    public static UtilsKt$hexString$1 Field3792 = new UtilsKt$hexString$1();

    public Object Method41(Object object) {
        return this.Method5506(((Number)object).byteValue());
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public String Method5506(byte by) {
        void it;
        String string = "%02x";
        Object[] arrobject = new Object[]{(byte)it};
        boolean bl = false;
        return String.format(string, Arrays.copyOf(arrobject, arrobject.length));
    }

    public UtilsKt$hexString$1() {
        super(1);
    }
}

