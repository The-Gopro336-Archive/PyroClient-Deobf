/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import dev.nuker.pyro.Class34;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f1s;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f2x
implements Command {
    public static f2x Field3949 = new f2x();

    public int Method152(CommandContext commandContext) {
        for (Module module : Class34.Field4599.Method6756()) {
            module.Field5236.Method5266((Object)false);
        }
        ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString("All modules turned off."));
        return 0;
    }
}

