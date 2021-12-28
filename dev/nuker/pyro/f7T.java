/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Module;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

public class f7T
extends Module {
    @JvmField
    @NotNull
    public BooleanSetting Field3320 = (BooleanSetting)this.Method7264(new BooleanSetting("disconnect", "Block Disconnect", "Add a confirmation popup for the disconnect button", true));
    @JvmField
    @NotNull
    public BooleanSetting Field3321 = (BooleanSetting)this.Method7264(new BooleanSetting("close_window", "Block Window Close", "Add a confirmation popup for the 'X' button", true));

    public f7T() {
        super("anti_disconnect", "AntiDisconnect", "Gives a confirmation screen before you disconnect", true);
    }
}

