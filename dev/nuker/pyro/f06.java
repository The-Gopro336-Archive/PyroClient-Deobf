/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Timer
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import net.minecraft.util.Timer;
import org.jetbrains.annotations.NotNull;

public class f06 {
    @NotNull
    public Timer Field5460;

    public void Method7607() {
        throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
    }

    @NotNull
    public Timer Method7683() {
        return this.Field5460;
    }

    public void Method7684(@NotNull Timer timer) {
        this.Field5460 = timer;
    }

    public f06(float f) {
        this.Field5460 = new Timer(f);
    }
}

