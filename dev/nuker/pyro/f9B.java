/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f9b
extends Enum {
    public static /* enum */ f9b Ignore;
    public static /* enum */ f9b Frequency;
    public static /* enum */ f9b Distance;
    public static /* enum */ f9b Both;
    public static /* synthetic */ f9b[] Field3712;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f9b() {
        void var2_-1;
        void var1_-1;
    }

    public static f9b[] Method5460() {
        return (f9b[])Field3712.clone();
    }

    public static f9b Method5461(String string) {
        return Enum.valueOf(f9b.class, string);
    }

    static {
        f9b[] arrf9b = new f9b[4];
        f9b[] arrf9b2 = arrf9b;
        arrf9b[0] = Ignore = new f9b("Ignore", 0);
        arrf9b[1] = Frequency = new f9b("Frequency", 1);
        arrf9b[2] = Distance = new f9b("Distance", 2);
        arrf9b[3] = Both = new f9b("Both", 3);
        Field3712 = arrf9b;
    }
}

