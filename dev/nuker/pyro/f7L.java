/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f7l
extends Enum {
    public static /* enum */ f7l Off;
    public static /* enum */ f7l Semi;
    public static /* enum */ f7l Full;
    public static /* synthetic */ f7l[] Field3456;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f7l() {
        void var2_-1;
        void var1_-1;
    }

    public static f7l[] Method5258() {
        return (f7l[])Field3456.clone();
    }

    static {
        f7l[] arrf7l = new f7l[3];
        f7l[] arrf7l2 = arrf7l;
        arrf7l[0] = Off = new f7l("Off", 0);
        arrf7l[1] = Semi = new f7l("Semi", 1);
        arrf7l[2] = Full = new f7l("Full", 2);
        Field3456 = arrf7l;
    }

    public static f7l Method5259(String string) {
        return Enum.valueOf(f7l.class, string);
    }
}

