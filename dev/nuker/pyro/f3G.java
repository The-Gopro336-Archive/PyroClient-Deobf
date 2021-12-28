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

public class f3G
implements Command {
    public static f3G Field3876 = new f3G();

    public int Method152(@NotNull CommandContext commandContext) {
        Config.Field3937.Field3935 = StringArgumentType.Method5880(commandContext, "watermark");
        Config.Field3938.Method5382();
        ((f1s)commandContext.Method6876()).Method5489(new TextComponentString("Changed the watermark to ").appendSibling(new TextComponentString(Config.Field3937.Field3935).setStyle(new Style().setColor(TextFormatting.DARK_AQUA))));
        return 0;
    }
}

