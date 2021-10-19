/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({Block.class})
public class BlockMixin {
   @Inject(
      method = {"shouldSideBeRendered"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side, CallbackInfoReturnable callback) {
      if ((Boolean)PyroStatic.field_2488.c.method_3034() && PyroStatic.field_2488.method_1056()) {
         PyroStatic.field_2488.method_1036((Block)this, blockState, blockAccess, pos, side, callback);
      }

   }

   @Inject(
      method = {"canRenderInLayer"},
      at = {@At("HEAD")},
      cancellable = true,
      remap = false
   )
   public void canRenderInLayer(IBlockState state, BlockRenderLayer layer, CallbackInfoReturnable cir) {
      if ((Boolean)PyroStatic.field_2488.c.method_3034() && PyroStatic.field_2488.method_1056()) {
         PyroStatic.field_2488.method_1055((Block)this, layer, cir);
      }

   }

   @Inject(
      method = {"Lnet/minecraft/block/Block;getLightValue(Lnet/minecraft/block/state/IBlockState;)I"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void getLightValue(IBlockState state, CallbackInfoReturnable callback) {
      if ((Boolean)PyroStatic.field_2488.c.method_3034() && PyroStatic.field_2488.method_1056()) {
         PyroStatic.field_2488.method_1037((Block)this, callback);
      }

   }

   @Inject(
      method = {"addCollisionBoxToList(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/AxisAlignedBB;Ljava/util/List;Lnet/minecraft/util/math/AxisAlignedBB;)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void addCollisionBoxToList(BlockPos var0, AxisAlignedBB var1, List var2, AxisAlignedBB var3, CallbackInfo var4) {
      if ((Boolean)PyroStatic.field_2611.c.method_3034() && var3 != Block.NULL_AABB) {
         AxisAlignedBB var5 = var3.offset(var0);
         AxisAlignedBB var420 = PyroStatic.field_2611.method_550(var0, var5);
         if (var5 != var420) {
            var4.cancel();
            if (var420 != null && var1.intersects(var420)) {
               var2.add(var420);
            }
         }
      }

   }
}
