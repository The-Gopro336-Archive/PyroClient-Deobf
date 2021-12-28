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
import dev.nuker.pyro.f3G;
import dev.nuker.pyro.f3e;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

public class f3H {
    public static f3H Field3880;

    static {
        f3H f3H2;
        Field3880 = f3H2 = new f3H();
    }

    @JvmStatic
    public static void Method5589(@NotNull CommandDispatcher commandDispatcher) {
        commandDispatcher.Method8399((LiteralArgumentBuilder)f3e.Method5657("watermark").Method12041(f3e.Method5658("watermark", StringArgumentType.Method5879()).Method12044(f3G.Field3876)));
    }
}

