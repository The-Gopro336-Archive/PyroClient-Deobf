/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.nuker.pyro.f1S;
import dev.nuker.pyro.f3e;
import org.jetbrains.annotations.NotNull;

public class f1T {
    public static f1T Field5641;

    public void Method7992(@NotNull CommandDispatcher commandDispatcher) {
        commandDispatcher.Method8399((LiteralArgumentBuilder)f3e.Method5657("forcemount").Method12041(f3e.Method5658("entityId", IntegerArgumentType.Method9835()).Method12044(f1S.Field5614)));
    }

    static {
        f1T f1T2;
        Field5641 = f1T2 = new f1T();
    }
}

