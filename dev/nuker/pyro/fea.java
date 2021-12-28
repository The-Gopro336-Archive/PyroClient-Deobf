/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class fea
extends Enum {
    public static /* enum */ fea NotReplaceable = new fea("NotReplaceable", 0);
    public static /* enum */ fea Neighbors = new fea("Neighbors", 1);
    public static /* enum */ fea CantPlace = new fea("CantPlace", 2);
    public static /* enum */ fea Placed = new fea("Placed", 3);
    public static /* synthetic */ fea[] Field455;

    public static fea Method702(String string) {
        return Enum.valueOf(fea.class, string);
    }

    public static fea[] Method703() {
        return (fea[])Field455.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public fea() {
        void var2_-1;
        void var1_-1;
    }

    static {
        Field455 = new fea[]{NotReplaceable, Neighbors, CantPlace, Placed};
    }
}

