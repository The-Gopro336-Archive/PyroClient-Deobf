/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class fdr {
   // $FF: renamed from: c net.minecraft.inventory.IInventory
   @Nullable
   public IInventory field_1326;
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos field_1327;
   // $FF: renamed from: 0 net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos field_1328;
   // $FF: renamed from: c net.minecraft.util.EnumFacing
   @Nullable
   public EnumFacing field_1329;
   // $FF: renamed from: 1 net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos field_1330;

   // $FF: renamed from: 1 () net.minecraft.inventory.IInventory
   @Nullable
   public IInventory method_1995() {
      return this.field_1326;
   }

   // $FF: renamed from: 1 (net.minecraft.util.math.BlockPos) void
   public void method_1996(@Nullable BlockPos var1) {
      this.field_1330 = var1;
   }

   // $FF: renamed from: 3 () net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos method_1997() {
      return this.field_1328;
   }

   // $FF: renamed from: 0 () net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos method_1998() {
      return this.field_1330;
   }

   // $FF: renamed from: c () boolean
   public boolean method_1999() {
      boolean var1;
      if (this.field_1326 != null) {
         IInventory var10000 = this.field_1326;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         if (!var10000.isEmpty()) {
            var1 = false;
            return var1;
         }
      }

      var1 = true;
      return var1;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) void
   public void method_2000(@Nullable BlockPos var1) {
      this.field_1327 = var1;
   }

   // $FF: renamed from: c (net.minecraft.util.EnumFacing) void
   public void method_2001(@Nullable EnumFacing var1) {
      this.field_1329 = var1;
   }

   // $FF: renamed from: 4 () net.minecraft.util.EnumFacing
   @Nullable
   public EnumFacing method_2002() {
      return this.field_1329;
   }

   // $FF: renamed from: 0 (net.minecraft.util.math.BlockPos) void
   public void method_2003(@Nullable BlockPos var1) {
      this.field_1328 = var1;
   }

   // $FF: renamed from: 2 () net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos method_2004() {
      return this.field_1327;
   }

   // $FF: renamed from: c (net.minecraft.inventory.IInventory) void
   public void method_2005(@Nullable IInventory var1) {
      this.field_1326 = var1;
   }
}
