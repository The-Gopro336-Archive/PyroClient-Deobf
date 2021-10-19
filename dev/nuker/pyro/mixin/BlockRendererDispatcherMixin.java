/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({BlockRendererDispatcher.class})
public class BlockRendererDispatcherMixin {
   @Inject(
      method = {"renderBlock"},
      at = {@At("HEAD")}
   )
   private void renderBlock(IBlockState iBlockState, BlockPos blockPos, IBlockAccess iBlockAccess, BufferBuilder bufferBuilder, CallbackInfoReturnable callbackInfoReturnable) {
      try {
         if ((Boolean)PyroStatic.field_2584.c.method_3034()) {
            PyroStatic.field_2584.method_1101(iBlockState, blockPos);
         }
      } catch (Exception var7) {
      }

   }
}
