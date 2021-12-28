/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f7k
extends Enum {
    public static /* enum */ f7k Fast;
    public static /* enum */ f7k Factor;
    public static /* enum */ f7k SetBack;
    public static /* enum */ f7k SemiFactor;
    public static /* enum */ f7k Limit;
    public static /* synthetic */ f7k[] Field3454;

    public static f7k Method5256(String string) {
        return Enum.valueOf(f7k.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f7k() {
        void var2_-1;
        void var1_-1;
    }

    public static f7k[] Method5257() {
        return (f7k[])Field3454.clone();
    }

    static {
        f7k[] arrf7k = new f7k[5];
        f7k[] arrf7k2 = arrf7k;
        arrf7k[0] = Fast = new f7k("Fast", 0);
        arrf7k[1] = Factor = new f7k("Factor", 1);
        arrf7k[2] = SetBack = new f7k("SetBack", 2);
        arrf7k[3] = SemiFactor = new f7k("SemiFactor", 3);
        arrf7k[4] = Limit = new f7k("Limit", 4);
        Field3454 = arrf7k;
    }
}

