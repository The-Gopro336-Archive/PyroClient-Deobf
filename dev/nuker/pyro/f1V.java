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
import dev.nuker.pyro.f3e;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class f1V
implements Command {
    public Function1 Field5652;
    public String Field5653;

    public f1V(Function1 function1, String string) {
        this.Field5652 = function1;
        this.Field5653 = string;
    }

    public int Method152(CommandContext commandContext) {
        String string;
        boolean bl = (Boolean)this.Field5652.Method41(true);
        if (bl) {
            string = (Object)TextFormatting.GREEN + "Overwrote friends list with " + this.Field5653 + " friends list";
        } else if (!bl) {
            string = (Object)TextFormatting.RED + "Could not load " + this.Field5653 + " friends list";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        f3e.Field4001.Method5660((ITextComponent)new TextComponentString(string));
        f3e.Field4001.Method5660((ITextComponent)new TextComponentString((Object)TextFormatting.YELLOW + "Most clients cannot reload friends lists ingame. You will have to restart minecraft to see the change."));
        return 0;
    }
}

