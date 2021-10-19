/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum f5t {
   // $FF: renamed from: c dev.nuker.pyro.f5t
   field_1709(1, 1),
   // $FF: renamed from: 0 dev.nuker.pyro.f5t
   field_1710(1, -1),
   // $FF: renamed from: 1 dev.nuker.pyro.f5t
   field_1711(-1, 1),
   // $FF: renamed from: 2 dev.nuker.pyro.f5t
   field_1712(-1, -1),
   // $FF: renamed from: 3 dev.nuker.pyro.f5t
   field_1713(0, -1),
   // $FF: renamed from: 4 dev.nuker.pyro.f5t
   field_1714(0, 1),
   // $FF: renamed from: 5 dev.nuker.pyro.f5t
   field_1715(-1, 0),
   // $FF: renamed from: 6 dev.nuker.pyro.f5t
   field_1716(1, 0);

   // $FF: renamed from: c int
   public int field_1717;
   // $FF: renamed from: 0 int
   public int field_1718;
   // $FF: renamed from: c dev.nuker.pyro.f5t[]
   public static f5t[] field_1719 = new f5t[]{field_1709, field_1710, field_1711, field_1712, field_1713, field_1714, field_1715, field_1716};

   // $FF: renamed from: c (float, float, float, float, int, int, int) dev.nuker.pyro.f5t
   public static f5t method_2962(float var0, float var1, float var2, float var3, int var4, int var5, int var6) {
      int var7 = var0 < (float)var6 ? -1 : (var0 + var2 > (float)(var4 - var6) ? 1 : 0);
      int var8 = var1 < (float)var6 ? -1 : (var1 + var3 > (float)(var5 - var6) ? 1 : 0);
      f5t[] var9 = values();
      int var10 = var9.length;

      for(int var11 = 0; var11 < var10; ++var11) {
         f5t var12 = var9[var11];
         if (var12.field_1717 == var7 && var12.field_1718 == var8) {
            return var12;
         }
      }

      return null;
   }

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.f5t
   public static f5t method_2963(String var0) {
      return (f5t)Enum.valueOf(f5t.class, var0);
   }

   // $FF: renamed from: 0 (float, float, float) float
   public float method_2964(float var1, float var2, float var3) {
      return this.field_1717 == 0 ? var1 : (this.field_1717 == -1 ? 0.0F : var3 - var2);
   }

   public f5t(int var3, int var4) {
      this.field_1717 = var3;
      this.field_1718 = var4;
   }

   // $FF: renamed from: c (float, float, float) float
   public float method_2965(float var1, float var2, float var3) {
      return this.field_1718 == 0 ? var1 : (this.field_1718 == -1 ? 0.0F : var3 - var2);
   }

   // $FF: renamed from: c (int) dev.nuker.pyro.f5t
   public static f5t method_2966(int var0) {
      switch(var0) {
      case 0:
         return field_1710;
      case 1:
      default:
         return field_1709;
      case 2:
         return field_1711;
      case 3:
         return field_1712;
      }
   }
}
