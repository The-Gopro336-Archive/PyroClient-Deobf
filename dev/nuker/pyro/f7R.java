/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketKeepAlive
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f49;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.f7q;
import dev.nuker.pyro.fe8;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.TypeCastException;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketKeepAlive;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f7r
extends Module {
    @NotNull
    public DoubleSetting Field3488 = (DoubleSetting)this.Method7264(new DoubleSetting("delay", "Delay", null, 600.0, 1.0, 2000.0, 0.0, 64, null));
    @NotNull
    public fe8 Field3489 = new fe8();
    @NotNull
    public List<CPacketKeepAlive> Field3490 = new CopyOnWriteArrayList();

    @NotNull
    public DoubleSetting Method219() {
        return this.Field3488;
    }

    @f0g
    @LauncherEventHide
    public void Method183(@Nullable f4t f4t2) {
        this.Method7274("" + (int)((Number)this.Field3488.Method7979()).doubleValue() + "ms");
        if (this.Field3489.Method491(((Number)this.Field3488.Method7979()).doubleValue())) {
            this.Field3490.forEach(new f7q(this));
            this.Field3490.clear();
            this.Field3489.Method490();
        }
    }

    public static void Method5275(f7r f7r2, Minecraft minecraft) {
        f7r2.Field5233 = minecraft;
    }

    public void Method4965(@NotNull fe8 fe82) {
        this.Field3489 = fe82;
    }

    @NotNull
    public List Method4843() {
        return this.Field3490;
    }

    public void Method4841(@NotNull List list) {
        this.Field3490 = list;
    }

    public static Minecraft Method5276(f7r f7r2) {
        return f7r2.Field5233;
    }

    @f0g
    @LauncherEventHide
    public void Method2393(@NotNull f49 f492) {
        if (f492.Method5784() instanceof CPacketKeepAlive && f492.Method5619() == f41.Pre) {
            Packet packet = f492.Method5784();
            if (packet == null) {
                throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketKeepAlive");
            }
            if (!this.Field3490.contains((Object)((CPacketKeepAlive)packet))) {
                Packet packet2 = f492.Method5784();
                if (packet2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketKeepAlive");
                }
                this.Field3490.add((CPacketKeepAlive)packet2);
                f492.Method7948();
            }
        }
    }

    public f7r() {
        super("pingspoof", "PingSpoof", null);
    }

    @NotNull
    public fe8 Method5148() {
        return this.Field3489;
    }
}

