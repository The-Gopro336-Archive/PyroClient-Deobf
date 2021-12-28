/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import java.security.Permission;

public class BetterSecurityManager
extends SecurityManager {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void checkPermission(Permission permission) {
    }

    public BetterSecurityManager() {
        BetterSecurityManager betterSecurityManager = this;
        throw null;
    }
}

