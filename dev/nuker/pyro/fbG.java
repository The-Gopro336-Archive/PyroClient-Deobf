/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class fbG
extends Enum {
    public static /* enum */ fbG Off;
    public static /* enum */ fbG Outline;
    public static /* enum */ fbG Fill;
    public static /* enum */ fbG Stem;
    public static /* synthetic */ fbG[] Field1930;

    public static fbG Method2579(String string) {
        return Enum.valueOf(fbG.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public fbG() {
        void var2_-1;
        void var1_-1;
    }

    public static fbG[] Method2580() {
        return (fbG[])Field1930.clone();
    }

    static {
        fbG[] arrfbG = new fbG[4];
        fbG[] arrfbG2 = arrfbG;
        arrfbG[0] = Off = new fbG("Off", 0);
        arrfbG[1] = Outline = new fbG("Outline", 1);
        arrfbG[2] = Fill = new fbG("Fill", 2);
        arrfbG[3] = Stem = new fbG("Stem", 3);
        Field1930 = arrfbG;
    }
}

