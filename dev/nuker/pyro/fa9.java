/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

public class fa9 extends Lambda implements Function0 {
   // $FF: renamed from: c dev.nuker.pyro.faa
   public faa field_61;

   public fa9(faa var1) {
      this.field_61 = var1;
      super(0);
   }

   // $FF: renamed from: c () double
   public double method_97() {
      double var1 = ((Number)this.field_61.method_2780().c()).doubleValue();
      float var3 = fec.method_1764();
      double var4 = var1 - (double)var3;
      double var8 = (double)var3 + ((Number)this.field_61.method_2769().c()).doubleValue();
      boolean var10 = false;
      double var6 = Math.min(var1, var8);
      String var11 = var1 + " - " + var3 + " : " + ((double)var3 + ((Number)this.field_61.method_2769().c()).doubleValue()) + " : " + var4 + " - " + var6;
      boolean var9 = false;
      System.out.println(var11);
      return var6;
   }

   public Object invoke() {
      return this.method_97();
   }
}
