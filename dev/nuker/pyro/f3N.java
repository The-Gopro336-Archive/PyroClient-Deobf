/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.nuker.pyro.f3e;
import dev.nuker.pyro.f3m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f3n {
    @Nullable
    public static String Field4074;
    public static f3n Field4075;

    static {
        f3n f3n2;
        Field4075 = f3n2 = new f3n();
    }

    public void Method5726(@NotNull CommandDispatcher commandDispatcher) {
        commandDispatcher.Method8399((LiteralArgumentBuilder)f3e.Method5657("say").Method12041(f3e.Method5658("message", StringArgumentType.Method5879()).Method12044(f3m.Field4025)));
    }

    public void Method5727(@Nullable String string) {
        Field4074 = string;
    }

    @Nullable
    public String Method5728() {
        return Field4074;
    }
}

