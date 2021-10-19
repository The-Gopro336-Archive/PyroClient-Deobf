/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.fbt;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({RenderManager.class})
public class RenderManagerMixin {
   @Inject(
      method = {"renderEntity"},
      at = {@At("HEAD")}
   )
   private void renderChamsStart(Entity entityIn, double x, double y, double z, float yaw, float partialTicks, boolean p_188391_10_, CallbackInfo ci) {
      boolean isAutoCrystalTarget = (Boolean)PyroStatic.field_2480.c.method_3034() && (Boolean)PyroStatic.field_2480.method_151().c() && PyroStatic.field_2480.method_230() == entityIn;
      if ((Boolean)PyroStatic.field_2529.c.method_3034() || isAutoCrystalTarget) {
         if (!isAutoCrystalTarget && (Boolean)PyroStatic.field_2529.c.method_3034()) {
            if ((Boolean)PyroStatic.field_2529.method_1120().c()) {
               if (!(entityIn instanceof EntityLivingBase) && !PyroStatic.field_2529.method_1121(entityIn)) {
                  return;
               }
            } else if (!PyroStatic.field_2529.method_1121(entityIn)) {
               return;
            }
         }

         GL11.glEnable(32823);
         GL11.glPolygonOffset(1.0F, -2000000.0F);
      }

   }

   @Inject(
      method = {"renderEntity"},
      at = {@At("RETURN")}
   )
   private void renderChamsEnd(Entity entityIn, double x, double y, double z, float yaw, float partialTicks, boolean p_188391_10_, CallbackInfo ci) {
      boolean isAutoCrystalTarget = (Boolean)PyroStatic.field_2480.c.method_3034() && (Boolean)PyroStatic.field_2480.method_151().c() && PyroStatic.field_2480.method_230() == entityIn;
      if ((Boolean)PyroStatic.field_2529.c.method_3034() || isAutoCrystalTarget) {
         if (!isAutoCrystalTarget && (Boolean)PyroStatic.field_2529.c.method_3034()) {
            if ((Boolean)PyroStatic.field_2529.method_1120().c()) {
               if (!(entityIn instanceof EntityLivingBase) && !PyroStatic.field_2529.method_1121(entityIn)) {
                  return;
               }
            } else if (!PyroStatic.field_2529.method_1121(entityIn)) {
               return;
            }
         }

         GL11.glPolygonOffset(1.0F, 1000000.0F);
         GL11.glDisable(32823);
      }

   }

   @Inject(
      method = {"renderEntityStatic"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void renderEntityStatic(Entity entityIn, float partialTicks, boolean p_188388_3_, CallbackInfo info) {
      if ((Boolean)PyroStatic.field_2507.c.method_3034() && entityIn instanceof EntityItem && PyroStatic.field_2507.method_1329().c() == fbt.field_958) {
         info.cancel();
      }

   }
}
