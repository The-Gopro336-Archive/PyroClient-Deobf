/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class fen
extends Enum {
    public static /* enum */ fen NONE;
    public static /* enum */ fen BOX;
    public static /* enum */ fen WIREFRAME;
    public static /* synthetic */ fen[] Field463;

    public static fen Method752(String string) {
        return Enum.valueOf(fen.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public fen() {
        void var2_-1;
        void var1_-1;
    }

    static {
        fen[] arrfen = new fen[3];
        fen[] arrfen2 = arrfen;
        arrfen[0] = NONE = new fen("NONE", 0);
        arrfen[1] = BOX = new fen("BOX", 1);
        arrfen[2] = WIREFRAME = new fen("WIREFRAME", 2);
        Field463 = arrfen;
    }

    public static fen[] Method753() {
        return (fen[])Field463.clone();
    }
}

