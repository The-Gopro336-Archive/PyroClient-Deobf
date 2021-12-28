/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class faM
extends Enum {
    public static /* enum */ faM Gamma;
    public static /* enum */ faM NightVision;
    public static /* synthetic */ faM[] Field1722;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public faM() {
        void var2_-1;
        void var1_-1;
    }

    public static faM[] Method2417() {
        return (faM[])Field1722.clone();
    }

    public static faM Method2418(String string) {
        return Enum.valueOf(faM.class, string);
    }

    static {
        faM[] arrfaM = new faM[2];
        faM[] arrfaM2 = arrfaM;
        arrfaM[0] = Gamma = new faM("Gamma", 0);
        arrfaM[1] = NightVision = new faM("NightVision", 1);
        Field1722 = arrfaM;
    }
}

