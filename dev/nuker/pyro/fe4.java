/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityOtherPlayerMP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.mojang.authlib.GameProfile;
import dev.nuker.pyro.FriendManager;
import dev.nuker.pyro.mixin.EntityFlagAccessor;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fe4 {
    public static List<EntityOtherPlayerMP> Field248;
    public static List<EntityOtherPlayerMP> Field249;
    public static fe4 Field250;

    public boolean Method387(@Nullable EntityPlayer entityPlayer) {
        return entityPlayer != null && Intrinsics.Method6572((Object)entityPlayer, (Object)Minecraft.getMinecraft().player) ^ true && !FriendManager.Field2145.Method8960(entityPlayer) && (!CollectionsKt.Method3059((Iterable)Field248, entityPlayer) || CollectionsKt.Method3059((Iterable)Field249, entityPlayer));
    }

    static {
        fe4 fe42;
        Field250 = fe42 = new fe4();
        boolean bl = false;
        Field248 = new ArrayList();
        bl = false;
        Field249 = new ArrayList();
    }

    public void Method388() {
        Field248.clear();
        Field249.clear();
    }

    public void Method389(@NotNull EntityOtherPlayerMP entityOtherPlayerMP) {
        if (Minecraft.getMinecraft().world != null) {
            Minecraft.getMinecraft().world.removeEntityFromWorld(entityOtherPlayerMP.getEntityId());
        }
        Field248.remove((Object)entityOtherPlayerMP);
        Field249.remove((Object)entityOtherPlayerMP);
    }

    @NotNull
    public EntityOtherPlayerMP Method390(@NotNull EntityPlayer entityPlayer, int n, boolean bl) {
        EntityOtherPlayerMP entityOtherPlayerMP = new EntityOtherPlayerMP(entityPlayer.world, entityPlayer.getGameProfile());
        entityOtherPlayerMP.copyLocationAndAnglesFrom((Entity)entityPlayer);
        entityOtherPlayerMP.rotationYaw = entityPlayer.rotationYaw;
        entityOtherPlayerMP.rotationYawHead = entityPlayer.rotationYawHead;
        entityOtherPlayerMP.inventory.copyInventory(entityPlayer.inventory);
        ((EntityFlagAccessor)entityOtherPlayerMP).Method2970(7, entityPlayer.isElytraFlying());
        Minecraft.getMinecraft().world.addEntityToWorld(n, (Entity)entityOtherPlayerMP);
        Field248.add(entityOtherPlayerMP);
        if (bl) {
            Field249.add(entityOtherPlayerMP);
        }
        if (entityPlayer.getRidingEntity() != null) {
            entityOtherPlayerMP.startRiding(entityPlayer.getRidingEntity(), true);
        }
        return entityOtherPlayerMP;
    }

    @NotNull
    public EntityOtherPlayerMP Method391(@NotNull String string, int n, boolean bl) {
        EntityOtherPlayerMP entityOtherPlayerMP = new EntityOtherPlayerMP((World)Minecraft.getMinecraft().world, new GameProfile(null, string));
        Minecraft.getMinecraft().world.addEntityToWorld(n, (Entity)entityOtherPlayerMP);
        Field248.add(entityOtherPlayerMP);
        if (bl) {
            Field249.add(entityOtherPlayerMP);
        }
        return entityOtherPlayerMP;
    }

    @NotNull
    public EntityOtherPlayerMP Method392(@NotNull EntityPlayer entityPlayer, int n, boolean bl) {
        EntityOtherPlayerMP entityOtherPlayerMP = new EntityOtherPlayerMP(entityPlayer.world, entityPlayer.getGameProfile());
        entityOtherPlayerMP.copyLocationAndAnglesFrom((Entity)entityPlayer);
        entityOtherPlayerMP.rotationYaw = entityPlayer.rotationYaw;
        entityOtherPlayerMP.rotationYawHead = entityPlayer.rotationYawHead;
        Minecraft.getMinecraft().world.addEntityToWorld(n, (Entity)entityOtherPlayerMP);
        Field248.add(entityOtherPlayerMP);
        if (bl) {
            Field249.add(entityOtherPlayerMP);
        }
        return entityOtherPlayerMP;
    }
}

