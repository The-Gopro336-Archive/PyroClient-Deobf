/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5k extends fdZ {
   // $FF: renamed from: c dev.nuker.pyro.f5q
   @JvmField
   @NotNull
   public f5q field_1005;
   // $FF: renamed from: c float
   public float field_1006;
   // $FF: renamed from: 0 float
   public float field_1007;
   // $FF: renamed from: 1 float
   public float field_1008;
   // $FF: renamed from: 2 float
   public float field_1009;
   // $FF: renamed from: c boolean
   @JvmField
   public boolean field_1010;
   // $FF: renamed from: 0 boolean
   public boolean field_1011;
   // $FF: renamed from: 1 boolean
   public boolean field_1012;
   // $FF: renamed from: 3 float
   public float field_1013;
   // $FF: renamed from: c dev.nuker.pyro.f5m
   @Nullable
   public f5m field_1014;
   // $FF: renamed from: c dev.nuker.pyro.f5l
   @NotNull
   public f5l field_1015;
   // $FF: renamed from: 2 boolean
   public boolean field_1016;
   // $FF: renamed from: c java.lang.Runnable
   @JvmField
   @Nullable
   public Runnable field_1017;
   // $FF: renamed from: c java.lang.String
   @NotNull
   public String field_1018;
   // $FF: renamed from: 0 java.lang.String
   @NotNull
   public String field_1019;
   // $FF: renamed from: 3 boolean
   @JvmField
   public boolean field_1020;

   // $FF: renamed from: 0 () float
   public float method_1495() {
      return this.field_1013;
   }

   public f5k(String var1, String var2, f5q var3, f5l var4, boolean var5, int var6, DefaultConstructorMarker var7) {
      if ((var6 & 8) != 0) {
         var4 = f5l.field_1682;
      }

      if ((var6 & 16) != 0) {
         var5 = true;
      }

      this(var1, var2, var3, var4, var5);
   }

   // $FF: renamed from: c (float, boolean) boolean
   public boolean method_1496(float var1, boolean var2) {
      float var3 = (float)Minecraft.getDebugFPS() / 60.0F;
      float var4 = 3.0F / var3;
      float var5 = 4.0F / var3;
      if (this.field_1013 != var1) {
         if (this.field_1013 == 0.0F && this.field_1016) {
            this.field_1013 = var1;
            this.field_1016 = false;
         }

         if (this.field_1013 > var1) {
            this.field_1013 -= var5;
            if (this.field_1013 <= var1) {
               this.field_1013 = var1;
            }
         } else if (this.field_1013 < var1) {
            this.field_1013 += var5;
            if (this.field_1013 >= var1) {
               this.field_1013 = var1;
            }
         }
      }

      if (this.field_1010 && var2 && this.field_1006 < (float)10) {
         boolean var7 = false;
         boolean var8 = false;
         boolean var10 = false;
         this.field_1006 += var4;
         if (this.field_1006 >= (float)10) {
            if (this.method_1509()) {
               this.field_1012 = true;
               if (this.field_1017 != null) {
                  Runnable var11 = this.field_1017;
                  if (var11 == null) {
                     Intrinsics.throwNpe();
                  }

                  var11.run();
               }
            }

            return true;
         } else {
            return false;
         }
      } else {
         boolean var10000;
         if (this.field_1011 && var2) {
            if (this.field_1006 > (float)0) {
               this.field_1006 -= var4;
               this.field_1006 = Math.max(0.0F, this.field_1006);
               var10000 = false;
            } else {
               this.field_1011 = false;
               var10000 = true;
            }
         } else {
            var10000 = true;
         }

         return var10000;
      }
   }

   // $FF: renamed from: d () float
   public float method_1497() {
      return this.field_1005.method_1531();
   }

   // $FF: renamed from: 8 () float
   public float method_1498() {
      return this.field_1009;
   }

   // $FF: renamed from: c (net.minecraft.client.gui.ScaledResolution) void
   public void method_1499(@Nullable ScaledResolution var1) {
   }

   // $FF: renamed from: c (boolean) void
   public void method_1500(boolean var1) {
      this.field_1020 = var1;
      if (var1) {
         this.meth2();
      }

      class_5.field_1004.method_1493();
   }

   @JvmOverloads
   public f5k(@NotNull String var1, @NotNull String var2, @NotNull f5q var3, @NotNull f5l var4, boolean var5) {
      super();
      this.field_1018 = var1;
      this.field_1019 = var2;
      this.field_1020 = var5;
      this.field_1016 = true;
      this.field_1011 = true;
      this.field_1015 = var4;
      this.field_1005 = var3;
      this.method_1500(this.field_1020);
   }

   // $FF: renamed from: 3 () boolean
   public boolean method_1501() {
      return this.field_1012;
   }

   public void meth2() {
      this.field_1010 = false;
      this.field_1011 = true;
      this.field_1012 = false;
      this.field_1006 = 10.0F;
   }

   // $FF: renamed from: a () float
   public float method_1502() {
      return this.field_1007;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f5m) void
   public void method_1503(@Nullable f5m var1) {
      this.field_1014 = var1;
   }

   @JvmOverloads
   public f5k(@NotNull String var1, @NotNull String var2, @NotNull f5q var3, @NotNull f5l var4) {
      this(var1, var2, var3, var4, false, 16, (DefaultConstructorMarker)null);
   }

   // $FF: renamed from: 3 (float) void
   public void method_1504(float var1) {
      this.field_1008 = var1;
   }

   // $FF: renamed from: c (net.minecraft.client.gui.ScaledResolution, int, int) void
   public void method_1505(@Nullable ScaledResolution var1, int var2, int var3) {
   }

   // $FF: renamed from: 9 () java.lang.String
   @NotNull
   public String method_1506() {
      return this.field_1019;
   }

   // $FF: renamed from: 0 (float) void
   public void method_1507(float var1) {
      this.field_1007 = var1;
   }

   // $FF: renamed from: 7 () float
   public float method_1508() {
      return this.field_1008;
   }

   // $FF: renamed from: e () boolean
   public boolean method_1509() {
      return this.field_1020;
   }

   // $FF: renamed from: f () void
   public void method_1510() {
   }

   @JvmOverloads
   public f5k(@NotNull String var1, @NotNull String var2, @NotNull f5q var3) {
      this(var1, var2, var3, (f5l)null, false, 24, (DefaultConstructorMarker)null);
   }

   public float meth4() {
      return this.field_1006;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f5l) void
   public void method_1511(@NotNull f5l var1) {
      this.field_1015 = var1;
   }

   // $FF: renamed from: c (int, int, int) void
   public void method_1512(int var1, int var2, int var3) {
   }

   // $FF: renamed from: b () void
   public void method_1513() {
      this.field_1010 = true;
   }

   public float meth1() {
      return this.field_1005.method_1526();
   }

   // $FF: renamed from: 2 (float) void
   public void method_1514(float var1) {
      this.field_1009 = var1;
   }

   // $FF: renamed from: 5 () java.lang.String
   @NotNull
   public String method_1515() {
      return this.field_1018;
   }

   // $FF: renamed from: c () dev.nuker.pyro.f5l
   @NotNull
   public f5l method_1516() {
      return this.field_1015;
   }

   // $FF: renamed from: 1 (float) void
   public void method_1517(float var1) {
      this.field_1013 = var1;
   }

   // $FF: renamed from: c (float) void
   public void method_1518(float var1) {
      this.field_1006 = var1;
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.f5m
   @Nullable
   public f5m method_1519() {
      return this.field_1014;
   }
}
