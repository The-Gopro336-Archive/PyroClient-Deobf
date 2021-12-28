/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f9R
extends Enum {
    public static /* enum */ f9R Vanilla;
    public static /* enum */ f9R BHop;
    public static /* synthetic */ f9R[] Field3603;

    public static f9R[] Method5380() {
        return (f9R[])Field3603.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f9R() {
        void var2_-1;
        void var1_-1;
    }

    public static f9R Method5381(String string) {
        return Enum.valueOf(f9R.class, string);
    }

    static {
        f9R[] arrf9R = new f9R[2];
        f9R[] arrf9R2 = arrf9R;
        arrf9R[0] = Vanilla = new f9R("Vanilla", 0);
        arrf9R[1] = BHop = new f9R("BHop", 1);
        Field3603 = arrf9R;
    }
}

