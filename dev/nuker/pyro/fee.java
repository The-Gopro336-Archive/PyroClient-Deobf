/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public class fee {
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   @NotNull
   public BlockPos field_1333;
   // $FF: renamed from: c net.minecraft.util.EnumFacing
   @NotNull
   public EnumFacing field_1334;

   public fee(@NotNull BlockPos var1, @NotNull EnumFacing var2) {
      this.field_1333 = var1;
      this.field_1334 = var2;
   }

   // $FF: renamed from: c (net.minecraft.util.EnumFacing) void
   public void method_2007(@NotNull EnumFacing var1) {
      this.field_1334 = var1;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) void
   public void method_2008(@NotNull BlockPos var1) {
      this.field_1333 = var1;
   }

   // $FF: renamed from: c () net.minecraft.util.EnumFacing
   @NotNull
   public EnumFacing method_2009() {
      return this.field_1334;
   }

   // $FF: renamed from: 0 () net.minecraft.util.math.BlockPos
   @NotNull
   public BlockPos method_2010() {
      return this.field_1333;
   }
}
