/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.authlib.GameProfile;
import dev.nuker.pyro.alt.AltManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.network.EnumPacketDirection;

// $FF: renamed from: dev.nuker.pyro.fd
public class class_33 extends NetHandlerPlayClient {
   // $FF: renamed from: c java.util.List
   public List field_2626 = new ArrayList();

   // $FF: renamed from: c (com.mojang.authlib.GameProfile, net.minecraft.client.network.NetworkPlayerInfo) boolean
   public static boolean method_3956(GameProfile var0, NetworkPlayerInfo var1) {
      return var1.getGameProfile().getId().equals(var0.getId());
   }

   // $FF: renamed from: c (com.mojang.authlib.GameProfile) void
   public void method_3957(GameProfile var1) {
      this.field_2626.removeAll((Collection)this.field_2626.stream().filter(fd::c).collect(Collectors.toList()));
      NetworkPlayerInfo var2 = new NetworkPlayerInfo(var1);
      this.field_2626.add(var2);
      AltManager.INSTANCE.fillProfileAsync(var1, this::c);
   }

   @Nullable
   public NetworkPlayerInfo getPlayerInfo(String var1) {
      return (NetworkPlayerInfo)this.field_2626.stream().filter(fd::c).findFirst().get();
   }

   public NetworkPlayerInfo getPlayerInfo(UUID var1) {
      return (NetworkPlayerInfo)this.field_2626.stream().filter(fd::c).findFirst().get();
   }

   public class_33(Minecraft var1) {
      super(var1, var1.currentScreen, new class_54(EnumPacketDirection.CLIENTBOUND), var1.getSession().getProfile());
      this.method_3957(var1.getSession().getProfile());
   }

   // $FF: renamed from: c (java.lang.String, net.minecraft.client.network.NetworkPlayerInfo) boolean
   public static boolean method_3958(String var0, NetworkPlayerInfo var1) {
      return var1.getGameProfile().getName().equals(var0);
   }

   // $FF: renamed from: c (net.minecraft.client.network.NetworkPlayerInfo, com.mojang.authlib.GameProfile) void
   public void method_3959(NetworkPlayerInfo var1, GameProfile var2) {
      this.field_2626.remove(var1);
      this.field_2626.add(new NetworkPlayerInfo(var2));
   }

   // $FF: renamed from: c (java.util.UUID, net.minecraft.client.network.NetworkPlayerInfo) boolean
   public static boolean method_3960(UUID var0, NetworkPlayerInfo var1) {
      return var1.getGameProfile().getId().equals(var0);
   }
}
