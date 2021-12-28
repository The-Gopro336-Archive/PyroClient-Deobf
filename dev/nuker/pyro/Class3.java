/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroClientLoadingPlugin;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

public class Class3
implements ReadyCallback {
    public static Class3 Field5305 = new Class3();

    public void Method7344(DiscordUser discordUser) {
        PyroClientLoadingPlugin.Field7533.info("Connected discord: " + discordUser.Field6400 + '#' + discordUser.Field6401);
    }
}

