/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicate
 *  com.google.common.base.Predicates
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.ActiveRenderInfo
 *  net.minecraft.client.renderer.EntityRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderGlobal
 *  net.minecraft.client.renderer.culling.ICamera
 *  net.minecraft.client.resources.IResourceManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityItemFrame
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.item.ItemPickaxe
 *  net.minecraft.util.EntitySelectors
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraftforge.client.ForgeHooksClient
 *  net.minecraftforge.client.event.EntityViewRenderEvent$CameraSetup
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.Event
 *  org.lwjgl.opengl.Display
 */
package dev.nuker.pyro.mixin;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import dev.nuker.pyro.Class34;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroLightmap;
import dev.nuker.pyro.PyroStatic;
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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.lwjgl.opengl.Display;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={EntityRenderer.class})
public abstract class EntityRendererMixin {
    @Shadow
    @Final
    private Minecraft Field5967;
    @Shadow
    private float Field5968;
    @Shadow
    private boolean Field5969;
    @Shadow
    private Entity Field5970;
    @Shadow
    private boolean Field5971;
    @Shadow
    private float Field5972;
    @Shadow
    private float Field5973;
    @Shadow
    private float Field5974;
    private PyroLightmap Field5975;

    @Shadow
    private void Method8639(float partialTicks) {
    }

    @Inject(method={"<init>"}, at={@Class0(value="RETURN")})
    private void Method8640(Minecraft mcIn, IResourceManager resourceManagerIn, CallbackInfo ci) {
        this.Field5975 = new PyroLightmap(mcIn);
        PyroLightmap.Field21.Method10058(this.Field5975);
    }

    @Redirect(method={"setupCameraTransform", "renderHand"}, at=@Class0(value="INVOKE", target="Lnet/minecraft/client/renderer/EntityRenderer;applyBobbing(F)V"))
    private void Method8641(EntityRenderer entityRenderer, float partialTicks) {
        if (!Minecraft.getMinecraft().player.isElytraFlying() || !Minecraft.getMinecraft().player.movementInput.jump) {
            this.Method8639(partialTicks);
        }
    }

    @Redirect(method={"renderWorldPass"}, at=@Class0(value="INVOKE", target="Lnet/minecraft/client/renderer/RenderGlobal;setupTerrain(Lnet/minecraft/entity/Entity;DLnet/minecraft/client/renderer/culling/ICamera;IZ)V"))
    private void Method8642(RenderGlobal renderGlobal, Entity viewEntity, double partialTicks, ICamera camera, int frameCount, boolean playerSpectator) {
        renderGlobal.setupTerrain(viewEntity, partialTicks, camera, frameCount, playerSpectator || (Boolean)PyroStatic.Field6417.Field5236.Method5264() != false || PyroStatic.Field6424.Method2614() != 255);
    }

    @Inject(method={"renderWorldPass"}, at={@Class0(value="INVOKE", target="Lnet/minecraft/client/renderer/RenderGlobal;renderEntities(Lnet/minecraft/entity/Entity;Lnet/minecraft/client/renderer/culling/ICamera;F)V", shift=At.Shift.AFTER)})
    private void Method8643(int pass, float partialTicks, long finishTimeNano, CallbackInfo callbackInfo) {
        Pyro.Method8978().Method7918(new f4B(partialTicks));
    }

    @Inject(method={"updateLightmap"}, at={@Class0(value="HEAD")})
    private void Method8644(float partialTicks, CallbackInfo ci) {
        if (this.Field5971) {
            PyroStatic.Field6424.Method2620();
            if (PyroStatic.Field6424.Method2622()) {
                this.Field5975.Method50(partialTicks);
            }
        }
    }

