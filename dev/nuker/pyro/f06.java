/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.util.Timer;
import org.jetbrains.annotations.NotNull;

public class f06 {
   // $FF: renamed from: c net.minecraft.util.Timer
   @NotNull
   public Timer field_2307;

   // $FF: renamed from: c () void
   public void method_3471() {
      throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
   }

   // $FF: renamed from: 0 () net.minecraft.util.Timer
   @NotNull
   public Timer method_3472() {
      return this.field_2307;
   }

   // $FF: renamed from: c (net.minecraft.util.Timer) void
   public void method_3473(@NotNull Timer var1) {
      this.field_2307 = var1;
   }

   public f06(float var1) {
      this.field_2307 = new Timer(var1);
   }
}
