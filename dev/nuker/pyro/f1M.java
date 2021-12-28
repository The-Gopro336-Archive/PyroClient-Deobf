/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.GameType
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import com.mojang.brigadier.SingleRedirectModifier;
import com.mojang.brigadier.context.CommandContext;
import dev.nuker.pyro.f1s;
import net.minecraft.world.GameType;
import org.jetbrains.annotations.NotNull;

public class f1M
implements SingleRedirectModifier {
    public static f1M Field5621 = new f1M();

    public Object Method4086(CommandContext commandContext) {
        return this.Method7926(commandContext);
    }

    @NotNull
    public f1s Method7926(CommandContext commandContext) {
        return ((f1s)commandContext.Method6876()).Method5490("gamemode", (Object)GameType.SURVIVAL);
    }
}

