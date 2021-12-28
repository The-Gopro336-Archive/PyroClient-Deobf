/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Config;
import dev.nuker.pyro.Pyro;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=1, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0006\u0010\u0007\u001a\u00020\u0006R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Ldev/nuker/pyro/Config$Companion;", "", "()V", "INSTANCE", "Ldev/nuker/pyro/Config;", "load", "", "save", "pyroclient"})
public final class Config$Companion {
    public final void Method5382() {
        try {
            FileWriter writer = new FileWriter("pyro/config.json");
            Pyro.Field6181.toJson((Object)Config.Field3937, (Appendable)writer);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @JvmStatic
    public final void Method5383() {
        if (new File("pyro/config.json").exists()) {
            try {
                FileReader reader = new FileReader("pyro/config.json");
                Object object = Pyro.Field6181.fromJson((Reader)reader, Config.class);
                Intrinsics.Method6561(object, "Pyro.GSON.fromJson(reader, Config::class.java)");
                Config.Field3937 = (Config)object;
                reader.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Config$Companion() {
    }

    public /* synthetic */ Config$Companion(DefaultConstructorMarker $constructor_marker) {
        this();
    }
}

