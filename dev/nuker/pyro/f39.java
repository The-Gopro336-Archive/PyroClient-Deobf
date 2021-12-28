/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f66;
import dev.nuker.pyro.f67;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public class f39
implements Command {
    public static f39 Field3813 = new f39();

    public int Method152(CommandContext commandContext) {
        Object v0;
        String string;
        block3: {
            string = StringArgumentType.Method5880(commandContext, "name");
            List list = f67.Field4191.Method5825();
            Iterable iterable = list;
            boolean bl = false;
            for (Object t : iterable) {
                f66 f662 = (f66)t;
                boolean bl2 = false;
                if (!Intrinsics.Method6572(f662.Method5810(), string)) continue;
                v0 = t;
                break block3;
            }
            v0 = null;
        }
        f66 f663 = v0;
        if (f663 == null) {
            f67.Field4191.Method5823(new f66(new File(Pyro.Field6178, "profiles/" + string), string));
            Pyro.Field6182.Method8989((Object)ChatFormatting.GREEN + "Created profile " + string);
        } else {
            Pyro.Field6182.Method8989((Object)ChatFormatting.RED + "Profile " + string + " already exists");
        }
        return 0;
    }
}

