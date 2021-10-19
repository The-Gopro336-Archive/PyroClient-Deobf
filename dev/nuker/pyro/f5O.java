/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.potion.PotionEffect;
import org.jetbrains.annotations.NotNull;

public class f5O extends f5o {
   public f5O(int var1) {
      super("", var1);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f43) void
   @f0g
   @LauncherEventHide
   public void method_1594(@NotNull f43 var1) {
      if (var1.c() == f41.field_2120 && fdZ.field_976.world != null && fdZ.field_976.player != null) {
         Collection var2 = fdZ.field_976.player.getActivePotionEffects();
         Iterator var4 = this.c.field_1084.iterator();

         while(var4.hasNext()) {
            f5k var3 = (f5k)var4.next();
            if (!var2.stream().anyMatch((Predicate)(new f5N(var3)))) {
               var3.method_1513();
            }
         }

         var4 = var2.iterator();

         while(var4.hasNext()) {
            PotionEffect var8 = (PotionEffect)var4.next();
            boolean var5 = false;
            Iterator var7 = this.c.field_1084.iterator();

            while(var7.hasNext()) {
               f5k var6 = (f5k)var7.next();
               f5q var10000 = var6.field_1005;
               if (var10000 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.gui.hud.items.PotionEffectElement");
               }

               if (((f5M)var10000).method_1548().getPotion() == var8.getPotion()) {
                  var10000 = var6.field_1005;
                  if (var10000 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.gui.hud.items.PotionEffectElement");
                  }

                  ((f5M)var10000).method_1549(var8);
                  boolean var9 = var6.field_1010;
                  var5 = true;
                  break;
               }
            }

            if (!var5) {
               this.c.method_1606(new f5k("potion", "General", (f5q)(new f5M(var8)), (f5l)null, false, 24, (DefaultConstructorMarker)null));
            }
         }

      }
   }
}
