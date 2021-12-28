/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro.layer;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

public class DownloadLayer$run$1
extends Lambda
implements Function0 {
    public Ref.BooleanRef Field4022;
    public Ref.ObjectRef Field4023;
    public Ref.ObjectRef Field4024;

    public void Method3860() {
        this.Field4022.Field4235 = true;
        this.Field4023.Field5552 = null;
        this.Field4024.Field5552 = null;
    }

    public Object Method945() {
        this.Method3860();
        return Unit.Field4531;
    }

    public DownloadLayer$run$1(Ref.BooleanRef booleanRef, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
        this.Field4022 = booleanRef;
        this.Field4023 = objectRef;
        this.Field4024 = objectRef2;
        super(0);
    }
}

