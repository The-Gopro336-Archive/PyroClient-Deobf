/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketChunkData
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Module;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0l;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4B;
import dev.nuker.pyro.f4e;
import dev.nuker.pyro.f79;
import dev.nuker.pyro.f7a;
import dev.nuker.pyro.fe3;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.TypeCastException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketChunkData;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f7b
extends Module {
    @NotNull
    public f0l Field3394 = (f0l)this.Method7264(new f0l("color", "Color", null, f00.Field5379.Method7930(0.6f, 0.0f, 0.9333333f, 0.5f)));
    @NotNull
    public List<fe3<Integer, Integer>> Field3395 = new CopyOnWriteArrayList();

    public static Minecraft Method5203(f7b f7b2) {
        return f7b2.Field5233;
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
    }

    @f0g
    @LauncherEventHide
    public void Method244(@NotNull f4e f4e2) {
        if (f4e2.Method5619() != f41.Pre) {
            return;
        }
        if (f4e2.Method5784() instanceof SPacketChunkData) {
            Packet packet = f4e2.Method5784();
            if (packet == null) {
                throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketChunkData");
            }
            SPacketChunkData sPacketChunkData = (SPacketChunkData)packet;
            if (!sPacketChunkData.isFullChunk()) {
                this.Field3395.removeIf(new f7a(sPacketChunkData));
                fe3 fe32 = new fe3(sPacketChunkData.getChunkX(), sPacketChunkData.getChunkZ());
                if (!this.Field3395.contains(fe32)) {
                    this.Field3395.add(fe32);
                }
            }
        }
    }

    @NotNull
    public List Method4843() {
        return this.Field3395;
    }

    public f7b() {
        super("newchunks", "NewChunks", "Renders chunks that are classified as new on Spigot servers");
    }

    @f0g
    @LauncherEventHide
    public void Method5204(@Nullable f4B f4B2) {
        this.Field3395.forEach(new f79(this));
    }

    public static void Method5205(f7b f7b2, Minecraft minecraft) {
        f7b2.Field5233 = minecraft;
    }

    public void Method4841(@NotNull List list) {
        this.Field3395 = list;
    }

    @NotNull
    public f0l Method239() {
        return this.Field3394;
    }
}

