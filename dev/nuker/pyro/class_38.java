/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.gui.ClickGui$Window;
import java.util.Iterator;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

// $FF: renamed from: dev.nuker.pyro.fW
public class class_38 implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.fX
   public class_39 field_2635;

   public void accept(Object var1) {
      this.method_3984((ClickGui$Window)var1);
   }

   public class_38(class_39 var1) {
      this.field_2635 = var1;
      super();
   }

   // $FF: renamed from: c (dev.nuker.pyro.gui.ClickGui$Window) void
   public void method_3984(@Nullable ClickGui$Window var1) {
      Module var2;
      for(Iterator var3 = this.field_2635.method_3989().iterator(); var3.hasNext(); var2.method_124(var1)) {
         var2 = (Module)var3.next();
         if (var1 == null) {
            Intrinsics.throwNpe();
         }
      }

   }
}
