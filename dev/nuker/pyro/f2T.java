/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import dev.nuker.pyro.Config;
import dev.nuker.pyro.f1s;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import org.jetbrains.annotations.NotNull;

public class f2t
implements Command {
    public CommandDispatcher Field3902;

    public int Method152(@NotNull CommandContext commandContext) {
        ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString("Pyro Commands: "));
        for (String string : this.Field3902.Method8409(this.Field3902.Method8413(), commandContext.Method6876()).values()) {
            ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString(Config.Field3937.Field3931 + string));
        }
        return 0;
    }

    public f2t(CommandDispatcher commandDispatcher) {
        this.Field3902 = commandDispatcher;
    }
}

