/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

public class f8C extends Lambda implements Function1 {
   // $FF: renamed from: c kotlin.jvm.internal.Ref$ObjectRef
   public Ref.ObjectRef field_45;

   public Object invoke(Object var1) {
      this.method_88((String)var1);
      return Unit.INSTANCE;
   }

   // $FF: renamed from: c (java.lang.String) void
   public void method_88(@NotNull String var1) {
      ((ArrayList)this.field_45.element).add(var1);
   }

   public f8C(Ref.ObjectRef var1) {
      this.field_45 = var1;
      super(1);
   }
}
