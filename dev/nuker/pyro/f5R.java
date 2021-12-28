/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class55;
import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4e;
import dev.nuker.pyro.f5j;
import dev.nuker.pyro.f5q;
import dev.nuker.pyro.f5t;
import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.fe8;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5R
extends f5q {
    public fe8 Field4205 = new fe8();
    public float Field4206 = 50.0f;

    @Override
    public void Method4875(@Nullable f5t f5t2, int n, @Nullable ScaledResolution scaledResolution, float f, float f2) {
        float f3 = (float)(System.currentTimeMillis() - this.Field4205.Method488()) / 1000.0f % 60.0f;
        if (f3 < (float)2) {
            if (fdZ.Field313.currentScreen instanceof f5j) {
                PyroRenderUtil.Method12313("Server has stopped responding for x seconds..", 0.0f, 0.0f, -1);
            }
            return;
        }
        if (fdZ.Field313.isSingleplayer()) {
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.Field4618;
        String string = "Server has stopped responding for %.2f seconds..";
        Object[] arrobject = new Object[]{Float.valueOf(f3)};
        boolean bl = false;
        String string2 = String.format(string, Arrays.copyOf(arrobject, arrobject.length));
        this.Field4206 = PyroRenderUtil.Method12314(string2);
        Class55.Field4429.Method6335().Method5670(string2, this.Method4871() / (float)2, 0.0f, -1, true);
    }

    public f5R() {
        super("serverNotResponding", null, 2, null);
    }

    @f0g
    @LauncherEventHide
    public void Method493(@NotNull f4e f4e2) {
        if (f4e2.Method5619() == f41.Pre) {
            this.Field4205.Method490();
        }
    }

    @Override
    public float Method4873() {
        return PyroRenderUtil.Method4908();
    }

    @Override
    public float Method4871() {
        return this.Field4206;
    }

    @Override
    public boolean Method4872() {
        return false;
    }
}

