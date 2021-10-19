/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public class f98 extends class_6 {
   // $FF: renamed from: c java.lang.Object
   public Object field_1873;
   // $FF: renamed from: 0 java.lang.Object
   public Object field_1874;
   // $FF: renamed from: c baritone.api.Settings.Setting
   public baritone.api.Settings.Setting field_1875;
   // $FF: renamed from: c kotlin.jvm.functions.Function1
   public Function1 field_1876;
   // $FF: renamed from: 0 kotlin.jvm.functions.Function1
   public Function1 field_1877;

   // $FF: renamed from: c () void
   public void method_3035() {
      this.method_3033(this.field_1873);
   }

   // $FF: renamed from: 0 () java.lang.Object
   public Object method_3034() {
      if (Intrinsics.areEqual(this.field_1874, this.field_1875.value) ^ true) {
         this.field_1873 = this.field_1877.invoke(this.field_1875.value);
         this.field_1874 = this.field_1875.value;
      }

      return this.field_1873;
   }

   // $FF: renamed from: 1 (java.lang.Object) void
   public void method_3036(Object var1) {
      this.field_1874 = var1;
   }

   // $FF: renamed from: c (java.lang.Object) void
   public void method_3033(Object var1) {
      this.field_1875.value = this.field_1876.invoke(var1);
   }

   // $FF: renamed from: 0 (java.lang.Object) void
   public void method_3037(Object var1) {
      this.field_1873 = var1;
   }

   // $FF: renamed from: 1 () java.lang.Object
   public Object method_3038() {
      return this.field_1873;
   }

   public f98(baritone.api.Settings.Setting var1, Function1 var2, Function1 var3) {
      this.field_1875 = var1;
      this.field_1876 = var2;
      this.field_1877 = var3;
      super();
      this.field_1873 = var3.invoke(var1.value);
      this.field_1874 = var1.value;
   }

   // $FF: renamed from: c () java.lang.Object
   public Object method_3039() {
      return this.field_1874;
   }
}
