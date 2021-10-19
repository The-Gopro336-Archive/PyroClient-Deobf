/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public class f4w extends f42 {
   // $FF: renamed from: c net.minecraft.util.EnumHand
   @NotNull
   public EnumHand field_2061;
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   @NotNull
   public BlockPos field_2062;

   // $FF: renamed from: c () net.minecraft.util.EnumHand
   @NotNull
   public EnumHand method_3116() {
      return this.field_2061;
   }

   // $FF: renamed from: c (net.minecraft.util.EnumHand) void
   public void method_3117(@NotNull EnumHand var1) {
      this.field_2061 = var1;
   }

   // $FF: renamed from: 0 () net.minecraft.util.math.BlockPos
   @NotNull
   public BlockPos method_3118() {
      return this.field_2062;
   }

   public f4w(@NotNull EnumHand var1, @NotNull BlockPos var2) {
      this.field_2061 = var1;
      this.field_2062 = var2;
   }
}
