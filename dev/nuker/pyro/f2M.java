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
import dev.nuker.pyro.f1U;
import dev.nuker.pyro.f1V;
import dev.nuker.pyro.f1W;
import dev.nuker.pyro.f1X;
import dev.nuker.pyro.f1Y;
import dev.nuker.pyro.f1Z;
import dev.nuker.pyro.f20;
import dev.nuker.pyro.f21;
import dev.nuker.pyro.f22;
import dev.nuker.pyro.f23;
import dev.nuker.pyro.f24;
import dev.nuker.pyro.f2b;
import dev.nuker.pyro.f2c;
import dev.nuker.pyro.f2d;
import dev.nuker.pyro.f2e;
import dev.nuker.pyro.f2f;
import dev.nuker.pyro.f2g;
import dev.nuker.pyro.f2h;
import dev.nuker.pyro.f2i;
import dev.nuker.pyro.f2j;
import dev.nuker.pyro.f2k;
import dev.nuker.pyro.f2l;
import dev.nuker.pyro.f3e;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

public class f2m {
    public static f2m Field3905;

    @JvmStatic
    public static void Method5605(@NotNull CommandDispatcher commandDispatcher) {
        commandDispatcher.Method8399((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.Method5657("friend").Method12041(f3e.Method5657("add").Method12041(f3e.Method5658("name", StringArgumentType.Method5879()).Method12044(f1Y.Field5634)))).Method12041(f3e.Method5657("del").Method12041(((RequiredArgumentBuilder)f3e.Method5658("name", StringArgumentType.Method5878()).Method12044(f2e.Field3873)).Method1114(f2f.Field3875)))).Method12041(f3e.Method5657("list").Method12044(f2g.Field3879))).Method12041(f3e.Method5657("clear").Method12044(f2h.Field3881))).Method12041(f3e.Method5657("reload").Method12044(f2i.Field3865))).Method12041(((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.Method5657("sync").Method12041(Field3905.Method5606("future", f2j.Field3867, f2k.Field3869))).Method12041(Field3905.Method5606("impact", f2l.Field3871, f1Z.Field5636))).Method12041(Field3905.Method5606("summit", f2c.Field3820, f20.Field5624))).Method12041(Field3905.Method5606("salhack", f21.Field5601, f22.Field5603))).Method12041(Field3905.Method5606("ares", f23.Field5611, f24.Field5615))).Method12041(f3e.Method5657("overwrite_all").Method12044(f2b.Field3818)))).Method12041(f3e.Method5657("alias").Method12041(f3e.Method5658("name", StringArgumentType.Method5879()).Method12044(f2d.Field3822))));
    }

    static {
        f2m f2m2;
        Field3905 = f2m2 = new f2m();
    }

    public LiteralArgumentBuilder Method5606(String string, Function1 function1, Function1 function12) {
        return (LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.Method5657(string).Method12041(((LiteralArgumentBuilder)f3e.Method5657("load").Method12044(new f1U(function1, string))).Method12041(f3e.Method5657("overwrite").Method12044(new f1V(function1, string))))).Method12041(((LiteralArgumentBuilder)f3e.Method5657("save").Method12044(new f1W(function12, string))).Method12041(f3e.Method5657("overwrite").Method12044(new f1X(function12, string))));
    }
}

