/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f9w
extends Enum {
    public static /* enum */ f9w Ticks;
    public static /* enum */ f9w Fast;
    public static /* enum */ f9w Kangaroo;
    public static /* enum */ f9w Deer;
    public static /* synthetic */ f9w[] Field4504;

    public static f9w[] Method6427() {
        return (f9w[])Field4504.clone();
    }

    public static f9w Method6428(String string) {
        return Enum.valueOf(f9w.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f9w() {
        void var2_-1;
        void var1_-1;
    }

    static {
        f9w[] arrf9w = new f9w[4];
        f9w[] arrf9w2 = arrf9w;
        arrf9w[0] = Ticks = new f9w("Ticks", 0);
        arrf9w[1] = Fast = new f9w("Fast", 1);
        arrf9w[2] = Kangaroo = new f9w("Kangaroo", 2);
        arrf9w[3] = Deer = new f9w("Deer", 3);
        Field4504 = arrf9w;
    }
}

