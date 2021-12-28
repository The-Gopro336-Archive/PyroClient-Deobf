/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f7U
extends Enum {
    public static /* enum */ f7U Always = new f7U("Always", 0);
    public static /* enum */ f7U Old = new f7U("Old", 1);
    public static /* synthetic */ f7U[] Field3323;

    public static f7U[] Method5160() {
        return (f7U[])Field3323.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f7U() {
        void var2_-1;
        void var1_-1;
    }

    public static f7U Method5161(String string) {
        return Enum.valueOf(f7U.class, string);
    }

    static {
        Field3323 = new f7U[]{Always, Old};
    }
}

