/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f6h
extends Enum {
    public static /* enum */ f6h Soft = new f6h("Soft", 0);
    public static /* enum */ f6h Replace = new f6h("Replace", 1);
    public static /* synthetic */ f6h[] Field3166;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f6h() {
        void var2_-1;
        void var1_-1;
    }

    public static f6h Method5087(String string) {
        return Enum.valueOf(f6h.class, string);
    }

    static {
        Field3166 = new f6h[]{Soft, Replace};
    }

    public static f6h[] Method5088() {
        return (f6h[])Field3166.clone();
    }
}

