/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f07
extends Enum {
    public static /* enum */ f07 SET;
    public static /* enum */ f07 MULTIPLY;
    public static /* synthetic */ f07[] Field5386;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f07() {
        void var2_-1;
        void var1_-1;
    }

    public static f07[] Method7601() {
        return (f07[])Field5386.clone();
    }

    static {
        f07[] arrf07 = new f07[2];
        f07[] arrf072 = arrf07;
        arrf07[0] = SET = new f07("SET", 0);
        arrf07[1] = MULTIPLY = new f07("MULTIPLY", 1);
        Field5386 = arrf07;
    }

    public static f07 Method7602(String string) {
        return Enum.valueOf(f07.class, string);
    }
}

