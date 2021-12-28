/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  javax.annotation.Nullable
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.network.EnumPacketDirection
 *  net.minecraft.network.NetworkManager
 */
package dev.nuker.pyro;

import com.mojang.authlib.GameProfile;
import dev.nuker.pyro.Class51;
import dev.nuker.pyro.alt.AltManager;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.NetworkManager;

public class Class30
extends NetHandlerPlayClient {
    public List<NetworkPlayerInfo> Field4579 = new ArrayList<NetworkPlayerInfo>();

    public static boolean Method6727(GameProfile gameProfile, NetworkPlayerInfo networkPlayerInfo) {
        return networkPlayerInfo.getGameProfile().getId().equals(gameProfile.getId());
    }

    public void Method6728(GameProfile gameProfile) {
        this.Field4579.removeAll(this.Field4579.stream().filter(arg_0 -> Class30.Method6727(gameProfile, arg_0)).collect(Collectors.toList()));
        NetworkPlayerInfo networkPlayerInfo = new NetworkPlayerInfo(gameProfile);
        this.Field4579.add(networkPlayerInfo);
        AltManager.Field6702.Method9672(gameProfile, arg_0 -> this.Method6730(networkPlayerInfo, arg_0));
    }

    @Nullable
    public NetworkPlayerInfo getPlayerInfo(String string) {
        return this.Field4579.stream().filter(arg_0 -> Class30.Method6729(string, arg_0)).findFirst().get();
    }

    public NetworkPlayerInfo getPlayerInfo(UUID uUID) {
        return this.Field4579.stream().filter(arg_0 -> Class30.Method6731(uUID, arg_0)).findFirst().get();
    }

    public Class30(Minecraft minecraft) {
        super(minecraft, minecraft.currentScreen, (NetworkManager)new Class51(EnumPacketDirection.CLIENTBOUND), minecraft.getSession().getProfile());
        this.Method6728(minecraft.getSession().getProfile());
    }

    public static boolean Method6729(String string, NetworkPlayerInfo networkPlayerInfo) {
        return networkPlayerInfo.getGameProfile().getName().equals(string);
    }

    public void Method6730(NetworkPlayerInfo networkPlayerInfo, GameProfile gameProfile) {
        this.Field4579.remove((Object)networkPlayerInfo);
        this.Field4579.add(new NetworkPlayerInfo(gameProfile));
    }

    public static boolean Method6731(UUID uUID, NetworkPlayerInfo networkPlayerInfo) {
        return networkPlayerInfo.getGameProfile().getId().equals(uUID);
    }
}

