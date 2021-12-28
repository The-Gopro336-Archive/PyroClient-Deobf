/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Style
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.TextFormatting
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f1s;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class f3c
implements Command {
    public static f3c Field3992 = new f3c();

    public int Method152(CommandContext commandContext) {
        PyroStatic.Field6403.Method2286(new BlockPos(IntegerArgumentType.Method9838(commandContext, "x"), IntegerArgumentType.Method9838(commandContext, "y"), IntegerArgumentType.Method9838(commandContext, "z")));
        ((f1s)commandContext.Method6876()).Method5489(new TextComponentString("Set goal to ").appendSibling(new TextComponentString(PyroStatic.Field6403.Method211().toString()).setStyle(new Style().setColor(TextFormatting.DARK_AQUA))));
        return 0;
    }
}

