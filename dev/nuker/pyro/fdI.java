/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class fdi
extends Enum {
    public static /* enum */ fdi Normal;
    public static /* enum */ fdi NCP;
    public static /* enum */ fdi Hypixel;
    public static /* enum */ fdi Instant;
    public static /* synthetic */ fdi[] Field378;

    public static fdi Method587(String string) {
        return Enum.valueOf(fdi.class, string);
    }

    static {
        fdi[] arrfdi = new fdi[4];
        fdi[] arrfdi2 = arrfdi;
        arrfdi[0] = Normal = new fdi("Normal", 0);
        arrfdi[1] = NCP = new fdi("NCP", 1);
        arrfdi[2] = Hypixel = new fdi("Hypixel", 2);
        arrfdi[3] = Instant = new fdi("Instant", 3);
        Field378 = arrfdi;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public fdi() {
        void var2_-1;
        void var1_-1;
    }

    public static fdi[] Method588() {
        return (fdi[])Field378.clone();
    }
}

