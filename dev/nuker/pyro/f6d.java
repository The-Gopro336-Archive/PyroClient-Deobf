/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f6d
extends Enum {
    public static /* enum */ f6d None = new f6d("None", 0);
    public static /* enum */ f6d OnlySword = new f6d("OnlySword", 1);
    public static /* enum */ f6d BestSword = new f6d("BestSword", 2);
    public static /* synthetic */ f6d[] Field3186;

    static {
        Field3186 = new f6d[]{None, OnlySword, BestSword};
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f6d() {
        void var2_-1;
        void var1_-1;
    }

    public static f6d[] Method5097() {
        return (f6d[])Field3186.clone();
    }

    public static f6d Method5098(String string) {
        return Enum.valueOf(f6d.class, string);
    }
}

