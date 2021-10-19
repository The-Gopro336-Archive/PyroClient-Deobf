/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketBlockAction;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f8s extends Module {
   // $FF: renamed from: 1 int
   public int field_246;
   // $FF: renamed from: c boolean
   public boolean field_247;
   // $FF: renamed from: c java.util.LinkedHashMap
   @NotNull
   public LinkedHashMap field_248 = new LinkedHashMap();
   // $FF: renamed from: 2 int
   public int field_249;
   // $FF: renamed from: 0 java.util.LinkedHashMap
   @NotNull
   public LinkedHashMap field_250 = new LinkedHashMap();
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos field_251;
   // $FF: renamed from: 0 net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos field_252;
   // $FF: renamed from: 1 net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos field_253;

   // $FF: renamed from: 4 () int
   public int method_345() {
      return this.field_249;
   }

   // $FF: renamed from: 1 (net.minecraft.util.math.BlockPos) void
   public void method_346(@Nullable BlockPos var1) {
      this.field_253 = var1;
   }

   // $FF: renamed from: 2 () net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos method_347() {
      return this.field_251;
   }

   // $FF: renamed from: 6 () int
   public int method_348() {
      return this.field_246;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g
   @LauncherEventHide
   public void method_349(@NotNull f4u var1) {
      if (!var1.c() && var1.c() == f41.field_2120) {
         this.field_252 = (BlockPos)null;
         if (this.field_246 != 1 || this.method_363((BlockPos)null) != null) {
            int var2 = this.field_246;
            if (var2 != 0) {
               this.field_252 = this.method_363(this.field_253);
               this.field_253 = this.field_252;
            } else {
               while(this.field_249 < 250 && this.field_252 == null) {
                  LinkedHashMap var10001 = this.field_250;
                  fe0[] var10002 = fe0.values();
                  double var3 = (double)(this.field_249 / 25);
                  fe0[] var8 = var10002;
                  LinkedHashMap var7 = var10001;
                  boolean var5 = false;
                  double var9 = Math.floor(var3);
                  Object var12 = var7.get(var8[(int)var9]);
                  this.field_252 = (BlockPos[])var12 != null ? ((BlockPos[])var12)[this.field_249 % 25] : null;
                  int var13 = this.field_249++;
               }
            }

            if (this.field_252 == null) {
               return;
            }

            Ref.ObjectRef var11 = new Ref.ObjectRef();
            var11.element = few.method_1732(this.field_252, true);
            float[] var4 = few.method_1716().method_1736(this.field_252, (EnumFacing)var11.element);
            var1.0();
            var1.method_3139(var4[0]);
            var1.method_3140(var4[1]);
            var1.method_3133((Consumer)(new f8r(this, var11)));
            return;
         }

         if (this.field_247) {
            Pyro.INSTANCE.sendMessage("Finished tuning.");
            this.c.method_3033(false);
            return;
         }

         this.field_247 = true;
         this.field_246 = 0;
         this.field_249 = 0;
      }

   }

   // $FF: renamed from: c () java.util.LinkedHashMap
   @NotNull
   public LinkedHashMap method_350() {
      return this.field_250;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      if (!var1 || this.c.world != null && this.c.player != null) {
         this.field_247 = true;
         this.field_250 = fe1.method_1851();
         Iterable var4 = (Iterable)this.field_250.values();
         boolean var5 = false;
         Iterator var6 = var4.iterator();

         while(var6.hasNext()) {
            Object var7 = var6.next();
            BlockPos[] var8 = (BlockPos[])var7;
            boolean var9 = false;
            boolean var11 = false;
            BlockPos[] var12 = var8;
            int var13 = var8.length;

            for(int var14 = 0; var14 < var13; ++var14) {
               BlockPos var15 = var12[var14];
               boolean var17 = false;
               this.method_365(var15);
            }
         }

         this.field_246 = 0;
         this.field_249 = 0;
      } else {
         this.c.method_3033(false);
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f8s) net.minecraft.client.Minecraft
   public static Minecraft method_351(f8s var0) {
      return var0.c;
   }

   // $FF: renamed from: c (java.util.LinkedHashMap) void
   public void method_352(@NotNull LinkedHashMap var1) {
      this.field_248 = var1;
   }

   // $FF: renamed from: 4 (int) void
   public void method_353(int var1) {
      this.field_249 = var1;
   }

   // $FF: renamed from: 1 () net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos method_354() {
      return this.field_253;
   }

   // $FF: renamed from: 0 (net.minecraft.util.math.BlockPos) void
   public void method_355(@Nullable BlockPos var1) {
      this.field_252 = var1;
   }

   // $FF: renamed from: 2 (net.minecraft.util.math.BlockPos) void
   public void method_356(@Nullable BlockPos var1) {
      this.field_251 = var1;
   }

   // $FF: renamed from: 0 (java.util.LinkedHashMap) void
   public void method_357(@NotNull LinkedHashMap var1) {
      this.field_250 = var1;
   }

   // $FF: renamed from: c (boolean) void
   public void method_358(boolean var1) {
      this.field_247 = var1;
   }

   // $FF: renamed from: 0 () net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos method_359() {
      return this.field_252;
   }

   // $FF: renamed from: 5 () java.util.LinkedHashMap
   @NotNull
   public LinkedHashMap method_360() {
      return this.field_248;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_361(@NotNull f4e var1) {
      if (!var1.c() && var1.c() == f41.field_2120 && var1.c() instanceof SPacketBlockAction && this.field_246 == 0 && this.field_250 != null) {
         Packet var10000 = var1.c();
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketBlockAction");
         }

         SPacketBlockAction var2 = (SPacketBlockAction)var10000;
         fe0 var3 = fe0.values()[var2.getData1()];
         int var4 = var2.getData2();
         BlockPos[] var5 = (BlockPos[])this.field_250.get(var3);
         int var6 = 0;

         for(int var7 = 0; var6 < 25; var6 = var7) {
            if (var5 == null) {
               Intrinsics.throwNpe();
            }

            BlockPos var8 = var5[var7];
            if (Intrinsics.areEqual((Object)var2.getBlockPosition(), (Object)var8)) {
               AtomicInteger var9 = (AtomicInteger)this.field_248.get(var8);
               if (var9 == null) {
                  Intrinsics.throwNpe();
               }

               if (var9.intValue() == -1) {
                  Ref.IntRef var10 = new Ref.IntRef();
                  boolean var12 = false;
                  boolean var13 = false;
                  boolean var15 = false;
                  var10.element = var4;
                  if (var7 - var4 < 0) {
                     var10.element += 25;
                  }

                  Object var18 = this.field_248.get(var8);
                  if (var18 == null) {
                     Intrinsics.throwNpe();
                  }

                  ((AtomicInteger)var18).set(var10.element);
                  if (var10.element != 0) {
                     this.field_247 = false;
                  }
               }

               if (Intrinsics.areEqual((Object)this.field_251, (Object)var2.getBlockPosition()) && this.field_249 >= this.field_248.values().size()) {
                  this.field_246 = 1;
                  return;
               }
               break;
            }

            ++var7;
         }
      }

   }

   // $FF: renamed from: 3 () boolean
   public boolean method_362() {
      return this.field_247;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) net.minecraft.util.math.BlockPos
   public BlockPos method_363(BlockPos var1) {
      Iterator var2 = this.field_248.entrySet().iterator();

      while(var2.hasNext()) {
         Ref.ObjectRef var3 = new Ref.ObjectRef();
         Object var5 = var2.next();
         boolean var6 = false;
         boolean var7 = false;
         Entry var8 = (Entry)var5;
         boolean var9 = false;
         var3.element = var8;
         BlockPos var4 = (BlockPos)((Entry)var5).getKey();
         AtomicInteger var10 = (AtomicInteger)((Entry)var3.element).getValue();
         if (var4 != null) {
            if (var1 == null) {
               throw new TypeCastException("null cannot be cast to non-null type kotlin.Any");
            }

            if (Intrinsics.areEqual((Object)var4, (Object)((Object)var1)) ^ true && var10.intValue() > 0) {
               return var4;
            }
         }
      }

      return null;
   }

   public f8s() {
      super("notetuner", "NoteTuner", (String)null);
   }

   // $FF: renamed from: 3 (int) void
   public void method_364(int var1) {
      this.field_246 = var1;
   }

   // $FF: renamed from: 3 (net.minecraft.util.math.BlockPos) void
   public void method_365(BlockPos var1) {
      if (var1 != null) {
         this.field_251 = var1;
         ((Map)this.field_248).put(var1, new AtomicInteger(-1));
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f8s, net.minecraft.client.Minecraft) void
   public static void method_366(f8s var0, Minecraft var1) {
      var0.c = var1;
   }
}
