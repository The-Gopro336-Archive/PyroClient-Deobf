/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class48;
import dev.nuker.pyro.Class49;
import dev.nuker.pyro.alt.Alt;
import dev.nuker.pyro.alt.AltLogic;
import dev.nuker.pyro.alt.AltManager;
import net.minecraft.client.gui.GuiScreen;

public class Class50
extends Class49 {
    public Class48 Field4459;

    public static boolean Method6408(String string, Alt alt) {
        return alt.Method1434().equals(string);
    }

    public static boolean Method6409(String string, Alt alt) {
        return alt.Method1436().equals(string) && alt.Method1432();
    }

    public void Method6410(Alt alt) {
        AltManager.Field6702.Method9677(alt);
        Class48.Method6848(this.Field4459).Method6842();
    }

    @Override
    public void Method6411(String string, String string2) {
        if (string2.isEmpty()) {
            if (AltManager.Field6702.Method9676().stream().anyMatch(arg_0 -> Class50.Method6409(string, arg_0))) {
                this.Field4659 = "There is already an account with that name";
            } else {
                this.Method6410(new Alt(string));
                this.mc.displayGuiScreen(this.Field4658);
            }
        } else {
            switch (AltLogic.Method7695(string, string2)) {
                case 0: {
                    if (AltManager.Field6702.Method9676().stream().anyMatch(arg_0 -> Class50.Method6408(string, arg_0))) {
                        this.Field4659 = "There is already an account with that email";
                    }
                    this.Method6410(new Alt(string, AltLogic.Field5467.getSelectedProfile().getName(), string2, AltLogic.Field5467.getSelectedProfile().getId().toString()));
                    AltLogic.Field5467.logOut();
                    this.mc.displayGuiScreen(this.Field4658);
                    break;
                }
                case 1: {
                    this.Field4659 = "Invalid email or password";
                    break;
                }
                case 2: {
                    this.Field4659 = "Unable to connect to authentication servers";
                }
            }
        }
    }

    public Class50(Class48 class48, GuiScreen guiScreen, String string) {
        this.Field4459 = class48;
        super(guiScreen, string);
    }
}

