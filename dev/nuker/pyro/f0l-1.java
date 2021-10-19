/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.JsonElement;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f0l extends Setting {
   // $FF: renamed from: c dev.nuker.pyro.fz
   @JvmField
   @NotNull
   public class_7 field_2222 = new class_7(false);

   // $FF: renamed from: 2 () dev.nuker.pyro.f13
   @NotNull
   public f13 method_3309() {
      return (f13)(new f0L(this));
   }

   // $FF: renamed from: c (dev.nuker.pyro.f00) void
   public void method_3335(@NotNull f00 var1) {
      super.0(var1);
   }

   // $FF: renamed from: c (com.google.gson.JsonElement) void
   public void method_3310(@NotNull JsonElement var1) {
      this.getValue().method_3033(f00.field_2296.method_3690(var1.getAsJsonObject()));
   }

   public f0l(@NotNull String var1, @NotNull String var2, @Nullable String var3, @NotNull f00 var4) {
      super(var1, var2, var3, var4);
      this.method_3335(var4.meth0());
   }

   // $FF: renamed from: 0 () com.google.gson.JsonElement
   @NotNull
   public JsonElement method_3316() {
      return (JsonElement)((f00)this.getValue().method_3034()).method_3450();
   }

   // $FF: renamed from: 1 () java.lang.Object
   public Object method_3304() {
      return this.method_3336();
   }

   // $FF: renamed from: c () dev.nuker.pyro.f00
   @NotNull
   public f00 method_3336() {
      return ((f00)super.1()).meth0();
   }

   // $FF: renamed from: 0 (java.lang.Object) void
   public void method_3308(Object var1) {
      this.method_3335((f00)var1);
   }
}
