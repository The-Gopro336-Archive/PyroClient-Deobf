/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public class fdq {
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   @NotNull
   public BlockPos field_1324;
   // $FF: renamed from: 0 net.minecraft.util.math.BlockPos
   @NotNull
   public BlockPos field_1325;

   public fdq(@NotNull BlockPos var1, @NotNull BlockPos var2) {
      int var3 = var1.getX();
      int var4 = var2.getX();
      boolean var5 = false;
      int var9 = Math.min(var3, var4);
      var3 = var1.getY();
      var4 = var2.getY();
      var5 = false;
      int var10 = Math.min(var3, var4);
      var3 = var1.getZ();
      var4 = var2.getZ();
      var5 = false;
      int var11 = Math.min(var3, var4);
      this.field_1324 = new BlockPos(var9, var10, var11);
      var3 = var1.getX();
      var4 = var2.getX();
      var5 = false;
      var9 = Math.max(var3, var4);
      var3 = var1.getY();
      var4 = var2.getY();
      var5 = false;
      var10 = Math.max(var3, var4);
      var3 = var1.getZ();
      var4 = var2.getZ();
      var5 = false;
      var11 = Math.max(var3, var4);
      this.field_1325 = new BlockPos(var9, var10, var11);
   }

   // $FF: renamed from: 0 () net.minecraft.util.math.BlockPos
   @NotNull
   public BlockPos method_1993() {
      return this.field_1325;
   }

   // $FF: renamed from: c () net.minecraft.util.math.BlockPos
   @NotNull
   public BlockPos method_1994() {
      return this.field_1324;
   }
}
