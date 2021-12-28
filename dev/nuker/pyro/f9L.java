/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f9l
extends Enum {
    public static /* enum */ f9l WaterStrafe = new f9l("WaterStrafe", 0);
    public static /* enum */ f9l Tick = new f9l("Tick", 1);
    public static /* enum */ f9l AAC = new f9l("AAC", 2);
    public static /* synthetic */ f9l[] Field4473;

    public static f9l[] Method6414() {
        return (f9l[])Field4473.clone();
    }

    static {
        Field4473 = new f9l[]{WaterStrafe, Tick, AAC};
    }

    public static f9l Method6415(String string) {
        return Enum.valueOf(f9l.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f9l() {
        void var2_-1;
        void var1_-1;
    }
}

