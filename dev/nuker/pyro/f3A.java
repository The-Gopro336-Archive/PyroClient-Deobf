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
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

public class f3A
implements Command {
    public static f3A Field3853 = new f3A();

    public int Method152(@Nullable CommandContext commandContext) {
        String string = StringArgumentType.Method5880(commandContext, "module");
        for (Module module : Class34.Field4599.Method6756()) {
            String string2 = module.Method7265();
            if (!StringsKt.Method9997(string2, string, true)) continue;
            module.Field5236.Method5266((Object)((Boolean)module.Field5236.Method5264() == false ? 1 : 0));
            if (((Boolean)module.Field5236.Method5264()).booleanValue()) {
                Pyro.Field6182.Method8989("" + module.Method7265() + " is now " + (Object)ChatFormatting.GREEN + "enabled.");
                break;
            }
            Pyro.Field6182.Method8989(module.Method7265() + " is now " + (Object)ChatFormatting.RED + "disabled.");
            break;
        }
        return 0;
    }
}

