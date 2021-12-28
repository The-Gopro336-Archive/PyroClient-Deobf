/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class fd1
extends Enum {
    public static /* enum */ fd1 Legit;
    public static /* enum */ fd1 ClickSelect;
    public static /* synthetic */ fd1[] Field158;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public fd1() {
        void var2_-1;
        void var1_-1;
    }

    static {
        fd1[] arrfd1 = new fd1[2];
        fd1[] arrfd12 = arrfd1;
        arrfd1[0] = Legit = new fd1("Legit", 0);
        arrfd1[1] = ClickSelect = new fd1("ClickSelect", 1);
        Field158 = arrfd1;
    }

    public static fd1 Method245(String string) {
        return Enum.valueOf(fd1.class, string);
    }

    public static fd1[] Method246() {
        return (fd1[])Field158.clone();
    }
}

