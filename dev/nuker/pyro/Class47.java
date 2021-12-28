/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class48;
import dev.nuker.pyro.Class49;
import dev.nuker.pyro.alt.AltLogic;
import net.minecraft.client.gui.GuiScreen;

public class Class47
extends Class49 {
    public Class48 Field4690;

    public Class47(Class48 class48, GuiScreen guiScreen, String string) {
        this.Field4690 = class48;
        super(guiScreen, string);
    }

    @Override
    public void Method6411(String string, String string2) {
        if (string2.isEmpty()) {
            AltLogic.Method7696(string);
            this.mc.displayGuiScreen(this.Field4658);
        } else {
            switch (AltLogic.Method7694(string, string2)) {
                case 0: {
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
}

