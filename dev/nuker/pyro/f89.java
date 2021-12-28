/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f44;
import dev.nuker.pyro.security.inject.LauncherEventHide;

public class f89
extends Module {
    public BooleanSetting Field3287 = new BooleanSetting("showEnabled", "ShowEnabled", null, true);
    public BooleanSetting Field3288 = new BooleanSetting("showDisabled", "ShowDisabled", null, true);
    public BooleanSetting Field3289 = new BooleanSetting("combat", "Combat", null, true);
    public BooleanSetting Field3290 = new BooleanSetting("exploit", "Exploit", null, true);
    public BooleanSetting Field3291 = new BooleanSetting("movement", "Movement", null, true);
    public BooleanSetting Field3292 = new BooleanSetting("misc", "Misc", null, true);
    public BooleanSetting Field3293 = new BooleanSetting("render", "Render", null, true);
    public BooleanSetting Field3294 = new BooleanSetting("world", "World", null, true);

    @f0g
    @LauncherEventHide
    public void Method5152(f44 f442) {
        if (this.Field5233.player == null || this.Field5233.ingameGUI == null) {
            return;
        }
        if (!((Boolean)this.Field3287.Method7979()).booleanValue() && ((Boolean)f442.Method5595().Field5236.Method5264()).booleanValue()) {
            return;
        }
        if (!((Boolean)this.Field3288.Method7979()).booleanValue()) {
            if (!((Boolean)f442.Method5595().Field5236.Method5264()).booleanValue()) {
                return;
            }
        }
        if (f442.Method5595().Method7267() == null) {
            return;
        }
        if (f442.Method5595().Method7267().equals("Combat")) {
            if (!((Boolean)this.Field3289.Method7979()).booleanValue()) {
                return;
            }
        }
        if (f442.Method5595().Method7267().equals("Exploit") && !((Boolean)this.Field3290.Method7979()).booleanValue()) {
            return;
        }
        if (f442.Method5595().Method7267().equals("Movement") && !((Boolean)this.Field3291.Method7979()).booleanValue()) {
            return;
        }
        if (f442.Method5595().Method7267().equals("Misc") && !((Boolean)this.Field3292.Method7979()).booleanValue()) {
            return;
        }
        if (f442.Method5595().Method7267().equals("Render") && !((Boolean)this.Field3293.Method7979()).booleanValue()) {
            return;
        }
        if (f442.Method5595().Method7267().equals("World")) {
            if (!((Boolean)this.Field3294.Method7979()).booleanValue()) {
                return;
            }
        }
        if (((Boolean)f442.Method5595().Field5236.Method5264()).booleanValue()) {
            Pyro.Field6182.Method8989((Object)ChatFormatting.GREEN + f442.Method5595().Method7265() + " has been enabled.");
        } else {
            Pyro.Field6182.Method8989((Object)ChatFormatting.RED + f442.Method5595().Method7265() + " has been disabled.");
        }
    }

    public f89() {
        super("chatnotifier", "ChatNotifier", "Notifies you in chat when a module is enabled/disabled depending on what is filtered", true);
        this.Method7264(this.Field3287);
        this.Method7264(this.Field3288);
        this.Method7264(this.Field3289);
        this.Method7264(this.Field3290);
        this.Method7264(this.Field3291);
        this.Method7264(this.Field3292);
        this.Method7264(this.Field3293);
        this.Method7264(this.Field3294);
    }
}

