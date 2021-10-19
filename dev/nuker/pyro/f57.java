/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class f57 extends f58 {
   // $FF: renamed from: 1 boolean
   public boolean field_1116 = false;

   // $FF: renamed from: 0 (int, int, int) void
   public void method_1622(int var1, int var2, int var3) {
      super.0(var1, var2, var3);
      if (var3 == 0) {
         this.field_1116 = !this.field_1116;
      }

      if (this.field_1116) {
         switch(var3) {
         case 0:
         case 1:
            break;
         default:
            BindSetting var4 = (BindSetting)this.c;
            var4.c(-var3);
            this.field_1116 = false;
         }
      }

   }

   // $FF: renamed from: 8 () java.lang.String
   public String method_1630() {
      if (this.field_1116) {
         return "Listening";
      } else {
         BindSetting var1 = (BindSetting)this.c;
         return (Integer)var1.c() != 0 && (Integer)var1.c() != -1 ? var1.c() + ": " + ((Integer)var1.c() > 0 ? Keyboard.getKeyName((Integer)var1.c()) : Mouse.getButtonName(-(Integer)var1.c())) : var1.c() + ": NONE";
      }
   }

   // $FF: renamed from: c (float, float, float) boolean
   public boolean method_1639(float var1, float var2, float var3) {
      if (this.field_1116) {
         PyroRenderUtil.meth0(this.2() + 3.0F, this.7() - 2.0F, -this.2() + this.c() - 2.0F, this.7() + this.meth4() - 3.0F, f0H.field_2338.method_3505());
      }

      PyroRenderUtil.meth1(this.method_1630(), this.2() + 5.0F, this.7(), f0H.field_2338.method_3494());
      return false;
   }

   // $FF: renamed from: c (char, int) void
   public void method_1632(char var1, int var2) {
      super.c(var1, var2);
      if (this.field_1116) {
         this.field_1116 = false;
         BindSetting var3 = (BindSetting)this.c;
         if (Keyboard.getKeyName(var2).equals("BACK")) {
            var3.c(-1);
         } else {
            var3.c(var2);
         }
      }

   }

   public f57(f0w var1, float var2, float var3) {
      super(var1, var2, var3);
   }
}
