/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f7f
extends Enum {
    public static /* enum */ f7f Tunnel;
    public static /* enum */ f7f Nearby;
    public static /* synthetic */ f7f[] Field3355;

    public static f7f[] Method5185() {
        return (f7f[])Field3355.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f7f() {
        void var2_-1;
        void var1_-1;
    }

    public static f7f Method5186(String string) {
        return Enum.valueOf(f7f.class, string);
    }

    static {
        f7f[] arrf7f = new f7f[2];
        f7f[] arrf7f2 = arrf7f;
        arrf7f[0] = Tunnel = new f7f("Tunnel", 0);
        arrf7f[1] = Nearby = new f7f("Nearby", 1);
        Field3355 = arrf7f;
    }
}

