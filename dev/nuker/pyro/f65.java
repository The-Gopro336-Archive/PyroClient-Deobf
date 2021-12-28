/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f65
extends Enum {
    public static /* enum */ f65 NONE;
    public static /* enum */ f65 CLIENTSIDE;
    public static /* enum */ f65 SERVERSIDE;
    public static /* synthetic */ f65[] Field4178;

    static {
        f65[] arrf65 = new f65[3];
        f65[] arrf652 = arrf65;
        arrf65[0] = NONE = new f65("NONE", 0);
        arrf65[1] = CLIENTSIDE = new f65("CLIENTSIDE", 1);
        arrf65[2] = SERVERSIDE = new f65("SERVERSIDE", 2);
        Field4178 = arrf65;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f65() {
        void var2_-1;
        void var1_-1;
    }

    public static f65 Method5807(String string) {
        return Enum.valueOf(f65.class, string);
    }

    public static f65[] Method5808() {
        return (f65[])Field4178.clone();
    }
}

