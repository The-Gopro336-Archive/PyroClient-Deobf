/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f87
extends Enum {
    public static /* enum */ f87 White = new f87("White", 0);
    public static /* enum */ f87 Gray = new f87("Gray", 1);
    public static /* enum */ f87 DarkGray = new f87("DarkGray", 2);
    public static /* enum */ f87 Red = new f87("Red", 3);
    public static /* enum */ f87 DarkRed = new f87("DarkRed", 4);
    public static /* enum */ f87 Green = new f87("Green", 5);
    public static /* enum */ f87 DarkGreen = new f87("DarkGreen", 6);
    public static /* enum */ f87 Blue = new f87("Blue", 7);
    public static /* enum */ f87 DarkBlue = new f87("DarkBlue", 8);
    public static /* enum */ f87 Aqua = new f87("Aqua", 9);
    public static /* enum */ f87 Yellow = new f87("Yellow", 10);
    public static /* enum */ f87 Gold = new f87("Gold", 11);
    public static /* synthetic */ f87[] Field3263;

    public static f87[] Method5144() {
        return (f87[])Field3263.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f87() {
        void var2_-1;
        void var1_-1;
    }

    public static f87 Method5145(String string) {
        return Enum.valueOf(f87.class, string);
    }

    static {
        Field3263 = new f87[]{White, Gray, DarkGray, Red, DarkRed, Green, DarkGreen, Blue, DarkBlue, Aqua, Yellow, Gold};
    }
}

