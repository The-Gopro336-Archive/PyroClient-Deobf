/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f72
extends Enum {
    public static /* enum */ f72 Normal;
    public static /* enum */ f72 AAC;
    public static /* synthetic */ f72[] Field3078;

    static {
        f72[] arrf72 = new f72[2];
        f72[] arrf722 = arrf72;
        arrf72[0] = Normal = new f72("Normal", 0);
        arrf72[1] = AAC = new f72("AAC", 1);
        Field3078 = arrf72;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f72() {
        void var2_-1;
        void var1_-1;
    }

    public static f72 Method4953(String string) {
        return Enum.valueOf(f72.class, string);
    }

    public static f72[] Method4954() {
        return (f72[])Field3078.clone();
    }
}

