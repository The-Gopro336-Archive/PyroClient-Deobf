/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  baritone.api.Settings$Setting
 */
package dev.nuker.pyro;

import baritone.api.Settings;
import dev.nuker.pyro.Class57;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public class f98
extends Class57 {
    public A Field3462;
    public B Field3463;
    public Settings.Setting Field3464;
    public Function1 Field3465;
    public Function1 Field3466;

    @Override
    public void Method5263() {
        this.Method5266(this.Field3462);
    }

    @Override
    public Object Method5264() {
        if (Intrinsics.Method6572(this.Field3463, this.Field3464.value) ^ true) {
            this.Field3462 = this.Field3466.Method41(this.Field3464.value);
            this.Field3463 = this.Field3464.value;
        }
        return this.Field3462;
    }

    public void Method5265(Object object) {
        this.Field3463 = object;
    }

    @Override
    public void Method5266(Object object) {
        this.Field3464.value = this.Field3465.Method41(object);
    }

    public void Method5267(Object object) {
        this.Field3462 = object;
    }

    public Object Method5268() {
        return this.Field3462;
    }

    public f98(Settings.Setting setting, Function1 function1, Function1 function12) {
        this.Field3464 = setting;
        this.Field3465 = function1;
        this.Field3466 = function12;
        this.Field3462 = function12.Method41(setting.value);
        this.Field3463 = setting.value;
    }

    public Object Method5269() {
        return this.Field3463;
    }
}

