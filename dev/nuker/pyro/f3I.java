/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.Class29;
import dev.nuker.pyro.Pyro;
import org.jetbrains.annotations.Nullable;

public class f3i
implements Command {
    public static f3i Field4045 = new f3i();

    public int Method152(@Nullable CommandContext commandContext) {
        Class29.Field3216.Method7300().Method455();
        Pyro.Field6182.Method8989((Object)ChatFormatting.GREEN + "Reloaded macros");
        return 0;
    }
}

