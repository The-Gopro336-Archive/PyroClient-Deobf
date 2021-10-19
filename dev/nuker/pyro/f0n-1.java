/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f0n extends Setting {
   // $FF: renamed from: 2 () dev.nuker.pyro.f13
   @NotNull
   public f13 method_3309() {
      return (f13)(new f0N(this));
   }

   // $FF: renamed from: c (com.google.gson.JsonElement) void
   public void method_3310(@NotNull JsonElement var1) {
   }

   public f0n(@NotNull String var1, @NotNull String var2, @Nullable String var3) {
      super(var1, var2, var3, Unit.INSTANCE);
   }

   // $FF: renamed from: 0 () com.google.gson.JsonElement
   @NotNull
   public JsonElement method_3316() {
      return (JsonElement)JsonNull.INSTANCE;
   }
}
