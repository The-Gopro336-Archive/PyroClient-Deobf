/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Class12 {
    @NotNull
    public String Field3006;
    @Nullable
    public String Field3007;

    @Nullable
    public String Method4889() {
        return this.Field3007;
    }

    public Class12(@NotNull String string, @Nullable String string2) {
        this.Field3006 = string;
        this.Field3007 = string2;
    }

    @Nullable
    public String Method4890() {
        return this.Field3007;
    }

    public void Method4891(@NotNull String string) {
        this.Field3006 = string;
    }

    @NotNull
    public String Method4892() {
        return this.Field3006;
    }

    public static Class12 Method4893(Class12 class12, String string, String string2, int n, Object object) {
        if ((n & 1) != 0) {
            string = class12.Field3006;
        }
        if ((n & 2) != 0) {
            string2 = class12.Field3007;
        }
        return class12.Method4895(string, string2);
    }

    @NotNull
    public String toString() {
        return "Friend(name=" + this.Field3006 + ", alias=" + this.Field3007 + ")";
    }

    public void Method4894(@Nullable String string) {
        this.Field3007 = string;
    }

    @NotNull
    public Class12 Method4895(@NotNull String string, @Nullable String string2) {
        return new Class12(string, string2);
    }

    public boolean equals(@Nullable Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof Class12)) break block3;
                Class12 class12 = (Class12)object;
                if (!Intrinsics.Method6572(this.Field3006, class12.Field3006) || !Intrinsics.Method6572(this.Field3007, class12.Field3007)) break block3;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        String string = this.Field3006;
        String string2 = this.Field3007;
        return (string != null ? string.hashCode() : 0) * 31 + (string2 != null ? string2.hashCode() : 0);
    }

    @NotNull
    public String Method4896() {
        return this.Field3006;
    }
}

