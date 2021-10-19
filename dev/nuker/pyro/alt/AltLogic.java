/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
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
import java.net.InetAddress;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;

public class AltLogic {
   private static final YggdrasilAuthenticationService yas = new YggdrasilAuthenticationService(Minecraft.getMinecraft().getProxy(), UUID.randomUUID().toString());
   public static final YggdrasilUserAuthentication yua;
   private static final YggdrasilMinecraftSessionService ymss;

   public static int login(String user, String password) {
      yua.setUsername(user);
      yua.setPassword(password);

      try {
         yua.logIn();
      } catch (AuthenticationException var6) {
         if (var6 instanceof AuthenticationUnavailableException) {
            return 2;
         }

         return 1;
      }

      String username = yua.getSelectedProfile().getName();
      String uuid = UUIDTypeAdapter.fromUUID(yua.getSelectedProfile().getId());
      String access = yua.getAuthenticatedToken();
      String type = yua.getUserType().getName();
      ((MinecraftAccessor)Minecraft.getMinecraft()).setSession(new Session(username, uuid, access, type));
      yua.logOut();
      return 0;
   }

   public static int verifyCredentials(String user, String password) {
      yua.setUsername(user);
      yua.setPassword(password);

      try {
         yua.logIn();
         return 0;
      } catch (AuthenticationException var3) {
         return var3 instanceof AuthenticationUnavailableException ? 2 : 1;
      }
   }

   public static boolean loginOffline(String username) {
      UUID uuid = UUID.nameUUIDFromBytes(("OfflinePlayer:" + username).getBytes(Charsets.UTF_8));
      ((MinecraftAccessor)Minecraft.getMinecraft()).setSession(new Session(username, uuid.toString(), "invalid", "legacy"));
      return true;
   }

   public static boolean isOffline() {
      return Minecraft.getMinecraft().getSession().getProfile().getId().equals(UUID.nameUUIDFromBytes(("OfflinePlayer:" + Minecraft.getMinecraft().getSession().getUsername()).getBytes(Charsets.UTF_8)));
   }

   public static boolean sessionValid() {
      try {
         GameProfile gp = Minecraft.getMinecraft().getSession().getProfile();
         String token = Minecraft.getMinecraft().getSession().getToken();
         String id = UUID.randomUUID().toString();
         ymss.joinServer(gp, token, id);
         return ymss.hasJoinedServer(gp, id, (InetAddress)null).isComplete();
      } catch (Exception var3) {
         return false;
      }
   }

   static {
      yua = (YggdrasilUserAuthentication)yas.createUserAuthentication(Agent.MINECRAFT);
      ymss = (YggdrasilMinecraftSessionService)yas.createMinecraftSessionService();
   }
}
