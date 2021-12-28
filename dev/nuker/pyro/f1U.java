/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.Class2;
import dev.nuker.pyro.Pyro;
import org.jetbrains.annotations.Nullable;

public class f1u
implements Command {
    public static f1u Field3805 = new f1u();

    public int Method152(@Nullable CommandContext commandContext) {
        int n = IntegerArgumentType.Method9838(commandContext, "line");
        String string = StringArgumentType.Method5880(commandContext, "text");
        Class2.Field5304.Method7341(n - 1, string);
        Class2.Field5304.Method7338();
        Pyro.Field6182.Method8989((Object)ChatFormatting.GREEN + "Set custom text for rpc line " + n);
        return 0;
    }
}

