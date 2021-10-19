/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class f4V extends f4Q {
   // $FF: renamed from: c dev.nuker.pyro.Module
   public Module field_1105;
   // $FF: renamed from: 1 boolean
   public boolean field_1106 = false;

   // $FF: renamed from: c (char, int) void
   public void method_1632(char var1, int var2) {
      super.method_1632(var1, var2);
      if (this.field_1106) {
         this.field_1106 = false;
         if (Keyboard.getKeyName(var2).equals("BACK")) {
            this.field_1105.method_115(-1);
         } else {
            this.field_1105.method_115(var2);
         }
      }

   }

   // $FF: renamed from: c (float, float, float) boolean
   public boolean method_1639(float var1, float var2, float var3) {
      if (this.field_1106) {
         PyroRenderUtil.meth0(this.2() + 3.0F, this.7() - 2.0F, -this.2() + this.c() - 2.0F, this.7() + this.meth4() - 3.0F, f0H.field_2338.method_3505());
      }

      PyroRenderUtil.meth1(this.method_1630(), this.2() + 5.0F, this.7(), f0H.field_2338.method_3494());
      return super.method_1639(var1, var2, var3);
   }

   // $FF: renamed from: 0 (int, int, int) void
   public void method_1622(int var1, int var2, int var3) {
      super.method_1622(var1, var2, var3);
      if (var3 == 0) {
         this.field_1106 = !this.field_1106;
      }

      if (this.field_1106) {
         switch(var3) {
         case 0:
         case 1:
            break;
         default:
            this.field_1105.method_115(-var3);
            this.field_1106 = false;
         }
      }

   }

   public f4V(Module var1) {
      super("Keybind", 0.0F, 0.0F, 115.0F, PyroRenderUtil.meth1() + 2.0F);
      this.field_1105 = var1;
   }

   // $FF: renamed from: 8 () java.lang.String
   public String method_1630() {
      if (this.field_1106) {
         return "Listening";
      } else {
         return this.field_1105.method_133() != 0 && this.field_1105.method_133() != -1 ? "Key: " + (this.field_1105.method_133() > 0 ? Keyboard.getKeyName(this.field_1105.method_133()) : Mouse.getButtonName(-this.field_1105.method_133())) : "Key: NONE";
      }
   }
}
