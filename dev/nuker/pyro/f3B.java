/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.nuker.pyro.f3A;
import dev.nuker.pyro.f3e;
import org.jetbrains.annotations.NotNull;

public class f3B {
    public static f3B Field3816;

    public void Method5512(@NotNull CommandDispatcher commandDispatcher) {
        commandDispatcher.Method8399((LiteralArgumentBuilder)f3e.Method5657("toggle").Method12041(f3e.Method5658("module", StringArgumentType.Method5879()).Method12044(f3A.Field3853)));
    }

    static {
        f3B f3B2;
        Field3816 = f3B2 = new f3B();
    }
}

