/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Predicate;
import kotlin.TypeCastException;
import net.minecraft.entity.player.EntityPlayer;

public class f5W implements Predicate {
   // $FF: renamed from: c dev.nuker.pyro.f5k
   public f5k field_2202;

   // $FF: renamed from: c (net.minecraft.entity.player.EntityPlayer) boolean
   public boolean method_3283(EntityPlayer var1) {
      int var10000 = var1.getEntityId();
      f5q var10001 = this.field_2202.field_1005;
      if (var10001 == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.gui.hud.items.TextRadarPlayer");
      } else {
         return var10000 == ((f5Y)var10001).method_1569();
      }
   }

   public f5W(f5k var1) {
      this.field_2202 = var1;
      super();
   }

   public boolean test(Object var1) {
      return this.method_3283((EntityPlayer)var1);
   }
}
