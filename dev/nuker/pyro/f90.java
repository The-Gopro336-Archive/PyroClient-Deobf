/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.awt.Color;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

public class f90 extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.f90
   public static f90 field_43 = new f90();

   // $FF: renamed from: c (java.awt.Color) dev.nuker.pyro.f00
   @NotNull
   public f00 method_86(Color var1) {
      return f00.field_2296.method_3693(var1);
   }

   public f90() {
      super(1);
   }

   public Object invoke(Object var1) {
      return this.method_86((Color)var1);
   }
}
