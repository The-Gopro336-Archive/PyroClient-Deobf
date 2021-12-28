/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f7m
extends Enum {
    public static /* enum */ f7m Down;
    public static /* enum */ f7m Up;
    public static /* enum */ f7m Preserve;
    public static /* enum */ f7m Bounds;
    public static /* synthetic */ f7m[] Field3458;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f7m() {
        void var2_-1;
        void var1_-1;
    }

    public static f7m Method5260(String string) {
        return Enum.valueOf(f7m.class, string);
    }

    static {
        f7m[] arrf7m = new f7m[4];
        f7m[] arrf7m2 = arrf7m;
        arrf7m[0] = Down = new f7m("Down", 0);
        arrf7m[1] = Up = new f7m("Up", 1);
        arrf7m[2] = Preserve = new f7m("Preserve", 2);
        arrf7m[3] = Bounds = new f7m("Bounds", 3);
        Field3458 = arrf7m;
    }

    public static f7m[] Method5261() {
        return (f7m[])Field3458.clone();
    }
}

