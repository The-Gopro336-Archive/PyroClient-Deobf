/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.Timer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f05;
import dev.nuker.pyro.f06;
import dev.nuker.pyro.f07;
import dev.nuker.pyro.f08;
import dev.nuker.pyro.f09;
import dev.nuker.pyro.f0a;
import dev.nuker.pyro.mixin.MinecraftAccessor;
import dev.nuker.pyro.mixin.TimerAccessor;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Timer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f0b {
    public Map<String, f08> Field5564;
    public Map<String, f06> Field5565;
    public boolean Field5566;
    public Minecraft Field5567;
    @JvmField
    @NotNull
    public static f0b Field5568;
    public static f05 Field5569;

    public void Method7899(@NotNull String string) {
        this.Field5565.remove(string);
    }

    public void Method7900(@NotNull String string, @NotNull f08 f082) {
        this.Field5564.put(string, f082);
    }

    public f0b(@NotNull Minecraft minecraft) {
        this.Field5567 = minecraft;
        this.Field5564 = new HashMap();
        this.Field5565 = new HashMap();
    }

    static {
        Field5569 = new f05(null);
        Field5568 = new f0b(Minecraft.getMinecraft());
    }

    public void Method7901(@NotNull String string, float f, @NotNull Runnable runnable) {
        this.Field5565.put(string, new f09(runnable, f, f));
    }

    public void Method7902(@NotNull String string, @NotNull f07 f072, float f) {
        this.Method7900(string, new f08(f072, f));
    }

    @Nullable
    public f06 Method7903(@NotNull String string) {
        return this.Field5565.get(string);
    }

    public void Method7904(@NotNull String string) {
        this.Field5564.remove(string);
    }

    public void Method7905() {
        Minecraft minecraft = this.Field5567;
        if (minecraft == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.MinecraftAccessor");
        }
        Timer timer = ((MinecraftAccessor)minecraft).Method6086();
        if (timer == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.TimerAccessor");
        }
        TimerAccessor timerAccessor = (TimerAccessor)timer;
        float f = 50.0f;
        if (this.Field5564.isEmpty()) {
            if (this.Field5566) {
                timerAccessor.Method12406(f);
                this.Field5566 = false;
            }
        } else {
            Optional<f08> optional = this.Field5564.values().stream().filter(f0a.Field5562).findFirst();
            if (optional.isPresent()) {
                f = optional.get().Method7604();
            } else {
                for (f08 f082 : this.Field5564.values()) {
                    f *= 1.0f / f082.Method7604();
                }
            }
            timerAccessor.Method12406(f);
            this.Field5566 = true;
        }
    }

    public void Method7906() {
        for (f06 f062 : this.Field5565.values()) {
            f062.Method7683().updateTimer();
            int n = f062.Method7683().elapsedTicks;
            for (int i = 0; i < n; ++i) {
                f062.Method7607();
            }
        }
    }
}

