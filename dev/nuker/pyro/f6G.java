/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f6g
extends Enum {
    public static /* enum */ f6g None = new f6g("None", 0);
    public static /* enum */ f6g FlyEnabled = new f6g("FlyEnabled", 1);
    public static /* enum */ f6g Key = new f6g("Key", 2);
    public static /* synthetic */ f6g[] Field3163;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f6g() {
        void var2_-1;
        void var1_-1;
    }

    public static f6g Method5068(String string) {
        return Enum.valueOf(f6g.class, string);
    }

    static {
        Field3163 = new f6g[]{None, FlyEnabled, Key};
    }

    public static f6g[] Method5069() {
        return (f6g[])Field3163.clone();
    }
}

