/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fer {
   // $FF: renamed from: c dev.nuker.pyro.feh
   @NotNull
   public feh field_1389;
   // $FF: renamed from: c dev.nuker.pyro.Rotation
   @NotNull
   public Rotation field_1390;

   // $FF: renamed from: c (dev.nuker.pyro.feh, dev.nuker.pyro.Rotation) dev.nuker.pyro.fer
   @NotNull
   public fer method_2068(@NotNull feh var1, @NotNull Rotation var2) {
      return new fer(var1, var2);
   }

   public int hashCode() {
      feh var10000 = this.field_1389;
      int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
      Rotation var10001 = this.field_1390;
      return var1 + (var10001 != null ? var10001.hashCode() : 0);
   }

   // $FF: renamed from: c (dev.nuker.pyro.fer, dev.nuker.pyro.feh, dev.nuker.pyro.Rotation, int, java.lang.Object) dev.nuker.pyro.fer
   public static fer method_2069(fer var0, feh var1, Rotation var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.field_1389;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.field_1390;
      }

      return var0.method_2068(var1, var2);
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.Rotation
   @NotNull
   public Rotation method_2070() {
      return this.field_1390;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.feh
   @NotNull
   public feh method_2071() {
      return this.field_1389;
   }

   public boolean equals(@Nullable Object var1) {
      if (this != var1) {
         if (var1 instanceof fer) {
            fer var2 = (fer)var1;
            if (Intrinsics.areEqual((Object)this.field_1389, (Object)var2.field_1389) && Intrinsics.areEqual((Object)this.field_1390, (Object)var2.field_1390)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   public fer(@NotNull feh var1, @NotNull Rotation var2) {
      this.field_1389 = var1;
      this.field_1390 = var2;
   }

   @NotNull
   public String toString() {
      return "PlaceRotation(placeInfo=" + this.field_1389 + ", rotation=" + this.field_1390 + ")";
   }

   // $FF: renamed from: c () dev.nuker.pyro.feh
   @NotNull
   public feh method_2072() {
      return this.field_1389;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.Rotation
   @NotNull
   public Rotation method_2073() {
      return this.field_1390;
   }
}
