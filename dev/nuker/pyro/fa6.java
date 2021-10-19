/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fa6 {
   // $FF: renamed from: c java.util.LinkedList
   @Nullable
   public LinkedList field_1448;
   // $FF: renamed from: c double[]
   @NotNull
   public double[] field_1449;
   // $FF: renamed from: c dev.nuker.pyro.fa3[]
   @NotNull
   public fa3[] field_1450;
   // $FF: renamed from: c java.lang.Double[]
   @NotNull
   public Double[] field_1451;
   // $FF: renamed from: c java.util.concurrent.CopyOnWriteArrayList
   @NotNull
   public CopyOnWriteArrayList field_1452;
   // $FF: renamed from: 0 java.util.concurrent.CopyOnWriteArrayList
   @NotNull
   public CopyOnWriteArrayList field_1453;
   // $FF: renamed from: 1 java.util.concurrent.CopyOnWriteArrayList
   @NotNull
   public CopyOnWriteArrayList field_1454;
   // $FF: renamed from: c boolean
   public boolean field_1455;
   // $FF: renamed from: c dev.nuker.pyro.fa3
   @Nullable
   public fa3 field_1456;
   // $FF: renamed from: c net.minecraft.util.math.BlockPos[]
   @NotNull
   public BlockPos[] field_1457;
   // $FF: renamed from: 0 net.minecraft.util.math.BlockPos[]
   @NotNull
   public BlockPos[] field_1458;
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   @NotNull
   public BlockPos field_1459;
   // $FF: renamed from: 0 net.minecraft.util.math.BlockPos
   @NotNull
   public BlockPos field_1460;
   // $FF: renamed from: c double
   public double field_1461;
   // $FF: renamed from: 0 double
   public double field_1462;
   // $FF: renamed from: c net.minecraft.world.World
   @NotNull
   public World field_1463;
   // $FF: renamed from: c long
   public long field_1464;

   // $FF: renamed from: 2 () dev.nuker.pyro.fa3
   @Nullable
   public fa3 method_2614() {
      double var1 = 0.0D;
      fa3 var3 = (fa3)null;
      int var4 = 0;

      for(int var5 = this.field_1449.length; var4 < var5; ++var4) {
         if (this.field_1450[var4] != null) {
            BlockPos var10000 = this.field_1459;
            fa3 var10001 = this.field_1450[var4];
            if (var10001 == null) {
               Intrinsics.throwNpe();
            }

            double var6 = var10000.distanceSq((Vec3i)var10001.method_2609());
            if (var6 > var1 && var6 > 25.0D) {
               var1 = var6;
               var3 = this.field_1450[var4];
            }
         }
      }

      return var3;
   }

   // $FF: renamed from: c (java.util.LinkedList) void
   public void method_2615(@Nullable LinkedList var1) {
      this.field_1448 = var1;
   }

   // $FF: renamed from: 7 () java.util.concurrent.CopyOnWriteArrayList
   @NotNull
   public CopyOnWriteArrayList method_2616() {
      return this.field_1454;
   }

   // $FF: renamed from: c (java.lang.Double[]) void
   public void method_2617(@NotNull Double[] var1) {
      this.field_1451 = var1;
   }

   // $FF: renamed from: 0 (java.util.concurrent.CopyOnWriteArrayList) void
   public void method_2618(@NotNull CopyOnWriteArrayList var1) {
      this.field_1453 = var1;
   }

   // $FF: renamed from: 2 (net.minecraft.util.math.BlockPos, net.minecraft.util.math.BlockPos) boolean
   public boolean method_2619(BlockPos var1, BlockPos var2) {
      int var3 = var1.getX();
      int var4 = var2.getX();
      boolean var5 = false;
      int var9 = Math.min(var3, var4);
      int var10001 = var9 - 1;
      var3 = var1.getY();
      var4 = var2.getY();
      var9 = var10001;
      var5 = false;
      int var10 = Math.min(var3, var4);
      int var10002 = var10 - 1;
      var3 = var1.getZ();
      var4 = var2.getZ();
      var10 = var10002;
      var5 = false;
      int var11 = Math.min(var3, var4);
      int var13 = var11 - 1;
      BlockPos var19 = new BlockPos(var9, var10, var13);
      var3 = var1.getX();
      var4 = var2.getX();
      BlockPos var7 = var19;
      var5 = false;
      var10 = Math.max(var3, var4);
      var3 = var1.getY();
      var4 = var2.getY();
      var5 = false;
      var11 = Math.max(var3, var4);
      var3 = var1.getZ();
      var4 = var2.getZ();
      var5 = false;
      int var12 = Math.max(var3, var4);
      return this.method_2623(var7, new BlockPos(var10, var11, var12));
   }

   // $FF: renamed from: a () java.util.concurrent.CopyOnWriteArrayList
   @NotNull
   public CopyOnWriteArrayList method_2620() {
      return this.field_1452;
   }

   // $FF: renamed from: i () double
   public double method_2621() {
      return this.field_1461;
   }

   // $FF: renamed from: 1 (java.util.concurrent.CopyOnWriteArrayList) void
   public void method_2622(@NotNull CopyOnWriteArrayList var1) {
      this.field_1454 = var1;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, net.minecraft.util.math.BlockPos) boolean
   public boolean method_2623(BlockPos var1, BlockPos var2) {
      int var5 = var1.getX();
      int var6 = var2.getX();
      boolean var7 = false;
      int var3 = Math.min(var5, var6);
      var5 = var1.getX();
      var6 = var2.getX();
      var7 = false;
      int var4 = Math.max(var5, var6);
      if (var3 <= var4) {
         while(true) {
            int var12 = var1.getY();
            int var8 = var2.getY();
            boolean var9 = false;
            var5 = Math.min(var12, var8);
            var12 = var1.getY();
            var8 = var2.getY();
            var9 = false;
            var6 = Math.max(var12, var8);
            if (var5 <= var6) {
               while(true) {
                  int var13 = var1.getZ();
                  int var10 = var2.getZ();
                  boolean var11 = false;
                  var12 = Math.min(var13, var10);
                  var13 = var1.getZ();
                  var10 = var2.getZ();
                  var11 = false;
                  var8 = Math.max(var13, var10);
                  if (var12 <= var8) {
                     while(true) {
                        IBlockState var14 = this.field_1463.getBlockState(new BlockPos(var3, var5, var12));
                        if (!this.method_2630(var14)) {
                           return false;
                        }

                        if (var12 == var8) {
                           break;
                        }

                        ++var12;
                     }
                  }

                  if (var5 == var6) {
                     break;
                  }

                  ++var5;
               }
            }

            if (var3 == var4) {
               break;
            }

            ++var3;
         }
      }

      return true;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.fa3) void
   public void method_2624(@Nullable fa3 var1) {
      this.field_1456 = var1;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.fa3
   @Nullable
   public fa3 method_2625() {
      return this.field_1456;
   }

   // $FF: renamed from: g () net.minecraft.util.math.BlockPos
   @NotNull
   public BlockPos method_2626() {
      return this.field_1460;
   }

   // $FF: renamed from: 4 () double
   public double method_2627() {
      return this.field_1462;
   }

   // $FF: renamed from: 1 (net.minecraft.util.math.BlockPos, net.minecraft.util.math.BlockPos) boolean
   public boolean method_2628(BlockPos var1, BlockPos var2) {
      int var3 = var1.getX();
      int var4 = var2.getX();
      boolean var5 = false;
      int var9 = Math.min(var3, var4);
      int var10001 = var9 - 1;
      var3 = var1.getY();
      var4 = var2.getY();
      var9 = var10001;
      var5 = false;
      int var10 = Math.min(var3, var4);
      int var10002 = var10 - 1;
      var3 = var1.getZ();
      var4 = var2.getZ();
      var10 = var10002;
      var5 = false;
      int var11 = Math.min(var3, var4);
      int var13 = var11 - 1;
      BlockPos var19 = new BlockPos(var9, var10, var13);
      var3 = var1.getX();
      var4 = var2.getX();
      BlockPos var7 = var19;
      var5 = false;
      var10 = Math.max(var3, var4);
      var3 = var1.getY();
      var4 = var2.getY();
      var5 = false;
      var11 = Math.max(var3, var4);
      int var10003 = var11 + 1;
      var3 = var1.getZ();
      var4 = var2.getZ();
      var11 = var10003;
      var5 = false;
      int var12 = Math.max(var3, var4);
      return this.method_2648(var7, new BlockPos(var10, var11, var12));
   }

   // $FF: renamed from: 0 () net.minecraft.world.World
   @NotNull
   public World method_2629() {
      return this.field_1463;
   }

   // $FF: renamed from: c (net.minecraft.block.state.IBlockState) boolean
   public boolean method_2630(IBlockState var1) {
      return var1.getMaterial().isLiquid() ? false : Intrinsics.areEqual((Object)var1.getMaterial(), (Object)Material.AIR) || Intrinsics.areEqual((Object)var1.getMaterial(), (Object)Material.PLANTS);
   }

   // $FF: renamed from: c (boolean) void
   public void method_2631(boolean var1) {
      this.field_1455 = var1;
   }

   // $FF: renamed from: 3 () java.lang.Double[]
   @NotNull
   public Double[] method_2632() {
      return this.field_1451;
   }

   // $FF: renamed from: c () double[]
   @NotNull
   public double[] method_2633() {
      return this.field_1449;
   }

   // $FF: renamed from: e () boolean
   public boolean method_2634() {
      return this.field_1455;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fa3) java.util.LinkedList
   @NotNull
   public LinkedList method_2635(@NotNull fa3 var1) {
      LinkedList var2 = new LinkedList();
      fa3 var3 = var1;

      do {
         var2.add(var3);
         var3 = var3.method_2606();
      } while(var3 != null);

      CollectionsKt.reverse((List)var2);
      return var2;
   }

   // $FF: renamed from: d () long
   public long method_2636() {
      return this.field_1464;
   }

   // $FF: renamed from: f () dev.nuker.pyro.fa4
   @NotNull
   public fa4 method_2637() {
      fdJ var1 = new fdJ((Function)fa5.field_1447, false, 2, (DefaultConstructorMarker)null);
      fa3 var2 = new fa3(this, (fa3)null, this.field_1459, 0.0D);
      this.field_1456 = var2;

      fa3 var10001;
      fa3 var10002;
      for(int var3 = 0; this.field_1456 != null; ++var3) {
         fa3 var10000 = this.field_1456;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         if (var10000.method_2607(this.field_1460)) {
            break;
         }

         fa2[] var6 = fa2.values();
         int var7 = var6.length;

         for(int var5 = 0; var5 < var7; ++var5) {
            fa2 var4 = var6[var5];
            var10000 = this.field_1456;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            BlockPos var8 = var10000.method_2609().add((Vec3i)var4.method_2602());
            var10001 = this.field_1456;
            if (var10001 == null) {
               Intrinsics.throwNpe();
            }

            if (this.method_2628(var10001.method_2609(), var8)) {
               var10000 = this.field_1456;
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               double var20;
               double var21;
               label390: {
                  var20 = var10000.method_2608();
                  if (this.field_1462 != 1.0D) {
                     var10002 = this.field_1456;
                     if (var10002 == null) {
                        Intrinsics.throwNpe();
                     }

                     if (!this.method_2619(var10002.method_2609(), var8)) {
                        var21 = var4.method_2603() - 1.0D + this.field_1462;
                        break label390;
                     }
                  }

                  var21 = var4.method_2603();
               }

               double var9 = var20 + var21;
               fa3 var11 = new fa3(this, this.field_1456, var8, var9);
               Iterable var13 = (Iterable)var1;
               boolean var14 = false;
               Iterator var15 = var13.iterator();

               Object var22;
               while(true) {
                  if (var15.hasNext()) {
                     Object var16 = var15.next();
                     fa3 var17 = (fa3)var16;
                     boolean var18 = false;
                     if (!Intrinsics.areEqual((Object)var17.method_2609(), (Object)var8)) {
                        continue;
                     }

                     var22 = var16;
                     break;
                  }

                  var22 = null;
                  break;
               }

               fa3 var12 = (fa3)var22;
               if (var12 == null && !this.field_1452.contains(var8) && !this.field_1454.contains(var8)) {
                  var1.add(var11);
                  this.field_1453.add(var8);
               }
            } else if (!this.field_1454.contains(var8)) {
               this.field_1454.add(var8);
               this.field_1453.add(var8);
            }
         }

         fa3 var19 = (fa3)var1.poll();
         if (var19 != null) {
            if (!this.field_1463.isBlockLoaded(var19.method_2609(), false)) {
               var10001 = this.field_1456;
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               this.method_2646(var10001);
               var10002 = this.field_1456;
               if (var10002 == null) {
                  Intrinsics.throwNpe();
               }

               this.field_1448 = this.method_2635(var10002);
               return fa4.field_1445;
            }

            this.field_1456 = var19;
            this.field_1452.add(var19.method_2609());
            this.field_1453.remove(var19.method_2609());
         }
      }

      var10001 = this.field_1456;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      this.method_2646(var10001);
      var10002 = this.field_1456;
      if (var10002 == null) {
         Intrinsics.throwNpe();
      }

      this.field_1448 = this.method_2635(var10002);
      return fa4.field_1443;
   }

   // $FF: renamed from: 5 () java.util.LinkedList
   @Nullable
   public LinkedList method_2638() {
      return this.field_1448;
   }

   // $FF: renamed from: 0 (net.minecraft.util.math.BlockPos) void
   public void method_2639(@NotNull BlockPos var1) {
      this.field_1460 = var1;
   }

   // $FF: renamed from: b () dev.nuker.pyro.fa3[]
   @NotNull
   public fa3[] method_2640() {
      return this.field_1450;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fa3[]) void
   public void method_2641(@NotNull fa3[] var1) {
      this.field_1450 = var1;
   }

   // $FF: renamed from: 6 () net.minecraft.util.math.BlockPos[]
   @NotNull
   public BlockPos[] method_2642() {
      return this.field_1457;
   }

   // $FF: renamed from: 9 () net.minecraft.util.math.BlockPos
   @NotNull
   public BlockPos method_2643() {
      return this.field_1459;
   }

   // $FF: renamed from: 8 () java.util.concurrent.CopyOnWriteArrayList
   @NotNull
   public CopyOnWriteArrayList method_2644() {
      return this.field_1453;
   }

   // $FF: renamed from: c (java.util.concurrent.CopyOnWriteArrayList) void
   public void method_2645(@NotNull CopyOnWriteArrayList var1) {
      this.field_1452 = var1;
   }

   // $FF: renamed from: 1 (dev.nuker.pyro.fa3) void
   public void method_2646(@NotNull fa3 var1) {
      fa3 var2 = var1;

      while(true) {
         while(true) {
            fa3 var10000 = var2.method_2606();
            if ((var10000 != null ? var10000.method_2606() : null) == null) {
               return;
            }

            BlockPos var3 = var2.method_2609();
            var10000 = var2.method_2606();
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            var10000 = var10000.method_2606();
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            BlockPos var4;
            label289: {
               var4 = var10000.method_2609();
               var10000 = var2.method_2606();
               if (var10000 != null) {
                  var10000 = var10000.method_2606();
                  if (var10000 != null) {
                     var10000 = var10000.method_2606();
                     break label289;
                  }
               }

               var10000 = null;
            }

            BlockPos var5;
            int var8;
            fa3 var10001;
            if (var10000 != null) {
               var10000 = var2.method_2606();
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               var10000 = var10000.method_2606();
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               var10000 = var10000.method_2606();
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               var5 = var10000.method_2609();
               boolean var6 = false;
               BlockPos[] var9 = this.field_1457;
               int var10 = var9.length;

               for(var8 = 0; var8 < var10; ++var8) {
                  BlockPos var7 = var9[var8];
                  if (Intrinsics.areEqual((Object)var3, (Object)var5.add((Vec3i)var7))) {
                     if (this.method_2628(var5, var3)) {
                        var10001 = var2.method_2606();
                        if (var10001 == null) {
                           Intrinsics.throwNpe();
                        }

                        var10001 = var10001.method_2606();
                        if (var10001 == null) {
                           Intrinsics.throwNpe();
                        }

                        var2.method_2611(var10001.method_2606());
                        var6 = true;
                     }
                     break;
                  }
               }

               if (var6) {
                  var10000 = var2.method_2606();
                  if (var10000 == null) {
                     Intrinsics.throwNpe();
                  }

                  var2 = var10000;
                  continue;
               }
            }

            BlockPos[] var12 = this.field_1458;
            var8 = var12.length;

            for(int var11 = 0; var11 < var8; ++var11) {
               var5 = var12[var11];
               if (Intrinsics.areEqual((Object)var3, (Object)var4.add((Vec3i)var5))) {
                  if (this.method_2628(var4, var3)) {
                     var10001 = var2.method_2606();
                     if (var10001 == null) {
                        Intrinsics.throwNpe();
                     }

                     var2.method_2611(var10001.method_2606());
                  }
                  break;
               }
            }

            var10000 = var2.method_2606();
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            var2 = var10000;
         }
      }
   }

   // $FF: renamed from: h () net.minecraft.util.math.BlockPos[]
   @NotNull
   public BlockPos[] method_2647() {
      return this.field_1458;
   }

   // $FF: renamed from: 0 (net.minecraft.util.math.BlockPos, net.minecraft.util.math.BlockPos) boolean
   public boolean method_2648(BlockPos var1, BlockPos var2) {
      int var5 = var1.getX();
      int var6 = var2.getX();
      boolean var7 = false;
      int var3 = Math.min(var5, var6);
      var5 = var1.getX();
      var6 = var2.getX();
      var7 = false;
      int var4 = Math.max(var5, var6);
      if (var3 <= var4) {
         while(true) {
            int var16 = var1.getY();
            int var8 = var2.getY();
            boolean var9 = false;
            var5 = Math.min(var16, var8);
            var16 = var1.getY();
            var8 = var2.getY();
            var9 = false;
            var6 = Math.max(var16, var8);
            if (var5 <= var6) {
               while(true) {
                  var7 = true;
                  int var10 = var1.getZ();
                  int var11 = var2.getZ();
                  boolean var12 = false;
                  var8 = Math.min(var10, var11);
                  var10 = var1.getZ();
                  var11 = var2.getZ();
                  var12 = false;
                  int var17 = Math.max(var10, var11);
                  int var15;
                  if (var8 <= var17) {
                     while(true) {
                        IBlockState var18 = this.field_1463.getBlockState(new BlockPos(var3, var5, var8));
                        if (!Intrinsics.areEqual((Object)var18.getBlock(), (Object)Blocks.LAVA) && !Intrinsics.areEqual((Object)var18.getBlock(), (Object)Blocks.FLOWING_LAVA)) {
                           var7 = false;
                        }

                        var11 = var1.getY();
                        int var20 = var2.getY();
                        boolean var13 = false;
                        var15 = Math.min(var11, var20);
                        if (var5 != var15 && !this.method_2630(var18)) {
                           return false;
                        }

                        if (var8 == var17) {
                           break;
                        }

                        ++var8;
                     }
                  }

                  var8 = var1.getY();
                  var17 = var2.getY();
                  boolean var19 = false;
                  var15 = Math.min(var8, var17);
                  if (var5 == var15 && var7) {
                     return false;
                  }

                  if (var5 == var6) {
                     break;
                  }

                  ++var5;
               }
            }

            if (var3 == var4) {
               break;
            }

            ++var3;
         }
      }

      return true;
   }

   public fa6(@NotNull BlockPos var1, @NotNull BlockPos var2, double var3, double var5, @NotNull World var7, long var8) {
      this.field_1459 = var1;
      this.field_1460 = var2;
      this.field_1461 = var3;
      this.field_1462 = var5;
      this.field_1463 = var7;
      this.field_1464 = var8;
      this.field_1449 = new double[]{1.5D, 2.0D, 2.5D, 3.0D, 4.0D, 5.0D, 10.0D};
      this.field_1450 = new fa3[this.field_1449.length];
      int var10 = this.field_1449.length;
      Double[] var11 = new Double[var10];

      for(int var12 = 0; var12 < var10; ++var12) {
         boolean var14 = false;
         Double var18 = DoubleCompanionObject.INSTANCE.getMAX_VALUE();
         var11[var12] = var18;
      }

      this.field_1451 = var11;
      this.field_1452 = new CopyOnWriteArrayList();
      this.field_1453 = new CopyOnWriteArrayList();
      this.field_1454 = new CopyOnWriteArrayList();
      this.field_1457 = new BlockPos[]{new BlockPos(-1, -1, -1), new BlockPos(-1, -1, 1), new BlockPos(1, -1, -1), new BlockPos(-1, -1, -1), new BlockPos(-1, 1, -1), new BlockPos(-1, 1, 1), new BlockPos(1, 1, -1), new BlockPos(-1, 1, -1)};
      this.field_1458 = new BlockPos[]{new BlockPos(-1, -1, 0), new BlockPos(1, 1, 0), new BlockPos(-1, 1, 0), new BlockPos(1, -1, 0), new BlockPos(0, -1, -1), new BlockPos(0, 1, 1), new BlockPos(0, 1, -1), new BlockPos(0, -1, 1), new BlockPos(-1, 0, -1), new BlockPos(-1, 0, 1), new BlockPos(1, 0, -1), new BlockPos(1, 0, 1)};
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) void
   public void method_2649(@NotNull BlockPos var1) {
      this.field_1459 = var1;
   }
}
