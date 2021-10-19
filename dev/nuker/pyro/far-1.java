/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.math.BigDecimal;
import java.math.RoundingMode;
import net.minecraft.init.MobEffects;

public class far extends fdZ {
   // $FF: renamed from: 1 () double
   public static double method_1680() {
      double var0 = 0.2873D;
      if (c.player == null) {
         return var0;
      } else {
         if (c.player.isPotionActive(MobEffects.SPEED)) {
            int var2 = c.player.getActivePotionEffect(MobEffects.SPEED).getAmplifier();
            var0 *= 1.0D + 0.2D * (double)(var2 + 1);
         }

         return var0;
      }
   }

   public void meth0() {
      throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   public void method_1681(f4p var1) {
      throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
   }

   // $FF: renamed from: c () void
   public void method_1682() {
      throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
   }

   // $FF: renamed from: c (double, int) double
   public static double method_1683(double var0, int var2) {
      if (var2 < 0) {
         throw new IllegalArgumentException();
      } else {
         BigDecimal var3 = new BigDecimal(var0);
         var3 = var3.setScale(var2, RoundingMode.HALF_UP);
         return var3.doubleValue();
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   public void method_1684(f4u var1) {
      throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
   }
}
