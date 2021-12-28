/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Rotation;
import dev.nuker.pyro.feh;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fer {
    @NotNull
    public feh Field526;
    @NotNull
    public Rotation Field527;

    @NotNull
    public fer Method878(@NotNull feh feh2, @NotNull Rotation rotation) {
        return new fer(feh2, rotation);
    }

    public int hashCode() {
        feh feh2 = this.Field526;
        Rotation rotation = this.Field527;
        return (feh2 != null ? feh2.hashCode() : 0) * 31 + (rotation != null ? ((Object)rotation).hashCode() : 0);
    }

    public static fer Method879(fer fer2, feh feh2, Rotation rotation, int n, Object object) {
        if ((n & 1) != 0) {
            feh2 = fer2.Field526;
        }
        if ((n & 2) != 0) {
            rotation = fer2.Field527;
        }
        return fer2.Method878(feh2, rotation);
    }

    @NotNull
    public Rotation Method880() {
        return this.Field527;
    }

    @NotNull
    public feh Method881() {
        return this.Field526;
    }

    public boolean equals(@Nullable Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof fer)) break block3;
                fer fer2 = (fer)object;
                if (!Intrinsics.Method6572(this.Field526, fer2.Field526)) break block3;
                if (!Intrinsics.Method6572(this.Field527, fer2.Field527)) break block3;
            }
            return true;
        }
        return false;
    }

    public fer(@NotNull feh feh2, @NotNull Rotation rotation) {
        this.Field526 = feh2;
        this.Field527 = rotation;
    }

    @NotNull
    public String toString() {
        return "PlaceRotation(placeInfo=" + this.Field526 + ", rotation=" + this.Field527 + ")";
    }

    @NotNull
    public feh Method882() {
        return this.Field526;
    }

    @NotNull
    public Rotation Method883() {
        return this.Field527;
    }
}

