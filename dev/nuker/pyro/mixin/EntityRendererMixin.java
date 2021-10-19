/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import com.google.common.base.Predicates;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroLightmap;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.class_37;
import dev.nuker.pyro.f4B;
import dev.nuker.pyro.f4C;
import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.EntityViewRenderEvent.CameraSetup;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.Display;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At$Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({EntityRenderer.class})
public abstract class EntityRendererMixin {
   // $FF: renamed from: mc net.minecraft.client.Minecraft
   @Shadow
   @Final
   private Minecraft field_2460;
   @Shadow
   private float thirdPersonDistancePrev;
   @Shadow
   private boolean cloudFog;
   @Shadow
   private Entity pointedEntity;
   @Shadow
   private boolean lightmapUpdateNeeded;
   @Shadow
   private float fogColorRed;
   @Shadow
   private float fogColorGreen;
   @Shadow
   private float fogColorBlue;
   private PyroLightmap pyroLightmap;

   @Shadow
   private void applyBobbing(float partialTicks) {
   }

   @Inject(
      method = {"<init>"},
      at = {@At("RETURN")}
   )
   private void init(Minecraft mcIn, IResourceManager resourceManagerIn, CallbackInfo ci) {
      this.pyroLightmap = new PyroLightmap(mcIn);
      PyroLightmap.Companion.setINSTANCE(this.pyroLightmap);
   }

   @Redirect(
      method = {"setupCameraTransform", "renderHand"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/renderer/EntityRenderer;applyBobbing(F)V"
)
   )
   private void cancelKnockBob(EntityRenderer entityRenderer, float partialTicks) {
      if (!Minecraft.getMinecraft().player.isElytraFlying() || !Minecraft.getMinecraft().player.movementInput.jump) {
         this.applyBobbing(partialTicks);
      }

   }

   @Redirect(
      method = {"renderWorldPass"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/renderer/RenderGlobal;setupTerrain(Lnet/minecraft/entity/Entity;DLnet/minecraft/client/renderer/culling/ICamera;IZ)V"
)
   )
   private void spectateFreecamTerrain(RenderGlobal renderGlobal, Entity viewEntity, double partialTicks, ICamera camera, int frameCount, boolean playerSpectator) {
      renderGlobal.setupTerrain(viewEntity, partialTicks, camera, frameCount, playerSpectator || (Boolean)PyroStatic.field_2481.c.method_3034() || PyroStatic.field_2488.method_1047() != 255);
   }

