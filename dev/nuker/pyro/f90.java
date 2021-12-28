/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f00;
import java.awt.Color;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

public class f90
extends Lambda
implements Function1 {
    public static f90 Field3422 = new f90();

    @NotNull
    public f00 Method5220(Color color) {
        return f00.Field5379.Method7937(color);
    }

    public f90() {
        super(1);
    }

    public Object Method41(Object object) {
        return this.Method5220((Color)object);
    }
}

