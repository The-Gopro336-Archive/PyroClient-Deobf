/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.awt.Color;
import java.util.Arrays;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import net.minecraft.client.gui.Gui;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f0M extends f0Y {
   // $FF: renamed from: c java.lang.String
   @JvmField
   @Nullable
   public String field_2365;
   // $FF: renamed from: c dev.nuker.pyro.fw
   @JvmField
   @Nullable
   public class_6 field_2366;
   // $FF: renamed from: c double
   @JvmField
   public double field_2367;
   // $FF: renamed from: 0 double
   @JvmField
   public double field_2368;
   // $FF: renamed from: 1 double
   @JvmField
   public double field_2369;
   // $FF: renamed from: c int
   public int field_2370;
   // $FF: renamed from: c boolean
   public boolean field_2371;
   // $FF: renamed from: 0 int
   @JvmField
   public int field_2372 = -1;
   // $FF: renamed from: 0 java.lang.String
   @JvmField
   @Nullable
   public String field_2373;
   // $FF: renamed from: 0 boolean
   @JvmField
   public boolean field_2374;

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H, dev.nuker.pyro.f17) void
   public void method_24(@NotNull f0F var1, @NotNull f0H var2, @NotNull f17 var3) {
      class_6 var10000;
      if (var3 instanceof f16 && var3.method_3645() == 0) {
         var10000 = this.field_2366;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         double var18 = this.field_2368;
         double var10002 = this.field_2367;
         StringCompanionObject var15 = StringCompanionObject.INSTANCE;
         String var5 = "%.5f";
         Object[] var10003 = new Object[1];
         class_6 var10006 = this.field_2366;
         if (var10006 == null) {
            Intrinsics.throwNpe();
         }

         var10003[0] = var10006.method_3034();
         Object[] var6 = var10003;
         double var11 = var10002;
         double var9 = var18;
         class_6 var8 = var10000;
         boolean var7 = false;
         String var13 = String.format(var5, Arrays.copyOf(var6, var6.length));
         boolean var16 = false;
         double var17 = Double.parseDouble(var13);
         var8.method_3033(Math.min(var9, Math.max(var11, var17)));
      } else {
         class_6 var10001;
         if (var3 instanceof f15 && var3.method_3645() == 0) {
            var10000 = this.field_2366;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            double var4 = ((Number)var10000.method_3034()).doubleValue() + ((f15)var3).method_3655() / ((double)(var1.method_3581() - f0H.field_2335 * 2) / this.field_2369);
            if (var4 > this.field_2368) {
               var4 = this.field_2368;
            } else if (var4 < this.field_2367) {
               var4 = this.field_2367;
            }

            var10001 = this.field_2366;
            if (var10001 == null) {
               Intrinsics.throwNpe();
            }

            if (Intrinsics.areEqual(var4, (Double)var10001.method_3034()) ^ true) {
               var10000 = this.field_2366;
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               var10000.method_3033(var4);
            }

            this.field_2372 = -1;
            this.field_2373 = (String)null;
         } else if (var3 instanceof f18 && !(var3 instanceof f16) && var3.method_3645() == 0) {
            if (this.field_2372 == -1) {
               this.field_2372 = 0;
               var10001 = this.field_2366;
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               this.field_2373 = Double.toString(((Number)var10001.method_3034()).doubleValue());
            } else {
               this.method_3615();
            }
         }
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H) int
   public int method_29(@NotNull f0F var1, @NotNull f0H var2) {
      return var1.method_3582().getStringWidth(this.field_2365 + " XX.XXX") + f0H.field_2335 * 2;
   }

   // $FF: renamed from: 0 () java.lang.String
   @NotNull
   public String method_3612() {
      String var10000;
      if (this.field_2373 != null) {
         var10000 = this.field_2373;
      } else {
         class_6 var10001 = this.field_2366;
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         var10000 = this.method_3617(((Number)var10001.method_3034()).doubleValue());
      }

      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      String var1 = var10000;
      if (this.field_2372 != -1) {
         StringBuilder var9 = new StringBuilder();
         byte var3 = 0;
         int var4 = this.field_2372;
         StringBuilder var6 = var9;
         boolean var5 = false;
         if (var1 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         }

         String var7 = var1.substring(var3, var4);
         var9 = var6.append(var7).append(this.field_2371 ? "|" : ":");
         int var8 = this.field_2372;
         var4 = var1.length();
         var6 = var9;
         var5 = false;
         if (var1 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         }

         var7 = var1.substring(var8, var4);
         var1 = var6.append(var7).toString();
      }

      return var1;
   }

   // $FF: renamed from: c () void
   public void method_20() {
      this.field_2372 = -1;
      this.field_2373 = (String)null;
      this.field_2374 = false;
   }

   public f0M(@Nullable f0w var1) {
      super(var1);
   }

   // $FF: renamed from: c () int
   public int method_3613() {
      return this.field_2370;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, double, double, dev.nuker.pyro.f0H) void
   public void method_28(@NotNull f0F var1, double var2, double var4, @NotNull f0H var6) {
      super.method_28(var1, var2, var4, var6);
      f0J.method_3555(f0J.field_2340, var1.method_3582(), this.field_2365, 0, f0H.field_2335, var1.method_3581() - 4, var1.method_3583() - f0H.field_2335 * 2 - 4, f0G.field_2325, f0H.field_2335, var6.method_3494(), false, 512, (Object)null);
      f0J.method_3555(f0J.field_2340, var1.method_3582(), this.method_3612(), 0, f0H.field_2335, var1.method_3581() - 4, var1.method_3583() - f0H.field_2335 * 2 - 4, f0G.field_2326, f0H.field_2335, this.field_2372 == -1 ? var6.method_3494() : (this.field_2374 ? Color.RED.getRGB() : var6.method_3488()), false, 512, (Object)null);
      double var10000 = (double)(var1.method_3581() - f0H.field_2335 * 2);
      class_6 var10001 = this.field_2366;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      int var7 = (int)(var10000 * ((((Number)var10001.method_3034()).doubleValue() - this.field_2367) / (this.field_2368 - this.field_2367)));
      Gui.drawRect(f0H.field_2335, var1.method_3583() - f0H.field_2335, var7 + f0H.field_2335, var1.method_3583() - f0H.field_2335 - 1, var6.method_3505());
      Gui.drawRect(f0H.field_2335 + var7, var1.method_3583() - f0H.field_2335, var1.method_3581() - f0H.field_2335, var1.method_3583() - f0H.field_2335 - 1, var6.method_3494());
      int var9 = this.field_2370++;
      if (this.field_2370 >= 20) {
         this.field_2370 = 0;
         this.field_2371 = !this.field_2371;
      }

   }

   // $FF: renamed from: 2 () boolean
   public boolean method_3614() {
      return this.field_2371;
   }

   // $FF: renamed from: 1 () void
   public void method_3615() {
      try {
         Double var1 = Double.valueOf(this.field_2373);
         if (var1 >= this.field_2367 && var1 <= this.field_2368) {
            class_6 var10000 = this.field_2366;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            var10000.method_3033(var1);
            this.field_2373 = (String)null;
         } else {
            this.field_2374 = true;
         }
      } catch (NumberFormatException var2) {
         this.field_2374 = true;
      }

      if (!this.field_2374) {
         this.field_2372 = -1;
      }

   }

   public f0M(@NotNull DoubleSetting var1) {
      super((f0w)var1);
      this.field_2365 = var1.c();
      this.field_2366 = var1.getValue();
      this.field_2367 = var1.getValue();
      this.field_2368 = var1.method_3328();
      this.field_2369 = var1.method_3325();
   }

   // $FF: renamed from: c (boolean) void
   public void method_3616(boolean var1) {
      this.field_2371 = var1;
   }

   // $FF: renamed from: c (double) java.lang.String
   @Nullable
   public String method_3617(double var1) {
      StringCompanionObject var3 = StringCompanionObject.INSTANCE;
      String var4 = "%.3f";
      Object[] var5 = new Object[]{var1};
      boolean var6 = false;
      return String.format(var4, Arrays.copyOf(var5, var5.length));
   }

   // $FF: renamed from: c (int) void
   public void method_3618(int var1) {
      this.field_2370 = var1;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H) int
   public int method_26(@NotNull f0F var1, @NotNull f0H var2) {
      return var1.method_3582().FONT_HEIGHT + 4 + f0H.field_2335 * 2;
   }

   // $FF: renamed from: c (char, int) void
   public void method_23(char var1, int var2) {
      if (this.field_2372 != -1) {
         if (this.field_2374) {
            this.field_2374 = false;
         }

         int var13;
         int var10000;
         String var10001;
         if (var2 == 205) {
            var10000 = this.field_2372;
            var10001 = this.field_2373;
            if (var10001 == null) {
               Intrinsics.throwNpe();
            }

            if (var10000 < var10001.length()) {
               var13 = this.field_2372++;
               return;
            }
         }

         if (var2 == 203 && this.field_2372 > 0) {
            this.field_2372 += -1;
         } else if (var2 == 28) {
            this.method_3615();
         } else {
            String var3;
            byte var4;
            int var5;
            boolean var6;
            StringBuilder var8;
            String var9;
            int var10;
            boolean var11;
            StringBuilder var12;
            String var10002;
            if (var2 == 14) {
               if (this.field_2372 > 0) {
                  var12 = new StringBuilder();
                  var10002 = this.field_2373;
                  if (var10002 == null) {
                     Intrinsics.throwNpe();
                  }

                  var3 = var10002;
                  var4 = 0;
                  var5 = this.field_2372 - 1;
                  var8 = var12;
                  var6 = false;
                  if (var3 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                  }

                  var9 = var3.substring(var4, var5);
                  var12 = var8.append(var9);
                  var10002 = this.field_2373;
                  if (var10002 == null) {
                     Intrinsics.throwNpe();
                  }

                  var3 = var10002;
                  var10 = this.field_2372;
                  var8 = var12;
                  var11 = false;
                  if (var3 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                  }

                  var9 = var3.substring(var10);
                  this.field_2373 = var8.append(var9).toString();
                  this.field_2372 += -1;
               }
            } else if (var2 == 211) {
               var10000 = this.field_2372;
               var10001 = this.field_2373;
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               if (var10000 < var10001.length()) {
                  var12 = new StringBuilder();
                  var10002 = this.field_2373;
                  if (var10002 == null) {
                     Intrinsics.throwNpe();
                  }

                  var3 = var10002;
                  var4 = 0;
                  var5 = this.field_2372;
                  var8 = var12;
                  var6 = false;
                  if (var3 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                  }

                  var9 = var3.substring(var4, var5);
                  var12 = var8.append(var9);
                  var10002 = this.field_2373;
                  if (var10002 == null) {
                     Intrinsics.throwNpe();
                  }

                  var3 = var10002;
                  var10 = this.field_2372 + 1;
                  var8 = var12;
                  var11 = false;
                  if (var3 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                  }

                  var9 = var3.substring(var10);
                  this.field_2373 = var8.append(var9).toString();
               }
            } else if (var1 != 0) {
               var12 = new StringBuilder();
               var10002 = this.field_2373;
               if (var10002 == null) {
                  Intrinsics.throwNpe();
               }

               var3 = var10002;
               var4 = 0;
               var5 = this.field_2372;
               var8 = var12;
               var6 = false;
               if (var3 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
               }

               var9 = var3.substring(var4, var5);
               var12 = var8.append(var9).append(var1);
               var10002 = this.field_2373;
               if (var10002 == null) {
                  Intrinsics.throwNpe();
               }

               var3 = var10002;
               var10 = this.field_2372;
               var8 = var12;
               var11 = false;
               if (var3 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
               }

               var9 = var3.substring(var10);
               this.field_2373 = var8.append(var9).toString();
               var13 = this.field_2372++;
            }
         }
      }

   }
}
