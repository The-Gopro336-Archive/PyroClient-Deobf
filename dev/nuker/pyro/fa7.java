/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class fa7
extends Enum {
    public static /* enum */ fa7 Instant;
    public static /* enum */ fa7 Add;
    public static /* enum */ fa7 Multiply;
    public static /* enum */ fa7 Ace;
    public static /* synthetic */ fa7[] Field1643;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public fa7() {
        void var2_-1;
        void var1_-1;
    }

    static {
        fa7[] arrfa7 = new fa7[4];
        fa7[] arrfa72 = arrfa7;
        arrfa7[0] = Instant = new fa7("Instant", 0);
        arrfa7[1] = Add = new fa7("Add", 1);
        arrfa7[2] = Multiply = new fa7("Multiply", 2);
        arrfa7[3] = Ace = new fa7("Ace", 3);
        Field1643 = arrfa7;
    }

    public static fa7 Method2361(String string) {
        return Enum.valueOf(fa7.class, string);
    }

    public static fa7[] Method2362() {
        return (fa7[])Field1643.clone();
    }
}

