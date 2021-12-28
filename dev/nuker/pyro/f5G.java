/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.gui.ScaledResolution
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.f5T;
import dev.nuker.pyro.f5w;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5G
extends f5T {
    @NotNull
    public String Field4133;
    @Nullable
    public String Field4134;
    public int Field4135;
    public f5w Field4136;

    public void Method4800(@NotNull String string) {
        this.Field4133 = string;
    }

    @NotNull
    public String Method5782() {
        return this.Field4133;
    }

    @Nullable
    public String Method5783() {
        return this.Field4134;
    }

    public void Method5736(@Nullable String string) {
        this.Field4134 = string;
    }

    public void Method2377(int n) {
        this.Field4135 = n;
    }

    @Override
    public int Method4968(@Nullable ScaledResolution scaledResolution, float f, float f2) {
        return this.Field4136.Method4948(this);
    }

    public int Method5742() {
        return this.Field4135;
    }

    @Override
    @NotNull
    public String Method4969() {
        return this.Field4133 + (Object)ChatFormatting.GRAY + (this.Field4134 == null ? "" : ' ' + this.Field4134);
    }

    public f5G(@NotNull String string, @Nullable String string2, int n, @NotNull f5w f5w2) {
        super("");
        this.Field4133 = string;
        this.Field4134 = string2;
        this.Field4135 = n;
        this.Field4136 = f5w2;
    }
}

