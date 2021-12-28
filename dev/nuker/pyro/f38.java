/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  org.apache.commons.io.FileUtils
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
import org.apache.commons.io.FileUtils;

public class f38
implements Command {
    public static f38 Field3810 = new f38();

    public int Method152(CommandContext commandContext) {
        Object v0;
        String string;
        block4: {
            string = StringArgumentType.Method5880(commandContext, "name");
            List list = f67.Field4191.Method5825();
            Iterable iterable = list;
            boolean bl = false;
            for (Object t : iterable) {
                f66 f662 = (f66)t;
                boolean bl2 = false;
                if (!Intrinsics.Method6572(f662.Method5810(), string)) continue;
                v0 = t;
                break block4;
            }
            v0 = null;
        }
        f66 f663 = v0;
        if (f663 != null) {
            if (Intrinsics.Method6572(f67.Field4191.Method5824().Method5810(), string)) {
                f67.Field4191.Method5823(f67.Field4191.Method5828());
            }
            FileUtils.deleteDirectory((File)f663.Method5809());
            Pyro.Field6182.Method8989((Object)ChatFormatting.GREEN + "Deleted profile " + string);
        } else {
            Pyro.Field6182.Method8989((Object)ChatFormatting.RED + "Profile " + string + " does not exist");
        }
        return 0;
    }
}

