/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.Gson;
import dev.nuker.pyro.mixin.EntityRendererAccessor;
import dev.nuker.pyro.mixin.RenderManagerAccessor;
import java.awt.Color;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11;

public class fbB extends Module {
   // $FF: renamed from: c dev.nuker.pyro.fbA
   @NotNull
   public fbA field_746;
   // $FF: renamed from: c java.util.concurrent.CopyOnWriteArrayList
   @NotNull
   public CopyOnWriteArrayList field_747 = new CopyOnWriteArrayList();
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_748 = (BooleanSetting)this.register((f0w)(new BooleanSetting("boundingBox", "BoundingBox", (String)null, true)));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_749 = (BooleanSetting)this.register((f0w)(new BooleanSetting("tracers", "Tracers", (String)null, true)));
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_750 = (DoubleSetting)this.register((f0w)(new DoubleSetting("width", "TracerWidth", (String)null, 0.6D, 0.1D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_751 = (BooleanSetting)this.register((f0w)(new BooleanSetting("colorTracers", "ColorTracers", "Color tracers the same color as the search block", true)));
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_752 = (BooleanSetting)this.register((f0w)(new BooleanSetting("fill", "Fill", (String)null, true)));
   // $FF: renamed from: 0 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_753 = (DoubleSetting)this.register((f0w)(new DoubleSetting("boxWidth", "BoxWidth", (String)null, 1.5D, 0.1D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null)));

   // $FF: renamed from: c (net.minecraft.block.state.IBlockState, net.minecraft.util.math.BlockPos) void
   public void method_1101(@NotNull IBlockState var1, @NotNull BlockPos var2) {
      if (this.field_747.size() >= 100000) {
         this.field_747.clear();
      }

      if (!Intrinsics.areEqual((Object)var1.getBlock(), (Object)Blocks.AIR)) {
         if (this.method_1102(var1.getBlock())) {
            fbz var3 = new fbz(new Vec3d((double)var2.getX(), (double)var2.getY(), (double)var2.getZ()), var1.getBlock());
            if (!this.field_747.contains(var3)) {
               this.field_747.add(var3);
            }
         }

      }
   }

   // $FF: renamed from: c (net.minecraft.block.Block) boolean
   public boolean method_1102(@NotNull Block var1) {
      boolean var2;
      if ((Boolean)this.c.method_3034()) {
         fbA var10000 = this.field_746;
         if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
         }

         if (var10000.method_2666().contains(((ResourceLocation)Block.REGISTRY.getNameForObject(var1)).toString())) {
            var2 = true;
            return var2;
         }
      }

      var2 = false;
      return var2;
   }

   // $FF: renamed from: 4 () void
   public void method_1103() {
      if ((new File("pyro/search_blocks.json")).exists()) {
         try {
            FileReader var1 = new FileReader("pyro/search_blocks.json");
            this.field_746 = (fbA)Pyro.GSON.fromJson((Reader)var1, fbA.class);
            var1.close();
         } catch (IOException var13) {
            var13.printStackTrace();
         }
      } else {
         this.field_746 = new fbA();
         fbA var10000 = this.field_746;
         if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
         }

         Iterable var14 = (Iterable)CollectionsKt.listOf(new Block[]{Blocks.MOB_SPAWNER, (Block)Blocks.PORTAL, Blocks.END_PORTAL_FRAME, Blocks.END_PORTAL, Blocks.DISPENSER, Blocks.DROPPER, (Block)Blocks.HOPPER, Blocks.FURNACE, Blocks.LIT_FURNACE, (Block)Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.ENDER_CHEST, Blocks.WHITE_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.SILVER_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.BLACK_SHULKER_BOX});
         fbA var10 = var10000;
         boolean var2 = false;
         Collection var4 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var14, 10)));
         boolean var5 = false;
         Iterator var6 = var14.iterator();

         while(var6.hasNext()) {
            Object var7 = var6.next();
            Block var8 = (Block)var7;
            boolean var9 = false;
            String var12 = ((ResourceLocation)Block.REGISTRY.getNameForObject(var8)).toString();
            var4.add(var12);
         }

