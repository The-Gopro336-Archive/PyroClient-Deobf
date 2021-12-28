/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.world.World
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class34;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f44;
import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public class Class26
implements Consumer {
    public Module Field3235;

    public void Method5120(boolean bl) {
        Pyro.Method8978().Method7918(new f44(this.Field3235, bl));
        this.Field3235.Method205(bl, Minecraft.getMinecraft().player, (World)Minecraft.getMinecraft().world);
        Class34.Field4599.Method6753(this.Field3235);
    }

    public void accept(Object object) {
        this.Method5120((Boolean)object);
    }

    public Class26(Module module) {
        this.Field3235 = module;
    }
}

