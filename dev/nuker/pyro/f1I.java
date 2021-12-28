/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.TextFormatting
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import dev.nuker.pyro.f1R;
import dev.nuker.pyro.f3e;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class f1I
implements Command {
    public static f1I Field5584 = new f1I();

    public int Method152(CommandContext commandContext) {
        f1R.Field5610.Method7958();
        f3e.Field4001.Method5660((ITextComponent)new TextComponentString((Object)TextFormatting.GREEN + "Deleted all fake players"));
        return 0;
    }
}

