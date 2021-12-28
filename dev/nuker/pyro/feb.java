/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class feb
extends Enum {
    public static /* enum */ feb NoEntityCollision = new feb("NoEntityCollision", 0);
    public static /* enum */ feb AlreadyBlockThere = new feb("AlreadyBlockThere", 1);
    public static /* enum */ feb NoNeighbors = new feb("NoNeighbors", 2);
    public static /* enum */ feb Ok = new feb("Ok", 3);
    public static /* synthetic */ feb[] Field457;

    static {
        Field457 = new feb[]{NoEntityCollision, AlreadyBlockThere, NoNeighbors, Ok};
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public feb() {
        void var2_-1;
        void var1_-1;
    }

    public static feb[] Method716() {
        return (feb[])Field457.clone();
    }

    public static feb Method717(String string) {
        return Enum.valueOf(feb.class, string);
    }
}

