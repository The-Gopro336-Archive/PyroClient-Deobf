/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.Tuple;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f0V implements f13 {
   // $FF: renamed from: c java.util.List
   @JvmField
   @NotNull
   public List field_2385;
   // $FF: renamed from: c dev.nuker.pyro.f0F
   @JvmField
   @Nullable
   public f0F field_2386;
   // $FF: renamed from: c dev.nuker.pyro.fw
   @NotNull
   public class_6 field_2387;
   // $FF: renamed from: c dev.nuker.pyro.f13
   @Nullable
   public f13 field_2388;
   // $FF: renamed from: 0 java.util.List
   @NotNull
   public List field_2389;

   // $FF: renamed from: c (dev.nuker.pyro.f0F, double, double, dev.nuker.pyro.f0H) void
   public void method_22(@NotNull f0F var1, double var2, double var4, @NotNull f0H var6) {
      f13 var10000 = this.field_2388;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      if (var10000.method_21(var1, var2, var4, var6)) {
         var10000 = this.field_2388;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         f0F var10001 = this.field_2386;
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         var10000.method_22(var10001, var2, var4, var6);
      }

      if ((Boolean)this.field_2387.method_3034()) {
         f0F var12 = this.field_2386;
         if (var12 == null) {
            Intrinsics.throwNpe();
         }

         int var7 = var12.method_3583();
         int var8 = 0;

         for(int var9 = ((Collection)this.field_2389).size(); var8 < var9; ++var8) {
            f13 var10 = (f13)this.field_2389.get(var8);
            Object var13 = this.field_2385.get(var8);
            if (var13 == null) {
               Intrinsics.throwNpe();
            }

            f0F var11 = (f0F)var13;
            if (var10.method_21(var1, var2, var4 - (double)var7, var6)) {
               GlStateManager.pushMatrix();
               GlStateManager.translate(1.0F, (float)var7, 0.0F);
               var10.method_22(var11, var2, var4 - (double)var7, var6);
               GlStateManager.popMatrix();
            }

            var7 += var11.method_3583();
         }
      }

   }

   // $FF: renamed from: 1 () dev.nuker.pyro.fw
   @NotNull
   public class_6 method_3624() {
      return this.field_2387;
   }

   // $FF: renamed from: 1 (dev.nuker.pyro.f0F, double, double, dev.nuker.pyro.f0H) boolean
   public boolean method_25(@NotNull f0F var1, double var2, double var4, @NotNull f0H var6) {
      f13 var10000 = this.field_2388;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      f0F var10001 = this.field_2386;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      if (var10000.method_25(var10001, var2, var4, var6)) {
         return true;
      } else {
         if ((Boolean)this.field_2387.method_3034()) {
            f0F var12 = this.field_2386;
            if (var12 == null) {
               Intrinsics.throwNpe();
            }

            int var7 = var12.method_3583();
            int var8 = 0;

            for(int var9 = ((Collection)this.field_2389).size(); var8 < var9; ++var8) {
               f13 var10 = (f13)this.field_2389.get(var8);
               Object var13 = this.field_2385.get(var8);
               if (var13 == null) {
                  Intrinsics.throwNpe();
               }

               f0F var11 = (f0F)var13;
               if (var10.method_25(var11, var2, var4 - (double)var7, var6)) {
                  return true;
               }

               var7 += var11.method_3583();
            }
         }

         return false;
      }
   }

   // $FF: renamed from: c (char, int) void
   public void method_23(char var1, int var2) {
      Iterator var4 = this.field_2389.iterator();

      while(var4.hasNext()) {
         f13 var3 = (f13)var4.next();
         var3.method_23(var1, var2);
      }

   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H, dev.nuker.pyro.f17) void
   public void method_24(@NotNull f0F var1, @NotNull f0H var2, @NotNull f17 var3) {
      if (var3 instanceof f14 && var3.method_3645() == 1) {
         double var10000 = var3.method_3646();
         f0F var10001 = this.field_2386;
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         if (var10000 < (double)var10001.method_3583()) {
            this.field_2387.method_3033(!(Boolean)this.field_2387.method_3034());
            Iterator var8 = this.field_2389.iterator();

            while(var8.hasNext()) {
               f13 var7 = (f13)var8.next();
               var7.method_20();
            }

            var1.method_3579();
            return;
         }
      }

      Tuple var9 = this.method_3631(var3 instanceof f15 ? ((f15)var3).method_3650() : (var3 instanceof f16 ? ((f16)var3).method_3658() : var3.method_3646()));
      if (var9 == null) {
         Intrinsics.throwNpe();
      }

      Tuple var4 = var9;
      f13 var10 = (f13)((Tuple)var4.getFirst()).getFirst();
      Object var11 = ((Tuple)var4.getFirst()).getSecond();
      if (var11 == null) {
         Intrinsics.throwNpe();
      }

      var10.method_24((f0F)var11, var2, var3.method_3648(1.0D, (double)((Number)var4.getSecond()).intValue()));
      Iterator var6 = this.field_2389.iterator();

      while(var6.hasNext()) {
         f13 var5 = (f13)var6.next();
         if (var5 != (f13)((Tuple)var4.getFirst()).getFirst()) {
            var5.method_20();
         }
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.fw) void
   public void method_3625(@NotNull class_6 var1) {
      this.field_2387 = var1;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.f13
   @Nullable
   public f13 method_3626() {
      return this.field_2388;
   }

   // $FF: renamed from: c () void
   public void method_20() {
      f13 var10000 = this.field_2388;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10000.method_20();
      Iterator var2 = this.field_2389.iterator();

      while(var2.hasNext()) {
         f13 var1 = (f13)var2.next();
         var1.method_20();
      }

   }

   public f0V(@Nullable f13 var1, @NotNull List var2, @NotNull class_6 var3) {
      this.field_2388 = var1;
      this.field_2389 = var2;
      this.field_2385 = (List)(new ArrayList());
      this.field_2387 = var3;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0F) void
   public void method_3627(@NotNull f0F var1) {
      this.field_2385.clear();
      int var2 = 0;

      for(int var3 = ((Collection)this.field_2389).size(); var2 < var3; ++var2) {
         this.field_2385.add(new f0F((Supplier)(new f0T(var1)), var1.method_3573(), 0, var1.method_3571(), var1.method_3582()));
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H, dev.nuker.pyro.f17) void
   public void method_27(@NotNull f0F var1, @NotNull f0H var2, @NotNull f17 var3) {
      double var4 = var3 instanceof f15 ? ((f15)var3).method_3656() : var3.method_3647();
      double var6 = var3 instanceof f15 ? ((f15)var3).method_3650() : var3.method_3646();
      f13 var10000 = this.field_2388;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      f0F var10001 = this.field_2386;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      if (var10000.method_25(var10001, var4, var6, var2)) {
         var10000 = this.field_2388;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.method_27(var1, var2, var3);
      }

      if ((Boolean)this.field_2387.method_3034()) {
         f0F var13 = this.field_2386;
         if (var13 == null) {
            Intrinsics.throwNpe();
         }

         int var8 = var13.method_3583();
         int var9 = 0;

         for(int var10 = ((Collection)this.field_2389).size(); var9 < var10; ++var9) {
            f13 var11 = (f13)this.field_2389.get(var9);
            Object var14 = this.field_2385.get(var9);
            if (var14 == null) {
               Intrinsics.throwNpe();
            }

            f0F var12 = (f0F)var14;
            if (var11.method_25(var12, var4, var6 - (double)var8, var2)) {
               var11.method_27(var1, var2, var3.method_3648(0.0D, (double)var8));
            }

            var8 += var12.method_3583();
         }
      }

   }

   // $FF: renamed from: 2 (dev.nuker.pyro.f0F, double, double, dev.nuker.pyro.f0H) boolean
   public boolean method_21(@NotNull f0F var1, double var2, double var4, @NotNull f0H var6) {
      f13 var10000 = this.field_2388;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      f0F var10001 = this.field_2386;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      if (var10000.method_21(var10001, var2, var4, var6)) {
         return true;
      } else {
         if ((Boolean)this.field_2387.method_3034()) {
            f0F var12 = this.field_2386;
            if (var12 == null) {
               Intrinsics.throwNpe();
            }

            int var7 = var12.method_3583();
            int var8 = 0;

            for(int var9 = ((Collection)this.field_2389).size(); var8 < var9; ++var8) {
               f13 var10 = (f13)this.field_2389.get(var8);
               Object var13 = this.field_2385.get(var8);
               if (var13 == null) {
                  Intrinsics.throwNpe();
               }

               f0F var11 = (f0F)var13;
               if (var10.method_21(var11, var2, var4 - (double)var7, var6)) {
                  return true;
               }

               var7 += var11.method_3583();
            }
         }

         return false;
      }
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H) int
   public int method_26(@NotNull f0F var1, @NotNull f0H var2) {
      this.method_3630(var1);
      f13 var10000 = this.field_2388;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      f0F var10001 = this.field_2386;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      int var3 = var10000.method_26(var10001, var2);
      f0F var8 = this.field_2386;
      if (var8 == null) {
         Intrinsics.throwNpe();
      }

      var8.method_3578(var3);
      if ((Boolean)this.field_2387.method_3034()) {
         int var4 = 0;

         for(int var5 = ((Collection)this.field_2389).size(); var4 < var5; ++var4) {
            f13 var6 = (f13)this.field_2389.get(var4);
            Object var10 = this.field_2385.get(var4);
            if (var10 == null) {
               Intrinsics.throwNpe();
            }

            int var7 = var6.method_26((f0F)var10, var2);
            Object var9 = this.field_2385.get(var4);
            if (var9 == null) {
               Intrinsics.throwNpe();
            }

            ((f0F)var9).method_3578(var7);
            var3 += var7;
         }
      }

      return var3;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f13) void
   public void method_3628(@Nullable f13 var1) {
      this.field_2388 = var1;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, double, double, dev.nuker.pyro.f0H) void
   public void method_28(@NotNull f0F var1, double var2, double var4, @NotNull f0H var6) {
      this.method_3630(var1);
      f0F var10000 = this.field_2386;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10000.method_3576(var1.method_3582());
      f13 var12 = this.field_2388;
      if (var12 == null) {
         Intrinsics.throwNpe();
      }

      f0F var10001 = this.field_2386;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      var12.method_28(var10001, var2, var4, var6);
      if ((Boolean)this.field_2387.method_3034()) {
         var10000 = this.field_2386;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         int var7 = var10000.method_3583();
         int var8 = 0;

         for(int var9 = ((Collection)this.field_2389).size(); var8 < var9; ++var8) {
            f13 var10 = (f13)this.field_2389.get(var8);
            Object var13 = this.field_2385.get(var8);
            if (var13 == null) {
               Intrinsics.throwNpe();
            }

            f0F var11 = (f0F)var13;
            GlStateManager.pushMatrix();
            GlStateManager.translate(1.0F, (float)var7, 0.0F);
            var10.method_28(var11, var2, var4 - (double)var7, var6);
            GlStateManager.popMatrix();
            var7 += var11.method_3583();
         }

         var10001 = this.field_2386;
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         Gui.drawRect(1, var10001.method_3583(), 2, var7, var6.method_3505());
      }

   }

   // $FF: renamed from: c () java.util.List
   @NotNull
   public List method_3629() {
      return this.field_2389;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F) void
   public void method_3630(@NotNull f0F var1) {
      if (this.field_2386 == null) {
         this.field_2386 = new f0F((Supplier)(new f0U(var1)), var1.method_3573(), 0, var1.method_3571(), var1.method_3582());
         this.method_3627(var1);
      }

   }

   // $FF: renamed from: c (double) net.minecraft.util.Tuple
   @Nullable
   public Tuple method_3631(double var1) {
      f0F var10000 = this.field_2386;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      int var3 = var10000.method_3583();
      if (var1 <= (double)var3) {
         Tuple var8 = new Tuple;
         Tuple var10002 = new Tuple;
         f13 var10004 = this.field_2388;
         if (var10004 == null) {
            Intrinsics.throwNpe();
         }

         var10002.<init>(var10004, this.field_2386);
         var8.<init>(var10002, 0);
         return var8;
      } else {
         int var4 = 0;

         for(int var5 = ((Collection)this.field_2389).size(); var4 < var5; ++var4) {
            Object var7 = this.field_2385.get(var4);
            if (var7 == null) {
               Intrinsics.throwNpe();
            }

            f0F var6 = (f0F)var7;
            var3 += var6.method_3583();
            if (var1 <= (double)var3) {
               return new Tuple(new Tuple(this.field_2389.get(var4), var6), var3 - var6.method_3583());
            }
         }

         return null;
      }
   }

   // $FF: renamed from: c (java.util.List) void
   public void method_3632(@NotNull List var1) {
      this.field_2389 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H) int
   public int method_29(@NotNull f0F var1, @NotNull f0H var2) {
      this.method_3630(var1);
      f13 var10000 = this.field_2388;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      f0F var10001 = this.field_2386;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      int var3 = var10000.method_29(var10001, var2);
      int var4 = 0;

      for(int var5 = ((Collection)this.field_2389).size(); var4 < var5; ++var4) {
         f13 var6 = (f13)this.field_2389.get(var4);
         Object var8 = this.field_2385.get(var4);
         if (var8 == null) {
            Intrinsics.throwNpe();
         }

         int var7 = var6.method_29((f0F)var8, var2) + 1;
         if (var7 > var3) {
            var3 = var7;
         }
      }

      return var3;
   }
}
