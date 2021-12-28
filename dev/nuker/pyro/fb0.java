/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.GuiIngame
 *  net.minecraft.client.gui.GuiPlayerTabOverlay
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.ObfuscationReflectionHelper
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.f62;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.jetbrains.annotations.Nullable;

public class fb0
extends Module {
    public GuiPlayerTabOverlay Field1733;

    @f0g
    @LauncherEventHide
    public void Method183(f4t f4t2) {
        if (this.Field1733 == null) {
            this.Field1733 = this.Field5233.ingameGUI.getTabList();
            ObfuscationReflectionHelper.setPrivateValue(GuiIngame.class, (Object)this.Field5233.ingameGUI, (Object)((Object)new f62(this.Field5233, this.Field5233.ingameGUI)), (String[])new String[]{"field_175196_v"});
        }
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        if (!bl && this.Field5233.ingameGUI != null && this.Field1733 != null) {
            ObfuscationReflectionHelper.setPrivateValue(GuiIngame.class, (Object)this.Field5233.ingameGUI, (Object)this.Field1733, (String[])new String[]{"field_175196_v"});
        }
    }

    public fb0() {
        super("extratab", "ExtraTab", "Removes the vanilla tab limit of 100", false);
    }
}

