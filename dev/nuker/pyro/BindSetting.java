/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import net.minecraft.client.gui.inventory.GuiInventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class BindSetting extends Setting {
   // $FF: renamed from: 2 () dev.nuker.pyro.f13
   @NotNull
   public f13 method_3309() {
      return (f13)(new f0S(this));
   }

   // $FF: renamed from: 0 () com.google.gson.JsonElement
   @NotNull
   public JsonElement method_3316() {
      return (JsonElement)(new JsonPrimitive((Number)this.getValue().method_3034()));
   }

   public BindSetting(@NotNull String var1, @NotNull String var2, @Nullable String var3, int var4) {
      super(var1, var2, var3, var4);
   }

   // $FF: renamed from: c (com.google.gson.JsonElement) void
   public void method_3310(@NotNull JsonElement var1) {
      this.getValue().method_3033(var1.getAsInt());
   }

   // $FF: renamed from: c () boolean
   public boolean method_3330() {
      if (fdZ.field_976.currentScreen != null) {
         boolean var1 = (Boolean)PyroStatic.field_2496.c.method_3034() && (Boolean)PyroStatic.field_2496.field_285.c();
         if (!(fdZ.field_976.currentScreen instanceof GuiInventory)) {
            return false;
         }

         if (!var1) {
            return false;
         }
      }

      if (((Number)this.c()).intValue() != -1 && ((Number)this.c()).intValue() != 0) {
         return ((Number)this.c()).intValue() > 0 ? Keyboard.isKeyDown(((Number)this.c()).intValue()) : Mouse.isButtonDown(-((Number)this.c()).intValue());
      } else {
         return false;
      }
   }
}
