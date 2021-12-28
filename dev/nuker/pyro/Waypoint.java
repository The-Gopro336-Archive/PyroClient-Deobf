/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003JA\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010%\u001a\u00020\nH\u00d6\u0001J\t\u0010&\u001a\u00020\u0003H\u00d6\u0001R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017\u00a8\u0006'"}, d2={"Ldev/nuker/pyro/Waypoint;", "", "name", "", "x", "", "y", "z", "dimensions", "", "", "(Ljava/lang/String;DDDLjava/util/List;)V", "getDimensions", "()Ljava/util/List;", "setDimensions", "(Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getX", "()D", "setX", "(D)V", "getY", "setY", "getZ", "setZ", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "pyroclient"})
public final class Waypoint {
    @NotNull
    private String Field6853;
    private double Field6854;
    private double Field6855;
    private double Field6856;
    @NotNull
    private List<Integer> Field6857;

    @NotNull
    public final String Method9897() {
        return this.Field6853;
    }

    public final void Method9898(@NotNull String string) {
        Intrinsics.Method6567(string, "<set-?>");
        this.Field6853 = string;
    }

    public final double Method9899() {
        return this.Field6854;
    }

    public final void Method9900(double d) {
        this.Field6854 = d;
    }

    public final double Method9901() {
        return this.Field6855;
    }

    public final void Method9902(double d) {
        this.Field6855 = d;
    }

    public final double Method9903() {
        return this.Field6856;
    }

    public final void Method9904(double d) {
        this.Field6856 = d;
    }

    @NotNull
    public final List Method9905() {
        return this.Field6857;
    }

    public final void Method9906(@NotNull List list) {
        Intrinsics.Method6567(list, "<set-?>");
        this.Field6857 = list;
    }

    public Waypoint(@NotNull String name, double x, double y, double z, @NotNull List dimensions) {
        Intrinsics.Method6567(name, "name");
        Intrinsics.Method6567(dimensions, "dimensions");
        this.Field6853 = name;
        this.Field6854 = x;
        this.Field6855 = y;
        this.Field6856 = z;
        this.Field6857 = dimensions;
    }

    @NotNull
    public final String Method9907() {
        return this.Field6853;
    }

    public final double Method9908() {
        return this.Field6854;
    }

    public final double Method9909() {
        return this.Field6855;
    }

    public final double Method9910() {
        return this.Field6856;
    }

    @NotNull
    public final List Method9911() {
        return this.Field6857;
    }

    @NotNull
    public final Waypoint Method9912(@NotNull String name, double x, double y, double z, @NotNull List dimensions) {
        Intrinsics.Method6567(name, "name");
        Intrinsics.Method6567(dimensions, "dimensions");
        return new Waypoint(name, x, y, z, dimensions);
    }

    public static /* synthetic */ Waypoint Method9913(Waypoint waypoint, String string, double d, double d2, double d3, List list, int n, Object object) {
        if ((n & 1) != 0) {
            string = waypoint.Field6853;
        }
        if ((n & 2) != 0) {
            d = waypoint.Field6854;
        }
        if ((n & 4) != 0) {
            d2 = waypoint.Field6855;
        }
        if ((n & 8) != 0) {
            d3 = waypoint.Field6856;
        }
        if ((n & 0x10) != 0) {
            list = waypoint.Field6857;
        }
        return waypoint.Method9912(string, d, d2, d3, list);
    }

    @NotNull
    public String toString() {
        return "Waypoint(name=" + this.Field6853 + ", x=" + this.Field6854 + ", y=" + this.Field6855 + ", z=" + this.Field6856 + ", dimensions=" + this.Field6857 + ")";
    }

    public int hashCode() {
        String string = this.Field6853;
        List<Integer> list = this.Field6857;
        return ((((string != null ? string.hashCode() : 0) * 31 + Double.hashCode(this.Field6854)) * 31 + Double.hashCode(this.Field6855)) * 31 + Double.hashCode(this.Field6856)) * 31 + (list != null ? ((Object)list).hashCode() : 0);
    }

    public boolean equals(@Nullable Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof Waypoint)) break block3;
                Waypoint waypoint = (Waypoint)object;
                if (!Intrinsics.Method6572(this.Field6853, waypoint.Field6853) || Double.compare(this.Field6854, waypoint.Field6854) != 0 || Double.compare(this.Field6855, waypoint.Field6855) != 0 || Double.compare(this.Field6856, waypoint.Field6856) != 0 || !Intrinsics.Method6572(this.Field6857, waypoint.Field6857)) break block3;
            }
            return true;
        }
        return false;
    }
}

