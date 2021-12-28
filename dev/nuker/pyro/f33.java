/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.text.Style
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.TextFormatting
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import dev.nuker.pyro.Config;
import dev.nuker.pyro.f1s;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import org.jetbrains.annotations.NotNull;

public class f33
implements Command {
    public static f33 Field3765 = new f33();

    public int Method152(@NotNull CommandContext commandContext) {
        Config.Field3937.Field3931 = StringArgumentType.Method5880(commandContext, "prefix");
        Config.Field3938.Method5382();
        ((f1s)commandContext.Method6876()).Method5489(new TextComponentString("Changed prefix to ").appendSibling(new TextComponentString(Config.Field3937.Field3931).setStyle(new Style().setColor(TextFormatting.DARK_AQUA))));
        return 0;
    }
}

