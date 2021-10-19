/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.EntityLivingBaseAccessor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.jetbrains.annotations.Nullable;

public class f5V extends f5q {
   // $FF: renamed from: c net.minecraft.item.ItemStack
   public ItemStack field_1036;

   // $FF: renamed from: c (net.minecraft.entity.player.EntityPlayer) boolean
   public boolean method_1538(EntityPlayer var1) {
      EntityDataManager var10000 = var1.getDataManager();
      if (var1 == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityLivingBaseAccessor");
      } else {
         Object var9 = var10000.get(((EntityLivingBaseAccessor)var1).getPotionEffects());
         if (var9 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
         } else {
            int var2 = (Integer)var9;
            if (var2 <= 0) {
               return false;
            } else {
               double var3 = (double)(var2 >> 16 & 255) / 255.0D;
               double var5 = (double)(var2 >> 8 & 255) / 255.0D;
               double var7 = (double)(var2 >> 0 & 255) / 255.0D;
               return var2 >= 6704489 && var2 <= 11028782 && var3 <= 0.6588235294117647D && var3 >= 0.4D && var5 >= 0.1411764705882353D && var5 <= 0.3137254901960784D && var7 >= 0.13725490196078433D && var5 <= 0.4627450980392157D;
            }
         }
      }
   }

   // $FF: renamed from: 1 () boolean
   public boolean method_1535() {
      return false;
   }

   // $FF: renamed from: 5 () float
   public float method_1526() {
      return 200.0F;
   }

