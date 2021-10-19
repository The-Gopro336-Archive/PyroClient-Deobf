/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import org.jetbrains.annotations.NotNull;

public class f0N extends f0Y {
   // $FF: renamed from: c java.lang.String
   @NotNull
   public String field_2359;

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, double, double, dev.nuker.pyro.f0H) void
   public void method_28(@NotNull f0F var1, double var2, double var4, @NotNull f0H var6) {
      super.method_28(var1, var2, var4, var6);
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H) int
   public int method_26(@NotNull f0F var1, @NotNull f0H var2) {
      return var1.method_3582().FONT_HEIGHT + f0H.field_2335 * 2;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H) int
   public int method_29(@NotNull f0F var1, @NotNull f0H var2) {
      return var1.method_3582().getStringWidth(this.field_2359) + f0H.field_2335 * 2 + (var1.method_3583() - f0H.field_2335 * 2) * 2 + 2;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H, dev.nuker.pyro.f17) void
   public void method_24(@NotNull f0F var1, @NotNull f0H var2, @NotNull f17 var3) {
   }

   // $FF: renamed from: c (java.lang.String) void
   public void method_3591(@NotNull String var1) {
      this.field_2359 = var1;
   }

   public f0N(@NotNull f0n var1) {
      super((f0w)var1);
      this.field_2359 = var1.c();
   }

   // $FF: renamed from: c () java.lang.String
   @NotNull
   public String method_3592() {
      return this.field_2359;
   }
}
