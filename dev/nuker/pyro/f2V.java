/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Iterables
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import com.google.common.collect.Iterables;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.context.ParsedCommandNode;
import dev.nuker.pyro.Config;
import dev.nuker.pyro.f1s;
import dev.nuker.pyro.f2w;
import java.util.Iterator;
import java.util.Map;
import kotlin.TypeCastException;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import org.jetbrains.annotations.NotNull;

public class f2v
implements Command {
    public CommandDispatcher Field3943;

    public int Method152(@NotNull CommandContext commandContext) {
        ParseResults parseResults = this.Field3943.Method8404(StringArgumentType.Method5880(commandContext, "command"), commandContext.Method6876());
        if (parseResults.Method8971().Method7119().isEmpty()) {
            throw (Throwable)f2w.Method5639(f2w.Field3947).Method3035();
        }
        ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString("Usage: "));
        Map map = this.Field3943.Method8409(((ParsedCommandNode)Iterables.getLast((Iterable)parseResults.Method8971().Method7119())).Method5996(), commandContext.Method6876());
        Iterator<String> iterator2 = map.values().iterator();
        while (iterator2.hasNext()) {
            String string;
            if (iterator2.next() == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
            Object s = commandContext.Method6876();
            if (s == null) {
                throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.command.CommandSource");
            }
            ((f1s)s).Method5489((ITextComponent)new TextComponentString(Config.Field3937.Field3931 + parseResults.Method8972().Method9084() + " " + string));
        }
        return map.size();
    }

    public f2v(CommandDispatcher commandDispatcher) {
        this.Field3943 = commandDispatcher;
    }
}

