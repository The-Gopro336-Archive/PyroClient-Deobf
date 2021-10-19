/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import org.jetbrains.annotations.NotNull;
import org.lwjgl.input.Keyboard;

public class f0S extends f0Y {
   // $FF: renamed from: c dev.nuker.pyro.fw
   public class_6 field_2356;
   // $FF: renamed from: c java.lang.String
   public String field_2357;
   // $FF: renamed from: c boolean
   public boolean field_2358;

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, double, double, dev.nuker.pyro.f0H) void
   public void method_28(@NotNull f0F var1, double var2, double var4, @NotNull f0H var6) {
      super.method_28(var1, var2, var4, var6);
      f0J.method_3555(f0J.field_2340, var1.method_3582(), this.field_2357, 0, f0H.field_2335, var1.method_3581() - 4, var1.method_3583() - f0H.field_2335 * 2 - 4, f0G.field_2325, f0H.field_2335, var6.method_3494(), false, 512, (Object)null);
      f0J.method_3555(f0J.field_2340, var1.method_3582(), this.method_3590(((Number)this.field_2356.method_3034()).intValue()), 0, f0H.field_2335, var1.method_3581() - 4, var1.method_3583() - f0H.field_2335 * 2 - 4, f0G.field_2326, f0H.field_2335, this.field_2358 ? var6.method_3488() : var6.method_3494(), false, 512, (Object)null);
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H) int
   public int method_26(@NotNull f0F var1, @NotNull f0H var2) {
      return var1.method_3582().FONT_HEIGHT + f0H.field_2335 * 2;
   }

   public f0S(@NotNull String var1, @NotNull class_6 var2) {
      super((f0w)null);
      this.field_2357 = var1;
      this.field_2356 = var2;
   }

   // $FF: renamed from: c (char, int) void
   public void method_23(char var1, int var2) {
      if (this.field_2358) {
         if (var2 == 14) {
            this.field_2356.method_3033(-1);
         } else {
            this.field_2356.method_3033(var2);
         }

         this.field_2358 = false;
      }

   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H, dev.nuker.pyro.f17) void
   public void method_24(@NotNull f0F var1, @NotNull f0H var2, @NotNull f17 var3) {
      if (var3.method_3645() == 0 && var3 instanceof f14) {
         this.field_2358 = !this.field_2358;
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H) int
   public int method_29(@NotNull f0F var1, @NotNull f0H var2) {
      return var1.method_3582().getStringWidth(this.field_2357 + "           ") + f0H.field_2335 * 2;
   }

   public f0S(@NotNull BindSetting var1) {
      super((f0w)var1);
      this.field_2357 = var1.c();
      this.field_2356 = var1.getValue();
   }

   // $FF: renamed from: c (int) java.lang.String
   @NotNull
   public String method_3590(int var1) {
      return var1 == -1 ? "NONE" : Keyboard.getKeyName(var1);
   }

   // $FF: renamed from: c () void
   public void method_20() {
      this.field_2358 = false;
   }
}
