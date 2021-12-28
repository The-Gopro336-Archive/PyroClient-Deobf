/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f9o
extends Enum {
    public static /* enum */ f9o Survival = new f9o("Survival", 0);
    public static /* enum */ f9o Creative = new f9o("Creative", 1);
    public static /* enum */ f9o AAC = new f9o("AAC", 2);
    public static /* synthetic */ f9o[] Field4481;

    public static f9o Method6418(String string) {
        return Enum.valueOf(f9o.class, string);
    }

    public static f9o[] Method6419() {
        return (f9o[])Field4481.clone();
    }

    static {
        Field4481 = new f9o[]{Survival, Creative, AAC};
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f9o() {
        void var2_-1;
        void var1_-1;
    }
}

