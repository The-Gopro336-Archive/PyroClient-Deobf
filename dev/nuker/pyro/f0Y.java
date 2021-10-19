/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f0Y implements f13 {
   // $FF: renamed from: 2 boolean
   public boolean field_2351;
   // $FF: renamed from: c dev.nuker.pyro.fz
   @Nullable
   public class_7 field_2352;
   // $FF: renamed from: c dev.nuker.pyro.f0w
   @Nullable
   public f0w field_2353;
   // $FF: renamed from: 1 java.lang.String
   @NotNull
   public static String field_2354 = "Defaults";
   // $FF: renamed from: c dev.nuker.pyro.f0X
   public static f0X field_2355 = new f0X((DefaultConstructorMarker)null);

   // $FF: renamed from: c () void
   public void method_20() {
      f12.method_3637(this);
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H, dev.nuker.pyro.f17) void
   public void method_24(@NotNull f0F var1, @NotNull f0H var2, @NotNull f17 var3) {
      f12.method_3641(this, var1, var2, var3);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0w) void
   public void method_3585(@Nullable f0w var1) {
      this.field_2353 = var1;
   }

   // $FF: renamed from: 1 (dev.nuker.pyro.f0F, double, double, dev.nuker.pyro.f0H) boolean
   public boolean method_25(@NotNull f0F var1, double var2, double var4, @NotNull f0H var6) {
      return this.field_2353 != null && this.method_21(var1, var2, var4, var6) && var2 >= (double)(var1.method_3581() + f0H.field_2335);
   }

   // $FF: renamed from: c (dev.nuker.pyro.fz) void
   public void method_3586(@Nullable class_7 var1) {
      this.field_2352 = var1;
   }

   // $FF: renamed from: c (net.minecraft.client.gui.FontRenderer) int
   public int method_3587(FontRenderer var1) {
      int var10000 = f0J.field_2340.method_3556(var1, "Defaults");
      f0J var10001 = f0J.field_2340;
      f0w var10003 = this.field_2353;
      if (var10003 == null) {
         Intrinsics.throwNpe();
      }

      return Math.max(var10000, var10001.method_3556(var1, var10003.method_3305()));
   }

   public f0Y(@Nullable f0w var1) {
      this.field_2353 = var1;
      class_7 var10001;
      if (this.field_2353 != null) {
         var10001 = new class_7;
         f0w var10003 = this.field_2353;
         if (var10003 == null) {
            Intrinsics.throwNpe();
         }

         var10001.<init>(var10003.method_3318(), (Consumer)(new f0W(this)));
      } else {
         var10001 = null;
      }

      this.field_2352 = var10001;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H, dev.nuker.pyro.f17) void
   public void method_27(@NotNull f0F var1, @NotNull f0H var2, @NotNull f17 var3) {
      if (var3 instanceof f14 && var3.method_3645() == 0 && var3.method_3646() >= (double)f0H.field_2335 && var3.method_3647() >= (double)var1.method_3581() && var3.method_3646() <= (double)(var1.method_3582().FONT_HEIGHT + f0H.field_2335) && var3.method_3647() <= (double)(var1.method_3582().getStringWidth("Defaults") + var1.method_3581())) {
         class_7 var10000 = this.field_2352;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         f0w var10001 = this.field_2353;
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         var10000.method_3033(var10001.method_3318());
         var10000 = this.field_2352;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10001 = this.field_2353;
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         var10000.method_3033(var10001.method_3304());
      }

   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, double, double, dev.nuker.pyro.f0H) void
   public void method_28(@NotNull f0F var1, double var2, double var4, @NotNull f0H var6) {
      if (this.field_2353 != null) {
         if (var2 >= (double)0 && var4 >= (double)0 && var2 <= (double)var1.method_3581() && var4 <= (double)var1.method_3583()) {
            this.field_2351 = true;
         }

      }
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.f0w
   @Nullable
   public f0w method_3588() {
      return this.field_2353;
   }

   // $FF: renamed from: 2 (dev.nuker.pyro.f0F, double, double, dev.nuker.pyro.f0H) boolean
   public boolean method_21(@NotNull f0F var1, double var2, double var4, @NotNull f0H var6) {
      if (this.field_2353 == null) {
         return false;
      } else {
         if (this.field_2351) {
            if (var4 >= (double)0) {
               label100: {
                  if (!(var4 <= (double)var1.method_3583()) || !(var2 >= (double)0)) {
                     f0w var10001 = this.field_2353;
                     if (var10001 == null) {
                        Intrinsics.throwNpe();
                     }

                     if (!(var4 <= (double)(var10001.method_3305() == null ? f0H.field_2335 * 2 + var1.method_3582().FONT_HEIGHT : f0H.field_2335 * 2 + 5 + var1.method_3582().FONT_HEIGHT * 2)) || !(var2 >= (double)(var1.method_3581() + f0H.field_2335))) {
                        break label100;
                     }
                  }

                  if (var2 <= (double)(var1.method_3581() + this.method_3587(var1.method_3582()) + f0H.field_2335 * 3)) {
                     return this.field_2351;
                  }
               }
            }

            this.field_2351 = false;
         }

         return this.field_2351;
      }
   }

   // $FF: renamed from: c (char, int) void
   public void method_23(char var1, int var2) {
      f12.method_3638(this, var1, var2);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0F, double, double, dev.nuker.pyro.f0H) void
   public void method_22(@NotNull f0F var1, double var2, double var4, @NotNull f0H var6) {
      if (this.field_2353 != null) {
         double var7 = var2 - (double)var1.method_3581();
         int var9 = this.method_3587(var1.method_3582()) + f0H.field_2335 * 2;
         int var10 = var1.method_3581() + f0H.field_2335;
         f0w var10003 = this.field_2353;
         if (var10003 == null) {
            Intrinsics.throwNpe();
         }

         f0J.method_3558(var10, 0, var9, var10003.method_3305() == null ? f0H.field_2335 * 2 + var1.method_3582().FONT_HEIGHT : f0H.field_2335 * 4 + var1.method_3582().FONT_HEIGHT * 2, var6.method_3490(), var6.method_3505(), 1);
         f0w var10000 = this.field_2353;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         if (var10000.method_3305() != null) {
            Gui.drawRect(var10, var1.method_3582().FONT_HEIGHT + f0H.field_2335 * 2, var10 + var9, var1.method_3582().FONT_HEIGHT + f0H.field_2335 * 2 + 1, var6.method_3505());
         }

         var10 += f0H.field_2335;
         f0J.field_2340.method_3553(var1.method_3582(), "Defaults", var10, f0H.field_2335 + 1, var4 >= (double)f0H.field_2335 && var7 >= (double)f0H.field_2335 && var4 <= (double)(var1.method_3582().FONT_HEIGHT + f0H.field_2335) && var7 <= (double)var1.method_3582().getStringWidth("Defaults") ? var6.method_3505() : var6.method_3494());
         var10000 = this.field_2353;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         if (var10000.method_3305() != null) {
            f0J var11 = f0J.field_2340;
            FontRenderer var10001 = var1.method_3582();
            f0w var10002 = this.field_2353;
            if (var10002 == null) {
               Intrinsics.throwNpe();
            }

            var11.method_3553(var10001, var10002.method_3305(), var10, var1.method_3582().FONT_HEIGHT + f0H.field_2335 * 3 + 1, var6.method_3494());
         }

      }
   }

   // $FF: renamed from: c () dev.nuker.pyro.fz
   @Nullable
   public class_7 method_3589() {
      return this.field_2352;
   }
}
