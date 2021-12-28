/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f9X
extends Enum {
    public static /* enum */ f9X NCP = new f9X("NCP", 0);
    public static /* enum */ f9X Legit = new f9X("Legit", 1);
    public static /* enum */ f9X Vanilla = new f9X("Vanilla", 2);
    public static /* synthetic */ f9X[] Field3621;

    static {
        Field3621 = new f9X[]{NCP, Legit, Vanilla};
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f9X() {
        void var2_-1;
        void var1_-1;
    }

    public static f9X[] Method5397() {
        return (f9X[])Field3621.clone();
    }

    public static f9X Method5398(String string) {
        return Enum.valueOf(f9X.class, string);
    }
}

