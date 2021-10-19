/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.Gson;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerDigging.Action;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fdh extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_828;
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_829;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_830;
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_831;
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_832;
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_833;
   // $FF: renamed from: c dev.nuker.pyro.f0l
   @NotNull
   public f0l field_834;
   // $FF: renamed from: 0 dev.nuker.pyro.f0l
   @NotNull
   public f0l field_835;
   // $FF: renamed from: c dev.nuker.pyro.fe8
   @NotNull
   public fe8 field_836;
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos field_837;
   // $FF: renamed from: c java.util.List
   @NotNull
   public List field_838;
   // $FF: renamed from: c net.minecraft.block.Block
   @Nullable
   public Block field_839;
   // $FF: renamed from: 0 java.util.List
   @NotNull
   public List field_840;
   // $FF: renamed from: c dev.nuker.pyro.fdd
   @NotNull
   public fdd field_841;

   // $FF: renamed from: 2 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1225() {
      return this.field_831;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fdd) void
   public void method_1226(@NotNull fdd var1) {
      this.field_841 = var1;
   }

   // $FF: renamed from: c (net.minecraft.block.state.IBlockState, net.minecraft.util.math.BlockPos, net.minecraft.block.Block) boolean
   public boolean method_1227(@NotNull IBlockState var1, @NotNull BlockPos var2, @NotNull Block var3) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: 0 (net.minecraft.block.Block) boolean
   public boolean method_1228(@NotNull Block var1) {
      boolean var2;
      if ((Boolean)this.c.method_3034()) {
         fdd var10000 = this.field_841;
         if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
         }

         if (var10000.method_1983().contains(((ResourceLocation)Block.REGISTRY.getNameForObject(var1)).toString())) {
            var2 = true;
            return var2;
         }
      }

      var2 = false;
      return var2;
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.fe8
   @NotNull
   public fe8 method_1229() {
      return this.field_836;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1230() {
      return this.field_830;
   }

   // $FF: renamed from: 5 () java.util.List
   @NotNull
   public List method_1231() {
      return this.field_838;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g(10)
   @LauncherEventHide
   public void method_1232(@NotNull f4u var1) {
      this.5(((fdb)this.field_828.c()).toString());
      if (var1.c() == f41.field_2120 && !var1.c()) {
         this.field_838.clear();
         int var2 = (int)(this.c.player.posX - ((Number)this.field_829.c()).doubleValue());
         int var3 = (int)(this.c.player.posX + ((Number)this.field_829.c()).doubleValue());
         int var4 = (int)(this.c.player.posY - ((Number)this.field_829.c()).doubleValue());
         int var5 = (int)(this.c.player.posY + ((Number)this.field_829.c()).doubleValue());
         int var6 = (int)(this.c.player.posZ - ((Number)this.field_829.c()).doubleValue());
         int var7 = (int)(this.c.player.posZ + ((Number)this.field_829.c()).doubleValue());
         if ((Boolean)this.field_831.c()) {
            var4 = (int)this.c.player.posY;
         }

         if ((fdb)this.field_828.c() != fdb.field_1302) {
            if (class_2.field_982.method_1424() != null && Intrinsics.areEqual((Object)class_2.field_982.method_1424(), (Object)((fdh)this)) ^ true) {
               return;
            }

            if (Intrinsics.areEqual((Object)class_2.field_982.method_1424(), (Object)((fdh)this)) && this.field_837 != null) {
               BlockPos var10002 = this.field_837;
               if (var10002 == null) {
                  Intrinsics.throwNpe();
               }

               this.method_1241(var1, var10002);
               return;
            }
         }

         int var8 = var2;

         for(int var9 = var3; var8 < var9; ++var8) {
            int var10 = var4;

            for(int var11 = var5; var10 < var11; ++var10) {
               int var12 = var6;

               for(int var13 = var7; var12 < var13; ++var12) {
                  BlockPos var14 = new BlockPos(var8, var10, var12);
                  double var15 = this.c.player.posX - ((double)var14.getX() + 0.5D);
                  double var17 = this.c.player.posY - ((double)var14.getY() + 0.5D) + 1.5D;
                  double var19 = this.c.player.posZ - ((double)var14.getZ() + 0.5D);
                  double var21 = var15 * var15 + var17 * var17 + var19 * var19;
                  if (!(var21 > 36.0D)) {
                     Block var23 = feg.method_1779(var14);
                     if ((!(Boolean)this.field_830.c() || !(Intrinsics.areEqual((Object)var23, (Object)this.field_839) ^ true)) && this.method_1227(feg.method_1791(var14), var14, var23)) {
                        if ((fdb)this.field_828.c() != fdb.field_1302) {
                           if ((Boolean)this.field_833.c() && (fdb)this.field_828.c() != fdb.field_1305 && (fdb)this.field_828.c() != fdb.field_1306) {
                              Vec3d var24 = new Vec3d(this.c.player.posX, this.c.player.getEntityBoundingBox().minY + (double)this.c.player.getEyeHeight(), this.c.player.posZ);
                              Vec3d var25 = new Vec3d((double)var14.getX() + 0.5D, (double)var14.getY() + 0.5D, (double)var14.getZ() + 0.5D);
                              RayTraceResult var10000 = this.c.world.rayTraceBlocks(var24, var25, false, true, true);
                              if (var10000 == null) {
                                 continue;
                              }

                              RayTraceResult var26 = var10000;
                              if (Intrinsics.areEqual((Object)var26.getBlockPos(), (Object)var14) ^ true) {
                                 continue;
                              }
                           }

                           if (this.method_1241(var1, var14)) {
                              this.field_837 = var14;
                              class_2.field_982.method_1425((Module)this, var14, (Boolean)this.field_833.c(), (Consumer)(new fdf(this)));
                              break;
                           }
                        } else if (Intrinsics.areEqual((Object)var23, (Object)Blocks.AIR) ^ true) {
                           this.c.player.connection.sendPacket((Packet)(new CPacketPlayerDigging(Action.START_DESTROY_BLOCK, var14, EnumFacing.UP)));
                           this.field_838.add(var14);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   // $FF: renamed from: 6 () net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos method_1233() {
      return this.field_837;
   }

   // $FF: renamed from: e () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_1234() {
      return this.field_834;
   }

   // $FF: renamed from: c (net.minecraft.block.Block) void
   public void method_1235(@Nullable Block var1) {
      this.field_839 = var1;
   }

   // $FF: renamed from: a () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1236() {
      return this.field_833;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1237() {
      return this.field_832;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) void
   public void method_1238(@Nullable BlockPos var1) {
      this.field_837 = var1;
   }

   // $FF: renamed from: f () void
   public void method_1239() {
      if ((new File("pyro/nuker_blocks.json")).exists()) {
         try {
            FileReader var1 = new FileReader("pyro/nuker_blocks.json");
            this.field_841 = (fdd)Pyro.GSON.fromJson((Reader)var1, fdd.class);
            var1.close();
         } catch (IOException var2) {
            var2.printStackTrace();
         }
      } else {
         this.field_841 = new fdd();
      }

   }

   // $FF: renamed from: 8 () net.minecraft.block.Block
   @Nullable
   public Block method_1240() {
      return this.field_839;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u, net.minecraft.util.math.BlockPos) boolean
   public boolean method_1241(@NotNull f4u var1, @NotNull BlockPos var2) {
      if ((Boolean)this.field_832.c()) {
         float[] var3 = few.method_1716().method_1736(var2, few.method_1732(var2, true));
         if (var3 != null) {
            var1.0();
            var1.method_3139(var3[0]);
            var1.method_3140(var3[1]);
            return true;
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4k) void
   @f0g
   @LauncherEventHide
   public void method_1242(@NotNull f4k var1) {
      if ((Boolean)this.c.method_3034() && this.field_836.method_1980(50.0D)) {
         this.field_836.method_1979();
         this.field_839 = feg.method_1779(var1.method_3268());
      }

   }

   // $FF: renamed from: c () dev.nuker.pyro.fdd
   @NotNull
   public fdd method_1243() {
      fdd var10000 = this.field_841;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("storage");
      }

      return var10000;
   }

   // $FF: renamed from: 9 () java.util.List
   @NotNull
   public List method_1244() {
      return this.field_840;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_1245() {
      return this.field_835;
   }

   // $FF: renamed from: b () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1246() {
      return this.field_829;
   }

   // $FF: renamed from: d () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_1247() {
      return this.field_828;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      if (class_2.field_982.method_1424() != null && Intrinsics.areEqual((Object)class_2.field_982.method_1424(), (Object)((fdh)this))) {
         class_2.field_982.method_1423(false);
      }
   }

   public fdh() {
      super("nuker", "Nuker", "Destroys blocks around you");
      this.field_828 = new f0o("mode", "Mode", (String)null, (Enum)fdb.field_1303);
      this.field_829 = new DoubleSetting("range", "Range", (String)null, 6.0D, 1.0D, 6.0D, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_830 = new BooleanSetting("clickSelect", "Click Select", (String)null, false);
      this.field_831 = new BooleanSetting("flat", "Flatten", (String)null, false);
      this.field_832 = new BooleanSetting("rotate", "Rotate", (String)null, true);
      this.field_833 = new BooleanSetting("raytrace", "Raytrace", (String)null, true);
      this.field_834 = new f0l("renderColor", "RenderColor", (String)null, new f00(1.0F, 1.0F, 0.5F, 0.3F));
      this.field_835 = new f0l("renderOutline", "RenderOutline", (String)null, new f00(1.0F, 1.0F, 0.5F, 1.0F));
      this.field_836 = new fe8();
      this.field_838 = (List)(new CopyOnWriteArrayList());
      this.field_840 = (List)(new ArrayList());
      this.register((f0w)this.field_828);
      this.register((f0w)this.field_829);
      this.register((f0w)this.field_830);
      this.register((f0w)this.field_831);
      this.register((f0w)this.field_832);
      this.register((f0w)this.field_833);
      this.register((f0w)this.field_834);
      this.register((f0w)this.field_835);
      this.field_840.add(Blocks.AIR);
      this.field_840.add(Blocks.WATER);
      this.field_840.add(Blocks.FIRE);
      this.field_840.add(Blocks.FLOWING_WATER);
      this.field_840.add(Blocks.LAVA);
      this.field_840.add(Blocks.FLOWING_LAVA);
      this.field_840.add(Blocks.PORTAL);
      this.field_840.add(Blocks.END_PORTAL);
      this.field_840.add(Blocks.END_PORTAL_FRAME);
      this.field_840.add(Blocks.BEDROCK);
      this.method_1239();
   }

   // $FF: renamed from: 7 () void
   public void method_1248() {
      try {
         FileWriter var1 = new FileWriter("pyro/nuker_blocks.json");
         Gson var10000 = Pyro.GSON;
         fdd var10001 = this.field_841;
         if (var10001 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
         }

         var10000.toJson(var10001, (Appendable)var1);
         var1.close();
      } catch (IOException var2) {
         var2.printStackTrace();
      }

   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
      this.field_838.forEach((Consumer)(new fdg(this)));
      if (this.field_837 != null) {
         fe5.field_1245.method_1915(7);
         fe5 var10000 = fe5.field_1245;
         BlockPos var10001 = this.field_837;
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         var10000.method_1917(var10001, ((f00)this.field_834.c()).meth1(), 63);
         fe5.field_1245.method_1912();
         BlockPos var3 = this.field_837;
         if (var3 == null) {
            Intrinsics.throwNpe();
         }

         PyroRenderUtil.method_1433(var3, ((f00)this.field_835.c()).meth1(), 1.5F, false);
      }

   }
}