   public f5V() {
      super("targetInfo", "Shows target of AutoCrystal or Aura, inspiration from ZeroDay client");
      this.field_1036 = new ItemStack((Item)Items.POTIONITEM);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f5t, int, net.minecraft.client.gui.ScaledResolution, float, float) void
   public void method_1528(@Nullable f5t var1, int var2, @Nullable ScaledResolution var3, float var4, float var5) {
      Entity var6 = PyroStatic.field_2509.field_330;
      if (var6 == null) {
         var6 = (Entity)PyroStatic.field_2480.method_230();
      }

      if (var6 != null && var6 instanceof EntityPlayer && var6.isEntityAlive()) {
         Entity var7 = var6;
         Iterator var8 = var6.getArmorInventoryList().iterator();
         ArrayList var9 = new ArrayList();

         while(var8.hasNext()) {
            ItemStack var10 = (ItemStack)var8.next();
            if (!var10.isEmpty()) {
               var9.add(var10);
            }
         }

         PyroRenderUtil.meth0(0.0F, 0.0F, this.method_1526(), this.method_1531(), -1727263732);
         boolean var11 = false;
         boolean var12 = false;
         f5V var13 = (f5V)this;
         boolean var14 = false;
         Tessellator var15 = Tessellator.getInstance();
         BufferBuilder var16 = var15.getBuffer();
         GlStateManager.shadeModel(7425);
         GlStateManager.enableBlend();
         GlStateManager.disableTexture2D();
         GlStateManager.tryBlendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         var16.begin(7, DefaultVertexFormats.POSITION_COLOR);
         float var17 = (((EntityPlayer)var6).getHealth() + ((EntityPlayer)var6).getAbsorptionAmount()) / 36.0F;
         int var18 = (int)(var13.method_1526() * var17);
         byte var19 = 2;
         float var20 = 1.0F;
         float var21 = 1.0F;
         float var22 = 0.0F;
         float var23 = 1.0F;
         boolean var24 = true;
         byte var25 = 0;
         int var26 = var19 - var19;
         float var28 = 0.0F;
         int var29 = var25;

         for(int var30 = var25 + var18; var29 < var30; ++var29) {
            float var31 = (float)(var29 - var25) / (float)var18;
            float[] var32 = new float[]{var20, var28, var22, var23};
            float[] var33 = new float[]{var20, var31, var22, var23};
            var16.pos((double)var29, (double)var26 + (double)var19, 0.0D).color(var32[0], var32[1], var32[2], var32[3]).endVertex();
            var16.pos((double)var29 + 1.0D, (double)var26 + (double)var19, 0.0D).color(var33[0], var33[1], var33[2], var33[3]).endVertex();
            var16.pos((double)var29 + 1.0D, (double)var26, 0.0D).color(var33[0], var33[1], var33[2], var33[3]).endVertex();
            var16.pos((double)var29, (double)var26, 0.0D).color(var32[0], var32[1], var32[2], var32[3]).endVertex();
            var28 = var31;
         }

         var15.draw();
         GlStateManager.enableTexture2D();
         GlStateManager.disableBlend();
         GlStateManager.shadeModel(7424);

         try {
            GuiInventory.drawEntityOnScreen(20, 70, 37, var4, var5, (EntityLivingBase)var7);
         } catch (Exception var35) {
         }

         GlStateManager.pushMatrix();
         GlStateManager.scale(1.5F, 1.5F, 1.5F);
         PyroRenderUtil.meth1(var6.getName(), 33.333332F, 3.3333333F, -1);
         GlStateManager.popMatrix();
         int var36 = 0;

         try {
            NetHandlerPlayClient var10000 = fdZ.field_976.getConnection();
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            var36 = var10000.getPlayerInfo(var6.getUniqueID()).getResponseTime();
         } catch (Exception var34) {
         }

         String var37 = var36 + "ms";
         GlStateManager.pushMatrix();
         GlStateManager.scale(0.8F, 0.8F, 0.8F);
         PyroRenderUtil.meth1(var37, this.method_1526() - PyroRenderUtil.method_1439(var37) * 0.8F + (float)40, 5.0F, -1);
         GlStateManager.popMatrix();
         f6B var38 = PyroStatic.field_2558.method_938(var6.getName(), var6.getEntityId());
         ItemStack var39 = new ItemStack(Items.TOTEM_OF_UNDYING, var38.field_1674 > 0 ? (var38.field_1674 == 1 ? 1337 : var38.field_1674) : 1);
         ItemStack var40 = new ItemStack(Items.SKULL, var38.field_1675 > 0 ? (var38.field_1675 == 1 ? 1337 : var38.field_1675) : 1);
         int var41 = 20;
         GlStateManager.pushMatrix();
         GlStateManager.scale(0.8F, 0.8F, 0.8F);
         ItemStack[] var46 = new ItemStack[]{var39, var40, this.field_1036};
         int var47 = var46.length;

         for(int var44 = 0; var44 < var47; ++var44) {
            ItemStack var42 = var46[var44];
            GlStateManager.pushMatrix();
            GlStateManager.depthMask(true);
            GlStateManager.clear(256);
            RenderHelper.enableStandardItemLighting();
            fdZ.field_976.getRenderItem().zLevel = -150.0F;
            GlStateManager.disableAlpha();
            GlStateManager.enableDepth();
            GlStateManager.disableCull();
            fdZ.field_976.getRenderItem().renderItemAndEffectIntoGUI(var42, 55, var41);
            fdZ.field_976.getRenderItem().renderItemOverlayIntoGUI(fdZ.field_976.fontRenderer, var42, 55, var41, var42.getCount() == 1337 ? "1" : null);
            fdZ.field_976.getRenderItem().zLevel = 0.0F;
            RenderHelper.disableStandardItemLighting();
            GlStateManager.enableCull();
            GlStateManager.enableAlpha();
            GlStateManager.popMatrix();
            var41 += 14;
         }

         PyroRenderUtil.meth1("Totems Popped", 73.0F, 23.0F, -1);
         PyroRenderUtil.meth1("Total Deaths", 73.0F, 40.0F, -1);
         boolean var43 = this.method_1538((EntityPlayer)var6);
         PyroRenderUtil.meth1(var43 ? "Active" : "Inactive", 73.0F, 57.0F, var43 ? 16711680 : -1);
         GlStateManager.popMatrix();
         GlStateManager.pushMatrix();
         GlStateManager.scale(1.5F, 1.5F, 1.5F);
         String var45 = "Vulnerable!";
         var18 = -1;
         boolean var49 = false;
         boolean var51 = false;
         f5V var52 = (f5V)this;
         boolean var54 = false;
         var24 = true;
         boolean var55 = true;
         var26 = 0;

         for(byte var27 = 3; var26 <= var27; ++var26) {
            BlockPos var56 = fdN.method_1870(var6, faP.field_793[var26]);
            Block var57 = feg.method_1779(var56);
            if (var57.isReplaceable((IBlockAccess)fdZ.field_976.world, var56) || var57 != Blocks.BEDROCK && var57 != Blocks.OBSIDIAN) {
               var24 = false;
               break;
            }

            if (var57 == Blocks.OBSIDIAN) {
               var55 = false;
            }
         }

         if (var24) {
            var45 = "IN HOLE!";
            if (var55) {
               var18 = 16711680;
            } else {
               var18 = 16776960;
               if (!PyroStatic.field_2559.method_1176((EntityPlayer)var6).isEmpty()) {
                  var45 = "CITY!";
                  var18 = 1834752;
               }
            }
         }

         PyroRenderUtil.meth1(var45, 33.333332F, this.method_1531() - (float)40, var18);
         GlStateManager.popMatrix();
         Collections.reverse((List)var9);
         var41 = 18;
         Iterator var50 = var9.iterator();

         while(var50.hasNext()) {
            ItemStack var48 = (ItemStack)var50.next();
            GlStateManager.pushMatrix();
            GlStateManager.depthMask(true);
            GlStateManager.clear(256);
            RenderHelper.enableStandardItemLighting();
            fdZ.field_976.getRenderItem().zLevel = -150.0F;
            GlStateManager.disableAlpha();
            GlStateManager.enableDepth();
            GlStateManager.disableCull();
            if (var48 == null) {
               Intrinsics.throwNpe();
            }

            var21 = (float)(var48.getMaxDamage() - var48.getItemDamage()) / (float)var48.getMaxDamage() * 100.0F;
            fdZ.field_976.getRenderItem().renderItemAndEffectIntoGUI(var48, (int)(this.method_1526() - (float)20), var41);
            fdZ.field_976.getRenderItem().renderItemOverlays(fdZ.field_976.fontRenderer, var48, (int)(this.method_1526() - (float)20), var41);
            var18 = 2096896;
            if (var21 > (float)30 && var21 < (float)70) {
               var18 = 16776960;
            } else if (var21 <= (float)30) {
               var18 = 16711680;
            }

            String var53 = String.valueOf(var21);
            PyroRenderUtil.meth1(var53, (float)-20 - PyroRenderUtil.method_1439(var53) + this.method_1526(), (float)var41 + (float)5, var18);
            var41 += 14;
            fdZ.field_976.getRenderItem().zLevel = 0.0F;
            RenderHelper.disableStandardItemLighting();
            GlStateManager.enableCull();
            GlStateManager.enableAlpha();
            GlStateManager.popMatrix();
         }
      }

   }

   // $FF: renamed from: 0 () float
   public float method_1531() {
      return 80.0F;
   }
}
