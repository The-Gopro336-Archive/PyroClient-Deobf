/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class mode
extends Enum {
    public static /* enum */ mode Packet;
    public static /* enum */ mode Jump;
    public static /* enum */ mode Mini;
    public static /* enum */ mode OldNCP;
    public static /* synthetic */ mode[] Field1352;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public mode() {
        void var2_-1;
        void var1_-1;
    }

    static {
        mode[] arrmode = new mode[4];
        mode[] arrmode2 = arrmode;
        arrmode[0] = Packet = new mode("Packet", 0);
        arrmode[1] = Jump = new mode("Jump", 1);
        arrmode[2] = Mini = new mode("Mini", 2);
        arrmode[3] = OldNCP = new mode("OldNCP", 3);
        Field1352 = arrmode;
    }

    public static mode[] Method1982() {
        return (mode[])Field1352.clone();
    }

    public static mode Method1983(String string) {
        return Enum.valueOf(mode.class, string);
    }
}

