/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f1s;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f19
implements Command {
    public static f19 Field5532 = new f19();

    public int Method152(CommandContext commandContext) {
        ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString("Attempting to start server with port " + IntegerArgumentType.Method9838(commandContext, "port")));
        PyroStatic.Field6541.Method541(IntegerArgumentType.Method9838(commandContext, "port"));
        return 0;
    }
}

