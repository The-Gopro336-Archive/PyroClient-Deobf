/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class fbV
extends Enum {
    public static /* enum */ fbV Coords;
    public static /* enum */ fbV Distance;
    public static /* synthetic */ fbV[] Field2025;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public fbV() {
        void var2_-1;
        void var1_-1;
    }

    public static fbV Method2683(String string) {
        return Enum.valueOf(fbV.class, string);
    }

    public static fbV[] Method2684() {
        return (fbV[])Field2025.clone();
    }

    static {
        fbV[] arrfbV = new fbV[2];
        fbV[] arrfbV2 = arrfbV;
        arrfbV[0] = Coords = new fbV("Coords", 0);
        arrfbV[1] = Distance = new fbV("Distance", 1);
        Field2025 = arrfbV;
    }
}

