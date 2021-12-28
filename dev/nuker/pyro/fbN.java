/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.RenderGlobal
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  org.lwjgl.opengl.GL11
 */
package dev.nuker.pyro;

import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.f0l;
import dev.nuker.pyro.fbL;
import dev.nuker.pyro.fbM;
import dev.nuker.pyro.mixin.EntityRendererAccessor;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.annotation.Nullable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class fbN
extends Module {
    public DoubleSetting Field1987 = (DoubleSetting)this.Method7264(new DoubleSetting("width", "Width", null, 1.0, 1.0, 10.0));
    public f0l Field1988 = (f0l)this.Method7264(new f0l("color", "EnemyColor", null, new f00(0.0f, 1.0f, 0.5f, 1.0f)));
    public Queue<Vec3d> Field1989 = new ConcurrentLinkedQueue<Vec3d>();

    public fbM Method2669(EntityPlayerSP entityPlayerSP) {
        if (entityPlayerSP.getHeldItemMainhand() == null) {
            return fbM.NONE;
        }
        ItemStack itemStack = entityPlayerSP.getHeldItem(EnumHand.MAIN_HAND);
        switch (Item.getIdFromItem((Item)itemStack.getItem())) {
            case 261: {
                if (!entityPlayerSP.isHandActive()) break;
                return fbM.ARROW;
            }
            case 346: {
                return fbM.FISHING_ROD;
            }
            case 438: 
            case 441: {
                return fbM.POTION;
            }
            case 384: {
                return fbM.EXPERIENCE;
            }
            case 332: 
            case 344: 
            case 368: {
                return fbM.NORMAL;
            }
        }
        return fbM.NONE;
    }

    @Override
    public void Method195(@Nullable Vec3d vec3d, float f) {
        Vec3d vec3d2;
        Vec3d vec3d3;
        super.Method195(vec3d, f);
        fbM fbM2 = this.Method2669(this.Field5233.player);
        if (fbM2 == fbM.NONE) {
            return;
        }
        fbL fbL2 = new fbL(this, this.Field5233.player, fbM2);
        while (!fbL2.Method2559()) {
            fbL2.Method2566();
            this.Field1989.offer(new Vec3d(fbL.Method2568((fbL)fbL2).x - this.Field5233.getRenderManager().viewerPosX, fbL.Method2568((fbL)fbL2).y - this.Field5233.getRenderManager().viewerPosY, fbL.Method2568((fbL)fbL2).z - this.Field5233.getRenderManager().viewerPosZ));
        }
        boolean bl = this.Field5233.gameSettings.viewBobbing;
        this.Field5233.gameSettings.viewBobbing = false;
        ((EntityRendererAccessor)this.Field5233.entityRenderer).Method4472(f, 0);
        GlStateManager.pushMatrix();
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.shadeModel((int)7425);
        GL11.glLineWidth((float)((Double)this.Field1987.Method7979()).floatValue());
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GlStateManager.disableDepth();
        GL11.glEnable((int)34383);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        while (!this.Field1989.isEmpty()) {
            bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
            vec3d3 = this.Field1989.poll();
            bufferBuilder.pos(vec3d3.x, vec3d3.y, vec3d3.z).color(((f00)this.Field1988.Method7979()).Method7514(), ((f00)this.Field1988.Method7979()).Method7517(), ((f00)this.Field1988.Method7979()).Method7531(), ((f00)this.Field1988.Method7979()).Method7522()).endVertex();
            if (this.Field1989.peek() != null) {
                vec3d2 = this.Field1989.peek();
                bufferBuilder.pos(vec3d2.x, vec3d2.y, vec3d2.z).color(((f00)this.Field1988.Method7979()).Method7514(), ((f00)this.Field1988.Method7979()).Method7517(), ((f00)this.Field1988.Method7979()).Method7531(), ((f00)this.Field1988.Method7979()).Method7522()).endVertex();
            }
            tessellator.draw();
        }
        GlStateManager.shadeModel((int)7424);
        GL11.glDisable((int)2848);
        GlStateManager.enableDepth();
        GL11.glDisable((int)34383);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();
        this.Field5233.gameSettings.viewBobbing = bl;
        ((EntityRendererAccessor)this.Field5233.entityRenderer).Method4472(f, 0);
        if (fbL.Method2571(fbL2)) {
            AxisAlignedBB axisAlignedBB;
            vec3d3 = fbL.Method2564(fbL2);
            vec3d2 = null;
            if (vec3d3 == null) {
                return;
            }
            if (vec3d3.typeOfHit == RayTraceResult.Type.BLOCK) {
                BlockPos blockPos = vec3d3.getBlockPos();
                IBlockState iBlockState = this.Field5233.world.getBlockState(blockPos);
                if (iBlockState.getMaterial() != Material.AIR && this.Field5233.world.getWorldBorder().contains(blockPos)) {
                    double d = this.Field5233.getRenderViewEntity().lastTickPosX + (this.Field5233.getRenderViewEntity().posX - this.Field5233.getRenderViewEntity().lastTickPosX) * (double)f;
                    double d2 = this.Field5233.getRenderViewEntity().lastTickPosY + (this.Field5233.getRenderViewEntity().posY - this.Field5233.getRenderViewEntity().lastTickPosY) * (double)f;
                    double d3 = this.Field5233.getRenderViewEntity().lastTickPosZ + (this.Field5233.getRenderViewEntity().posZ - this.Field5233.getRenderViewEntity().lastTickPosZ) * (double)f;
                    vec3d2 = iBlockState.getSelectedBoundingBox((World)this.Field5233.world, blockPos).grow((double)0.002f).offset(-d, -d2, -d3);
                }
            } else if (vec3d3.typeOfHit == RayTraceResult.Type.ENTITY && vec3d3.entityHit != null && (axisAlignedBB = vec3d3.entityHit.getEntityBoundingBox()) != null) {
                vec3d2 = new AxisAlignedBB(axisAlignedBB.minX - this.Field5233.getRenderManager().viewerPosX, axisAlignedBB.minY - this.Field5233.getRenderManager().viewerPosY, axisAlignedBB.minZ - this.Field5233.getRenderManager().viewerPosZ, axisAlignedBB.maxX - this.Field5233.getRenderManager().viewerPosX, axisAlignedBB.maxY - this.Field5233.getRenderManager().viewerPosY, axisAlignedBB.maxZ - this.Field5233.getRenderManager().viewerPosZ);
            }
            if (vec3d2 != null) {
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
                GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                GlStateManager.disableTexture2D();
                GlStateManager.glLineWidth((float)6.0f);
                RenderHelper.enableStandardItemLighting();
                GlStateManager.enablePolygonOffset();
                GlStateManager.doPolygonOffset((float)1.0f, (float)-1500000.0f);
                GlStateManager.disableLighting();
                RenderGlobal.renderFilledBox((AxisAlignedBB)vec3d2, (float)((f00)this.Field1988.Method7979()).Method7514(), (float)((f00)this.Field1988.Method7979()).Method7517(), (float)((f00)this.Field1988.Method7979()).Method7531(), (float)((f00)this.Field1988.Method7979()).Method7522());
                GlStateManager.enableTexture2D();
                GlStateManager.disableBlend();
                GlStateManager.disablePolygonOffset();
                GlStateManager.doPolygonOffset((float)1.0f, (float)1500000.0f);
            }
        }
    }

    public fbN() {
        super("trajectories", "Trajectories", null);
    }
}

