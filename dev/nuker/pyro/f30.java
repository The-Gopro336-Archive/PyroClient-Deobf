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
import dev.nuker.pyro.f3c;
import dev.nuker.pyro.f3e;
import org.jetbrains.annotations.NotNull;

public class f30 {
    public static f30 Field3778;

    static {
        f30 f302;
        Field3778 = f302 = new f30();
    }

    public void Method5501(@NotNull CommandDispatcher commandDispatcher) {
        commandDispatcher.Method8399((LiteralArgumentBuilder)f3e.Method5657("path").Method12041(f3e.Method5658("x", IntegerArgumentType.Method9835()).Method12041(f3e.Method5658("y", IntegerArgumentType.Method9837(0, 255)).Method12041(f3e.Method5658("z", IntegerArgumentType.Method9835()).Method12044(f3c.Field3992)))));
    }
}

