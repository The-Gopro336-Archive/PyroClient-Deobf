/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

public enum f0B {
   // $FF: renamed from: c dev.nuker.pyro.f0B
   field_2317,
   // $FF: renamed from: 0 dev.nuker.pyro.f0B
   field_2318,
   // $FF: renamed from: 1 dev.nuker.pyro.f0B
   field_2319,
   // $FF: renamed from: 2 dev.nuker.pyro.f0B
   field_2320;

   // $FF: renamed from: c dev.nuker.pyro.f0B[]
   public static f0B[] field_2321 = new f0B[]{field_2317 = new f0B("TOP_LEFT", 0, -1, -1), field_2318 = new f0B("TOP_RIGHT", 1, 1, -1), field_2319 = new f0B("BOTTOM_LEFT", 2, -1, 1), field_2320 = new f0B("BOTTOM_RIGHT", 3, 1, 1)};
   // $FF: renamed from: c int
   public int field_2322;
   // $FF: renamed from: 0 int
   public int field_2323;
   // $FF: renamed from: c dev.nuker.pyro.f0A
   public static f0A field_2324 = new f0A((DefaultConstructorMarker)null);

   // $FF: renamed from: 0 (double, int) double
   public double method_3480(double var1, int var3) {
      switch(this.field_2323) {
      case -1:
         return var1;
      case 0:
      default:
         return 0.0D;
      case 1:
         return (double)var3 - var1;
      }
   }

   // $FF: renamed from: 1 () int
   public int method_3481() {
      return this.field_2323;
   }

   // $FF: renamed from: 0 () int
   public int method_3482() {
      return this.field_2322;
   }

   public f0B(int var3, int var4) {
      this.field_2322 = var3;
      this.field_2323 = var4;
   }

   // $FF: renamed from: c (double, int) double
   public double method_3483(double var1, int var3) {
      switch(this.field_2322) {
      case -1:
         return var1;
      case 0:
      default:
         return 0.0D;
      case 1:
         return (double)var3 - var1;
      }
   }

   // $FF: renamed from: c () dev.nuker.pyro.f0G
   @Nullable
   public f0G method_3484() {
      switch(this.field_2322) {
      case -1:
         return f0G.field_2325;
      case 0:
      default:
         return null;
      case 1:
         return f0G.field_2326;
      }
   }

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.f0B
   public static f0B method_3485(String var0) {
      return (f0B)Enum.valueOf(f0B.class, var0);
   }
}
