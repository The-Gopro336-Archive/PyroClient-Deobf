/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;

public class f02 {
   // $FF: renamed from: c float
   public float field_2297 = -1337.0F;
   // $FF: renamed from: 0 float
   public float field_2298 = -1337.0F;
   // $FF: renamed from: 1 float
   public float field_2299 = -1337.0F;
   // $FF: renamed from: 2 float
   public float field_2300 = -1337.0F;
   // $FF: renamed from: c dev.nuker.pyro.fe8
   public fe8 field_2301 = new fe8();

   // $FF: renamed from: c (float) void
   public void method_3454(float var1) {
      this.field_2298 = var1;
   }

   // $FF: renamed from: 2 () float
   public float method_3455() {
      return this.field_2298;
   }

   // $FF: renamed from: 1 (float) void
   public void method_3456(float var1) {
      this.field_2300 = var1;
      this.field_2301.method_1979();
   }

   // $FF: renamed from: 0 (float) void
   public void method_3457(float var1) {
      this.field_2297 = var1;
   }

   // $FF: renamed from: c () float
   public float method_3458() {
      return this.field_2297;
   }

   // $FF: renamed from: 3 () float
   public float method_3459() {
      return this.field_2300;
   }

   // $FF: renamed from: 2 (float) void
   public void method_3460(float var1) {
      this.field_2299 = var1;
      this.field_2301.method_1979();
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_3461(f4t var1) {
      if (this.field_2301.method_1980(100.0D)) {
         this.field_2301.method_1979();
         this.field_2297 = -1337.0F;
         this.field_2298 = -1337.0F;
         this.field_2299 = -1337.0F;
         this.field_2300 = -1337.0F;
      }

   }

   // $FF: renamed from: 0 () float
   public float method_3462() {
      return this.field_2299;
   }

   // $FF: renamed from: 1 () void
   public void method_3463() {
      Pyro.getEventManager().method_31(this);
   }
}
