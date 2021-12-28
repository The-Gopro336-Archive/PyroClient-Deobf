/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class fdb
extends Enum {
    public static /* enum */ fdb Creative;
    public static /* enum */ fdb Survival;
    public static /* enum */ fdb Selective;
    public static /* enum */ fdb Farm;
    public static /* enum */ fdb Lawnmower;
    public static /* synthetic */ fdb[] Field321;

    public static fdb[] Method533() {
        return (fdb[])Field321.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public fdb() {
        void var2_-1;
        void var1_-1;
    }

    public static fdb Method534(String string) {
        return Enum.valueOf(fdb.class, string);
    }

    static {
        fdb[] arrfdb = new fdb[5];
        fdb[] arrfdb2 = arrfdb;
        arrfdb[0] = Creative = new fdb("Creative", 0);
        arrfdb[1] = Survival = new fdb("Survival", 1);
        arrfdb[2] = Selective = new fdb("Selective", 2);
        arrfdb[3] = Farm = new fdb("Farm", 3);
        arrfdb[4] = Lawnmower = new fdb("Lawnmower", 4);
        Field321 = arrfdb;
    }
}

