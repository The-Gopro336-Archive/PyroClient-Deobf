/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Predicate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityWolf;
import org.jetbrains.annotations.Nullable;

public class faX implements Predicate {
   // $FF: renamed from: c dev.nuker.pyro.faX
   public static faX field_1481 = new faX();

   // $FF: renamed from: c (net.minecraft.entity.Entity) boolean
   public boolean method_2655(@Nullable Entity var1) {
      return var1 instanceof EntityWolf || var1 instanceof AbstractHorse;
   }

   public boolean test(Object var1) {
      return this.method_2655((Entity)var1);
   }
}
