/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f0G
extends Enum {
    public static /* enum */ f0G LEFT;
    public static /* enum */ f0G RIGHT;
    public static /* enum */ f0G CENTER;
    public static /* synthetic */ f0G[] Field5469;

    public static f0G[] Method7699() {
        return (f0G[])Field5469.clone();
    }

    static {
        f0G[] arrf0G = new f0G[3];
        f0G[] arrf0G2 = arrf0G;
        arrf0G[0] = LEFT = new f0G("LEFT", 0);
        arrf0G[1] = RIGHT = new f0G("RIGHT", 1);
        arrf0G[2] = CENTER = new f0G("CENTER", 2);
        Field5469 = arrf0G;
    }

    public static f0G Method7700(String string) {
        return Enum.valueOf(f0G.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f0G() {
        void var2_-1;
        void var1_-1;
    }
}

