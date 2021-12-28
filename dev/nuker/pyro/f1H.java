/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import dev.nuker.pyro.f19;
import dev.nuker.pyro.f1a;
import dev.nuker.pyro.f1b;
import dev.nuker.pyro.f1d;
import dev.nuker.pyro.f1e;
import dev.nuker.pyro.f1f;
import dev.nuker.pyro.f1g;
import dev.nuker.pyro.f3e;
import org.jetbrains.annotations.NotNull;

public class f1h {
    public static f1h Field3735;

    public void Method5471(@NotNull CommandDispatcher commandDispatcher) {
        commandDispatcher.Method8399((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.Method5657("autodupe").Method12041(f3e.Method5657("host").Method12041(f3e.Method5658("port", IntegerArgumentType.Method9835()).Method12044(f19.Field5532)))).Method12041(f3e.Method5657("connect").Method12041(((RequiredArgumentBuilder)f3e.Method5658("port", IntegerArgumentType.Method9835()).Method12044(f1a.Field3721)).Method12041(f3e.Method5658("host", StringArgumentType.Method5879()).Method12044(f1b.Field3723))))).Method12041(f3e.Method5657("ping").Method12044(f1d.Field3752))).Method12041(f3e.Method5657("startPos").Method12044(f1e.Field3754))).Method12041(f3e.Method5657("quarryPos").Method12044(f1f.Field3756))).Method12041(f3e.Method5657("button").Method12044(f1g.Field3758)));
    }

    static {
        f1h f1h2;
        Field3735 = f1h2 = new f1h();
    }
}

