/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.util.math.Vec3d;

public class fbf {
   // $FF: renamed from: c java.lang.String
   public String field_1648;
   // $FF: renamed from: c net.minecraft.util.math.Vec3d
   public Vec3d field_1649;
   // $FF: renamed from: c boolean
   public boolean field_1650;
   // $FF: renamed from: c int
   public int field_1651;
   // $FF: renamed from: c dev.nuker.pyro.fe8
   public fe8 field_1652;
   // $FF: renamed from: c double
   public double field_1653;
   // $FF: renamed from: c dev.nuker.pyro.fbg
   public fbg field_1654;
   // $FF: renamed from: c dev.nuker.pyro.fbh
   public fbh field_1655;

   // $FF: renamed from: 1 () int
   public int method_2832() {
      return this.field_1651;
   }

   // $FF: renamed from: 4 () net.minecraft.util.math.Vec3d
   public Vec3d method_2833() {
      return this.field_1649;
   }

   // $FF: renamed from: 2 () void
   public void method_2834() {
      this.field_1649 = this.field_1649.addVector(0.0D, this.field_1653, 0.0D);
      if (this.field_1652.method_1980(1000.0D)) {
         this.field_1650 = true;
      }

   }

   // $FF: renamed from: 0 () dev.nuker.pyro.fbg
   public fbg method_2835() {
      return this.field_1654;
   }

   // $FF: renamed from: c () java.lang.String
   public String method_2836() {
      return this.field_1648;
   }

   // $FF: renamed from: 3 () boolean
   public boolean method_2837() {
      return this.field_1650;
   }

   public fbf(fbh var1, String var2, Vec3d var3, int var4, fbg var5) {
      this.field_1655 = var1;
      super();
      this.field_1652 = new fe8();
      this.field_1653 = 0.0D;
      this.field_1648 = var2;
      this.field_1649 = var3;
      this.field_1651 = var4;
      this.field_1652.method_1979();
      this.field_1653 = Math.random();

      for(this.field_1654 = var5; this.field_1653 > 0.025D || this.field_1653 < 0.011D; this.field_1653 = Math.random()) {
      }

   }
}