   @Inject(
      method = {"renderWorldPass"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/renderer/RenderGlobal;renderEntities(Lnet/minecraft/entity/Entity;Lnet/minecraft/client/renderer/culling/ICamera;F)V",
   shift = At$Shift.AFTER
)}
   )
   private void renderWorldPass(int pass, float partialTicks, long finishTimeNano, CallbackInfo callbackInfo) {
      Pyro.getEventManager().method_32(new f4B(partialTicks));
   }

   @Inject(
      method = {"updateLightmap"},
      at = {@At("HEAD")}
   )
   private void onLightmapUpdate(float partialTicks, CallbackInfo ci) {
      if (this.lightmapUpdateNeeded) {
         PyroStatic.field_2488.method_1054();
         if (PyroStatic.field_2488.method_1056()) {
            this.pyroLightmap.updateLightmap(partialTicks);
         }
      }

   }

   @Inject(
      method = {"setupFog"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void increaseClipArea(int startCoords, float partialTicks, CallbackInfo ci) {
      if ((Boolean)PyroStatic.field_2507.c.method_3034() && (Boolean)PyroStatic.field_2507.method_1331().c()) {
         ci.cancel();
         GlStateManager.pushMatrix();
         GlStateManager.setFogDensity(0.0F);
         GlStateManager.popMatrix();
      }

   }

   @Inject(
      method = {"hurtCameraEffect"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void cancelHurtcam(float partialTicks, CallbackInfo ci) {
      if ((Boolean)PyroStatic.field_2507.c.method_3034() && (Boolean)PyroStatic.field_2507.method_1333().c() || !PyroStatic.field_2498.method_986()) {
         ci.cancel();
      }

   }

   @Redirect(
      method = {"setupFog"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/block/state/IBlockState;getMaterial()Lnet/minecraft/block/material/Material;"
)
   )
   private Material cancelLiquidFog(IBlockState iBlockState) {
      return (Boolean)PyroStatic.field_2507.c.method_3034() && (Boolean)PyroStatic.field_2507.method_1323().c() ? Material.AIR : iBlockState.getMaterial();
   }

   @Inject(
      method = {"orientCamera"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void orientCamera(float partialTicks, CallbackInfo ci) {
      if ((Boolean)PyroStatic.field_2535.c.method_3034()) {
         ci.cancel();
         Entity entity = this.field_2460.getRenderViewEntity();
         float f = entity.getEyeHeight();
         double var10000 = entity.prevPosX + (entity.posX - entity.prevPosX) * (double)partialTicks;
         double d1 = entity.prevPosY + (entity.posY - entity.prevPosY) * (double)partialTicks + (double)f;
         var10000 = entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)partialTicks;
         float f1;
         if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).isPlayerSleeping()) {
            f = (float)((double)f + 1.0D);
            GlStateManager.translate(0.0F, 0.3F, 0.0F);
            if (!this.field_2460.gameSettings.debugCamEnable) {
               BlockPos blockpos = new BlockPos(entity);
               IBlockState iblockstate = this.field_2460.world.getBlockState(blockpos);
               ForgeHooksClient.orientBedCamera(this.field_2460.world, blockpos, iblockstate, entity);
               GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks + 180.0F, 0.0F, -1.0F, 0.0F);
               GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, -1.0F, 0.0F, 0.0F);
            }
         } else if (this.field_2460.gameSettings.thirdPersonView > 0) {
            double d3 = (Double)PyroStatic.field_2535.field_700.c();
            if (this.field_2460.gameSettings.debugCamEnable) {
               GlStateManager.translate(0.0F, 0.0F, (float)(-d3));
            } else {
               f1 = entity.rotationYaw;
               float f2 = entity.rotationPitch;
               if (this.field_2460.gameSettings.thirdPersonView == 2) {
                  f2 += 180.0F;
               }

               double d4 = (double)(-MathHelper.sin(f1 * 0.017453292F) * MathHelper.cos(f2 * 0.017453292F)) * d3;
               double d5 = (double)(MathHelper.cos(f1 * 0.017453292F) * MathHelper.cos(f2 * 0.017453292F)) * d3;
               double d6 = (double)(-MathHelper.sin(f2 * 0.017453292F)) * d3;

               for(int i = 0; i < 8; ++i) {
                  float f3 = (float)((i & 1) * 2 - 1);
                  float f4 = (float)((i >> 1 & 1) * 2 - 1);
                  float f5 = (float)((i >> 2 & 1) * 2 - 1);
                  f3 *= 0.1F;
                  f4 *= 0.1F;
                  f5 *= 0.1F;
               }

               if (this.field_2460.gameSettings.thirdPersonView == 2) {
                  GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
               }

               GlStateManager.rotate(entity.rotationPitch - f2, 1.0F, 0.0F, 0.0F);
               GlStateManager.rotate(entity.rotationYaw - f1, 0.0F, 1.0F, 0.0F);
               GlStateManager.translate(0.0F, 0.0F, (float)(-d3));
               GlStateManager.rotate(f1 - entity.rotationYaw, 0.0F, 1.0F, 0.0F);
               GlStateManager.rotate(f2 - entity.rotationPitch, 1.0F, 0.0F, 0.0F);
            }
         } else {
            GlStateManager.translate(0.0F, 0.0F, 0.05F);
         }

         if (!this.field_2460.gameSettings.debugCamEnable) {
            float yaw = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks + 180.0F;
            float pitch = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks;
            f1 = 0.0F;
            if (entity instanceof EntityAnimal) {
               EntityAnimal entityanimal = (EntityAnimal)entity;
               yaw = entityanimal.prevRotationYawHead + (entityanimal.rotationYawHead - entityanimal.prevRotationYawHead) * partialTicks + 180.0F;
            }

            IBlockState state = ActiveRenderInfo.getBlockStateAtEntityViewpoint(this.field_2460.world, entity, partialTicks);
            CameraSetup event = new CameraSetup((EntityRenderer)this, entity, state, (double)partialTicks, yaw, pitch, f1);
            MinecraftForge.EVENT_BUS.post(event);
            GlStateManager.rotate(event.getRoll(), 0.0F, 0.0F, 1.0F);
            GlStateManager.rotate(event.getPitch(), 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(event.getYaw(), 0.0F, 1.0F, 0.0F);
         }

         GlStateManager.translate(0.0F, -f, 0.0F);
         double d0 = entity.prevPosX + (entity.posX - entity.prevPosX) * (double)partialTicks;
         d1 = entity.prevPosY + (entity.posY - entity.prevPosY) * (double)partialTicks + (double)f;
         double d2 = entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)partialTicks;
         this.cloudFog = this.field_2460.renderGlobal.hasCloudFog(d0, d1, d2, partialTicks);
      }
   }

   @Inject(
      method = {"getMouseOver"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void getMouseOver(float partialTicks, CallbackInfo info) {
      boolean reach = (Boolean)PyroStatic.field_2543.c.method_3034();
      boolean miningTrace = (Boolean)PyroStatic.field_2536.c.method_3034();
      if (miningTrace || reach) {
         boolean hasPickaxe = false;
         if (miningTrace) {
            hasPickaxe = this.field_2460.player != null && this.field_2460.player.getHeldItemMainhand().getItem() instanceof ItemPickaxe;
         }

         if (!miningTrace || reach || !(Boolean)PyroStatic.field_2536.method_599().c() || hasPickaxe) {
            info.cancel();
            Entity entity = this.field_2460.getRenderViewEntity();
            if (entity != null && this.field_2460.world != null) {
               this.field_2460.mcProfiler.startSection("pick");
               this.field_2460.pointedEntity = null;
               double d0 = (double)this.field_2460.playerController.getBlockReachDistance();
               if (reach) {
                  d0 += (Double)PyroStatic.field_2543.method_508().c();
               }

               this.field_2460.objectMouseOver = entity.rayTrace(d0, partialTicks);
               Vec3d vec3d = entity.getPositionEyes(partialTicks);
               boolean flag = false;
               int i = true;
               double d1 = d0;
               if (this.field_2460.playerController.extendedReach()) {
                  d1 = 6.0D;
                  d0 = d1;
               } else if (d0 > 3.0D) {
                  flag = true;
               }

               if (this.field_2460.objectMouseOver != null) {
                  d1 = this.field_2460.objectMouseOver.hitVec.distanceTo(vec3d);
               }

               Vec3d vec3d1 = entity.getLook(1.0F);
               Vec3d vec3d2 = vec3d.addVector(vec3d1.x * d0, vec3d1.y * d0, vec3d1.z * d0);
               this.pointedEntity = null;
               Vec3d vec3d3 = null;
               double d2 = d1;
               if (!hasPickaxe) {
                  List list = this.field_2460.world.getEntitiesInAABBexcluding(entity, entity.getEntityBoundingBox().expand(vec3d1.x * d0, vec3d1.y * d0, vec3d1.z * d0).grow(1.0D, 1.0D, 1.0D), Predicates.and(EntitySelectors.NOT_SPECTATING, Predicates.and(EntitySelectors.NOT_SPECTATING, Entity::func_70067_L)));

                  for(int j = 0; j < list.size(); ++j) {
                     Entity entity1 = (Entity)list.get(j);
                     AxisAlignedBB axisalignedbb = entity1.getEntityBoundingBox().grow((double)entity1.getCollisionBorderSize());
                     RayTraceResult raytraceresult = axisalignedbb.calculateIntercept(vec3d, vec3d2);
                     if (axisalignedbb.contains(vec3d)) {
                        if (d2 >= 0.0D) {
                           this.pointedEntity = entity1;
                           vec3d3 = raytraceresult == null ? vec3d : raytraceresult.hitVec;
                           d2 = 0.0D;
                        }
                     } else if (raytraceresult != null) {
                        double d3 = vec3d.distanceTo(raytraceresult.hitVec);
                        if (d3 < d2 || d2 == 0.0D) {
                           if (entity1.getLowestRidingEntity() == entity.getLowestRidingEntity() && !entity1.canRiderInteract()) {
                              if (d2 == 0.0D) {
                                 this.pointedEntity = entity1;
                                 vec3d3 = raytraceresult.hitVec;
                              }
                           } else {
                              this.pointedEntity = entity1;
                              vec3d3 = raytraceresult.hitVec;
                              d2 = d3;
                           }
                        }
                     }
                  }
               }

               double dist = 3.0D;
               if (reach) {
                  dist += (Double)PyroStatic.field_2543.method_508().c();
               }

               if (this.pointedEntity != null && flag && vec3d.distanceTo(vec3d3) > dist) {
                  this.pointedEntity = null;
                  this.field_2460.objectMouseOver = new RayTraceResult(Type.MISS, vec3d3, (EnumFacing)null, new BlockPos(vec3d3));
               }

               if (this.pointedEntity != null && (d2 < d1 || this.field_2460.objectMouseOver == null)) {
                  this.field_2460.objectMouseOver = new RayTraceResult(this.pointedEntity, vec3d3);
                  if (this.pointedEntity instanceof EntityLivingBase || this.pointedEntity instanceof EntityItemFrame) {
                     this.field_2460.pointedEntity = this.pointedEntity;
                  }
               }

               this.field_2460.mcProfiler.endSection();
            }

         }
      }
   }

   @Inject(
      method = {"updateFogColor"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void updateFogColor(float partialTicks, CallbackInfo callback) {
      if ((Boolean)PyroStatic.field_2585.c.method_3034()) {
         callback.cancel();
         float[] v = PyroStatic.field_2585.method_1081();
         this.fogColorRed = v[0];
         this.fogColorGreen = v[1];
         this.fogColorBlue = v[2];
         GlStateManager.clearColor(this.fogColorRed, this.fogColorGreen, this.fogColorBlue, v[3]);
      }

   }

   @Inject(
      method = {"renderWorldPass"},
      at = {@At(
   value = "INVOKE",
   target = "net/minecraft/client/renderer/GlStateManager.clear(I)V",
   ordinal = 1,
   shift = At$Shift.AFTER
)}
   )
   private void renderHand(int pass, float partialTicks, long finishTimeNano, CallbackInfo callbackInfo) {
      if (Display.isActive() || Display.isVisible()) {
         class_37.field_2633.method_3975(partialTicks);
      }

   }

   @Inject(
      method = {"renderWorldPass"},
      at = {@At(
   value = "FIELD",
   target = "Lnet/minecraft/client/renderer/EntityRenderer;renderHand:Z",
   shift = At$Shift.BEFORE
)}
   )
   private void renderHandPre(int pass, float partialTicks, long finishTimeNano, CallbackInfo callbackInfo) {
      if (Display.isActive() || Display.isVisible()) {
         Pyro.getEventManager().method_32(new f4C(partialTicks));
      }

   }

   @Inject(
      method = {"getFOVModifier"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void getFOVModifier(float partialTicks, boolean useFOVSetting, CallbackInfoReturnable callback) {
      if ((Boolean)PyroStatic.field_2587.c.method_3034() && useFOVSetting) {
         callback.setReturnValue(((Integer)PyroStatic.field_2587.method_1173().c()).floatValue());
      }

   }
}
