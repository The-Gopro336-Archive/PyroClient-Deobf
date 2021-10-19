/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5C extends f5T {
   // $FF: renamed from: c dev.nuker.pyro.fe8
   public fe8 field_1066 = new fe8();
   // $FF: renamed from: 1 java.lang.String
   @NotNull
   public String field_1067 = "FPS";
   // $FF: renamed from: c int[]
   public int[] field_1068 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

   public f5C() {
      super("fps");
   }

   // $FF: renamed from: 4 () java.lang.String
   @NotNull
   public String method_1559() {
      return this.field_1067;
   }

   // $FF: renamed from: c () int
   public int method_1578() {
      int var1 = 0;
      int[] var4 = this.field_1068;
      int var5 = var4.length;

      for(int var3 = 0; var3 < var5; ++var3) {
         int var2 = var4[var3];
         var1 += var2;
      }

      return var1 / 10;
   }

   // $FF: renamed from: c (net.minecraft.client.gui.ScaledResolution, float, float) int
   public int method_1558(@Nullable ScaledResolution var1, float var2, float var3) {
      return 11184810;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f43) void
   @f0g
   @LauncherEventHide
   public void method_1579(@NotNull f43 var1) {
      if (var1.c() == f41.field_2120 && fdZ.field_976.world != null && fdZ.field_976.player != null) {
         if (this.field_1066.method_1980(1000.0D)) {
            this.field_1066.method_1979();
            int var2 = 0;

            for(int var3 = this.field_1068.length - 1; var2 < var3; ++var2) {
               this.field_1068[var2] = this.field_1068[var2 + 1];
            }

            this.field_1068[this.field_1068.length - 1] = Minecraft.getDebugFPS();
         }

         this.field_1067 = "FPS " + ChatFormatting.WHITE + Minecraft.getDebugFPS() + ChatFormatting.RESET + " Average " + ChatFormatting.WHITE + this.method_1578();
      }
   }
}
