/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import org.lwjgl.input.Keyboard;

public class f5f extends f4Q {
   // $FF: renamed from: 1 boolean
   public boolean field_1140 = false;
   // $FF: renamed from: 1 java.lang.String
   public String field_1141 = "";

   // $FF: renamed from: c (char, int) void
   public void method_1632(char var1, int var2) {
      super.method_1632(var1, var2);
      if (this.field_1140) {
         switch(var2) {
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
         case 9:
         case 10:
         case 11:
            this.field_1141 = this.field_1141 + Keyboard.getKeyName(var2);
            break;
         case 12:
            this.field_1141 = this.field_1141.contains("-") ? this.field_1141.replace("-", "") : "-" + this.field_1141;
            break;
         case 14:
            if (this.field_1141 != null && this.field_1141.length() > 0) {
               this.field_1141 = this.field_1141.substring(0, this.field_1141.length() - 1);
            }
            break;
         case 52:
         case 83:
            this.field_1141 = this.field_1141.contains(".") ? this.field_1141.replace(".", "") : this.field_1141 + ".";
            break;
         default:
            return;
         }

      }
   }

   // $FF: renamed from: c (float, float, float) boolean
   public boolean method_1639(float var1, float var2, float var3) {
      PyroRenderUtil.meth0(this.2(), this.7(), this.2() + this.c(), this.7() + this.meth4(), -1);
      if (!this.field_1141.isEmpty()) {
         float var4 = PyroRenderUtil.method_1439(this.field_1141);
         PyroRenderUtil.method_1444(this.field_1141, this.2() + this.c() - var4, this.7() + 2.0F, 0);
      }

      return super.method_1639(var1, var2, var3);
   }

   // $FF: renamed from: c () java.lang.String
   public String method_1678() {
      return this.field_1141;
   }

   // $FF: renamed from: 0 (java.lang.String) void
   public void method_1624(String var1) {
      super.method_1624(var1);
      this.field_1141 = var1;
   }

   public f5f(String var1, float var2, float var3, float var4, float var5) {
      super(var1, var2, var3, var4, var5);
   }

   // $FF: renamed from: 0 (int, int, int) void
   public void method_1622(int var1, int var2, int var3) {
      super.method_1622(var1, var2, var3);
      this.field_1140 = true;
   }
}
