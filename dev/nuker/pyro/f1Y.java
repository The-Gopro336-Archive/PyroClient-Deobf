/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.Class34;
import dev.nuker.pyro.Class8;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

public class f1y
implements Command {
    public static f1y Field3785 = new f1y();

    public int Method152(@Nullable CommandContext commandContext) {
        String string = StringArgumentType.Method5880(commandContext, "module");
        for (Module module : Class34.Field4599.Method6756()) {
            String string2 = module.Method7265();
            if (!StringsKt.Method9997(string2, string, true)) continue;
            module.Method7269().Method5266((Boolean)module.Method7269().Method5264() == false);
            if (((Boolean)module.Method7269().Method5264()).booleanValue()) {
                Pyro.Field6182.Method8989("" + module.Method7265() + " is now " + (Object)ChatFormatting.RED + "hidden.");
            } else {
                Pyro.Field6182.Method8989(module.Method7265() + " is now " + (Object)ChatFormatting.GREEN + "shown.");
            }
            Class8.Field5278.Method5760(module);
            break;
        }
        return 0;
    }
}

