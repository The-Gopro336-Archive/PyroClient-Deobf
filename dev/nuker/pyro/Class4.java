/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroClientLoadingPlugin;
import net.arikia.dev.drpc.callbacks.ErroredCallback;

public class Class4
implements ErroredCallback {
    public static Class4 Field5306 = new Class4();

    public void Method7329(int n, String string) {
        PyroClientLoadingPlugin.Field7533.error("Could not connect discord: " + string + " (Error code " + n + ')');
    }
}

