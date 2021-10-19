/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.concurrent.TimeUnit;

public class fe7 {
   // $FF: renamed from: c long
   public long field_1249;

   // $FF: renamed from: c () void
   public void method_1949() {
      this.field_1249 = System.nanoTime();
   }

   // $FF: renamed from: c (java.util.concurrent.TimeUnit) long
   public long method_1950(TimeUnit var1) {
      return var1.convert(System.nanoTime() - this.field_1249, TimeUnit.NANOSECONDS);
   }

   // $FF: renamed from: 0 () long
   public long method_1951() {
      return this.field_1249;
   }

   // $FF: renamed from: 1 () long
   public long method_1952() {
      return this.method_1950(TimeUnit.MILLISECONDS);
   }

   // $FF: renamed from: c (long) boolean
   public boolean method_1953(long var1) {
      return this.method_1954(var1, TimeUnit.MILLISECONDS);
   }

   // $FF: renamed from: c (long, java.util.concurrent.TimeUnit) boolean
   public boolean method_1954(long var1, TimeUnit var3) {
      long var4;
      if ((var4 = var3.convert(System.nanoTime() - this.field_1249, TimeUnit.NANOSECONDS)) >= var1) {
         this.method_1949();
      }

      return var4 >= var1;
   }
}
