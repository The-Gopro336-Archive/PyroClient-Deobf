/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiChat
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f4N;
import dev.nuker.pyro.mixin.GuiChatAccessor;
import kotlin.TypeCastException;
import net.minecraft.client.gui.GuiChat;

public class f4M
extends GuiChat {
    public int Field4019;
    public f4N Field4020;
    public String Field4021;

    public f4M(f4N f4N2, String string, String string2) {
        this.Field4020 = f4N2;
        this.Field4021 = string;
        super(string2);
        this.Field4019 = f4N.Method5693(f4N2);
    }

    public int Method5679() {
        return this.Field4019;
    }

    public void Method5680(int n) {
        this.Field4019 = n;
    }

    public void keyTyped(char c, int n) {
        f4M f4M2 = this;
        if (f4M2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.GuiChatAccessor");
        }
        ((GuiChatAccessor)((Object)f4M2)).Method4299(this.Field4019);
        super.keyTyped(c, n);
        this.Field4019 = ((GuiChatAccessor)((Object)this)).Method4298();
    }
}

