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
import dev.nuker.pyro.f25;
import dev.nuker.pyro.f26;
import dev.nuker.pyro.f27;
import dev.nuker.pyro.f28;
import dev.nuker.pyro.f29;
import dev.nuker.pyro.f2a;
import dev.nuker.pyro.f3e;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class f2b
implements Command {
    public static f2b Field3818 = new f2b();

    public int Method152(CommandContext commandContext) {
        f3e.Field4001.Method5660((ITextComponent)new TextComponentString((Object)TextFormatting.GREEN + "Attempting to overwrite other clients' friend lists"));
        f3e.Field4001.Method5660((ITextComponent)new TextComponentString((Object)TextFormatting.YELLOW + "Most clients cannot reload friends lists ingame. You will have to restart minecraft to see the change."));
        f25 f252 = f25.Field5642;
        f252.Method7993("future", f26.Field5651);
        f252.Method7993("impact", f27.Field5654);
        f252.Method7993("summit", f28.Field5659);
        f252.Method7993("salhack", f29.Field5632);
        f252.Method7993("ares", f2a.Field3815);
        return 0;
    }
}

