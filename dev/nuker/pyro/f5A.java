/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5A extends f5T {
   // $FF: renamed from: 1 java.lang.String
   public String field_1070 = "South";

   // $FF: renamed from: c (net.minecraft.client.gui.ScaledResolution, float, float) int
   public int method_1558(@Nullable ScaledResolution var1, float var2, float var3) {
      return 11184810;
   }

   public f5A() {
      super("Direction");
   }

   // $FF: renamed from: c (dev.nuker.pyro.f43) void
   @f0g
   @LauncherEventHide
   public void method_1581(@NotNull f43 var1) {
      if (var1.c() == f41.field_2120 && fdZ.field_976.world != null && fdZ.field_976.player != null) {
         this.field_1070 = this.method_1582() + " " + ChatFormatting.WHITE + this.method_1583();
      }
   }

   // $FF: renamed from: 1 () java.lang.String
   public String method_1582() {
      switch(MathHelper.floor((double)(fdZ.field_976.player.rotationYaw * 8.0F / 360.0F) + 0.5D) & 7) {
      case 0:
         return "South";
      case 1:
         return "South West";
      case 2:
         return "West";
      case 3:
         return "North West";
      case 4:
         return "North";
      case 5:
         return "North East";
      case 6:
         return "East";
      case 7:
         return "South East";
      default:
         return "Invalid";
      }
   }

   // $FF: renamed from: 0 () java.lang.String
   public String method_1583() {
      switch(MathHelper.floor((double)(fdZ.field_976.player.rotationYaw * 8.0F / 360.0F) + 0.5D) & 7) {
      case 0:
         return "+Z";
      case 1:
         return "-X +Z";
      case 2:
         return "-X";
      case 3:
         return "-X -Z";
      case 4:
         return "-Z";
      case 5:
         return "+X -Z";
      case 6:
         return "+X";
      case 7:
         return "+X +Z";
      default:
         return "Invalid";
      }
   }

   // $FF: renamed from: 4 () java.lang.String
   @NotNull
   public String method_1559() {
      return this.field_1070;
   }
}
