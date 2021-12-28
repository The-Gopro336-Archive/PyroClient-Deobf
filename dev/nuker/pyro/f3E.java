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
import dev.nuker.pyro.f1s;
import dev.nuker.pyro.fdZ;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f3E
implements Command {
    public static f3E Field3823 = new f3E();

    public int Method152(CommandContext commandContext) {
        int n = IntegerArgumentType.Method9838(commandContext, "distance");
        fdZ.Field313.player.setPosition(fdZ.Field313.player.posX, fdZ.Field313.player.posY + (double)n, fdZ.Field313.player.posZ);
        ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString("Teleported you " + n + " blocks in the air."));
        return 0;
    }
}

