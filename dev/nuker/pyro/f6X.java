/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f6X
extends Enum {
    public static /* enum */ f6X Trigger = new f6X("Trigger", 0);
    public static /* enum */ f6X Distance = new f6X("Distance", 1);
    public static /* synthetic */ f6X[] Field3075;

    public static f6X[] Method4950() {
        return (f6X[])Field3075.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f6X() {
        void var2_-1;
        void var1_-1;
    }

    static {
        Field3075 = new f6X[]{Trigger, Distance};
    }

    public static f6X Method4951(String string) {
        return Enum.valueOf(f6X.class, string);
    }
}

