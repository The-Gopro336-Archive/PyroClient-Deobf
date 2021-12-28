/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f6S
extends Enum {
    public static /* enum */ f6S Crystal;
    public static /* enum */ f6S Gap;
    public static /* synthetic */ f6S[] Field3091;

    public static f6S[] Method4962() {
        return (f6S[])Field3091.clone();
    }

    public static f6S Method4963(String string) {
        return Enum.valueOf(f6S.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f6S() {
        void var2_-1;
        void var1_-1;
    }

    static {
        f6S[] arrf6S = new f6S[2];
        f6S[] arrf6S2 = arrf6S;
        arrf6S[0] = Crystal = new f6S("Crystal", 0);
        arrf6S[1] = Gap = new f6S("Gap", 1);
        Field3091 = arrf6S;
    }
}

