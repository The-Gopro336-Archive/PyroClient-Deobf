/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Gui
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Class57;
import dev.nuker.pyro.f0F;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f0J;
import dev.nuker.pyro.f0Y;
import dev.nuker.pyro.f14;
import dev.nuker.pyro.f17;
import net.minecraft.client.gui.Gui;
import org.jetbrains.annotations.NotNull;

public class f0K
extends f0Y {
    @NotNull
    public String Field5515;
    @NotNull
    public Class57<Boolean> Field5516;

    public void Method7843(@NotNull Class57 class57) {
        this.Field5516 = class57;
    }

    @Override
    public void Method7819(@NotNull f0F f0F2, double d, double d2, @NotNull f0H f0H2) {
        super.Method7819(f0F2, d, d2, f0H2);
        f0J.Method7775(f0J.Field5485, f0F2.Method7814(), this.Field5515, 0, 0, f0F2.Method7813() - 4, f0F2.Method7815(), f0H.Field5477, f0H.Field5476, f0H2.Method7708(), false, 512, null);
        int n = f0F2.Method7813() - f0H.Field5476;
        int n2 = (f0F2.Method7815() - f0H.Field5476 * 2) * 2;
        int n3 = f0F2.Method7815() - f0H.Field5476 * 2 - 1;
        Gui.drawRect((int)(n - n2), (int)f0H.Field5476, (int)(f0F2.Method7813() - f0H.Field5476), (int)(f0F2.Method7815() - f0H.Field5476), (int)(((Boolean)this.Field5516.Method5264()).booleanValue() ? f0H2.Method7702() : f0H2.Method7705()));
        int n4 = (Boolean)this.Field5516.Method5264() != false ? n - 1 - n3 : n - n2 + 1;
        Gui.drawRect((int)n4, (int)(f0H.Field5476 + 1), (int)(n4 + n3), (int)(f0F2.Method7815() - f0H.Field5476 - 1), (int)f0H2.Method7708());
    }

    public void Method7844(@NotNull String string) {
        this.Field5515 = string;
    }

    @Override
    public void Method7818(@NotNull f0F f0F2, @NotNull f0H f0H2, @NotNull f17 f172) {
        if (f172 instanceof f14 && f172.Method7895() == 0) {
            this.Field5516.Method5266((Object)((Boolean)this.Field5516.Method5264() == false ? 1 : 0));
        }
    }

    @NotNull
    public Class57 Method7845() {
        return this.Field5516;
    }

    @NotNull
    public String Method7846() {
        return this.Field5515;
    }

    @Override
    public int Method7817(@NotNull f0F f0F2, @NotNull f0H f0H2) {
        return f0F2.Method7814().FONT_HEIGHT + f0H.Field5476 * 2;
    }

    @Override
    public int Method7820(@NotNull f0F f0F2, @NotNull f0H f0H2) {
        return f0F2.Method7814().getStringWidth(this.Field5515) + f0H.Field5476 * 2 + (f0F2.Method7815() - f0H.Field5476 * 2) * 2 + 2;
    }

    public f0K(@NotNull BooleanSetting booleanSetting) {
        super(booleanSetting);
        this.Field5515 = booleanSetting.Method5989();
        this.Field5516 = booleanSetting.Method7976();
    }
}

