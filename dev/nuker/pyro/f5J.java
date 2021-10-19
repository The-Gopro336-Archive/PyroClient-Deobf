/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetHandlerPlayClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5J extends f5T {
   // $FF: renamed from: 1 java.lang.String
   @NotNull
   public String field_1065 = "";

   // $FF: renamed from: c (net.minecraft.client.gui.ScaledResolution, float, float) int
   public int method_1558(@Nullable ScaledResolution var1, float var2, float var3) {
      return 11184810;
   }

   // $FF: renamed from: 4 () java.lang.String
   @NotNull
   public String method_1559() {
      return this.field_1065;
   }

   public f5J() {
      super("ping");
   }

   // $FF: renamed from: c (dev.nuker.pyro.f43) void
   @f0g
   @LauncherEventHide
   public void method_1577(@NotNull f43 var1) {
      if (var1.c() == f41.field_2120 && fdZ.field_976.world != null && fdZ.field_976.player != null) {
         if (fdZ.field_976.getConnection() != null) {
            NetHandlerPlayClient var10000 = fdZ.field_976.getConnection();
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            if (var10000.getPlayerInfo(fdZ.field_976.player.getUniqueID()) != null) {
               StringBuilder var10001 = (new StringBuilder("Ping ")).append(ChatFormatting.WHITE);
               NetHandlerPlayClient var10002 = fdZ.field_976.getConnection();
               if (var10002 == null) {
                  Intrinsics.throwNpe();
               }

               this.field_1065 = var10001.append(var10002.getPlayerInfo(fdZ.field_976.player.getUniqueID()).getResponseTime()).toString();
               return;
            }
         }

         this.field_1065 = "Ping 69";
      }
   }
}
