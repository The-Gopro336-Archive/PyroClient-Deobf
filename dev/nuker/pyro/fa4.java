/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class fa4
extends Enum {
    public static /* enum */ fa4 REACHED_GOAL;
    public static /* enum */ fa4 TIMEOUT;
    public static /* enum */ fa4 UNLOADED_CHUNKS;
    public static /* synthetic */ fa4[] Field1624;

    static {
        fa4[] arrfa4 = new fa4[3];
        fa4[] arrfa42 = arrfa4;
        arrfa4[0] = REACHED_GOAL = new fa4("REACHED_GOAL", 0);
        arrfa4[1] = TIMEOUT = new fa4("TIMEOUT", 1);
        arrfa4[2] = UNLOADED_CHUNKS = new fa4("UNLOADED_CHUNKS", 2);
        Field1624 = arrfa4;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public fa4() {
        void var2_-1;
        void var1_-1;
    }

    public static fa4 Method2322(String string) {
        return Enum.valueOf(fa4.class, string);
    }

    public static fa4[] Method2323() {
        return (fa4[])Field1624.clone();
    }
}

