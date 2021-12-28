/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f5h;
import dev.nuker.pyro.f5i;
import dev.nuker.pyro.f5j;
import dev.nuker.pyro.f5q;
import dev.nuker.pyro.f5t;
import dev.nuker.pyro.fdZ;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5H
extends f5q {
    @NotNull
    public f5h[] Field4160 = new f5h[]{null, null, null, null};

    @NotNull
    public f5h[] Method5799() {
        return this.Field4160;
    }

    @Override
    public boolean Method4872() {
        return false;
    }

    public f5H() {
        super("Notifications", null, 2, null);
    }

    @Override
    public float Method4873() {
        return 40.0f;
    }

    @Override
    public float Method4871() {
        return 160.0f;
    }

    public void Method5800(@NotNull f5h[] arrf5h) {
        this.Field4160 = arrf5h;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void Method5801(f5h f5h2, int n) {
        f5h f5h3 = f5h2;
        if (f5h3 == null) {
            Intrinsics.Method6551();
        }
        int n2 = f5h3.Method4882();
        int n3 = f5h2.Method4880();
        if (n2 == 0) {
            f5h2.Method4883(n3 + 1);
        }
        if (n2 > 0 && n3 < 300) {
            f5h2.Method4879(n2 - 2);
        } else if (n3 >= 300) {
            if ((float)n2 < this.Method4871()) {
                f5h2.Method4879(n2 + 3);
            } else {
                f5h2.Method4883(n3 + 1);
                if (n3 >= 330) {
                    f5i.Method4887().Field3004.remove(f5h2);
                }
            }
        }
        int n4 = 8;
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)n2, (float)n, (float)0.0f);
        PyroRenderUtil.Method12316(0.0f, 0.0f, this.Method4871(), this.Method4873(), -1728053248);
        PyroRenderUtil.Method12316(0.0f, 0.0f, n4, this.Method4873(), f5h2.Method4881());
        GlStateManager.pushMatrix();
        GlStateManager.scale((double)1.1, (double)1.1, (double)1.1);
        PyroRenderUtil.Method12313(f5h2.Method4884(), (float)n4 + (float)2, 4.0f, -1);
        GlStateManager.popMatrix();
        PyroRenderUtil.Method12313(f5h2.Method4878(), (float)n4 + (float)4, 18.0f, -1);
        GlStateManager.popMatrix();
    }

    @Override
    public void Method4875(@Nullable f5t f5t2, int n, @Nullable ScaledResolution scaledResolution, float f, float f2) {
        if (fdZ.Field313.world == null || fdZ.Field313.player == null) {
            f5i.Method4887().Field3004.clear();
            return;
        }
        if (fdZ.Field313.currentScreen instanceof f5j) {
            PyroRenderUtil.Method12316(0.0f, 0.0f, this.Method4871(), this.Method4873(), -1728053248);
            PyroRenderUtil.Method12316(0.0f, 0.0f, 8.0f, this.Method4873(), -1234904);
            GlStateManager.pushMatrix();
            GlStateManager.scale((double)1.1, (double)1.1, (double)1.1);
            PyroRenderUtil.Method12313("Notifications", 10.0f, 4.0f, -1);
            GlStateManager.popMatrix();
            PyroRenderUtil.Method12313("This is an example!", 12.0f, 18.0f, -1);
            return;
        }
        int n2 = this.Field4160.length;
        for (int i = 0; i < n2; ++i) {
            if (f5i.Method4887().Field3004.size() < i + 1) continue;
            if (f5i.Method4887().Field3004.size() >= i + 1) {
                this.Field4160[i] = f5i.Method4887().Field3004.get(i);
            }
            int n3 = (int)(this.Method4873() * (float)i + (float)(6 * i));
            if (this.Field4160[i] == null) continue;
            this.Method5801(this.Field4160[i], n3);
        }
    }
}

