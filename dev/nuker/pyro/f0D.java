/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f0D {
   // $FF: renamed from: c dev.nuker.pyro.f0B
   @Nullable
   public f0B field_2341;
   // $FF: renamed from: c double
   public double field_2342;
   // $FF: renamed from: 0 double
   public double field_2343;
   // $FF: renamed from: c dev.nuker.pyro.f0C
   public static f0C field_2344 = new f0C((DefaultConstructorMarker)null);

   public f0D(@Nullable f0B var1, double var2, double var4) {
      this.field_2341 = f0B.field_2317;
      this.field_2341 = var1;
      this.field_2342 = var2;
      this.field_2343 = var4;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0B) void
   public void method_3561(@Nullable f0B var1) {
      this.field_2341 = var1;
   }

   // $FF: renamed from: 0 () double
   public double method_3562() {
      return this.field_2342;
   }

   // $FF: renamed from: c () dev.nuker.pyro.f0B
   @Nullable
   public f0B method_3563() {
      return this.field_2341;
   }

   // $FF: renamed from: 0 (int) double
   public double method_3564(int var1) {
      f0B var10000 = this.field_2341;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      return var10000.method_3483(this.field_2342, var1);
   }

   // $FF: renamed from: c (double, double, int, int) dev.nuker.pyro.f0D
   @JvmStatic
   @NotNull
   public static f0D method_3565(double var0, double var2, int var4, int var5) {
      return field_2344.method_3560(var0, var2, var4, var5);
   }

   // $FF: renamed from: 1 () double
   public double method_3566() {
      return this.field_2343;
   }

   // $FF: renamed from: 0 (double) void
   public void method_3567(double var1) {
      this.field_2342 = var1;
   }

   // $FF: renamed from: c (int) double
   public double method_3568(int var1) {
      f0B var10000 = this.field_2341;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      return var10000.method_3480(this.field_2343, var1);
   }

   // $FF: renamed from: c (double) void
   public void method_3569(double var1) {
      this.field_2343 = var1;
   }
}
