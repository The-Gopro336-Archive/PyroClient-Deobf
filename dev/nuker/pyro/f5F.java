/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f5E;
import dev.nuker.pyro.f5q;
import dev.nuker.pyro.f5t;
import dev.nuker.pyro.fdZ;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5F
extends f5q {
    @NotNull
    public f5E[] Field4128;

    @Override
    public boolean Method4872() {
        return false;
    }

    @Override
    public float Method4873() {
        return 100.0f;
    }

    public void Method5778(@NotNull f5E[] arrf5E) {
        this.Field4128 = arrf5E;
    }

    @Override
    public float Method4871() {
        return 100.0f;
    }

    @Override
    public void Method4875(@Nullable f5t f5t2, int n, @Nullable ScaledResolution scaledResolution, float f, float f2) {
        f5E[] arrf5E = this.Field4128;
        boolean bl = false;
        f5E[] arrf5E2 = arrf5E;
        int n2 = arrf5E2.length;
        for (int i = 0; i < n2; ++i) {
            f5E f5E2;
            f5E f5E3 = f5E2 = arrf5E2[i];
            boolean bl2 = false;
            f5E3.Method5766();
        }
    }

    @NotNull
    public f5E[] Method5779() {
        return this.Field4128;
    }

    public f5F() {
        super("keystrokes", null, 2, null);
        f5E[] arrf5E = new f5E[5];
        arrf5E[0] = new f5E(fdZ.Field313.gameSettings.keyBindForward, 50.0f, 50.0f, 55.0f, 0.0f);
        arrf5E[1] = new f5E(fdZ.Field313.gameSettings.keyBindLeft, 50.0f, 50.0f, 0.0f, 55.0f);
        arrf5E[2] = new f5E(fdZ.Field313.gameSettings.keyBindBack, 50.0f, 50.0f, 55.0f, 55.0f);
        arrf5E[3] = new f5E(fdZ.Field313.gameSettings.keyBindRight, 50.0f, 50.0f, 110.0f, 55.0f);
        arrf5E[4] = new f5E(fdZ.Field313.gameSettings.keyBindJump, 160.0f, 50.0f, 0.0f, 110.0f);
        this.Field4128 = arrf5E;
    }
}

