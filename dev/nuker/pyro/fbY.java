/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class fbY
extends Enum {
    public static /* enum */ fbY Clear;
    public static /* enum */ fbY Rain;
    public static /* enum */ fbY Thunder;
    public static /* synthetic */ fbY[] Field2003;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public fbY() {
        void var2_-1;
        void var1_-1;
    }

    public static fbY Method2670(String string) {
        return Enum.valueOf(fbY.class, string);
    }

    public static fbY[] Method2671() {
        return (fbY[])Field2003.clone();
    }

    static {
        fbY[] arrfbY = new fbY[3];
        fbY[] arrfbY2 = arrfbY;
        arrfbY[0] = Clear = new fbY("Clear", 0);
        arrfbY[1] = Rain = new fbY("Rain", 1);
        arrfbY[2] = Thunder = new fbY("Thunder", 2);
        Field2003 = arrfbY;
    }
}

