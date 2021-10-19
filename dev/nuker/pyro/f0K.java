/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.client.gui.Gui;
import org.jetbrains.annotations.NotNull;

public class f0K extends f0Y {
   // $FF: renamed from: c java.lang.String
   @NotNull
   public String field_2363;
   // $FF: renamed from: c dev.nuker.pyro.fw
   @NotNull
   public class_6 field_2364;

   // $FF: renamed from: c (dev.nuker.pyro.fw) void
   public void method_3608(@NotNull class_6 var1) {
      this.field_2364 = var1;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, double, double, dev.nuker.pyro.f0H) void
   public void method_28(@NotNull f0F var1, double var2, double var4, @NotNull f0H var6) {
      super.method_28(var1, var2, var4, var6);
      f0J.method_3555(f0J.field_2340, var1.method_3582(), this.field_2363, 0, 0, var1.method_3581() - 4, var1.method_3583(), f0H.field_2336, f0H.field_2335, var6.method_3494(), false, 512, (Object)null);
      int var7 = var1.method_3581() - f0H.field_2335;
      int var8 = (var1.method_3583() - f0H.field_2335 * 2) * 2;
      int var9 = var1.method_3583() - f0H.field_2335 * 2 - 1;
      Gui.drawRect(var7 - var8, f0H.field_2335, var1.method_3581() - f0H.field_2335, var1.method_3583() - f0H.field_2335, (Boolean)this.field_2364.method_3034() ? var6.method_3488() : var6.method_3491());
      int var10 = (Boolean)this.field_2364.method_3034() ? var7 - 1 - var9 : var7 - var8 + 1;
      Gui.drawRect(var10, f0H.field_2335 + 1, var10 + var9, var1.method_3583() - f0H.field_2335 - 1, var6.method_3494());
   }

   // $FF: renamed from: c (java.lang.String) void
   public void method_3609(@NotNull String var1) {
      this.field_2363 = var1;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H, dev.nuker.pyro.f17) void
   public void method_24(@NotNull f0F var1, @NotNull f0H var2, @NotNull f17 var3) {
      if (var3 instanceof f14 && var3.method_3645() == 0) {
         this.field_2364.method_3033(!(Boolean)this.field_2364.method_3034());
      }

   }

   // $FF: renamed from: c () dev.nuker.pyro.fw
   @NotNull
   public class_6 method_3610() {
      return this.field_2364;
   }

   // $FF: renamed from: 0 () java.lang.String
   @NotNull
   public String method_3611() {
      return this.field_2363;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H) int
   public int method_26(@NotNull f0F var1, @NotNull f0H var2) {
      return var1.method_3582().FONT_HEIGHT + f0H.field_2335 * 2;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H) int
   public int method_29(@NotNull f0F var1, @NotNull f0H var2) {
      return var1.method_3582().getStringWidth(this.field_2363) + f0H.field_2335 * 2 + (var1.method_3583() - f0H.field_2335 * 2) * 2 + 2;
   }

   public f0K(@NotNull BooleanSetting var1) {
      super((f0w)var1);
      this.field_2363 = var1.c();
      this.field_2364 = var1.getValue();
   }
}
