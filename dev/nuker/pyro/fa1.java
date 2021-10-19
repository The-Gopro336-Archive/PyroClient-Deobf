/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fa1 extends Module {
   // $FF: renamed from: c boolean
   public boolean field_810;
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_811 = (DoubleSetting)this.register((f0w)(new DoubleSetting("hmult", "Heuristic Multiplier", (String)null, 2.0D, 0.01D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: 0 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_812 = (DoubleSetting)this.register((f0w)(new DoubleSetting("floorCost", "FloorCost", "Don't go on the ground", 25.0D, 1.0D, 100.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_813 = (BooleanSetting)this.register((f0w)(new BooleanSetting("showChecked", "Show Checked", (String)null, false)));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_814 = (BooleanSetting)this.register((f0w)(new BooleanSetting("showHorizon", "Show Horizon", (String)null, false)));
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_815 = (BooleanSetting)this.register((f0w)(new BooleanSetting("showFailed", "Show Failed", (String)null, false)));
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_816 = (BooleanSetting)this.register((f0w)(new BooleanSetting("showBoxes", "Show Boxes", (String)null, false)));
   // $FF: renamed from: 3 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_817 = (BooleanSetting)this.register((f0w)(new BooleanSetting("debugClips", "DebugRenderClips", (String)null, true)));
   // $FF: renamed from: c dev.nuker.pyro.fa6
   @Nullable
   public fa6 field_818;
   // $FF: renamed from: c net.minecraft.util.math.Vec3d
   @Nullable
   public Vec3d field_819;
   // $FF: renamed from: c java.util.LinkedList
   @Nullable
   public LinkedList field_820;
   // $FF: renamed from: c java.lang.Thread
   @Nullable
   public Thread field_821;
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   @NotNull
   public BlockPos field_822 = new BlockPos(0, 0, 0);
   // $FF: renamed from: c float
   public float field_823;
   // $FF: renamed from: 0 float
   public float field_824;
   // $FF: renamed from: c long
   public long field_825;

   // $FF: renamed from: c (double, double, double) void
   public void method_1191(double var1, double var3, double var5) {
      Pyro.INSTANCE.sendMessage("Detected a rubberband, pausing");
      this.field_825 = System.currentTimeMillis() + 2000L;
      this.method_1215(new BlockPos(var1, var3, var5));
   }

   // $FF: renamed from: a () boolean
   public boolean method_1192() {
      return this.field_810;
   }

   // $FF: renamed from: 4 () long
   public long method_1193() {
      return this.field_825;
   }

   // $FF: renamed from: 5 () dev.nuker.pyro.fa6
   @Nullable
   public fa6 method_1194() {
      return this.field_818;
   }

   // $FF: renamed from: 7 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1195() {
      return this.field_813;
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1196() {
      return this.field_812;
   }

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1197() {
      return this.field_815;
   }

   // $FF: renamed from: c (boolean) void
   public void method_1198(boolean var1) {
      this.field_810 = var1;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, net.minecraft.util.math.BlockPos, int) void
   public void method_1199(@NotNull BlockPos var1, @NotNull BlockPos var2, int var3) {
      Vec3d var4 = (new Vec3d((Vec3i)var1)).addVector(0.0D, 0.5D, 0.0D);
      Vec3d var5 = (new Vec3d((Vec3i)var2)).addVector(0.0D, 0.5D, 0.0D);
      this.method_1200(var4, var5, var3);
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, net.minecraft.util.math.Vec3d, int) void
   public void method_1200(@NotNull Vec3d var1, @NotNull Vec3d var2, int var3) {
      new Color(var3);
      fe5.field_1245.method_1904(fe5.field_1245.getBuffer(), var1.x, var1.y, var1.z, var2.x, var2.y, var2.z, var3, var3);
   }

   // $FF: renamed from: 0 () net.minecraft.util.math.Vec3d
   @Nullable
   public Vec3d method_1201() {
      return this.field_819;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4C) void
   @f0g
   @LauncherEventHide
   public void method_1202(@NotNull f4C var1) {
      if (this.c.player != null && this.c.world != null && this.field_818 != null) {
         GlStateManager.enableAlpha();
         fe5.field_1245.method_1915(7);
         if (!(Boolean)this.field_817.c()) {
            GlStateManager.enableDepth();
         }

         Iterable var2;
         boolean var3;
         Iterator var4;
         Object var5;
         BlockPos var6;
         boolean var7;
         fa6 var10000;
         if ((Boolean)this.field_813.c()) {
            var10000 = this.field_818;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            var2 = (Iterable)var10000.method_2620();
            var3 = false;
            var4 = var2.iterator();

            while(var4.hasNext()) {
               var5 = var4.next();
               var6 = (BlockPos)var5;
               var7 = false;
               fe5.field_1245.method_1901((float)var6.getX() - 0.3F, (float)var6.getY() + 0.2F, (float)var6.getZ() - 0.3F, 0.6F, 0.6F, 0.6F, 503382015, 63);
            }
         }

         if ((Boolean)this.field_814.c()) {
            var10000 = this.field_818;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            var2 = (Iterable)var10000.method_2644();
            var3 = false;
            var4 = var2.iterator();

            while(var4.hasNext()) {
               var5 = var4.next();
               var6 = (BlockPos)var5;
               var7 = false;
               fe5.field_1245.method_1901((float)var6.getX() - 0.3F, (float)var6.getY() + 0.2F, (float)var6.getZ() - 0.3F, 0.6F, 0.6F, 0.6F, 503381760, 63);
            }
         }

         if ((Boolean)this.field_815.c()) {
            var10000 = this.field_818;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            var2 = (Iterable)var10000.method_2616();
            var3 = false;
            var4 = var2.iterator();

            while(var4.hasNext()) {
               var5 = var4.next();
               var6 = (BlockPos)var5;
               var7 = false;
               fe5.field_1245.method_1901((float)var6.getX() - 0.3F, (float)var6.getY() + 0.2F, (float)var6.getZ() - 0.3F, 0.6F, 0.6F, 0.6F, 520028160, 63);
            }
         }

         fe5.field_1245.method_1912();
         fe5.field_1245.method_1915(1);
         GlStateManager.glLineWidth(1.5F);
         var10000 = this.field_818;
         fa3 var8;
         fa3 var9;
         fe5 var10;
         AxisAlignedBB var11;
         fa3 var10003;
         if ((var10000 != null ? var10000.method_2638() : null) != null) {
            var10000 = this.field_818;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            LinkedList var12 = var10000.method_2638();
            if (var12 == null) {
               Intrinsics.throwNpe();
            }

            var2 = (Iterable)var12;
            var3 = false;
            var4 = var2.iterator();

            while(var4.hasNext()) {
               var5 = var4.next();
               var8 = (fa3)var5;
               var7 = false;
               if (var8.method_2606() != null) {
                  var9 = var8.method_2606();
                  if (var9 == null) {
                     Intrinsics.throwNpe();
                  }

                  this.method_1199(var9.method_2609(), var8.method_2609(), Color.GREEN.getRGB());
                  if ((Boolean)this.field_816.c()) {
                     var10 = fe5.field_1245;
                     var11 = new AxisAlignedBB;
                     var10003 = var8.method_2606();
                     if (var10003 == null) {
                        Intrinsics.throwNpe();
                     }

                     var11.<init>(var10003.method_2609(), var8.method_2609());
                     var10.method_1918(var11.expand(0.75D, 1.0D, 0.75D).expand(-0.75D, 0.0D, -0.75D), Color.RED.getRGB(), 63);
                  }
               }
            }
         } else {
            var10000 = this.field_818;
            if ((var10000 != null ? var10000.method_2625() : null) != null) {
               var10000 = this.field_818;
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               fa6 var10001 = this.field_818;
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               var9 = var10001.method_2625();
               if (var9 == null) {
                  Intrinsics.throwNpe();
               }

               var2 = (Iterable)var10000.method_2635(var9);
               var3 = false;
               var4 = var2.iterator();

               while(var4.hasNext()) {
                  var5 = var4.next();
                  var8 = (fa3)var5;
                  var7 = false;
                  if (var8.method_2606() != null) {
                     var9 = var8.method_2606();
                     if (var9 == null) {
                        Intrinsics.throwNpe();
                     }

                     this.method_1199(var9.method_2609(), var8.method_2609(), Color.MAGENTA.getRGB());
                     if ((Boolean)this.field_816.c()) {
                        var10 = fe5.field_1245;
                        var11 = new AxisAlignedBB;
                        var10003 = var8.method_2606();
                        if (var10003 == null) {
                           Intrinsics.throwNpe();
                        }

                        var11.<init>(var10003.method_2609(), var8.method_2609());
                        var10.method_1918(var11.expand(0.75D, 1.0D, 0.75D).expand(-0.75D, 0.0D, -0.75D), Color.RED.getRGB(), 63);
                     }
                  }
               }
            }
         }

         if (this.field_819 != null) {
            Vec3d var13 = this.c.player.getPositionVector();
            Vec3d var10002 = this.field_819;
            if (var10002 == null) {
               Intrinsics.throwNpe();
            }

            this.method_1200(var13, var10002, Color.BLUE.getRGB());
         }

         fe5.field_1245.method_1912();
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f43) void
   @f0g
   @LauncherEventHide
   public void method_1203(@NotNull f43 var1) {
      if (this.c.player != null && this.field_818 != null) {
         fa6 var10000 = this.field_818;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         if (var10000.method_2638() != null) {
            Collection var2 = (Collection)this.field_820;
            boolean var3 = false;
            boolean var4 = false;
            if (var2 != null && !var2.isEmpty()) {
               if (this.field_819 != null) {
                  if (this.c.player.getRidingEntity() == null) {
                     return;
                  }

                  Entity var5 = this.c.player.getRidingEntity();
                  if (var5 == null) {
                     Intrinsics.throwNpe();
                  }

                  if (!(var5.getPositionVector().distanceTo(this.field_819) < 0.5D)) {
                     return;
                  }
               }

               Vec3d var10001 = new Vec3d;
               LinkedList var10003 = this.field_820;
               if (var10003 == null) {
                  Intrinsics.throwNpe();
               }

               var10001.<init>((Vec3i)var10003.removeFirst());
               this.field_819 = var10001.addVector(0.0D, 0.1D, 0.0D);
            } else {
               method_1217(this, (BlockPos)null, 1, (Object)null);
            }

            return;
         }
      }

   }

   // $FF: renamed from: c (java.lang.Thread) void
   public void method_1204(@Nullable Thread var1) {
      this.field_821 = var1;
   }

   // $FF: renamed from: b () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1205() {
      return this.field_814;
   }

   // $FF: renamed from: c (long) void
   public void method_1206(long var1) {
      this.field_825 = var1;
   }

   // $FF: renamed from: 8 () java.lang.Thread
   @Nullable
   public Thread method_1207() {
      return this.field_821;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1208() {
      return this.field_811;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fa6) void
   public void method_1209(@Nullable fa6 var1) {
      this.field_818 = var1;
   }

   // $FF: renamed from: c (java.util.LinkedList) void
   public void method_1210(@Nullable LinkedList var1) {
      this.field_820 = var1;
   }

   // $FF: renamed from: d () java.util.LinkedList
   @Nullable
   public LinkedList method_1211() {
      return this.field_820;
   }

   // $FF: renamed from: 2 () net.minecraft.util.math.BlockPos
   @NotNull
   public BlockPos method_1212() {
      return this.field_822;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1213() {
      return this.field_817;
   }

   public fa1() {
      super("auto_pilot", "AutoPilot", (String)null);
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      if (!var1) {
         this.field_810 = false;
         this.field_818 = (fa6)null;
         this.field_820 = (LinkedList)null;
         this.field_819 = (Vec3d)null;
         if (this.field_821 != null) {
            Thread var10000 = this.field_821;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            var10000.stop();
         }
      } else if (var2 != null) {
         if (this.c.player.getRidingEntity() instanceof EntityBoat) {
            method_1217(this, (BlockPos)null, 1, (Object)null);
            Pyro.INSTANCE.sendMessage("To set destination type " + Config.INSTANCE.chatPrefix + "path x y z");
         } else {
            this.c.method_3033(false);
            Pyro.INSTANCE.sendMessage(ChatFormatting.RED + "AutoPilot only works in boats");
         }
      }

   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d) void
   public void method_1214(@Nullable Vec3d var1) {
      this.field_819 = var1;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) void
   public void method_1215(@NotNull BlockPos var1) {
      this.field_819 = (Vec3d)null;
      fa6 var10000 = this.field_818;
      if (var10000 != null) {
         var10000.method_2615((LinkedList)null);
      }

      if (this.field_821 != null) {
         Thread var2 = this.field_821;
         if (var2 == null) {
            Intrinsics.throwNpe();
         }

         var2.stop();
      }

      if (this.c.player.getRidingEntity() != null) {
         fa6 var10001 = new fa6;
         BlockPos var10004 = this.field_822;
         double var10005 = ((Number)this.field_811.c()).doubleValue();
         double var10006 = ((Number)this.field_812.c()).doubleValue();
         WorldClient var10007 = this.c.world;
         if (var10007 == null) {
            Intrinsics.throwNpe();
         }

         var10001.<init>(var1, var10004, var10005, var10006, (World)var10007, (long)0.0D);
         this.field_818 = var10001;
         this.field_821 = ThreadsKt.thread$default(true, false, (ClassLoader)null, (String)null, 0, (Function0)(new fa0(this)), 30, (Object)null);
      }

   }

   // $FF: renamed from: c (double) double[]
   @Nullable
   public double[] method_1216(double var1) {
      if (this.field_825 != 0L) {
         if (this.field_825 < System.currentTimeMillis()) {
            this.field_825 = 0L;
         }

         return null;
      } else if (this.field_819 != null) {
         Entity var3 = this.c.player.getRidingEntity();
         fdU var10000 = fdU.field_1248.method_1957();
         Vec3d var10001 = this.field_819;
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         float var4 = var10000.method_1929(var10001).x;
         Vec3d var13 = new Vec3d;
         Entity var10002 = this.c.player.getRidingEntity();
         if (var10002 == null) {
            Intrinsics.throwNpe();
         }

         double var15 = var10002.posX;
         Vec3d var10003 = this.field_819;
         if (var10003 == null) {
            Intrinsics.throwNpe();
         }

         double var16 = var10003.y;
         Entity var10004 = this.c.player.getRidingEntity();
         if (var10004 == null) {
            Intrinsics.throwNpe();
         }

         var13.<init>(var15, var16, var10004.posZ);
         double var5 = var13.distanceTo(this.field_819);
         boolean var7 = false;
         if (Math.abs(var5) < 0.1D) {
            var5 = 0.0D;
         }

         boolean var9 = false;
         double var11 = Math.min(var1, var5);
         var13 = this.field_819;
         if (var13 == null) {
            Intrinsics.throwNpe();
         }

         double var14 = var13.y;
         if (var3 == null) {
            Intrinsics.throwNpe();
         }

         double var12 = var14 - var3.posY;
         return new double[]{var11 * Math.cos(Math.toRadians((double)var4 + (double)90.0F)), var11 * Math.sin(Math.toRadians((double)var4 + (double)90.0F)), var12 > 0.1D ? var12 : (var12 < -0.1D ? var12 : 0.0D)};
      } else {
         return null;
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.fa1, net.minecraft.util.math.BlockPos, int, java.lang.Object) void
   public static void method_1217(fa1 var0, BlockPos var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         Entity var10000 = var0.c.player.getRidingEntity();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         double var19 = var10000.posX;
         Entity var10001 = var0.c.player.getRidingEntity();
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         double var4 = var10001.posY;
         double var9 = var19;
         boolean var6 = false;
         double var11 = Math.floor(var4);
         Entity var10002 = var0.c.player.getRidingEntity();
         if (var10002 == null) {
            Intrinsics.throwNpe();
         }

         double var13 = var10002.posZ;
         var1 = new BlockPos(var9, var11, var13);
      }

      var0.method_1215(var1);
   }

   // $FF: renamed from: 9 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1218() {
      return this.field_816;
   }

   // $FF: renamed from: 0 (net.minecraft.util.math.BlockPos) void
   public void method_1219(@NotNull BlockPos var1) {
      this.field_822 = var1;
   }
}
