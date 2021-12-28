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
import dev.nuker.pyro.f5q;
import dev.nuker.pyro.f5t;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5T
extends f5q {
    @Override
    public float Method4871() {
        return this.Method4969() == null ? 0.0f : PyroRenderUtil.Method12314(this.Method4969()) + (float)3;
    }

    public int Method4968(@Nullable ScaledResolution scaledResolution, float f, float f2) {
        throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
    }

    @Nullable
    public String Method4969() {
        throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
    }

    public f5T(@NotNull String string) {
        super(string, null, 2, null);
    }

    @Override
    public void Method4875(@Nullable f5t f5t2, int n, @Nullable ScaledResolution scaledResolution, float f, float f2) {
        String string = this.Method4969();
        GlStateManager.translate((float)2.0f, (float)2.0f, (float)0.0f);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        if (string != null) {
            PyroRenderUtil.Method12313(string, 0.0f, 0.0f, this.Method4968(scaledResolution, f, f2));
        }
    }

    @Override
    public float Method4873() {
        return PyroRenderUtil.Method740();
    }
}

