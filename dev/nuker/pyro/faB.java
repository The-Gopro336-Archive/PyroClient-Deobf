/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class fab
extends Enum {
    public static /* enum */ fab Vanilla;
    public static /* synthetic */ fab[] Field1789;

    public static fab[] Method2492() {
        return (fab[])Field1789.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public fab() {
        void var2_-1;
        void var1_-1;
    }

    static {
        fab[] arrfab = new fab[1];
        fab[] arrfab2 = arrfab;
        arrfab[0] = Vanilla = new fab("Vanilla", 0);
        Field1789 = arrfab;
    }

    public static fab Method2493(String string) {
        return Enum.valueOf(fab.class, string);
    }
}

