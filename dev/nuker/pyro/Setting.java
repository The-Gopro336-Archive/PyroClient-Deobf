/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Setting extends f0w {
   // $FF: renamed from: c java.lang.String
   @NotNull
   public String field_2216;

   // $FF: renamed from: c () java.lang.String
   @NotNull
   public String method_3323() {
      return this.field_2216;
   }

   public Setting(@NotNull String var1, @NotNull String var2, Object var3) {
      this(var1, var2, (String)null, var3);
   }

   // $FF: renamed from: c (java.lang.String) void
   public void method_3324(@NotNull String var1) {
      this.field_2216 = var1;
   }

   public Setting(@NotNull String var1, @NotNull String var2, @Nullable String var3, Object var4) {
      super(var1, var3, var4);
      this.field_2216 = var2;
   }
}
