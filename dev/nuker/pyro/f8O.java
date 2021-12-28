/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f8o
extends Enum {
    public static /* enum */ f8o Activation = new f8o("Activation", 0);
    public static /* enum */ f8o Crystals = new f8o("Crystals", 1);
    public static /* enum */ f8o Both = new f8o("Both", 2);
    public static /* synthetic */ f8o[] Field3596;

    public static f8o[] Method5371() {
        return (f8o[])Field3596.clone();
    }

    public static f8o Method5372(String string) {
        return Enum.valueOf(f8o.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f8o() {
        void var2_-1;
        void var1_-1;
    }

    static {
        Field3596 = new f8o[]{Activation, Crystals, Both};
    }
}

