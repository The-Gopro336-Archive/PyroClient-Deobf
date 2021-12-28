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
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f1s;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f3o
implements Command {
    public static f3o Field4076 = new f3o();

    public int Method152(CommandContext commandContext) {
        if (PyroStatic.Field6520.Method2488().Method2451().isEmpty()) {
            ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString("There are no listed search blocks"));
        } else {
            for (String string : PyroStatic.Field6520.Method2488().Method2451()) {
                ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString(string));
            }
        }
        return 0;
    }
}

