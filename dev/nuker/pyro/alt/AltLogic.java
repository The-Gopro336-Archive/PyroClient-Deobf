/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Charsets
 *  com.mojang.authlib.Agent
 *  com.mojang.authlib.GameProfile
 *  com.mojang.authlib.exceptions.AuthenticationException
 *  com.mojang.authlib.exceptions.AuthenticationUnavailableException
 *  com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService
 *  com.mojang.authlib.yggdrasil.YggdrasilMinecraftSessionService
 *  com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication
 *  com.mojang.util.UUIDTypeAdapter
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.Session
 */
package dev.nuker.pyro.alt;

import com.google.common.base.Charsets;
import com.mojang.authlib.Agent;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.exceptions.AuthenticationUnavailableException;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilMinecraftSessionService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import com.mojang.util.UUIDTypeAdapter;
import dev.nuker.pyro.mixin.MinecraftAccessor;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;

public class AltLogic {
    private static final YggdrasilAuthenticationService Field5466 = new YggdrasilAuthenticationService(Minecraft.getMinecraft().getProxy(), UUID.randomUUID().toString());
    public static final YggdrasilUserAuthentication Field5467 = (YggdrasilUserAuthentication)Field5466.createUserAuthentication(Agent.MINECRAFT);
    private static final YggdrasilMinecraftSessionService Field5468 = (YggdrasilMinecraftSessionService)Field5466.createMinecraftSessionService();

    public static int Method7694(String user, String password) {
        Field5467.setUsername(user);
        Field5467.setPassword(password);
        try {
            Field5467.logIn();
        }
        catch (AuthenticationException e) {
            if (e instanceof AuthenticationUnavailableException) {
                return 2;
            }
            return 1;
        }
        String username = Field5467.getSelectedProfile().getName();
        String uuid = UUIDTypeAdapter.fromUUID((UUID)Field5467.getSelectedProfile().getId());
        String access = Field5467.getAuthenticatedToken();
        String type = Field5467.getUserType().getName();
        ((MinecraftAccessor)Minecraft.getMinecraft()).Method6089(new Session(username, uuid, access, type));
        Field5467.logOut();
        return 0;
    }

    public static int Method7695(String user, String password) {
        Field5467.setUsername(user);
        Field5467.setPassword(password);
        try {
            Field5467.logIn();
        }
        catch (AuthenticationException e) {
            if (e instanceof AuthenticationUnavailableException) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public static boolean Method7696(String username) {
        UUID uuid = UUID.nameUUIDFromBytes(("OfflinePlayer:" + username).getBytes(Charsets.UTF_8));
        ((MinecraftAccessor)Minecraft.getMinecraft()).Method6089(new Session(username, uuid.toString(), "invalid", "legacy"));
        return true;
    }

    public static boolean Method7697() {
        return Minecraft.getMinecraft().getSession().getProfile().getId().equals(UUID.nameUUIDFromBytes(("OfflinePlayer:" + Minecraft.getMinecraft().getSession().getUsername()).getBytes(Charsets.UTF_8)));
    }

    public static boolean Method7698() {
        try {
            GameProfile gp = Minecraft.getMinecraft().getSession().getProfile();
            String token = Minecraft.getMinecraft().getSession().getToken();
            String id = UUID.randomUUID().toString();
            Field5468.joinServer(gp, token, id);
            if (Field5468.hasJoinedServer(gp, id, null).isComplete()) {
                return true;
            }
        }
        catch (Exception e) {
            return false;
        }
        return false;
    }
}

