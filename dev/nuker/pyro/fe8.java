/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public class fe8 {
   // $FF: renamed from: c long
   public long field_1295 = -1L;

   // $FF: renamed from: 0 () long
   public long method_1977() {
      return this.field_1295;
   }

   // $FF: renamed from: c (long) void
   public void method_1978(long var1) {
      this.field_1295 = var1;
   }

   // $FF: renamed from: c () void
   public void method_1979() {
      this.field_1295 = System.currentTimeMillis();
   }

   // $FF: renamed from: c (double) boolean
   public boolean method_1980(double var1) {
      return (double)(System.currentTimeMillis() - this.field_1295) >= var1;
   }
}
