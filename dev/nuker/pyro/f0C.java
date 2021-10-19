/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public class f0C {
   public f0C(DefaultConstructorMarker var1) {
      this();
   }

   public f0C() {
   }

   // $FF: renamed from: c (double, double, int, int) dev.nuker.pyro.f0D
   @JvmStatic
   @NotNull
   public f0D method_3560(double var1, double var3, int var5, int var6) {
      double var7 = var1;
      double var9 = var3;
      boolean var11 = false;
      boolean var12 = false;
      byte var13;
      if (var1 < (double)var5 / 2.0D) {
         var13 = -1;
      } else {
         var13 = 1;
         var7 = (double)var5 - var1;
      }

      byte var14;
      if (var3 < (double)var6 / 2.0D) {
         var14 = -1;
      } else {
         var14 = 1;
         var9 = (double)var6 - var3;
      }

      return new f0D(f0B.field_2324.method_3479(var13, var14), var7, var9);
   }
}
