/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class8;
import dev.nuker.pyro.f5l;
import dev.nuker.pyro.f5m;
import dev.nuker.pyro.f5q;
import dev.nuker.pyro.fdZ;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5k
extends fdZ {
    @JvmField
    @NotNull
    public f5q Field3010;
    public float Field3011;
    public float Field3012;
    public float Field3013;
    public float Field3014;
    @JvmField
    public boolean Field3015;
    public boolean Field3016;
    public boolean Field3017;
    public float Field3018;
    @Nullable
    public f5m Field3019;
    @NotNull
    public f5l Field3020;
    public boolean Field3021;
    @JvmField
    @Nullable
    public Runnable Field3022;
    @NotNull
    public String Field3023;
    @NotNull
    public String Field3024;
    @JvmField
    public boolean Field3025;

    public float Method4873() {
        return this.Field3018;
    }

    public f5k(String string, String string2, f5q f5q2, f5l f5l2, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 8) != 0) {
            f5l2 = f5l.Single;
        }
        if ((n & 0x10) != 0) {
            bl = true;
        }
        this(string, string2, f5q2, f5l2, bl);
    }

    public boolean Method4897(float f, boolean bl) {
        boolean bl2;
        float f2 = (float)Minecraft.getDebugFPS() / 60.0f;
        float f3 = 3.0f / f2;
        float f4 = 4.0f / f2;
        if (this.Field3018 != f) {
            if (this.Field3018 == 0.0f && this.Field3021) {
                this.Field3018 = f;
                this.Field3021 = false;
            }
            if (this.Field3018 > f) {
                this.Field3018 -= f4;
                if (this.Field3018 <= f) {
                    this.Field3018 = f;
                }
            } else if (this.Field3018 < f) {
                this.Field3018 += f4;
                if (this.Field3018 >= f) {
                    this.Field3018 = f;
                }
            }
        }
        if (this.Field3015 && bl && this.Field3011 < (float)10) {
            float f5 = f3;
            boolean bl3 = false;
            boolean bl4 = false;
            float f6 = f5;
            boolean bl5 = false;
            this.Field3011 += f6;
            if (this.Field3011 >= (float)10) {
                if (this.Method4907()) {
                    this.Field3017 = true;
                    if (this.Field3022 != null) {
                        Runnable runnable = this.Field3022;
                        if (runnable == null) {
                            Intrinsics.Method6551();
                        }
                        runnable.run();
                    }
                }
                return true;
            }
            return false;
        }
        if (this.Field3016 && bl) {
            if (this.Field3011 > 0.0f) {
                this.Field3011 -= f3;
                this.Field3011 = Math.max(0.0f, this.Field3011);
                bl2 = false;
            } else {
                this.Field3016 = false;
                bl2 = true;
            }
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public float Method730() {
        return this.Field3010.Method4873();
    }

    public float Method4898() {
        return this.Field3014;
    }

    public void Method4899(@Nullable ScaledResolution scaledResolution) {
    }

    public void Method4824(boolean bl) {
        this.Field3025 = bl;
        if (bl) {
            this.Method456();
        }
        Class8.Field5278.Method7321();
    }

    @JvmOverloads
    public f5k(@NotNull String string, @NotNull String string2, @NotNull f5q f5q2, @NotNull f5l f5l2, boolean bl) {
        this.Field3023 = string;
        this.Field3024 = string2;
        this.Field3025 = bl;
        this.Field3021 = true;
        this.Field3016 = true;
        this.Field3020 = f5l2;
        this.Field3010 = f5q2;
        this.Method4824(this.Field3025);
    }

    public boolean Method4900() {
        return this.Field3017;
    }

    public void Method456() {
        this.Field3015 = false;
        this.Field3016 = true;
        this.Field3017 = false;
        this.Field3011 = 10.0f;
    }

    public float Method4901() {
        return this.Field3012;
    }

    public void Method4902(@Nullable f5m f5m2) {
        this.Field3019 = f5m2;
    }

    @JvmOverloads
    public f5k(@NotNull String string, @NotNull String string2, @NotNull f5q f5q2, @NotNull f5l f5l2) {
        this(string, string2, f5q2, f5l2, false, 16, null);
    }

    public void Method4903(float f) {
        this.Field3013 = f;
    }

    public void Method4904(@Nullable ScaledResolution scaledResolution, int n, int n2) {
    }

    @NotNull
    public String Method4905() {
        return this.Field3024;
    }

    public void Method737(float f) {
        this.Field3012 = f;
    }

    public float Method4906() {
        return this.Field3013;
    }

    public boolean Method4907() {
        return this.Field3025;
    }

    public void Method724() {
    }

    @JvmOverloads
    public f5k(@NotNull String string, @NotNull String string2, @NotNull f5q f5q2) {
        this(string, string2, f5q2, null, false, 24, null);
    }

    public float Method4908() {
        return this.Field3011;
    }

    public void Method4909(@NotNull f5l f5l2) {
        this.Field3020 = f5l2;
    }

    public void Method4810(int n, int n2, int n3) {
    }

    public void Method731() {
        this.Field3015 = true;
    }

    public float Method740() {
        return this.Field3010.Method4871();
    }

    public void Method4910(float f) {
        this.Field3014 = f;
    }

    @NotNull
    public String Method4911() {
        return this.Field3023;
    }

    @NotNull
    public f5l Method4912() {
        return this.Field3020;
    }

    public void Method735(float f) {
        this.Field3018 = f;
    }

    public void Method458(float f) {
        this.Field3011 = f;
    }

    @Nullable
    public f5m Method4913() {
        return this.Field3019;
    }
}

