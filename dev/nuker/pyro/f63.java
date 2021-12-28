/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f4s;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class f63 {
    public static Minecraft Field4207;
    public static f63 Field4208;

    static {
        f63 f632;
        Field4208 = f632 = new f63();
        Field4207 = Minecraft.getMinecraft();
    }

    public void Method5841() {
        Pyro.Method8978().Method7915(this);
    }

    @f0g
    @LauncherEventHide
    public void Method5842(@NotNull f4s f4s2) {
        if (((Boolean)PyroStatic.Field6408.Method276().Method7979()).booleanValue() && !((Boolean)PyroStatic.Field6408.Field5236.Method5264()).booleanValue() && f63.Field4207.player.onGround) {
            if (PyroStatic.Field6408.Method4844((Entity)f63.Field4207.player)) {
                PyroStatic.Field6408.Field5236.Method5266(true);
            }
        }
    }
}

