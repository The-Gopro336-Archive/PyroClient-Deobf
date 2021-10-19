/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.lang.reflect.Method;
import org.jetbrains.annotations.NotNull;

public class f0j extends f0i {
   // $FF: renamed from: c java.lang.Class
   @NotNull
   public Class field_2424;
   // $FF: renamed from: c java.lang.Object
   public Object field_2425;
   // $FF: renamed from: c java.lang.reflect.Method
   @NotNull
   public Method field_2426;

   // $FF: renamed from: c () java.lang.reflect.Method
   @NotNull
   public Method method_3681() {
      return this.field_2426;
   }

   public f0j(@NotNull Object var1, @NotNull Method var2) {
      this.field_2425 = var1;
      this.field_2426 = var2;
      this.field_2424 = this.field_2426.getParameterTypes()[0];
   }

   // $FF: renamed from: 0 () java.lang.Class
   @NotNull
   public Class method_3680() {
      return this.field_2424;
   }

   public void accept(@NotNull Object var1) {
      this.field_2426.invoke(this.field_2425, var1);
   }
}