         List var11 = (List)var4;
         var10.method_2667(CollectionsKt.toMutableList((Collection)var11));
      }

   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      this.field_747.clear();
      this.c.renderGlobal.loadRenderers();
   }

   // $FF: renamed from: c (dev.nuker.pyro.fbA) void
   public void method_1104(@NotNull fbA var1) {
      this.field_746 = var1;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1105() {
      return this.field_752;
   }

   // $FF: renamed from: 7 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1106() {
      return this.field_750;
   }

   // $FF: renamed from: 5 () dev.nuker.pyro.fbA
   @NotNull
   public fbA method_1107() {
      fbA var10000 = this.field_746;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("storage");
      }

      return var10000;
   }

   // $FF: renamed from: 8 () java.util.concurrent.CopyOnWriteArrayList
   @NotNull
   public CopyOnWriteArrayList method_1108() {
      return this.field_747;
   }

   public fbB() {
      super("search", "Search", "Allows you to easily find blocks");
      this.method_1103();
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
      if (this.c.player != null) {
         Entity var10000;
         if (this.c.getRenderViewEntity() == null) {
            var10000 = (Entity)this.c.player;
         } else {
            var10000 = this.c.getRenderViewEntity();
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }
         }

         Entity var3 = var10000;
         PyroRenderUtil.field_983.setPosition(var3.lastTickPosX + (var3.posX - var3.lastTickPosX) * (double)var2, var3.lastTickPosY + (var3.posY - var3.lastTickPosY) * (double)var2, var3.lastTickPosZ + (var3.posZ - var3.lastTickPosZ) * (double)var2);
         Iterable var4 = (Iterable)this.field_747;
         boolean var5 = false;
         Iterator var6 = var4.iterator();

         while(var6.hasNext()) {
            Object var7 = var6.next();
            fbz var8 = (fbz)var7;
            boolean var9 = false;
            if (this.c.player.getDistance(var8.method_1410().x, var8.method_1410().y, var8.method_1410().z) <= 256.0D) {
               BlockPos var10 = new BlockPos(var8.method_1410().x, var8.method_1410().y, var8.method_1410().z);
               IBlockState var11 = feg.method_1791(var10);
               if (this.method_1102(var11.getBlock())) {
                  AxisAlignedBB var12 = var11.getBoundingBox((IBlockAccess)this.c.world, var10).offset((double)var10.getX(), (double)var10.getY(), (double)var10.getZ());
                  RenderManager var27 = this.c.getRenderManager();
                  if (var27 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
                  }

                  RenderManagerAccessor var13 = (RenderManagerAccessor)var27;
                  Color var14 = this.method_1110(var11, var11.getBlock());
                  if (((Boolean)this.field_748.c() || (Boolean)this.field_752.c()) && PyroRenderUtil.field_983.isBoundingBoxInFrustum(var12)) {
                     AxisAlignedBB var15 = var12.offset(-var13.getRenderPosX(), -var13.getRenderPosY(), -var13.getRenderPosZ());
                     if ((Boolean)this.field_748.c()) {
                        PyroRenderUtil.method_1441();
                        PyroRenderUtil.method_1431(var15, (float)((Number)this.field_753.c()).doubleValue(), var14);
                        PyroRenderUtil.meth2();
                     }

                     if ((Boolean)this.field_752.c()) {
                        PyroRenderUtil.method_1441();
                        PyroRenderUtil.method_1438(var15, var14);
                        PyroRenderUtil.meth2();
                     }
                  }

                  Entity var26 = this.c.getRenderViewEntity() != null ? this.c.getRenderViewEntity() : (Entity)this.c.player;
                  if ((Boolean)this.field_749.c() && var26 != null) {
                     boolean var16 = this.c.gameSettings.viewBobbing;
                     this.c.gameSettings.viewBobbing = false;
                     double var17 = var8.method_1410().x - var13.getRenderPosX();
                     double var19 = var8.method_1410().y - var13.getRenderPosY();
                     double var21 = var8.method_1410().z - var13.getRenderPosZ();
                     if ((Boolean)this.field_751.c()) {
                        GL11.glColor4f((float)var14.getRed() / 255.0F, (float)var14.getGreen() / 255.0F, (float)var14.getBlue() / 255.0F, 1.0F);
                     } else {
                        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                     }

                     PyroRenderUtil.method_1441();
                     GL11.glLoadIdentity();
                     GL11.glLineWidth((float)((Number)this.field_750.c()).doubleValue());
                     EntityRenderer var28 = this.c.entityRenderer;
                     if (var28 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
                     }

                     ((EntityRendererAccessor)var28).invokeSetupCameraTransform(var2, 0);
                     Vec3d var23 = (new Vec3d(0.0D, 0.0D, 1.0D)).rotatePitch((float)(-Math.toRadians((double)var26.rotationPitch))).rotateYaw((float)(-Math.toRadians((double)var26.rotationYaw)));
                     GL11.glBegin(1);
                     GL11.glVertex3d(var23.x, (double)this.c.player.getEyeHeight() + var23.y, var23.z);
                     GL11.glVertex3d(var17 + 0.5D, var19 + 0.5D, var21 + 0.5D);
                     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                     GL11.glEnd();
                     PyroRenderUtil.meth2();
                     this.c.gameSettings.viewBobbing = var16;
                  }
               }
            }
         }

         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      }

   }

   // $FF: renamed from: 6 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1109() {
      return this.field_751;
   }

   // $FF: renamed from: c (net.minecraft.block.state.IBlockState, net.minecraft.block.Block) java.awt.Color
   @NotNull
   public Color method_1110(@NotNull IBlockState var1, @NotNull Block var2) {
      switch(Block.getIdFromBlock(var2)) {
      case 52:
         return new Color(0, 255, 216, 156);
      case 90:
         return new Color(143, 0, 255, 156);
      default:
         int var3 = var1.getMaterial().getMaterialMapColor().colorValue;
         return new Color(var3 >> 16 & 255, var3 >> 8 & 255, var3 & 255, 100);
      }
   }

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1111() {
      return this.field_748;
   }

   // $FF: renamed from: 0 () void
   public void method_1112() {
      try {
         FileWriter var1 = new FileWriter("pyro/search_blocks.json");
         Gson var10000 = Pyro.GSON;
         fbA var10001 = this.field_746;
         if (var10001 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
         }

         var10000.toJson(var10001, (Appendable)var1);
         var1.close();
      } catch (IOException var2) {
         var2.printStackTrace();
      }

   }

   // $FF: renamed from: 1 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1113() {
      return this.field_749;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1114() {
      return this.field_753;
   }
}
