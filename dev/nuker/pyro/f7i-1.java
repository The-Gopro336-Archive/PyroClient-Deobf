/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.RenderManagerAccessor;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11;

public class f7i extends Module {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   public DoubleSetting field_416 = (DoubleSetting)this.register((f0w)(new DoubleSetting("range", "Range", (String)null, 10.0D, 1.0D, 100.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: 0 dev.nuker.pyro.DoubleSetting
   public DoubleSetting field_417 = (DoubleSetting)this.register((f0w)(new DoubleSetting("delay", "Delay", (String)null, 35.0D, 0.0D, 100.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: 1 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_418 = (DoubleSetting)this.register((f0w)(new DoubleSetting("startHeight", "StartHeight", (String)null, 4.0D, 1.0D, 16.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: 2 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_419 = (DoubleSetting)this.register((f0w)(new DoubleSetting("addHeight", "AddHeight", (String)null, 10.0D, 1.0D, 64.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c dev.nuker.pyro.f0o
   public f0o field_420;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_421;
   // $FF: renamed from: c dev.nuker.pyro.fe8
   public fe8 field_422;
   // $FF: renamed from: c net.minecraft.block.Block[]
   public Block[] field_423;
   // $FF: renamed from: 1 int
   public int field_424;
   // $FF: renamed from: 2 int
   public int field_425;
   // $FF: renamed from: 3 int
   public int field_426;
   // $FF: renamed from: c java.util.ArrayList
   @NotNull
   public ArrayList field_427;
   // $FF: renamed from: 0 java.util.ArrayList
   @NotNull
   public ArrayList field_428;
   // $FF: renamed from: 4 int
   public int field_429;
   // $FF: renamed from: c boolean
   public boolean field_430;
   // $FF: renamed from: c dev.nuker.pyro.f7g
   public f7g field_431;

   // $FF: renamed from: 0 () int
   public int method_631() {
      return this.field_426;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      if (var1 && this.c.world == null) {
         this.c.method_3033(false);
      } else {
         if (!var1) {
            this.field_427.clear();
            this.field_428.clear();
            this.field_429 = -2;
         } else {
            this.field_431 = new f7g(this);
            f7g var10000 = this.field_431;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            var10000.method_3015();
         }

      }
   }

   // $FF: renamed from: 4 (int) void
   public void method_632(int var1) {
      this.field_425 = var1;
   }

   // $FF: renamed from: 1 () int
   public int method_633() {
      return this.field_424;
   }

   // $FF: renamed from: 2 () int
   public int method_634() {
      return this.field_425;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f43) void
   @f0g
   public void method_635(@NotNull f43 var1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: 6 () java.util.ArrayList
   @NotNull
   public ArrayList method_636() {
      return this.field_427;
   }

   // $FF: renamed from: 6 (int) void
   public void method_637(int var1) {
      this.field_424 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f7i) dev.nuker.pyro.f0o
   public static f0o method_638(f7i var0) {
      return var0.field_420;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
      super.method_123(var1, var2);
      if ((Boolean)this.field_421.c()) {
         Color var3 = new Color(1.0F, 0.0F, 0.0F, 0.6F);
         double var10000;
         RenderManager var10001;
         if (this.field_428.size() > 1000) {
            this.field_428.clear();
         } else {
            Iterable var4 = (Iterable)this.field_428;
            boolean var5 = false;
            Iterator var6 = var4.iterator();

            while(var6.hasNext()) {
               Object var7 = var6.next();
               BlockPos var8 = (BlockPos)var7;
               boolean var9 = false;
               var10000 = (double)var8.getX();
               var10001 = this.c.getRenderManager();
               if (var10001 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
               }

               double var10 = var10000 - ((RenderManagerAccessor)var10001).getRenderPosX();
               var10000 = (double)var8.getY();
               var10001 = this.c.getRenderManager();
               if (var10001 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
               }

               double var12 = var10000 - ((RenderManagerAccessor)var10001).getRenderPosY();
               var10000 = (double)var8.getZ();
               var10001 = this.c.getRenderManager();
               if (var10001 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
               }

               double var14 = var10000 - ((RenderManagerAccessor)var10001).getRenderPosZ();
               if (this.c.player.getDistance((double)var8.getX(), (double)var8.getY(), (double)var8.getZ()) <= 128.0D) {
                  PyroRenderUtil.method_1441();
                  PyroRenderUtil.method_1431(new AxisAlignedBB(var10, var12, var14, var10 + 1.0D, var12 + 1.0D, var14 + 1.0D), 1.0F, var3);
                  PyroRenderUtil.meth2();
               }
            }
         }

         if (this.field_429 >= 0) {
            BlockPos var16 = (BlockPos)this.field_427.get(this.field_429);
            var10000 = (double)var16.getX();
            var10001 = this.c.getRenderManager();
            if (var10001 == null) {
               throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
            }

            double var17 = var10000 - ((RenderManagerAccessor)var10001).getRenderPosX();
            var10000 = (double)var16.getY();
            var10001 = this.c.getRenderManager();
            if (var10001 == null) {
               throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
            }

            double var18 = var10000 - ((RenderManagerAccessor)var10001).getRenderPosY();
            var10000 = (double)var16.getZ();
            var10001 = this.c.getRenderManager();
            if (var10001 == null) {
               throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
            }

            double var19 = var10000 - ((RenderManagerAccessor)var10001).getRenderPosZ();
            if (this.c.player.getDistance((double)var16.getX(), (double)var16.getY(), (double)var16.getZ()) <= 128.0D) {
               PyroRenderUtil.method_1441();
               PyroRenderUtil.method_1431(new AxisAlignedBB(var17, var18, var19, var17 + 1.0D, var18 + 1.0D, var19 + 1.0D), 1.0F, var3);
               PyroRenderUtil.meth2();
            }

            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         }
      }

   }

   public f7i() {
      super("orebfuscator", "Orebfuscator", "Attempts to turn fake ores from the Orebfuscator plugin into real blocks.");
      this.field_420 = (f0o)this.register((f0w)(new f0o("mode", "Mode", (String)null, (Enum)f7f.field_1833)));
      this.field_421 = (BooleanSetting)this.register((f0w)(new BooleanSetting("visualize", "Visualize", (String)null, false)));
      this.field_422 = new fe8();
      this.field_423 = new Block[]{Blocks.AIR, (Block)Blocks.WATER, (Block)Blocks.FIRE, (Block)Blocks.FLOWING_WATER, (Block)Blocks.LAVA, (Block)Blocks.FLOWING_LAVA, (Block)Blocks.PORTAL, Blocks.END_PORTAL, Blocks.END_PORTAL_FRAME, Blocks.BEDROCK};
      this.field_427 = new ArrayList();
      this.field_428 = new ArrayList();
      this.field_429 = -2;
   }

   // $FF: renamed from: 5 (int) void
   public void method_639(int var1) {
      this.field_426 = var1;
   }

   // $FF: renamed from: 7 () int
   public int method_640() {
      return this.field_429;
   }

   // $FF: renamed from: 3 (int) void
   public void method_641(int var1) {
      this.field_429 = var1;
   }

   // $FF: renamed from: 5 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_642() {
      return this.field_419;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_643() {
      return this.field_418;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f7i, net.minecraft.client.Minecraft) void
   public static void method_644(f7i var0, Minecraft var1) {
      var0.c = var1;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f7i) net.minecraft.client.Minecraft
   public static Minecraft method_645(f7i var0) {
      return var0.c;
   }

   // $FF: renamed from: 4 () java.util.ArrayList
   @NotNull
   public ArrayList method_646() {
      return this.field_428;
   }
}
