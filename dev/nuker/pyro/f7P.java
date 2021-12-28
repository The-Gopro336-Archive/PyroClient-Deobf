/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketVehicleMove
 *  net.minecraft.network.play.server.SPacketDestroyEntities
 *  net.minecraft.network.play.server.SPacketDisconnect
 *  net.minecraft.network.play.server.SPacketSetPassengers
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4J;
import dev.nuker.pyro.f4e;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.network.play.server.SPacketDestroyEntities;
import net.minecraft.network.play.server.SPacketDisconnect;
import net.minecraft.network.play.server.SPacketSetPassengers;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f7P
extends Module {
    @Nullable
    public Entity Field3206;

    public f7P() {
        super("entitdesync", "EntityDesync", null, true);
    }

    @f0g
    @LauncherEventHide
    public void Method183(@Nullable f4t f4t2) {
        if (this.Field3206 != null) {
            Entity entity = this.Field3206;
            if (entity == null) {
                Intrinsics.Method6551();
            }
            entity.setPosition(this.Field5233.player.posX, this.Field5233.player.posY, this.Field5233.player.posZ);
            NetHandlerPlayClient netHandlerPlayClient = this.Field5233.getConnection();
            if (netHandlerPlayClient == null) {
                Intrinsics.Method6551();
            }
            netHandlerPlayClient.sendPacket((Packet)new CPacketVehicleMove(this.Field3206));
        }
    }

    public void Method2407(@Nullable Entity entity) {
        this.Field3206 = entity;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        if (bl) {
            if (this.Field5233.player.isRiding()) {
                this.Field3206 = this.Field5233.player.getRidingEntity();
                this.Field5233.player.dismountRidingEntity();
                this.Field5233.world.removeEntity(this.Field3206);
                return;
            }
        }
        if (bl) return;
        if (this.Field3206 == null) return;
        if (this.Field3206 == null) {
            Intrinsics.Method6551();
        }
        this.Field3206.isDead = false;
        this.Field5233.world.spawnEntity(this.Field3206);
        this.Field5233.player.startRiding(this.Field3206, true);
        this.Field3206 = null;
    }

    @f0g
    @LauncherEventHide
    public void Method244(@NotNull f4e f4e2) {
        if (f4e2.Method5619() == f41.Pre) {
            if (f4e2.Method5784() instanceof SPacketSetPassengers) {
                if (this.Field3206 != null) {
                    Packet packet = f4e2.Method5784();
                    if (packet == null) {
                        throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketSetPassengers");
                    }
                    SPacketSetPassengers sPacketSetPassengers = (SPacketSetPassengers)packet;
                    int n = sPacketSetPassengers.getEntityId();
                    Entity entity = this.Field3206;
                    if (entity == null) {
                        Intrinsics.Method6551();
                    }
                    if (n == entity.getEntityId()) {
                        for (int n2 : sPacketSetPassengers.getPassengerIds()) {
                            if (n2 != this.Field5233.player.getEntityId()) continue;
                            return;
                        }
                        Pyro.Field6182.Method8989("[EntityDesync]: " + (Object)ChatFormatting.RED + "The server has kicked you off the riding entity");
                        this.Field3206 = null;
                        this.Field5236.Method5266(false);
                    } else {
                        for (int n3 : sPacketSetPassengers.getPassengerIds()) {
                            if (n3 != this.Field5233.player.getEntityId()) continue;
                            Pyro.Field6182.Method8989("[EntityDesync]: " + (Object)ChatFormatting.RED + "You started riding another entity");
                            this.Field3206 = null;
                            this.Field5236.Method5266(false);
                            return;
                        }
                    }
                }
            } else if (f4e2.Method5784() instanceof SPacketDestroyEntities) {
                Packet packet = f4e2.Method5784();
                if (packet == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketDestroyEntities");
                }
                SPacketDestroyEntities sPacketDestroyEntities = (SPacketDestroyEntities)packet;
                if (this.Field3206 != null) {
                    for (int n : sPacketDestroyEntities.getEntityIDs()) {
                        Entity entity = this.Field3206;
                        if (entity == null) {
                            Intrinsics.Method6551();
                        }
                        if (n != entity.getEntityId()) continue;
                        Pyro.Field6182.Method8989("[EntityDesync]: " + (Object)ChatFormatting.RED + "The server has despawned the riding entity");
                        this.Field3206 = null;
                        this.Field5236.Method5266(false);
                        return;
                    }
                }
            } else if (f4e2.Method5784() instanceof SPacketDisconnect) {
                this.Field3206 = null;
                this.Field5236.Method5266(false);
            }
        }
    }

    @Nullable
    public Entity Method5123() {
        return this.Field3206;
    }

    @f0g
    @LauncherEventHide
    public void Method187(@Nullable f4J f4J2) {
        this.Field3206 = null;
        this.Field5236.Method5266(false);
    }
}

