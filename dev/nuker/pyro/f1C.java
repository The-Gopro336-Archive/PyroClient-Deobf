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

public class f1C
implements Command {
    public static f1C Field5570 = new f1C();

    public int Method152(CommandContext commandContext) {
        if (((Boolean)PyroStatic.Field6548.Field5236.Method5264()).booleanValue()) {
            PyroStatic.Field6548.Method2407(null);
            ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString("Reset the riding entity"));
        } else {
            ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString("You have not forced a dismount."));
        }
        return 0;
    }
}

