/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro.layer;

import java.nio.ByteBuffer;

public class DLBHash {
    public static DLBHash Field3824;

    static {
        DLBHash dLBHash;
        Field3824 = dLBHash = new DLBHash();
    }

    public byte[] Method5514() {
        return ByteBuffer.allocate(16).putInt(-1172281222).putInt(327996254).putInt(-361805921).putInt(-625156042).array();
    }
}

