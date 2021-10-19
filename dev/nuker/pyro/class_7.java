/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;

// $FF: renamed from: dev.nuker.pyro.fz
public class class_7 extends class_6 {
   // $FF: renamed from: c java.lang.Object
   public Object field_1871;
   // $FF: renamed from: c java.util.function.Consumer
   public Consumer field_1872;

   // $FF: renamed from: 0 () java.lang.Object
   public Object method_3034() {
      return this.field_1871;
   }

   public class_7(Object var1) {
      this(var1, (Consumer)null);
   }

   // $FF: renamed from: c (java.lang.Object) void
   public void method_3033(Object var1) {
      if (var1 != this.field_1871) {
         this.field_1871 = var1;
         this.method_3035();
      }

   }

   public class_7(Object var1, Consumer var2) {
      this.field_1871 = var1;
      this.field_1872 = var2;
   }

   // $FF: renamed from: c () void
   public void method_3035() {
      if (this.field_1872 != null) {
         this.field_1872.accept(this.field_1871);
      }

   }
}
