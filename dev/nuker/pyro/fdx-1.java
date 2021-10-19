/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class fdx extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.fdx
   public static fdx field_65 = new fdx();

   // $FF: renamed from: c (net.minecraft.item.ItemStack) boolean
   public boolean method_101(@NotNull ItemStack var1) {
      return var1.isEmpty();
   }

   public Object invoke(Object var1) {
      return this.method_101((ItemStack)var1);
   }

   public fdx() {
      super(1);
   }
}
