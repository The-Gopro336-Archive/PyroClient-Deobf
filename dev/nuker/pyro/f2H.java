/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.text.Style
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.TextFormatting
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.LiteralMessage;
import com.mojang.brigadier.Message;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f1s;
import dev.nuker.pyro.f2M;
import java.util.Arrays;
import java.util.Optional;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import org.jetbrains.annotations.Nullable;

public class f2H
implements Command {
    public static f2H Field3759 = new f2H();

    public int Method152(@Nullable CommandContext commandContext) {
        String string = StringArgumentType.Method5880(commandContext, "module");
        Optional optional = f2M.Method5498(f2M.Field3773, string);
        if (optional.isPresent()) {
            if (((Boolean)((Module)optional.get()).Field5236.Method5264()).booleanValue()) {
                CommandContext commandContext2 = commandContext;
                if (commandContext2 == null) {
                    Intrinsics.Method6551();
                }
                Object s = commandContext2.Method6876();
                if (s == null) {
                    Intrinsics.Method6551();
                }
                ((f1s)s).Method5489(new TextComponentString("Module Already Enabled: ").appendSibling(new TextComponentString(((Module)optional.get()).Method7265()).setStyle(new Style().setColor(TextFormatting.DARK_AQUA))));
            } else {
                ((Module)optional.get()).Field5236.Method5266((Object)true);
                CommandContext commandContext3 = commandContext;
                if (commandContext3 == null) {
                    Intrinsics.Method6551();
                }
                Object s = commandContext3.Method6876();
                if (s == null) {
                    Intrinsics.Method6551();
                }
                ((f1s)s).Method5489(new TextComponentString("Enabled Module: ").appendSibling(new TextComponentString(((Module)optional.get()).Method7265()).setStyle(new Style().setColor(TextFormatting.DARK_AQUA))));
            }
        } else {
            String string2;
            StringCompanionObject stringCompanionObject = StringCompanionObject.Field4618;
            String string3 = "Module %s does not exist";
            Object[] arrobject = new Object[]{string};
            boolean bl = false;
            String string4 = string2 = String.format(string3, Arrays.copyOf(arrobject, arrobject.length));
            Message message = new LiteralMessage(string4);
            throw (Throwable)new SimpleCommandExceptionType(message).Method3035();
        }
        return 0;
    }
}

