/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.fb2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.chunk.ChunkRenderWorker;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({ChunkRenderWorker.class})
public class ChunkRenderWorkerMixin {
   @Redirect(
      method = {"processTask"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/Minecraft;getRenderViewEntity()Lnet/minecraft/entity/Entity;"
)
   )
   private Entity getRenderOrFreecamEntity(Minecraft minecraft) {
      return (Entity)((Boolean)PyroStatic.field_2481.c.method_3034() ? (PyroStatic.field_2481.field_777.method_3334().c() == fb2.field_1471 ? minecraft.player : PyroStatic.field_2481.field_775) : minecraft.getRenderViewEntity());
   }
}
