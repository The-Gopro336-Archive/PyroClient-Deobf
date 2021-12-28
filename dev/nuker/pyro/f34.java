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
import dev.nuker.pyro.f33;
import dev.nuker.pyro.f3e;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

public class f34 {
    public static f34 Field3768;

    @JvmStatic
    public static void Method5486(@NotNull CommandDispatcher commandDispatcher) {
        commandDispatcher.Method8399((LiteralArgumentBuilder)f3e.Method5657("prefix").Method12041(f3e.Method5658("prefix", StringArgumentType.Method5879()).Method12044(f33.Field3765)));
    }

    static {
        f34 f342;
        Field3768 = f342 = new f34();
    }
}

