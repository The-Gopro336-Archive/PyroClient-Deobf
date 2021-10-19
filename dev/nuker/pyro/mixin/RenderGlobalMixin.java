/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroLightmap;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.fb2;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.ViewFrustum;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({RenderGlobal.class})
public abstract class RenderGlobalMixin {
   @Shadow
   private double frustumUpdatePosX;
   @Shadow
   private double frustumUpdatePosY;
   @Shadow
   private double frustumUpdatePosZ;
   @Shadow
   private int frustumUpdatePosChunkX;
   @Shadow
   private int frustumUpdatePosChunkY;
   @Shadow
   private int frustumUpdatePosChunkZ;
   @Shadow
   private WorldClient world;
   private double _frustumUpdatePosX = Double.MIN_VALUE;
   private double _frustumUpdatePosY = Double.MIN_VALUE;
   private double _frustumUpdatePosZ = Double.MIN_VALUE;
   private int _frustumUpdatePosChunkX = Integer.MIN_VALUE;
   private int _frustumUpdatePosChunkY = Integer.MIN_VALUE;
   private int _frustumUpdatePosChunkZ = Integer.MIN_VALUE;

   @Redirect(
      method = {"loadRenderers"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/Minecraft;getRenderViewEntity()Lnet/minecraft/entity/Entity;"
)
   )
   private Entity getRenderOrFreecamEntity(Minecraft minecraft) {
      return (Entity)((Boolean)PyroStatic.field_2481.c.method_3034() ? (PyroStatic.field_2481.field_777.method_3334().c() == fb2.field_1471 ? minecraft.player : PyroStatic.field_2481.field_775) : minecraft.getRenderViewEntity());
   }

   @Redirect(
      method = {"setupTerrain"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/renderer/ViewFrustum;updateChunkPositions(DD)V"
)
   )
   private void checkFreecamChunkUpdates(ViewFrustum viewFrustum, double viewEntityX, double viewEntityZ) {
      if ((Boolean)PyroStatic.field_2481.c.method_3034()) {
         Entity viewEntity = PyroStatic.field_2481.field_777.method_3334().c() == fb2.field_1471 ? Minecraft.getMinecraft().player : PyroStatic.field_2481.field_775;
         double d0 = ((Entity)viewEntity).posX - this._frustumUpdatePosX;
         double d1 = ((Entity)viewEntity).posY - this._frustumUpdatePosY;
         double d2 = ((Entity)viewEntity).posZ - this._frustumUpdatePosZ;
         if (this._frustumUpdatePosChunkX != ((Entity)viewEntity).chunkCoordX || this._frustumUpdatePosChunkY != ((Entity)viewEntity).chunkCoordY || this._frustumUpdatePosChunkZ != ((Entity)viewEntity).chunkCoordZ || d0 * d0 + d1 * d1 + d2 * d2 > 16.0D) {
            this._frustumUpdatePosX = ((Entity)viewEntity).posX;
            this._frustumUpdatePosY = ((Entity)viewEntity).posY;
            this._frustumUpdatePosZ = ((Entity)viewEntity).posZ;
            this._frustumUpdatePosChunkX = ((Entity)viewEntity).chunkCoordX;
            this._frustumUpdatePosChunkY = ((Entity)viewEntity).chunkCoordY;
            this._frustumUpdatePosChunkZ = ((Entity)viewEntity).chunkCoordZ;
            viewFrustum.updateChunkPositions(((Entity)viewEntity).posX, ((Entity)viewEntity).posZ);
         }
      } else {
         this._frustumUpdatePosX = this.frustumUpdatePosX;
         this._frustumUpdatePosY = this.frustumUpdatePosY;
         this._frustumUpdatePosZ = this.frustumUpdatePosZ;
         this._frustumUpdatePosChunkX = this.frustumUpdatePosChunkX;
         this._frustumUpdatePosChunkY = this.frustumUpdatePosChunkY;
         this._frustumUpdatePosChunkZ = this.frustumUpdatePosChunkZ;
         viewFrustum.updateChunkPositions(viewEntityX, viewEntityZ);
      }

   }

   @Redirect(
      method = {"setupTerrain"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/block/state/IBlockState;isOpaqueCube()Z"
)
   )
   private boolean isOpaqueOrWallhacking(IBlockState iBlockState) {
      return iBlockState.isOpaqueCube() || PyroStatic.field_2488.method_1047() != 255;
   }

   @Redirect(
      method = {"renderBlockLayer(Lnet/minecraft/util/BlockRenderLayer;)V"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/renderer/EntityRenderer;enableLightmap()V"
)
   )
   private void enableFakeLightmap(EntityRenderer entityRenderer) {
      if (PyroStatic.field_2488.method_1056()) {
         PyroLightmap.Companion.getINSTANCE().enableLightmap();
      } else {
         entityRenderer.enableLightmap();
      }

   }

   @Redirect(
      method = {"renderSky(FI)V"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/multiplayer/WorldClient;getRainStrength(F)F"
)
   )
   float getRainStrength(WorldClient world, float delta) {
      return (Boolean)PyroStatic.field_2585.c.method_3034() ? PyroStatic.field_2585.method_1082() : world.getRainStrength(delta);
   }

   @Inject(
      method = {"makeEntityOutlineShader"},
      at = {@At("RETURN")}
   )
   private void updateESPShader(CallbackInfo ci) {
      PyroStatic.field_2498.method_1008();
   }

   @Inject(
      method = {"drawSelectionBox"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void drawSelectionBox(EntityPlayer player, RayTraceResult movingObjectPositionIn, int execute, float partialTicks, CallbackInfo info) {
      if ((Boolean)PyroStatic.field_2576.c.method_3034()) {
         PyroStatic.field_2576.method_1185(player, movingObjectPositionIn, execute, partialTicks);
         info.cancel();
      }

   }
}
