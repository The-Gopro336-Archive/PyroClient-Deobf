/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f7Z
extends Enum {
    public static /* enum */ f7Z Auto;
    public static /* enum */ f7Z Keep;
    public static /* synthetic */ f7Z[] Field3341;

    static {
        f7Z[] arrf7Z = new f7Z[2];
        f7Z[] arrf7Z2 = arrf7Z;
        arrf7Z[0] = Auto = new f7Z("Auto", 0);
        arrf7Z[1] = Keep = new f7Z("Keep", 1);
        Field3341 = arrf7Z;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f7Z() {
        void var2_-1;
        void var1_-1;
    }

    public static f7Z[] Method5176() {
        return (f7Z[])Field3341.clone();
    }

    public static f7Z Method5177(String string) {
        return Enum.valueOf(f7Z.class, string);
    }
}

