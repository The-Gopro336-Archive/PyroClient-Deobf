/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class fb2
extends Enum {
    public static /* enum */ fb2 CAMERA;
    public static /* enum */ fb2 PACKET;
    public static /* synthetic */ fb2[] Field1688;

    public static fb2[] Method2384() {
        return (fb2[])Field1688.clone();
    }

    static {
        fb2[] arrfb2 = new fb2[2];
        fb2[] arrfb22 = arrfb2;
        arrfb2[0] = CAMERA = new fb2("CAMERA", 0);
        arrfb2[1] = PACKET = new fb2("PACKET", 1);
        Field1688 = arrfb2;
    }

    public static fb2 Method2385(String string) {
        return Enum.valueOf(fb2.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public fb2() {
        void var2_-1;
        void var1_-1;
    }
}

