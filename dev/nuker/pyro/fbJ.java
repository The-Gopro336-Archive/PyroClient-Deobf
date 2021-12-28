/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class fbj
extends Enum {
    public static /* enum */ fbj Glow;
    public static /* enum */ fbj Outline;
    public static /* enum */ fbj Filled;
    public static /* enum */ fbj FilledOutline;
    public static /* enum */ fbj Flat;
    public static /* synthetic */ fbj[] Field2096;

    public static fbj[] Method2740() {
        return (fbj[])Field2096.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public fbj() {
        void var2_-1;
        void var1_-1;
    }

    static {
        fbj[] arrfbj = new fbj[5];
        fbj[] arrfbj2 = arrfbj;
        arrfbj[0] = Glow = new fbj("Glow", 0);
        arrfbj[1] = Outline = new fbj("Outline", 1);
        arrfbj[2] = Filled = new fbj("Filled", 2);
        arrfbj[3] = FilledOutline = new fbj("FilledOutline", 3);
        arrfbj[4] = Flat = new fbj("Flat", 4);
        Field2096 = arrfbj;
    }

    public static fbj Method2741(String string) {
        return Enum.valueOf(fbj.class, string);
    }
}

