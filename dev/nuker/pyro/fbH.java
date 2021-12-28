/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class fbH
extends Enum {
    public static /* enum */ fbH Head;
    public static /* enum */ fbH Body;
    public static /* enum */ fbH Feet;
    public static /* synthetic */ fbH[] Field1934;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public fbH() {
        void var2_-1;
        void var1_-1;
    }

    static {
        fbH[] arrfbH = new fbH[3];
        fbH[] arrfbH2 = arrfbH;
        arrfbH[0] = Head = new fbH("Head", 0);
        arrfbH[1] = Body = new fbH("Body", 1);
        arrfbH[2] = Feet = new fbH("Feet", 2);
        Field1934 = arrfbH;
    }

    public static fbH Method2581(String string) {
        return Enum.valueOf(fbH.class, string);
    }

    public static fbH[] Method2582() {
        return (fbH[])Field1934.clone();
    }
}

