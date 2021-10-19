/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fa3 {
   // $FF: renamed from: c double
   public double field_1437;
   // $FF: renamed from: c dev.nuker.pyro.fa3
   @Nullable
   public fa3 field_1438;
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   @NotNull
   public BlockPos field_1439;
   // $FF: renamed from: 0 double
   public double field_1440;
   // $FF: renamed from: c dev.nuker.pyro.fa6
   public fa6 field_1441;

   public fa3(@Nullable fa6 var1, @NotNull fa3 var2, BlockPos var3, double var4) {
      this.field_1441 = var1;
      super();
      this.field_1438 = var2;
      this.field_1439 = var3;
      this.field_1440 = var4;
      double var6 = this.field_1439.distanceSq((Vec3i)var1.method_2626());
      boolean var8 = false;
      double var10 = Math.sqrt(var6);
      this.field_1437 = var10 * var1.method_2621();
   }

   // $FF: renamed from: c (double) void
   public void method_2605(double var1) {
      this.field_1440 = var1;
   }

   // $FF: renamed from: c () dev.nuker.pyro.fa3
   @Nullable
   public fa3 method_2606() {
      return this.field_1438;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) boolean
   public boolean method_2607(@NotNull BlockPos var1) {
      return Intrinsics.areEqual((Object)this.field_1439, (Object)var1);
   }

   // $FF: renamed from: 2 () double
   public double method_2608() {
      return this.field_1440;
   }

   // $FF: renamed from: 0 () net.minecraft.util.math.BlockPos
   @NotNull
   public BlockPos method_2609() {
      return this.field_1439;
   }

   // $FF: renamed from: 1 () double
   public double method_2610() {
      return this.field_1437;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fa3) void
   public void method_2611(@Nullable fa3 var1) {
      this.field_1438 = var1;
   }
}
