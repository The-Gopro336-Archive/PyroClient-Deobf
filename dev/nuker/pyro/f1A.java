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

public class f1a
implements Command {
    public static f1a Field3721 = new f1a();

    public int Method152(CommandContext commandContext) {
        ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString("Attempting to connect to port " + IntegerArgumentType.Method9838(commandContext, "port")));
        PyroStatic.Field6541.Method5006("localhost", IntegerArgumentType.Method9838(commandContext, "port"));
        return 0;
    }
}

