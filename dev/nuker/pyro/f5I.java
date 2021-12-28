/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.gui.ScaledResolution
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f5q;
import dev.nuker.pyro.f5t;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5I
extends f5q {
    public BooleanSetting Field4162 = (BooleanSetting)this.Method4959(new BooleanSetting("autocrystal", "AutoCrystal", null, true));
    public BooleanSetting Field4163 = (BooleanSetting)this.Method4959(new BooleanSetting("autotrap", "AutoTrap", null, true));
    public BooleanSetting Field4164 = (BooleanSetting)this.Method4959(new BooleanSetting("speed", "Speed", null, true));
    public BooleanSetting Field4165 = (BooleanSetting)this.Method4959(new BooleanSetting("surround", "Surround", null, true));
    public BooleanSetting Field4166 = (BooleanSetting)this.Method4959(new BooleanSetting("auaa", "Aura", null, true));
    public BooleanSetting Field4167 = (BooleanSetting)this.Method4959(new BooleanSetting("offhand", "Offhand", null, true));
    public float Field4168 = 128.0f;
    public float Field4169;
    public float Field4170 = 64.0f;

    @Override
    public float Method4871() {
        return this.Field4168;
    }

    public void Method458(float f) {
        this.Field4168 = f;
    }

    public f5I() {
        super("pvpinfo", null, 2, null);
    }

    @Override
    public void Method4875(@Nullable f5t f5t2, int n, @Nullable ScaledResolution scaledResolution, float f, float f2) {
        this.Field4168 = 0.0f;
        this.Field4169 = 0.0f;
        this.Method5803(this.Field4162, "" + (Object)ChatFormatting.GRAY + "AC" + (Object)ChatFormatting.RESET, PyroStatic.Field6416);
        this.Method5803(this.Field4163, "" + (Object)ChatFormatting.GRAY + "AT" + (Object)ChatFormatting.RESET, PyroStatic.Field6444);
        this.Method5803(this.Field4164, "" + (Object)ChatFormatting.GRAY + "S" + (Object)ChatFormatting.RESET, PyroStatic.Field6430);
        this.Method5803(this.Field4165, "" + (Object)ChatFormatting.GRAY + "Surr" + (Object)ChatFormatting.RESET, PyroStatic.Field6408);
        this.Method5803(this.Field4166, "" + (Object)ChatFormatting.GRAY + "KA" + (Object)ChatFormatting.RESET, PyroStatic.Field6445);
        this.Method5803(this.Field4167, "" + (Object)ChatFormatting.GRAY + "Offhand" + (Object)ChatFormatting.RESET, PyroStatic.Field6490);
        this.Field4170 = this.Field4169;
    }

    public void Method737(float f) {
        this.Field4169 = f;
    }

    public float Method740() {
        return this.Field4170;
    }

    public float Method4828() {
        return this.Field4169;
    }

    @Override
    public boolean Method4872() {
        return false;
    }

    @Override
    public float Method4873() {
        return this.Field4170;
    }

    public void Method5803(@NotNull BooleanSetting booleanSetting, @NotNull String string, @NotNull Module module) {
        if (((Boolean)booleanSetting.Method7979()).booleanValue()) {
            String string2 = (Boolean)module.Field5236.Method5264() != false ? string + " ON" : string + " OFF";
            int n = ((Boolean)module.Field5236.Method5264()).booleanValue() ? f0H.Field5479.Method7719() : -1;
            float f = PyroRenderUtil.Method12314(string2);
            if (f > this.Field4168) {
                this.Field4168 = f;
            }
            PyroRenderUtil.Method12313(string2, 0.0f, this.Field4169, n);
            this.Field4169 += PyroRenderUtil.Method740();
        }
    }

    public void Method735(float f) {
        this.Field4170 = f;
    }

    public float Method5094() {
        return this.Field4168;
    }
}

