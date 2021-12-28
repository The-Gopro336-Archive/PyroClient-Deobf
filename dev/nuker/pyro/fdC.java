/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class fdc
extends Enum {
    public static /* enum */ fdc BELOW;
    public static /* enum */ fdc INLINE;
    public static /* synthetic */ fdc[] Field314;

    static {
        fdc[] arrfdc = new fdc[2];
        fdc[] arrfdc2 = arrfdc;
        arrfdc[0] = BELOW = new fdc("BELOW", 0);
        arrfdc[1] = INLINE = new fdc("INLINE", 1);
        Field314 = arrfdc;
    }

    public static fdc[] Method517() {
        return (fdc[])Field314.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public fdc() {
        void var2_-1;
        void var1_-1;
    }

    public static fdc Method518(String string) {
        return Enum.valueOf(fdc.class, string);
    }
}

