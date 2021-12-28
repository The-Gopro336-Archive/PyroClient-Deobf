/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f9t
extends Enum {
    public static /* enum */ f9t Solid = new f9t("Solid", 0);
    public static /* enum */ f9t Dolphin = new f9t("Dolphin", 1);
    public static /* enum */ f9t Trampoline = new f9t("Trampoline", 2);
    public static /* synthetic */ f9t[] Field4497;

    static {
        Field4497 = new f9t[]{Solid, Dolphin, Trampoline};
    }

    public static f9t Method6425(String string) {
        return Enum.valueOf(f9t.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f9t() {
        void var2_-1;
        void var1_-1;
    }

    public static f9t[] Method6426() {
        return (f9t[])Field4497.clone();
    }
}

