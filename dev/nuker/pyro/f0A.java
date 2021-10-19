/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

public class f0A {
   public f0A(DefaultConstructorMarker var1) {
      this();
   }

   // $FF: renamed from: c (int, int) dev.nuker.pyro.f0B
   @Nullable
   public f0B method_3479(int var1, int var2) {
      f0B[] var5 = f0B.values();
      int var6 = var5.length;

      for(int var4 = 0; var4 < var6; ++var4) {
         f0B var3 = var5[var4];
         if (var3.method_3482() == var1 && var3.method_3481() == var2) {
            return var3;
         }
      }

      return null;
   }

   public f0A() {
   }
}
