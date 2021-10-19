/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

// $FF: renamed from: dev.nuker.pyro.fJ
public class class_29 implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.Module
   public Module field_2287;
   // $FF: renamed from: c kotlin.jvm.internal.Ref$BooleanRef
   public Ref.BooleanRef field_2288;
   // $FF: renamed from: c dev.nuker.pyro.f0w
   public f0w field_2289;

   public class_29(Module var1, Ref.BooleanRef var2, f0w var3) {
      this.field_2287 = var1;
      this.field_2288 = var2;
      this.field_2289 = var3;
      super();
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0w) void
   public void method_3425(@NotNull f0w var1) {
      class_37.field_2633.method_3978(this.field_2287);
   }

   public void accept(Object var1) {
      this.method_3425((f0w)var1);
   }
}
