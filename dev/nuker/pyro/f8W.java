/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f8w
extends Enum {
    public static /* enum */ f8w UNCHANGED;
    public static /* enum */ f8w ADDED;
    public static /* enum */ f8w REMOVED;
    public static /* enum */ f8w MODIFIED;
    public static /* synthetic */ f8w[] Field3620;

    static {
        f8w[] arrf8w = new f8w[4];
        f8w[] arrf8w2 = arrf8w;
        arrf8w[0] = UNCHANGED = new f8w("UNCHANGED", 0);
        arrf8w[1] = ADDED = new f8w("ADDED", 1);
        arrf8w[2] = REMOVED = new f8w("REMOVED", 2);
        arrf8w[3] = MODIFIED = new f8w("MODIFIED", 3);
        Field3620 = arrf8w;
    }

    public static f8w Method5395(String string) {
        return Enum.valueOf(f8w.class, string);
    }

    public static f8w[] Method5396() {
        return (f8w[])Field3620.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f8w() {
        void var2_-1;
        void var1_-1;
    }
}

