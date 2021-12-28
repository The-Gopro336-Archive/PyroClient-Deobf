/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f43;
import dev.nuker.pyro.f5T;
import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.fe8;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5C
extends f5T {
    public fe8 Field4143 = new fe8();
    @NotNull
    public String Field4144 = "FPS";
    public int[] Field4145 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public f5C() {
        super("fps");
    }

    @Override
    @NotNull
    public String Method4969() {
        return this.Field4144;
    }

    public int Method2376() {
        int n = 0;
        for (int n2 : this.Field4145) {
            n += n2;
        }
        return n / 10;
    }

    @Override
    public int Method4968(@Nullable ScaledResolution scaledResolution, float f, float f2) {
        return 0xAAAAAA;
    }

    @f0g
    @LauncherEventHide
    public void Method840(@NotNull f43 f432) {
        block6: {
            block5: {
                if (f432.Method5619() != f41.Pre) break block5;
                if (fdZ.Field313.world != null && fdZ.Field313.player != null) break block6;
            }
            return;
        }
        if (this.Field4143.Method491(1000.0)) {
            this.Field4143.Method490();
            int n = this.Field4145.length - 1;
            for (int i = 0; i < n; ++i) {
                this.Field4145[i] = this.Field4145[i + 1];
            }
            this.Field4145[this.Field4145.length - 1] = Minecraft.getDebugFPS();
        }
        this.Field4144 = "FPS " + (Object)ChatFormatting.WHITE + Minecraft.getDebugFPS() + (Object)ChatFormatting.RESET + " Average " + (Object)ChatFormatting.WHITE + this.Method2376();
    }
}

