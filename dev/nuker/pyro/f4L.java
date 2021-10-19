/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.suggestion.Suggestions;
import java.util.function.BiConsumer;
import org.jetbrains.annotations.Nullable;

public class f4L implements BiConsumer {
   // $FF: renamed from: c dev.nuker.pyro.f4N
   public f4N field_2148;

   public void accept(Object var1, Object var2) {
      this.method_3221((Suggestions)var1, (Throwable)var2);
   }

   // $FF: renamed from: c (com.mojang.brigadier.suggestion.Suggestions, java.lang.Throwable) void
   public void method_3221(@Nullable Suggestions var1, @Nullable Throwable var2) {
      this.field_2148.method_3226(var1);
   }

   public f4L(f4N var1) {
      this.field_2148 = var1;
      super();
   }
}
