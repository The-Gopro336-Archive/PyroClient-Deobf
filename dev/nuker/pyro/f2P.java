/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0H;
import org.jetbrains.annotations.Nullable;

public class f2p
implements Command {
    public static f2p Field3919 = new f2p();

    public int Method152(@Nullable CommandContext commandContext) {
        double d;
        f0H.Field5478 = d = DoubleArgumentType.Method8094(commandContext, "scale");
        Pyro.Field6182.Method8989("Set the gui scale to " + d);
        return 0;
    }
}

