/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0l;
import dev.nuker.pyro.fb5;
import dev.nuker.pyro.fb6;
import dev.nuker.pyro.fb7;
import dev.nuker.pyro.fb8;
import dev.nuker.pyro.fb9;
import dev.nuker.pyro.fba;
import dev.nuker.pyro.fbb;
import dev.nuker.pyro.gui.ClickGui;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fbd
extends Module {
    @NotNull
    public BooleanSetting Field2080 = (BooleanSetting)this.Method7264(new BooleanSetting("customFont", "Custom Font", null, true));
    @NotNull
    public BooleanSetting Field2081 = (BooleanSetting)this.Method7264(new BooleanSetting("hudBackground", "HUD Background", null, true));
    public f0l Field2082 = (f0l)this.Method7264(new f0l("primary_color", "Primary Color", null, ClickGui.Field2428.Method8969().Method7701()));
    public f0l Field2083 = (f0l)this.Method7264(new f0l("accent_color", "Accent Color", null, ClickGui.Field2428.Method8969().Method7710()));
    public f0l Field2084 = (f0l)this.Method7264(new f0l("active_color", "Active Color", null, ClickGui.Field2428.Method8969().Method7718()));
    public f0l Field2085 = (f0l)this.Method7264(new f0l("inactive_color", "Inctive Color", null, ClickGui.Field2428.Method8969().Method7714()));
    public f0l Field2086 = (f0l)this.Method7264(new f0l("background_color", "Background Color", null, ClickGui.Field2428.Method8969().Method7711()));
    public f0l Field2087 = (f0l)this.Method7264(new f0l("background_color_hovered", "Hov. Background Color", null, ClickGui.Field2428.Method8969().Method7715()));
    public DoubleSetting Field2088 = (DoubleSetting)this.Method7264(new DoubleSetting("scale", "Scale", null, 1.0, 0.1, 2.0, 0.0, 64, null));

    @NotNull
    public BooleanSetting Method215() {
        return this.Field2081;
    }

    @NotNull
    public BooleanSetting Method274() {
        return this.Field2080;
    }

    public fbd() {
        super("clickgui", "ClickGUI", null);
        this.Field2082.Method7980(fb5.Field1743);
        this.Field2083.Method7980(fb6.Field1745);
        this.Field2084.Method7980(fb7.Field1747);
        this.Field2085.Method7980(fb8.Field1753);
        this.Field2086.Method7980(fb9.Field1735);
        this.Field2087.Method7980(fba.Field2042);
        this.Field2088.Method7980(fbb.Field2049);
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        if (bl) {
            this.Field5236.Method5266(false);
        }
    }
}