    @Inject(method={"setupFog"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method8645(int startCoords, float partialTicks, CallbackInfo ci) {
        if (((Boolean)PyroStatic.Field6443.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6443.Method215().Method7979()).booleanValue()) {
            ci.Method9034();
            GlStateManager.pushMatrix();
            GlStateManager.setFogDensity((float)0.0f);
            GlStateManager.popMatrix();
        }
    }

    @Inject(method={"hurtCameraEffect"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method8646(float partialTicks, CallbackInfo ci) {
        if (((Boolean)PyroStatic.Field6443.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6443.Method281().Method7979()).booleanValue() || !PyroStatic.Field6434.Method2715()) {
            ci.Method9034();
        }
    }

    @Redirect(method={"setupFog"}, at=@Class0(value="INVOKE", target="Lnet/minecraft/block/state/IBlockState;getMaterial()Lnet/minecraft/block/material/Material;"))
    private Material Method8647(IBlockState iBlockState) {
        if (((Boolean)PyroStatic.Field6443.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6443.Method272().Method7979()).booleanValue()) {
            return Material.AIR;
        }
        return iBlockState.getMaterial();
    }

    @Inject(method={"orientCamera"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method8648(float partialTicks, CallbackInfo ci) {
        if (!((Boolean)PyroStatic.Field6471.Field5236.Method5264()).booleanValue()) {
            return;
        }
        ci.Method9034();
        Entity entity = this.Field5967.getRenderViewEntity();
        float f = entity.getEyeHeight();
        double d0 = entity.prevPosX + (entity.posX - entity.prevPosX) * (double)partialTicks;
        double d1 = entity.prevPosY + (entity.posY - entity.prevPosY) * (double)partialTicks + (double)f;
        double d2 = entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)partialTicks;
        if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).isPlayerSleeping()) {
            f = (float)((double)f + 1.0);
            GlStateManager.translate((float)0.0f, (float)0.3f, (float)0.0f);
            if (!this.Field5967.gameSettings.debugCamEnable) {
                BlockPos blockpos = new BlockPos(entity);
                IBlockState iblockstate = this.Field5967.world.getBlockState(blockpos);
                ForgeHooksClient.orientBedCamera((IBlockAccess)this.Field5967.world, (BlockPos)blockpos, (IBlockState)iblockstate, (Entity)entity);
                GlStateManager.rotate((float)(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks + 180.0f), (float)0.0f, (float)-1.0f, (float)0.0f);
                GlStateManager.rotate((float)(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks), (float)-1.0f, (float)0.0f, (float)0.0f);
            }
        } else if (this.Field5967.gameSettings.thirdPersonView > 0) {
            double d3 = (Double)PyroStatic.Field6471.Field1994.Method7979();
            if (this.Field5967.gameSettings.debugCamEnable) {
                GlStateManager.translate((float)0.0f, (float)0.0f, (float)((float)(-d3)));
            } else {
                float f1 = entity.rotationYaw;
                float f2 = entity.rotationPitch;
                if (this.Field5967.gameSettings.thirdPersonView == 2) {
                    f2 += 180.0f;
                }
                double d4 = (double)(-MathHelper.sin((float)(f1 * ((float)Math.PI / 180))) * MathHelper.cos((float)(f2 * ((float)Math.PI / 180)))) * d3;
                double d5 = (double)(MathHelper.cos((float)(f1 * ((float)Math.PI / 180))) * MathHelper.cos((float)(f2 * ((float)Math.PI / 180)))) * d3;
                double d6 = (double)(-MathHelper.sin((float)(f2 * ((float)Math.PI / 180)))) * d3;
                for (int i = 0; i < 8; ++i) {
                    float f3 = (i & 1) * 2 - 1;
                    float f4 = (i >> 1 & 1) * 2 - 1;
                    float f5 = (i >> 2 & 1) * 2 - 1;
                    f3 *= 0.1f;
                    f4 *= 0.1f;
                    f5 *= 0.1f;
                }
                if (this.Field5967.gameSettings.thirdPersonView == 2) {
                    GlStateManager.rotate((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                }
                GlStateManager.rotate((float)(entity.rotationPitch - f2), (float)1.0f, (float)0.0f, (float)0.0f);
                GlStateManager.rotate((float)(entity.rotationYaw - f1), (float)0.0f, (float)1.0f, (float)0.0f);
                GlStateManager.translate((float)0.0f, (float)0.0f, (float)((float)(-d3)));
                GlStateManager.rotate((float)(f1 - entity.rotationYaw), (float)0.0f, (float)1.0f, (float)0.0f);
                GlStateManager.rotate((float)(f2 - entity.rotationPitch), (float)1.0f, (float)0.0f, (float)0.0f);
            }
        } else {
            GlStateManager.translate((float)0.0f, (float)0.0f, (float)0.05f);
        }
        if (!this.Field5967.gameSettings.debugCamEnable) {
            float yaw = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks + 180.0f;
            float pitch = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks;
            float roll = 0.0f;
            if (entity instanceof EntityAnimal) {
                EntityAnimal entityanimal = (EntityAnimal)entity;
                yaw = entityanimal.prevRotationYawHead + (entityanimal.rotationYawHead - entityanimal.prevRotationYawHead) * partialTicks + 180.0f;
            }
            IBlockState state = ActiveRenderInfo.getBlockStateAtEntityViewpoint((World)this.Field5967.world, (Entity)entity, (float)partialTicks);
            EntityViewRenderEvent.CameraSetup event = new EntityViewRenderEvent.CameraSetup((EntityRenderer)this, entity, state, (double)partialTicks, yaw, pitch, roll);
            MinecraftForge.EVENT_BUS.post((Event)event);
            GlStateManager.rotate((float)event.getRoll(), (float)0.0f, (float)0.0f, (float)1.0f);
            GlStateManager.rotate((float)event.getPitch(), (float)1.0f, (float)0.0f, (float)0.0f);
            GlStateManager.rotate((float)event.getYaw(), (float)0.0f, (float)1.0f, (float)0.0f);
        }
        GlStateManager.translate((float)0.0f, (float)(-f), (float)0.0f);
        d0 = entity.prevPosX + (entity.posX - entity.prevPosX) * (double)partialTicks;
        d1 = entity.prevPosY + (entity.posY - entity.prevPosY) * (double)partialTicks + (double)f;
        d2 = entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)partialTicks;
        this.Field5969 = this.Field5967.renderGlobal.hasCloudFog(d0, d1, d2, partialTicks);
    }

    @Inject(method={"getMouseOver"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method8649(float partialTicks, CallbackInfo info) {
        boolean reach = (Boolean)PyroStatic.Field6479.Field5236.Method5264();
        boolean miningTrace = (Boolean)PyroStatic.Field6472.Field5236.Method5264();
        if (!miningTrace && !reach) {
            return;
        }
        boolean hasPickaxe = false;
        if (miningTrace) {
            boolean bl = hasPickaxe = this.Field5967.player != null && this.Field5967.player.getHeldItemMainhand().getItem() instanceof ItemPickaxe;
        }
        if (miningTrace && !reach && ((Boolean)PyroStatic.Field6472.Method215().Method7979()).booleanValue() && !hasPickaxe) {
            return;
        }
        info.Method9034();
        Entity entity = this.Field5967.getRenderViewEntity();
        if (entity != null && this.Field5967.world != null) {
            this.Field5967.mcProfiler.startSection("pick");
            this.Field5967.pointedEntity = null;
            double d0 = this.Field5967.playerController.getBlockReachDistance();
            if (reach) {
                d0 += ((Double)PyroStatic.Field6479.Method218().Method7979()).doubleValue();
            }
            this.Field5967.objectMouseOver = entity.rayTrace(d0, partialTicks);
            Vec3d vec3d = entity.getPositionEyes(partialTicks);
            boolean flag = false;
            int i = 3;
            double d1 = d0;
            if (this.Field5967.playerController.extendedReach()) {
                d0 = d1 = 6.0;
            } else if (d0 > 3.0) {
                flag = true;
            }
            if (this.Field5967.objectMouseOver != null) {
                d1 = this.Field5967.objectMouseOver.hitVec.distanceTo(vec3d);
            }
            Vec3d vec3d1 = entity.getLook(1.0f);
            Vec3d vec3d2 = vec3d.addVector(vec3d1.x * d0, vec3d1.y * d0, vec3d1.z * d0);
            this.Field5970 = null;
            Vec3d vec3d3 = null;
            double d2 = d1;
            if (!hasPickaxe) {
                List list = this.Field5967.world.getEntitiesInAABBexcluding(entity, entity.getEntityBoundingBox().expand(vec3d1.x * d0, vec3d1.y * d0, vec3d1.z * d0).grow(1.0, 1.0, 1.0), Predicates.and((Predicate)EntitySelectors.NOT_SPECTATING, (Predicate)Predicates.and((Predicate)EntitySelectors.NOT_SPECTATING, Entity::func_70067_L)));
                for (int j = 0; j < list.size(); ++j) {
                    double d3;
                    Entity entity1 = (Entity)list.get(j);
                    AxisAlignedBB axisalignedbb = entity1.getEntityBoundingBox().grow((double)entity1.getCollisionBorderSize());
                    RayTraceResult raytraceresult = axisalignedbb.calculateIntercept(vec3d, vec3d2);
                    if (axisalignedbb.contains(vec3d)) {
                        if (!(d2 >= 0.0)) continue;
                        this.Field5970 = entity1;
                        vec3d3 = raytraceresult == null ? vec3d : raytraceresult.hitVec;
                        d2 = 0.0;
                        continue;
                    }
                    if (raytraceresult == null || !((d3 = vec3d.distanceTo(raytraceresult.hitVec)) < d2) && d2 != 0.0) continue;
                    if (entity1.getLowestRidingEntity() == entity.getLowestRidingEntity() && !entity1.canRiderInteract()) {
                        if (d2 != 0.0) continue;
                        this.Field5970 = entity1;
                        vec3d3 = raytraceresult.hitVec;
                        continue;
                    }
                    this.Field5970 = entity1;
                    vec3d3 = raytraceresult.hitVec;
                    d2 = d3;
                }
            }
            double dist = 3.0;
            if (reach) {
                dist += ((Double)PyroStatic.Field6479.Method218().Method7979()).doubleValue();
            }
            if (this.Field5970 != null && flag && vec3d.distanceTo(vec3d3) > dist) {
                this.Field5970 = null;
                this.Field5967.objectMouseOver = new RayTraceResult(RayTraceResult.Type.MISS, vec3d3, (EnumFacing)null, new BlockPos(vec3d3));
            }
            if (this.Field5970 != null && (d2 < d1 || this.Field5967.objectMouseOver == null)) {
                this.Field5967.objectMouseOver = new RayTraceResult(this.Field5970, vec3d3);
                if (this.Field5970 instanceof EntityLivingBase || this.Field5970 instanceof EntityItemFrame) {
                    this.Field5967.pointedEntity = this.Field5970;
                }
            }
            this.Field5967.mcProfiler.endSection();
        }
    }

    @Inject(method={"updateFogColor"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method8650(float partialTicks, CallbackInfo callback) {
        if (((Boolean)PyroStatic.Field6521.Field5236.Method5264()).booleanValue()) {
            callback.Method9034();
            float[] v = PyroStatic.Field6521.Method2505();
            this.Field5972 = v[0];
            this.Field5973 = v[1];
            this.Field5974 = v[2];
            GlStateManager.clearColor((float)this.Field5972, (float)this.Field5973, (float)this.Field5974, (float)v[3]);
        }
    }

    @Inject(method={"renderWorldPass"}, at={@Class0(value="INVOKE", target="net/minecraft/client/renderer/GlStateManager.clear(I)V", ordinal=1, shift=At.Shift.AFTER)})
    private void Method8651(int pass, float partialTicks, long finishTimeNano, CallbackInfo callbackInfo) {
        if (Display.isActive() || Display.isVisible()) {
            Class34.Field4599.Method6750(partialTicks);
        }
    }

    @Inject(method={"renderWorldPass"}, at={@Class0(value="FIELD", target="Lnet/minecraft/client/renderer/EntityRenderer;renderHand:Z", shift=At.Shift.BEFORE)})
    private void Method8652(int pass, float partialTicks, long finishTimeNano, CallbackInfo callbackInfo) {
        if (Display.isActive() || Display.isVisible()) {
            Pyro.Method8978().Method7918(new f4C(partialTicks));
        }
    }

    @Inject(method={"getFOVModifier"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method8653(float partialTicks, boolean useFOVSetting, CallbackInfoReturnable callback) {
        if (((Boolean)PyroStatic.Field6523.Field5236.Method5264()).booleanValue() && useFOVSetting) {
            callback.Method521(Float.valueOf(((Integer)PyroStatic.Field6523.Method2383().Method7979()).floatValue()));
        }
    }
}

