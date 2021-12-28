/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f7w
extends Enum {
    public static /* enum */ f7w Cancel;
    public static /* enum */ f7w Offhand;
    public static /* synthetic */ f7w[] Field3467;

    public static f7w Method5270(String string) {
        return Enum.valueOf(f7w.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f7w() {
        void var2_-1;
        void var1_-1;
    }

    public static f7w[] Method5271() {
        return (f7w[])Field3467.clone();
    }

    static {
        f7w[] arrf7w = new f7w[2];
        f7w[] arrf7w2 = arrf7w;
        arrf7w[0] = Cancel = new f7w("Cancel", 0);
        arrf7w[1] = Offhand = new f7w("Offhand", 1);
        Field3467 = arrf7w;
    }
}

