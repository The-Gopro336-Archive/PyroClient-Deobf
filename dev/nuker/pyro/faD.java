/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class fad
extends Enum {
    public static /* enum */ fad Packet;
    public static /* enum */ fad Spin;
    public static /* enum */ fad Off;
    public static /* synthetic */ fad[] Field1909;

    static {
        fad[] arrfad = new fad[3];
        fad[] arrfad2 = arrfad;
        arrfad[0] = Packet = new fad("Packet", 0);
        arrfad[1] = Spin = new fad("Spin", 1);
        arrfad[2] = Off = new fad("Off", 2);
        Field1909 = arrfad;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public fad() {
        void var2_-1;
        void var1_-1;
    }

    public static fad Method2572(String string) {
        return Enum.valueOf(fad.class, string);
    }

    public static fad[] Method2573() {
        return (fad[])Field1909.clone();
    }
}

