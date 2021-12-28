/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Module;
import org.jetbrains.annotations.NotNull;

public class f7e
extends Module {
    @NotNull
    public BooleanSetting Field3412 = (BooleanSetting)this.Method7264(new BooleanSetting("pickaxeOnly", "Pickaxe Only", null, true));

    public f7e() {
        super("nominingtrace", "NoMiningTrace", "Ignores entity collision when holding a pickaxe");
    }

    @NotNull
    public BooleanSetting Method215() {
        return this.Field3412;
    }
}

