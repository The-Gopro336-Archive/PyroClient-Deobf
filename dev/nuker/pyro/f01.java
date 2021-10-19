/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import dev.nuker.pyro.gui.ClickGui$Window;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f01 extends Module {
   // $FF: renamed from: 2 () com.google.gson.JsonObject
   @NotNull
   public JsonObject method_117() {
      JsonObject var1 = new JsonObject();
      var1.add("enabled", (JsonElement)(new JsonPrimitive((Boolean)this.c.method_3034())));
      var1.add("expanded", (JsonElement)(new JsonPrimitive((Boolean)this.0.method_3034())));
      var1.add("keybind", (JsonElement)(new JsonPrimitive((Number)this.c())));
      return var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.gui.ClickGui$Window) void
   public void method_124(@NotNull ClickGui$Window var1) {
      this.method_236();
      super.method_124(var1);
   }

   // $FF: renamed from: c (com.google.gson.JsonObject) void
   public void method_119(@Nullable JsonObject var1) {
      if (var1 != null) {
         this.c.method_3033(var1.get("enabled").getAsBoolean());
         this.0.method_3033(var1.get("expanded").getAsBoolean());
         this.1(var1.get("keybind").getAsInt());
      }

   }

   // $FF: renamed from: c () void
   public void method_236() {
   }

   public f01(@NotNull String var1, @NotNull String var2, @Nullable String var3) {
      super(var1, var2, var3);
   }
}
