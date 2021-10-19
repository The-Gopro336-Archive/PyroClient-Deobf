/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class fdD extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.fdD
   public static fdD field_74 = new fdD();

   public fdD() {
      super(1);
   }

   public Object invoke(Object var1) {
      return this.method_109((ItemStack)var1);
   }

   // $FF: renamed from: c (net.minecraft.item.ItemStack) boolean
   public boolean method_109(@NotNull ItemStack var1) {
      return !var1.isEmpty();
   }
}
