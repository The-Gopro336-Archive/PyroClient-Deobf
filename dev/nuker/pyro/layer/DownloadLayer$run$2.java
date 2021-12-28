/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro.layer;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

public class DownloadLayer$run$2
extends Lambda
implements Function2 {
    public Ref.BooleanRef Field4034;
    public Ref.ObjectRef Field4035;
    public Ref.ObjectRef Field4036;

    public DownloadLayer$run$2(Ref.BooleanRef booleanRef, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
        this.Field4034 = booleanRef;
        this.Field4035 = objectRef;
        this.Field4036 = objectRef2;
        super(2);
    }

    /*
     * WARNING - void declaration
     */
    public void Method5695(@NotNull String string, @NotNull String string2) {
        void version;
        void channel;
        this.Field4034.Field4235 = false;
        this.Field4035.Field5552 = channel;
        this.Field4036.Field5552 = version;
    }

    public Object Method943(Object object, Object object2) {
        this.Method5695((String)object, (String)object2);
        return Unit.Field4531;
    }
}

