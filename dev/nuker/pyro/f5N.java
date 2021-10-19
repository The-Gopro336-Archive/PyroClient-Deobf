/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Predicate;
import kotlin.TypeCastException;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class f5N implements Predicate {
   // $FF: renamed from: c dev.nuker.pyro.f5k
   public f5k field_2192;

   public boolean test(Object var1) {
      return this.method_3269((PotionEffect)var1);
   }

   // $FF: renamed from: c (net.minecraft.potion.PotionEffect) boolean
   public boolean method_3269(PotionEffect var1) {
      Potion var10000 = var1.getPotion();
      f5q var10001 = this.field_2192.field_1005;
      if (var10001 == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.gui.hud.items.PotionEffectElement");
      } else {
         return var10000 == ((f5M)var10001).method_1548().getPotion();
      }
   }

   public f5N(f5k var1) {
      this.field_2192 = var1;
      super();
   }
}
