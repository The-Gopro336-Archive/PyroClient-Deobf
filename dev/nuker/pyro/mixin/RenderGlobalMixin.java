/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.renderer.EntityRenderer
 *  net.minecraft.client.renderer.RenderGlobal
 *  net.minecraft.client.renderer.ViewFrustum
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.RayTraceResult
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroLightmap;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.fb2;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.ViewFrustum;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={RenderGlobal.class})
public abstract class RenderGlobalMixin {
    @Shadow
    private double Field379;
    @Shadow
    private double Field380;
    @Shadow
    private double Field381;
    @Shadow
    private int Field382;
    @Shadow
    private int Field383;
    @Shadow
    private int Field384;
    @Shadow
    private WorldClient Field385;
    private double Field386 = Double.MIN_VALUE;
    private double Field387 = Double.MIN_VALUE;
    private double Field388 = Double.MIN_VALUE;
    private int Field389 = Integer.MIN_VALUE;
    private int Field390 = Integer.MIN_VALUE;
    private int Field391 = Integer.MIN_VALUE;

    @Redirect(method={"loadRenderers"}, at=@Class0(value="INVOKE", target="Lnet/minecraft/client/Minecraft;getRenderViewEntity()Lnet/minecraft/entity/Entity;"))
    private Entity Method589(Minecraft minecraft) {
        return ((Boolean)PyroStatic.Field6417.Field5236.Method5264()).booleanValue() ? (PyroStatic.Field6417.Field1714.Method7991().Method7979() == fb2.CAMERA ? minecraft.player : PyroStatic.Field6417.Field1712) : minecraft.getRenderViewEntity();
    }

    @Redirect(method={"setupTerrain"}, at=@Class0(value="INVOKE", target="Lnet/minecraft/client/renderer/ViewFrustum;updateChunkPositions(DD)V"))
    private void Method590(ViewFrustum viewFrustum, double viewEntityX, double viewEntityZ) {
        if (((Boolean)PyroStatic.Field6417.Field5236.Method5264()).booleanValue()) {
            EntityPlayerSP viewEntity = PyroStatic.Field6417.Field1714.Method7991().Method7979() == fb2.CAMERA ? Minecraft.getMinecraft().player : PyroStatic.Field6417.Field1712;
            double d0 = viewEntity.posX - this.Field386;
            double d1 = viewEntity.posY - this.Field387;
            double d2 = viewEntity.posZ - this.Field388;
            if (this.Field389 != viewEntity.chunkCoordX || this.Field390 != viewEntity.chunkCoordY || this.Field391 != viewEntity.chunkCoordZ || d0 * d0 + d1 * d1 + d2 * d2 > 16.0) {
                this.Field386 = viewEntity.posX;
                this.Field387 = viewEntity.posY;
                this.Field388 = viewEntity.posZ;
                this.Field389 = viewEntity.chunkCoordX;
                this.Field390 = viewEntity.chunkCoordY;
                this.Field391 = viewEntity.chunkCoordZ;
                viewFrustum.updateChunkPositions(viewEntity.posX, viewEntity.posZ);
            }
        } else {
            this.Field386 = this.Field379;
            this.Field387 = this.Field380;
            this.Field388 = this.Field381;
            this.Field389 = this.Field382;
            this.Field390 = this.Field383;
            this.Field391 = this.Field384;
            viewFrustum.updateChunkPositions(viewEntityX, viewEntityZ);
        }
    }

    @Redirect(method={"setupTerrain"}, at=@Class0(value="INVOKE", target="Lnet/minecraft/block/state/IBlockState;isOpaqueCube()Z"))
    private boolean Method591(IBlockState iBlockState) {
        return iBlockState.isOpaqueCube() || PyroStatic.Field6424.Method2614() != 255;
    }

    @Redirect(method={"renderBlockLayer(Lnet/minecraft/util/BlockRenderLayer;)V"}, at=@Class0(value="INVOKE", target="Lnet/minecraft/client/renderer/EntityRenderer;enableLightmap()V"))
    private void Method592(EntityRenderer entityRenderer) {
        if (PyroStatic.Field6424.Method2622()) {
            PyroLightmap.Field21.Method10057().Method52();
        } else {
            entityRenderer.enableLightmap();
        }
    }

    @Redirect(method={"renderSky(FI)V"}, at=@Class0(value="INVOKE", target="Lnet/minecraft/client/multiplayer/WorldClient;getRainStrength(F)F"))
    float Method593(WorldClient world, float delta) {
        if (((Boolean)PyroStatic.Field6521.Field5236.Method5264()).booleanValue()) {
            return PyroStatic.Field6521.Method2397();
        }
        return world.getRainStrength(delta);
    }

    @Inject(method={"makeEntityOutlineShader"}, at={@Class0(value="RETURN")})
    private void Method594(CallbackInfo ci) {
        PyroStatic.Field6434.Method2731();
    }

    @Inject(method={"drawSelectionBox"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method595(EntityPlayer player, RayTraceResult movingObjectPositionIn, int execute, float partialTicks, CallbackInfo info) {
        if (((Boolean)PyroStatic.Field6512.Field5236.Method5264()).booleanValue()) {
            PyroStatic.Field6512.Method2370(player, movingObjectPositionIn, execute, partialTicks);
            info.Method9034();
        }
    }
}

