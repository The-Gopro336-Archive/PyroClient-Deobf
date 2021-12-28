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
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import dev.nuker.pyro.f3N;
import dev.nuker.pyro.f3O;
import dev.nuker.pyro.f3P;
import dev.nuker.pyro.f3Q;
import dev.nuker.pyro.f3R;
import dev.nuker.pyro.f3e;
import org.jetbrains.annotations.NotNull;

public class f3S {
    public static f3S Field3895;

    public void Method5593(@NotNull CommandDispatcher commandDispatcher) {
        commandDispatcher.Method8399((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.Method5657("xray").Method12041(f3e.Method5657("list").Method12044(f3N.Field3906))).Method12041(f3e.Method5657("add").Method12041(((RequiredArgumentBuilder)f3e.Method5658("block", StringArgumentType.Method5879()).Method12044(f3O.Field3908)).Method1114(f3P.Field3917)))).Method12041(f3e.Method5657("del").Method12041(((RequiredArgumentBuilder)f3e.Method5658("block", StringArgumentType.Method5879()).Method12044(f3Q.Field3920)).Method1114(f3R.Field3893))));
    }

    static {
        f3S f3S2;
        Field3895 = f3S2 = new f3S();
    }
}

