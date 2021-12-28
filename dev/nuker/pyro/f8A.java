/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f8a
extends Enum {
    public static /* enum */ f8a Random;
    public static /* enum */ f8a Ordered;
    public static /* synthetic */ f8a[] Field3519;

    public static f8a[] Method5288() {
        return (f8a[])Field3519.clone();
    }

    public static f8a Method5289(String string) {
        return Enum.valueOf(f8a.class, string);
    }

    static {
        f8a[] arrf8a = new f8a[2];
        f8a[] arrf8a2 = arrf8a;
        arrf8a[0] = Random = new f8a("Random", 0);
        arrf8a[1] = Ordered = new f8a("Ordered", 1);
        Field3519 = arrf8a;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f8a() {
        void var2_-1;
        void var1_-1;
    }
}

