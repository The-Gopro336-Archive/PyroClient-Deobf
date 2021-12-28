/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class f41
extends Enum {
    public static /* enum */ f41 Pre = new f41("Pre", 0);
    public static /* enum */ f41 Post = new f41("Post", 1);
    public static /* synthetic */ f41[] Field3918;

    public static f41[] Method5617() {
        return (f41[])Field3918.clone();
    }

    static {
        Field3918 = new f41[]{Pre, Post};
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f41() {
        void var2_-1;
        void var1_-1;
    }

    public static f41 Method5618(String string) {
        return Enum.valueOf(f41.class, string);
    }
}

