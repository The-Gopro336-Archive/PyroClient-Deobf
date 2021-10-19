/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5z extends f5T {
   // $FF: renamed from: 1 java.lang.String
   @NotNull
   public String field_1075 = "";

   // $FF: renamed from: 4 () java.lang.String
   @NotNull
   public String method_1559() {
      return this.field_1075;
   }

   // $FF: renamed from: c (net.minecraft.client.gui.ScaledResolution, float, float) int
   public int method_1558(@Nullable ScaledResolution var1, float var2, float var3) {
      return 11184810;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f43) void
   @f0g
   @LauncherEventHide
   public void method_1590(@NotNull f43 var1) {
      if (var1.c() == f41.field_2120 && fdZ.field_976.world != null && fdZ.field_976.player != null) {
         if (fdZ.field_976.player == null) {
            this.field_1075 = "";
         } else {
            StringBuilder var10000 = (new StringBuilder("XYZ ")).append("(").append(ChatFormatting.WHITE);
            StringCompanionObject var3 = StringCompanionObject.INSTANCE;
            String var4 = "%.1f";
            Object[] var5 = new Object[]{fdZ.field_976.player.posX};
            StringBuilder var14 = var10000;
            boolean var6 = false;
            String var15 = String.format(var4, Arrays.copyOf(var5, var5.length));
            var10000 = var14.append(var15).append(", ").append(ChatFormatting.WHITE);
            var3 = StringCompanionObject.INSTANCE;
            var4 = "%.1f";
            var5 = new Object[]{fdZ.field_976.player.posY};
            var14 = var10000;
            var6 = false;
            var15 = String.format(var4, Arrays.copyOf(var5, var5.length));
            var10000 = var14.append(var15).append(", ").append(ChatFormatting.WHITE);
            var3 = StringCompanionObject.INSTANCE;
            var4 = "%.1f";
            var5 = new Object[]{fdZ.field_976.player.posZ};
            var14 = var10000;
            var6 = false;
            var15 = String.format(var4, Arrays.copyOf(var5, var5.length));
            StringBuilder var2 = var14.append(var15).append(ChatFormatting.RESET).append(") ");
            boolean var16 = fdZ.field_976.player.dimension != 1;
            Entity var19 = fdZ.field_976.getRenderViewEntity();
            if (var19 == null) {
               Intrinsics.throwNpe();
            }

            double var20;
            if (var19.dimension == 0) {
               var19 = fdZ.field_976.getRenderViewEntity();
               if (var19 == null) {
                  Intrinsics.throwNpe();
               }

               var20 = var19.posX / (double)8;
            } else {
               var20 = fdZ.field_976.player.posX * (double)8;
            }

            double var17 = var20;
            var19 = fdZ.field_976.getRenderViewEntity();
            if (var19 == null) {
               Intrinsics.throwNpe();
            }

            double var18 = var19.posY;
            var19 = fdZ.field_976.getRenderViewEntity();
            if (var19 == null) {
               Intrinsics.throwNpe();
            }

            if (var19.dimension == 0) {
               var19 = fdZ.field_976.getRenderViewEntity();
               if (var19 == null) {
                  Intrinsics.throwNpe();
               }

               var20 = var19.posZ / (double)8;
            } else {
               var20 = fdZ.field_976.player.posZ * (double)8;
            }

            double var8 = var20;
            if (var16) {
               var10000 = var2.append("[").append(ChatFormatting.WHITE);
               StringCompanionObject var10 = StringCompanionObject.INSTANCE;
               String var11 = "%.1f";
               Object[] var12 = new Object[]{var17};
               var14 = var10000;
               boolean var13 = false;
               var15 = String.format(var11, Arrays.copyOf(var12, var12.length));
               var10000 = var14.append(var15).append(", ");
               var10 = StringCompanionObject.INSTANCE;
               var11 = "%.1f";
               var12 = new Object[]{var18};
               var14 = var10000;
               var13 = false;
               var15 = String.format(var11, Arrays.copyOf(var12, var12.length));
               var10000 = var14.append(var15).append(", ");
               var10 = StringCompanionObject.INSTANCE;
               var11 = "%.1f";
               var12 = new Object[]{var8};
               var14 = var10000;
               var13 = false;
               var15 = String.format(var11, Arrays.copyOf(var12, var12.length));
               var14.append(var15).append(ChatFormatting.RESET).append("]");
            }

            this.field_1075 = var2.toString();
         }
      }
   }

   public f5z() {
      super("coords");
   }
}
