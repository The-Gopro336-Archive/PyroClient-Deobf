/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

public class f8C
extends Lambda
implements Function1 {
    public Ref.ObjectRef Field3396;

    public Object Method41(Object object) {
        this.Method5206((String)object);
        return Unit.Field4531;
    }

    public void Method5206(@NotNull String string) {
        ((ArrayList)this.Field3396.Field5552).add(string);
    }

    public f8C(Ref.ObjectRef objectRef) {
        this.Field3396 = objectRef;
        super(1);
    }
}

