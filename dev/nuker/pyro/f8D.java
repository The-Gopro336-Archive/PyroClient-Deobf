/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.ServerData
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f4j;
import dev.nuker.pyro.f8a;
import dev.nuker.pyro.f8b;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.io.File;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f8d
extends Module {
    @NotNull
    public f0o<f8a> Field3585 = (f0o)this.Method7264(new f0o("mode", "Mode", "The way suffix picks your current suffix", f8a.Random));
    @NotNull
    public List<String> Field3586 = CollectionsKt.Method9007("\u00bb \u0489 \u1d18\u028f\u0280\u1d0f \u1d04\u029f\u026a\u1d07\u0274\u1d1b \u0489");
    public int Field3587;

    @NotNull
    public f0o Method2672() {
        return this.Field3585;
    }

    public void Method541(int n) {
        this.Field3587 = n;
    }

    @NotNull
    public String Method5364() {
        String string;
        if (this.Field3586.isEmpty()) {
            string = "";
        } else {
            switch (f8b.Field3521[((f8a)((Object)this.Field3585.Method7979())).ordinal()]) {
                case 1: {
                    Collection collection = this.Field3586;
                    boolean bl = false;
                    string = (String)CollectionsKt.Method3094(collection, Random.Field4299);
                    break;
                }
                case 2: {
                    f8d f8d2 = this;
                    ++f8d2.Field3587;
                    if (f8d2.Field3587 >= this.Field3586.size()) {
                        this.Field3587 = 0;
                    }
                    string = this.Field3586.get(this.Field3587);
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        return string;
    }

    public void Method5281() {
        if (new File("pyro/chatsuffix.txt").exists()) {
            this.Field3586 = FilesKt.Method8762(new File("pyro/chatsuffix.txt"), Charsets.Field5722);
        } else {
            FilesKt.Method8752(new File("pyro/chatsuffix.txt"), CollectionsKt.Method3238(this.Field3586, "\n", null, null, 0, null, null, 62, null), Charsets.Field5722);
        }
    }

    @f0g
    @LauncherEventHide
    public void Method5362(@NotNull f4j f4j2) {
        if (this.Field5233.getCurrentServerData() != null) {
            ServerData serverData = this.Field5233.getCurrentServerData();
            if (serverData == null) {
                Intrinsics.Method6551();
            }
            if (StringsKt.Method11503(serverData.serverIP, "2b2t.org", false, 2, null)) {
                return;
            }
        }
        if (StringsKt.Method9998(f4j2.Method5798(), "/", false, 2, null)) {
            return;
        }
        f4j f4j3 = f4j2;
        f4j3.Method5797(f4j3.Method5798() + ' ' + this.Method5364());
    }

    public int Method547() {
        return this.Field3587;
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        this.Method5281();
        Pyro.Field6182.Method8989("You can customize the ChatSuffix in chatsuffix.txt");
    }

    public f8d() {
        super("chatsuffix", "ChatSuffix", null);
    }

    @NotNull
    public List Method5365() {
        return this.Field3586;
    }

    public void Method4841(@NotNull List list) {
        this.Field3586 = list;
    }
}

