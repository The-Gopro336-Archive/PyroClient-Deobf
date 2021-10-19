/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.Comparator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

public class fdI implements Comparator {
   // $FF: renamed from: c dev.nuker.pyro.fdJ
   @Nullable
   public fdJ field_1232;

   // $FF: renamed from: c () dev.nuker.pyro.fdJ
   @Nullable
   public fdJ method_1885() {
      return this.field_1232;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fdJ) void
   public void method_1886(@Nullable fdJ var1) {
      this.field_1232 = var1;
   }

   public int compare(Object var1, Object var2) {
      double var3 = 0.0D;
      fdJ var10000 = this.field_1232;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      if (!fdJ.method_1888(var10000).containsKey(var1)) {
         var10000 = this.field_1232;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.method_1891(var1);
      }

      double var5 = 0.0D;
      var10000 = this.field_1232;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      if (!fdJ.method_1888(var10000).containsKey(var2)) {
         var10000 = this.field_1232;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.method_1891(var2);
      }

      var10000 = this.field_1232;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      Map var7 = fdJ.method_1888(var10000);
      fdJ var10001 = this.field_1232;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      Object var9 = var7.get(fdJ.method_1890(var10001) ? var2 : var1);
      if (var9 == null) {
         Intrinsics.throwNpe();
      }

      double var11 = ((Number)var9).doubleValue();
      var10001 = this.field_1232;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      Map var8 = fdJ.method_1888(var10001);
      fdJ var10002 = this.field_1232;
      if (var10002 == null) {
         Intrinsics.throwNpe();
      }

      Object var10 = var8.get(fdJ.method_1890(var10002) ? var1 : var2);
      if (var10 == null) {
         Intrinsics.throwNpe();
      }

      return Double.compare(var11, ((Number)var10).doubleValue());
   }
}
