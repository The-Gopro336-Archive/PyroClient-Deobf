/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import org.jetbrains.annotations.NotNull;

public class f0O extends f0Y {
   // $FF: renamed from: c dev.nuker.pyro.fw
   @JvmField
   @NotNull
   public class_6 field_2376;
   // $FF: renamed from: c java.lang.String
   public String field_2377;
   // $FF: renamed from: c java.lang.Enum[]
   public Enum[] field_2378;
   // $FF: renamed from: 0 java.lang.String
   public String field_2379;
   // $FF: renamed from: c double
   public double field_2380;
   // $FF: renamed from: c boolean
   public boolean field_2381;

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H) int
   public int method_26(@NotNull f0F var1, @NotNull f0H var2) {
      return var1.method_3582().FONT_HEIGHT + 4 + f0H.field_2335 * 2;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H, dev.nuker.pyro.f17) void
   public void method_24(@NotNull f0F var1, @NotNull f0H var2, @NotNull f17 var3) {
      if (var3.method_3645() == 0) {
         if (var3 instanceof f18) {
            if (!this.field_2381) {
               this.method_3621(1);
            }

            this.field_2380 = 0.0D;
            this.field_2381 = false;
         } else if (var3 instanceof f15) {
            this.field_2381 = true;
            this.field_2380 += ((f15)var3).method_3655();
            int var4 = (var1.method_3581() - f0H.field_2335 * 2) / this.field_2378.length;
            if (this.field_2380 > (double)var4) {
               this.method_3621(1);
               this.field_2380 = 0.0D;
            } else if (this.field_2380 < (double)(-var4)) {
               this.method_3621(-1);
               this.field_2380 = 0.0D;
            }
         }
      }

   }

   public f0O(@NotNull f0o var1) {
      super((f0w)var1);
      this.field_2377 = var1.c();
      this.field_2379 = "";
      this.field_2376 = var1.getValue();
      Object var10001 = this.field_2376.method_3034();
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      Object[] var6 = ((Enum)var10001).getClass().getEnumConstants();
      if (var6 == null) {
         throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      } else {
         this.field_2378 = (Enum[])var6;
         Enum[] var4 = this.field_2378;
         int var5 = var4.length;

         for(int var3 = 0; var3 < var5; ++var3) {
            Enum var2 = var4[var3];
            if (var2 == null) {
               Intrinsics.throwNpe();
            }

            if (var2.name().length() > this.field_2379.length()) {
               this.field_2379 = var2.name();
            }
         }

      }
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, double, double, dev.nuker.pyro.f0H) void
   public void method_28(@NotNull f0F var1, double var2, double var4, @NotNull f0H var6) {
      super.method_28(var1, var2, var4, var6);
      f0J.method_3555(f0J.field_2340, var1.method_3582(), this.field_2377, 0, f0H.field_2335, var1.method_3581() - 4, var1.method_3583() - f0H.field_2335 * 2 - 4, f0G.field_2325, f0H.field_2335, var6.method_3494(), false, 512, (Object)null);
      f0J var10000 = f0J.field_2340;
      FontRenderer var10001 = var1.method_3582();
      Object var10002 = this.field_2376.method_3034();
      if (var10002 == null) {
         Intrinsics.throwNpe();
      }

      f0J.method_3555(var10000, var10001, ((Enum)var10002).name(), 0, f0H.field_2335, var1.method_3581() - 4, var1.method_3583() - f0H.field_2335 * 2 - 4, f0G.field_2326, f0H.field_2335, var6.method_3494(), false, 512, (Object)null);
      int var7 = (var1.method_3581() - f0H.field_2335 * 2) / this.field_2378.length;
      Object var12 = this.field_2376.method_3034();
      if (var12 == null) {
         Intrinsics.throwNpe();
      }

      int var8 = var7 * ((Enum)var12).ordinal();
      Object var10 = this.field_2376.method_3034();
      if (var10 == null) {
         Intrinsics.throwNpe();
      }

      int var11;
      if (((Enum)var10).ordinal() == this.field_2378.length - 1) {
         var11 = var1.method_3581() - f0H.field_2335 * 2;
      } else {
         var12 = this.field_2376.method_3034();
         if (var12 == null) {
            Intrinsics.throwNpe();
         }

         var11 = var7 * (((Enum)var12).ordinal() + 1);
      }

      int var9 = var11;
      Gui.drawRect(f0H.field_2335, var1.method_3583() - f0H.field_2335, var1.method_3581() - f0H.field_2335, var1.method_3583() - f0H.field_2335 - 1, var6.method_3494());
      Gui.drawRect(f0H.field_2335 + var8, var1.method_3583() - f0H.field_2335, f0H.field_2335 + var9, var1.method_3583() - f0H.field_2335 - 1, var6.method_3505());
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H) int
   public int method_29(@NotNull f0F var1, @NotNull f0H var2) {
      return var1.method_3582().getStringWidth(this.field_2377 + "  " + this.field_2379) + f0H.field_2335 * 2;
   }

   // $FF: renamed from: c (int) void
   public void method_3621(int var1) {
      Object var10000 = this.field_2376.method_3034();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      int var2;
      for(var2 = ((Enum)var10000).ordinal() + var1; var2 >= this.field_2378.length; var2 -= this.field_2378.length) {
      }

      while(var2 < 0) {
         var2 += this.field_2378.length;
      }

      this.field_2376.method_3033(this.field_2378[var2]);
   }
}
