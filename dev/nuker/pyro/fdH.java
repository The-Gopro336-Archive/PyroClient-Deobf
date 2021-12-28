/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.util.Timer
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f04;
import dev.nuker.pyro.f07;
import dev.nuker.pyro.f0b;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.fdG;
import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.mixin.MinecraftAccessor;
import dev.nuker.pyro.mixin.TimerAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Arrays;
import kotlin.TypeCastException;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.Timer;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fdH
extends Module {
    @NotNull
    public DoubleSetting Field241 = (DoubleSetting)this.Method7264(new DoubleSetting("multiplier", "Multiplier", null, 2.0, 0.1, 10.0, 0.0, 64, null));
    @NotNull
    public BooleanSetting Field242 = (BooleanSetting)this.Method7264(new BooleanSetting("tpsSync", "TPSSync", null, false));

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        f0b.Field5568.Method7904("timer");
        if (bl) {
            f0b.Field5568.Method7902("timer", f07.MULTIPLY, (float)((Number)this.Field241.Method7979()).doubleValue());
        }
    }

    @f0g
    @LauncherEventHide
    public void Method183(@NotNull f4t f4t2) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.Field4618;
        String string = "%.2f";
        Object[] arrobject = new Object[1];
        Minecraft minecraft = fdZ.Field313;
        if (minecraft == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.MinecraftAccessor");
        }
        Timer timer = ((MinecraftAccessor)minecraft).Method6086();
        if (timer == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.TimerAccessor");
        }
        arrobject[0] = Float.valueOf((float)50 / ((TimerAccessor)timer).Method12405());
        Object[] arrobject2 = arrobject;
        fdH fdH2 = this;
        boolean bl = false;
        String string2 = String.format(string, Arrays.copyOf(arrobject2, arrobject2.length));
        fdH2.Method7274(string2);
        if (((Boolean)this.Field242.Method7979()).booleanValue()) {
            f0b.Field5568.Method7902("timer", f07.MULTIPLY, (float)50 / RangesKt.Method4267(500.0f, 50.0f * ((float)20 / f04.Field5418.Method7642())));
        } else {
            f0b.Field5568.Method7902("timer", f07.MULTIPLY, (float)((Number)this.Field241.Method7979()).doubleValue());
        }
    }

    @NotNull
    public BooleanSetting Method215() {
        return this.Field242;
    }

    public fdH() {
        super("timer", "Timer", "Change the clientside tick speed");
        this.Field241.Method7980(new fdG(this));
    }

    @NotNull
    public DoubleSetting Method218() {
        return this.Field241;
    }
}

