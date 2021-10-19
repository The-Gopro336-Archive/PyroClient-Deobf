/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({BlockLiquid.class})
public class BlockLiquidMixin {
   @Inject(
      method = {"canCollideCheck"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void canCollideCheck(IBlockState blockState, boolean b, CallbackInfoReturnable callbackInfoReturnable) {
      if ((Boolean)PyroStatic.field_2515.c.method_3034()) {
         callbackInfoReturnable.cancel();
         callbackInfoReturnable.setReturnValue(true);
      }

   }

   @Inject(
      method = {"getCollisionBoundingBox"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos, CallbackInfoReturnable callbackInfoReturnable) {
      PyroStatic.field_2500.method_244(pos, callbackInfoReturnable);
   }
}
