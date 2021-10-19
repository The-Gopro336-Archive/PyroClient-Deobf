/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

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
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.RayTraceResult.Type;
import org.lwjgl.opengl.GL11;

public class fbN extends Module {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   public DoubleSetting field_701 = (DoubleSetting)this.register(new DoubleSetting("width", "Width", (String)null, 1.0D, 1.0D, 10.0D));
   // $FF: renamed from: c dev.nuker.pyro.f0l
   public f0l field_702 = (f0l)this.register(new f0l("color", "EnemyColor", (String)null, new f00(0.0F, 1.0F, 0.5F, 1.0F)));
   // $FF: renamed from: c java.util.Queue
   public Queue field_703 = new ConcurrentLinkedQueue();

   // $FF: renamed from: c (net.minecraft.client.entity.EntityPlayerSP) dev.nuker.pyro.fbM
   public fbM method_1035(EntityPlayerSP var1) {
      if (var1.getHeldItemMainhand() == null) {
         return fbM.field_1615;
      } else {
         ItemStack var2 = var1.getHeldItem(EnumHand.MAIN_HAND);
         switch(Item.getIdFromItem(var2.getItem())) {
         case 261:
            if (var1.isHandActive()) {
               return fbM.field_1616;
            }
         default:
            return fbM.field_1615;
         case 332:
         case 344:
         case 368:
            return fbM.field_1620;
         case 346:
            return fbM.field_1619;
         case 384:
            return fbM.field_1618;
         case 438:
         case 441:
            return fbM.field_1617;
         }
      }
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
      super.method_123(var1, var2);
      fbM var3 = this.method_1035(this.c.player);
      if (var3 != fbM.field_1615) {
         fbL var4 = new fbL(this, this.c.player, var3);

         while(!var4.method_2800()) {
            var4.method_2807();
            this.field_703.offer(new Vec3d(fbL.method_2809(var4).x - this.c.getRenderManager().viewerPosX, fbL.method_2809(var4).y - this.c.getRenderManager().viewerPosY, fbL.method_2809(var4).z - this.c.getRenderManager().viewerPosZ));
         }

         boolean var5 = this.c.gameSettings.viewBobbing;
         this.c.gameSettings.viewBobbing = false;
         ((EntityRendererAccessor)this.c.entityRenderer).invokeSetupCameraTransform(var2, 0);
         GlStateManager.pushMatrix();
         GlStateManager.disableTexture2D();
         GlStateManager.enableBlend();
         GlStateManager.disableAlpha();
         GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
         GlStateManager.shadeModel(7425);
         GL11.glLineWidth(((Double)this.field_701.c()).floatValue());
         GL11.glEnable(2848);
         GL11.glHint(3154, 4354);
         GlStateManager.disableDepth();
         GL11.glEnable(34383);
         Tessellator var6 = Tessellator.getInstance();

         for(BufferBuilder var7 = var6.getBuffer(); !this.field_703.isEmpty(); var6.draw()) {
            var7.begin(3, DefaultVertexFormats.POSITION_COLOR);
            Vec3d var8 = (Vec3d)this.field_703.poll();
            var7.pos(var8.x, var8.y, var8.z).color(((f00)this.field_702.c()).meth7(), ((f00)this.field_702.c()).method_3446(), ((f00)this.field_702.c()).meth22(), ((f00)this.field_702.c()).meth9()).endVertex();
            if (this.field_703.peek() != null) {
               Vec3d var9 = (Vec3d)this.field_703.peek();
               var7.pos(var9.x, var9.y, var9.z).color(((f00)this.field_702.c()).meth7(), ((f00)this.field_702.c()).method_3446(), ((f00)this.field_702.c()).meth22(), ((f00)this.field_702.c()).meth9()).endVertex();
            }
         }

         GlStateManager.shadeModel(7424);
         GL11.glDisable(2848);
         GlStateManager.enableDepth();
         GL11.glDisable(34383);
         GlStateManager.disableBlend();
         GlStateManager.enableAlpha();
         GlStateManager.enableTexture2D();
         GlStateManager.popMatrix();
         this.c.gameSettings.viewBobbing = var5;
         ((EntityRendererAccessor)this.c.entityRenderer).invokeSetupCameraTransform(var2, 0);
         if (fbL.method_2812(var4)) {
            RayTraceResult var18 = fbL.method_2805(var4);
            AxisAlignedBB var19 = null;
            if (var18 == null) {
               return;
            }

            if (var18.typeOfHit == Type.BLOCK) {
               BlockPos var10 = var18.getBlockPos();
               IBlockState var11 = this.c.world.getBlockState(var10);
               if (var11.getMaterial() != Material.AIR && this.c.world.getWorldBorder().contains(var10)) {
                  double var12 = this.c.getRenderViewEntity().lastTickPosX + (this.c.getRenderViewEntity().posX - this.c.getRenderViewEntity().lastTickPosX) * (double)var2;
                  double var14 = this.c.getRenderViewEntity().lastTickPosY + (this.c.getRenderViewEntity().posY - this.c.getRenderViewEntity().lastTickPosY) * (double)var2;
                  double var16 = this.c.getRenderViewEntity().lastTickPosZ + (this.c.getRenderViewEntity().posZ - this.c.getRenderViewEntity().lastTickPosZ) * (double)var2;
                  var19 = var11.getSelectedBoundingBox(this.c.world, var10).grow(0.0020000000949949026D).offset(-var12, -var14, -var16);
               }
            } else if (var18.typeOfHit == Type.ENTITY && var18.entityHit != null) {
               AxisAlignedBB var20 = var18.entityHit.getEntityBoundingBox();
               if (var20 != null) {
                  var19 = new AxisAlignedBB(var20.minX - this.c.getRenderManager().viewerPosX, var20.minY - this.c.getRenderManager().viewerPosY, var20.minZ - this.c.getRenderManager().viewerPosZ, var20.maxX - this.c.getRenderManager().viewerPosX, var20.maxY - this.c.getRenderManager().viewerPosY, var20.maxZ - this.c.getRenderManager().viewerPosZ);
               }
            }

            if (var19 != null) {
               GlStateManager.enableBlend();
               GlStateManager.tryBlendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
               GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
               GlStateManager.disableTexture2D();
               GlStateManager.glLineWidth(6.0F);
               RenderHelper.enableStandardItemLighting();
               GlStateManager.enablePolygonOffset();
               GlStateManager.doPolygonOffset(1.0F, -1500000.0F);
               GlStateManager.disableLighting();
               RenderGlobal.renderFilledBox(var19, ((f00)this.field_702.c()).meth7(), ((f00)this.field_702.c()).method_3446(), ((f00)this.field_702.c()).meth22(), ((f00)this.field_702.c()).meth9());
               GlStateManager.enableTexture2D();
               GlStateManager.disableBlend();
               GlStateManager.disablePolygonOffset();
               GlStateManager.doPolygonOffset(1.0F, 1500000.0F);
            }
         }

      }
   }

   public fbN() {
      super("trajectories", "Trajectories", (String)null);
   }
}
