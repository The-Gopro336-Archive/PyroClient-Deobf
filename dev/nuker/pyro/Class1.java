/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroClientLoadingPlugin;
import net.arikia.dev.drpc.callbacks.DisconnectedCallback;

public class Class1
implements DisconnectedCallback {
    public static Class1 Field5301 = new Class1();

    public void Method7329(int n, String string) {
        PyroClientLoadingPlugin.Field7533.error("Discord disconnected: " + string + " (Error code " + n + ')');
    }
}

