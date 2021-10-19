/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public class f09 extends f06 {
   // $FF: renamed from: c java.lang.Runnable
   public Runnable field_2308;
   // $FF: renamed from: c float
   public float field_2309;

   public f09(Runnable var1, float var2, float var3) {
      this.field_2308 = var1;
      this.field_2309 = var2;
      super(var3);
   }

   // $FF: renamed from: c () void
   public void method_3471() {
      this.field_2308.run();
   }
}
