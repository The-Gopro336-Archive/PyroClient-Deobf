/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.ServerData
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f82;
import kotlin.jvm.JvmField;
import net.minecraft.client.multiplayer.ServerData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f83
extends Module {
    @NotNull
    public DoubleSetting Field3313 = (DoubleSetting)this.Method7264(new DoubleSetting("delayy", "Delay", "Delay in seconds", 5.0, 0.0, 20.0, 0.0, 64, null));
    @NotNull
    public BooleanSetting Field3314 = (BooleanSetting)this.Method7264(new BooleanSetting("show", "Show Buttons", "Show reconnect buttons on the disconnect screen", true));
    @JvmField
    @Nullable
    public static ServerData Field3315;
    public static f82 Field3316;

    public void Method2691(@NotNull BooleanSetting booleanSetting) {
        this.Field3314 = booleanSetting;
    }

    @NotNull
    public DoubleSetting Method238() {
        return this.Field3313;
    }

    static {
        Field3316 = new f82(null);
    }

    public void Method2371(@NotNull DoubleSetting doubleSetting) {
        this.Field3313 = doubleSetting;
    }

    @NotNull
    public BooleanSetting Method274() {
        return this.Field3314;
    }

    public f83() {
        super("auto_reconnect", "AutoReconnect", "Automatically reconnects to a server when you get disconnected.");
    }
}

