/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.NoWhenBranchMatchedException;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public class fbi {
   // $FF: renamed from: c net.minecraft.util.math.AxisAlignedBB
   @NotNull
   public AxisAlignedBB field_1636;
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   @NotNull
   public BlockPos field_1637;
   // $FF: renamed from: c boolean
   public boolean field_1638;
   // $FF: renamed from: c dev.nuker.pyro.fbl
   public fbl field_1639;

   // $FF: renamed from: 1 () net.minecraft.util.math.AxisAlignedBB
   @NotNull
   public AxisAlignedBB method_2826() {
      return this.field_1636;
   }

   // $FF: renamed from: 0 () net.minecraft.util.math.BlockPos
   @NotNull
   public BlockPos method_2827() {
      return this.field_1637;
   }

   // $FF: renamed from: 3 () int
   public int method_2828() {
      boolean var1 = this.field_1638;
      int var10000;
      if (var1) {
         var10000 = ((f00)this.field_1639.method_960().c()).meth1();
      } else {
         if (var1) {
            throw new NoWhenBranchMatchedException();
         }

         var10000 = ((f00)this.field_1639.method_969().c()).meth1();
      }

      return var10000;
   }

   // $FF: renamed from: 2 () int
   public int method_2829() {
      boolean var1 = this.field_1638;
      int var10000;
      if (var1) {
         var10000 = ((f00)this.field_1639.method_956().c()).meth1();
      } else {
         if (var1) {
            throw new NoWhenBranchMatchedException();
         }

         var10000 = ((f00)this.field_1639.method_955().c()).meth1();
      }

      return var10000;
   }

   public fbi(@NotNull fbl var1, @NotNull AxisAlignedBB var2, BlockPos var3, boolean var4) {
      this.field_1639 = var1;
      super();
      this.field_1636 = var2;
      this.field_1637 = var3;
      this.field_1638 = var4;
   }

   // $FF: renamed from: c () boolean
   public boolean method_2830() {
      return this.field_1638;
   }
}
